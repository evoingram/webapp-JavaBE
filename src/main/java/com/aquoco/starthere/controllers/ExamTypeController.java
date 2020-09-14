package com.aquoco.starthere.controllers;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.ExamType;
import com.aquoco.starthere.services.ExamTypeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/*
 * examtypes table fields: eid, examination, ecode
 */
@Loggable
@RestController
@RequestMapping("/examtypes")
public class ExamTypeController {
    private static final Logger logger = LoggerFactory.getLogger(ExamTypeController.class);

    @Autowired
    private ExamTypeService examtypeService;

    // GET endpoint all examtypes (admin)
    // http://localhost:2019/examtypes/examtypes/?page=1&size=1
    // http://localhost:2019/examtypes/examtypes/?sort=examination,desc&sort=<field>,asc
    @ApiOperation(value = "returns all exam types",
            response = ExamType.class,
            responseContainer = "List")
    @ApiImplicitParams({@ApiImplicitParam(name = "page",
            dataType = "integer",
            paramType = "query",
            value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size",
                    dataType = "integer",
                    paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort",
                    allowMultiple = true,
                    dataType = "string",
                    paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/examtypes",
            produces = {"application/json"})
    public ResponseEntity<?> listAllExamTypes(HttpServletRequest request,
                                           @PageableDefault(page = 0, size = 5)
                                                   Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<ExamType> myExamTypes = examtypeService.findAll(pageable);
        return new ResponseEntity<>(myExamTypes, HttpStatus.OK);
    }

    // GET endpoint all examtypes (admin)
    // http://localhost:2019/examtypes/examtypes/all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/examtypes/all",
            produces = {"application/json"})
    public ResponseEntity<?> reallyListAllExamTypes(HttpServletRequest request) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<ExamType> myExamTypes = examtypeService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myExamTypes, HttpStatus.OK);
    }


    // GET endpoint one examtype (admin)
    // http://localhost:2019/examtypes/examtype/7
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/examtype/{eid}",
            produces = {"application/json"})
    public ResponseEntity<?> getExamTypeById(HttpServletRequest request,
                                          @PathVariable
                                                  Long eid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        ExamType currentExamType = examtypeService.findExamtypeById(eid);
        return new ResponseEntity<>(currentExamType, HttpStatus.OK);
    }

    // GET endpoint one examtypes by examination (admin)
    // http://localhost:2019/examtypes/examtype/exam/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/examtype/exam/exact/{examination}",
            produces = {"application/json"})
    public ResponseEntity<?> getExamTypeByExamination(HttpServletRequest request,
                                            @PathVariable
                                                    String examination) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        ExamType currentExamType = examtypeService.findByExamination(examination);
        return new ResponseEntity<>(currentExamType, HttpStatus.OK);
    }

    // GET endpoint search partial or full by examination (admin)
    // http://localhost:2019/examtypes/examtype/name/like/da?sort=examination
    @ApiOperation(value = "returns all examtypes with examinations containing a given string",
            response = ExamType.class,
            responseContainer = "List")
    @ApiImplicitParams({@ApiImplicitParam(name = "page",
            dataType = "integer",
            paramType = "query",
            value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size",
                    dataType = "integer",
                    paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort",
                    allowMultiple = true,
                    dataType = "string",
                    paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/examtype/examination/like/{examination}",
            produces = {"application/json"})
    public ResponseEntity<?> getExamTypeLikeExamination(HttpServletRequest request,
                                              @PathVariable String examination,
                                              @PageableDefault(page = 0, size = 5)
                                                      Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<ExamType> currentExamType = examtypeService.findByExaminationContainingIgnoreCase(examination, pageable);
        return new ResponseEntity<>(currentExamType, HttpStatus.OK);
    }

    // GET endpoint one examtype by ecode (admin)
    // http://localhost:2019/examtypes/examtype/ecode/exact/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/examtype/ecode/exact/{ecode}",
            produces = {"application/json"})
    public ResponseEntity<?> getExamTypeByEcode(HttpServletRequest request,
                                            @PathVariable
                                                    String ecode) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        ExamType currentExamType = examtypeService.findByEcode(ecode);
        return new ResponseEntity<>(currentExamType, HttpStatus.OK);
    }

    // GET endpoint search partial or full by ecode (admin)
    // http://localhost:2019/examtypes/examtype/ecode/like/da?sort=ecode
    @ApiOperation(value = "returns all examtypes with ecodes containing a given string",
            response = ExamType.class,
            responseContainer = "List")
    @ApiImplicitParams({@ApiImplicitParam(name = "page",
            dataType = "integer",
            paramType = "query",
            value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size",
                    dataType = "integer",
                    paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort",
                    allowMultiple = true,
                    dataType = "string",
                    paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/examtype/ecode/like/{ecode}",
            produces = {"application/json"})
    public ResponseEntity<?> getExamTypeLikeEcode(HttpServletRequest request,
                                              @PathVariable String ecode,
                                              @PageableDefault(page = 0, size = 5)
                                                      Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<ExamType> currentExamType = examtypeService.findByEcodeContainingIgnoreCase(ecode, pageable);
        return new ResponseEntity<>(currentExamType, HttpStatus.OK);
    }

    // POST endpoint one examtype (admin)
    // http://localhost:2019/examtypes/examtype
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/examtype",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewExamType(HttpServletRequest request,
                                         @Valid
                                         @RequestBody ExamType newExamType) throws
            URISyntaxException {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newExamType = examtypeService.save(newExamType, request.isUserInRole("ADMIN"));

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newExamTypeURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                     .path("/{sid}")
                                                     .buildAndExpand(newExamType.getEid())
                                                     .toUri();
        responseHeaders.setLocation(newExamTypeURI);

        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }

    // PUT endpoint one examtype (admin)
    // http://localhost:2019/examtypes/examtype/7
    @PutMapping(value = "/examtype/{eid}")
    public ResponseEntity<?> updateExamType(HttpServletRequest request,
                                         @RequestBody ExamType updateExamType,
                                         @PathVariable long eid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        examtypeService.update(updateExamType,
                            eid,
                            request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE endpoint one examtype (admin)
    // http://localhost:2019/examtypes/examtype/14
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/examtype/{eid}")
    public ResponseEntity<?> deleteExamTypeById(HttpServletRequest request,
                                             @PathVariable long eid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        examtypeService.delete(eid, request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

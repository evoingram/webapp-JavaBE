package com.aquoco.starthere.controllers;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.BrandingTheme;
import com.aquoco.starthere.models.Case;
import com.aquoco.starthere.services.CaseService;
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
 * cases table fields:  casesid, party1, party1name, party2,
 * party2name, casenumber1, casenumber2, jurisdiction, notes
 */
@Loggable
@RestController
@RequestMapping("/cases")
public class CaseController {
    private static final Logger logger = LoggerFactory.getLogger(CaseController.class);

    @Autowired
    private CaseService caseService;

    // GET endpoint all cases (admin)
    // http://localhost:2019/cases/cases/?page=1&size=1
    // http://localhost:2019/cases/cases/?sort=brandingthemename,desc&sort=<field>,asc
    @ApiOperation(value = "returns all cases",
            response = Case.class,
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
    @GetMapping(value = "/cases",
            produces = {"application/json"})
    public ResponseEntity<?> listAllCases(HttpServletRequest request,
                                                   @PageableDefault(page = 0, size = 5)
                                                           Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Case> myCases = caseService.findAll(pageable);
        return new ResponseEntity<>(myCases,
                                    HttpStatus.OK);
    }

    // GET endpoint all cases (admin)
    // http://localhost:2019/cases/cases/all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/cases/all",
            produces = {"application/json"})
    public ResponseEntity<?> reallyListAllCases(HttpServletRequest request) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Case> myCases = caseService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myCases,
                                    HttpStatus.OK);
    }

    // GET endpoint one case (admin)
    // http://localhost:2019/cases/case/7
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/case/{casesid}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseById(HttpServletRequest request,
                                                  @PathVariable
                                                          Long casesid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Case singleCase = caseService.findCaseById(casesid);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint one case by party1 (admin)
    // http://localhost:2019/cases/case/party1/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/case/party1/exact/{party1}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseByParty1(HttpServletRequest request,
                                             @PathVariable
                                                     String party1) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Case singleCase = caseService.findByParty1(party1);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint one case by party1name (admin)
    // http://localhost:2019/cases/case/party1name/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/case/party1name/exact/{party1name}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseByParty1name(HttpServletRequest request,
                                             @PathVariable
                                                     String party1name) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Case singleCase = caseService.findByParty1name(party1name);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint one case by party2 (admin)
    // http://localhost:2019/cases/case/party2/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/case/party2/exact/{party2}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseByParty2(HttpServletRequest request,
                                             @PathVariable
                                                     String party2) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Case singleCase = caseService.findByParty2(party2);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint one case by party2name (admin)
    // http://localhost:2019/cases/case/party2name/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/case/party2name/exact/{party2name}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseByParty2name(HttpServletRequest request,
                                             @PathVariable
                                                     String party2name) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Case singleCase = caseService.findByParty2name(party2name);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint one case by casenumber1 (admin)
    // http://localhost:2019/cases/case/casenumber1/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/case/casenumber1/exact/{casenumber1}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseByCasenumber1(HttpServletRequest request,
                                             @PathVariable
                                                     String casenumber1) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Case singleCase = caseService.findByCasenumber1(casenumber1);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint one case by casenumber2 (admin)
    // http://localhost:2019/cases/case/casenumber2/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/case/casenumber2/exact/{casenumber2}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseByCasenumber2(HttpServletRequest request,
                                                  @PathVariable
                                                          String casenumber2) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Case singleCase = caseService.findByCasenumber2(casenumber2);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint one case by jurisdiction (admin)
    // http://localhost:2019/cases/case/jurisdiction/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/case/jurisdiction/exact/{jurisdiction}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseByJurisdiction(HttpServletRequest request,
                                                  @PathVariable
                                                          String jurisdiction) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Case singleCase = caseService.findByJurisdiction(jurisdiction);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint search partial or full by party1 (admin)
    // http://localhost:2019/cases/case/party1/like/da?sort=party1
    @ApiOperation(value = "returns all cases with party1s containing a given string",
            response = Case.class,
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
    @GetMapping(value = "/case/party1/like/{party1}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseLikeParty1(HttpServletRequest request,
                                                      @PathVariable String party1,
                                                      @PageableDefault(page = 0, size = 5)
                                                              Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Case> singleCase = caseService.findByParty1ContainingIgnoreCase(party1, pageable);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint search partial or full by party1name (admin)
    // http://localhost:2019/cases/case/party1name/like/da?sort=party1name
    @ApiOperation(value = "returns all cases with party1names containing a given string",
            response = Case.class,
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
    @GetMapping(value = "/case/party1name/like/{party1name}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseLikeParty1name(HttpServletRequest request,
                                               @PathVariable String party1name,
                                               @PageableDefault(page = 0, size = 5)
                                                       Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Case> singleCase = caseService.findByParty1nameContainingIgnoreCase(party1name, pageable);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint search partial or full by party2 (admin)
    // http://localhost:2019/cases/case/party2/like/da?sort=party1
    @ApiOperation(value = "returns all cases with party2s containing a given string",
            response = Case.class,
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
    @GetMapping(value = "/case/party2/like/{party2}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseLikeParty2(HttpServletRequest request,
                                               @PathVariable String party2,
                                               @PageableDefault(page = 0, size = 5)
                                                       Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Case> singleCase = caseService.findByParty2ContainingIgnoreCase(party2, pageable);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint search partial or full by party2name (admin)
    // http://localhost:2019/cases/case/party2name/like/da?sort=party1name
    @ApiOperation(value = "returns all cases with party2names containing a given string",
            response = Case.class,
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
    @GetMapping(value = "/case/party2name/like/{party2name}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseLikeParty2name(HttpServletRequest request,
                                                   @PathVariable String party2name,
                                                   @PageableDefault(page = 0, size = 5)
                                                           Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Case> singleCase = caseService.findByParty2nameContainingIgnoreCase(party2name, pageable);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint search partial or full by casenumber1 (admin)
    // http://localhost:2019/cases/case/casenumber1/like/da?sort=casenumber1
    @ApiOperation(value = "returns all cases with casenumber1s containing a given string",
            response = Case.class,
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
    @GetMapping(value = "/case/casenumber1/like/{casenumber1}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseLikeCasenumber1(HttpServletRequest request,
                                                   @PathVariable String casenumber1,
                                                   @PageableDefault(page = 0, size = 5)
                                                           Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Case> singleCase = caseService.findByCasenumber1ContainingIgnoreCase(casenumber1, pageable);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint search partial or full by casenumber2 (admin)
    // http://localhost:2019/cases/case/casenumber2/like/da?sort=casenumber2
    @ApiOperation(value = "returns all cases with casenumber2s containing a given string",
            response = Case.class,
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
    @GetMapping(value = "/case/casenumber2/like/{casenumber2}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseLikeCasenumber2(HttpServletRequest request,
                                                    @PathVariable String casenumber2,
                                                    @PageableDefault(page = 0, size = 5)
                                                            Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Case> singleCase = caseService.findByCasenumber1ContainingIgnoreCase(casenumber2, pageable);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint search partial or full by jurisdiction (admin)
    // http://localhost:2019/cases/case/jurisdiction/like/da?sort=jurisdiction
    @ApiOperation(value = "returns all cases with jurisdictions containing a given string",
            response = Case.class,
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
    @GetMapping(value = "/case/jurisdiction/like/{jurisdiction}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseLikeJurisdiction(HttpServletRequest request,
                                                    @PathVariable String jurisdiction,
                                                    @PageableDefault(page = 0, size = 5)
                                                            Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Case> singleCase = caseService.findByJurisdictionContainingIgnoreCase(jurisdiction, pageable);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // GET endpoint search partial or full by notes (admin)
    // http://localhost:2019/cases/case/notes/like/da?sort=notes
    @ApiOperation(value = "returns all cases with jurisdictions containing a given string",
            response = Case.class,
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
    @GetMapping(value = "/case/notes/like/{notes}",
            produces = {"application/json"})
    public ResponseEntity<?> getCaseLikeNotes(HttpServletRequest request,
                                                     @PathVariable String notes,
                                                     @PageableDefault(page = 0, size = 5)
                                                             Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Case> singleCase = caseService.findByNotesContainingIgnoreCase(notes, pageable);
        return new ResponseEntity<>(singleCase, HttpStatus.OK);
    }

    // POST endpoint one case (admin)
    // http://localhost:2019/cases/case
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/case",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewCase(HttpServletRequest request,
                                                 @Valid
                                                 @RequestBody Case newCase) throws
            URISyntaxException {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newCase = caseService.save(newCase);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCasesURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                             .path("/{casesid}")
                                                             .buildAndExpand(newCase.getCasesid())
                                                             .toUri();
        responseHeaders.setLocation(newCasesURI);

        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }

    // PUT endpoint one case (user or admin)
    // http://localhost:2019/cases/case/7
    @PutMapping(value = "/case/{casesid}")
    public ResponseEntity<?> updateCase(HttpServletRequest request,
                                                 @RequestBody Case updateCase,
                                                 @PathVariable long casesid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        caseService.update(updateCase,
                         casesid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE endpoint one case (user or admin)
    // http://localhost:2019/cases/case/14
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/case/{casesid}")
    public ResponseEntity<?> deleteCaseById(HttpServletRequest request,
                                                     @PathVariable long casesid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        caseService.delete(casesid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

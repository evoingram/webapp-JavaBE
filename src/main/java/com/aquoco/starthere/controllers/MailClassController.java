package com.aquoco.starthere.controllers;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.MailClass;
import com.aquoco.starthere.services.MailClassService;
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
 * mailclass table fields: mcid, mailclass, description
 */
@Loggable
@RestController
@RequestMapping("/mailclasses")
public class MailClassController {
    private static final Logger logger = LoggerFactory.getLogger(MailClassController.class);

    @Autowired
    private MailClassService mcService;

    // GET endpoint all mailclasses (admin)
    // http://localhost:2019/mailclasses/mailclasses/?page=1&size=1
    // http://localhost:2019/mailclasses/mailclasses/?sort=mailclass,desc&sort=<field>,asc
    @ApiOperation(value = "returns all mail classes",
            response = MailClass.class,
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
    @GetMapping(value = "/mailclasses",
            produces = {"application/json"})
    public ResponseEntity<?> listAllMailClasses(HttpServletRequest request,
                                                   @PageableDefault(page = 0, size = 5)
                                                           Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<MailClass> myMailClasses = mcService.findAll(pageable);
        return new ResponseEntity<>(myMailClasses, HttpStatus.OK);
    }

    // GET endpoint all mailclasses (admin)
    // http://localhost:2019/mailclasses/mailclasses/all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/mailclasses/all",
            produces = {"application/json"})
    public ResponseEntity<?> reallyListAllMailClasses(HttpServletRequest request) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<MailClass> myMailClasses = mcService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myMailClasses, HttpStatus.OK);
    }


    // GET endpoint one mailclass (admin)
    // http://localhost:2019/mailclasses/mailclass/7
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/mailclass/{mcid}",
            produces = {"application/json"})
    public ResponseEntity<?> getMailclassById(HttpServletRequest request,
                                                  @PathVariable Long mcid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        MailClass mc = mcService.findMailclassById(mcid);
        return new ResponseEntity<>(mc, HttpStatus.OK);
    }

    // GET endpoint one mailclass by mailclass (admin)
    // http://localhost:2019/mailclasses/mailclass/class/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/mailclass/class/exact/{mailclass}",
            produces = {"application/json"})
    public ResponseEntity<?> getMailclassByMailclass(HttpServletRequest request,
                                                    @PathVariable String mailclass) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        MailClass mc = mcService.findByMailclass(mailclass);
        return new ResponseEntity<>(mc, HttpStatus.OK);
    }

    // GET endpoint one mailclass by description (admin)
    // http://localhost:2019/mailclasses/mailclass/description/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/mailclass/class/exact/{description}",
            produces = {"application/json"})
    public ResponseEntity<?> getMailclassByDescription(HttpServletRequest request,
                                                     @PathVariable String description) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        MailClass mc = mcService.findByDescription(description);
        return new ResponseEntity<>(mc, HttpStatus.OK);
    }

    // GET endpoint search partial or full by mailclass (admin)
    // http://localhost:2019/mailclasses/mailclass/class/like/da?sort=mailclass
    @ApiOperation(value = "returns all mail classes with classes containing a given string",
            response = MailClass.class,
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
    @GetMapping(value = "/mailclass/class/like/{mailclass}",
            produces = {"application/json"})
    public ResponseEntity<?> getMailclassLikeMailclass(HttpServletRequest request,
                                                      @PathVariable String mailclass,
                                                      @PageableDefault(page = 0, size = 5)
                                                              Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<MailClass> mc = mcService.findByMailclassContainingIgnoreCase(mailclass, pageable);
        return new ResponseEntity<>(mc, HttpStatus.OK);
    }

    // GET endpoint search partial or full by description (admin)
    // http://localhost:2019/mailclasses/mailclass/description/like/da?sort=description
    @ApiOperation(value = "returns all mail classes with descriptions containing a given string",
            response = MailClass.class,
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
    @GetMapping(value = "/mailclass/description/like/{description}",
            produces = {"application/json"})
    public ResponseEntity<?> getMailclassLikeDescription(HttpServletRequest request,
                                                      @PathVariable String description,
                                                      @PageableDefault(page = 0, size = 5)
                                                              Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<MailClass> mc = mcService.findByDescriptionContainingIgnoreCase(description, pageable);
        return new ResponseEntity<>(mc, HttpStatus.OK);
    }
    // POST endpoint one mailclass (admin)
    // http://localhost:2019/mailclasses/mailclass
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/mailclass",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewMailClass(HttpServletRequest request,
                                                 @Valid
                                                 @RequestBody MailClass newMailclass) throws
            URISyntaxException {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newMailclass = mcService.save(newMailclass, request.isUserInRole("ADMIN"));

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newMailClassURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                             .path("/{mcid}")
                                                             .buildAndExpand(newMailclass.getMcid())
                                                             .toUri();
        responseHeaders.setLocation(newMailClassURI);

        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }

    // PUT endpoint one mailclass (admin)
    // http://localhost:2019/mailclasses/mailclass/7
    @PutMapping(value = "/mailclass/{mcid}")
    public ResponseEntity<?> updateMailClass(HttpServletRequest request,
                                                 @RequestBody MailClass updateMailClass,
                                                 @PathVariable long mcid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        mcService.update(updateMailClass,
                         mcid,
                         request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE endpoint one mailclass (admin)
    // http://localhost:2019/mailclasses/mailclass/14
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/mailclass/{mcid}")
    public ResponseEntity<?> deleteMailclassById(HttpServletRequest request,
                                                     @PathVariable long mcid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        mcService.delete(mcid, request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

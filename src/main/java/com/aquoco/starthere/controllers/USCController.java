package com.aquoco.starthere.controllers;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.USC;
import com.aquoco.starthere.services.USCService;
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
 * usc table fields:  uscid, findcitation, longcitation,
 * chcategory, webaddress
 */
@Loggable
@RestController
@RequestMapping("/usc")
public class USCController {

    private static final Logger logger = LoggerFactory.getLogger(USCController.class);

    @Autowired
    private USCService uscService;

    // GET endpoint all usccites (admin)
    // http://localhost:2019/usccites/usccites/?page=1&size=1
    // http://localhost:2019/usccites/usccites/?sort=property,desc&sort=<field>,asc
    @ApiOperation(value = "returns all branding themes",
            response = USC.class,
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
    @GetMapping(value = "/usccites",
            produces = {"application/json"})
    public ResponseEntity<?> listAllUSCs(HttpServletRequest request,
                                                       @PageableDefault(page = 0, size = 5)
                                                               Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<USC> myUSCs = uscService.findAll(pageable);
        return new ResponseEntity<>(myUSCs,
                                    HttpStatus.OK);
    }

    // GET endpoint all usccites (admin)
    // http://localhost:2019/usccites/usccites/all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/usccites/all",
            produces = {"application/json"})
    public ResponseEntity<?> reallyListAllUSCs(HttpServletRequest request) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<USC> myUSCs = uscService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myUSCs,
                                    HttpStatus.OK);
    }

    // GET endpoint one usc (admin)
    // http://localhost:2019/usccites/usc/7
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/usc/{uscid}",
            produces = {"application/json"})
    public ResponseEntity<?> getUSCById(HttpServletRequest request,
                                                      @PathVariable
                                                              Long uscid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        USC usc = uscService.findUSCById(uscid);
        return new ResponseEntity<>(usc, HttpStatus.OK);
    }

    // GET endpoint searusc full one usc by findcitation (admin)
    // http://localhost:2019/usccites/usc/findcitation/exact/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/usc/findcitation/exact/{findcitation}",
            produces = {"application/json"})
    public ResponseEntity<?> getUSCByFindcitation(HttpServletRequest request,
                                                                @PathVariable
                                                                        String findcitation) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        USC usc = uscService.findByFindcitation(findcitation);
        return new ResponseEntity<>(usc, HttpStatus.OK);
    }

    // GET endpoint search partial one usc by findcitation (admin)
    // http://localhost:2019/usccites/findcitation/findcitation/like/da?sort=findcitation
    @ApiOperation(value = "returns all usccites with findcitations containing a given string",
            response = USC.class,
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
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/usc/findcitation/like/{findcitation}",
            produces = {"application/json"})
    public ResponseEntity<?> getUSCLikeFindcitation(HttpServletRequest request,
                                                                  @PathVariable String findcitation,
                                                                  @PageableDefault(page = 0, size = 5)
                                                                          Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<USC> usc = uscService.findByFindcitationContainingIgnoreCase(findcitation, pageable);
        return new ResponseEntity<>(usc, HttpStatus.OK);
    }

    // GET endpoint search full one usc by longcitation (admin)
    // http://localhost:2019/usccites/usc/longcitation/exact/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/usc/longcitation/exact/{longcitation}",
            produces = {"application/json"})
    public ResponseEntity<?> getUSCByLongcitation(HttpServletRequest request,
                                                                @PathVariable
                                                                        String longcitation) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        USC usc = uscService.findByLongcitation(longcitation);
        return new ResponseEntity<>(usc, HttpStatus.OK);
    }

    // GET endpoint search partial one usc by longcitation (admin)
    // http://localhost:2019/usccites/usc/longcitation/like/da?sort=longcitation
    @ApiOperation(value = "returns all usccites with longcitations containing a given string",
            response = USC.class,
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
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/usc/longcitation/like/{longcitation}",
            produces = {"application/json"})
    public ResponseEntity<?> getUSCLikeLongcitation(HttpServletRequest request,
                                                                  @PathVariable String longcitation,
                                                                  @PageableDefault(page = 0, size = 5)
                                                                          Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<USC> usc = uscService.findByLongcitationContainingIgnoreCase(longcitation, pageable);
        return new ResponseEntity<>(usc, HttpStatus.OK);
    }

    // GET endpoint search full one usc by chcategory (admin)
    // http://localhost:2019/usccites/usc/chcategory/exact/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/usc/chcategory/exact/{chcategory}",
            produces = {"application/json"})
    public ResponseEntity<?> getUSCByChcategory(HttpServletRequest request,
                                                              @PathVariable
                                                                      String chcategory) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        USC usc = uscService.findByChcategory(chcategory);
        return new ResponseEntity<>(usc, HttpStatus.OK);
    }

    // GET endpoint search partial one usc by chcategory (admin)
    // http://localhost:2019/usccites/usc/chcategory/like/da?sort=chcategory
    @ApiOperation(value = "returns all usccites with chcategorys containing a given string",
            response = USC.class,
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
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/usc/chcategory/like/{chcategory}",
            produces = {"application/json"})
    public ResponseEntity<?> getUSCLikeChcategory(HttpServletRequest request,
                                                                @PathVariable String chcategory,
                                                                @PageableDefault(page = 0, size = 5)
                                                                        Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<USC> usc = uscService.findByChcategoryContainingIgnoreCase(chcategory, pageable);
        return new ResponseEntity<>(usc, HttpStatus.OK);
    }

    // GET endpoint search full one usc by webaddress (admin)
    // http://localhost:2019/usccites/usc/webaddress/exact/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/usc/webaddress/exact/{webaddress}",
            produces = {"application/json"})
    public ResponseEntity<?> getUSCByWebaddress(HttpServletRequest request,
                                                              @PathVariable
                                                                      String webaddress) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        USC usc = uscService.findByWebaddress(webaddress);
        return new ResponseEntity<>(usc, HttpStatus.OK);
    }

    // GET endpoint search partial one usc by webaddress (admin)
    // http://localhost:2019/usccites/usc/webaddress/like/da?sort=webaddress
    @ApiOperation(value = "returns all usccites with webaddresses containing a given string",
            response = USC.class,
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
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/usc/webaddress/like/{webaddress}",
            produces = {"application/json"})
    public ResponseEntity<?> getUSCLikeWebaddress(HttpServletRequest request,
                                                                @PathVariable String webaddress,
                                                                @PageableDefault(page = 0, size = 5)
                                                                        Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<USC> usc = uscService.findByWebaddressContainingIgnoreCase(webaddress, pageable);
        return new ResponseEntity<>(usc, HttpStatus.OK);
    }


    // POST endpoint one usc (admin)
    // http://localhost:2019/usccites/usc
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/usc",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewUSC(HttpServletRequest request,
                                                     @Valid
                                                     @RequestBody USC newUSC) throws
            URISyntaxException {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newUSC = uscService.save(newUSC, request.isUserInRole("ADMIN"));

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUSCURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                                 .path("/{uscid}")
                                                                 .buildAndExpand(newUSC.getUscid())
                                                                 .toUri();
        responseHeaders.setLocation(newUSCURI);

        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }

    // PUT endpoint one usc (admin)
    // http://localhost:2019/usccites/usc/7
    @PutMapping(value = "/usc/{uscid}")
    public ResponseEntity<?> updateUSC(HttpServletRequest request,
                                                     @RequestBody USC updateUSC,
                                                     @PathVariable long uscid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        uscService.update(updateUSC,
                         uscid,
                         request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE endpoint one brandingtheme (admin)
    // http://localhost:2019/usccites/usc/14
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/usc/{uscid}")
    public ResponseEntity<?> deleteUSCById(HttpServletRequest request,
                                                         @PathVariable long uscid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        uscService.delete(uscid, request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
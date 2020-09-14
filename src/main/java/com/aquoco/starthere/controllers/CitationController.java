package com.aquoco.starthere.controllers;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.CitationHyperlink;
import com.aquoco.starthere.services.CitationHyperlinkService;
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
 * citations table fields:  chid, findcitation, longcitation,
 * chcategory, webaddress
 */
@Loggable
@RestController
@RequestMapping("/citations")
public class CitationController {

    private static final Logger logger = LoggerFactory.getLogger(CitationHyperlinkController.class);

    @Autowired
    private CitationHyperlinkService chService;

    // GET endpoint all citationhyperlinks (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlinks/?page=1&size=1
    // http://localhost:2019/citationhyperlinks/citationhyperlinks/?sort=property,desc&sort=<field>,asc
    @ApiOperation(value = "returns all branding themes",
            response = CitationHyperlink.class,
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
    @GetMapping(value = "/citationhyperlinks",
            produces = {"application/json"})
    public ResponseEntity<?> listAllCitationHyperlinks(HttpServletRequest request,
                                                       @PageableDefault(page = 0, size = 5)
                                                               Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<CitationHyperlink> myCitationHyperlinks = chService.findAll(pageable);
        return new ResponseEntity<>(myCitationHyperlinks,
                                    HttpStatus.OK);
    }

    // GET endpoint all citationhyperlinks (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlinks/all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/citationhyperlinks/all",
            produces = {"application/json"})
    public ResponseEntity<?> reallyListAllCitationHyperlinks(HttpServletRequest request) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<CitationHyperlink> myCitationHyperlinks = chService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myCitationHyperlinks,
                                    HttpStatus.OK);
    }

    // GET endpoint one citationhyperlink (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlink/7
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/citationhyperlink/{chid}",
            produces = {"application/json"})
    public ResponseEntity<?> getCitationhyperlinkById(HttpServletRequest request,
                                                      @PathVariable
                                                              Long chid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        CitationHyperlink ch = chService.findCitationhyperlinkById(chid);
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }

    // GET endpoint search full one citationhyperlink by findcitation (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlink/findcitation/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/citationhyperlink/findcitation/exact/{findcitation}",
            produces = {"application/json"})
    public ResponseEntity<?> getCitationhyperlinkByFindcitation(HttpServletRequest request,
                                                                @PathVariable
                                                                        String findcitation) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        CitationHyperlink ch = chService.findByFindcitation(findcitation);
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }

    // GET endpoint search partial one citationhyperlink by findcitation (admin)
    // http://localhost:2019/citationhyperlinks/findcitation/findcitation/like/da?sort=findcitation
    @ApiOperation(value = "returns all citationhyperlinks with findcitations containing a given string",
            response = CitationHyperlink.class,
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
    @GetMapping(value = "/citationhyperlink/findcitation/like/{findcitation}",
            produces = {"application/json"})
    public ResponseEntity<?> getCitationHyperlinkLikeFindcitation(HttpServletRequest request,
                                                                  @PathVariable String findcitation,
                                                                  @PageableDefault(page = 0, size = 5)
                                                                          Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<CitationHyperlink> ch = chService.findByFindcitationContainingIgnoreCase(findcitation, pageable);
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }

    // GET endpoint search full one citationhyperlink by longcitation (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlink/longcitation/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/citationhyperlink/longcitation/exact/{longcitation}",
            produces = {"application/json"})
    public ResponseEntity<?> getCitationhyperlinkByLongcitation(HttpServletRequest request,
                                                                @PathVariable
                                                                        String longcitation) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        CitationHyperlink ch = chService.findByLongcitation(longcitation);
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }

    // GET endpoint search partial one citationhyperlink by longcitation (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlink/longcitation/like/da?sort=longcitation
    @ApiOperation(value = "returns all citationhyperlinks with longcitations containing a given string",
            response = CitationHyperlink.class,
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
    @GetMapping(value = "/citationhyperlink/longcitation/like/{longcitation}",
            produces = {"application/json"})
    public ResponseEntity<?> getCitationHyperlinkLikeLongcitation(HttpServletRequest request,
                                                                  @PathVariable String longcitation,
                                                                  @PageableDefault(page = 0, size = 5)
                                                                          Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<CitationHyperlink> ch = chService.findByLongcitationContainingIgnoreCase(longcitation, pageable);
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }

    // GET endpoint search full one citationhyperlink by chcategory (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlink/chcategory/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/citationhyperlink/chcategory/exact/{chcategory}",
            produces = {"application/json"})
    public ResponseEntity<?> getCitationhyperlinkByChcategory(HttpServletRequest request,
                                                              @PathVariable
                                                                      String chcategory) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        CitationHyperlink ch = chService.findByChcategory(chcategory);
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }

    // GET endpoint search partial one citationhyperlink by chcategory (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlink/chcategory/like/da?sort=chcategory
    @ApiOperation(value = "returns all citationhyperlinks with chcategorys containing a given string",
            response = CitationHyperlink.class,
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
    @GetMapping(value = "/citationhyperlink/chcategory/like/{chcategory}",
            produces = {"application/json"})
    public ResponseEntity<?> getCitationHyperlinkLikeChcategory(HttpServletRequest request,
                                                                @PathVariable String chcategory,
                                                                @PageableDefault(page = 0, size = 5)
                                                                        Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<CitationHyperlink> ch = chService.findByChcategoryContainingIgnoreCase(chcategory, pageable);
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }

    // GET endpoint search full one citationhyperlink by webaddress (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlink/webaddress/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/citationhyperlink/webaddress/exact/{webaddress}",
            produces = {"application/json"})
    public ResponseEntity<?> getCitationhyperlinkByWebaddress(HttpServletRequest request,
                                                              @PathVariable
                                                                      String webaddress) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        CitationHyperlink ch = chService.findByWebaddress(webaddress);
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }

    // GET endpoint search partial one citationhyperlink by webaddress (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlink/webaddress/like/da?sort=webaddress
    @ApiOperation(value = "returns all citationhyperlinks with webaddresses containing a given string",
            response = CitationHyperlink.class,
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
    @GetMapping(value = "/citationhyperlink/webaddress/like/{webaddress}",
            produces = {"application/json"})
    public ResponseEntity<?> getCitationHyperlinkLikeWebaddress(HttpServletRequest request,
                                                                @PathVariable String webaddress,
                                                                @PageableDefault(page = 0, size = 5)
                                                                        Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<CitationHyperlink> ch = chService.findByWebaddressContainingIgnoreCase(webaddress, pageable);
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }


    // POST endpoint one citationhyperlink (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlink
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/citationhyperlink",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewCitationHyperlink(HttpServletRequest request,
                                                     @Valid
                                                     @RequestBody CitationHyperlink newCitationhyperlink) throws
            URISyntaxException {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newCitationhyperlink = chService.save(newCitationhyperlink, request.isUserInRole("ADMIN"));

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCitationHyperlinkURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                                 .path("/{chid}")
                                                                 .buildAndExpand(newCitationhyperlink.getChid())
                                                                 .toUri();
        responseHeaders.setLocation(newCitationHyperlinkURI);

        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }

    // PUT endpoint one citationhyperlink (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlink/7
    @PutMapping(value = "/citationhyperlink/{chid}")
    public ResponseEntity<?> updateCitationHyperlink(HttpServletRequest request,
                                                     @RequestBody CitationHyperlink updateCitationHyperlink,
                                                     @PathVariable long chid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        chService.update(updateCitationHyperlink,
                         chid,
                         request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE endpoint one brandingtheme (admin)
    // http://localhost:2019/citationhyperlinks/citationhyperlink/14
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/citationhyperlink/{chid}")
    public ResponseEntity<?> deleteCitationhyperlinkById(HttpServletRequest request,
                                                         @PathVariable long chid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        chService.delete(chid, request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
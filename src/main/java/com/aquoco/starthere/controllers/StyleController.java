package com.aquoco.starthere.controllers;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.Style;
import com.aquoco.starthere.services.StyleService;
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
 * style table fields: sid, stylename
 */
@Loggable
@RestController
@RequestMapping("/styles")
public class StyleController {
    private static final Logger logger = LoggerFactory.getLogger(StyleController.class);

    @Autowired
    private StyleService styleService;

    // GET endpoint all styles (admin)
    // http://localhost:2019/styles/styles/?page=1&size=1
    // http://localhost:2019/styles/styles/?sort=stylename,desc&sort=<field>,asc
    @ApiOperation(value = "returns all branding themes",
            response = Style.class,
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
    @GetMapping(value = "/styles",
            produces = {"application/json"})
    public ResponseEntity<?> listAllStyles(HttpServletRequest request,
                                                   @PageableDefault(page = 0, size = 5)
                                                           Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Style> myStyles = styleService.findAll(pageable);
        return new ResponseEntity<>(myStyles, HttpStatus.OK);
    }

    // GET endpoint all styles (admin)
    // http://localhost:2019/styles/styles/all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/styles/all",
            produces = {"application/json"})
    public ResponseEntity<?> reallyListAllStyles(HttpServletRequest request) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Style> myStyles = styleService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myStyles, HttpStatus.OK);
    }


    // GET endpoint one style (admin)
    // http://localhost:2019/styles/style/7
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/style/{sid}",
            produces = {"application/json"})
    public ResponseEntity<?> getStyleById(HttpServletRequest request,
                                                  @PathVariable
                                                          Long sid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Style currentStyle = styleService.findStyleById(sid);
        return new ResponseEntity<>(currentStyle, HttpStatus.OK);
    }

    // GET endpoint one style by stylename (admin)
    // http://localhost:2019/styles/style/name/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/style/name/exact/{stylename}",
            produces = {"application/json"})
    public ResponseEntity<?> getStyleByName(HttpServletRequest request,
                                                    @PathVariable
                                                            String stylename) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Style currentStyle = styleService.findByStylename(stylename);
        return new ResponseEntity<>(currentStyle, HttpStatus.OK);
    }

    // GET endpoint search partial or full by stylename (admin)
    // http://localhost:2019/styles/style/name/like/da?sort=stylename
    @ApiOperation(value = "returns all styles with names containing a given string",
            response = Style.class,
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
    @GetMapping(value = "/style/name/like/{stylename}",
            produces = {"application/json"})
    public ResponseEntity<?> getStyleLikeName(HttpServletRequest request,
                                                      @PathVariable String stylename,
                                                      @PageableDefault(page = 0, size = 5)
                                                              Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Style> currentStyle = styleService.findByStylenameContainingIgnoreCase(stylename, pageable);
        return new ResponseEntity<>(currentStyle, HttpStatus.OK);
    }

    // POST endpoint one style (admin)
    // http://localhost:2019/styles/style
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/style",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewStyle(HttpServletRequest request,
                                                 @Valid
                                                 @RequestBody Style newStyle) throws
            URISyntaxException {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newStyle = styleService.save(newStyle, request.isUserInRole("ADMIN"));

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newStyleURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                             .path("/{sid}")
                                                             .buildAndExpand(newStyle.getSid())
                                                             .toUri();
        responseHeaders.setLocation(newStyleURI);

        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }

    // PUT endpoint one style (admin)
    // http://localhost:2019/styles/style/7
    @PutMapping(value = "/style/{sid}")
    public ResponseEntity<?> updateStyle(HttpServletRequest request,
                                                 @RequestBody Style updateStyle,
                                                 @PathVariable long sid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        styleService.update(updateStyle,
                         sid,
                         request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE endpoint one style (admin)
    // http://localhost:2019/styles/style/14
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/style/{sid}")
    public ResponseEntity<?> deleteStyleById(HttpServletRequest request,
                                                     @PathVariable long sid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        styleService.delete(sid, request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

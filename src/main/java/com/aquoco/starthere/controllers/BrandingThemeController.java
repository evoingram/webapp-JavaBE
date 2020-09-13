package com.aquoco.starthere.controllers;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.BrandingTheme;
import com.aquoco.starthere.services.BrandingThemeService;
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
 * brandingtheme table fields: btid, brandingtheme
 */
@Loggable
@RestController
@RequestMapping("/brandingthemes")
public class BrandingThemeController {
    private static final Logger logger = LoggerFactory.getLogger(BrandingThemeController.class);

    @Autowired
    private BrandingThemeService btService;

    // GET endpoint all brandingthemes (admin)
    // http://localhost:2019/brandingthemes/brandingthemes/?page=1&size=1
    // http://localhost:2019/brandingthemes/brandingthemes/?sort=brandingthemename,desc&sort=<field>,asc
    @ApiOperation(value = "returns all branding themes",
            response = BrandingTheme.class,
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
    @GetMapping(value = "/brandingthemes",
            produces = {"application/json"})
    public ResponseEntity<?> listAllBrandingThemes(HttpServletRequest request,
                                          @PageableDefault(page = 0, size = 5)
                                                  Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<BrandingTheme> myBrandingThemes = btService.findAll(pageable);
        return new ResponseEntity<>(myBrandingThemes,
                                    HttpStatus.OK);
    }

    // GET endpoint all brandingthemes (admin)
    // http://localhost:2019/brandingthemes/brandingthemes/all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/brandingthemes/all",
            produces = {"application/json"})
    public ResponseEntity<?> reallyListAllBrandingThemes(HttpServletRequest request) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<BrandingTheme> myBrandingThemes = btService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myBrandingThemes,
                                    HttpStatus.OK);
    }


    // GET endpoint one brandingtheme (admin)
    // http://localhost:2019/brandingthemes/brandingtheme/7
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/brandingtheme/{brandingthemeId}",
            produces = {"application/json"})
    public ResponseEntity<?> getBrandingthemeById(HttpServletRequest request,
                                         @PathVariable Long brandingthemeId) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        BrandingTheme bt = btService.findBrandingthemeById(brandingthemeId);
        return new ResponseEntity<>(bt, HttpStatus.OK);
    }

    // GET endpoint one brandingtheme by name (admin)
    // http://localhost:2019/brandingthemes/brandingtheme/name/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/brandingtheme/name/{brandingtheme}",
            produces = {"application/json"})
    public ResponseEntity<?> getBrandingthemeByName(HttpServletRequest request,
                                           @PathVariable
                                                   String brandingtheme) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        BrandingTheme bt = btService.findByBrandingtheme(brandingtheme);
        return new ResponseEntity<>(bt, HttpStatus.OK);
    }

    // GET endpoint search partial or full by brandingtheme (admin)
    // http://localhost:2019/brandingthemes/brandingtheme/theme/like/da?sort=brandingthemename
    @ApiOperation(value = "returns all BrandingThemes with names containing a given string",
            response = BrandingTheme.class,
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
    @GetMapping(value = "/brandingtheme/theme/like/{brandingtheme}",
            produces = {"application/json"})
    public ResponseEntity<?> getBrandingthemeLikeName(HttpServletRequest request,
                                             @PathVariable String brandingtheme,
                                             @PageableDefault(page = 0, size = 5)
                                                     Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<BrandingTheme> bt = btService.findByBrandingthemeContaining(brandingtheme, pageable);
        return new ResponseEntity<>(bt, HttpStatus.OK);
    }

    // POST endpoint one brandingtheme (admin)
    // http://localhost:2019/brandingthemes/brandingtheme
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/brandingtheme",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewBrandingTheme(HttpServletRequest request,
                                        @Valid
                                        @RequestBody BrandingTheme newBrandingtheme) throws
            URISyntaxException {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newBrandingtheme = btService.save(newBrandingtheme, request.isUserInRole("ADMIN"));

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBrandingThemeURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                    .path("/{brandingthemeid}")
                                                    .buildAndExpand(newBrandingtheme.getBtid())
                                                    .toUri();
        responseHeaders.setLocation(newBrandingThemeURI);

        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }

    // PUT endpoint one brandingtheme (admin)
    // http://localhost:2019/brandingthemes/brandingtheme/7
    @PutMapping(value = "/brandingtheme/{btid}")
    public ResponseEntity<?> updateBrandingTheme(HttpServletRequest request,
                                        @RequestBody BrandingTheme updateBrandingTheme,
                                        @PathVariable long btid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        btService.update(updateBrandingTheme,
                           btid,
                           request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE endpoint one brandingtheme (admin)
    // http://localhost:2019/brandingthemes/brandingtheme/14
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/brandingtheme/{btid}")
    public ResponseEntity<?> deleteBrandingthemeById(HttpServletRequest request,
                                            @PathVariable long btid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        btService.delete(btid, request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

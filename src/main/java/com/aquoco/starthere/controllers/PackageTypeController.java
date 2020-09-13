package com.aquoco.starthere.controllers;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.PackageType;
import com.aquoco.starthere.services.PackageTypeService;
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
 * packagetype table fields: ptid, packagetype, description
 */
@Loggable
@RestController
@RequestMapping("/packagetypes")
public class PackageTypeController {
    private static final Logger logger = LoggerFactory.getLogger(PackageTypeController.class);

    @Autowired
    private PackageTypeService ptService;


    // GET endpoint all packagetypes (admin)
    // http://localhost:2019/packagetypes/packagetypes/?page=1&size=1
    // http://localhost:2019/packagetypes/packagetypes/?sort=packagetype,desc&sort=<field>,asc
    @ApiOperation(value = "returns all package types",
            response = PackageType.class,
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
    @GetMapping(value = "/packagetypes",
            produces = {"application/json"})
    public ResponseEntity<?> listAllPackageTypes(HttpServletRequest request,
                                                @PageableDefault(page = 0, size = 5)
                                                        Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<PackageType> myPackageTypes = ptService.findAll(pageable);
        return new ResponseEntity<>(myPackageTypes, HttpStatus.OK);
    }

    // GET endpoint all packagetypes (admin)
    // http://localhost:2019/packagetypes/packagetypes/all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/packagetypes/all",
            produces = {"application/json"})
    public ResponseEntity<?> reallyListAllPackageTypes(HttpServletRequest request) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<PackageType> myPackageTypes = ptService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myPackageTypes, HttpStatus.OK);
    }


    // GET endpoint one packagetype (admin)
    // http://localhost:2019/packagetypes/packagetype/7
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/packagetype/{ptid}",
            produces = {"application/json"})
    public ResponseEntity<?> getPackagetypeById(HttpServletRequest request,
                                              @PathVariable
                                                      Long ptid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        PackageType pt = ptService.findPackagetypeById(ptid);
        return new ResponseEntity<>(pt, HttpStatus.OK);
    }

    // GET endpoint one packagetype by packagetype (admin)
    // http://localhost:2019/packagetypes/packagetype/class/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/packagetype/type/exact/{packagetype}",
            produces = {"application/json"})
    public ResponseEntity<?> getPackagetypeByPackagetype(HttpServletRequest request,
                                                     @PathVariable String packagetype) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        PackageType pt = ptService.findByPackagetype(packagetype);
        return new ResponseEntity<>(pt, HttpStatus.OK);
    }

    // GET endpoint one packagetype by description (admin)
    // http://localhost:2019/packagetypes/packagetype/description/exact/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/packagetype/type/exact/{description}",
            produces = {"application/json"})
    public ResponseEntity<?> getPackagetypeByDescription(HttpServletRequest request,
                                                         @PathVariable String description) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        PackageType pt = ptService.findByDescription(description);
        return new ResponseEntity<>(pt, HttpStatus.OK);
    }

    // GET endpoint search partial or full by packagetype (admin)
    // http://localhost:2019/packagetypes/packagetype/class/like/da?sort=packagetype
    @ApiOperation(value = "returns all mail classes with classes containing a given string",
            response = PackageType.class,
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
    @GetMapping(value = "/packagetype/type/like/{packagetype}",
            produces = {"application/json"})
    public ResponseEntity<?> getPackagetypeLikePackagetype(HttpServletRequest request,
                                                       @PathVariable String packagetype,
                                                       @PageableDefault(page = 0, size = 5)
                                                               Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<PackageType> pt = ptService.findByPackagetypeContainingIgnoreCase(packagetype, pageable);
        return new ResponseEntity<>(pt, HttpStatus.OK);
    }

    // GET endpoint search partial or full by description (admin)
    // http://localhost:2019/packagetypes/packagetype/description/like/da?sort=description
    @ApiOperation(value = "returns all mail classes with descriptions containing a given string",
            response = PackageType.class,
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
    @GetMapping(value = "/packagetype/description/like/{description}",
            produces = {"application/json"})
    public ResponseEntity<?> getPackagetypeLikeDescription(HttpServletRequest request,
                                                         @PathVariable String description,
                                                         @PageableDefault(page = 0, size = 5)
                                                                 Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<PackageType> pt = ptService.findByDescriptionContainingIgnoreCase(description, pageable);
        return new ResponseEntity<>(pt, HttpStatus.OK);
    }
    // POST endpoint one packagetype (admin)
    // http://localhost:2019/packagetypes/packagetype
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/packagetype",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewPackageType(HttpServletRequest request,
                                             @Valid
                                             @RequestBody PackageType newPackagetype) throws
            URISyntaxException {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newPackagetype = ptService.save(newPackagetype, request.isUserInRole("ADMIN"));

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPackageTypeURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                         .path("/{ptid}")
                                                         .buildAndExpand(newPackagetype.getPtid())
                                                         .toUri();
        responseHeaders.setLocation(newPackageTypeURI);

        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }

    // PUT endpoint one packagetype (admin)
    // http://localhost:2019/packagetypes/packagetype/7
    @PutMapping(value = "/packagetype/{ptid}")
    public ResponseEntity<?> updatePackageType(HttpServletRequest request,
                                             @RequestBody PackageType updatePackageType,
                                             @PathVariable long ptid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        ptService.update(updatePackageType,
                         ptid,
                         request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE endpoint one packagetype (admin)
    // http://localhost:2019/packagetypes/packagetype/14
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/packagetype/{ptid}")
    public ResponseEntity<?> deletePackagetypeById(HttpServletRequest request,
                                                 @PathVariable long ptid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        ptService.delete(ptid, request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

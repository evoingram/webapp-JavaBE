package com.aquoco.starthere.controllers;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.Rate;
import com.aquoco.starthere.services.RateService;
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
    * rate table fields:  ratesid, code, inventoryratecode, productname, description, rate
*/

@Loggable
@RestController
@RequestMapping("/rates")
public class RateController {

    private static final Logger logger = LoggerFactory.getLogger(RateController.class);

    @Autowired
    private RateService rateService;

    // http://localhost:2019/rates/rates/?page=1&size=1
    // http://localhost:2019/rates/rates/?sort=username,desc&sort=<field>,asc
    @ApiOperation(value = "returns all rates",
            response = Rate.class,
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
    @GetMapping(value = "/rates",
            produces = {"application/json"})
    public ResponseEntity<?> listAllRates(HttpServletRequest request,
                                          @PageableDefault(page = 0,
                                                  size = 5)
                                                  Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Rate> myRates = rateService.findAll(pageable);
        return new ResponseEntity<>(myRates, HttpStatus.OK);
    }

    // http://localhost:2019/rates/rates/all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/rates/all",
            produces = {"application/json"})
    public ResponseEntity<?> reallyListAllUsers(HttpServletRequest request) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Rate> myRates = rateService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myRates, HttpStatus.OK);
    }

    // http://localhost:2019/rates/rate/7
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/rate/{ratesId}",
            produces = {"application/json"})
    public ResponseEntity<?> getRateById(HttpServletRequest request,
                                         @PathVariable
                                                 Long ratesId) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Rate r = rateService.findRateById(ratesId);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    // http://localhost:2019/rates/rate/1.60
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/rate/rate/{rate}",
            produces = {"application/json"})
    public ResponseEntity<?> getRateByRate(HttpServletRequest request,
                                           @PathVariable
                                                   Double rate) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Rate r = rateService.findByRate(rate);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }

    // List<Rate> findByRateContaining(Double rate, Pageable pageable);
    // http://localhost:2019/rates/rateamount/like/da?sort=rate
    @ApiOperation(value = "returns all rates with rates containing a given string",
            response = Rate.class,
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
    @GetMapping(value = "/rateamount/like/{rate}",
            produces = {"application/json"})
    public ResponseEntity<?> getRateLikeRate(HttpServletRequest request,
                                             @PathVariable
                                                     Double rate,
                                             @PageableDefault(page = 0,
                                                     size = 5)
                                                     Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Rate> r = rateService.findByRateContaining(rate,
                                                        pageable);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }

    // List<Rate> findByCodeContainingIgnoreCase(String code, Pageable pageable);
    // http://localhost:2019/rates/code/like/da?sort=rate
    @ApiOperation(value = "returns all rates with codes containing a given string",
            response = Rate.class,
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
    @GetMapping(value = "/code/like/{code}",
            produces = {"application/json"})
    public ResponseEntity<?> getRateLikeCode(HttpServletRequest request,
                                             @PathVariable
                                                     String code,
                                             @PageableDefault(page = 0,
                                                     size = 5)
                                                     Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Rate> r = rateService.findByCodeContainingIgnoreCase(code,
                                                        pageable);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }

    // List<Rate> findByInventoryratecodeContainingIgnoreCase(String inventoryratecode, Pageable pageable);
    // http://localhost:2019/rates/irc/like/da?sort=rate
    @ApiOperation(value = "returns all rates with ircs containing a given string",
            response = Rate.class,
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
    @GetMapping(value = "/irc/like/{irc}",
            produces = {"application/json"})
    public ResponseEntity<?> getRateLikeInventoryratecode(HttpServletRequest request,
                                             @PathVariable
                                                     String irc,
                                             @PageableDefault(page = 0,
                                                     size = 5)
                                                     Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Rate> r = rateService.findByInventoryratecodeContainingIgnoreCase(irc,
                                                        pageable);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }

    // List<Rate> findByProductnameContainingIgnoreCase(String productname, Pageable pageable);
    // http://localhost:2019/rates/productname/like/da?sort=rate
    @ApiOperation(value = "returns all rates with rates containing a given string",
            response = Rate.class,
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
    @GetMapping(value = "/productname/like/{productname}",
            produces = {"application/json"})
    public ResponseEntity<?> getRateLikeProductname(HttpServletRequest request,
                                             @PathVariable
                                                     String productname,
                                             @PageableDefault(page = 0,
                                                     size = 5)
                                                     Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Rate> r = rateService.findByProductnameContainingIgnoreCase(productname,
                                                        pageable);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }

    // List<Rate> findByDescriptionContainingIgnoreCase(String description, Pageable pageable);
    // http://localhost:2019/rates/description/like/da?sort=rate
    @ApiOperation(value = "returns all rates with rates containing a given string",
            response = Rate.class,
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
    @GetMapping(value = "/description/like/{description}",
            produces = {"application/json"})
    public ResponseEntity<?> getRateLikeDescription(HttpServletRequest request,
                                             @PathVariable
                                                     String description,
                                             @PageableDefault(page = 0,
                                                     size = 5)
                                                     Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Rate> r = rateService.findByDescriptionContainingIgnoreCase(description,
                                                        pageable);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/rates/rate
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/rate",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewRate(HttpServletRequest request,
                                        @Valid
                                        @RequestBody
                                                Rate newrate) throws
            URISyntaxException {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newrate = rateService.save(newrate, request.isUserInRole("ADMIN"));

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRateURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                    .path("/{ratesid}")
                                                    .buildAndExpand(newrate.getRatesid())
                                                    .toUri();
        responseHeaders.setLocation(newRateURI);

        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }

    // http://localhost:2019/rates/rate/7
    @PutMapping(value = "/rate/{id}")
    public ResponseEntity<?> updateRate(HttpServletRequest request,
                                        @RequestBody
                                                Rate updateRate,
                                        @PathVariable
                                                long id) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        rateService.update(updateRate,
                           id,
                           request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:2019/rates/rate/14
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/rate/{id}")
    public ResponseEntity<?> deleteRateById(HttpServletRequest request,
                                            @PathVariable
                                                    long id) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        rateService.delete(id, request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

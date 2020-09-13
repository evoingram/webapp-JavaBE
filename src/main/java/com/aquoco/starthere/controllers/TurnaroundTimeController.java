package com.aquoco.starthere.controllers;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.TurnaroundTime;
import com.aquoco.starthere.services.TurnaroundTimeService;
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
 * turnaroundtimes table fields: ttid, turnaroundtime turnaroundtimes
 */
@Loggable
@RestController
@RequestMapping("/turnaroundtimes")
public class TurnaroundTimeController {
    private static final Logger logger = LoggerFactory.getLogger(TurnaroundTimeController.class);

    @Autowired
    private TurnaroundTimeService ttService;

    // GET endpoint all turnaroundtimes (admin)
    // http://localhost:2019/turnaroundtimes/turnaroundtimes/?page=1&size=1
    // http://localhost:2019/turnaroundtimes/turnaroundtimes/?sort=Username,desc&sort=<field>,asc
    @ApiOperation(value = "returns all turnaround times",
            response = TurnaroundTime.class,
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
    @GetMapping(value = "/turnaroundtimes",
            produces = {"application/json"})
    public ResponseEntity<?> listAllTurnaroundTimes(HttpServletRequest request,
                                                   @PageableDefault(page = 0, size = 5)
                                                           Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<TurnaroundTime> myTurnaroundTimes = ttService.findAll(pageable);
        return new ResponseEntity<>(myTurnaroundTimes,
                                    HttpStatus.OK);
    }

    // GET endpoint all turnaroundtimes (admin)
    // http://localhost:2019/turnaroundtimes/turnaroundtimes/all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/turnaroundtimes/all",
            produces = {"application/json"})
    public ResponseEntity<?> reallyListAllTurnaroundTimes(HttpServletRequest request) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<TurnaroundTime> myTurnaroundTimes = ttService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myTurnaroundTimes,
                                    HttpStatus.OK);
    }


    // GET endpoint one turnaroundtime (admin)
    // http://localhost:2019/turnaroundtimes/turnaroundtime/7
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/turnaroundtime/{ttid}",
            produces = {"application/json"})
    public ResponseEntity<?> getTurnaroundtimeById(HttpServletRequest request,
                                                  @PathVariable
                                                          Long ttid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        TurnaroundTime tt = ttService.findTurnaroundtimeById(ttid);
        return new ResponseEntity<>(tt, HttpStatus.OK);
    }

    // GET endpoint one turnaroundtime by name (admin)
    // http://localhost:2019/turnaroundtimes/turnaroundtime/name/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/turnaroundtime/name/{turnaroundtime}",
            produces = {"application/json"})
    public ResponseEntity<?> getTurnaroundtimeByName(HttpServletRequest request,
                                                    @PathVariable
                                                            long turnaroundtime) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        TurnaroundTime tt = ttService.findByTurnaroundtime(turnaroundtime);
        return new ResponseEntity<>(tt, HttpStatus.OK);
    }

    // GET endpoint search partial or full by turnaroundtime (admin)
    // http://localhost:2019/turnaroundtimes/turnaroundtime/time/like/da?sort=turnaroundtime
    @ApiOperation(value = "returns all turnaround times with names containing a given string",
            response = TurnaroundTime.class,
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
    @GetMapping(value = "/turnaroundtime/time/like/{turnaroundtime}",
            produces = {"application/json"})
    public ResponseEntity<?> getTurnaroundtimeLikeName(HttpServletRequest request,
                                                      @PathVariable long turnaroundtime,
                                                      @PageableDefault(page = 0, size = 5)
                                                              Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        TurnaroundTime tt = ttService.findByTurnaroundtime(turnaroundtime);
        return new ResponseEntity<>(tt, HttpStatus.OK);
    }

    // POST endpoint one turnaroundtime (admin)
    // http://localhost:2019/turnaroundtimes/turnaroundtime
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/turnaroundtime",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewTurnaroundTime(HttpServletRequest request,
                                                 @Valid
                                                 @RequestBody
                                                         TurnaroundTime newTurnaroundtime) throws
            URISyntaxException {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newTurnaroundtime = ttService.save(newTurnaroundtime, request.isUserInRole("ADMIN"));

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newTurnaroundTimeURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                             .path("/{ttid}")
                                                             .buildAndExpand(newTurnaroundtime.getTtid())
                                                             .toUri();
        responseHeaders.setLocation(newTurnaroundTimeURI);

        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }

    // PUT endpoint one turnaroundtime (admin)
    // http://localhost:2019/turnaroundtimes/turnaroundtime/7
    @PutMapping(value = "/turnaroundtime/{ttid}")
    public ResponseEntity<?> updateTurnaroundTime(HttpServletRequest request,
                                                 @RequestBody TurnaroundTime updateTurnaroundTime,
                                                 @PathVariable long ttid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        ttService.update(updateTurnaroundTime,
                         ttid,
                         request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE endpoint one turnaroundtime (admin)
    // http://localhost:2019/turnaroundtimes/turnaroundtime/14
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/turnaroundtime/{ttid}")
    public ResponseEntity<?> deleteTurnaroundtimeById(HttpServletRequest request,
                                                     @PathVariable long ttid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        ttService.delete(ttid, request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

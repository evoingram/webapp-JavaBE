package com.aquoco.starthere.controllers;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.User;
import com.aquoco.starthere.services.UserService;
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
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/*
 * user table fields:  userid, address1, address2, businessphone, city,
 * company, creditApproved,firstname, jobtitle, lastname, mrms, notes,
 * password, postalcode, primaryemail, state, username
 */
@Loggable
@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // http://localhost:2019/users/users/?page=1&size=1
    // http://localhost:2019/users/users/?sort=username,desc&sort=<field>,asc
    @ApiOperation(value = "returns all Users",
            response = User.class,
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
    @GetMapping(value = "/users",
            produces = {"application/json"})
    public ResponseEntity<?> listAllUsers(HttpServletRequest request,
                                          @PageableDefault(page = 0,
                                                  size = 5)
                                                  Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<User> myUsers = userService.findAll(pageable);
        return new ResponseEntity<>(myUsers,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/users/users/all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/users/all",
            produces = {"application/json"})
    public ResponseEntity<?> reallyListAllUsers(HttpServletRequest request) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<User> myUsers = userService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myUsers,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/users/users/all
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/creditApproved/{creditApproved}",
            produces = {"application/json"})
    public ResponseEntity<?> findUsersByCreditApproved(HttpServletRequest request,
                                                 @PathVariable boolean creditApproved) {

        logger.trace(request.getMethod().toUpperCase() + " " +
                     request.getRequestURI() + " accessed");

        List<User> myUsers = userService.findUsersByCreditApproved(creditApproved, Pageable.unpaged());

        return new ResponseEntity<>(myUsers, HttpStatus.OK);
    }

    // http://localhost:2019/users/user/7
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/user/{userId}",
            produces = {"application/json"})
    public ResponseEntity<?> getUserById(HttpServletRequest request,
                                         @PathVariable
                                                 Long userId) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        User u = userService.findUserById(userId);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // http://localhost:2019/users/user/name/cinnamon
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/user/name/{userName}",
            produces = {"application/json"})
    public ResponseEntity<?> getUserByName(HttpServletRequest request,
                                           @PathVariable
                                                   String userName) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        User u = userService.findByName(userName);
        return new ResponseEntity<>(u,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/users/user/name/like/da?sort=username
    @ApiOperation(value = "returns all Users with names containing a given string",
            response = User.class,
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
    @GetMapping(value = "/user/name/like/{userName}",
            produces = {"application/json"})
    public ResponseEntity<?> getUserLikeName(HttpServletRequest request,
                                             @PathVariable
                                                     String userName,
                                             @PageableDefault(page = 0,
                                                     size = 5)
                                                     Pageable pageable) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<User> u = userService.findByNameContaining(userName,
                                                        pageable);
        return new ResponseEntity<>(u,
                                    HttpStatus.OK);
    }

    // http://localhost:2019/users/user/company/like/da?sort=username
    @ApiOperation(value = "returns all Users with companies containing a given string",
            response = User.class,
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
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/company/like/{company}",
            produces = {"application/json"})
    public ResponseEntity<?> findByCompanyContainingIgnoreCase(HttpServletRequest request,
                                             @PathVariable String company,
                                             @PageableDefault(page = 0, size = 5)
                                             Pageable pageable) {
        logger.trace(request.getMethod().toUpperCase() + " " +
                     request.getRequestURI() + " accessed");

        List<User> u = userService.findByCompanyContainingIgnoreCase(company, pageable);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // http://localhost:2019/users/user/lastname/like/da?sort=username
    @ApiOperation(value = "returns all Users with last name containing a given string",
            response = User.class,
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
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/lastname/like/{lastname}",
            produces = {"application/json"})
    public ResponseEntity<?> findByLastnameContainingIgnoreCase(HttpServletRequest request,
                                                               @PathVariable String lastname,
                                                               @PageableDefault(page = 0, size = 5)
                                                                       Pageable pageable) {
        logger.trace(request.getMethod().toUpperCase() + " " +
                             request.getRequestURI() + " accessed");

        List<User> u = userService.findByLastnameContainingIgnoreCase(lastname, pageable);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // http://localhost:2019/users/user/firstname/like/da?sort=username
    @ApiOperation(value = "returns all Users with first name containing a given string",
            response = User.class,
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
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/firstname/like/{firstname}",
            produces = {"application/json"})
    public ResponseEntity<?> findByFirstnameContainingIgnoreCase(HttpServletRequest request,
                                                                @PathVariable String firstname,
                                                                @PageableDefault(page = 0, size = 5)
                                                                        Pageable pageable) {
        logger.trace(request.getMethod().toUpperCase() + " " +
                             request.getRequestURI() + " accessed");

        List<User> u = userService.findByFirstnameContainingIgnoreCase(firstname, pageable);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // http://localhost:2019/users/businessphone/like/da?sort=username
    @ApiOperation(value = "returns all Users with business phone containing a given string",
            response = User.class,
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
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/businessphone/like/{businessphone}",
            produces = {"application/json"})
    public ResponseEntity<?> findByBusinessphoneContainingIgnoreCase(HttpServletRequest request,
                                                                 @PathVariable String businessphone,
                                                                 @PageableDefault(page = 0, size = 5)
                                                                         Pageable pageable) {
        logger.trace(request.getMethod().toUpperCase() + " " +
                             request.getRequestURI() + " accessed");

        List<User> u = userService.findByBusinessphoneContainingIgnoreCase(businessphone, pageable);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // http://localhost:2019/users/address1/like/da?sort=username
    @ApiOperation(value = "returns all Users with address1 containing a given string",
            response = User.class,
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
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/address1/like/{address1}",
            produces = {"application/json"})
    public ResponseEntity<?> findByAddress1ContainingIgnoreCase(HttpServletRequest request,
                                                            @PathVariable String address1,
                                                            @PageableDefault(page = 0, size = 5)
                                                                    Pageable pageable) {
        logger.trace(request.getMethod().toUpperCase() + " " +
                             request.getRequestURI() + " accessed");

        List<User> u = userService.findByAddress1ContainingIgnoreCase(address1, pageable);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // http://localhost:2019/users/city/like/da?sort=username
    @ApiOperation(value = "returns all Users with city containing a given string",
            response = User.class,
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
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/city/like/{city}",
            produces = {"application/json"})
    public ResponseEntity<?> findByCityContainingIgnoreCase(HttpServletRequest request,
                                                                     @PathVariable String city,
                                                                     @PageableDefault(page = 0, size = 5)
                                                                             Pageable pageable) {
        logger.trace(request.getMethod().toUpperCase() + " " +
                             request.getRequestURI() + " accessed");

        List<User> u = userService.findByCityContainingIgnoreCase(city, pageable);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // http://localhost:2019/users/state/like/da?sort=username
    @ApiOperation(value = "returns all Users with state containing a given string",
            response = User.class,
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
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/state/like/{state}",
            produces = {"application/json"})
    public ResponseEntity<?> findByStateContainingIgnoreCase(HttpServletRequest request,
                                                            @PathVariable String state,
                                                            @PageableDefault(page = 0, size = 5)
                                                                    Pageable pageable) {
        logger.trace(request.getMethod().toUpperCase() + " " +
                             request.getRequestURI() + " accessed");

        List<User> u = userService.findByStateContainingIgnoreCase(state, pageable);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // http://localhost:2019/users/postalcode/like/da?sort=username
    @ApiOperation(value = "returns all Users with postal code containing a given string",
            response = User.class,
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
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/postalcode/like/{postalcode}",
            produces = {"application/json"})
    public ResponseEntity<?> findByPostalcodeContainingIgnoreCase(HttpServletRequest request,
                                                            @PathVariable String postalcode,
                                                            @PageableDefault(page = 0, size = 5)
                                                                    Pageable pageable) {
        logger.trace(request.getMethod().toUpperCase() + " " +
                             request.getRequestURI() + " accessed");

        List<User> u = userService.findByPostalcodeContainingIgnoreCase(postalcode, pageable);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // http://localhost:2019/users/notes/like/da?sort=username
    @ApiOperation(value = "returns all Users with notes containing a given string",
            response = User.class,
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
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/notes/like/{notes}",
            produces = {"application/json"})
    public ResponseEntity<?> findByNotesContainingIgnoreCase(HttpServletRequest request,
                                                            @PathVariable String notes,
                                                            @PageableDefault(page = 0, size = 5)
                                                                    Pageable pageable) {
        logger.trace(request.getMethod().toUpperCase() + " " +
                             request.getRequestURI() + " accessed");

        List<User> u = userService.findByNotesContainingIgnoreCase(notes, pageable);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    // http://localhost:2019/users/getusername
    @GetMapping(value = "/getusername",
            produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> getCurrentUserName(HttpServletRequest request,
                                                Authentication authentication) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        return new ResponseEntity<>(authentication.getPrincipal(),
                                    HttpStatus.OK);
    }

    // http://localhost:2019/users/getuserinfo
    @GetMapping(value = "/getuserinfo",
            produces = {"application/json"})
    public ResponseEntity<?> getCurrentUserInfo(HttpServletRequest request,
                                                Authentication authentication) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        User u = userService.findByName(authentication.getName());
        return new ResponseEntity<>(u,
                                    HttpStatus.OK);
    }

    //        {
    //            "username": "Mojo",
    //            "primaryemail": "mojo@lambdaschool.local",
    //            "password" : "Coffee123",
    //            "useremails": [
    //            {
    //                "useremail": "mojo@mymail.local"
    //            },
    //            {
    //                "useremail": "mojo@mymail.local"
    //            },
    //            {
    //                "useremail": "mojo@email.local"
    //            }
    //        ]
    //        }
    // http://localhost:2019/users/user
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/user",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewUser(HttpServletRequest request,
                                        @Valid
                                        @RequestBody
                                                User newuser) throws
            URISyntaxException {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newuser = userService.save(newuser);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                    .path("/{userid}")
                                                    .buildAndExpand(newuser.getUserid())
                                                    .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }


//        {
//            "userid": 7,
//                "username": "cinnamon",
//                "primaryemail": "cinnamon@lambdaschool.home",
//                "useremails": [
//            {
//                    "useremail": "cinnamon@mymail.local"
//            },
//            {
//                    "useremail": "hops@mymail.local"
//            },
//            {
//                    "useremail": "bunny@email.local"
//            }
//        ]
//        }
    // http://localhost:2019/users/user/7
    @PutMapping(value = "/user/{id}")
    public ResponseEntity<?> updateUser(HttpServletRequest request,
                                        @RequestBody
                                                User updateUser,
                                        @PathVariable
                                                long id) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        userService.update(updateUser,
                           id,
                           request.isUserInRole("ADMIN"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:2019/users/user/14/creditApproved
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(value = "/user/{id}/creditApproved")
    public ResponseEntity<?> updateUserCreditApproved(HttpServletRequest request,
                                                 @PathVariable long id) {

        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        userService.updateUserCreditApproved(id, request.isUserInRole("ADMIN"));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:2019/users/user/14
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(HttpServletRequest request,
                                            @PathVariable
                                                    long id) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:2019/users/user/15/role/2
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/user/{userid}/role/{roleid}")
    public ResponseEntity<?> deleteUserRoleByIds(HttpServletRequest request,
                                                 @PathVariable
                                                         long userid,
                                                 @PathVariable
                                                         long roleid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        userService.deleteUserRole(userid,
                                   roleid);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    // http://localhost:2019/users/user/15/role/2
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/user/{userid}/role/{roleid}")
    public ResponseEntity<?> postUserRoleByIds(HttpServletRequest request,
                                               @PathVariable
                                                       long userid,
                                               @PathVariable
                                                       long roleid) {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        userService.addUserRole(userid,
                                roleid);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
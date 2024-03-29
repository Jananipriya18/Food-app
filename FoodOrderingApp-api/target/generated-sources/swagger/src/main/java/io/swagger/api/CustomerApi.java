/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.LoginResponse;
import io.swagger.model.LogoutResponse;
import io.swagger.model.SignupCustomerRequest;
import io.swagger.model.SignupCustomerResponse;
import io.swagger.model.UpdateCustomerRequest;
import io.swagger.model.UpdateCustomerResponse;
import io.swagger.model.UpdatePasswordRequest;
import io.swagger.model.UpdatePasswordResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-10-11T19:45:20.154+05:30")

@Api(value = "customer", description = "the customer API")
public interface CustomerApi {

    @ApiOperation(value = "login", nickname = "login", notes = "Each customer logs into FoodOrderingApp application using their contactNumber and password as credentials. ", response = LoginResponse.class, authorizations = {
        @Authorization(value = "BasicAuthorization")
    }, tags={ "API#001 Authentication", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK - Authenticated successfully", response = LoginResponse.class),
        @ApiResponse(code = 400, message = "BAD REQUEST - server cannot or will not process the request due to something that is perceived to be a client error (e.g., malformed request syntax, mandatory elements are missing)"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED - customer has provided wrong credentials"),
        @ApiResponse(code = 403, message = "FORBIDDEN - request has not been applied because client application has no permission to perform action"),
        @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR - server encountered an unexpected condition that prevented it from fulfilling the request.") })
    @RequestMapping(value = "/customer/login",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<LoginResponse> login(@ApiParam(value = "Mandatory customer credentials in Base64 encoded format." ,required=true) @RequestHeader(value="authorization", required=true) String authorization);


    @ApiOperation(value = "logout", nickname = "logout", notes = "Customer logs out of the FoodOrderingApp application. ", response = LogoutResponse.class, authorizations = {
        @Authorization(value = "BearerAuthorization")
    }, tags={ "API#001 Authentication", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK - Logged out successfully", response = LogoutResponse.class),
        @ApiResponse(code = 400, message = "BAD REQUEST - server cannot or will not process the request due to something that is perceived to be a client error (e.g., malformed request syntax, mandatory elements are missing)"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED - customer has provided wrong credentials"),
        @ApiResponse(code = 403, message = "FORBIDDEN - request has not been applied because client application has no permission to perform action"),
        @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR - server encountered an unexpected condition that prevented it from fulfilling the request.") })
    @RequestMapping(value = "/customer/logout",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<LogoutResponse> logout(@ApiParam(value = "Mandatory customer credentials in bearer http authentication scheme format." ,required=true) @RequestHeader(value="authorization", required=true) String authorization);


    @ApiOperation(value = "signup", nickname = "registerCustomer", notes = "Each customer who needs access to FoodOrderingApp application should signup using their valid contact number, email and set a password for an authorized access. ", response = SignupCustomerResponse.class, tags={ "API#001 Customer Sign up", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "CREATED - Customer has been signed up successfully", response = SignupCustomerResponse.class),
        @ApiResponse(code = 400, message = "BAD REQUEST - server cannot or will not process the request due to something that is perceived to be a client error (e.g., malformed request syntax, mandatory elements are missing)"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED - customer has provided wrong credentials"),
        @ApiResponse(code = 403, message = "FORBIDDEN - request has not been applied because client application has no permission to perform action"),
        @ApiResponse(code = 422, message = "UNPROCESSABLE ENTITY - request was well-formed but server unable to process due to semantic errors"),
        @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR - server encountered an unexpected condition that prevented it from fulfilling the request.") })
    @RequestMapping(value = "/customer/signup",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<SignupCustomerResponse> registerCustomer(@ApiParam(value = "Request containing customer signup information" ,required=true )  @Valid @RequestBody SignupCustomerRequest signupCustomerRequest);


    @ApiOperation(value = "Update Customer Details", nickname = "updateCustomerDetails", notes = "Customers can update their name using this endpoint with authorization. ", response = UpdateCustomerResponse.class, authorizations = {
        @Authorization(value = "BearerAuthorization")
    }, tags={ "API#001 Update Customer Details", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "UPDATED - Customer details have been updated successfully", response = UpdateCustomerResponse.class),
        @ApiResponse(code = 400, message = "BAD REQUEST - server cannot or will not process the request due to something that is perceived to be a client error (e.g., malformed request syntax, mandatory elements are missing)"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED - customer has provided wrong credentials"),
        @ApiResponse(code = 403, message = "FORBIDDEN - request has not been applied because client application has no permission to perform action"),
        @ApiResponse(code = 422, message = "UNPROCESSABLE ENTITY - request was well-formed but server unable to process due to semantic errors"),
        @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR - server encountered an unexpected condition that prevented it from fulfilling the request.") })
    @RequestMapping(value = "/customer",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<UpdateCustomerResponse> updateCustomerDetails(@ApiParam(value = "Mandatory customer credentials in bearer http authentication scheme format." ,required=true) @RequestHeader(value="authorization", required=true) String authorization,@ApiParam(value = "Request containing customer update information" ,required=true )  @Valid @RequestBody UpdateCustomerRequest updateCustomerRequest);


    @ApiOperation(value = "Update Customer Password", nickname = "updateCustomerPassword", notes = "Customers can update their password using this endpoint with authorization. ", response = UpdatePasswordResponse.class, authorizations = {
        @Authorization(value = "BearerAuthorization")
    }, tags={ "API#001 Update Customer Password", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "UPDATED - Customer password has been updated successfully", response = UpdatePasswordResponse.class),
        @ApiResponse(code = 400, message = "BAD REQUEST - server cannot or will not process the request due to something that is perceived to be a client error (e.g., malformed request syntax, mandatory elements are missing)"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED - customer has provided wrong credentials"),
        @ApiResponse(code = 403, message = "FORBIDDEN - request has not been applied because client application has no permission to perform action"),
        @ApiResponse(code = 422, message = "UNPROCESSABLE ENTITY - request was well-formed but server unable to process due to semantic errors"),
        @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR - server encountered an unexpected condition that prevented it from fulfilling the request.") })
    @RequestMapping(value = "/customer/password",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<UpdatePasswordResponse> updateCustomerPassword(@ApiParam(value = "Mandatory customer credentials in bearer http authentication scheme format." ,required=true) @RequestHeader(value="authorization", required=true) String authorization,@ApiParam(value = "Request containing customer password update information" ,required=true )  @Valid @RequestBody UpdatePasswordRequest updatePasswordRequest);

}

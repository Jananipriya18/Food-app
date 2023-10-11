package io.swagger.api;

import io.swagger.model.LoginResponse;
import io.swagger.model.LogoutResponse;
import io.swagger.model.SignupCustomerRequest;
import io.swagger.model.SignupCustomerResponse;
import io.swagger.model.UpdateCustomerRequest;
import io.swagger.model.UpdateCustomerResponse;
import io.swagger.model.UpdatePasswordRequest;
import io.swagger.model.UpdatePasswordResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-10-11T19:45:20.154+05:30")

@Controller
public class CustomerApiController implements CustomerApi {

    private static final Logger log = LoggerFactory.getLogger(CustomerApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CustomerApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<LoginResponse> login(@ApiParam(value = "Mandatory customer credentials in Base64 encoded format." ,required=true) @RequestHeader(value="authorization", required=true) String authorization) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<LoginResponse>(objectMapper.readValue("{  \"email_address\" : \"email_address\",  \"last_name\" : \"last_name\",  \"id\" : \"id\",  \"message\" : \"message\",  \"first_name\" : \"first_name\",  \"contact_number\" : \"contact_number\"}", LoginResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<LoginResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<LoginResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<LogoutResponse> logout(@ApiParam(value = "Mandatory customer credentials in bearer http authentication scheme format." ,required=true) @RequestHeader(value="authorization", required=true) String authorization) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<LogoutResponse>(objectMapper.readValue("{  \"id\" : \"id\",  \"message\" : \"message\"}", LogoutResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<LogoutResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<LogoutResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SignupCustomerResponse> registerCustomer(@ApiParam(value = "Request containing customer signup information" ,required=true )  @Valid @RequestBody SignupCustomerRequest signupCustomerRequest) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SignupCustomerResponse>(objectMapper.readValue("{  \"id\" : \"2ddf4646-ecd0-11e8-8eb2-f2801f1b9fd1\",  \"status\" : \"USER SUCCESSFULLY REGISTERED\"}", SignupCustomerResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SignupCustomerResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SignupCustomerResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UpdateCustomerResponse> updateCustomerDetails(@ApiParam(value = "Mandatory customer credentials in bearer http authentication scheme format." ,required=true) @RequestHeader(value="authorization", required=true) String authorization,@ApiParam(value = "Request containing customer update information" ,required=true )  @Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UpdateCustomerResponse>(objectMapper.readValue("{  \"id\" : \"2ddf4646-ecd0-11e8-8eb2-f2801f1b9fd1\",  \"status\" : \"USER DETAILS SUCCESSFULLY UPDATED\"}", UpdateCustomerResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UpdateCustomerResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UpdateCustomerResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UpdatePasswordResponse> updateCustomerPassword(@ApiParam(value = "Mandatory customer credentials in bearer http authentication scheme format." ,required=true) @RequestHeader(value="authorization", required=true) String authorization,@ApiParam(value = "Request containing customer password update information" ,required=true )  @Valid @RequestBody UpdatePasswordRequest updatePasswordRequest) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UpdatePasswordResponse>(objectMapper.readValue("{  \"id\" : \"2ddf4646-ecd0-11e8-8eb2-f2801f1b9fd1\",  \"status\" : \"USER PASSWORD SUCCESSFULLY UPDATED\"}", UpdatePasswordResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UpdatePasswordResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UpdatePasswordResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}

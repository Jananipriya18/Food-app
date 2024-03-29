package com.upgrad.FoodOrderingApp.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.upgrad.FoodOrderingApp.api.model.ErrorResponse;
import com.upgrad.FoodOrderingApp.service.exception.AddressNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.AuthenticationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.AuthorizationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.CategoryNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.CouponNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.InvalidRatingException;
import com.upgrad.FoodOrderingApp.service.exception.ItemNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.PaymentMethodNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.RestaurantNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.SaveAddressException;
import com.upgrad.FoodOrderingApp.service.exception.SignUpRestrictedException;
import com.upgrad.FoodOrderingApp.service.exception.UpdateCustomerException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(SignUpRestrictedException.class)
    public ResponseEntity<ErrorResponse> signUpRestrictedException(SignUpRestrictedException exc, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getCode());
        errorResponse.setMessage(exc.getErrorMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<ErrorResponse> authenticationFailedException(AuthenticationFailedException exc, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getCode());
        errorResponse.setMessage(exc.getErrorMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UpdateCustomerException.class)
    public ResponseEntity<ErrorResponse> updateCustomerException(UpdateCustomerException exc, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getCode());
        errorResponse.setMessage(exc.getErrorMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SaveAddressException.class)
    public ResponseEntity<ErrorResponse> saveAddressException(SaveAddressException exc, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getCode());
        errorResponse.setMessage(exc.getErrorMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorResponse> addressNotFoundException(AddressNotFoundException exc, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getCode());
        errorResponse.setMessage(exc.getErrorMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthorizationFailedException.class)
    public ResponseEntity<ErrorResponse> authorizationFailedException(AuthorizationFailedException exc, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getCode());
        errorResponse.setMessage(exc.getErrorMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<ErrorResponse> restaurantNotFoundException(RestaurantNotFoundException exc, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getCode());
        errorResponse.setMessage(exc.getErrorMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> categoryNotFoundException(CategoryNotFoundException exc, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getCode());
        errorResponse.setMessage(exc.getErrorMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRatingException.class)
    public ResponseEntity<ErrorResponse> invalidRatingException(InvalidRatingException exc, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getCode());
        errorResponse.setMessage(exc.getErrorMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CouponNotFoundException.class)
    public ResponseEntity<ErrorResponse> couponNotFoundException(CouponNotFoundException exc, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getCode());
        errorResponse.setMessage(exc.getErrorMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymentMethodNotFoundException.class)
    public ResponseEntity<ErrorResponse> paymentMethodNotFoundException(PaymentMethodNotFoundException exc, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getCode());
        errorResponse.setMessage(exc.getErrorMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> itemNotFoundException(ItemNotFoundException exc, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(exc.getCode());
        errorResponse.setMessage(exc.getErrorMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}

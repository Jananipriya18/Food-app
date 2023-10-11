package com.upgrad.FoodOrderingApp.api.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.FoodOrderingApp.api.model.CouponDetailsResponse;
import com.upgrad.FoodOrderingApp.api.model.CustomerOrderResponse;
import com.upgrad.FoodOrderingApp.api.model.ItemQuantity;
import com.upgrad.FoodOrderingApp.api.model.ItemQuantityResponse;
import com.upgrad.FoodOrderingApp.api.model.ItemQuantityResponseItem;
import com.upgrad.FoodOrderingApp.api.model.OrderList;
import com.upgrad.FoodOrderingApp.api.model.OrderListAddress;
import com.upgrad.FoodOrderingApp.api.model.OrderListAddressState;
import com.upgrad.FoodOrderingApp.api.model.OrderListCoupon;
import com.upgrad.FoodOrderingApp.api.model.OrderListCustomer;
import com.upgrad.FoodOrderingApp.api.model.OrderListPayment;
import com.upgrad.FoodOrderingApp.api.model.SaveOrderRequest;
import com.upgrad.FoodOrderingApp.api.model.SaveOrderResponse;
import com.upgrad.FoodOrderingApp.service.businness.AddressService;
import com.upgrad.FoodOrderingApp.service.businness.CustomerService;
import com.upgrad.FoodOrderingApp.service.businness.ItemService;
import com.upgrad.FoodOrderingApp.service.businness.OrderService;
import com.upgrad.FoodOrderingApp.service.businness.PaymentService;
import com.upgrad.FoodOrderingApp.service.businness.RestaurantService;
import com.upgrad.FoodOrderingApp.service.entity.AddressEntity;
import com.upgrad.FoodOrderingApp.service.entity.CouponEntity;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import com.upgrad.FoodOrderingApp.service.entity.ItemEntity;
import com.upgrad.FoodOrderingApp.service.entity.OrderItemEntity;
import com.upgrad.FoodOrderingApp.service.entity.OrdersEntity;
import com.upgrad.FoodOrderingApp.service.entity.PaymentEntity;
import com.upgrad.FoodOrderingApp.service.entity.RestaurantEntity;
import com.upgrad.FoodOrderingApp.service.exception.AddressNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.AuthorizationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.CouponNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.ItemNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.PaymentMethodNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.RestaurantNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    AddressService addressService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    ItemService itemService;

    @RequestMapping(method = RequestMethod.GET, path = "/coupon/{coupon_name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CouponDetailsResponse> getCouponByCouponName(
            @RequestHeader(value = "authorization") final String authorization,
            @PathVariable(value = "coupon_name") final String couponName)
            throws AuthorizationFailedException, CouponNotFoundException {

        String accessToken = authorization.split("Bearer ")[1];

        CustomerEntity customerEntity = customerService.getCustomer(accessToken);
        CouponEntity couponEntity = orderService.getCouponByCouponName(couponName);

        CouponDetailsResponse couponDetailsResponse = new CouponDetailsResponse();
        couponDetailsResponse.setCouponName(couponEntity.getCouponName());
        couponDetailsResponse.setId(UUID.fromString(couponEntity.getUuid()));
        couponDetailsResponse.setPercent(new BigDecimal(couponEntity.getPercent()));

        return new ResponseEntity<>(couponDetailsResponse, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SaveOrderResponse> saveOrder(@RequestHeader(value = "authorization") final String authorization,
            @RequestBody(required = false) final SaveOrderRequest saveOrderRequest)
            throws AuthorizationFailedException, PaymentMethodNotFoundException, AddressNotFoundException,
            RestaurantNotFoundException, CouponNotFoundException, ItemNotFoundException {

        String accessToken = authorization.split("Bearer ")[1];
        CustomerEntity customerEntity = customerService.getCustomer(accessToken);
        CouponEntity couponEntity = orderService.getCouponByCouponId(saveOrderRequest.getCouponId().toString());
        PaymentEntity paymentEntity = paymentService.getPaymentByUUID(saveOrderRequest.getPaymentId().toString());
        AddressEntity addressEntity = addressService.getAddressByUUID(saveOrderRequest.getAddressId(),
                customerEntity);
        RestaurantEntity restaurantEntity = restaurantService.restaurantByUUID(saveOrderRequest.getRestaurantId()
                .toString());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setUuid(UUID.randomUUID().toString());
        ordersEntity.setBill(saveOrderRequest.getBill().doubleValue());
        ordersEntity.setDate(timestamp);
        ordersEntity.setCustomer(customerEntity);
        ordersEntity.setDiscount(saveOrderRequest.getDiscount().doubleValue());
        ordersEntity.setPayment(paymentEntity);
        ordersEntity.setAddress(addressEntity);
        ordersEntity.setRestaurant(restaurantEntity);
        ordersEntity.setCoupon(couponEntity);

        OrdersEntity savedOrderEntity = orderService.saveOrder(ordersEntity);

        List<ItemQuantity> itemQuantities = saveOrderRequest.getItemQuantities();
        for (ItemQuantity itemQuantity : itemQuantities) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            ItemEntity itemEntity = itemService.getItemByUUID(itemQuantity.getItemId().toString());
            orderItemEntity.setItem(itemEntity);
            orderItemEntity.setOrder(ordersEntity);
            orderItemEntity.setPrice(itemQuantity.getPrice());
            orderItemEntity.setQuantity(itemQuantity.getQuantity());

            OrderItemEntity savedOrderItem = orderService.saveOrderItem(orderItemEntity);
        }

        SaveOrderResponse saveOrderResponse = new SaveOrderResponse();
        saveOrderResponse.setId(savedOrderEntity.getUuid());
        saveOrderResponse.setStatus("ORDER SUCCESSFULLY PLACED");
        return new ResponseEntity<>(saveOrderResponse, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CustomerOrderResponse> getPastOrderOfUser(
            @RequestHeader(value = "authorization") final String authorization)
            throws AuthorizationFailedException {

        String accessToken = authorization.split("Bearer ")[1];
        CustomerEntity customerEntity = customerService.getCustomer(accessToken);
        List<OrdersEntity> ordersEntities = orderService.getOrdersByCustomers(customerEntity.getUuid());

        List<OrderList> orderLists = new LinkedList<>();
        if (ordersEntities != null) {
            for (OrdersEntity ordersEntity : ordersEntities) {
                List<OrderItemEntity> orderItemEntities = orderService.getOrderItemsByOrder(ordersEntity);

                List<ItemQuantityResponse> itemQuantityResponseList = new LinkedList<>();
                orderItemEntities.forEach(orderItemEntity -> {
                    ItemQuantityResponseItem itemQuantityResponseItem = new ItemQuantityResponseItem();
                    itemQuantityResponseItem.setItemName(orderItemEntity.getItem().getItemName());
                    itemQuantityResponseItem.setItemPrice(orderItemEntity.getItem().getPrice());
                    itemQuantityResponseItem.setId(UUID.fromString(orderItemEntity.getItem().getUuid()));
                    itemQuantityResponseItem
                            .setType(ItemQuantityResponseItem.TypeEnum.valueOf(orderItemEntity.getItem().getType()
                                    .getValue()));

                    ItemQuantityResponse itemQuantityResponse = new ItemQuantityResponse();
                    itemQuantityResponse.setItem(itemQuantityResponseItem);
                    itemQuantityResponse.setQuantity(orderItemEntity.getQuantity());
                    itemQuantityResponse.setPrice(orderItemEntity.getPrice());
                    itemQuantityResponseList.add(itemQuantityResponse);
                }

                OrderListAddressState orderListAddressState = new OrderListAddressState();
                orderListAddressState.setId(UUID.fromString(ordersEntity.getAddress().getState().getStateUuid()));
                orderListAddressState.setStateName(ordersEntity.getAddress().getState().getStateName());

                OrderListAddress orderListAddress = new OrderListAddress();
                orderListAddress.setId(UUID.fromString(ordersEntity.getAddress().getUuid()));
                orderListAddress.setFlatBuildingName(ordersEntity.getAddress().getFlatBuilNo());
                orderListAddress.setLocality(ordersEntity.getAddress().getLocality());
                orderListAddress.setCity(ordersEntity.getAddress().getCity());
                orderListAddress.setPincode(ordersEntity.getAddress().getPincode());
                orderListAddress.setState(orderListAddressState);

                OrderListCoupon orderListCoupon = new OrderListCoupon();
                orderListCoupon.setCouponName(ordersEntity.getCoupon().getCouponName());
                orderListCoupon.setId(UUID.fromString(ordersEntity.getCoupon().getUuid()));
                orderListCoupon.setPercent(ordersEntity.getCoupon().getPercent());

                OrderListCustomer orderListCustomer = new OrderListCustomer();
                orderListCustomer.setId(UUID.fromString(ordersEntity.getCustomer().getUuid()));
                orderListCustomer.setFirstName(ordersEntity.getCustomer().getFirstName());
                orderListCustomer.setLastName(ordersEntity.getCustomer().getLastName());
                orderListCustomer.setEmailAddress(ordersEntity.getCustomer().getEmail());
                orderListCustomer.setContactNumber(ordersEntity.getCustomer().getContactNumber());

                OrderListPayment orderListPayment = new OrderListPayment();
                orderListPayment.setId(UUID.fromString(ordersEntity.getPayment().getUuid()));
                orderListPayment.setPaymentName(ordersEntity.getPayment().getPaymentName());

                OrderList orderList = new OrderList();
                orderList.setId(UUID.fromString(ordersEntity.getUuid()));
                orderList.setItemQuantities(itemQuantityResponseList);
                orderList.setAddress(orderListAddress);
                orderList.setBill(BigDecimal.valueOf(ordersEntity.getBill()));
                orderList.setDate(String.valueOf(ordersEntity.getDate()));
                orderList.setDiscount(BigDecimal.valueOf(ordersEntity.getDiscount()));
                orderList.setCoupon(orderListCoupon);
                orderList.setCustomer(orderListCustomer);
                orderList.setPayment(orderListPayment);
                orderLists.add(orderList);
            }

            CustomerOrderResponse customerOrderResponse = new CustomerOrderResponse();
            customerOrderResponse.setOrders(orderLists);
            return new ResponseEntity<>(customerOrderResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomerOrderResponse(), HttpStatus.OK);
        }
    }
}

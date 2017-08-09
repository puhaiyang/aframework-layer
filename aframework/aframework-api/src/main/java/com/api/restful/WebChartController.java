/******************************************************************
 *
 *    Java Lib For Web, Powered By Alvis.Yu.
 *
 *    Copyright (c) 2001-2017 Alvis.Yu Co.,Ltd
 *    http://yu.alvis.com/
 *
 *    Package:     com.controller.restfulapi
 *
 *    Filename:    WebChartController.java
 *
 *    Description: TODO
 *
 *    Copyright:   Copyright (c) 2001-2017
 *
 *    Company:     Alvis.Yu Co.,Ltd
 *
 *    @author: dell
 *
 *    @version: 1.0.0
 *
 *    Create at:   Jul 27, 2017 9:58:49 AM
 *
 *    Revision:
 *
 *    Jul 27, 2017 9:58:49 AM
 *        - first revision
 *
 *****************************************************************/
package com.api.restful;

import java.util.List;
import java.util.Map;


import com.api.configurer.ApiConstant;
import com.api.configurer.Authorization;
import com.api.model.CustomerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.customers.Customer;
import com.service.customers.ICustomerService;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Alvis
 * @version 1.0.0
 * @ClassName WebChartController
 * @Description TODO
 * @Date Jul 27, 2017 9:58:49 AM
 */
@RestController
@RequestMapping("/api/webchart")
public class WebChartController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    HttpServletRequest request;

    @Authorization
    @PostMapping("/list")
    public CustomerResult GetAllCustomer(Integer age) {
        CustomerResult customerResult = new CustomerResult(1);
        List<Customer> customers = customerService.getCustomers();
        customerResult.setCustomerList(customers);
        Customer user = (Customer) request.getAttribute(ApiConstant.UserKey);
        return customerResult;
    }


}
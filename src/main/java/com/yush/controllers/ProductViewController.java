package com.yush.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductViewController {
    private static final Logger LOG = Logger.getLogger(MainWebController.class);

@RequestMapping("/productview")
public String productView () {
    LOG.debug("productView");

    return "productView";
}
}

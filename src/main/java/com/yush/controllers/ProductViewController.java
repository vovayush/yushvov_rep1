package com.yush.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductViewController {
    private static final Logger LOG = Logger.getLogger(MainWebController.class);

    @RequestMapping("/productview")
    public ModelAndView productView() {
        LOG.debug("productView");
        ModelAndView modelAndView = new ModelAndView("productView");
        return modelAndView;
    }
}

package com.aquoco.starthere.controllers;

import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.services.MailClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * mailclass table fields: mcid, mailclass, description
 */
@Loggable
@RestController
@RequestMapping("/mailclasses")
public class MailClassController {
    private static final Logger logger = LoggerFactory.getLogger(MailClassController.class);

    @Autowired
    private MailClassService mcService;

    
}

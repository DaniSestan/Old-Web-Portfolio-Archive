/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package com.daniasestan.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.daniasestan.business.service.EmailService;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Locale;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class SendingController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/sendmessage", method = POST)
    public String sendmessage(
            @RequestParam("sender-name") final String recipientName,
            @RequestParam("email") final String recipientEmail,
            @RequestParam("body") final String body,
            final Locale locale)
            throws MessagingException, IOException {

        this.emailService.sendEditableEmail(
                recipientName, recipientEmail, body, locale);
        return "redirect:sendmessage.html";
    }
}

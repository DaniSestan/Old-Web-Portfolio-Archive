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
package com.daniasestan.business.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.daniasestan.business.SpringMailConfig;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@Service
public class EmailService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine stringTemplateEngine;

    public void sendEditableEmail(
            final String senderName, final String senderEmail, final String htmlContent,
            final Locale locale)
            throws MessagingException {

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message
                = new MimeMessageHelper(mimeMessage, true /* multipart */, "UTF-8");
        message.setSubject("Example editable HTML email");
//        message.setFrom(senderEmail);
        message.setTo("dsestancontact@gmail.com");
        message.setReplyTo(senderEmail);
        // Prepare the evaluation context
        final Context ctx = new Context(locale);
//        ctx.setVariable("name", senderName);
//        ctx.setVariable("subscriptionDate", new Date());
//        ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));

        // Create the HTML body using Thymeleaf
//        include sender info, append to message output
//        try to create separate str val for this, or concat sender info as strings to output val
        final String senderInfo = "Sender Name: " + senderName + "\n" + " Sender Email: " + senderEmail;
        final String output = senderInfo + "\n" + stringTemplateEngine.process(htmlContent, ctx);
        message.setText(output, true /* isHtml */);

        // Send mail
        this.mailSender.send(mimeMessage);
    }


}

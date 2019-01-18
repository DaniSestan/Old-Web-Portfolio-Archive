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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.daniasestan.business.service.EmailService;

import java.io.IOException;
import java.util.Map;

@Controller
public class MainController {

    @RequestMapping("/")
    public String indexPage(Map<String, Object> model) {
//		model.put("message", this.message);
        return "index";
    }

    @RequestMapping("/checkmate-automation")
    public String checkmateautomationpage(Map<String, Object> model) {
        return "project-checkmate-automation";
    }

    @RequestMapping("/checkmate-web")
    public String checkmatewebpage (Map<String, Object> model) {
        return "project-checkmate-web";
    }

    @RequestMapping("/web-dev")
    public String webdevpage (Map<String, Object> model) {
        return "project-web-dev";
    }

//    @RequestMapping(value="/resume", method=RequestMethod.GET)
//    public ResponseEntity<byte[]> getPDF1() throws IOException {
//
////        ClassPathResource pdfFile = new ClassPathResource("Dania-Sestan_Resume.pdf");
////        InputStreamResource resumeBytes = new InputStreamResource(pdfFile.getInputStream());
//
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setContentType(MediaType.parseMediaType("application/pdf"));
//        String filename = "Dania-Sestan_Resume.pdf";
//
//        headers.add("content-disposition", "inline;filename=" + filename);
//
//        headers.setContentDispositionFormData(filename, filename);
//        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(headers, HttpStatus.OK);
//        return response;
//    }

    /*

    @RequestMapping(value = "/generatePdf/{id}", method = RequestMethod.GET)
    @ResponseBody
    public final void generateWithResponseBody(@PathVariable("id") final int idBulletin
            ,final HttpServletRequest httpRequete, final HttpServletResponse reponse) throws ApplicationException
    {
        //Here retrieve your PDF file
        if(file != null) {
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                logger.debug("mimetype is not detectable, will take default");
                mimeType = "application/pdf";
            }
            logger.debug("mimetype : {}", mimeType);
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
            response.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
    }
     */
    @RequestMapping(value = "/resume", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<InputStreamResource> downloadPDFFile()
            throws IOException {

        ClassPathResource pdfFile = new ClassPathResource("Dania-Sestan_Resume.pdf");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(pdfFile.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(pdfFile.getInputStream()));
    }

    @Autowired
    private EmailService emailService;

    /* Sending confirmation page. */
    @RequestMapping(value = "/sendmessage", method = RequestMethod.GET)
//    @RequestMapping(value = "/sendmessage, /sendmessage/", method = RequestMethod.GET)
//    edit in the index template, form
    public String sendmessage() {
        return "sendmessage";
    }
}

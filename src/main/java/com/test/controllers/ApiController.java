package com.test.controllers;

import com.test.pojos.LanguageResponse;
import com.test.pojos.Response;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.test.services.AppService;
import java.util.UUID;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AppService appService;

    @RequestMapping(value = "/{applicationName}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response<LanguageResponse>>
            getLanguageServicesByApplicationName(
                    @PathVariable("applicationName") String applicationName) throws Exception {
        final String uuid = UUID.randomUUID().toString();
        final Response<LanguageResponse> response = new Response();
        response.setUuid(uuid);
        final LanguageResponse result = appService.findByApplicationName(
                applicationName, uuid);
        response.setData(result);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}

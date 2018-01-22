package com.test.services;

import com.test.pojos.ApplicationLang;
import com.test.pojos.Language;
import com.test.pojos.LanguageResponse;
import com.test.pojos.LanguageText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppService.class);

    public LanguageResponse findByApplicationName(final String applicationName,
            final String uuid) {
        LOGGER.info("UUID [{}] - Start of findByApplicationName for "
                + "Application [{}]", uuid, applicationName);
        //whatever
        final LanguageResponse response = new LanguageResponse();
        response.put(applicationName, new ApplicationLang());
        response.get(applicationName).put("en", new Language());
        response.get(applicationName).get("en").put("HELLO", new LanguageText());
        response.get(applicationName).get("en").get("HELLO").setText("Hello, World");
        LOGGER.info("UUID [{}] - End of findByApplicationName for Application "
                + "[{}]", uuid, applicationName);
        return response;
    }

}

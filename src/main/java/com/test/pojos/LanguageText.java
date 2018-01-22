package com.test.pojos;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageText implements Serializable {

    @JsonProperty("TEXT")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

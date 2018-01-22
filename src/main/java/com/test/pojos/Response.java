package com.test.pojos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> {

    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("data")
    private T data;
    @JsonProperty("errors")
    private List<String> errors;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(final List<String> errors) {
        this.errors = errors;
    }
}

package com.devsenior.acaycedo.http.response.dto;

public class SumaResponse {
    private Boolean isError;
    private String message;
    private Integer value;

    public SumaResponse(Integer value) {
        this.value = value;
        this.isError = false;
    }

    public SumaResponse(String message) {
        this.isError = false;
        this.message = message;
    }

    public Boolean getIsError() {
        return isError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public SumaResponse(Boolean isError, String message, Integer value) {
        this.isError = isError;
        this.message = message;
        this.value = value;
    }

    public static SumaResponseBuilder builder() {
        return new SumaResponseBuilder();
    }

    public static class SumaResponseBuilder {
        private Boolean isError = null;
        private String message = null;
        private Integer value = null;

        public SumaResponseBuilder isError(Boolean isError) {
            this.isError = isError;
            return this;
        }

        public SumaResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public SumaResponseBuilder value(Integer value) {
            this.value = value;
            return this;
        }

        public SumaResponse build() {
            return new SumaResponse(isError, message, value);
        }
    }

}

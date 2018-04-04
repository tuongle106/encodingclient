package com.linecorp.sample.login.application.controller;

/**
 * @author tuong.le on 4/4/18.
 */
public class EncodingResult {
    private AddMediaResponse result;

    public AddMediaResponse getResult() {
        return result;
    }

    public void setResult(AddMediaResponse result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "EncodingResult{" +
                "result=" + result +
                '}';
    }
}

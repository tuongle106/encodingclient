package com.linecorp.sample.login.application.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class AddMediaResponse {
    private String mediaid;
    private String source;
    private String status;
    private String description;
    private String taskId;
    
    @JsonProperty("output_params")
    private String outputParams;
    
    private Map<String, Object> format;

    public String getMediaid() {
        return mediaid;
    }

    public void setMediaid(String mediaid) {
        this.mediaid = mediaid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getOutputParams() {
        return outputParams;
    }

    public void setOutputParams(String outputParams) {
        this.outputParams = outputParams;
    }

    public Map<String, Object> getFormat() {
        return format;
    }

    public void setFormat(Map<String, Object> format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "AddMediaResponse{" +
                "mediaid='" + mediaid + '\'' +
                ", source='" + source + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", taskId='" + taskId + '\'' +
                ", outputParams='" + outputParams + '\'' +
                ", format=" + format +
                '}';
    }
}

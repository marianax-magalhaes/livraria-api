package com.livrariaapi.exceptions;

import lombok.Data;

@Data
public class StandardError {
    private Long timestamp;
    private Integer status;
    private String error;

    public StandardError() {
    }

    public StandardError(Long timestamp, Integer status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }
}

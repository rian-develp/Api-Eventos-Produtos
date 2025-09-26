package br.com.productseventsapi.ProductEventApi.response;

import java.time.LocalDateTime;

public class ResponseBodyError {
    private final String status;
    private final LocalDateTime timestamp;
    private final String errorMessage;
    private final int code;

    public ResponseBodyError(int code, String status, LocalDateTime timestamp, String errorMessage) {
        this.code = code;
        this.status = status;
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

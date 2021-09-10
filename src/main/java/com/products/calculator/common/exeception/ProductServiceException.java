package com.products.calculator.common.exeception;

public class ProductServiceException extends RuntimeException {

    public ProductServiceException(String message) {
        super(message);
    }

    protected ProductServiceException() {
    }

    public ProductServiceException(Throwable throwable) {
        super(throwable);
    }

    public ProductServiceException(String message, Throwable e) {
        super(message, e);
    }
}

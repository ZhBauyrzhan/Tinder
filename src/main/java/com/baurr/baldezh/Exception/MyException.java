package com.baurr.baldezh.Exception;

public class MyException extends RuntimeException{
    public MyException() {
        super();
    }
    public MyException(String message) {
        super(message);
    }
    public MyException(String message, Throwable throwable) {
        super(message,throwable);
    }
}

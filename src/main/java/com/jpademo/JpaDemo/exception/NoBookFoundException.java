package com.jpademo.JpaDemo.exception;

public class NoBookFoundException extends Exception{
    public NoBookFoundException(String msg){
        super(msg);
    }
}

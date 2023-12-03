package com.jpademo.JpaDemo.exception;

public class WrongDataException extends Exception {
    public WrongDataException(String msg){
        super(msg);
    }
}

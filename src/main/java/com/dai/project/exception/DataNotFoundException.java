package com.dai.project.exception;

public class DataNotFoundException extends RuntimeException {

    private String dataType;

    public DataNotFoundException(String dataType) {
        super("Can't find data type object:"+ dataType);
    }

    @Override
    public String toString() {
        return "DataNotFoundException{" +
                this.getMessage() + '\'' +
                '}';
    }
}

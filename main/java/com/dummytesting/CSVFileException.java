package com.dummytesting;

public class CSVFileException extends Exception{
    enum ExceptionType{
        NO_SUCHFILE,NO_OPTIONS;
    }
    ExceptionType type;

    public CSVFileException(String message, ExceptionType type) {
        super(message);
        this.type= type;
    }
    public CSVFileException(ExceptionType type, Throwable cause) {
        super(cause);
        this.type= type;
    }
}

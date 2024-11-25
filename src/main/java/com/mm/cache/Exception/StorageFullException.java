package com.mm.cache.Exception;

public class StorageFullException extends RuntimeException {
    public StorageFullException(String message){
        super(message);
    }
}

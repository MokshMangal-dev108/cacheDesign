package com.mm.cache.storage;

import com.mm.cache.Exception.NotFoundException;
import com.mm.cache.Exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key,Value> implements Storage<Key,Value>{

    Map<Key,Value> storage;
    private final Integer capacity;

    public HashMapBasedStorage(Integer capacity){
        this.capacity=capacity;
        storage = new HashMap<>();
    }

    private boolean isStorageFull(){
        return storage.size()== capacity;
    }

    @Override
    public void add(Key key, Value value) {
        if(isStorageFull())throw new StorageFullException("Storage is full");
        storage.put(key,value);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if(!storage.containsKey(key))throw new NotFoundException(key+" Element is not found in Map");
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if(!storage.containsKey(key))throw new NotFoundException(key+" Element is not present in Map");
        return storage.get(key);
    }

}

package com.mm.cache;

import com.mm.cache.Exception.NotFoundException;
import com.mm.cache.Exception.StorageFullException;
import com.mm.cache.policies.EvictionPolicy;
import com.mm.cache.storage.Storage;

public class Cache<Key,Value> {

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key,Value value){
        try{
            this.storage.add(key,value);
            this.evictionPolicy.keyAccessed(key);
        }catch (StorageFullException storageFullException){
            System.out.println("Storage is Full, will try to evict");
            Key keytoremove = evictionPolicy.evictKey();
            if(keytoremove==null){
                throw new RuntimeException("Unexpected State. Storage full and no key is to evict");
            }
            this.storage.remove(keytoremove);
            System.out.println("Creating space by evicting element "+keytoremove);
            put(key,value);
        }
    }

    public Value get(Key key){
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        }catch (NotFoundException notFoundException){
            System.out.println("Element is not present");
            return null;
        }
    }

}

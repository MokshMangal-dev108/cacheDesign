package com.mm.cache.storage;

import com.mm.cache.Exception.NotFoundException;

public interface Storage<Key,Value> {

    public void add(Key key,Value value);
    public void remove(Key key) throws NotFoundException;
    Value get(Key key) throws NotFoundException;

}

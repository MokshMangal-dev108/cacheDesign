package com.mm.cache.factories;

import com.mm.cache.Cache;
import com.mm.cache.policies.LRUEvictionPolicy;
import com.mm.cache.storage.HashMapBasedStorage;

public class CacheFactory <Key,Value>{

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
                new HashMapBasedStorage<Key, Value>(capacity));
    }

}

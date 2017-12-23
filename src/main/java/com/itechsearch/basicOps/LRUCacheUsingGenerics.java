package com.itechsearch.basicOps;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCacheUsingGenerics<K,V> {
    final int MAX_CAPACITY;
    Map<K,V> map;
    Queue<K> queue;

    public static void main(String[] args) {
        LRUCacheUsingGenerics<Integer,Integer> cache = new LRUCacheUsingGenerics<>( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
//        cache.get(1);       // returns 1//
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));
        //cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));
        //cache.get(1);       // returns -1 (not found)
        System.out.println(cache.get(3));
        //cache.get(3);       // returns 3
        System.out.println(cache.get(4));
        //cache.get(4);       // returns 4

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);
    }

    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    private Lock readLock=readWriteLock.readLock();
    private Lock writeLock=readWriteLock.writeLock();

    public LRUCacheUsingGenerics(int max_capacity){
        MAX_CAPACITY = max_capacity;
        map =new HashMap<>();
        queue=new ConcurrentLinkedQueue<>();
    }

    public V get(K key){
        V value=null;
        try {
            readLock.lock();
            if (map.containsKey(key)) {
                queue.remove(key);
                value=map.get(key);
                queue.add(key);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
        return value;
    }

    public void put(K key, V value){
        try{
            writeLock.lock();
            if(map.containsKey(key)){
                queue.remove(key);
                queue.add(key);
            }
            else {
                map.put(key,value);
                queue.add(key);
            }

            while(queue.size()>MAX_CAPACITY){
                K queueKey=queue.poll();
                map.remove(queueKey);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }

    public boolean remove(K key){
        try{
            writeLock.lock();
            map.remove(key);
            queue.remove(key);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
        return false;
    }

}

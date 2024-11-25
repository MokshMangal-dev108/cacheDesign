package com.mm;

import com.mm.cache.Cache;
import com.mm.cache.factories.CacheFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("System is started.....");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the capacity of cache:- ");
        int capacity = sc.nextInt();

        Cache<Integer,Integer> cache = new CacheFactory<Integer,Integer>().defaultCache(capacity);

        String str = sc.next().trim();
        while(!str.equalsIgnoreCase("exit")){
            if(str.equalsIgnoreCase("add")){
                int key = sc.nextInt();
                int value = sc.nextInt();
                cache.put(key,value);
            }else{
                int key = sc.nextInt();
                System.out.println("The value is.... ");
                System.out.println(cache.get(key));
            }
            str = sc.next().trim();
        }
        System.out.println("Program terminated successfully");
    }
}
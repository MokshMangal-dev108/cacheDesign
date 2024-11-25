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
        System.out.print("Enter new Commnd ");
        String str = sc.next().trim();
        while(!str.equalsIgnoreCase("exit")){
            if(str.equalsIgnoreCase("add")){
                System.out.print("Enter Key:- ");
                int key = sc.nextInt();
                System.out.print("Enter Value:- ");
                int value = sc.nextInt();
                cache.put(key,value);
                System.out.println("Element added successfully");
            }else if(str.equalsIgnoreCase("get")){
                System.out.print("Enter Key:- ");
                int key = sc.nextInt();
                System.out.print("The value is.... ");
                System.out.println(cache.get(key));
                System.out.println("Element retrived successfully");
            }else{
                System.out.println("Only 2 commands Get and Put is Supported");
            }
            System.out.println("Enter new Command");
            str = sc.next().trim();
        }
        System.out.println("Program terminated successfully");
    }
}
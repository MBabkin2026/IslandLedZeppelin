package com.javarush.island.babkin.servises;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MapGameLock {
    private static final Lock mapGameLock = new ReentrantLock();

    public static Lock getMapGameLock() {
        return mapGameLock;
    }
}

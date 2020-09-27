package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passengers extends Thread{
    Semaphore semaphore;
    CountDownLatch countDownLatch;
    int person;

    public Passengers(Semaphore semaphore, CountDownLatch countDownLatch, int person) {
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.person = person;
    }
    public Passengers(CountDownLatch countDownLatch, int i, int person){

    }
    @Override
public synchronized void run(){
try {
semaphore.acquire();
    System.out.println(" Пассажир " + person + " Стоит у окна кассы ");
    sleep(200);

    System.out.println(" Пассажир " + person + " уходит от окна  кассы");

semaphore.release();
sleep(200);
    System.out.println(" Пассажир " + person + " Посадка на автобус ");

countDownLatch.countDown();

}catch (InterruptedException ie){

}
    }
}

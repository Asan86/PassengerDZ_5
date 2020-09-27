package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Semaphore semaphore = new Semaphore(4, true);
        CountDownLatch count = new CountDownLatch(100);
        for (int i = 1; i <=100 ; i++) {
            new Passengers(semaphore, count, i).start();
        }
            try {
                while (count.getCount() <= 1) ;
                Thread.sleep(100);

                Thread.sleep(1000);
                System.out.println(" Начинаем обратный отсчет с (5)");

                count.countDown();
                Thread.sleep(1000);
                System.out.println(" 5 ");

                count.countDown();
                Thread.sleep(1000);
                System.out.println(" 4 ");

                count.countDown();
                Thread.sleep(1000);
                System.out.println(" 3 ");

                count.countDown();
                Thread.sleep(1000);
                System.out.println(" 2 ");

                count.countDown();
                Thread.sleep(1000);
                System.out.println(" 1 ");
                count.countDown();

                count.await();
                Thread.sleep(1000);
                System.out.println(" Автобус полный");
                Thread.sleep(2000);
                System.out.println(" Направляемся в город Ош");
                Thread.sleep(2000);
                System.out.println(" Eдем! ");
                count.countDown();
            }catch (InterruptedException ie){

            }
        }
    }


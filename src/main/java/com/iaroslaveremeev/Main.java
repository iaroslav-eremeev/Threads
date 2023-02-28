package com.iaroslaveremeev;

import com.iaroslaveremeev.service.WorkerService;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Create and fill a random array of integers
        int[] arr = new int[200_000_000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }

        // Calculate sum with linear method and show time consumed
        Long timeStartLinear = System.currentTimeMillis();
        int totalLinear = 0;
        for (int i = 0; i < arr.length; i++) {
            totalLinear += arr[i];
        }
        System.out.println("Total with linear method is " + totalLinear);
        Long timeEndLinear = System.currentTimeMillis();
        System.out.println("Time consumed for linear method is " + (timeEndLinear - timeStartLinear) + " ms");

        // Calculate sum with parallel method and show time consumed
        Thread sumThread = new Thread(new Runnable() {
            @Override
            public void run() {
                WorkerService workerService = new WorkerService(arr);
                try {
                    int totalParallel = workerService.calculateSum(10);
                    System.out.println("Total with parallel method is " + totalParallel);
                } catch (InterruptedException ignored) {}
            }
        });
        Long timeStartParallel = System.currentTimeMillis();
        sumThread.start();
        Long timeEndParallel = System.currentTimeMillis();
        System.out.println("Time consumed for parallel method is " + (timeEndParallel - timeStartParallel) + " ms");
    }
}
package com.iaroslaveremeev;

import com.iaroslaveremeev.service.WorkerService;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Create and fill a random array of 1 million integers
        int[] arrOne = new int[1_000_000];
        Random random = new Random();
        for (int i = 0; i < arrOne.length; i++) {
            arrOne[i] = random.nextInt(10);
        }

        // Create and fill a random array of 5 million integers
        int[] arrFive = new int[5_000_000];
        for (int i = 0; i < arrFive.length; i++) {
            arrFive[i] = random.nextInt(10);
        }

        // Create and fill a random array of 10 million integers
        int[] arrTen = new int[10_000_000];
        for (int i = 0; i < arrTen.length; i++) {
            arrTen[i] = random.nextInt(10);
        }

        // Calculate sum with linear method and show time consumed for an array of 1 million integers
        Long timeStartLinear = System.currentTimeMillis();
        int totalLinear = 0;
        for (int i = 0; i < arrOne.length; i++) {
            totalLinear += arrOne[i];
        }
        System.out.println("Total with linear method is " + totalLinear + " (1 mln integers)");
        Long timeEndLinear = System.currentTimeMillis();
        System.out.println("Time consumed for linear method is " + (timeEndLinear - timeStartLinear) + " ms for 1 mln integers");

        // Calculate sum with parallel method and show time consumed
        Thread sumThread = new Thread(new Runnable() {
            @Override
            public void run() {
                WorkerService workerService = new WorkerService(arrOne);
                try {
                    int totalParallel = workerService.calculateSum(10);
                    System.out.println("Total with parallel method is " + totalParallel + " (1 mln integers)");
                } catch (InterruptedException ignored) {}
            }
        });
        Long timeStartParallel = System.currentTimeMillis();
        sumThread.start();
        Long timeEndParallel = System.currentTimeMillis();
        System.out.println("Time consumed for parallel method is "
                + (timeEndParallel - timeStartParallel) + " ms for 1 mln integers");
        sumThread.interrupt();
        System.out.println();

        // Calculate sum with linear method and show time consumed for an array of 5 million integers
        Long timeStartLinear5 = System.currentTimeMillis();
        int totalLinear5 = 0;
        for (int i = 0; i < arrFive.length; i++) {
            totalLinear5 += arrFive[i];
        }
        System.out.println("Total with linear method is " + totalLinear5 + " (5 mln integers)");
        Long timeEndLinear5 = System.currentTimeMillis();
        System.out.println("Time consumed for linear method is " + (timeEndLinear5 - timeStartLinear5) + " ms for 5 mln integers");

        // Calculate sum with parallel method and show time consumed
        Thread sumThread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                WorkerService workerService = new WorkerService(arrFive);
                try {
                    int totalParallel = workerService.calculateSum(10);
                    System.out.println("Total with parallel method is " + totalParallel + " (5 mln integers)");
                } catch (InterruptedException ignored) {}
            }
        });
        Long timeStartParallel5 = System.currentTimeMillis();
        sumThread5.start();
        Long timeEndParallel5 = System.currentTimeMillis();
        System.out.println("Time consumed for parallel method is "
                + (timeEndParallel5 - timeStartParallel5) + " ms for 5 mln integers");
        sumThread5.interrupt();
        System.out.println();

        // Calculate sum with linear method and show time consumed for an array of 10 million integers
        Long timeStartLinear10 = System.currentTimeMillis();
        int totalLinear10 = 0;
        for (int i = 0; i < arrTen.length; i++) {
            totalLinear10 += arrTen[i];
        }
        System.out.println("Total with linear method is " + totalLinear10 + " (10 mln integers)");
        Long timeEndLinear10 = System.currentTimeMillis();
        System.out.println("Time consumed for linear method is " + (timeEndLinear10 - timeStartLinear10) + " ms for 10 mln integers");

        // Calculate sum with parallel method and show time consumed
        Thread sumThread10 = new Thread(new Runnable() {
            @Override
            public void run() {
                WorkerService workerService = new WorkerService(arrTen);
                try {
                    int totalParallel = workerService.calculateSum(10);
                    System.out.println("Total with parallel method is " + totalParallel + " (10 mln integers)");
                } catch (InterruptedException ignored) {}
            }
        });
        Long timeStartParallel10 = System.currentTimeMillis();
        sumThread10.start();
        Long timeEndParallel10 = System.currentTimeMillis();
        System.out.println("Time consumed for parallel method is "
                + (timeEndParallel10 - timeStartParallel10) + " ms for 10 mln integers");
        sumThread10.interrupt();
    }
}
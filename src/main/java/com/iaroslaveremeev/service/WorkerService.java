package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.SumWorker;

public class WorkerService {
    private int[] array;

    public WorkerService(int[] array) {
        this.array = array;
    }

    public int calculateSum(int n) throws InterruptedException{
        if (this.array.length % n != 0){
            throw new IllegalArgumentException("Array size must be divided by N without remainder!");
        }
        int workersNumber = array.length / n;
        SumWorker[] sumWorkers = new SumWorker[n];
        for (int i = 0; i < sumWorkers.length; i++) {
            sumWorkers[i] = new SumWorker(this.array, i * workersNumber, i * workersNumber + workersNumber);
            sumWorkers[i].start();
        }
        int total = 0;
        for (SumWorker sumWorker : sumWorkers) {
            sumWorker.join();
            int sum = sumWorker.getResult();
            total += sum;
        }
        return total;
    }
}

package com.iaroslaveremeev.model;

public class SumWorker extends Thread {
    private int[] array;
    private int start;
    private int end;
    private int result;
    public SumWorker(int[] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
        this.result = 0;
    }
    @Override
    public void run(){
        for (int i = this.start; i < this.end; i++) {
            this.result += this.array[i];
        }
    }
    public int getResult() {
        return result;
    }
}

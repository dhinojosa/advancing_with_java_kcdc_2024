package com.xyzcorp.virtualthreads;

public class UnstartedBasicVirtualThread {
    public static void main(String[] args) throws InterruptedException {
        Thread unstartedThread = Thread.ofVirtual().unstarted(() -> {
            System.out.printf("Starting Thread in %s", Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Starting Thread");
        unstartedThread.start();

        System.out.println("Waiting for Thread to finish");
        unstartedThread.join();
    }
}

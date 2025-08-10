package org.expensetracker;


public class TestLogger {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int threadNum = i;
            new Thread(() -> {
                MultiProcessLogger.log("INFO","Log message from thread " + threadNum);
            }).start();
        }
    }
}

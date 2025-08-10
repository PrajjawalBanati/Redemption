package org.expensetracker;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.nio.channels.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MultiProcessLogger {
    private static final String LOG_FILE = "app.log";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS yyyy-MM-dd");

    public static synchronized void log(String level, String message) {
        String processId = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        String threadId = String.valueOf(Thread.currentThread().getId());
        String timestamp = sdf.format(new Date());
        String logLine = String.format("%s %s %s %s %s %s\n",
                processId, threadId, timestamp.split(" ")[0], timestamp.split(" ")[1], level, message);

        try (RandomAccessFile raf = new RandomAccessFile(LOG_FILE, "rw");
             FileChannel channel = raf.getChannel()) {

//            FileLock lock = channel.lock(); // blocks until lock acquired
            try {
                raf.seek(raf.length()); // move to end of file
                raf.write(logLine.getBytes());
            } finally {
//                lock.release();
            }
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }
}

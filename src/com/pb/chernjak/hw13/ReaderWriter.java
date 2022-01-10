package com.pb.chernjak.hw13;

import java.util.LinkedList;
import java.util.Queue;

public class ReaderWriter {

    public static final int MAX_QUEUE_SIZE = 3;

    public static void main(String[] args) throws Exception {

        Queue<Integer> queue = new LinkedList<>();

        Writer writer = new Writer(queue, MAX_QUEUE_SIZE);
        Thread writerThread = new Thread(writer);
        writerThread.start();

        Reader reader = new Reader(queue);
        Thread readerThread = new Thread(reader);
        readerThread.start();

        Thread.sleep(10);
        writerThread.interrupt();
        readerThread.interrupt();
    }

    private static class Writer implements Runnable {
        private final Queue<Integer> queue;
        int maxSize;

        public Writer(Queue<Integer> queue, int maxSize) {
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            int number = 0;
            while (!Thread.interrupted()) {
                try {
                    System.out.println("Записать число: " + number);
                    write(number++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        public void write(int number) throws InterruptedException {
            synchronized (queue) {
                if (queue.size() >= maxSize) {
                    System.out.println("Ожидание записи ...");
                    queue.wait();
                }
                queue.offer(number);
                queue.notifyAll();
            }
        }
    }

    private static class Reader implements Runnable {
        private final Queue<Integer> queue;

        public Reader(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    System.out.println("Считать число: " + read());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public int read() throws InterruptedException {
            synchronized (queue) {
                if (queue.isEmpty()) {
                    System.out.println("Ожидание чтения ...");
                    queue.wait();
                }
                queue.notifyAll();
                return queue.poll();
            }
        }
    }
}

package com.pb.chernjak.hw13;

import java.util.LinkedList;
import java.util.Queue;

public class ReaderWriter {

    public static final int MAX_QUEUE_SIZE = 5;

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        Writer writer = new Writer(queue);
        Thread writerThread = new Thread(writer);
        writerThread.start();

        Reader reader = new Reader(queue);
        Thread readerThread = new Thread(reader);
        readerThread.start();
    }

    private static class Writer implements Runnable {
        private Queue<Integer> queue;

        public Writer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            int number = 0;
            while (true) {
                if (queue.size() <= MAX_QUEUE_SIZE) {
                    System.out.println("Записать число: " + number);
                    queue.offer(number);
                    number++;
                    System.out.println("Размер очереди: " + queue.size());
                }
                try {
                    Thread.sleep(500 + (int)(Math.random() * 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Reader implements Runnable {
        private Queue<Integer> queue;

        public Reader(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                if (queue.size() > 0) {
                    int number = queue.poll();
                    System.out.println("Считать число: " + number);
                }
                try {
                    Thread.sleep(500 + (int)(Math.random() * 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:15 下午 2022/7/4
 **/


package threadexample;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 生产者和消费者
 */
public class SynchronizedConsumerAndProducer {

    /**
     * 队列长度
     */
    private static final int MAX_LEN = 5;

    private Queue<Integer> queue = new LinkedList<>();


    class Producer extends Thread {

        @Override
        public void run() {
            producer();
        }

        private void producer() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == MAX_LEN) { //队列已满
                        queue.notify();
                        System.out.println("当前队列已满");
                        try {
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    queue.notify();
                    System.out.println("生产了一条数据，当前队列长度为：" + queue.size());

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        queue.notify();
                        System.out.println("当前队列为空");

                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("消费者消费一条任务，当前队列长度为：" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedConsumerAndProducer synchronizedConsumerAndProducer = new SynchronizedConsumerAndProducer();
        Producer producer = synchronizedConsumerAndProducer.new Producer();
        Consumer consumer = synchronizedConsumerAndProducer.new Consumer();
        producer.start();
        consumer.start();
    }
}

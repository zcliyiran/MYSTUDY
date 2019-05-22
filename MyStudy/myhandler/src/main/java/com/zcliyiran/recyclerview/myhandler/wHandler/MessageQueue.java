package com.zcliyiran.recyclerview.myhandler.wHandler;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lyr
 * @date 2018/9/22.
 */
public class MessageQueue {


    private int putIndex;
    private int takeIndex;
    private Message[] item;

    private int count;

    private Lock lock;

    private Condition notFull;

    private Condition notEmpty;

    public MessageQueue() {

        item = new Message[50];

        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();

    }

    void enqueueMessage(Message msg) {

        try {
            lock.lock();
            while (count == 50) {
                notFull.await();
            }
            item[putIndex] = msg;
            putIndex = (++putIndex == item.length) ? 0 : putIndex;
            count++;
            //队列不为空，通知主线程消费
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public Message next() {
        Message msg = null;
        try {

            lock.lock();
            while (count == 0) {
                notEmpty.await();
            }


            msg = item[takeIndex];
            item[takeIndex] = null;
            takeIndex = (++takeIndex == item.length) ? 0 : takeIndex;
            count--;
            //队列满，通知子线程生产
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }

        return msg;

    }
}

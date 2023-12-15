package Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Video {
    int likes;
    ReentrantLock lock ;
    Condition condition ;

    public Video(int likes) {
        this.likes = likes;
        this.lock = new ReentrantLock();
        this.condition  = lock.newCondition();
    }

    public synchronized int getLikes() {
        return likes;
    }

    public synchronized void increase() {
        this.likes++;
    }
}


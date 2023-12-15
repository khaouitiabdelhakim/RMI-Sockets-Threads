package Solution;

import java.util.concurrent.locks.ReentrantLock;

public class Video {
    int likes;
    ReentrantLock lock;

    public Video(int likes) {
        this.likes = likes;
        this.lock = new ReentrantLock();
    }

    public synchronized int getLikes() {
        return likes;
    }

    public synchronized void  increase() {
        this.likes++;
    }
}



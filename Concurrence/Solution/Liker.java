package Solution;

import java.util.concurrent.locks.ReentrantLock;

public class Liker implements Runnable {

    Video video;

    public Liker(Video video) {
        this.video = video;
    }

    @Override
    public void run() {
        video.lock.lock();
        try {
            this.video.increase();
            System.out.println("Video likes: " + video.getLikes());
        }catch (Exception e){}
        finally {
            video.lock.unlock();
        }
    }
}




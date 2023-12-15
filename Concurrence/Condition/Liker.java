package Condition;

public class Liker implements Runnable {

    Video video;

    public Liker(Video video) {
        this.video = video;
    }

    @Override
    public void run() {
        video.lock.lock();
        try {
            while (video.getLikes() >=99) {
                // Wait until the number of likes is below 99
                this.video.condition.await();
            }
            this.video.increase();
            System.out.println("Video likes: " + video.getLikes());
            this.video.condition.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            video.lock.unlock();
        }
    }
}





package WaitAndNotify;

class Fan implements Runnable {
    private YouTuber youtuber;

    public Fan(YouTuber youtuber) {
        this.youtuber = youtuber;
    }

    public void notifyFan() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " received notification about a new video!");
            // Process the new video, e.g., watch it
        }
    }

    @Override
    public void run() {
        // Fan's logic, for example, waiting for new videos
        while (true) {
            synchronized (this) {
                try {
                    wait(); // Fan waits for a new video notification
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}


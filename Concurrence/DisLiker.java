public class DisLiker implements Runnable {

    Video video;

    public DisLiker(Video video) {
        this.video = video;
    }

    @Override
    public void run() {
        this.video.decrease();
        System.out.println("Video likes: " + video.likes);
    }
}
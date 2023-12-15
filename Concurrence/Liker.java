public class Liker implements Runnable{

    Video video;
    public Liker(Video video) {
        this.video = video;
    }

    @Override
    public void run() {
        this.video.increase();
        System.out.println("Video likes: "+ video.likes);
    }
}

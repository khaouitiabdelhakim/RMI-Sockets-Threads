package Condition;

public class YouTube {

    public static void main(String[] args) {
        Video video = new Video(0);

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Liker(video));
            thread.start();
        }

    }
}

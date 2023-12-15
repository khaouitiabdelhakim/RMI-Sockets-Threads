package WaitAndNotify;

public class YouTubeExample {

    public static void main(String[] args) {
        YouTuber youtuber = new YouTuber();
        Fan fan1 = new Fan(youtuber);
        Fan fan2 = new Fan(youtuber);

        youtuber.addFan(fan1);
        youtuber.addFan(fan2);

        Thread youtuberThread = new Thread(youtuber);
        Thread fanThread1 = new Thread(fan1, "Fan 1");
        Thread fanThread2 = new Thread(fan2, "Fan 2");

        youtuberThread.start();
        fanThread1.start();
        fanThread2.start();
    }
}



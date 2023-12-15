package WaitAndNotify;


import java.util.ArrayList;
import java.util.List;

class YouTuber implements Runnable {
    private List<Fan> fans = new ArrayList<>();

    public void addFan(Fan fan) {
        fans.add(fan);
    }

    public void uploadVideo(String videoName) {
        System.out.println("YouTuber uploaded a new video: " + videoName);
        notifyAllFans();
    }

    private void notifyAllFans() {
        synchronized (fans) {
            for (Fan fan : fans) {
                fan.notifyFan();
            }
        }
    }

    @Override
    public void run() {
        // YouTuber's logic, for example, uploading videos periodically
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000); // Simulating time between video uploads
                uploadVideo("Video " + (i + 1));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}











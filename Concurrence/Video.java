public class Video {
    int likes;

    public Video(int likes) {
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    public void increase() {
        this.likes ++;
    }

    public void decrease() {
        this.likes --;
    }
}

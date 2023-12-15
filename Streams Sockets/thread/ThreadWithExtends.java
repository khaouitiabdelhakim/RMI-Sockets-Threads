package thread;

public class ThreadWithExtends extends Thread {
    public ThreadWithExtends(String name) {
        super(name);
    }

    public void run() {
            // Code to be executed in the thread
            //fait jhfjkdshfjkdhfjksd
        }

        public static void main(String args[]) {
            ThreadWithExtends myThread = new ThreadWithExtends("nom");
            myThread.start();
            //myThread.run();

        }
}



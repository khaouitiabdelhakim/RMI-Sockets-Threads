package thread;

public class ThreadWithImplements implements Runnable{


        public static void main(String args[]) {
            ThreadGroup g = new ThreadGroup("monG");
            Thread myThread = new Thread(g,new ThreadWithImplements(),"monthread");
            myThread.start();
        }

    @Override
    public void run() {

    }
}





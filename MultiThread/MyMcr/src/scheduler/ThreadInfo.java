package scheduler;

import java.util.concurrent.Semaphore;

public class ThreadInfo {

    Thread thread;
    String action;
    private Semaphore semaphore;

    public Semaphore getPausingSemaphore() {
        return semaphore;
    }

    public ThreadInfo(Thread thread,String action){
        this.thread = thread;
        this.action = action;
        semaphore =  new Semaphore(0);

    }

    @Override
    public String toString() {
        return "线程："+ thread.getName()+ action;

    }
}

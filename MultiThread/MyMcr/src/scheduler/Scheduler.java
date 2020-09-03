package scheduler;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Scheduler {

    private static Map<Thread, ThreadInfo> livingThreadInfos = new HashMap<>();
    private static Set<ThreadInfo> pausedThreadInfos = new HashSet<>();
    private static ReentrantLock schedulerStateLock = new ReentrantLock();

    static {
//        initState();
        Thread thread = new Thread(() -> {
            while (true) {
                schedulerStateLock.lock();
                try {

                    if (!livingThreadInfos.isEmpty() && !pausedThreadInfos.isEmpty()) {
                        ThreadInfo threadInfo = choose();
                        pausedThreadInfos.remove(threadInfo);
                        threadInfo.getPausingSemaphore().release();
                    }
                } finally {
                    schedulerStateLock.unlock();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

//    public static void initState() {
//        livingThreadInfos = new HashMap<>();
//        pausedThreadInfos = new HashSet<>();
//        schedulerStateLock = new ReentrantLock();
//    }

    public static void beforeFieldRead(boolean isRead, String methodName, String fieldName, String desc, int lineNumber) {
        beforeEvent(isRead, methodName, fieldName, desc);
    }

    public static void beforeFieldWrite(boolean isRead, String methodName, String fieldName, String desc,int lineNumber) {

        beforeEvent(isRead, methodName, fieldName, desc);
    }

    public static void beforeEvent(boolean isRead, String methodName, String name, String desc) {
//
        String action = isRead ? "读" : "写";
        System.out.println("线程" + Thread.currentThread().getName() + " 将要" + action + "方法" + methodName +"中的变量" + name + ",描述符为 " + desc);
////
//        ThreadInfo currentTI;
//        if (Thread.currentThread().getName().equals("main") == false) {
//
//            try {
//                schedulerStateLock.lock();
//                Thread currentThread = Thread.currentThread();
//
//                currentTI = new ThreadInfo(currentThread, action);
//                livingThreadInfos.put(currentThread, currentTI);
//                pausedThreadInfos.add(currentTI);
////
//////            if (!livingThreadInfos.containsKey(currentThread)) {
//////                System.out.println("if里的"+action);
//////                currentTI = new ThreadInfo(currentThread, action);
//////                livingThreadInfos.put(currentThread, currentTI);
//////                pausedThreadInfos.add(currentTI);
//////            } else {
//////                currentTI = livingThreadInfos.get(currentThread);
//////                System.out.println("else里的"+currentTI);
//////                pausedThreadInfos.add(currentTI);
//////            }
////            }
////
//            } finally {
//                schedulerStateLock.unlock();
//
//            }
//
//            if (currentTI != null) {
//                try {
////                System.out.println(1);
//                    currentTI.getPausingSemaphore().acquire();
////                System.out.println(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
    }

    public static ThreadInfo choose() {
        System.out.println("=====================当前暂停的线程信息======================");
        pausedThreadInfos.forEach(System.out::println);

        ThreadInfo choice = null;
        for (ThreadInfo ti : pausedThreadInfos){
            if (ti.thread.getName().equals("Thread-0") && ti.action.equals("读")){
                choice = ti;
            }else if (ti.thread.getName().equals("Thread-1") && ti.action.equals("写")){
                choice = ti;
            }else if (ti.thread.getName().equals("Thread-0") && ti.action.equals("写")){
                choice = ti;
            }else {
                choice = ti;
            }
        }
        System.out.println("返回的选择是" + choice);
        return choice;
    }

}

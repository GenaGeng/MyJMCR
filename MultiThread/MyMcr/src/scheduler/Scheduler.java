package scheduler;

public class Scheduler {

    public static void beforeFieldAccess(boolean isRead, String methodName, String fieldName, String desc,int lineNumber) {
        System.out.println("!");
        beforeEvent(isRead , methodName, fieldName, desc);
    }

    public static void afterFieldAccess(boolean isRead, String owner, String name, String desc){

    }

    public static void beforeEvent(boolean isRead,String methodName,String name,String desc){
        String action = isRead? "读":"写";
        System.out.println("正在"+action+"变量"+name+",描述符为"+desc);
    }
}

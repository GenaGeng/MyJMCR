package top.stanwang.state;

public class NoonState implements State{

    private static NoonState singleton= new NoonState();
    private NoonState(){

    }

    public static NoonState getInstance(){
        return singleton;
    }
    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || 17<= hour){
            context.changeState(NightState.getInstance());
        } else if (hour <= 13&& hour >= 12) {
            context.changeState(getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("午餐时间使用金库");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃（午餐时间）");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("午餐时间的通话录音");
    }
}//同时应当修改DayState和NightState的 doclock方法，与本类的方法类似。

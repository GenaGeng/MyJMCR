package top.stanwang.state;

public class UrgentState implements State {

    private static UrgentState singleton = new UrgentState();

    private UrgentState() {

    }

    public static UrgentState getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {

    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("����������ʱʹ�ý��");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("���¾��壡������ʱ��");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("����ͨ��������ʱ��");
    }
}//ͬʱ��NightState��doAlarm�����м��� context.changeState(Urgent.getInstance());

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
        context.callSecurityCenter("���ʱ��ʹ�ý��");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("���¾��壨���ʱ�䣩");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("���ʱ���ͨ��¼��");
    }
}//ͬʱӦ���޸�DayState��NightState�� doclock�������뱾��ķ������ơ�

package top.stanwang.state;

public class DayState implements State {
	
	private DayState() {
		
	}
	
	private static DayState singleton= new DayState();
	public static DayState getInstance() {
		return singleton;
	}
	@Override
	public void doClock(Context context, int hour) {
		if(hour < 7 || 17 <= hour) {
			context.changeState(NightState.getInstance());
		}
	}

	@Override
	public void doUse(Context context) {
		context.recordLog("ʹ�ý�⣨���죩");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("���¾��壨���죩");
	}

	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("����ͨ�������죩");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "����";
	}
}

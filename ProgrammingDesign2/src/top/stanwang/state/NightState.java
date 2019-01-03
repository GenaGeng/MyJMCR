package top.stanwang.state;

public class NightState implements State {
	
	private NightState() {
		
	}
	
	private static NightState singleton= new NightState();
	public static NightState getInstance() {
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
		context.recordLog("����������ʹ�ý�⣡");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("���¾��壨���ϣ�");
	}

	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("���ϵ�ͨ��¼��");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "����";
	}
}

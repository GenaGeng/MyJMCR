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
		context.recordLog("紧急：晚上使用金库！");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("按下警铃（晚上）");
	}

	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("晚上的通话录音");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "晚上";
	}
}

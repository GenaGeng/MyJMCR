package top.stanwang.state;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements Context,ActionListener {

	private TextField textClock = new TextField(60);
	private TextArea textScreen = new TextArea(10,60);
	private Button buttonUse = new Button("使用金库");
	private Button buttonAlarm = new Button("按下警铃");
	private Button buttonPhone = new Button("正常通话");
	private Button buttonExit = new Button("结束");
	
	private State state = NightState.getInstance();
	
	public SafeFrame(String title) {
		super(title);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		add(textClock, BorderLayout.NORTH);
		textClock.setEditable(false);
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);
		Panel panel= new Panel();
		panel.add(buttonAlarm);
		panel.add(buttonExit);
		panel.add(buttonPhone);
		panel.add(buttonUse);
		add(panel,BorderLayout.SOUTH);
		pack();
		show();
		buttonUse.addActionListener(this);
		buttonExit.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
	}
	
	@Override
	public void setClock(int hour) {
		// TODO Auto-generated method stub
		String str = "现在时间是";
		if(hour<10) {
			str += "0"+hour+":00";
		}
		else {
			str+= hour + ":00";
		}
		textClock.setText(str);
		state.doClock(this, hour);
	}

	@Override
	public void changeState(State state) {
		this.state = state;
		System.out.println("从"+this.state+"状态变成了"+state);
	}

	@Override
	public void callSecurityCenter(String msg) {
		// TODO Auto-generated method stub
		textScreen.append("call" + msg +"\n");
	}

	@Override
	public void recordLog(String msg) {
		// TODO Auto-generated method stub
		textScreen.append("record... " + msg + "\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.toString());
		if(e.getSource() == buttonUse) {
			state.doUse(this);
			
		}
		if(e.getSource()== buttonPhone) {
			state.doPhone(this);
		}
		if(e.getSource() == buttonExit) {
			System.exit(0);
		}
		if(e.getSource() == buttonAlarm) {
			state.doAlarm(this);
		}
	}

}

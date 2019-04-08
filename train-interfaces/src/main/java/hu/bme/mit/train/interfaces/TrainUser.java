package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();

	void setAlarmState(boolean alarmState);

	void overrideJoystickPosition(int joystickPosition);

}

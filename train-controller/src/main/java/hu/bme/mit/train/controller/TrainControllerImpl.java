package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
// this is doing magic
public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private Thread t;

	private boolean running = true;

	public TrainControllerImpl()
	{
		t = new Thread(
			new Runnable()
			{
				public synchronized void run()
				{
					while(running)
					{
						try
						{
							followSpeed();
							Thread.sleep(1000);
						}
						catch(InterruptedException e)
						{
							running = false;
							e.printStackTrace();
						}
					}
				}
				
			}

		);		
	}

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}

		enforceSpeedLimit();
	}
//some more magic
	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

//this is not magic just plain old c
	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;	    
	}

	public synchronized void stopTrainController(){
		running = false;
	}


}

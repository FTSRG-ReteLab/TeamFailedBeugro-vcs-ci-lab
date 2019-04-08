package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorTest {

    private TrainController mockController;// = new TrainControllerImpl();
	private TrainUser mockUser;// = new TrainUserImpl(controller);
	private TrainSensor sensor; // = new TrainSensorImpl(controller, user);

    @Before
    public void before() {
        mockController = mock(TrainController.class);
        mockUser = mock(TrainUser.class);
        sensor = new TrainSensorImpl(mockController, mockUser);
        


        when(mockController.getReferenceSpeed()).thenReturn(50);
    }

    @Test
    public void fivehundredPlussSpeedLimit(){
        sensor.overrideSpeedLimit(501);
        verify(mockUser, times(1)).setAlarmState(true);
    }


    @Test
    public void regularSpeedLimit(){
        sensor.overrideSpeedLimit(30);
        verify(mockUser, times(0)).setAlarmState(true);
        verify(mockController, times(1)).setSpeedLimit(30);
    }

}

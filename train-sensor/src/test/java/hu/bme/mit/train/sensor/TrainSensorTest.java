package hu.bme.mit.train.sensor;



import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

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
    public void negativeSpeedLimit()
    {
        sensor.overrideSpeedLimit(-10);
        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void lessThanHalfSpeedLimit()
    {
        sensor.overrideSpeedLimit(10);
        verify(mockUser, times(1)).setAlarmState(true);
    }

}

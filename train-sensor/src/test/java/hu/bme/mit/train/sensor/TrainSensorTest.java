package hu.bme.mit.train.sensor;

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
        mockController = mock(TrainControllerImpl.class);
        mockUser = mock(TrainUserImpl.class);
        sensor = new TrainSensorImpl(mockController, mockUser);
    }

}

package hu.bme.mit.train.system;


import java.util.ArrayList;

import com.google.common.collect.*;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class Tachograph {

	
	private ArrayTable<Long, Integer, Integer> table;
	
	private long count = 0;
	
	public Tachograph()
	{
		
		ArrayList<Long> longs = new ArrayList<>();
		for(long i = count; i < 10; ++i )
		longs.add(i);
		ArrayList<Integer> ints = new ArrayList<>();
		for(int j = -100; j < 100; ++j)
		ints.add(j);
		
		table = ArrayTable.create(longs, ints);
	}
	
	public void collectData(TrainUser user, TrainController controller)
	{
		if(count < 10)
			table.put(count++, user.getJoystickPosition(),controller.getReferenceSpeed());
	}
	
	public int size()
	{
		return table.size();
	}
}

package za.co.avaj.weather;

import za.co.avaj.exceptions.FailedUnregisterException;
import za.co.avaj.vehicles.Flyable;

import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable> observers=new ArrayList<Flyable>();

	public void			register(Flyable flyable) {
		observers.add(flyable);
	}

	public void			unregister(Flyable flyable) throws FailedUnregisterException {
		if (observers.contains(flyable)) {
			observers.remove(flyable);
			//Log the unregister  TYPE#NAME(UNIQUE_ID): SPECIFIC_MESSAGE.
		} else {
			throw new FailedUnregisterException("ERROR: Cannot unregister Flyable: " + flyable.getFlyableName());
		}

	}

	protected void		conditionsChanged() {}
}
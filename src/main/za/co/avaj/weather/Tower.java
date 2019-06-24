package za.co.avaj.weather;

import za.co.avaj.exceptions.FailedUnregisterException;
import za.co.avaj.logger.Logger;
import za.co.avaj.vehicles.Flyable;

import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable> observers=new ArrayList<Flyable>();
	Logger log = new Logger();

	public void			register(Flyable flyable) {
		observers.add(flyable);
		log.logToFile("normal", "Tower says: " + flyable.getFlyableType() + "#" + flyable.getFlyableName() + "(" + flyable.getFlyableId() + ") registered to weather tower." );
	}

	public void			unregister(Flyable flyable) throws FailedUnregisterException {
		if (observers.contains(flyable)) {
			observers.remove(flyable);
			log.logToFile("default", "Tower says: " + flyable.getFlyableType() + "#" + flyable.getFlyableName() +
					"(" + flyable.getFlyableId() + ") unregistered to weather tower.");
		} else {
			throw new FailedUnregisterException("ERROR: Cannot unregister Flyable: " + flyable.getFlyableName());
		}

	}

	protected void		conditionsChanged() {
		for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
	}
}
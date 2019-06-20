package za.co.avaj.vehicles;

import Flyable;

public class Tower {
	private Flyable		*observers;

	public void			register(Flyable flyable) {}

	public void			unregister(Flyable flyable) {}

	protected void		conditionsChanged() {}
}
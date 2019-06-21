import Coordinates;

public class Aircraft {
	protected long				id;
	protected string			name;
	protected Coordinates		coordinates;
	private long				idCounter;

	protected Aircraft(string name, Coordinates coordinates) {}
	private long				nextId() {}
}
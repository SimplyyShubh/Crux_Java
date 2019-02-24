package Lecture11.IStory;

public class Car {
	private IEngine engine;

	public Car(IEngine engine) throws Exception {
		this.setEngine(engine);
	}

	public void setEngine(IEngine engine) throws Exception {
		if (engine == null) {
			throw new Exception("Car won't work without an engine");
		}

		this.engine = engine;
	}

	public void Power() throws Exception {
		if (this.engine == null) {
			throw new Exception("No engine installed");
		}

		this.engine.start();
	}
}

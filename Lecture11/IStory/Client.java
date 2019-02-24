package Lecture11.IStory;

public class Client {

	public static void main(String[] args) throws Exception {
		IEngine mEngine = new MarutiEngine();
		IEngine hEngine = new HyundaiEngine();
		
		Car myCar = new Car(mEngine);
		myCar.Power();
		
//		myCar.setEngine(hEngine);
//		myCar.Power();
	}

}

package Lecture17;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HashTable<String, Integer> map = new HashTable<>(3);
		map.put("USA", 200);
		map.put("Russia", 250);
		map.put("India", 225);
		map.put("RSA", 150);
		map.put("China", 300);

		map.display();
		map.put("India", 275);
		System.out.println(map.get("India"));
		//System.out.println(map.remove("India"));

		map.put("Bangladesh", 125);
		map.put("Nepal", 50);
		map.display();

	}

}

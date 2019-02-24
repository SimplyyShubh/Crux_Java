package Lecture17;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("USA", 200);
		map.put("Russia", 250);
		map.put("India", 225);
		map.put("RSA", 150);
		map.put("China", 300);

		System.out.println(map);
		System.out.println(map.get("India"));
		System.out.println(map.get("Pak"));

		map.put("India", 275);
		System.out.println(map.remove("Pak"));
		System.out.println(map);

		System.out.println(map.size());

		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key);
		}

		Collection<Integer> values = map.values();
		for (Integer value : values) {
			System.out.println(value);
		}

		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
			System.out.print(entry.getKey() + "=>");
			System.out.println(entry.getValue());
		}

		String str = "aabbccdddef";
		System.out.println(maxFreq(str));

	}

	public static char maxFreq(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			if (map.containsKey(cc)) {
				int ov = map.get(cc);
				ov = ov + 1;
				map.put(cc, ov);
			} else {
				map.put(cc, 1);
			}

		}

		char maxChar = '\0';
		int maxValue = 0;

		Set<Map.Entry<Character, Integer>> entries = map.entrySet();
		for (Map.Entry<Character, Integer> entry : entries) {
			if (entry.getValue() > maxValue) {
				maxChar = entry.getKey();
				maxValue=entry.getValue();
			}
		}
		return maxChar;
	}
}

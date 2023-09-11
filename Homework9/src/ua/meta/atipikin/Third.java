package ua.meta.atipikin;

import java.util.HashMap;

public class Third {

	public static void main(String[] args) {
		int[] array = new int[] {1, 489, 56, 99, 42, 293, 56, 1, 78, 56, 604, 56, 42, 424, 438, 56, 94, 3, 7, 56, 1, 293, 604, 42, 1, 42, 293, 56, 78, 42, 604, 1, 42};
		HashMap<Integer, Integer> arrNum = new HashMap<>(); // карта, у якої ключ - елемент масиву, а значення - кількість повторень
		for(int i = 0; i < array.length; i++) {
			if(arrNum.containsKey(array[i])) {
				int value = arrNum.get(array[i]);
				value += 1;
				arrNum.put(array[i], value);
			}
			else {
				arrNum.put(array[i], 1);
			}
		}
		arrNum.forEach((key, value) -> System.out.println(key + " - " + value));
	}
}
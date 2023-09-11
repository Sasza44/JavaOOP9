package ua.meta.atipikin;

import java.util.HashMap;

public class Fourth {

	public static void main(String[] args) {
//		String[] a = artA();
//		for(int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
		HashMap<Character, String[]> art = new HashMap<>();
		art.put('A', artA());
		art.put('B', artB());
		art.put('C', artC());
		art.put('D', artD());
		art.put('E', artE());
		artWord("BEE", art); // бджола
	}
	
	public static String[] artA() {
		String[] s = new String[6];
		s[0] = "      *      ";
		s[1] = "     * *     ";
		s[2] = "    *   *    ";
		s[3] = "   *******   ";
		s[4] = "  *       *  ";
		s[5] = " *         * ";
		return s;
	}
	public static String[] artB() {
		String[] s = new String[6];
		s[0] = " *******     ";
		s[1] = " *        *  ";
		s[2] = " ********    ";
		s[3] = " *         * ";
		s[4] = " *         * ";
		s[5] = " ********    ";
		return s;
	}
	public static String[] artC() {
		String[] s = new String[6];
		s[0] = "    ******** ";
		s[1] = "  *          ";
		s[2] = " *           ";
		s[3] = " *           ";
		s[4] = "  *          ";
		s[5] = "    ******** ";
		return s;
	}
	public static String[] artD() {
		String[] s = new String[6];
		s[0] = " *********   ";
		s[1] = " *        *  ";
		s[2] = " *         * ";
		s[3] = " *         * ";
		s[4] = " *        *  ";
		s[5] = " *********   ";
		return s;
	}
	public static String[] artE() {
		String[] s = new String[6];
		s[0] = " *********** ";
		s[1] = " *           ";
		s[2] = " *******     ";
		s[3] = " *           ";
		s[4] = " *           ";
		s[5] = " *********** ";
		return s;
	}
	public static String[] artF() {
		String[] s = new String[6];
		s[0] = " *********** ";
		s[1] = " *           ";
		s[2] = " *******     ";
		s[3] = " *           ";
		s[4] = " *           ";
		s[5] = " *           ";
		return s;
	}
	public static void artWord(String word, HashMap<Character, String[]> art) {
		char[] arr = word.toCharArray();
		String[] arr1 = new String[] {"", "", "", "", "", ""};
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				arr1[i] += art.get(arr[j])[i];
			}
			System.out.println(arr1[i]);
		}
	}
}
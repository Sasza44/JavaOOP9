package ua.meta.atipikin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class First {

	public static void main(String[] args) {
		File en = new File("English.in.txt");
		File ua = new File("Ukrainian.out.txt");
		File dictionaryFile = new File("dictionary.txt"); // файл для збереження словника
		String textEn = fastLoadFromFile(en); // зчитування тексту з файлу
		HashMap<String, String> dictionary = createDictionary(); // створення словника
		System.out.println(textEn); // вивід на консоль тексту, зчитаного з файлу
		String textUa = translate(textEn, dictionary); // переклад тексту
		writeToFile(ua, textUa);
		dictionary.putIfAbsent("or", "або"); // додавання слова до словника
		writeDictionaryToFile(dictionaryFile, dictionary); // запис словника у файл
	}
	
	public static String fastLoadFromFile(File file) { // зчитування тексту з файлу
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for(; (text = br.readLine()) != null; ) {
				sb.append(text);
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return sb.toString();
	}
	
	public static HashMap<String, String> createDictionary() { // створення словника
		HashMap<String, String> dictionary = new HashMap<>();
		dictionary.put("Down", "Вниз");
		dictionary.put("the", "");
		dictionary.put("a", "");
		dictionary.put("Rabbit-hole", "по кролячій норі");
		dictionary.put("Alice", "Аліса");
		dictionary.put("and", "і");
		dictionary.put("her", "її(нею)");
		dictionary.put("big", "великий(а)");
		dictionary.put("sister", "сестра");
		dictionary.put("sat", "сидів(ла, ли)");
		dictionary.put("under", "під");
		dictionary.put("tree", "дерево(м)");
		dictionary.put("one", "один(одного)");
		dictionary.put("sunny", "сонячний(ого)");
		dictionary.put("day", "день(дня)");
		dictionary.put("Alice's", "Аліси");
		dictionary.put("had", "мав(ла)");
		dictionary.put("book", "книжка(у)");
		dictionary.put("but", "але");
		dictionary.put("nothing", "нічого");
		dictionary.put("with", "з");
		dictionary.put("She", "Вона");
		dictionary.put("looked", "подивився(лась)");
		dictionary.put("at", "на");
		dictionary.put("sister's", "сестри");
		dictionary.put("to", "до");
		return dictionary;
	}
	
	public static String translate(String text, HashMap<String, String> dictionary) {
		String text1 = text; // копія вихідного тексту
		int i0 = 0; // індекс пробілу
		int i1 = 0; // індекс крапки
		int i2 = 0; // індекс коми
		int i = 0; // індекс найближчого з трьох вищевказаних символів
		int x = 0; // індекс початку пошуку наступного слова
		String wordEn = "";
		while(i != -1) {
			if(i == 0) {
				i0 = text.indexOf(" ");
				i1 = text.indexOf(".");
				i2 = text.indexOf(",");
				i = searchIndexAfterWord(i0, i1, i2);
				if(i > 0) {wordEn = text.substring(0, i).trim();}
			}
			else {
				i0 = text.indexOf(" ", x);
				i1 = text.indexOf(".", x);
				i2 = text.indexOf(",", x);
				i = searchIndexAfterWord(i0, i1, i2);
				if(i > 0) {wordEn = text.substring(x, i).trim();}
			}
			if(dictionary.containsKey(wordEn)) {
				String wordUa = dictionary.get(wordEn);
				text1 = text1.replaceFirst(wordEn, wordUa);
			}
			x = i + 1;
		}
		return text1;
	}
	
	public static int searchIndexAfterWord(int i0, int i1, int i2) { // пошук індексу символа, який стоїть після слова
		int[] arr = new int[] {i0, i1, i2};
		int i = 0; // мінімальний елемент масиву
		Arrays.sort(arr);
		for(int j = 0; j < arr.length; j++) {
			i = arr[j];
			if(i != -1) {break;}
		}
		return i;
	}
	
	public static void writeToFile(File file, String text) { // запис тексту в файл
		try(PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);
		} catch(FileNotFoundException e) {
			System.out.println("Error file write");
		}
	}
	
	public static void writeDictionaryToFile(File file, HashMap<String, String> dictionary) {
		try(PrintWriter pw = new PrintWriter(file)) {
			dictionary.forEach((key, value) -> pw.println(key + " - " + value));
		} catch(FileNotFoundException e) {
			System.out.println("Error file write");
		}
	}
}
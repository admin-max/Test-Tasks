package testTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

Specification
Write a program that takes line as input and will tell is that line palindrome or not.
If there are more than one word in line - program must verify each word for palindrome.
A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward as forward, 
such as madam or racecar.

*/

public class Palindrome {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			println("Enter your line:");

			String line = readln(br);

			if (line.isEmpty())
				break;

			verifyLine(line);
			
			/* For example line : "qwerty 123321 ytrewq" will looks as
			 * 
			 * Enter your line: 
			 * qwerty 123321 ytrewq 
			 * You entered 3 words: qwerty 123321 ytrewq 
			 * Reversed by words: ytrewq 123321 qwerty 
			 * Reversed: qwerty 123321 ytrewq 
			 * The line is Palindrome! 
			 * The word1: qwerty is NOT Palindrome! 
			 * The word2: 123321 is Palindrome! 
			 * The word3: ytrewq is NOT Palindrome! 
			 * Enter your line:
			 */
		}
	}

	static void verifyLine(String line) {

		String[] strArr = splitBySpace(line);

		println("You entered " + strArr.length + " words: " + line);

		String reversedByWords = reverseStringByWords(line);

		println("Reversed by words: " + reversedByWords);

		String reversed = reverceString(line);
		println("Reversed: " + reversed);

		if (isPolindrome(line))
			println("The line  is Polindrome!");
		else
			println("The line is NOT Polindrome!");

		if (strArr.length > 1) {
			for (int i = 0; i < strArr.length; i++) {

				if (isPolindrome(strArr[i]))
					println("The word"+(i+1)+": " + strArr[i] + " is Polindrome!");
				else
					println("The word"+(i+1)+": " + strArr[i] + " is NOT Polindrome!");

			}
		}
	}

	static String reverceString(String str) {

		int lenth = str.length();
		char[] strArr = str.toCharArray();
		char[] result = new char[lenth];

		StringBuilder resultStr = new StringBuilder();

		for (int i = 0, j = lenth - 1; (i < lenth && 0 <= j); i++, j--) {

			result[i] = strArr[j];
		}
		
		StringBuilder myResult = resultStr.append(result);

		return myResult.toString();
	}

	static String reverseStringByWords(String string) {

		StringBuilder stringBuilder = new StringBuilder();
		String[] words = string.split(" ");

		for (int j = words.length - 1; j >= 0; j--) {
			stringBuilder.append(words[j]).append(' ');
		}
		return stringBuilder.toString();
	}

	static String[] splitBySpace(String string) {

		return string.split(" ");
	}

	static boolean isPolindrome(String str) {
		if (str.equalsIgnoreCase(reverceString(str)))
			return true;
		else
			return false;
	}

	static void println(String str) {
		System.out.println(str);
	}

	static String readln(BufferedReader br) {

		try {
			return br.readLine();
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
}

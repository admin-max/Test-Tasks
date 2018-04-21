package testTasks;

import java.util.ArrayList;

/*

Specification
Write a program returning the largest palindromic number that is product of two prime 5-digit numbers. 
The program must also return both factors multiplied.
A prime number is a whole number greater than 1 whose only factors are 1 and itself (2, 3, 5, 7, 11, …).
A palindrome is a sequence of characters which reads the same backward as forward (i.e. ABBA)
 
*/

public class Test_task_largest_palindromic_number {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int startNumber = 10000;
		int endNumber = 99999;

		ArrayList<Integer> list = primeNumbers(startNumber, endNumber);

		getLargestPalindromicNumberFromArrList(list);
		// result: 999949999 = 33211 * 30109

		// measure execution time. (7364)		
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);

	}

	public static ArrayList<Integer> primeNumbers(int startNum, int endNum) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		int end = endNum, start = startNum;
		int count = 0;

		while (end >= start) {
			
			// excluding odd numbers and numbers that can be divided by 3
			
			if (end % 2 != 0 && end % 3 != 0) {
				for (int i = 5; i < end; i += 2) {

					// count dividers
					if (end % i == 0) {

						count++;

					}

				}
				
				// if dividers' counter still 0, it indicates that number is prime
				
				if (count == 0) {
					list.add(end);
				}
				count = 0;
			}

			end--;
		}
		return list;
	}

	public static void getLargestPalindromicNumberFromArrList(ArrayList<Integer> list) {

		// will store our data in ArrayList and result of multiplication will be
		// above int capacity, must use long instead
		
		ArrayList<Long> result = new ArrayList<>();
		ArrayList<Integer> num1arr = new ArrayList<>();
		ArrayList<Integer> num2arr = new ArrayList<>();

		int num1, num2;
		long multiple;

		// will check for largest result of multiplication
		
		long maxMultiple = 0L;

		for (int a : list) {
			for (int b : list) {

				num1 = a;
				num2 = b;

				multiple = (long) a * b;

				if (multiple > maxMultiple) {

					if (isPalindrome(multiple)) {

						result.add(multiple);
						num1arr.add(num1);
						num2arr.add(num2);
						maxMultiple = multiple;
					}
				}
			}
		}

		// the largest number will be displayed the last
		
		int index = result.size() - 1;

		if (!(result.isEmpty())) {

			System.out.println(result.get(index) + " = " + num1arr.get(index) + " * " + num2arr.get(index));
		} else {
			System.out.println("ArrayList is empty");
		}
	}

	public static boolean isPalindrome(long num) {

		ArrayList<Integer> list = new ArrayList<>();

		long temp = num;

		long add;

		while (temp > 0) {

			add = temp % 10;
			temp /= 10;
			list.add((int) add);

		}

		int length = list.size() - 1;
		for (int i = 0, j = length; i < length + 1; i++, j--) {

			if (list.get(i) != list.get(j)) {
				return false;
			}
		}

		return true;

	}
}

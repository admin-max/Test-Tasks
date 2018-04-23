package testTasks;

/*
 * Write an efficient Java program to find the sum of contiguous 
 * subarray within a one-dimensional array of numbers which has the largest sum.
 */

public class KadaneProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = { -2, 0, 1, 3, 4, 0, 5, 2, -2, 9, -1, 0};
		
		System.out.println(kadaneAlgorithm(arr));

	}
	
	public static int kadaneAlgorithm (int [] arr){
		
		int maxForNow = 0;
		int maxEndPoint = 0;
		
		for (int i = 0; i < arr.length; i++){
			
			maxEndPoint += arr[i];
			
			if (maxEndPoint < 0)
				maxEndPoint = 0;
			
			if (maxForNow < maxEndPoint)
				maxForNow = maxEndPoint;
		}
		return maxForNow;
					
		}
	}



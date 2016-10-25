package diagonal;

public class NegativePositive {

	public static int[] arrA;

	public void solve() {
		
		int low = 0;
		int high = arrA.length;
		
		int i = low;
		int j = high - 1;
	    // if high is odd, we have even number of elements.
		// if high is even, we have odd number of elements
		// 0 1 2 3 4 5 6, high = 7;
		// we go thorugh 01 23 45,...
		// 0 1 2 3 4 5; high = 6;
		// we go through 0,1 , 2, 3,  4,5
		while (i + 1 <= high - 1)
		{
			if (arrA[i] * arrA[i + 1] < 0)
			{
				i =  i + 2;
				continue;
			}
			// now we have i and i+1 different sign
			if (arrA[i] < 0)
			{
				 j = high - 1;
				while (j > i + 1 && arrA[j] <0)
					j--;
				swap(i+1,j);
			}
			else
				// a[i] is positive. swap with negative
			{
				 j = high - 1;
				while (j > i + 1 && arrA[j] > 0)
					j--;
				swap(i,j);				
			}
			
			i = i + 2;
		}

	}
	
	public void rerrange(int[] arrA) {
		int pivot = 0;
		int left = 0;
		int right = arrA.length - 1;
		while (right > left) {
			while (arrA[left] < 0 && left < right)
				left++;
			while (arrA[right] > 0 && left < right)
				right--;
			if (left < right) {

				int temp = arrA[left];
				arrA[left] = arrA[right];
				arrA[right] = temp;
				left++;
				right--;
			}
		}
		// At the point all the negative elements on the left half and
		// positive elements on the right half of the array
		// swap the every alternate element in the left half (negative
		// elements) with the elements in the right (positive elements)
		left = 1;
		int high = 0;
		while (arrA[high] < 0)
			high++;
		right = high;
		while (arrA[left] < 0 && right < arrA.length) {
			int temp = arrA[left];
			arrA[left] = arrA[right];
			arrA[right] = temp;
			left = left + 2;
			right++;
		}
		for (int i = 0; i < arrA.length; i++) {
			System.out.print("  " + arrA[i]);
		}
	}
	
	public void swap(int i, int j) {

		if (i < j) {
			int temp = arrA[i];
			arrA[i] = arrA[j];
			arrA[j] = temp;
		}

	}
	
	public void printArray(int[] arrA) {
		for (int i = 0; i < arrA.length; i++) {
			System.out.print(" " + arrA[i]);
		}
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrA = { 1, 2, -3, -4, -5, 6, -7, -8, 9, 10, -11, -12, -13, 14 };
		NegativePositive i = new NegativePositive();
		i.rerrange(arrA);
	}

}

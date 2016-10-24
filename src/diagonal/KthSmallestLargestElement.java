package diagonal;

public class KthSmallestLargestElement {

	public int findkthSmallestElement(int[] arrA, int k) {
		k = k - 1; // since array index starts with 0
		return kSmall(arrA, 0, arrA.length - 1, k);
	}

	public int kSmall(int[] arrA, int start, int end, int k) {
		int left = start;
		int right = end;
		int pivot = start;
		while (left <= right) {
			while (left <= right && arrA[left] <= arrA[pivot])
				left++;
			while (left <= right && arrA[right] >= arrA[pivot])
				right--;
			if (left < right) {
				swap(arrA, left, right);
				left++;
				right--;
			}
		}

		swap(arrA, pivot, right);
		if (right == k)
			return arrA[pivot];// if pivot is kth element , return
		else if (right  < k)
			// if pivot is less than k, then kth element will be on the right
			return kSmall(arrA, right + 1, end, k);
		else
			// if pivot is greater than k, then kth element will be on the right
			return kSmall(arrA, start, right - 1, k);
	}

	public void swap(int[] arrA, int a, int b) {
		int x = arrA[a];
		arrA[a] = arrA[b];
		arrA[b] = x;
	}

	public static void main(String args[]) {
		int[] arrA = { 4,6,5,2,8 };
		KthSmallestLargestElement k = new KthSmallestLargestElement();
		int a = 4;
		int x = k.findkthSmallestElement(arrA, a);
		System.out.print("The " + a + "th smallest element is : " + x);
	}

}

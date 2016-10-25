package diagonal;
// It can also find non duplicate one.
public class oddOccuringNumber {

	public static int findNumber(int [] A){
		int x=0;
		for(int i=0;i<A.length;i++){
			x= x^A[i];
		}
		return x;
	}
	public static void main(String[] args) {
		//int[] A = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7 };
		int [] A = { 2,1,3,5,5,3,2,1,6,7,7,8,8};
		System.out.println("Element appearing add number of times: " + findNumber(A));

	}
}

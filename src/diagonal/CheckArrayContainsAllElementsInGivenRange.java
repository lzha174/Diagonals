package diagonal;

public class CheckArrayContainsAllElementsInGivenRange {

	public Boolean find(int[] arrA, int x, int y) {
		int range = y - x + 1;
		
		for(int i = 0;i<arrA.length;i++){
			arrA[i] = arrA[i]-x + 1;
		}
		
		for(int i = 0;i<arrA.length;i++){
			int f  = Math.abs(arrA[i]) -1;
			if(arrA[f]>0){
				arrA[f] = arrA[f]*-1;
			}

		}
		
		// for(int i=0;i<arrA.length;i++){
		// System.out.print("  " + arrA[i]);
		// }
		for (int i = 0; i < range; i++) {
			if (arrA[i] > 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws java.lang.Exception {
		int[] arrA = { 2, 1, 3, 1, 5};
		int x = 1;
		int y = 4;
		CheckArrayContainsAllElementsInGivenRange i = new CheckArrayContainsAllElementsInGivenRange();
		System.out.println(i.find(arrA, x, y));
	}
}
package diagonal;

import java.util.Arrays;

public class Array {
	/*
	 * http://algorithms.tutorialhorizon.com/rearrange-the-array-of-given-range-n-such-that-aii/
	 * a2 = 6;
x = 6;
try to put 6 to slot 6...

if slot 6 is occupied ( != -1 != 6)
copy value 2 from 6 to y. y = 2;

so now we can put to 6....

now x become 2....check if slot 2 is occcupied....
a[2] = 6.....
y = 6;
put 2 to a[2];
x = 6;
check a[6]..which is 6....so we quit the loop...
at this stage.. we can have a[6] = -1;
in this case...we should put 6 to a[6].

now lets go back to the original slot 2...
if a[2] != 2;
it means we dont have the value for this slot..so we set it to be -1..
originaly, it has a value for other slot..
basically, we expect the while loop will put the value at 2 to the correct slot, and get 2 from some other position.
*/
		public static int[] fix(int[] A) {
			for (int i = 0; i < A.length; i++) {
				if (A[i] != -1 && A[i] != i) {
					int x = A[i];
					while (A[x] != -1 && A[x] != x) { // check if desired place is not vacate
						int y = A[x]; // store the value from desired place
						A[x] = x; // place the x to its correct position
						x = y; // now y will become x, now search the place for x
					}
					A[x] = x; // place the x to its correct position
					if(A[i]!=i){//check if while loop hasn't set the correct value at A[i]
						A[i] = -1; // if not then put -1 at the vacated place
					}
					
				}
			}
			return A;
		}

		public static void main(String[] args) {
			int A[] = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
			System.out.println("Fixed Indexed Array " + Arrays.toString(fix(A)));
			int B[] = { 19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2,
					14, 17, 4, };
			System.out.println("Fixed Indexed Array " + Arrays.toString(fix(B)));

		}


}

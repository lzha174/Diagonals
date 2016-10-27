package diagonal;

public class DistanceRootToNode {

	public int Pathlength(Node root, int n1) {
		// I like the recursive pass value back to the top
		// this returns number of nodes
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
					|| (x = Pathlength(root.right, n1)) > 0) {
				return x + 1;

			}
			return 0;
		}
		return 0;
	}

	public int Pathlength2(Node root, int n1, int length) {
		if (root != null) {
			if (root.data == n1)
			{
				return length;
			}
			int length1 = Pathlength2(root.left, n1, ++length);
			int length2 = Pathlength2(root.right, n1, length);
		     
			if (length1 > 0)
				return length1;
			if (length2 > 0)
				return length2;
			
			return 0;
		}
		return 0;
	}
	
	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);
		DistanceRootToNode i = new DistanceRootToNode();
		System.out.println("Distance from root to 45 is : "
				+ (i.Pathlength(root, 30)-1));
		
		System.out.println("Distance from root to 45 is : "
				+ (i.Pathlength2(root, 30, 0)));
	}

}

package diagonal;

public class DeepestNode {
	int deepestlevel;
	int value;

	public int Deep(Node root) {
		find(root, 0);
		return value;
	}

	public void find(Node root, int level) {
		if (root != null) {
			find(root.left, ++level);
			find(root.right, level);
			if (level > deepestlevel) {
				value = root.data;
				deepestlevel = level;
			}
		}
	}

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(5);
		root.left.left.right = new Node(6);
		root.left.left.right.right = new Node(7);


		DeepestNode dp = new DeepestNode();
		System.out.println("Deepest child is: " + dp.Deep(root));
		System.out.println("Deepest level is: " + dp.deepestlevel);

	}
}

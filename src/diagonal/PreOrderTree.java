package diagonal;

import java.util.Stack;

public class PreOrderTree {
	public void preOrderRecursive(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderRecursive(root.left);
			preOrderRecursive(root.right);
		}
	}

	public void preorderIteration(Node root) {
		Stack<Node> s = new Stack<Node>();
		while (true) {
			// First print the root node and then add left node
			while (root != null) {
				System.out.print(root.data + " ");
				s.push(root);
				root = root.left;
			}
			// check if Stack is emtpy, if yes, exit from everywhere
			if (s.isEmpty()) {
				return;
			}
			// pop the element from the stack and go right to the tree
			root = s.pop();
			root = root.right;
		}
	}
	
	public void DFS(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		while (s.isEmpty() == false) {
			Node x = s.pop();
			if(x.right!=null) s.add(x.right);
			if(x.left!=null) s.add(x.left);			
			System.out.print(" " + x.data);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		PreOrderTree i = new PreOrderTree();
		i.preOrderRecursive(root);
		System.out.println();
		i.preorderIteration(root);
		System.out.println();
		i.DFS(root);
	}

}


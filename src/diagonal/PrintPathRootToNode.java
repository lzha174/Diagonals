package diagonal;
import java.util.ArrayList;
import java.util.Collections;
public class PrintPathRootToNode {

	public static ArrayList path;

	int [] paths = new int[500];
	int pathLength =0;
	
	public Boolean printPath(Node root, Node dest){
		if(root==null) return false;
		// I like this backtracking(easy to build the path or the length)
		if(root==dest||printPath(root.left,dest)||printPath(root.right,dest)){
			//System.out.print("  " + root.data);
			path.add(root.data);
			return true;
		}
		return false;
	}
	
	public void printPath2(Node root, Node dest, int pathLen){
		if(root==null) return;
		
		paths[pathLen]= root.data;
		if(root==dest)
		{
			print1(paths,++pathLen);
			return;
		}
		
		printPath2(root.left,dest, ++pathLen);
		printPath2(root.right,dest, pathLen);
		return;
	}
	
	public void print1(int [] path, int pathLen){
		for(int i=0;i<pathLen;i++){
			System.out.print(path[i]+ " ");
		}
		System.out.println();
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(1);
		root.left = new Node (2);
		root.right = new Node (3);
		Node n1 = new Node (4);
		root.left.left = n1;
		root.left.right = new Node (5);
		Node n2 = new Node (8);
		root.left.right.right = n2;
		root.left.right.left = new Node (7);

		PrintPathRootToNode i = new PrintPathRootToNode();
		path = new ArrayList();
		i.printPath(root,n2);
		i.printPath2(root, n2, 0);
		Collections.reverse(path);
		System.out.println(" Path " + path);
	}

}

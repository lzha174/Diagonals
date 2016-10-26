package diagonal;
public class SingleThreadedBinaryTree {

    public static NodeThread root;

    public void insert(NodeThread root, int id){
    	NodeThread newNode = new NodeThread(id);
    	NodeThread current = root;
    	NodeThread parent = null;
        while(true){
            parent = current;
            if(id<current.data){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    newNode.right = parent;
                    newNode.rightThread = true;
                    return;
                }
            }else{
                if(current.rightThread==false){
                    current = current.right;
                    if(current==null){
                        parent.right = newNode;
                        return;
                    }
                }else{
                	NodeThread temp = current.right;
                    current.right = newNode;
                    newNode.right = temp;
                    newNode.rightThread=true;
                    return;
                }
            }
        }
    }

    public void print(NodeThread root){
        //first go to most left node
    	NodeThread current = leftMostNode(root);


        //now travel using right pointers
        while(current!=null){
            System.out.print(" " + current.data);
            //check if node has a right thread
            if(current.rightThread)
                current = current.right;
            else // else go to left most node in the right subtree
                current = leftMostNode(current.right);
        }
        System.out.println();
    }

    public NodeThread leftMostNode(NodeThread node){
        if(node==null){
            return null;
        }else{
            while(node.left!=null){
                node = node.left;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        root = new NodeThread(6);
        SingleThreadedBinaryTree st=new SingleThreadedBinaryTree();
        st.insert(root,3);
        st.insert(root,8);
        st.insert(root,1);
        st.insert(root,5);
        st.insert(root,7);
        st.insert(root,11);
        st.insert(root, 9);
        st.insert(root, 13);
        

        st.print(root);
    }

}
class NodeThread{
	NodeThread left;
	NodeThread right;
    int data;
    boolean rightThread;
    public NodeThread(int data){
        this.data = data;
        rightThread = false;
    }
}
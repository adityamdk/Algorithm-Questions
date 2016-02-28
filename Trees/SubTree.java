
//Program to check if a given tree is subtree of another tree

package subtree;

class Node
{
    int data;
    Node left,right;
    public Node(int dat)
    {
        data = dat;
        left=right=null;
    }
    
}


public class SubTree {
    static Node n1,n2;
    
    boolean isSubtree(Node T,Node S)
    {
        
        if(S==null)
            return true;
        if(T==null)
            return false;
        if(isIdentical(T,S))
            return true;
        
        return (isSubtree(T.right,S)||isSubtree(T.left,S));
    }
    boolean isIdentical(Node T,Node S)
    {
        if(T==null && S==null)
        {
            return true;
        }
        
        if(T==null || S==null)
        {
            return true;
        }

        return((T.data ==S.data)&&(isIdentical(T.right,S.right))&&(isIdentical(T.left,S.left)));
    }
    public static void main(String[] args) {
        //Tree 1
        SubTree st = new SubTree();
        st.n1 = new Node(1);
        st.n1.right = new Node(3);
        st.n1.left = new Node(2);
        st.n1.left.left = new Node(4);
        st.n1.left.right = new Node(5);
        
        //Tree 2
        
        st.n2 = new Node(2);
        st.n2.left = new Node(4);
        st.n2.right = new Node(5);
        
        boolean value = st.isSubtree(n1,n2);
        System.out.println("n1 is subtree of n2 is "+value);
                
    }
    
}

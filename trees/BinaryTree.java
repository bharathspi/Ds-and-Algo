import java.util.*;
public class BinaryTree
 {
    TreeNode root;
    class TreeNode
     {

         TreeNode right;
         TreeNode left;
          int data;
        TreeNode(int d)
         {
            right=null;
             left=null;
             data=d;
         }

     }

 //Level order insertion in a BinarY Tree
  public TreeNode levelOrderInsert(TreeNode root,int d)
   {
       TreeNode temp = new TreeNode(d);
       if(root==null)
       	{
            root =temp;
            return root;
       	}

       	Queue<TreeNode> q = new LinkedList<TreeNode>();
       	q.add(root);
       	while(!q.isEmpty())
        {
           TreeNode dummy =q.remove();

           if(dummy.left==null)
           {
           	  dummy.left=temp;
           	  return root;
           }
           else
           	  q.add(dummy.left);

           if(dummy.right==null)
           {
               dummy.right=temp;
               return root;
           }
           else
           	  q.add(dummy.right);

        }

   return root;

   }

//LevelOrder Traversal 
  public void levelOrderTraversal(TreeNode root)
   {
            TreeNode temp = root;
           Queue<TreeNode> q = new LinkedList<TreeNode>();
           q.add(temp);
           while(!q.isEmpty())
           {
                TreeNode dummy = q.remove();
                if(dummy!=null)
                    System.out.print(dummy.data+" ");
                if(dummy.left!=null)
                     q.add(dummy.left);
                 if(dummy.right!=null)
                     q.add(dummy.right);
      
           }



   }
   //Preorder recursive version

   public void preOrderRec(TreeNode root)
    {
         if(root==null)
             return;
           System.out.print(root.data+" ");
            preOrderRec(root.left);
            preOrderRec(root.right);
    }

  //Inorder recursive version
   
   public void inOrderRec(TreeNode root)
   {
         if(root==null)
            return;
          inOrderRec(root.left);
          System.out.print(root.data+" ");
          inOrderRec(root.right);
        
   }

   //PostOrder recursive version
   public void postOrderRec(TreeNode root)
   {
       if(root==null)
           return;
         postOrderRec(root.left);
         postOrderRec(root.right);
         System.out.print(root.data+" ");

   }
  
  //Iterative version Inorder
  //Ref: https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
  public void itrInOrder(TreeNode root)
   {
      Stack<TreeNode> st  = new Stack<TreeNode>();
       TreeNode current  = root;
       while(!st.isEmpty()||current!=null)
         {
              while(current!=null)
                 {
                    st.push(current);
                    current=current.left;
                        
                 }

                    current=st.pop();
                    System.out.print(current.data+" ");
                    current=current.right;


}
         }
  //Iterative version preOrder traversal
  //Ref: modify INORDER a bit
  //Time-O(n) it is same for every traversal
public void itrPreOrder(TreeNode root)
   {
      Stack<TreeNode> st  = new Stack<TreeNode>();
       TreeNode current  = root;
       while(!st.isEmpty()||current!=null)
         {
            
              while(current!=null)
                 {
                   System.out.print(current.data+" ");
                    st.push(current);
                    current=current.left;
                        
                 }
               current=st.pop();
               current=current.right;

         }
    }

//Iterative version of postOrder traversal
//This is little complex it can be done using 2 methods
//using 1 stack
//using 2 stacks
//do it when you get time
    public void itrPostOrder(TreeNode root)
    {
      
    }


//Finding max in a BinaryTree using Rescursion
//You can also do this with levelorder traversal without recurrsion
//Time - O(n) Space -O(n)
//Keep it up this code is written by you only without any help. It even passes all test case in GFG:)
public int findMax(TreeNode root)
 {
   if(root==null)
     {
       return -1;
     }
      
       return Math.max(findMax(root.left),Math.max(findMax(root.right),root.data));

 }
 //Search for an element in a BinaryTree using Recurrsion
 //You can also do this with levelorder traversal without recurrsion
 //Time - O(n) Space -O(n)
 public boolean search(TreeNode root,int key)
  {
    if(root==null)
        return false;
    if(root.data==key)
        return true;

       return search(root.left,key)||search(root.right,key);
  }

//Find the size of a BinaryTree size means no of node ina binary tree using recurrsion
//You can also do this with levelOrder trversal Iteratively
//Time O(n) space O(n);
public int size(TreeNode root)
 {
   if(root == null)
      return 0;
    return size(root.left)+size(root.right)+1;

 }
//Find the height of the BinaryTree using recurrsion
//Time O(n) space O(n)
/*The height of the binary tree is the longest path from root node to any leaf node in the tree*/
 public int heightRec(TreeNode root)
 {
   if(root==null)
       return 0;
     return Math.max(heightRec(root.left),heightRec(root.right))+1;

 }

//Find the height of the binary tree without using recurrsion
//This can be done using levelOrder traversal
//Time O(n)
//REF: https://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/#:~:text=We%20can%20use%20level%20order,the%20next%20level%20is%200.
//This method can also be use to determine the no of nodes at given level
 public int itrHeight(TreeNode root)
 {
     if(root==null)
        return 0;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    int height = 0;
    int nodeCount=0;
    while(true)
    {
        nodeCount = q.size();
         if(nodeCount==0)
             return height;
          height++;
         while(nodeCount-->0)
            {
              TreeNode temp =  q.remove();
               if(temp.left!=null)
                   q.add(temp.left);
               if(temp.right!=null)
                   q.add(temp.right);

            }

    }
  }
//Find the minimum depth of the binary Tree using recurrsion
//Time O(n)
//Ref: https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
public int minDepth(TreeNode root)
{
    if(root==null)
       return 0;
    if(root.left==null&&root.right==null)
          return 1;
    if(root.left==null)
        return minDepth(root.right)+1;
      if(root.right==null)
         return minDepth(root.left)+1;
    return Math.min(minDepth(root.left),minDepth(root.right))+1;

}
//Find the minimum depth of the binary Tree without using recurssion
//can be done using level order traversal
//Time O(n)
//Ref: https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
//mindepth iterative approch in the above reference is wrong below is the correct one and 
//passed all test cases in leetcode
public int minDepthItr(TreeNode root) {
        if(root==null)
              return 0;
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        int mindepth=0,nodecount=0;;
        while(true)
        {
           q.add(root);
            nodecount = q.size();
        if(nodecount==0)
              return mindepth;
         mindepth++;
         while(nodecount-->0)
         {
             TreeNode temp = q.remove();
             if(temp.left==null&&temp.right==null)
                   return mindepth;
               if(temp.left!=null)
                q.add(temp.left);
              if(temp.right!=null)
                q.add(temp.right);
          
         }
          
        }
        
    }
//No of leafNodes in a binarytree this solution passed all test cases in GFG
//the approch is sames as mindepth but here we keep a counter for every leafnode
  public int countLeaves(TreeNode node) 
    {
        TreeNode root=node;
        if(root==null)
            return 0;
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      q.add(root);
      int noOfLeafNodes = 0;
      int no_nodes=0;
      while(true)
      {
          no_nodes=q.size();
          if(no_nodes==0)
             return noOfLeafNodes;
           while(no_nodes-->0)
           {
               TreeNode temp=q.remove();
               if(temp.left==null&&temp.right==null)
                   noOfLeafNodes++;
                if(temp.left!=null)
                   q.add(temp.left);
                 if(temp.right!=null)
                   q.add(temp.right);
           }
          
      }
    }

//check if two binary trees have same structure and also same values in them
//This solution passes all test cases in leetcode
//Time complexity O(n)
public boolean isSameTree(TreeNode root1,TreeNode root2)
{
  if(root1==null&&root2==null)
      return true;
  if(root1==null||root2==null)
      return false;
  if(root1.data!=root2.data)
      return false;
  return isSameTree(root1.left,root2.left)&&isSameTree(root1.right,root2.right);

}

//find the diameter of the treeThe diameter of a binary tree is the length 
//of the longest path between 
//any two nodes in a tree. This path may or may not pass through the root.
//Diameter of a tree can be calculated by only using the height function, 
//because the diameter of a tree is nothing 
//but maximum value of (left_height + right_height + 1) for each node
//O(n^2) solution
//This solution is coded by me and passed all test cases in both GFG and leetcode
//Approch is just to call height method on each node while doing level order traversal
// and find max it is the answer
  public int diameterOfBinaryTreeBruteForce(TreeNode root) {
        if(root==null)
           return 0;
         Queue<TreeNode> q = new LinkedList<TreeNode>();
         q.add(root);
         int max = Integer.MIN_VALUE;
         while(!q.isEmpty())
         {
             TreeNode temp = q.remove();
             int heightl = heightRec(temp.left);//already defined 
             int heightr = heightRec(temp.right);
             max=Math.max(max,heightl+heightr+1);
             if(temp.left!=null)
                q.add(temp.left);
              if(temp.right!=null)
                q.add(temp.right);
         }
        return max;
    }
//O(n) solution
//In this approch there is no need to calculate height seprately
static int diameter;//global like variable to store answer
public int diameterOfBinaryTreeOptimized(TreeNode root)
{
   if(root ==null)
       return 0;
     int left = diameterOfBinaryTreeOptimized(root.left);
     int right = diameterOfBinaryTreeOptimized(root.right);
     diameter = Math.max(diameter,left+right+1);
     return Math.max(left,right)+1;
}

//Vertical sum time O(n) space O(n)
//ref:https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
 public void verticalSum(TreeNode root,int key)
 {   if(root==null)
       {
        return;
       }
         
         verticalSum(root.left,key-1);
         System.out.println(key+" "+root.data);
           if(map.containsKey(key))
                map.put(key,map.get(key)+root.data);
            else
                map.put(key,root.data);
        verticalSum(root.right,key+1);
 }

//Finding the mirror tree of given tree
public void makeTreeMirror(TreeNode root)
{
   if(root==null)
       return;
    makeTreeMirror(root.left);
    makeTreeMirror(root.right);
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
}

//check if two trees are mirror images to eachother
//approch 1: find inorder trversal if one is opposite to other than they are
//mirror images to each other
//approch2 below
public boolean checkMirror(TreeNode root1,TreeNode root2)
{
    if(root1==null&&root2==null)
        return true;
    if(root1==null||root2==null)
        return false;
      if(root1.data!=root2.data)
         return false;
    return checkMirror(root1.left,root2.right)&&checkMirror(root1.right,root2.left);

}

//root to leaves all paths
//time o(n^2)
public void rootToLeafPaths(TreeNode root,StringBuilder sb,ArrayList<String> arr)
{
   if(root==null)
     return;
    sb.append(root.data);
   if(root.left==null&&root.right==null)
   {
      arr.add(sb.toString());
      System.out.println(sb.toString());
      return;
   }
   sb.append("->");
    rootToLeafPaths(root.left,new StringBuilder(sb),arr);
    rootToLeafPaths(root.right,new StringBuilder(sb),arr);
       


}
//Check if the path exists
//O(n)
public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
    if(root.left==null&&root.right==null&&root.data==targetSum)
        return true;
        return hasPathSum(root.left,targetSum-root.data)||hasPathSum(root.right,targetSum-root.data);
}

//find the  ancestors for a given node
//Ref:https://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
//watch a video in that page at the bottom for clear reference
//Time O(n)
public boolean ancestors(TreeNode root, int targetNode , ArrayList<Integer> answer)
{
  if(root==null)
      return false;
  if(root.data==targetNode)
     return true;
   if(ancestors(root.left,targetNode,answer)||ancestors(root.right,targetNode,answer))
        {
           answer.add(root.data);
           return true;
        }
      return false;
}

//Least common ancestors
//Time O(n)
//space O(n)
//This algo only works if there both nodes are present or both nodes are not present(returns null)
//if only one node is present then it will return the node that is present itself
public TreeNode LCA(TreeNode root,int n1,int n2)
{
  if(root==null)
      return null;
   if(root.data==n1||root.data==n2)
       return root;
   TreeNode left=LCA(root.left,n1,n2);
   TreeNode right = LCA(root.right,n1,n2);
   if(left!=null&&right!=null)
      return root;
  return left==null?right:left;

}







//zig-zag traversal 
//Time O(n)
//Space O(n)
  ArrayList<Integer> zigZagTraversal(TreeNode root)
  {
      ArrayList<Integer> answer = new ArrayList<Integer>();
      if(root==null)
         return answer;
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      q.add(root);
      int nodeCount=0,level=0;
      Stack<Integer> st = new Stack<Integer>();
      while(true)
      {
          nodeCount = q.size();
          if(nodeCount==0)
                break;
          while(nodeCount-->0)
          {
             TreeNode temp = q.remove();
             if(level%2==0)
               answer.add(temp.data);
              else
               {
                   st.add(temp.data);
               }
               if(temp.left!=null)
                 q.add(temp.left);
                 if(temp.right!=null)
                   q.add(temp.right);
          }
             if(level%2!=0)
              {
                  while(!st.isEmpty())
                    answer.add(st.pop() );
              }
              level++;
          
      }
      return answer;
  }
    public static void main(String [] args)
     {
          
       BinaryTree bt = new BinaryTree();
       bt.root=bt.levelOrderInsert(bt.root,1);
       bt.root=bt.levelOrderInsert(bt.root,2);
       bt.root=bt.levelOrderInsert(bt.root,3);
       bt.root=bt.levelOrderInsert(bt.root,4);
       bt.root=bt.levelOrderInsert(bt.root,5);
       bt.root=bt.levelOrderInsert(bt.root,6);
       bt.root=bt.levelOrderInsert(bt.root,7);
        //bt.levelOrderTraversal(bt.root);
      /* System.out.println();
       bt.postOrderRec(bt.root);
       System.out.println();
       bt.inOrderRec(bt.root);
       System.out.println();
       bt.preOrderRec(bt.root);
       System.out.println();*/
      // bt.itrInOrder(bt.root);
      // bt.itrPreOrder(bt.root);
        //bt.itrPostOrder(bt.root);
       //System.out.println(bt.findMax(bt.root));
       //System.out.println(bt.search(bt.root,1));
       //System.out.println(bt.size(bt.root));
       //System.out.println(bt.heightRec(bt.root));
        //System.out.println(bt.minDepth(bt.root));
        //.out.println(bt.diameterOfBinaryTree(bt.root));
         //bt.verticalSum(bt.root,0);
         //System.out.println(map.entrySet());
        //ArrayList<String> arr = new ArrayList<String>();
       //StringBuilder sb = new StringBuilder();
       //bt.rootToLeafPaths(bt.root,sb,arr);
   System.out.println(bt.LCA(bt.root,2,3).data);
  }
     }

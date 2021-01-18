//LEETCODE LINKED LIST MOST ASKED IN INTERVIEWS: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/
//git Commands git init
//git add .
//git commit -m "comment here"
//git push -u origin master
import java.util.*;
public class LinkedList
{
	Node head;
    class Node
     {
    	int data;
    	Node next;
    Node(int d)
     {
     	this.next=null;
     	this.data=d;
     }
    }


 public LinkedList insertLast(LinkedList list,int d)
 {
    Node new_node = new Node(d);
    if(list.head==null)
      {
      	list.head=new_node;
      	return list;
      }
      Node temp = list.head;
      while(temp.next!=null)
      {
      	temp=temp.next;
      }

      temp.next=new_node;

    return list;
 }

 public LinkedList insertFirst(LinkedList list, int d)
 {
 	Node new_node =  new Node(d);
 	new_node.next =list.head;
 	list.head=new_node;
 	return list;
 }

 public LinkedList deleteFirst(LinkedList list)
 {
 	list.head=head.next;
 	return list;
 }

 public LinkedList deleteLast(LinkedList list)
 {
 	if(list.head.next==null)
 	{
       list.head=null;
       return list;
 	}
 	Node temp=list.head;
 	while(temp.next.next!=null)
 	{
 		temp=temp.next;	
 	}
 	temp.next=null;
  return list;
 }

 //IF you give index "1" it will insert node at first node and previously first becomes 2nd now
 //Example insert "#" at 3rd position in the linked list 1,2,3,4,5,6
 //Result: 1,2,#,3,4,5,6
 //Note indexing starts with "1" means '0' is invalid
 public LinkedList insertAtIndex(LinkedList list, int index, int d)
 {
    Node new_node = new Node(d);
    Node temp= list.head;
    if(index==1) //for inserting at head
     {
        new_node.next=list.head;
        list.head= new_node;
        return list;
     }
     index-=2; // Because we need to traverse to before node for insertion
    while(index-->0)
    {
    	temp=temp.next;

    }

    new_node.next=temp.next;
    temp.next=new_node;

 return list;
 }

 //IF you give index "1" it will delete the first node
 //Example delete 3rd position in the linked list 1,2,3,4,5,6
 //Result: 1,2,4,5,6
 //Note indexing starts with "1" means '0' is invalid
public LinkedList deleteAtIndex(LinkedList list, int index)
{
	if(index==1) //to delete head
	{
		list.head=head.next;
		return list;
	}
	index-=2; // Because we need to traverse to before node for insertion
	Node temp= list.head;
	while(index-->0)
	{
		temp=temp.next;
	}
	temp.next=temp.next.next;
    return list;
}

//revering linked list using iteration
/*Initialize three pointers prev as NULL, curr as head and next as NULL.
Iterate through the linked list. In loop, do following. 
// Before changing next of current, 
// store next node 
next = curr->next
// Now change next of current 
// This is where actual reversing happens 
curr->next = prev 
// Move prev and curr one step forward 
prev = curr 
curr = next*/
public LinkedList reverseL(LinkedList list)
{
	Node current = list.head;
	Node prev =null;
	Node next=null;
	while(current!=null)
	{
		next=current.next;
		current.next=prev;
		prev=current;
		current=next;
	}
	list.head=prev;

	return list;
}

//Reference https://www.youtube.com/watch?v=KYH83T4q6Vs
//Video link can also be found in liked videos of youtube
//Revrsing Linked list using Recurssion
//https://www.geeksforgeeks.org/recursively-reversing-a-linked-list-a-simple-implementation/
public void reverseUsingRec(Node head)
{
	if(head.next==null||head==null)
	{
		this.head=head;
		return;
	}
      reverseUsingRec(head.next);
      Node temp=head.next;
      temp.next=head;
      head.next=null;
}

//Printing nth node from last using two pointer method
//Ref: Narasimha Karamunchi Question 5 page 79
 public int nthNodeFromTheEnd(LinkedList list, int n)
 {
 	Node nthNodeFromEnd=list.head;
 	Node temp=list.head;
   while(n-->0)
   	temp=temp.next;
  while(temp!=null)
  {
  	temp=temp.next;
  	nthNodeFromEnd=nthNodeFromEnd.next;
  }
  return nthNodeFromEnd.data;
 }

//Printing nth node from last using Recurssion
public Node nthNodeFromEndRec(Node head,int n,int [] c)
{
   if(head==null)
   	  {
   	  	return null;
   	  }
      Node result=nthNodeFromEndRec(head.next,n,c);
      c[0]++;
      if(c[0]==n)
      {
      	result = head;
      }

      return result;  
}

//merging two sorted Linked lists into list
public LinkedList merge(LinkedList list1, LinkedList list2)
{
	LinkedList merged_list = new LinkedList();
	Node temp1 = list1.head;
	Node temp2 = list2.head;
	while(temp1!=null&&temp2!=null)
	{
		if(temp1.data<temp2.data)
			{
				merged_list=merged_list.insertLast(merged_list,temp1.data);
				temp1=temp1.next;
		    }
		else
		{
			merged_list=merged_list.insertLast(merged_list,temp2.data);
			temp2=temp2.next;

		}
	}
	if(temp1==null)
	{
		while(temp2!=null)
		{
			merged_list=merged_list.insertLast(merged_list,temp2.data);
			temp2=temp2.next;
		}
	}
	else
	{
		while(temp1!=null)
		{
			merged_list=merged_list.insertLast(merged_list,temp1.data);
			temp1=temp1.next;
		}
	}
	return merged_list;
}

public void print(Node list)
{
	Node temp =  list;
    if(temp==null)
    {
     System.out.println("Empty");
     return;
    }
  while(temp!=null)
  {
  	System.out.print(temp.data+" ");  
  	temp=temp.next;
  }
  System.out.printf("\n");
}

public void printReverseUsingRec(Node head)
{
	if(head==null)
		return;
	printReverseUsingRec(head.next);
	System.out.print(head.data+" ");

}

//https://www.youtube.com/watch?v=Cs3KwAsqqn4&t=122s
//The above video explains why floyd cycle detection algorithm works finding the starting point of the loop.
	
//All QUESTIONS THAT YOU DID IN LINKED LISTS ARE THERE IN THE GOOGLE DOC

public static void main(String []  args)
{
   LinkedList list =  new LinkedList();
   // System.out.println("***Inserted 1 to 6 to the end of LinkedList***");
    Scanner obj  = new Scanner(System.in);
    int size  = obj.nextInt();
    int k;
    while(size-->0)
    {
    	k= obj.nextInt();
    	list=list.insertLast(list,k);
    }
    
    //list=list.insertLast(list,4);
    //list=list.insertLast(list,9);
    /*list=list.insertLast(list,7);
    list=list.insertLast(list,9);
    list=list.insertLast(list,11);*/
    //list.print(list.head);
    /*System.out.println("***Inserted 0 in the beginning***");
    list=list.insertFirst(list,0);
    list.print(list);
    System.out.println("***deleted the first element***");
    list=list.deleteFirst(list);
    list.print(list);
    System.out.println("***deleted the last element***");
    list=list.deleteLast(list);
    list.print(list);
    System.out.println("***Inserted 8 in the 3rd position***");
    list=list.insertAtIndex(list,3,8);
    list.print(list);
    System.out.println("***Deleted at 3rd index***");
    list=list.deleteAtIndex(list,3);
    list.print(list);
    System.out.println("***Reversed the list with iteration***");
    list=list.reverseL(list);
    list.print(list);;
    System.out.println("****Printing linked list Reverse using recurrsion****");
    list.printReverseUsingRec(list.head);
    System.out.println();
    System.out.println("***Reversing the LinkedList Using Reccursion***");
    list.reverseUsingRec(list.head);
    list.print(list);
    System.out.println("3 rd node from end using two Pointer method");
    System.out.println(list.nthNodeFromTheEnd(list,3));
    System.out.println("2 nd node from end using Reccursion");
    int []c =  new int[1];
    Node req = list.nthNodeFromEndRec(list.head,2,c);
    System.out.println(req.data);*/
    LinkedList list1 =  new LinkedList();
    int size1  = obj.nextInt();
    while(size1-->0)
    {
    	k= obj.nextInt();
    	list1=list1.insertLast(list1,k);
    }
     
     /*list1=list1.insertLast(list1,6);
     list1=list1.insertLast(list1,4);
     list1=list1.insertLast(list1,9);*/
     /*list1=list1.insertLast(list1,10);
     list1=list1.insertLast(list1,12);*/
     list1.print(list1.head);
     /*System.out.println("Merging 1->3->5->7->9->11 and 2->4->6->8->10->12");
    LinkedList sorted_list=list1.merge(list,list1);
    list1.print(sorted_list);*/
    //list1.print(list1.addTwoNumbers(list1.head,list.head));
    list1.addTwoNumbers(list1.head,list.head);

}

public int reverse(int d)
{
	int rev=0;
	while(d!=0)
	{
		int dit = d%10;
		rev=rev*10+dit;
		d=d/10;

	}
	return rev;
}


public Node addTwoNumbers(Node l1, Node l2) {
        LinkedList l= new LinkedList();
        Node temp1 = l1;
        Node temp2  = l2;
        int sum1=0;
        int sum2=0;
        while(temp1!=null)
        {
            sum1=sum1*10+temp1.data;
            temp1=temp1.next;
        }
        
        while(temp2!=null)
        {
            sum2=sum2*10+temp2.data;
            temp2=temp2.next;
        }
        int new_sum1=l.reverse(sum1);
        int new_sum2=l.reverse(sum2);
        int req_sum=new_sum1+new_sum2;
        //System.out.println(req_sum);
        Node req_head = null;
         System.out.println(new_sum1+" "+new_sum2);
        if(req_sum==0)
            return new Node(0);
        
            
        while(req_sum>0)
        {
            int digit = req_sum%10;
            Node new_node = new Node(digit);
            Node dummy = req_head;
            if(req_head==null)
            {
                req_head = new_node;
            }
            else
            {
                while(dummy.next!=null)
                {
                    dummy = dummy.next;
                }
                dummy.next=new_node;
            }
                req_sum=req_sum/10; 
            
        }

       
        

        return req_head;
        
        
        
    }
             }



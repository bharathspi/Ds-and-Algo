//LEETCODE LINKED LIST MOST ASKED IN INTERVIEWS: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/

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

public void reverseUsingRec(Node head)
{
	if(head.next==null)
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
public void print(LinkedList list)
{
	Node temp =  list.head;
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
public static void main(String []  args)
{
   LinkedList list =  new LinkedList();
    System.out.println("***Inserted 1 to 6 to the end of LinkedList***");
    list=list.insertLast(list,1);
    list=list.insertLast(list,2);
    list=list.insertLast(list,3);
    list=list.insertLast(list,4);
    list=list.insertLast(list,5);
    list=list.insertLast(list,6);
    list.print(list);
    System.out.println("***Inserted 0 in the beginning***");
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
    System.out.println(req.data);

}
             }



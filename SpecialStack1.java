//This class implements the getMin() from stack with time complexity O(1) and space O(n)
//Ref: https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
import java.util.*;
public class SpecialStack1 extends Stack<Integer>
 {
    Stack<Integer> minstack = new Stack<Integer>();

    public void push(int d)
    {
        if(isEmpty()==true)
        {
        	super.push(d);
        	minstack.push(d);
        }
        else
        {
        	super.push(d);
        	if(minstack.peek()>d)
        		minstack.push(d);
        	else
        		minstack.push(minstack.peek());
        }
    }

    public Integer pop()
    {
    	minstack.pop();
    	return super.pop();
    }

    public int getMin()
    {
    	return minstack.peek();
    }


    public static void main(String [] args)
    {
    	SpecialStack1 s = new SpecialStack1();
    	s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
    }
 }
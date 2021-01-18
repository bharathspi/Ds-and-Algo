//This class implements the getMin() from stack with time complexity O(1) and space O(1)
//Ref: https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
//In this method we follow these steps:
 /* step1: We always store the minimum element in the stack in minEle varible:
    step2: minEle is updated Like this:
        During push:
          1) if the element to be inserted is greater than or equal to minEle we does nothing to minEle
              and we push it to the stack.
           2)if the element to be inserted(lets says x) is less than minEle we do this before updating the minEle
              minEle we push 2*x-minEle to the stack here minEle is still previous min not updated. after
              pushing that to the stack we now change minEle to x. This done to retrive 2nd min if 1st min
              is poped.
        During Pop:
          1)if Poped elemet is greater than or equal to minEle we does nothing
          1)poped element will be less than minEle if the poped element is minimum and modified value
             is stored in it and original value is stored in minEle. So now we want the 2nd minimum because
             1st min is being deleted. That can be obtained from modified value whose value is
              2*x-2ndMin and at that point x is stored in minEle so... we need 2ndMin that'w why we do
              2*(MinEle(i.e., x))-elementPoped(i.e, 2*x-Minele)
         Note: Do spend some time in it you will understand this.*/

import java.util.*;

public class SpecialStack2 extends Stack<Integer>
 {
 	int minEle;
 	public SpecialStack2()
 	{
 		this.minEle = Integer.MIN_VALUE;
 	}
   public void push(int d)
   {
   	 if(isEmpty()==true)
   	 {
   	 	super.push(d);
   	 	this.minEle = d;
   	 }
   	 else
   	 {
   	 	if(d<this.minEle)
   	 	{
   	 		super.push(2*d-this.minEle);
   	 		minEle=d;
   	 	}
   	 }
   }

   public Integer pop()
   {
   	 if(super.peek()>=this.minEle)
   	 	return super.pop();
   	  else
   	  {
   	  	minEle=2*minEle-super.peek();
   	  }

   	  return super.pop();
   }

   public int getMin()
   {
   	System.out.println(this.minEle);
   	return this.minEle;
   }


 //maximum subarray size with a[i]<=a[i+1]
  public int maxSubSize(int [] a)
  {
  	Stack <Integer> s  = new Stack<Integer>();
  	int req=1;
  	for(int i = 0;i<a.length;i++)
  	{
  		if(s.isEmpty())
  			 s.push(a[i]);
  		else
  		{
  			if(s.peek()<=a[i])
  				{
  					s.push(a[i]);
  					 req=s.size();
  			    }
  			else
  			{
  				if(req<s.size())
  					req=s.size();
  				s.clear();
  				s.push(a[i]);

  			}

  		}
  	}

  	return req;
  }

  //Sorting stack
  //Ref: https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
   public static void main( String [] args)
    {
    	SpecialStack2 s = new SpecialStack2();
    	/*s.push(3); 
        s.push(5); 
        s.getMin(); 
        s.push(2); 
        s.push(1); 
        s.getMin(); 
        s.pop(); 
        s.getMin(); 
        s.pop(); 
        s.peek(); */

        int [] a = {6,3,4,5,2};
        System.out.println(s.maxSubSize(a));
    }
 }


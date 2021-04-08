import java.util.*;

//PROBLEM 2,3,4,5 ARE LEFT FROM NARASIMHA KARAMUNCHI THEY ARE RELATED TO INFIX,POSTFIX CONVERTIONS AND
//EVALUATION THEY ARE IMPORTANT DO READ THEM

public class Stacks
{
//Parenthesis balancing using stack it contains"{},[],()" and some characters.
	public boolean isValidParenthesis(String s)
	{
       Stack<Character> stack = new Stack<Character>();
       for(int i = 0 ; i<s.length();i++)
       {
       	char c= s.charAt(i);
       	char c1='0';
         if(c=='{'||c=='['||c=='(')
         	 stack.push(c);
         else if(c=='}'||c==']'||c==')')
         	 { 
         	 	if(!stack.isEmpty())
         	 	{
                    c1=stack.pop();
         	 	}
         	 	else
         	 	{
         	 		if(i==0)
         	 			{return false;
         	 				
         	 			}
         	 	}
                if((c1=='{'&&c!='}')||(c1=='['&&c!=']')||(c1=='('&&c!=')'))
                {
                     return false;
                     
                }
         	 }

       }

       
       if(stack.isEmpty())
       	   return true;
       	return false;

	}


public static void main( String [] args)
	{
		Scanner in = new Scanner(System.in);
		Stacks st  = new Stacks();
		//String s = in.next();
       System.out.println(st.isValidParenthesis(s));
	}


}


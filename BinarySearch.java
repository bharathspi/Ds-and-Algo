import java.util.*;
public class BinarySearch 
{
	public static int binarySearchAsc(int [] a,int x)
	{
		int l = 0;int r = a.length-1;
		while(l<=r)
		{
			int mid = (l+ (r-l)/2);
			if(a[mid]==x)
				 return mid;
		    else if(a[mid]>x)
		    	  r=mid-1;
		    else 
		    	 l = mid+1;

		}
		return r;
	}

	public static int binarySearchDec(int [] a,int x)
	{
		int l = 0;int r = a.length-1;
		while(l<=r)
		{
			int mid = (l+ (r-l)/2);
			if(a[mid]==x)
				 return mid;
		    else if(a[mid]>x)
		    	  l=mid+1;
		    else 
		    	 r= mid-1;

		}
		return r;
	}

	public static void main(String[] args) {
        
		int [] a = {7,6,6,6,4,4,4,3,3,2,2,1};
		System.out.println(a[binarySearchDec(a,5)]);
		System.out.println(a[binarySearchAsc(a,5)]);
	}


//Note : Some important observations
//1.If we apply binary search for Ascending ordered array the left will give the element that is just greater than the key and right will give the element less than that.
//2.In Descending ordered  array It's just reverse of that
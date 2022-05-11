//FOR THEORY REFER NOTES

import java.util.*;
public class Heap
{
  static int cnt = 0;
    static int left(int i)
    {
        return 2*i+1;
    }

    static int right(int i)
    {
        return 2*i +2;
    }

    static int parent(int i)
    {

        int k = (int)Math.ceil(i/2.0);
        return k-1;
    }

    private static Object resizeArray (Object oldArray, int newSize) {
            int oldSize = java.lang.reflect.Array.getLength(oldArray);
            Class elementType = oldArray.getClass().getComponentType();
            Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
            int preserveLength = Math.min(oldSize, newSize);
               if (preserveLength > 0)
                  System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
            return newArray;
      }

     public static int[] insert(int [] arr,int ele) //Time complexity -->O(logn)
     {
            
           arr = (int [])(resizeArray(arr,arr.length+1));
          arr[arr.length-1] = ele;
         int k = arr.length-1;
        while(true)
        {
            if(k<0 || parent(k)<0)
                break;
            if(arr[k]<arr[parent(k)])
                break;
            else 
            {
                int temp = arr[k];
                arr[k] = arr[parent(k)];
                arr[parent(k)] = temp;
                k=parent(k);
            }
        }
        
        return arr;

     }
//           In heaps you can only delete root element
     //Time complexity for deleting is O(logn)
   public static int [] delete(int [] arr)
   {
       int first= arr[0];
       arr[0] = arr[arr.length-1-cnt];
       int last = arr.length-1-cnt;
       int k =0;
      while(true)
      {
        // System.out.println(k);
          if(left(k)>last ||right(k)>last)
              break;
          
          else if(arr[k]<arr[left(k)]||arr[k]<arr[right(k)])
          {
              if(arr[left(k)]>arr[right(k)])
              {
                  int temp=arr[k];
                  arr[k]=arr[left(k)];
                  arr[left(k)] = temp;
                  k=left(k);
              }
              else
              {
                  int temp=arr[k];
                  arr[k]=arr[right(k)];
                  arr[right(k)] = temp;
                  k=right(k);
              }
          }
          else 
            break;
              
      }
       arr[arr.length-1-cnt] = first;
       cnt++;
       return arr;
       
   }

   public static int[] heapSort(int [] arr)
   {
    buidHeap(arr);
    int n  = arr.length-1;
    while(n-->0)
        delete(arr);
    return arr;
   }
 
 public static void buidHeap(int [] arr)
 {
    int k = (int)Math.floor(arr.length/2.0)-1;
    for(int i=k;i>=0;i--)
        heapify(arr,arr.length,i);
 }
  public static void heapify(int [] arr,int n,int index)
  {
     int largest = index;
     int left = 2*index+1;
     int right =2*index+2;
     if(left<n&&arr[left]>arr[largest])
        largest = left;
    if(right<n&&arr[right]>arr[largest])
        largest = right;
    if(largest!=index)
    {
        int temp = arr[largest];
        arr[largest] = arr[index];
        arr[index] = temp;

        heapify(arr,n,largest);
    }
  }
   public static void print(int [] arr)
   {
    for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
   }
    public static void main(String [] args)
    {
        int [] arr = {18,-6,4,45,0,34};
        heapSort(arr);
        print(arr);
     
    }
}
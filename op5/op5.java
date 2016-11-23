/**
 * @author: Panchami Rudrakshi				
 * Program description :
 * 1. howMany(int[] A, int X)- Given an array A of integers, and an integer X, find how many pairs of
                               elements of A sum to X
   2. exactlyOnce(T[] A)- Given an array A, return an array B that has those elements of A that
   						  occur exactly once, in the same order in which they appear in A
   3. longestStreak(int[] A)- Given an array A of integers, find the length of a longest streak of
                              consecutive integers that occur in A 						  
 */

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.List;
import java.util.*;
public class op5 {
	public static void main(String args[]){
		int [] howmany_arr = {3,3,4,5,3,5};
		int x=8;
		System.out.println("howmany:"+howMany(howmany_arr,x));
		int [] longstreak_arr = {1,7,9,4,1,7,4,8,7,1};
		System.out.println("longest streak :"+longestStreak(longstreak_arr));
		Integer [] exactonce_arr={6,3,4,5,3,5};
		System.out.println("exactly once:");
		System.out.println(exactlyOnce(exactonce_arr));
	}
	static int howMany(int[] arr,int x){
		TreeMap<Integer,Integer> tm1=new TreeMap<>();
		TreeMap<Integer,Integer> tm2=new TreeMap<>();
		//populating the tree map 1 with key being the array value and value being the number of times it occured 
		for(int i=0;i<arr.length;i++){
			if(tm1.containsKey(arr[i]))
				tm1.put(arr[i],tm1.get(arr[i])+1);
			else
				tm1.put(arr[i],1);
		}
		//populating tree map 2 with 'key' being the value in the array and 'value' being the additional number that must
		// be added to the 'key' to make it equal to given sum
		for(int i=0;i<arr.length;i++){
			if(tm2.containsKey(arr[i]))
				continue;
			else{
				//only considering those 'keys' that are lesser than (sum-key) 
				if(arr[i]<= (x-arr[i]))
				   tm2.put(arr[i],x-arr[i]);
			}
		}
		int a=0;
	
		for(int y:tm2.keySet()){
			// if the key and value is same , get the count by doing factorial of the number instead of multiplying 
			//the  same numbers
			if(y==tm2.get(y))
				a+=fact(tm1.get(y))/2;
			else{
				//for each key in tree map 2 get the corresponding values in tree map 1(if exists) and multiply them 
				if(tm1.containsKey(tm2.get(y)))
			       a+= tm1.get(y)*tm1.get(tm2.get(y));
			}
		}
			
		
		
		return a;
	}
	static int fact(int a){
		if(a==0)
			return 1;
		else
			return a*fact(a-1);
	}
	static int longestStreak(int [] arr) {
		TreeMap<Integer,Integer> tm1=new TreeMap<>();
		//populate the tree map with 'key' as the value found in the array and 'value' as the 
		// corresponding consecutive value of the 'key'.
		for(int i=0;i<arr.length;i++){
			tm1.put(arr[i], arr[i]+1);
			
		}
	    int len=tm1.size();
	    TreeSet<Integer> ts=new TreeSet<>();
	    int cnt=1;
	    Iterator<Integer> it=tm1.keySet().iterator();
	    for(int i=0;i<len;i++){
	    	//check if the tree map contains the corresponding consecutive value for every key
	    	// if yes, go on increasing count value
	    	// if no, add the count value to the set and initialise count to 0 again
	    	if(tm1.containsKey(tm1.get(it.next()))){
	    		cnt++;
	    		
	    	}
	    	else{
	    		ts.add(cnt);
	    		cnt=1;
	    		
	    	}
	    		
	    	
	    	
	    }
return ts.last();
	}
	public static <T extends Comparable<? super T>> List<T> exactlyOnce(T[] a) {
		TreeMap<T,Integer>arrMap=new TreeMap<>();	
		List<T> res=new ArrayList<>();
		int count=0;
		for(T x: a){
			if(!arrMap.containsKey(x)){
				arrMap.put(x, 1);
			}else{
			//Keeps track of the count of elements that occur more than once
				if(arrMap.get(x)==2)count++;
				arrMap.put(x,arrMap.get(x)+1);
			}
		}
//elements that occur exactly once will have 1 as their value	
		for(T l:a){
			if(arrMap.get(l)==1){
				res.add(l);				
			}
		}
		return res;
		
}
}

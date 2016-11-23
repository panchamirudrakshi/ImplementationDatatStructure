/**
 * @author: Panchami Rudrakshi 
 * Implementation of MergeSort
 * Date: 9/11/2016
 */
import java.util.Random;
import java.util.Comparator;
import java.util.PriorityQueue;
//import java.util.*;


  public class MergeSort<E extends Comparable<E>>{
	E[] a;
	 public MergeSort(E[] b){
		 a=b;		 
	 }
	 
  //Method to merge 
  public static<E extends Comparable<? super E>>void merge(E[] l,E[] r, E[] a){
			int nl=l.length;
		int nr=r.length;
		int i=0,j=0,k=0;
		while(i<nl && j<nr){
			if(l[i].compareTo(r[j])<0)a[k++]=l[i++];
			else a[k++]=r[j++];
		}
		//If the left array has elements
		while(i<nl){
			a[k++]=l[i++];
		}
		
		//If the right array has elements
		while(j<nr){
			a[k++]=r[j++];
		}
  } 
  
	
  // Method to split the array recursively
	public  void mrgSort(Comparable[] a){
		int n=a.length;
		Comparable[] left;
		Comparable[] right;
		
		if(n<2)return;		
		else{
			int mid=n/2;
			left=new Comparable[mid];
			right=new Comparable[n-mid];
			
			for(int i=0;i<mid;i++)left[i]=a[i];
			for(int i=mid;i<n;i++)right[i-mid]=a[i];
		}
		mrgSort(left);
		mrgSort(right);
		merge(left,right,a);
   }

	public static void main(String[] args) {
		
		Comparable[] intip=new Integer[1000006]; 
		int j=1000006;
		j--;
		for(;j>=0;j--){
			intip[j]=j;
		}
			
		Timer timer = new Timer();
		timer.start();
		MergeSort mint=new MergeSort(intip);
		mint.mrgSort(intip);
		timer.end();
				
		System.out.println("Time taken for merge sort");
		System.out.println(timer);
		
		Integer[] secip=new Integer[1000006];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Integer minimum=0, maximum=400;
		
		int k=1000006;
		k--;
		timer.start();
		for(;k>=0;k--){
			secip[k]=minimum + (int)(Math.random() * maximum);
			pq.offer(secip[k]);
		}
		
		timer.end();
		System.out.println();
		System.out.println("Time taken for sorting with priority queue");
		System.out.println(timer);
		
	}

}

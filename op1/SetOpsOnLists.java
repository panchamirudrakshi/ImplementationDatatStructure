/**
 * @author :Panchami Rudrakshi 
 * Set Operations : union, intersection, difference on Lists
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class SetOpsOnLists<T>{
	
	//Set Difference a-b Elements of a that are not in b
	public static<T extends Comparable<? super T>>
        void difference(List<T> a, List<T> b,List<T> c) {
		List<T> l1 = new ArrayList<T>(a);
	    List<T> l2 = new ArrayList<T>(b);
	    List<T> res = new ArrayList<T>(c);    
	    
	    Iterator<T> it1=l1.iterator();
	    Iterator<T> it2=l2.iterator();
	    
	    T x=it1.next();
    	T y=it2.next();
	    
	    while(it1.hasNext()){	    	
	    	
	    	//If the element of first list is smaller than the one in the second list then
	    	// add that element to the resultant list & move the first iterator
	    	if(x.compareTo(y)<0){				  
			  res.add(x);
			  if(it1.hasNext())x=(T)it1.next();
			}
	    	
	    	//If the first element is larger than the corresponding element in the second list then 
	    	//move both the iterators
	    	else if(x.compareTo(y)>0){				  
	    		if(it2.hasNext())y=(T)it2.next();
			}
	    	
	    	else{
	    		if(it1.hasNext()&&it2.hasNext()){
	    			x=it1.next();
	    			y=it2.next();
	    		}
	    	}	    		    	
	    	
	    }
	    
	    //Compare the last element of the first list with the remaining elements in the second list
	    while(x.compareTo(y)>0){
	    	y=(T)it2.next();
	    }
	    
	    if(x.compareTo(y)==0);
	    else res.add(x);
	    
	    
	    for(T v:res){	    	
	    	System.out.print(v+" ");
	    }
	    
	}
	
	//Union of list l1 and list l2
	public static<T extends Comparable<? super T>>void union(List<T> l1, List<T> l2,List<T> outList) {
	    List<T> x1 = new ArrayList<T>(l1);
	    List<T> x2 = new ArrayList<T>(l2);
	    List<T> res = new ArrayList<T>(outList);  
	    	        
	    Iterator<T> it1=x1.iterator();
	    Iterator<T> it2=x2.iterator();
	    
	    T h=it1.next();
    	T i=it2.next();
    	
	    while(it1.hasNext()&& it2.hasNext()){
	    	
			  if(h.compareTo(i)==0){
				  res.add(h);
				  if(it1.hasNext())h=it1.next();
				  if(it2.hasNext())i=it2.next();
			  }
			  else if(h.compareTo(i)>0){
				  res.add(i);
				  if(it2.hasNext())i=it2.next();
			  }
			  else{
				  res.add(h);
				  if(it1.hasNext()) h=it1.next();
			  }
	    }
	    
	    	    
	    //List 2 has more elements to be iterated
	       if(!it1.hasNext()){
			     if(h.compareTo(i)==0){
			    	 res.add(h);
			    	 while(it2.hasNext()){	    		 
			 	    	i=(T) it2.next();
			 	    	res.add(i);	    		   		
			 	     }	    	 
			     }			    
			     else if(h.compareTo(i)>0){
			    	 while(h.compareTo(i)>0&&it2.hasNext()){
			    		res.add(i);
			    		i=it2.next();
			    	 }
			    	 
			    	 res.add(h);
			    	 while(it2.hasNext()){	    		 
				 	    	i=it2.next();
				 	    	res.add(i);	    		   		
				 	 }
			     }			     
			     else{
			    	 res.add(h);
			    	 res.add(i);
			    	 while(it2.hasNext()){	    		 
			    		 i=it2.next();
			    		 res.add(i);		 	    		    		   		
				 	 }	    	 
			     }
	       }
	       
	     //List 1 has more elements to be iterated
	     //Compare the last element of list 2 with remaining elements of list1  
	       else if(!it2.hasNext()&&it1.hasNext()){
			     if(h.compareTo(i)==0){
			    	 res.add(h);
			    	 while(it1.hasNext()){	    		 
			 	    	h=it1.next();
			 	    	res.add(h);	    		   		
			 	     }	    	 
			     }			    
			     else if(i.compareTo(h)>0){
			    	 while(i.compareTo(h)>0&&it2.hasNext()){
			    		res.add(h);
			    		h=it1.next();
			    	 }
			    	 
			    	 res.add(i);
			    	 while(it1.hasNext()){	    		 
				 	    	h=it1.next();
				 	    	res.add(h);	    		   		
				 	 }
			     }			     
			     else{
			    	 res.add(h);
			    	 res.add(i);
			    	 while(it1.hasNext()){	    		 
			    		 h=it1.next();
			    		 res.add(h);		 	    		    		   		
				 	 }	    	 
			     }
			     
	       }
	       
	       //When both the iterators have reached the end of the list
	       //Compare the last elements of both the lists
	       //If they are equal add one of them, else add the smallest first and then the larger one
	       else if(!it1.hasNext()&&!it2.hasNext()){
	    	   if(h.compareTo(i)==0)res.add(h);
	    	   else if(h.compareTo(i)>0){
	    		   res.add(i);
	    		   res.add(h);
	    	   }
	    	   else{
	    		   res.add(h);
	    		   res.add(i);	    		   
	    	   }
	       }     
	   
	    Iterator it3=res.iterator();
	    while(it3.hasNext()){			  
		  System.out.print(it3.next()+" ");
	    }
	    
     }
	
	public static<T extends Comparable<? super T>>void intersect(List<T> l1, List<T> l2,List<T> outList) {
	    List<T> x1 = new ArrayList<T>(l1);
	    List<T> x2 = new ArrayList<T>(l2);
	    List<T> res = new ArrayList<T>(outList);   
	    
	    Iterator<T> it1=x1.iterator();
	    Iterator<T> it2=x2.iterator();
	    
	    T ele1=it1.next();
	    T ele2=it2.next();
	    
	    
	    while(it1.hasNext()&&it2.hasNext()){		    
			   
			  if(ele1.compareTo(ele2)<0){				 
				  ele1=it1.next();	  
			  }
			  
			  else if(ele1.compareTo(ele2)>0){
				  ele2=it2.next();				  
			  }
			  
			  else{
				  res.add(ele1);
				  ele1=it1.next();
				  ele2=it2.next();				  
			  }
		 }
	    
	    //If list2 reaches end before list1
	    while(it2.hasNext()&&(ele1.compareTo(ele2))!=0){	    	 
	    		 ele2=it2.next();	    	 
	    }
	    
	    //If list1 reaches end before list2
	    while(it1.hasNext()&&(ele1.compareTo(ele2))!=0){	    	 
   		 	ele1=it1.next();   	 
	    }
	    
	    if(ele1.compareTo(ele2)==0)res.add(ele1);    
	   	    
	    for(T l:res){			  
		  System.out.print(l+" ");
	    }
   }
	  
  public static void main(String[] args){
		  SetOpsOnLists s1=new SetOpsOnLists();	  
		 
		  List<Integer> m1=new ArrayList<>();
		  List<Integer> m2=new ArrayList<>();
		  List<Integer> resdiff=new ArrayList<>();
		  List<Integer> resintr=new ArrayList<>();
		  List<Integer> resuni=new ArrayList<>();
		  
		  m1.add(1);
		  m1.add(2);
		  m1.add(4);
		  m1.add(8);
		  m1.add(10);
		  m1.add(13);
		  
		  m2.add(13);
		  m2.add(15);	  
		  m2.add(18);
		  m2.add(19);		  	 
		  
		  
		 
		  System.out.println("Intersection of Lists");
		  s1.intersect(m2,m1,resintr);
		  System.out.println();
		  
		  System.out.println("Union of Lists");
		  s1.union(m1,m2,resuni);
		  System.out.println();
		  		  
		  System.out.println("List1-List2");
		  s1.difference(m1,m2,resdiff);
		  
		  
	  }

}

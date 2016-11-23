import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author : Panchami Rudrakshi
 */
public class FibonacciUsingExpontialLinearDAC {
	
	/**
	 * Fibonacci number using normal recursion approach
	 * @param n
	 * @return
	 */
	public BigInteger fibonacciExpontial(BigInteger n)
	{
		if(n.equals(new BigInteger("0")))
			return new BigInteger("0");                  // base case f(0) = 0 and f(1) = 1 
		if(n.equals(new BigInteger("1")))                // f(n) =  f(n-1) + f(n-2)
			return new BigInteger("1");
		
		return fibonacciExpontial(n.subtract(new BigInteger("1"))).add(fibonacciExpontial(n.subtract(new BigInteger("2"))));
	}
	
	/**
	 * Fibonacci using DP ( Memorization )
	 * @param n
	 * @param fib : DP array
	 * @return
	 */
	public int fiboncacciDAC(int n,int[] fib)
	{
		if(n==0)
		   return 0;
		if(n==1)
			return 1;
		if(fib[n]!=0)
			return fib[n];            // memorizing the values  
		fib[n]=fiboncacciDAC(n-1,fib)+fiboncacciDAC(n-2,fib);    // value is calculated again only if not present in cache
		return fib[n];
	}
	
	 /**
	 * Fibonacci using Divide and Conqure Approach
	 * @param n
	 * @return
	 */
	public BigInteger fibonacciDP(BigInteger n)
	{
		BigInteger[][] fib=new BigInteger[2][2];
		fib[0][0]=new BigInteger("1");
		fib[0][1]=new BigInteger("1");
		fib[1][0]=new BigInteger("1");
		fib[1][1]=new BigInteger("0");
		
		if(n.equals(new BigInteger("0")))
			return new BigInteger("0");
		
		power(fib,n.subtract(new BigInteger("1")));              // (fib)^(n-1) 
	    return fib[0][0];		                                 // (0,0) index of fib
	} 
	
	/**
	 * Procedure to calculate Matrix power n 
	 * @param fib
	 * @param n
	 */
	public void power(BigInteger[][] fib,BigInteger n)
	{
		if(n.equals(new BigInteger("0"))||n.equals(new BigInteger("1")))
		{
			return ;
		}
		
		BigInteger[][] temp=new BigInteger[2][2];
		temp[0][0]=new BigInteger("1");
		temp[0][1]=new BigInteger("1");
		temp[1][0]=new BigInteger("1");
		temp[1][1]=new BigInteger("0");
		
		power(fib,n.divide(new BigInteger("2")));                   // compute (2*2) matrix and use it recursively
		multiply(fib, fib);
		
		if(!(n.mod(new BigInteger("2")).equals(new BigInteger("0"))))
		{
			multiply(fib,temp);                                     // if odd have to multiply with one extra matrix
		}
			
		
		
	}
	
	/**
	 * Procedure to multiply 2*2 matrix
	 * @param fib
	 * @param fib1
	 */
	public void multiply(BigInteger[][] fib,BigInteger[][] fib1)
	{
	     BigInteger w = (fib[0][0].multiply(fib1[0][0])).add(fib[0][1].multiply(fib1[1][0]));
	     BigInteger x = (fib[0][0].multiply(fib1[0][1])).add(fib[0][1].multiply(fib1[1][1]));
	     BigInteger y = (fib[1][0].multiply(fib1[0][0])).add(fib[1][1].multiply(fib1[1][0]));
	     BigInteger z = (fib[1][0].multiply(fib1[0][1])).add(fib[1][1] .multiply(fib1[1][1]));
        
		fib[0][0]=w;                                 // simple 2*2 matrix calculations 
		fib[0][1]=x;
		fib[1][0]=y;
		fib[1][1]=z;

	}
	
	public static void main(String args[])
	{
		FibonacciUsingExpontialLinearDAC fib=new FibonacciUsingExpontialLinearDAC();
		int inputValue;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the valur for n: ");
		inputValue= s.nextInt();
			
		int n;
		
		System.out.println("Enter the option: ");
		System.out.println("1. Recursive program ");
		System.out.println("2. Dynamic program ");
		System.out.println("3. DAC algorithm ");
		n= s.nextInt();
		switch(n)
		{
		case 1: 
			
			long time1 = System.nanoTime();
			System.out.println("Fibonacci using O(2^n) "+ fib.fibonacciExpontial(new BigInteger(new Integer(inputValue).toString())));
			long time2 = System.nanoTime();
			System.out.println("Time(second) for Fibonacci using O(2^n) : " + (time2-time1)/Math.pow(10, 9));
			break;
		case 2:
			time1 = System.nanoTime();
			System.out.println("Fibonacci using O(n) "+ fib.fibonacciDP(new BigInteger(new Integer(inputValue).toString())));
			time2 = System.nanoTime();
			System.out.println("Time(second) for Fibonacci using O(n) : " + (time2-time1)/Math.pow(10, 9));
			break;
		case 3:
			time1 = System.nanoTime();
			System.out.println("Fibonacci using O(log n) "+fib.fiboncacciDAC(inputValue,new int[inputValue+1]));
			time2 = System.nanoTime();
			System.out.println("Time(second) for Fibonacci using O(logn) : " + (time2-time1)/Math.pow(10, 9));
			break;
		default:
			System.out.println("Invalid option");
		}

		
		
	}

}

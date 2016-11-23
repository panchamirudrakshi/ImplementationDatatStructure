import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author : Panchami Rudrakshi
 * Class to Generate random numbers. 
 */

public class OneMillionRandomNumberGenerator {
	
	/**
	 * @param args : String : File name to store random numbers. 
	 */
	public static void main(String args[])
	{
		File f;
		FileWriter in;
		PrintWriter pw;
		
		if(args.length>0)
	    f=new File(args[0]); //file name provided in console 
		else
		f=new File("inputFile.txt"); // use own file name 
		
		try{
			in=new FileWriter(f);
			pw=new PrintWriter(in);
			int n;
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the power:");
			n= s.nextInt();
			for(int i=0;i<Math.pow(2, n);i++)
			{
				in.write((new Double(Math.random())).toString()); // get an random double and store in file as string. 
				in.write("\t");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

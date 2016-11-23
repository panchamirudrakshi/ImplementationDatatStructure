import java.util.TreeMap;
/** 
 * Tree Map class to compare performance of Skip lists and tree maps
 * @author : Panchami Rudrakshi 
 */
public class TreeMapComparison {
		
		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
		/** 
		 * method to insert values into tree map
		 * @param size
		 */
		public void insert(int size) {
			for (int i = 1; i < size; i++) {
				tmap.put(i,i);
			}
		}
		/** 
		 * method to delete a value from the tree map
		 */
		public void delete(int num) {
			for (int i = 10; i < num; i++) {
				tmap.remove(i);
			}
		}
		
		/** 
		 * method to check if a value is present in the treemap
		 */
		public int contains(int value)
		{
			for(int i=1;i< tmap.size();i++){
				if(tmap.containsValue(value))
					return value;				
			}
			return 0;
		}
		public static void main(String[] args) {
			int size = 1000000; 
			int number = 100;
			int value = 10;
			TreeMapComparison obj = new TreeMapComparison();
			Timer timer = new Timer();
			Timer timer1 = new Timer();
			Timer timer2 = new Timer();
			
			timer.start();	
			obj.insert(size);
			timer.end();
			System.out.println(timer); 
			
			timer1.start();
			obj.delete(number);
			timer1.end();
			System.out.println(timer1); 
			
			timer2.start();
			int x = obj.contains(5);
			timer2.end();
			System.out.println(timer2); 

		}

	
}

package cop2805;

public class AdvancedJavaHomework3 {
	
	public static void main(String[] args) {
		String[] colors = {"Red","Green","Blue"};
		Integer[] numbers = {1, 2, 3};
		Double[] circleRadius = {3.0, 5.9, 2.9};
		
		//outputs the max value of each array using the function call
		System.out.println("Colors: " + max(colors));
		System.out.println("Numbers: " + max(numbers));
		System.out.println("Circle Radius: " + max(circleRadius));
	}
	
	 public static <E extends Comparable<E>> E max (E [] list) {
		 E maxElement = list[0]; //assigns the first array index to an E variable type
		 
		//Loop that checks each index in the array and keeps the highest valued index
		 for(int i = 0; i < list.length; i++)
		 {
			 if (list[i].compareTo(maxElement) > 0) 
			 {
				 maxElement = list[i];
			 }
		 }
		 
		 return maxElement; //returns highest value
	 }
}

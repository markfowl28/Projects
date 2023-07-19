package cop2805;
import java.util.*;

public class AdvancedJavaHomework2 {

	public static void main(String[] args) {
		ArrayList<Character> list1 = new ArrayList<Character>();
		ArrayList<Character> list2 = new ArrayList<Character>();
		
		//add characters to first array list
		list1.add('M');
		list1.add('P');
		list1.add('F');
		
		//initial list
		System.out.println("Initial List:");
		Output(list1);
		
		//reverse first array list
		Collections.sort(list1, Collections.reverseOrder());
		System.out.println("Reverse List:");
		Output(list1);
		
		//copy reverse list into new list
		Collections.copy(list1, list2);
		System.out.println("Copied List:");
		Output(list1);
		
		//fill initial list with the letter R
		Collections.fill(list1, 'R');
		System.out.println("R Filled List:");
		Output(list1);
		
	}
	
	public static void Output(List<Character> list) {
		
		//For each loop to output list
		for(Object obj : list) {
			System.out.print(obj);
			System.out.print(" ");
		}
		System.out.println();
	}
}

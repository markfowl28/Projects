package cop2805;

public class ThreadsProblem extends Thread{
	static public int n = 40;
	
	static class RecursionThread extends Thread{
		public void run() {
			int answer;
			
			long initialTime = System.currentTimeMillis(); 
			answer = RecursionSolution(n); 
			long finishTime = System.currentTimeMillis();
			
			System.out.println("Recursion Thread found the answer: " + answer + " in " + (finishTime - initialTime) + "ms");
		}
	}
	
	static class DynamicThread extends Thread {
		public void run() {
			int answer;
			
			long initialTime = System.currentTimeMillis();
			answer = DynamicSolution(n);
			long finishTime = System.currentTimeMillis(); 
			
			System.out.println("Dyanmic Thread found the answer: " + answer + " in " + (finishTime - initialTime) + "ms");
		}
	}
	
	public static int RecursionSolution(int n) {
		int solution;
		
		if(n == 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		solution = RecursionSolution(n-1) + RecursionSolution(n-2);
		
		return solution;
	}
	
	public static int DynamicSolution(int n) {
		int v1 = 0, v2 = 1, v3 = 0;
		
		for(int i = 2; i <= n; i++) {
			v3 = v1 + v2;
			v1 = v2;
			v2 = v3;
		}
		
		return v3;
	}
	
	public static void main(String[] args) {
		RecursionThread recursion = new RecursionThread();
		DynamicThread dynamic = new DynamicThread();
		
		recursion.start();
		dynamic.start();
	}
}

public class MathDemo {

	public static void main(String[] args) {
		mathDemo();
	}

	private static void mathDemo() {
		// Lottery Game [1, 100]

		// Math.random() return double between [0, 1)
		double random = Math.random() * 100;
		int winner = (int) random + 1;

		System.out.println(winner);

		// Round ~ rounding floating point to the nearest integer
		
		long x = Math.round(24.54);
		System.out.println(x);
		
		
		// ceil ~ round up
		
		double ceil = Math.ceil(224.5);
		
		
		// floor ~ round down
		double floor = Math.floor(224.5);
		
		// max ~ maximum of 2 double or integers
		double max = Math.max(224.21, 323.12);
		
		// abs ~ remove sign
		double abs = Math.abs(+214.12);
		
		
		// pow ~ (integer or double) power of n
		double pow = Math.pow(2, 2);
		
		// sqrt ~ square root
		// NaN ~ when floating point result in undefined value
		double nan = 0.0/0.0;
		double sqrt = Math.sqrt(-pow);
		
		// Log 
		double id = Math.log(100/8);

		System.out.println(id);
	}

}

public class Test2 {
	public static void main(String[] args) {

		int a = Integer.valueOf(args[0]);
		System.out.println(a);
		System.out.println(add());
		System.out.println(greet());
	}

	public static String greet() {

		return "He3 World!";


	}

	public static int add() {
		int a = 5;
		int b = 10;
		return a + b;

	}
}

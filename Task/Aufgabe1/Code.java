
public class Code {
	public static void main(String[] args) {

		int a = Integer.valueOf(args[0]);
		System.out.println(a);
		System.out.println(add());
		System.out.println(greet());
	}

	public static String greet() {
<<<<<<< HEAD
		return "Hel World!";
=======
		return "He3 World!";
>>>>>>> branch 'master' of https://github.com/ProPra16/programmierpraktikum-abschlussprojekt-pwnyhof.git
	}

	public static int add() {
		int a = 5;
		int b = 10;
		return a + b;
	}
}

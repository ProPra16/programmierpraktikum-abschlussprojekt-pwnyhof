
public class Code{
	public static void main(String[] args){

	int a = Integer.valueOf(args[0]);
	int b = Integer.valueOf(args[1]);

	String s = String.valueOf(args[2]);

	System.out.println(s);
	System.out.println(a * b);
	System.out.println(add());

}

public static String greet()
{
		return "Hello World!";
}
public static int add()
{
	int a = 5;
	int b = 10;
	return a + b;
}
}


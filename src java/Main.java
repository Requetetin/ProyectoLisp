import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Print spl = new Print();

		System.out.print("user> ");
		String input = scan.nextLine();
		
		//Se revisa que no sea un ingreso vacío
		while(input.equals("")){
			System.out.print("\nuser> ");
			input = scan.nextLine();
		}
		
		System.out.print(spl.values(input));

	}
}
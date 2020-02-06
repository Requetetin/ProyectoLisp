import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Split spl = new Split();

		System.out.print("user> ");
		String input = scan.nextLine();
		while(!input.equals("")){
			System.out.println(input);
			System.out.print("\nuser> ");
			input = scan.nextLine();
			if(!input.equals("")){
				spl.values(input);
			}

		}
	}
}
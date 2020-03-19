import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		InterpreteLisp interprete = new InterpreteLisp();

		while(true){
			System.out.print("user> ");
			String input = scan.nextLine();
			System.out.println(interprete.buscarFuncionLisp(input)); //Dependiendo del metodo encontrado 
		}

		
		
	}
}
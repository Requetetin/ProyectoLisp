import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		InterpreteLisp interprete = new InterpreteLisp();

		System.out.print("user> ");
		String input = scan.nextLine();
		
		//Se revisa que no sea un ingreso vacío
		//PROGRA DE MARTIN QUE NO ENTENDI
		/*
		while(!input.equals("")){
			System.out.println(input);
			System.out.print("\nuser> ");
			input = scan.nextLine();
			if(!input.equals("")){
				spl.values(input);
			}

		}
		*/

		System.out.println(interprete.buscarFuncionLisp(input)); //Dependiendo del metodo encontrado 
		
		//System.out.print(spl.values(input));

	}
}
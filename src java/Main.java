import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		InterpreteLisp interprete = new InterpreteLisp();
		
		while(true){
			String text = "";
			System.out.print("user> ");

			while(scan.hasNextLine()){
				String input = scan.nextLine();
				if(input == null || input.isEmpty()){ //if the line is empty
					break;  //exit the loop
    			}
    			text += input;
			}

			System.out.println(interprete.buscarFuncionLisp(text)); //Dependiendo del metodo encontrado 
		}
	}
}
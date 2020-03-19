import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		InterpreteLisp interprete = new InterpreteLisp();
		Boolean seguir = true;
		
		while(seguir){
			String text = "";
			System.out.print("user> ");

			while(scan.hasNextLine()){
				String input = scan.nextLine();
				if(input == null || input.isEmpty()){
					break; 
    			}
    			text += " " + input;
			}

			if (text.equals("")) {
				seguir = false;
			} else {
				System.out.println(interprete.buscarFuncionLisp(text)); //Dependiendo del metodo encontrado 
			}
			
		}
	}
}
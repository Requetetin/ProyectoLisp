import java.util.*;

public class Leer{
	private String comment;
	private String actualprint = "";
	

	public String values(String input){			
		actualprint = actualprint.replace("(", ""); //Se remueven parentesis
		
		//Se quitan los comentarios
		for(int i=actualprint.indexOf(")"); i < input.length(); i++){
			String possible_comment = actualprint.substring(actualprint.indexOf(")") + 1); //Se obtiene el posible comentario

			if (possible_comment.contains(";")) {
				comment = actualprint.substring(actualprint.indexOf(";")); //Se obtiene el comentario
				actualprint = actualprint.replace(comment, ""); //Se remueve el comentario del string
				break;
			}
		}

		actualprint = actualprint.replace(")", ""); //Se remueve el de cierre
		//Retorna lo que haya ingresado
		return actualprint+"\n"+actualprint;	
	}

	//Se busca el metodo de imprimir
	public boolean methodPrintFound(String input){
		boolean methodisfound = false;
		
		if (input.contains("write-line")) {
			actualprint = input.replace("write-line", "");
			methodisfound = true;
		} else if (input.contains("write")) {
			actualprint = input.replace("write", "");
			methodisfound = true;
		} else if (input.contains("print")) {
			actualprint = input.replace("print", "");
			methodisfound = true;			
		} else if (input.contains("\"")) {
			methodisfound = true;
		} else {
			methodisfound = false;
		}

		return methodisfound;
	}


}
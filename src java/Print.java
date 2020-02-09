import java.util.*;

public class Print{
	private ArrayList<String> values = new ArrayList<String>();
	private String comment;
	private String actualprint = "";
	private String actualInput;
	

	public String values(String input){
		actualInput = input; //Se asigna el valor para revisar si contiene la función

		if (methodFound()) { //Si ingresa metodo para mostrar en pantalla
			String[] split_text = actualInput.split(""); //Se convierte a vector
			//Se quitan los paréntesis
			for(int i=0; i < split_text.length; i++){
				if (split_text[i].equals("(")) {
					//Se ignora
				} else if (split_text[i].equals(")")) { //Se revisa si hay comentario
					for (int j=i; j<split_text.length; j++) { //El contador inicia luego del paréntesis
						if (split_text[j].equals(";")){
							comment = actualInput.substring(actualInput.indexOf(";") + 1);
							break;
						}
					}						
				} else {
					if (comment == null) {
						values.add(split_text[i]);
					}		
				}
			}
			//Se regresa el array a string
			for (String i : values ) {
				actualprint += i;
			}		
		} else {
			actualprint = "** -EVAL: La funcion no esta definida";
		}
		
		//Retorna lo que haya ingresado
		return actualprint+"\n"+actualprint;	
	}

	//Se busca el metodo de imprimir
	private boolean methodFound(){
		boolean methodisfound = false;
		
		if (actualInput.contains("write-line")) {
			actualInput = actualInput.replaceAll("(?i) write-line", ""); //Se quita de lo ingresado
			methodisfound = true;
		} else if (actualInput.contains("write")) {
			actualInput = actualInput.replaceAll("(?i) write", ""); //Se quita de lo ingresado
			methodisfound = true;
		} else if (actualInput.contains("print")) {
			actualInput = actualInput.replaceAll("(?i) print", ""); //Se quita de lo ingresado
			methodisfound = true;			
		} else if (actualInput.contains("\"")) {
			methodisfound = true;
		} 
		else {
			methodisfound = false;
		}
		return methodisfound;
	}
}
import java.util.*;
public class InterpreteLisp{
	ArrayList<String> listado = new ArrayList<String>();
	boolean methodPrintIsFound = false;

	Print print = new Print();

	//Se convierte el input a arraylist
	public void convertirArray(String input){
		ArrayList<String> invertido = new ArrayList<String>(); //Arraylist temporal de invertidos


		String[] split_text = input.split(" "); //Se convierte a vector por letra
		
		for (int i=0; i<split_text.length; i++) {
			invertido.add(split_text[i]); //Se crea un array con todas las letras
		}
		
		Collections.reverse(invertido); //Se invierte el orden

		for (int j=0; j< invertido.size(); j++) {

			ArrayList<String> temporal = new ArrayList<String>(); //Se genera un nuevo arraylist


			if (invertido.get(j).equals("(")) { //Se busca el abierto
				for (int k=j; k>0; k--) {  //Se busca el de cerrar apartir de la posicion del abierto
					if (invertido.get(k).equals(")")){ //Se busca el de cerrar
						for (int l=j; (l+1)!=k; l--) { //Se comienza en la posicion del ( y se realiza el loop hasta llegar al )
							temporal.add(invertido.get(l)); //Se agregan las letras dentro de los parentesis
							invertido.remove(l); //Se quita la operacion encontrada
						}

						j = 0; //Se regresa j a cero para reiniciar el ciclo
						agregar(temporal);
						break;

					}

				}
			}
		
		}

		Collections.reverse(invertido); //Se revierte el orden
		agregar(invertido); //Se agrega lo ultimo dejado en invertidos
	}
	//Método para agregar la funcion encontrada al listado
	private void agregar(ArrayList<String> temporal){
		StringBuilder  s=new StringBuilder();
		boolean first = true;

		if (temporal.size()>0) {

			//Se regresa el array a string
			String complete_word = "";
			for (String i : temporal) {
				if (first) {
					s.append(i); //No agrega espacio a la primera letra
					first = false;
				} else {
					s.append(" " + i); //Agrega esoacios entre las palabras
				}
			}
			complete_word = s.toString(); //Se convierte el builder a String
			listado.add(complete_word); //Se agrega la primer operacion al listado					
		}
	}
	//Metodo para obtener el listado
	public ArrayList<String> getListado(){
		return this.listado;
	}
	//Metodo para realizar la funcion encontrada
	public String buscarFuncionLisp(String input){
		convertirArray(input); //Se genera el array para los metodos que lo necesiten

		if(print.methodPrintFound(input)){ //Print recibe el input inicial
			return print.values(input);  
		}

		return "Metodo no encontrado";
	}
	
}
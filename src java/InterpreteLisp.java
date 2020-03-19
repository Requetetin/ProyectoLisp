/**
* @author Andrea Amaya 19357
* @author Martin Amado 19020
* @author Brandon Hernández 19376
*
*
* Se encarga de separar lo ingresado en un arraylist de arraylist
* Se encarga de llevar a cabo las funciones necesarias dentro del input
*/
import java.util.*;
public class InterpreteLisp{
	ArrayList<String> listado = new ArrayList<String>();
	ArrayList<String> vocLisp = new ArrayList<String>();
	ArrayList<ArrayList<String>> ingresoLisp = new ArrayList<ArrayList<String>>();
	boolean methodPrintIsFound = false;

	Leer print = new Leer();
	Predicados predicados = new Predicados();
	Definir definir = new Definir();
	Calcular calcular = new Calcular();


	/**
	Pre: Ingresan codigo en forma lisp
	@param input 		String ingresado por el usuario
	Post: Se convierte el input a arraylist
	*/
	private void convertirArray(String input){
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

	/**
	@param temporal 	Se recibe el arraylist temporal
	Post: Se agrega lo mas significativo al arraylist listado
	*/
	private void agregar(ArrayList<String> temporal){
		listado = new ArrayList<String>();
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

	/**
	Post: Se crea un arraylist de arraylist con todo lo ingresado
	*/
	private void convertirArrayArray(){
		ingresoLisp = new ArrayList<ArrayList<String>>();
		for (int i=0; i<listado.size(); i++) {
			ArrayList<String> listado2 = new ArrayList<String>();

			String[] split_text = listado.get(i).split(" "); //Se convierte a vector por espacio

			for (int j=0; j<split_text.length; j++) {
				if (!split_text[j].equals("")) {
					listado2.add(split_text[j]);	
				}
				
			}

			ingresoLisp.add(listado2);
		}
	}

	/**
	Post:
	*/
	private void generarVoc(){
		vocLisp.add("atom");
		vocLisp.add("list");
		vocLisp.add("equals");
		vocLisp.add("cond");
		vocLisp.add("defun");
		vocLisp.add("+");
		vocLisp.add("-");
		vocLisp.add("/");
		vocLisp.add("*");
	}
	/**
	Pre: Hay algo ingresado por el usuario
	@return la funcion realizada por el usuario
	*/
	public ArrayList<String> buscarFuncionLisp(String input){
		ArrayList<String> mostrar = new ArrayList();
		convertirArray(input); //Se genera el array para los metodos que lo necesiten
		convertirArrayArray(); //Se genera el arraylist de arraylist
		generarVoc(); //Se genera el vocabulario lisp

		if(print.methodPrintFound(input)){ //Print recibe el input inicial
			mostrar.add(print.values(input));  
		} else {
			System.out.println(ingresoLisp);
			for (int i=0; i<ingresoLisp.size(); i++) {
				for (int j=0; j<vocLisp.size(); j++) {
					if (ingresoLisp.get(i).contains(vocLisp.get(j))) {
						switch(j){
							case 0: //Atom
								mostrar.add(predicados.funAtom(ingresoLisp));
								break;
							case 1: //List
								//mostrar.add(predicados.funList(ingresoLisp));
								mostrar.add("Hay que ver que hacer con este");
								break;
							case 2: //Equals
								mostrar.add(predicados.funEquals(ingresoLisp));
								break;
							case 3: //Cond
								mostrar.add(predicados.funCond(ingresoLisp));
								break;
							case 4: //Defun
								try{
									mostrar.add(definir.setFuncion(ingresoLisp)); //Se revisa que no exista la llave, sino se genera la funcion sin error
								} catch (Exception e) {
									mostrar.add("Hay que ver que hacer con este");
									//mostrar.add(definir.runFuncion(ingresoLisp)); //Se corre la funcion o se muestra error
								}
								break;
							case 5: //Sumar
								mostrar.add(calcular.operar(ingresoLisp));
								break;
							case 6: //Restar
								mostrar.add(calcular.operar(ingresoLisp));
								break;
							case 7: //Dividir
								mostrar.add(calcular.operar(ingresoLisp));
								break;
							case 8: //Multiplicar
								mostrar.add(calcular.operar(ingresoLisp));
								break;
							default:
								break;
						}
					}		
				}
				ingresoLisp.remove(i);
			}
		}
		if (mostrar.size() == 0) {
			mostrar.add("Metodo no encontrado");
		}

		return mostrar;
	}
	
}
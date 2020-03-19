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
	static ArrayList<ArrayList<String>> ingresoLisp = new ArrayList<ArrayList<String>>();
	boolean methodPrintIsFound = false;
	static int actual = 0;

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
		input = input.toLowerCase();

		actual = 0;
		ingresoLisp = new ArrayList<ArrayList<String>>();
		ArrayList<String> invertido = new ArrayList<String>(); //Arraylist temporal de invertidos

		String[] split_text = input.split(" "); //Se convierte a vector por espacio
		input = addSpace(split_text);
		split_text = input.split(" "); //Se convierte a vector por espacio



		
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
		StringBuilder  s=new StringBuilder();
		listado = new ArrayList<String>();
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
			String[] complete = complete_word.split(" ");

			for (int i = 0; i<complete.length; i++) {
				listado.add(complete[i]); //Se agrega la primer operacion al listado					
			}


			ingresoLisp.add(actual, listado);
			actual++;
			
		}
	}
	/*
	/**
	Post:
	*/
	private String addSpace(String[] input){
		String temporal = "";
		for (int i=0; i<input.length; i++) {
			String str = input[i];
			if (str.contains("(") && str.contains(")")) {
				temporal += str;
			} else if (!str.contains("(") && !str.contains(")")) {
				temporal += " " + str;
				System.out.println(temporal);
			} else if (str.contains("(") && !str.contains(")")) {
				str = str.replace("("," ");
				str = " (" + str;
				temporal += str;
			} else if (str.contains(")") && !str.contains("(")) {
				int temp = str.indexOf(")");
				temporal += " " +str.substring(0, temp);
				temporal += " ) " +str.substring(temp + 1);
			} 
		}

		temporal = temporal.replaceAll("( )+", " ");
		System.out.println(temporal);
		return temporal;
	}

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
		ArrayList<ArrayList<String>> mostrar2 = new ArrayList();
		
		convertirArray(input); //Se genera el array para los metodos que lo necesiten
		generarVoc(); //Se genera el vocabulario lisp

		System.out.println(ingresoLisp);

		if(print.methodPrintFound(input)){ //Print recibe el input inicial
			mostrar.add(print.values(input));  
		} else {
			for (int i=0; i<ingresoLisp.size(); i++) {
				for (int j=0; j<vocLisp.size(); j++) {
					if (ingresoLisp.get(i).contains(vocLisp.get(j))) {
						switch(j){
							case 0: //Atom
								mostrar.add(predicados.funAtom(ingresoLisp));
								break;
							case 1: //List
								//mostrar.add(predicados.funList(ingresoLisp));
								break;
							case 2: //Equals
								mostrar.add(predicados.funEquals(ingresoLisp));
								break;
							case 3: //Cond
								try{
									mostrar.add(predicados.funCond(ingresoLisp));
								} catch (Exception e) {
									mostrar.add("Debes de ingresar 3 condiciones");
									//mostrar.add(definir.runFuncion(ingresoLisp)); //Se corre la funcion o se muestra error
								}
								break;
							case 4: //Defun
								try{
									mostrar.add(definir.setFuncion(ingresoLisp)); //Se revisa que no exista la llave, sino se genera la funcion sin error
								} catch (Exception e) {
									mostrar.add(definir.runFuncion(ingresoLisp)); //Se corre la funcion o se muestra error
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
					break;
					}	
				}
				break;
			}
		}
		if (mostrar.size() == 0) {
			mostrar.add("Metodo no encontrado");
		} 
		return mostrar;
	}
	
}
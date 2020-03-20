import java.util.*;
/**
* @author Andrea Amaya 19357
* @author Martin Amado 19020
* @author Brandon Hernández 19376
*
*
* Administrador de las funciones que se crean durante la ejecucion del 
* programa
*/
public class Definir{

	// Se guardaran aquí las funciones y las variables
	private Map<String, ArrayList<ArrayList<String>>> functions = new HashMap<>();
	private Map<String, ArrayList<String>> variables = new HashMap<>();
	private Calcular calc = new Calcular();
	private Predicados predicate = new Predicados();

	/**
	 * Se encarga de correr una función o indicar que no se encuentra
	 * @pos se ejecuta una función o se manda un error
	 * @param funtion es el nombre de la función que quiere ser utilizada
	 * @return el resultado obtenido luego de realizar la función
	 */
	public String runFuncion(ArrayList<ArrayList<String>> function){
		// Espacios en donde se guardaran las funciones y las variables
		ArrayList<ArrayList<String>> funtionality = new ArrayList<>();
		ArrayList<String> variables = new ArrayList<>();
		ArrayList<String> replaceVariables = new ArrayList<>();
		Boolean flag = false; // Verifica si hay un cond()
		String resultado = "HOLA BB <3 :3";

		String functionName = function.get(0).get(1).toUpperCase(); // Nombre en mayusculas de la funcion
		function.get(0).remove(1);
		function.get(0).remove("(");
		function.get(0).remove(" )");

		if(functions.containsKey(functionName)){

			// Consiguiendo los elementos necesarios para poder realizar la funcion
			funtionality = functions.get(functionName);
			variables = this.variables.get(functionName);

			// Consiguiendo las variables del arraylist de arraylist
			for(int i = 0; i < function.get(0).size(); i++){
				replaceVariables.add(function.get(0).get(i).replace(" ", ""));
			}

			// Verificando que tenga la misma longitud de parametros que variables en la funcion
			if(replaceVariables.size() == variables.size()){
				
				// Cambiando todas las variables por números mandados por el usuario
				for(int i = 0; i < funtionality.size(); i++){ // Recorriendo el arraylist
					for(int j = 0; j < funtionality.get(i).size(); j++){ // Recorriendo el arraylist que esta adentro de otra

						for(int k = 0; k < replaceVariables.size(); k++){ // Trata de remplazar si es una variable
							funtionality.get(i).get(j).replace(variables.get(k), replaceVariables.get(k));

							if(funtionality.get(i).get(j).equalsIgnoreCase(" cond")){ // Verificando si tiene un cond
								flag = true;
							}

						}

					}
				}


				// Empieza la ejecución del programa WUUUUU ESO PERROS 
				






				return resultado;
			}else{ // Cuando ! [x,y].size() == [3, 3, 8].size() 
				return "*** - EVAL/APPLAY: se han entregado demasiados argumentos a " + functionName;

			}
			
		}else{

			return "*** - EVAL: la funcion " + functionName + " no esta definida";
		}

	}

	/**
	* Se encarga de agregar una nueva funcin al mapa
	* @pre hay una n cantidad de funciones y variables
	* @pos hay una cantidad (n + 1) de funciones y variables
	* @param nuevaFuncion contiene la funcioin que desea ser agregada
	*/
	public String setFuncion(ArrayList<ArrayList<String>> nuevaFuncion){
		ArrayList<String> variablesF = new ArrayList<>();
		ArrayList<ArrayList<String>> funtion = new ArrayList<>();
		String funtionName;

		// Consiguiendo el nombre y las funciones
		variablesF = setNombreFuncion(nuevaFuncion.get(nuevaFuncion.size() - 1));
		funtionName = variablesF.get(0);
		
		// Eliminando el nombre y cambiandolo a mayuscular
		variablesF.remove(0);
		funtionName = funtionName.toUpperCase();

		funtion = setFuncionalidadFuncion(nuevaFuncion); // Consiguiendo el funcionamiento de la función

		// Agregando las funciones 
		this.functions.put(funtionName, funtion);
		this.variables.put(funtionName, variablesF);


		/**
		Borrar despues
		*/
		System.out.println("\nInfo Metodo:");
		System.out.println(funtionName);
		System.out.println(this.functions.get(funtionName));
		System.out.println(this.variables.get(funtionName));
		return funtionName;
	}

	/**
	 * Se encarga de encontrar el nombre de la función y devolverlo para su uso
	 * @pre el nombre de la función esta mesclado con otros datos
	 * @pos el nombre y las variables estan separados
	 * @param nombre contiene el nombre de la función y las variables que necesitas ser agregadas
	 * @return el nombre de la funcion y todas las variables
	 * *Utilizado en setFuncion
	 */
	private ArrayList<String> setNombreFuncion(ArrayList<String> nombre) {
		ArrayList<String> temporal = new ArrayList<String>();
		Integer index = 0;
		String nombreAux = "", nombreAux2 = "";
		String[] aux = new String[2];
		Boolean flag = false;

		// Encontrando el nombre con base al defun
		for(int i = 0; i < nombre.size(); i++){
			nombreAux = nombre.get(i).replace(" ", "");
			if(nombreAux.equalsIgnoreCase("defun")){
				index = i;
			}
		}

		// Asignandole el nombre
		String nombreS = nombre.get(index + 1);
		// Separando los elementos
		nombreAux = "";
		for(int i = 0; i < nombreS.length(); i++){
			if((nombreS.charAt(i) == '(')){
				flag = true;
			}else if((nombreS.charAt(i) == ')')){
				break;
			}else if(flag){
				nombreAux += Character.toString(nombreS.charAt(i));
			}else{
				nombreAux2 += Character.toString(nombreS.charAt(i));
			}

		}		

		// Agregando a las listas
		aux[0] = nombreAux2;
		aux[1] = nombreAux.replace(" ","");

		// Agregando el nombre
		temporal.add(aux[0]);

		// Separando todas las variables
		aux = aux[1].split(",");

		// Agregando todas las variables
		for(int i = 0; i < aux.length; i++){
			temporal.add(aux[i]);
		}

		return temporal;
	}

	/**
	 * Guarda la función de tal manera que pueda ser ejecutada más adelante
	 * @pre se cuenta con una la función sin funcionamiento
	 * @pos se cuenta con la función lista para su lectura
	 * @param función que se quiere agregar
	 * @return un string con la función lista para ser leida
	 * *Utilizado en setFuncion
	 */
	private ArrayList<ArrayList<String>> setFuncionalidadFuncion(ArrayList<ArrayList<String>> funtionality){
		ArrayList<ArrayList<String>> temp = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<>();

		// Agregando a una arraylist 
		for(int i = 0; i < funtionality.size() - 1; i++){
			for(int j = 1; j < funtionality.get(i).size() - 1; j++){
				// Agregando la funcionalidad sin parentesis
				aux.add(funtionality.get(i).get(j));
			}

			temp.add(aux);
		}

		// Quitando hasta que solo quede un funcionamiento 
		while(temp.size() != 1){
			temp.remove(0);
		}
		
		return temp;
	}

}
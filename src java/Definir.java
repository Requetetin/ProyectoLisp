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
	private Map<String, ArrayList<String>> functions = new HashMap<>();
	private Map<String, ArrayList<String>> variables = new HashMap<>();
	private Map<String, ArrayList<ArrayList<String>>> oldFunction = new HashMap<>();
	private ArrayDeque<String> container = new ArrayDeque<>();
	private ArrayList<ArrayList<String>> nuevaFuncion = new  ArrayList<ArrayList<String>>();
	
	/**
	 * Se encarga de correr una función o indicar que no se encuentra
	 * @pos se ejecuta una función o se manda un error
	 * @param funtion es el nombre de la función que quiere ser utilizada
	 * @return el resultado obtenido luego de realizar la función
	 */
	public String runFuncion(ArrayList<ArrayList<String>> function){
		// Espacios en donde se guardaran las funciones y las variables
		Calcular calc = new Calcular();
		ArrayList<String> funtionality = new ArrayList<>();
		ArrayList<String> variablesM = new ArrayList<>(); // Las que se agarran del mapa
		ArrayList<String> replaceVariables = new ArrayList<>(); // Las que manda el usuario

		// Para realizar las operaciones matematicas
		ArrayList<String> operadoresAritmeticos = new ArrayList<>();

		// Banderas
		Boolean logic = false, aritmetico = false, recursive = false; // Verifica si hay un cond()
		String resultado = "HOLA BB <3 :3";

		// Agregando los operadores matematicos
		operadoresAritmeticos.add("+");
		operadoresAritmeticos.add("-");
		operadoresAritmeticos.add("*");
		operadoresAritmeticos.add("/");
		//-------------------------------------	

		//---------------------------------------------------------
		String functionName = function.get(0).get(1).toUpperCase(); // Nombre en mayusculas de la funcion
		function.get(0).remove(1);
		function.get(0).remove("(");
		function.get(0).remove(function.size());
		//---------------------------------------------------------

		// Consiguiendo los elementos necesarios para poder realizar la funcion
		for(int i = 0; i < functions.get(functionName).size(); i++){
			funtionality.add(functions.get(functionName).get(i)); // Copiando lo que hay en el mapa
		}
		variablesM = variables.get(functionName);

		// Consiguiendo las variables del arraylist de arraylist
		for(int i = 0; i < function.get(0).size(); i++){
			replaceVariables.add(function.get(0).get(i).replace(" ", ""));
		}

		// Verificando que tenga la misma longitud de parametros que variables en la funcion
		if(replaceVariables.size() == variablesM.size()){
			
			// Cambiando todas las variables por números mandados por el usuario
			for(int i = 0; i < funtionality.size(); i++){ // Recorriendo el arraylist
				
				for(int j = 0; j < replaceVariables.size(); j++){ // Trata de remplazar si es una variable
					if(funtionality.get(i).equalsIgnoreCase(variablesM.get(j))){
						funtionality.set(i, replaceVariables.get(j));
					}

					if(funtionality.get(i).equalsIgnoreCase("cond")){ // Verificando si tiene un cond
						logic = true;
					}

				}
			}

			// Empieza la ejecución del programa verificando en donde empieza
			if(logic){
				funtionality = predicateCommunication(functionName, replaceVariables);

				return "AUN NO PAPA";
			}else{

				// Realizando sin recursividad 
				for(int i = 0; i < funtionality.size(); i++){

					// Verificando si ya paso por un operador aritmetico o ya esta pasando
					container.add(funtionality.get(i));
					
					if(operadoresAritmeticos.contains(funtionality.get(i)) || aritmetico){ 
						aritmetico = true; // Ya hubo un operador aritmetico
						if(container.size() == 3){ // Esperando a que hayan elementos suficientes
							refresh();
							container.add(calc.operar(convertArrayList(3)));
						}
					}

				}

				// Consiguiendo el valor final 
				resultado = container.removeFirst();

				return resultado;
			}

		}else{ // Cuando ! [x,y].size() == [3, 3, 8].size() 
			return "*** - EVAL/APPLAY: se han entregado demasiados argumentos a " + functionName;

		}
		
	}


	/**
	* Se encarga de comunicarse con la clase de predicado 
	* @pre se tiene una operacion logica
	* @pos se tiene una operacion aritmetica
	* @param functionName es el nombre de la funcion que se esta corriendo 
	* @param replaceVariables son las variables que se deben de cambiar al momento de correr la funcion
	* @return devuelve un arraylist que puede ser ejecutado por el programa
	*/
	private ArrayList<String> predicateCommunication(String functionName, ArrayList<String> replaceVariables){
		Predicados predicate = new Predicados();
		ArrayList<ArrayList<String>> communicate = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<>();
		String[] temp;
		String response;

		for(int i = 0; i < this.oldFunction.get(functionName).size(); i++){
			communicate.add(this.oldFunction.get(functionName).get(i));
		}
				
		// Remplazando todas las variables por números
		for(int i = 0; i < communicate.size(); i++){ // Por cada elemento del arraylist
			for(int j = 0; j < communicate.get(i).size(); j++){ // Por cada string en el arraylist

				for(int k = 0; k < replaceVariables.size(); k++){ // Por cada variable

					if(communicate.get(i).get(j).equalsIgnoreCase(variables.get(functionName).get(k))){
						communicate.get(i).set(j, replaceVariables.get(k)); // Remplazando las variables por números
					}

				}

			}
		}

		System.out.println("Predicado\n" + communicate);
		// Consiguiendo el string que tendra que convertirse en arraylist para ser operado
		response = predicate.funCond(this.oldFunction.get(functionName));

		temp = response.split(" ");

		for(int i = 0; i < temp.length; i++){
			aux.add(temp[i]);
		}

		System.out.println(aux);

		return aux;
	}

	/**
	* Se encarga de crear un array list de arraylist 
	* @pre los datos son de tipo string o arraylist string 
	* @pos los datos estan en un arraylist de arraylist string
	* @param cant cantidad de elementos que se quieren convertir de la base de datos 
	* @return los datos ya convertidos
	*/
	private ArrayList<ArrayList<String>> convertArrayList(Integer cant){
		ArrayList<ArrayList<String>> dReturn = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<>();

		// Metiendo los datos
		for(int i = 0; i < cant; i++){
			aux.add(container.removeFirst());			
		}

		dReturn.add(aux);
		return dReturn;
	} 

	/**
	* Se encarga de hacer que el valor aritmetico vaya primero luego los nombres
	* @pre los elementos del contenedor no son aceptados por calcular 
	* @pos los elementos son aceptados por calcular
	*/
	private void refresh(){
		String temp, aux;

		try{
			Float.parseFloat(container.element()); // Verificando si es numero u operador

			// Cambiando los valores para que quede el operador aritmetico en la primera posicion
			temp = container.removeFirst(); // Numero
			aux = container.removeFirst(); // Operador aritmetico
 
			container.addFirst(temp);
			container.addFirst(aux);

		}catch(Exception e){
			return;
		}
	}

	/**
	* Da a conocer al exterior si posee la llave o no 
	* @pos da una vista al mundo si esta la funcion
	* @param function es el nombre de la funcion que quiere ser validada
	* @return si la contiene o <noframes></noframes>
	*/
	public Boolean hasKey(ArrayList<ArrayList<String>> function){
		return functions.containsKey(function.get(0).get(1).toUpperCase()); 
	}




	/**
	* Se encarga de agregar una nueva funcin al mapa
	* @pre hay una n cantidad de funciones y variables
	* @pos hay una cantidad (n + 1) de funciones y variables
	* @param nuevaFuncion contiene la funcioin que desea ser agregada
	* @return el nombre de la funcion en mayusculas
	*/
	public String setFuncion(ArrayList<ArrayList<String>> nuevaFuncion){
		ArrayList<String> variablesF = new ArrayList<>();
		ArrayList<String> funtion = new ArrayList<>();
		String functionName;

		// Consiguiendo el nombre y las funciones
		variablesF = setNombreFuncion(nuevaFuncion);
		functionName = variablesF.get(0);
		
		// Eliminando el nombre y cambiandolo a mayuscular
		variablesF.remove(0);
		functionName = functionName.toUpperCase();

		funtion = setFuncionalidadFuncion(nuevaFuncion); // Consiguiendo el funcionamiento de la función
		
		nuevaFuncion.remove(nuevaFuncion.size() - 1); // Eliminando la ultima posicion

		// Agregando las funciones 
		this.functions.put(functionName, funtion);
		this.variables.put(functionName, variablesF);
		this.oldFunction.put(functionName, nuevaFuncion);

		/**
		Borrar despues
		*/
		System.out.println("\nInfo Metodo:");
		System.out.println("OPERACIONES" + this.functions.get(functionName));
		System.out.println("VARIABLES FUN" + this.variables.get(functionName));
		System.out.println("??"+this.oldFunction.get(functionName));

		return functionName;
	}

	/**
	 * Se encarga de encontrar el nombre de la función y devolverlo para su uso
	 * @pre el nombre de la función esta mesclado con otros datos
	 * @pos el nombre y las variables estan separados
	 * @param nombre contiene el nombre de la función y las variables que necesitas ser agregadas
	 * @return el nombre de la funcion y todas las variables
	 * *Utilizado en setFuncion
	 */
	private ArrayList<String> setNombreFuncion(ArrayList<ArrayList<String>> nombre) {
		ArrayList<String> nombre2 = nombre.get(nombre.size() - 1);

		ArrayList<String> temporal = new ArrayList<String>();
		Integer index = 0;
		String nombreAux = "", nombreAux2 = "";
		String[] aux = new String[2];
		Boolean flag = false;

		// Encontrando el nombre con base al defun
		for(int i = 0; i < nombre2.size(); i++){
			nombreAux = nombre2.get(i).replace(" ", "");
			if(nombreAux.equalsIgnoreCase("defun")){
				index = i;
			}
		}

		// Asignandole el nombre
		nombreAux2 = nombre2.get(index + 1);

		nombreAux = "";
		for (int i=0; i<nombre.size(); i++) {
			for (int j=0; j<nombre.get(i).size(); j++) {
				if (nombre.get(i).get(j).contains("(") && nombre.get(i).get(j).contains(")")) {

					nombreAux = nombre.get(i).get(j);
				}				
			}
		}	

		if (nombreAux.equals("")) {
			nombre2 = nombre.get(nombre.size() - 2); //Se obtiene el array anterior
			for (String a: nombre2) {
				nombreAux += a;
			}
		}
		
		nombreAux = nombreAux.replaceAll("\\)", "");
		nombreAux = nombreAux.replaceAll("\\(", "");

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
	 * @param función la funcionalidad de la funcion 
	 * @return un arraylist de string de un arraylist con el funcionamiento
	 * *Utilizado en setFuncion
	 */
	private ArrayList<String> setFuncionalidadFuncion(ArrayList<ArrayList<String>> funtionality){
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
		
		aux = temp.get(0);

		return aux;
	}

}
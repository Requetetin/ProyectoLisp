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
	private Map<ArrayList<String>, ArrayList<ArrayList<String>>> functions = new HashMap<>();
	private Map<ArrayList<String>, ArrayList<String>> variables = new HashMap<>();

	/**
	 * Se encarga de correr una función o indicar que no se encuentra
	 * @pos se ejecuta una función o se manda un error
	 * @param funtion es el nombre de la función que quiere ser utilizada
	 * @return el resultado obtenido luego de realizar la función
	 */
	public String runFuncion(String funtion){
		String[] temporal = new String[2];
		temporal = funtion.split("(");

		// Regresando a su estado inicial solo que separados
		temporal[0] = temporal[0].toUpperCase();
		temporal[1] = "(" + temporal[1];

		if(functions.containsKey(temporal[0])){
			return "HOLAAAA BB :3";
		}else{

			return "*** - EVAL: la funcion " + temporal[0] + " no esta definida";
		}

	}

	/**
	* Se encarga de agregar una nueva funcin al mapa
	* @pre hay una n cantidad de funciones y variables
	* @pos hay una cantidad (n + 1) de funciones y variables
	* @param nuevaFuncion contiene la funcioin que desea ser agregada
	*/
	public String setFuncion(ArrayList<ArrayList<String>> nuevaFuncion){
		ArrayList<ArrayList<String>> temporal = new ArrayList<>();
		ArrayList<ArrayList<String>> funtion = new ArrayList<>();
		String funtionName = "";

		temporal = setNombreFuncion(nuevaFuncion.get(nuevaFuncion.size() - 1), nuevaFuncion.get(nuevaFuncion.size() - 2)); // Mandando el nombre

		funtion = setFuncionalidadFuncion(nuevaFuncion); // Consiguiendo el funcionamiento de la función

		// Agregando las funciones 
		this.functions.put(temporal.get(0), funtion);
		this.variables.put(temporal.get(0), temporal.get(1));

		// Pasando el nombre de la funcion en mayusculas
		for(int i = 0; i < temporal.get(0).size(); i++){	
			funtionName += temporal.get(0).get(i);
		}

		return funtionName;
	}

	/**
	 * Se encarga de encontrar el nombre de la función y devolverlo para su uso
	 * @pre el nombre de la función esta mesclado con otros datos
	 * @pos el nombre de la función esta separado
	 * @param nombre contiene el nombre de la función
	 * @param variables son las variables 
	 * @return el nombre de la función en mayúsculas
	 * *Utilizado en setFuncion
	 */
	private ArrayList<ArrayList<String>> setNombreFuncion(ArrayList<String> nombre, ArrayList<String> variables) {
		ArrayList<ArrayList<String>> temporal = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<>();

		// Consiguiendo el nombre de la función
		for(int i = 6; i < nombre.size(); i++){
			
			if(nombre.get(i).equals(" ")){
				break;
			}
			aux.add(nombre.get(i).toUpperCase());
		}

		// Metiendo el nombre
		temporal.add(aux);
		aux.clear();

		// Consiguiendo los parametros de la funcion 
		for(int i = 1; i < variables.size() - 2; i++){
			aux.add(variables.get(i));
		}

		// Metiendo las variables
		temporal.add(aux);

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
	private ArrayList<ArrayList<String>> setFuncionalidadFuncion(ArrayList<ArrayList<String>> function){
		ArrayList<ArrayList<String>> temp = new ArrayList<>();
		ArrayList<String> aux = new ArrayList<>();

		// Agregando a una arraylist 
		for(int i = 0; i < function.size() - 3; i++){
			for(int j = 1; j < function.get(i).size() - 2; j++){

				// Agregando la funcionalidad sin parentesis
				aux.add(function.get(i).get(j));

			}

			temp.add(aux);

		}

		return temp;
	}

}
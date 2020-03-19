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
	public Map<String, ArrayList<ArrayList<String>>> functions = new HashMap<>();
	public Map<String, ArrayList<String>> variables = new HashMap<>();

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
		ArrayList<String> variables = new ArrayList<>();
		ArrayList<ArrayList<String>> funtion = new ArrayList<>();
		String funtionName;

		// Consiguiendo el nombre y las funciones
		variables = setNombreFuncion(nuevaFuncion.get(nuevaFuncion.size() - 1));
		funtionName = variables.get(0);

		// Eliminando el nombre y cambiandolo a mayuscular
		variables.remove(funtionName);
		funtionName = funtionName.toUpperCase();

		funtion = setFuncionalidadFuncion(nuevaFuncion); // Consiguiendo el funcionamiento de la función

		// Agregando las funciones 
		this.functions.put(funtionName, funtion);
		this.variables.put(funtionName, variables);


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
		String[] aux;

		// Separando los elementos
		aux = nombre.get(2).split("(");
		aux[1].replace(")", "");

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
		for(int i = 0; i < funtionality.size() - 2; i++){
			for(int j = 1; j < funtionality.get(i).size() - 1; j++){

				// Agregando la funcionalidad sin parentesis
				aux.add(funtionality.get(i).get(j));

			}

			temp.add(aux);
		}

		return temp;
	}

}
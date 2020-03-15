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
	private Map<String, String> variables = new HashMap<>();

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
	public void setFuncion(ArrayList<ArrayList<String>> nuevaFuncion){
		String[] temporal = new String[2];
		temporal = setNombreFuncion(nuevaFuncion.get(nuevaFuncion.size() - 1)); // Mandando el nombre

		// Consiguiendo el funcionamiento de la función


	}

	/**
	 * Se encarga de encontrar el nombre de la función y devolverlo para su uso
	 * @pre el nombre de la función esta mesclado con otros datos
	 * @pos el nombre de la función esta separado
	 * @param nombre contiene el nombre de la función
	 * @return el nombre de la función en mayúsculas
	 * *Utilizado en setFuncion
	 */
	private String[] setNombreFuncion(ArrayList<String> nombre) {
		String[] temporal = new String[2];
		temporal = (nombre.get(2)).split("(");
		temporal[0] = temporal[0].toUpperCase();
		temporal[1] = "(" + temporal[1];
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
	private String setFuncionalidadFuncion(ArrayList<String> function){



		return " ";
	}

}
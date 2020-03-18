/**
* @author Andrea Amaya 19357
* @author Martin Amado 19020
* @author Brandon Hernández 19376
*
*
* Realiza operaciones aritmeticas 
*/
public class Calcular{

	/**
     * Suma dos números
     * @post crea un número resultante de la suma de los dos enviados
     * @param numero1 es el primer número que se sumara con el segundo
     * @param numero2 es el segundo número que se sumara con el primero
     * @return devuelve la suma de los dos números
     */
	public Integer suma(Integer numero1, Integer numero2){
		return numero1 + numero2;
	}

	/**
     * Resta dos números
     * @post crea un número resultante de la resta de los dos enviados
     * @param numero1 es el primer número que sera restado con el segundo
     * @param numero2 es el segundo número que se restara del primero
     * @return devuelve la resta de los dos números
     */
	public Integer resta(Integer numero1, Integer numero2){
		return numero1 - numero2;
	}

	/**
     * Multiplicacion dos números
     * @post crea un número resultante de la multiplicacion de los dos enviados
     * @param numero1 es el primer número que se multliplicara con el segundo
     * @param numero2 es el segundo número que se multiplicara con el primero
     * @return devuelve la multilplicacion de los dos números
     */
	public Integer multiplicacion(Integer numero1, Integer numero2){
		return numero1*numero2;
	}

	/**
     * Division dos números (verifica que el dividendo no sea 0)
     * @post crea un número resultante de la division de los dos enviados
     * @param numero1 es el primer número es el divisor
     * @param numero2 es el segundo número es el dividendo
     * @return devuelve la division de los dos números
     */
	public Integer dividir(Integer numero1, Integer numero2){
		try{
            return numero1/numero2;
        }catch(ArithmeticException e){
            return 0;
        }
	}

	
}
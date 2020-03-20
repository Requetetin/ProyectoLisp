/**
* @author Andrea Amaya 19357
* @author Martin Amado 19020
* @author Brandon Hernández 19376
*
*
* Realiza operaciones aritmeticas 
*/
import java.util.*;
public class Calcular{
    /**
     * @param operacion Recibe los operandos y la operadores
     * @return devuelve la operacion realizada por el operando
     */
    public String operar(ArrayList<ArrayList<String>> operacion){
        for (int i=0; i<operacion.size(); i++) {
            if (operacion.get(i).contains("+")) {
                try {
                    int posicion = operacion.get(i).indexOf("+");
                    float valor1 = (float)Float.parseFloat(operacion.get(i).get(posicion+1));
                    float valor2 = (float)Float.parseFloat(operacion.get(i).get(posicion+2));
                    
                    return Float.toString(suma(valor1, valor2));
                } catch (Exception e) {
                    return "Operacion invalida";
                }
            } else if (operacion.get(i).contains("-")) {
                try {
                	int posicion = operacion.get(i).indexOf("-");
                    
                    float valor1 = (float)Float.parseFloat(operacion.get(i).get(posicion+1));
                    float valor2 = (float)Float.parseFloat(operacion.get(i).get(posicion+2));

                    return Float.toString(resta(valor1, valor2));
                } catch (Exception e) {
                    return "Operacion invalida";
                }
            } else if (operacion.get(i).contains("*")) {
                try {
                    int posicion = operacion.get(i).indexOf("*");
                    float valor1 = (float)Float.parseFloat(operacion.get(i).get(posicion+1));
                    float valor2 = (float)Float.parseFloat(operacion.get(i).get(posicion+2));

                    return Float.toString(multiplicacion(valor1, valor2));
                } catch (Exception e) {
                    return "Operacion invalida";
                }
            } else if (operacion.get(i).contains("/")) {
                try {
                    int posicion = operacion.get(i).indexOf("/");
                    float valor1 = (float)Float.parseFloat(operacion.get(i).get(posicion+1));
                    float valor2 = (float)Float.parseFloat(operacion.get(i).get(posicion+2));

                    return Float.toString(dividir(valor1, valor2));
                } catch (Exception e) {
                    return "Operacion invalida";
                }
            } else {
                 return "Operacion no encontrada";
            }
        }
        return "Operacion no encontrada";
       
    }

	/**
     * Suma dos números
     * @post crea un número resultante de la suma de los dos enviados
     * @param numero1 es el primer número que se sumara con el segundo
     * @param numero2 es el segundo número que se sumara con el primero
     * @return devuelve la suma de los dos números
     */
	public float suma(float numero1, float numero2){
		return numero1 + numero2;
	}

	/**
     * Resta dos números
     * @post crea un número resultante de la resta de los dos enviados
     * @param numero1 es el primer número que sera restado con el segundo
     * @param numero2 es el segundo número que se restara del primero
     * @return devuelve la resta de los dos números
     */
	public float resta(float numero1, float numero2){
		return numero1 - numero2;
	}

	/**
     * Multiplicacion dos números
     * @post crea un número resultante de la multiplicacion de los dos enviados
     * @param numero1 es el primer número que se multliplicara con el segundo
     * @param numero2 es el segundo número que se multiplicara con el primero
     * @return devuelve la multilplicacion de los dos números
     */
	public float multiplicacion(float numero1, float numero2){
		return numero1*numero2;
	}

	/**
     * Division dos números (verifica que el dividendo no sea 0)
     * @post crea un número resultante de la division de los dos enviados
     * @param numero1 es el primer número es el divisor
     * @param numero2 es el segundo número es el dividendo
     * @return devuelve la division de los dos números
     */
	public float dividir(float numero1, float numero2){
		try{
            return numero1/numero2;
        }catch(ArithmeticException e){
            return 0.0f;
        }
	}

	
}
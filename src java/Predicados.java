import java.util.ArrayList;
/**
* @author Andrea Amaya 19357
* @author Martin Amado 19020
* @author Brandon Hernández 19376
*
*
* Encargada de realizar 4 funciones basicas para el funcionamiento de lisp
* Atom, List, Equals y Cond
*/
public class Predicados{


	/**
	 * Atom devuelve True cuando su parametro no es una celda cons
	 * pre: El ususario ingresa un argumento valido
	 * post: 
	 * @param listado es la funcion ingresada por el usuario convertida para poder ser operada
	 * @return true/false
	 */
	public String funAtom(ArrayList<ArrayList<String>> listado){
		

		for(int i=0;i<listado.size();i++){
			if(listado.get(i).contains("atom")){
				//Busca el indice de la palabra atom
				int p = listado.get(i).indexOf("atom");
				try{
					//Busca los parametros que indican si lo que ingresa es una celda cons
					if(listado.get(i-1).contains("cons")||listado.get(i-1).contains("list")||listado.get(i).get(p+1).contains("'")){
						return "false";
					}else{
						//Retorna true siempre que se cumpla que no sea celda cons
						return "true";
					}
				}catch(Exception e){
					return "true";
				}
				
			}
		}return "false";
	}

	/**
	 * Lista convierte su entrada a una lista
	 * pre: El ususario ingresa un argumento valido
	 * post: 
	 * @param listado es la funcion ingresada por el usuario convertida para poder ser operada
	 * @return La lista que se convirtio
	 */
	public ArrayList<String> funList(ArrayList<ArrayList<String>> listado){
		ArrayList<String> temp = new ArrayList<String>();
		for(int i=0;i<listado.size();i++){
			if(listado.get(i).contains("list")||listado.get(i).contains(" list")){
				//Crea un arraylist temporal igual al igresado por el usuario
				temp = listado.get(i);
				//Quita la palabra 
				temp.remove(temp.indexOf("list"));
				listado.set(i,temp);
				return temp;
			}
		}
		return temp;
	}

	/**
	 * Equals devuelve true cuando los dos parametros son iguales
	 * pre: El ususario ingresa un argumento valido
	 * post: 
	 * @param listado es la funcion ingresada por el usuario convertida para poder ser operada
	 * @return true/false
	 */
	public String funEquals(ArrayList<ArrayList<String>> listado){
		for(int i=0; i<listado.size();i++){

			if(listado.get(i).contains("equal")){
				int p = listado.get(i).indexOf("equal");
				//Revisa para comparar dos parametros que son otras listas (No dos strings)
				if(listado.get(i).size()<5){
					if(listado.get(i-1).equals(listado.get(i-2))){
						return "true";
					}
					//Revisa para comparar dos parametros de una palabra
				}else if(listado.get(i).size() == 5){
					if(listado.get(i).get(p+1).equals(listado.get(i).get(p+2))){
						return "true";
					}
					//Revisa para dos Strings de mas de una palabra
				}else{
					//Dos strings temporales que se van a comparar
					String a = "";
					String b = "";
					int d = 0;
					//Valor que indica cuantos espacios hay despues de la funcion equals
					int rest = listado.get(i).size()-2-p;
					//Limite para el primer string
					int lim1 = p+(rest/2)+1;

					//Se crean los strings a y b
					for(int j=p+1; j<lim1;j++){
						a+= listado.get(i).get(j);
					}for(int k = lim1;k<listado.get(i).size()-1;k++){
						b+= listado.get(i).get(k);
					}
					
					//Se comparan a y b
					if(a.equals(b)){
						return "true";
					}
					
				}
				
			}else{
					return "false";
				}
		}
		return "false";
	}

	/**
	 * Cond retorna el parametro correspondiente a la funcion que se hace verdadera
	 * pre: El ususario ingresa un argumento valido
	 * post: 
	 * @param listado es la funcion ingresada por el usuario convertida para poder ser operada
	 * @return Parametro string
	 */
	public String funCond(ArrayList<ArrayList<String>> listado){
		String s = "";
		for(int i=0; i<listado.size();i++){
			if(listado.get(i).contains("cond")){
				Float a = 0.0f;
				Float b = 0.0f;
				String c = "";

				//Busca los numeros y signos de la primera condicion
				a = Float.parseFloat(listado.get(i-2).get(2));
				b = Float.parseFloat(listado.get(i-2).get(3));
				c = listado.get(i-2).get(1);
			
				//Este switch case es el de la primera condicion
				switch(c){
					case ">":
					if(a > b){
						//Se crea un string del parametro a devolver
						for(int j=1;j<listado.get(i-1).size()-1;j++){
							s+= listado.get(i-1).get(j);
						}
						return s;
					}else{
						//Sino, realiza el mismo proceso con el segundo parametro
						a = Float.parseFloat(listado.get(i-4).get(2));
						b = Float.parseFloat(listado.get(i-4).get(3));
						c = listado.get(i-4).get(1);
						switch(c){
							case ">":
								if(a > b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}
									return s;	
								}else{
									if(listado.get(i-5).size()>3){
										for(int j=2;j<listado.get(i-5).size()-1;j++){
												s+= listado.get(i-5).get(j)+" ";
											}
											return s;
										}
									else{
										for(int j=i-6;j>-1;j--){
											for(int k=1; k<listado.get(j).size()-1;k++){
												s+= listado.get(j).get(k)+" ";
											}
										}
										return s;
									}
								}
							 
							case "<":
								if(a < b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								if(listado.get(i-5).size()>3){
										for(int j=2;j<listado.get(i-5).size()-1;j++){
												s+= listado.get(i-5).get(j)+" ";
											}
											return s;
										}
									else{
										for(int j=i-6;j>-1;j--){
											for(int k=1; k<listado.get(j).size()-1;k++){
												s+= listado.get(j).get(k)+" ";
											}
										}
										return s;
									}
								}
							 

							case "=":
								if(Math.abs(a-b)<1.0){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								if(listado.get(i-5).size()>3){
										for(int j=2;j<listado.get(i-5).size()-1;j++){
												s+= listado.get(i-5).get(j)+" ";
											}
											return s;
										}
									else{
										for(int j=i-6;j>-1;j--){
											for(int k=1; k<listado.get(j).size()-1;k++){
												s+= listado.get(j).get(k)+" ";
											}
										}
										return s;
									}
								}
							 
						}
					}
					
					
					 

					case "<":
					if(a < b){
						for(int j=1;j<listado.get(i-1).size()-1;j++){
						s+= listado.get(i-1).get(j);
						}
						return s;
					}else{
						a = Float.parseFloat(listado.get(i-4).get(2));
						b = Float.parseFloat(listado.get(i-4).get(3));
						c = listado.get(i-4).get(1);
						switch(c){
							case ">":
								if(a > b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								if(listado.get(i-5).size()>3){
										for(int j=2;j<listado.get(i-5).size()-1;j++){
												s+= listado.get(i-5).get(j)+" ";
											}
											return s;
										}
									else{
										for(int j=i-6;j>-1;j--){
											for(int k=1; k<listado.get(j).size()-1;k++){
												s+= listado.get(j).get(k)+" ";
											}
										}
										return s;
									}
								}
							case "<":
								if(a < b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								if(listado.get(i-5).size()>3){
										for(int j=2;j<listado.get(i-5).size()-1;j++){
												s+= listado.get(i-5).get(j)+" ";
											}
											return s;
										}
									else{
										for(int j=i-6;j>-1;j--){
											for(int k=1; k<listado.get(j).size()-1;k++){
												s+= listado.get(j).get(k)+" ";
											}
										}
										return s;
									}
								}
							 

							case "=":
								if(Math.abs(a-b)<1.0){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}
									return s;	
								}else{
								if(listado.get(i-5).size()>3){
										for(int j=2;j<listado.get(i-5).size()-1;j++){
												s+= listado.get(i-5).get(j)+" ";
											}
											return s;
										}
									else{
										for(int j=i-6;j>-1;j--){
											for(int k=1; k<listado.get(j).size()-1;k++){
												s+= listado.get(j).get(k)+" ";
											}
										}
										return s;
									}
								}
							 
						}
					}
					

					case "=":
					if(Math.abs(a-b)<1){
						for(int j=1;j<listado.get(i-1).size()-1;j++){
						s+= listado.get(i-1).get(j);
						}
						return s;
					}else{
						a = Float.parseFloat(listado.get(i-4).get(2));
						b = Float.parseFloat(listado.get(i-4).get(3));
						c = listado.get(i-4).get(1);
						switch(c){
							case ">":
								if(a > b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								if(listado.get(i-5).size()>3){
										for(int j=2;j<listado.get(i-5).size()-1;j++){
												s+= listado.get(i-5).get(j)+" ";
											}
											return s;
										}
									else{
										for(int j=i-6;j>-1;j--){
											for(int k=1; k<listado.get(j).size()-1;k++){
												s+= listado.get(j).get(k)+" ";
											}
										}
										return s;
									}
								}
								
							 
							case "<":
								if(a < b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								if(listado.get(i-5).size()>3){
										for(int j=2;j<listado.get(i-5).size()-1;j++){
												s+= listado.get(i-5).get(j)+" ";
											}
											return s;
										}
									else{
										for(int j=i-6;j>-1;j--){
											for(int k=1; k<listado.get(j).size()-1;k++){
												s+= listado.get(j).get(k)+" ";
											}
										}
										return s;
									}
								}
							 
							case "=":
								if(Math.abs(a-b)<1){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								if(listado.get(i-5).size()>3){
										for(int j=2;j<listado.get(i-5).size()-1;j++){
												s+= listado.get(i-5).get(j)+" ";
											}
											return s;
										}
									else{
										for(int j=i-6;j>-1;j--){
											for(int k=1; k<listado.get(j).size()-1;k++){
												s+= listado.get(j).get(k)+" ";
											}
										}
										return s;
									}
								}
							 
						}
					}
					


				}

				
			}	
		
		
		}
		return "Fallo funcion cond";
	}	
}
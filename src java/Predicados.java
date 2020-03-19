import java.util.ArrayList;
/**
* @author Andrea Amaya 19357
* @author Martin Amado 19020
* @author Brandon Hernández 19376
*
*
* Punto de arranque del interprete de lisp 
*/
public class Predicados{

	public String funAtom(ArrayList<ArrayList<String>> listado){
		

		for(int i=0;i<listado.size();i++){
			if(listado.get(i).contains("atom")){
				int p = listado.get(i).indexOf("atom");
				if(listado.get(i).contains("cons")||listado.get(i).contains("list")||listado.get(p-1).contains("'")){
					return "false";
				}else{
					return "true  ";
				}
			}
		}return "false";
	}

	public ArrayList<ArrayList<String>> funList(ArrayList<ArrayList<String>> listado){
		for(int i=0;i<listado.size();i++){
			if(listado.get(i).contains("list")||listado.get(i).contains(" list")){
				ArrayList<String> temp = new ArrayList<String>();
				temp = listado.get(i);
				temp.remove(temp.indexOf("list"));
				listado.set(i,temp);
				return listado;
			}
		}
		return listado;
	}

	public String funEquals(ArrayList<ArrayList<String>> listado){
		for(int i=0; i<listado.size();i++){

			if(listado.get(i).contains("equals")){
				int p = listado.get(i).indexOf("equals");
				if(listado.get(i).size()<6){
					if(listado.get(i-1).equals(listado.get(i-2))){
						return "true";
					}
				}else if(listado.get(i).size() == 6){
					if(listado.get(i).get(p+1).equals(listado.get(i).get(p+2))){
						return "true";
					}
				}else{
					String a = "";
					String b = "";
					int d = 0;
					int rest = listado.get(i).size()-2-p;
					int lim1 = p+(rest/2)+1;

					for(int j=p+1; j<lim1;j++){
						a+= listado.get(i).get(j);
					}for(int k = lim1;k<listado.get(i).size()-1;k++){
						b+= listado.get(i).get(k);
					}
				
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

	public String funCond(ArrayList<ArrayList<String>> listado){
		String s = "";
		for(int i=0; i<listado.size();i++){
			if(listado.get(i).contains("cond")){
				Integer a = 0;
				Integer b = 0;
				String c = "";

				a = Integer.parseInt(listado.get(i-2).get(2));
				b = Integer.parseInt(listado.get(i-2).get(3));
				c = listado.get(i-2).get(1);
			

				switch(c){
					case ">":
					if(a > b){
						for(int j=1;j<listado.get(i-1).size()-1;j++){
							s+= listado.get(i-1).get(j);
						}
						return s;
					}else{
						a = Integer.parseInt(listado.get(i-4).get(2));
						b = Integer.parseInt(listado.get(i-4).get(3));
						c = listado.get(i-4).get(1);
						switch(c){
							case ">":
								if(a > b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}
									return s;	
								}else{
								for(int j=1;j<listado.get(i-6).size()-1;j++){
									s+= listado.get(i-6).get(j);
									}
									return s;
								}
							 
							case "<":
								if(a < b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								for(int j=1;j<listado.get(i-6).size()-1;j++){
									s+= listado.get(i-6).get(j);
									}
									return s;
								}
							 

							case "=":
								if(a == b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								for(int j=1;j<listado.get(i-6).size()-1;j++){
									s+= listado.get(i-6).get(j);
									}
									return s;
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
						a = Integer.parseInt(listado.get(i-4).get(2));
						b = Integer.parseInt(listado.get(i-4).get(3));
						c = listado.get(i-4).get(1);
						switch(c){
							case ">":
								if(a > b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								for(int j=1;j<listado.get(i-6).size()-1;j++){
									s+= listado.get(i-6).get(j);
									}
									return s;
								}
							case "<":
								if(a < b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								for(int j=1;j<listado.get(i-6).size()-1;j++){
									s+= listado.get(i-6).get(j);
									}
									return s;
								}
							 

							case "=":
								if(a == b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}
									return s;	
								}else{
								for(int j=1;j<listado.get(i-6).size()-1;j++){
									s+= listado.get(i-6).get(j);
									}
									return s;
								}
							 
						}
					}
					

					case "=":
					if(a == b){
						for(int j=1;j<listado.get(i-1).size()-1;j++){
						s+= listado.get(i-1).get(j);
						}
						return s;
					}else{
						a = Integer.parseInt(listado.get(i-4).get(2));
						b = Integer.parseInt(listado.get(i-4).get(3));
						c = listado.get(i-4).get(1);
						switch(c){
							case ">":
								if(a > b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								for(int j=1;j<listado.get(i-6).size()-1;j++){
									s+= listado.get(i-6).get(j);
									}
									return s;
								}
							 
							case "<":
								if(a < b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								for(int j=1;j<listado.get(i-6).size()-1;j++){
									s+= listado.get(i-6).get(j);
									}
									return s;
								}
							 
							case "=":
								if(a == b){
								for(int j=1;j<listado.get(i-3).size()-1;j++){
									s+= listado.get(i-3).get(j);
									}	
									return s;
								}else{
								for(int j=1;j<listado.get(i-6).size()-1;j++){
									s+= listado.get(i-6).get(j);
									}
									return s;
								}
							 
						}
					}
					


				}

				
			}	
		
		
		}
		return "Fallo funcion cond";
	}	
}
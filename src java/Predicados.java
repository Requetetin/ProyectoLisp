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

	public boolean funAtom(ArrayList<ArrayList<String>> listado){
		
		for(int i=0;i<listado.size();i++){
			if(listado.get(i).contains("atom")){
				int p = listado.get(i).indexOf("atom");
				if(listado.get(i).get(p-1).contains("cons")||listado.get(i).get(p-1).contains("list")||listado.get(i).get(p-1).equals("'")){
					return true;
				}else{
					return false;
				}
			}
		}return false;
	}

	public ArrayList<ArrayList<String>> funList(ArrayList<ArrayList<String>> listado){
		for(int i=0;i<listado.size();i++){
			if(listado.get(i).contains("list")){
				ArrayList<String> temp = new ArrayList<String>();
				temp = listado.get(i);
				temp.remove(temp.indexOf("list"));
				listado.set(i,temp);
				return listado;
			}
		}
		return listado;
	}

	public boolean funEquals(ArrayList<ArrayList<String>> listado){
		for(int i=0; i<listado.size();i++){
			if(listado.get(i).contains("equals")){
				int p = listado.get(i).indexOf("equals");
				if(listado.get(i).get(p-1).equals(listado.get(i).get(p-2))){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}

	public String funCond(ArrayList<ArrayList<String>> listado){
		return "yes";
	}
}
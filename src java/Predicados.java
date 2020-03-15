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

	public boolean funAtom(ArrayList<String> listado){
		int l = listado.indexOf("atom");
		String s = listado.get(l);
		char j = s.charAt(s.length()-1);
		if(listado.get(l+1).contains("cons") || String.valueOf(j).equals("'") || listado.get(l+1).contains("list")){
			return false;
		}else{
			return true;
		}
	}

	public ArrayList<String> funList(ArrayList<String> listado){
		return listado;
	}

	public boolean funEquals(ArrayList<String> listado){
		int l = listado.indexOf("equal");
		//if(){

		//}else{

		//}
	}

	public String funCond(ArrayList<String> listado){
		return "yes";
	}
}
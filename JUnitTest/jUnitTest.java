import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

public class jUnitTest {
	Calcular calc = new Calcular();
	Leer read = new Leer();
	Predicados pred = new Predicados();
	ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
	
	ArrayList<String> temp = new ArrayList<String>();
	
	
	
	private void fillLists() {
	temp.add("(");
	temp.add("bien");
	temp.add("y");
	temp.add("tu");
	temp.add(")");
	arr.add(temp);
	temp.clear();
	
	temp.add("(");
	temp.add("hola");
	temp.add("como");
	temp.add("estas");
	temp.add(")");
	arr.add(temp);
	temp.clear();
	
	temp.add("(");
	temp.add("equals");
	temp.add(")");
	arr.add(temp);
	temp.clear();
	}
	

	
	@Test
	void testSuma() {
		assertEquals(6, calc.suma(1,5));
	}
	
	@Test
	void testResta() {
		assertEquals(8, calc.resta(18, 10));
	}
	
	@Test
	void testMult() {
		assertEquals(15, calc.multiplicacion(3, 5));
	}
	
	@Test
	void testDiv() {
		assertEquals(8,calc.dividir(16, 2));
	}
	
	@Test
	void testMethodFound() {
		assertEquals(true, read.methodPrintFound("print"));
	}
	
	@Test
	void testEquals() {
		fillLists();	
		assertEquals("false", pred.funEquals(arr));
	}
	
	

	

}

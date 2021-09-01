import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class testePizza {

	//Limpa os ingredientes
	@Before
	public void limparRegPizza() {
	    Pizza.getListaIngredientes();
	}

	//Verifica se o preço está correto
	@Test
	public void teste() {
	    Pizza P1 = new Pizza();
	    
	    P1.adicionaIngrediente("Muçarela");
	    P1.adicionaIngrediente("Catupiry");
	    P1.adicionaIngrediente("Pepperoni");
	    P1.adicionaIngrediente("Manjericão");
	    
	    assertEquals(4, P1.getIngrediente().size());
	}

	//Analise se a contagem de ingredientes funcionou :D
	@Test
	public void testeIngredientes() {
	    Pizza P1 = new Pizza();
	    
	    P1.adicionaIngrediente("Muçarela");
	    P1.adicionaIngrediente("Catupiry");
	    P1.adicionaIngrediente("Pepperoni");
	    P1.adicionaIngrediente("Manjericão");
	    
	    ArrayList<String> ingredientes = new ArrayList<String>();
	    ingredientes.addAll(P1.getIngrediente());
	    
	    assertEquals(ingredientes, P1.getIngrediente());
	}
}

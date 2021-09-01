import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testeCarrinho {
	 //Verifica se o preço da pizza eh somado corretamente
	@Test
	public void testeVerificarPreco() {
		Pizza P1 = new Pizza();

        P1.adicionaIngrediente("Muçarela");
	    P1.adicionaIngrediente("Catupiry");
	    P1.adicionaIngrediente("Pepperoni");
	    P1.adicionaIngrediente("Manjericão");

		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionarPizza(P1);

		assertEquals(35.0, carrinho.getprecoFinal(), 0);
	}
	//Evita pizza sem ingredientes
	@Test
	public void testeIngredientesVazio() {
		Pizza P1 = new Pizza();

		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionarPizza(P1);

		assertEquals(0, carrinho.getprecoFinal(), 0);
	}

}


public class Principal {

	public static void main(String[] args) {
		Pizza P1 = new Pizza();
		Pizza P2 = new Pizza();
		Pizza P3 = new Pizza();
		
		P1.adicionaIngrediente("Pepperoni");
		P1.adicionaIngrediente("Mucarela");
		P1.adicionaIngrediente("Manjericao");
		
		P2.adicionaIngrediente("Frango");
		P2.adicionaIngrediente("Catupiry");
		P2.adicionaIngrediente("Mucarela");
		P2.adicionaIngrediente("Bacon");
		
		P3.adicionaIngrediente("Mucarela");
		P3.adicionaIngrediente("Lombo");
		P3.adicionaIngrediente("Cream Cheese");;
		
		CarrinhoDeCompras c = new CarrinhoDeCompras();
		
		
		c.adicionarPizza(P1);
		c.adicionarPizza(P2);
		c.adicionarPizza(P3);
	
		System.out.println("Há no total " +c.pizzasTotais()+ " pizzas no carrinho");
		System.out.println("Valor total " + c.getprecoFinal());
		
		System.out.println("Os ingredientes utilizados foram: " +Pizza.getListaIngredientes());

	}

}

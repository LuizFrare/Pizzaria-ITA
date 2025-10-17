public class Principal {
    public static void main(String[] args) {
        Pizza p1 = new Pizza();
        Pizza p2 = new Pizza();
        Pizza p3 = new Pizza();

        p1.adicionaIngrediente("Pepperoni");
        p1.adicionaIngrediente("Mucarela");
        p1.adicionaIngrediente("Manjericão");

        p2.adicionaIngrediente("Frango");
        p2.adicionaIngrediente("Catupiry");
        p2.adicionaIngrediente("Mucarela");
        p2.adicionaIngrediente("Bacon");

        p3.adicionaIngrediente("Mucarela");
        p3.adicionaIngrediente("Lombo");
        p3.adicionaIngrediente("Cream Cheese");

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarPizza(p1);
        carrinho.adicionarPizza(p2);
        carrinho.adicionarPizza(p3);

        System.out.println("Há no total " + carrinho.getQuantidadePizzas() + " pizzas no carrinho.\n");

        System.out.println("Detalhes das pizzas:");
        System.out.println(carrinho); // usa o toString() do carrinho

        System.out.println("\nResumo de ingredientes usados:");
        for (var entry : Pizza.getListaIngredientes().entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " vez(es)");
        }

        System.out.println("\nIngredientes totais usados: " + Pizza.getIngredientesTotais());
    }
}

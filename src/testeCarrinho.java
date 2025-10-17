import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteCarrinho {

    private CarrinhoDeCompras carrinho;

    @BeforeEach
    void setup() {
        Pizza.resetarEstatisticas(); // limpa dados estáticos
        carrinho = new CarrinhoDeCompras();
    }

    // Verifica se o preço da pizza é calculado corretamente
    @Test
    public void testeVerificarPreco() {
        Pizza p1 = new Pizza();
        p1.adicionaIngrediente("Mussarela");
        p1.adicionaIngrediente("Catupiry");
        p1.adicionaIngrediente("Pepperoni");
        p1.adicionaIngrediente("Manjericão");

        carrinho.adicionarPizza(p1);

        assertEquals(35.0, carrinho.getPrecoFinal(), 0.01, "Preço incorreto para pizza média");
    }

    // Evita pizza sem ingredientes
    @Test
    public void testePizzaSemIngredientesNaoEntraNoCarrinho() {
        Pizza p1 = new Pizza();
        carrinho.adicionarPizza(p1);

        assertEquals(0, carrinho.getQuantidadePizzas(), "Pizza sem ingredientes não deve ser adicionada");
        assertEquals(0, carrinho.getPrecoFinal(), 0.01, "Preço deve ser zero");
    }

    // Verifica soma correta de várias pizzas
    @Test
    public void testeSomaDeVariosPrecos() {
        Pizza p1 = new Pizza();
        p1.adicionaIngrediente("Mussarela");
        p1.adicionaIngrediente("Catupiry");
        p1.adicionaIngrediente("Bacon"); // 3 ingredientes → R$35

        Pizza p2 = new Pizza();
        p2.adicionaIngrediente("Frango");
        p2.adicionaIngrediente("Cream Cheese");
        // 2 ingredientes → R$30

        carrinho.adicionarPizza(p1);
        carrinho.adicionarPizza(p2);

        assertEquals(65.0, carrinho.getPrecoFinal(), 0.01, "Soma total incorreta");
    }

    // Garante que os ingredientes foram contados globalmente
    @Test
    public void testeContagemGlobalDeIngredientes() {
        Pizza p1 = new Pizza();
        p1.adicionaIngrediente("Mussarela");
        p1.adicionaIngrediente("Catupiry");

        Pizza p2 = new Pizza();
        p2.adicionaIngrediente("Mussarela");

        carrinho.adicionarPizza(p1);
        carrinho.adicionarPizza(p2);

        assertEquals(3, Pizza.getIngredientesTotais(), "Total de ingredientes incorreto");
        assertEquals(2, Pizza.getListaIngredientes().get("mussarela"), "Contagem de Mussarela incorreta");
    }
}

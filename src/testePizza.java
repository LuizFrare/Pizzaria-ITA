import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestePizza {

    @BeforeEach
    public void limparRegPizza() {
        Pizza.resetarEstatisticas(); // zera os dados estáticos antes de cada teste
    }

    // Verifica se o número de ingredientes adicionados está correto
    @Test
    public void deveAdicionarIngredientesCorretamente() {
        Pizza p1 = new Pizza();

        p1.adicionaIngrediente("Mussarela");
        p1.adicionaIngrediente("Catupiry");
        p1.adicionaIngrediente("Pepperoni");
        p1.adicionaIngrediente("Manjericão");

        assertEquals(4, p1.getIngrediente().size(), "Deveria ter 4 ingredientes na pizza");
    }

    // Verifica se a lista de ingredientes retornada é a mesma
    @Test
    public void deveRetornarListaDeIngredientesCorreta() {
        Pizza p1 = new Pizza();

        p1.adicionaIngrediente("Mussarela");
        p1.adicionaIngrediente("Catupiry");
        p1.adicionaIngrediente("Pepperoni");
        p1.adicionaIngrediente("Manjericão");

        ArrayList<String> esperados = new ArrayList<>();
        esperados.add("mussarela");
        esperados.add("catupiry");
        esperados.add("pepperoni");
        esperados.add("manjericão");

        assertEquals(esperados, p1.getIngrediente(), "Lista de ingredientes não corresponde");
    }

    // Verifica se o preço é calculado corretamente com base na quantidade de ingredientes
    @Test
    public void deveCalcularPrecoCorretamente() {
        Pizza p1 = new Pizza();

        p1.adicionaIngrediente("Mussarela");
        p1.adicionaIngrediente("Catupiry");
        p1.adicionaIngrediente("Bacon");

        assertEquals(35.0, p1.getPreco(), 0.01, "Preço incorreto para 3 ingredientes");
    }

    // Verifica se o contador global de ingredientes funciona
    @Test
    public void deveContarIngredientesGlobais() {
        Pizza p1 = new Pizza();
        p1.adicionaIngrediente("Mussarela");
        p1.adicionaIngrediente("Catupiry");

        Pizza p2 = new Pizza();
        p2.adicionaIngrediente("Bacon");

        assertEquals(3, Pizza.getIngredientesTotais(), "Total de ingredientes globais incorreto");
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Pizza {

    private static int ingredientesTotais = 0;
    private static Map<String, Integer> ingredientesGastos = new HashMap<>();

    private double preco;
    private ArrayList<String> ingredientes = new ArrayList<>();

    // ---- Getters ----
    public ArrayList<String> getIngrediente() {
        return ingredientes;
    }

    public static Map<String, Integer> getListaIngredientes() {
        return ingredientesGastos;
    }

    public static int getIngredientesTotais() {
        return ingredientesTotais;
    }

    // ---- Métodos principais ----
    public void adicionaIngrediente(String ingrediente) {
        if (ingrediente == null || ingrediente.isBlank()) return;

        ingrediente = ingrediente.trim().toLowerCase();

        // evita ingredientes duplicados na mesma pizza
        if (!ingredientes.contains(ingrediente)) {
            this.ingredientes.add(ingrediente);
            contarIngrediente(ingrediente);
        }
    }

    public double getPreco() {
        int qtd = ingredientes.size();

        if (qtd <= 2) preco = 30;
        else if (qtd <= 5) preco = 35;
        else preco = 42;

        return preco;
    }

    private static void contarIngrediente(String ingrediente) {
        ingredientesGastos.put(ingrediente, ingredientesGastos.getOrDefault(ingrediente, 0) + 1);
        ingredientesTotais++;
    }

    // ---- Extras úteis ----
    public void limparIngredientes() {
        ingredientes.clear();
        preco = 0;
    }

    public static void resetarEstatisticas() {
        ingredientesGastos.clear();
        ingredientesTotais = 0;
    }

    // ---- Qualidade de vida ----
    @Override
    public String toString() {
        return "Pizza com " + ingredientes.size() + " ingredientes: " +
               String.join(", ", ingredientes) +
               " | Preço: R$ " + String.format("%.2f", getPreco());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pizza)) return false;
        Pizza outra = (Pizza) obj;
        return Objects.equals(ingredientes, outra.ingredientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientes);
    }
}

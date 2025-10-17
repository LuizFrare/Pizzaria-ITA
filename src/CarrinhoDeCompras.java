import java.util.ArrayList;

public class CarrinhoDeCompras {

    private ArrayList<Pizza> pizzas = new ArrayList<>();
    
    public void adicionarPizza(Pizza p) {
        if (p != null && !p.getIngrediente().isEmpty()) {
            pizzas.add(p);
        }
    }

    public void removerPizza(Pizza p) {
        pizzas.remove(p);
    }

    public int getQuantidadePizzas() {
        return pizzas.size();
    }

    public double getPrecoFinal() {
        double total = 0;
        for (Pizza p : pizzas) {
            total += p.getPreco();
        }
        return total;
    }

    public void limparCarrinho() {
        pizzas.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Carrinho de Compras:\n");
        for (Pizza p : pizzas) {
            sb.append("- ").append(p).append("\n");
        }
        sb.append("Total: R$ ").append(String.format("%.2f", getPrecoFinal()));
        return sb.toString();
    }
}

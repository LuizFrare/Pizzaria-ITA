import java.util.Scanner;

public class MenuInterativo {

    private static CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean rodando = true;

        System.out.println("🍕 Bem-vindo à Pizzaria Java! 🍕\n");

        while (rodando) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Montar nova pizza");
            System.out.println("2. Ver carrinho");
            System.out.println("3. Ver ingredientes utilizados");
            System.out.println("4. Finalizar pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    montarPizza();
                    break;
                case "2":
                    mostrarCarrinho();
                    break;
                case "3":
                    mostrarIngredientes();
                    break;
                case "4":
                    finalizarPedido();
                    break;
                case "0":
                    rodando = false;
                    System.out.println("👋 Saindo da pizzaria... Até logo!");
                    break;
                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }
        }

        sc.close();
    }

    private static void montarPizza() {
        Pizza pizza = new Pizza();
        System.out.println("\n🍕 Criando nova pizza!");
        while (true) {
            System.out.print("Digite um ingrediente (ou 'fim' para terminar): ");
            String ingrediente = sc.nextLine().trim();

            if (ingrediente.equalsIgnoreCase("fim")) break;

            pizza.adicionaIngrediente(ingrediente);
            System.out.println("✅ Ingrediente adicionado!");
        }

        if (pizza.getIngrediente().isEmpty()) {
            System.out.println("⚠️ Pizza sem ingredientes não foi adicionada ao carrinho.");
        } else {
            carrinho.adicionarPizza(pizza);
            System.out.println("✅ Pizza adicionada ao carrinho! Preço: R$ " + pizza.getPreco());
        }
    }

    private static void mostrarCarrinho() {
        if (carrinho.getQuantidadePizzas() == 0) {
            System.out.println("\n🛒 Carrinho vazio!");
        } else {
            System.out.println("\n🛒 Seu carrinho:");
            System.out.println(carrinho);
        }
    }

    private static void mostrarIngredientes() {
        System.out.println("\n📋 Ingredientes utilizados até agora:");
        if (Pizza.getListaIngredientes().isEmpty()) {
            System.out.println("(Nenhum ingrediente registrado)");
            return;
        }

        for (var entry : Pizza.getListaIngredientes().entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " vez(es)");
        }

        System.out.println("Total de ingredientes usados: " + Pizza.getIngredientesTotais());
    }

    private static void finalizarPedido() {
        if (carrinho.getQuantidadePizzas() == 0) {
            System.out.println("\n⚠️ Você não tem pizzas no carrinho!");
            return;
        }

        System.out.println("\n💰 Valor total do pedido: R$ " + String.format("%.2f", carrinho.getPrecoFinal()));
        System.out.println("🎉 Pedido finalizado! Obrigado por comprar na Pizzaria Java!");

        carrinho.limparCarrinho();
        Pizza.resetarEstatisticas();
    }
}

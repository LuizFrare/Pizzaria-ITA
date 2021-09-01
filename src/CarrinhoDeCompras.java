	import java.util.ArrayList;
public class CarrinhoDeCompras {			
	public ArrayList <Pizza> pizzas = new ArrayList <Pizza>();
	public double precoFinal =0;
			 
		public void adicionarPizza(Pizza p)
		 {
			if (p.getIngrediente().isEmpty()){}
			 else
			  pizzas.add(p);
			 	 }

				
		public int pizzasTotais()
		 {
			return pizzas.size();
				}
				
		public double getprecoFinal()
		 {
			for(int i=0; i< pizzas.size(); i++)
				{
					precoFinal += pizzas.get(i).getPreco();	
					 }
		return precoFinal;
				}

		}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pizza {
		public static int ingredientesTotais=0;
		private double preco;
		private ArrayList <String> ingrediente = new ArrayList <String>();
		public static Map <String, Integer> ingredientesGastos = new HashMap <String, Integer>(); 

public ArrayList<String> getIngrediente()
{
	return ingrediente;
}

public static Map<String, Integer>  getListaIngredientes()
{
	return   ingredientesGastos;
}

public void adicionaIngrediente (String ingrediente)
{
	this.ingrediente.add(ingrediente);
	contarIngrediente(ingrediente);
}

public double getPreco ()
{
	if (ingrediente.size() <= 2)
	{
		preco = 30;
	}
	if (ingrediente.size() >= 3 && ingrediente.size() <=5)
	{
		preco = 35;
	}
	if (ingrediente.size() > 5)
	{
		preco = 42;
	}
return preco;
}

public static void contarIngrediente(String ingrediente)
{
	if (ingredientesGastos.containsKey(ingrediente))
	{
		int value = ingredientesGastos.get(ingrediente);
		ingredientesGastos.put(ingrediente, value+1);	
		}
	else
	{
		ingredientesGastos.put(ingrediente, 1);
	}
	ingredientesTotais++;
			 
}
}
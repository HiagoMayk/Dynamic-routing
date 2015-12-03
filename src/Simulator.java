import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Simulator {
	public static void main(String args[]) 
	{		
		  ArrayList<Router> router = new ArrayList<Router>();
		  Entrada entrada = new Entrada();
		  System.out.println("Digite o grafo de entrada:");
		  Graph grafo = entrada.lerGrafo(router);
		  int size = grafo.getVertexes().size();
		  grafo.toString();
  
		  for (int i = 0; i < grafo.getVertexes().size(); i++)
		  {
				router.get(i).setGraph(grafo);
				router.get(i).execute(grafo.getVertexes().get(i));
				router.get(i).updateRoutingTable();
				router.get(i).printRoutingTable();
		  }
		  
		  while(true)
		  {
			  grafo = entrada.lerInterrupcao(grafo);
			  
			  if(size != grafo.getVertexes().size())
			  {
				  size = grafo.getVertexes().size();
				  System.out.println("Sim");
				  for (int i = 0; i < grafo.getVertexes().size(); i++)
				  {
						router.get(i).setGraph(grafo);
						router.get(i).execute(grafo.getVertexes().get(i));
						router.get(i).updateRoutingTable();
						router.get(i).printRoutingTable();
				  }
			  }
			  System.out.println("Não");
			  
		  }	
	}
}

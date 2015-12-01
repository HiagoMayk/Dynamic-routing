import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Simulator {
	public static void main(String args[]) 
	{
/*		  boolean flag = true;
		  int qtdVertex = 11;
		  List<Vertex> nodes = new ArrayList<Vertex>();
		  List<Edge> edges =new ArrayList<Edge>();
		  Verificator verificator;
		  
		  ArrayList<Router> router = new ArrayList<Router>();
		  
		  for (int i = 0; i < qtdVertex; i++)
		  {
			  Vertex location = new Vertex( i, "Node_" + i);
		    	nodes.add(location);
		    	router.add(new Router(location));
		  }
		  
		  // Lets check from location Loc_1 to Loc_10
		  Graph graph = new Graph(nodes);
		  graph.setBothEdges("Edge_0",nodes.get(0), nodes.get(1), 85);
		  graph.setBothEdges("Edge_1",nodes.get(0), nodes.get(2), 217);
		  graph.setBothEdges("Edge_2",nodes.get(0), nodes.get(4), 173);
		  graph.setBothEdges("Edge_3",nodes.get(2), nodes.get(6), 186);
		  graph.setBothEdges("Edge_4",nodes.get(2), nodes.get(7), 103);
		  graph.setBothEdges("Edge_5",nodes.get(3), nodes.get(7), 183);
		  graph.setBothEdges("Edge_6",nodes.get(5), nodes.get(8), 250);
		  graph.setBothEdges("Edge_7",nodes.get(8), nodes.get(9), 84);
		  graph.setBothEdges("Edge_9",nodes.get(4), nodes.get(9), 502);
		  graph.setBothEdges("Edge_8",nodes.get(7), nodes.get(9), 167);
		  graph.setBothEdges("Edge_10",nodes.get(9), nodes.get(10), 40);
		  graph.setBothEdges("Edge_11",nodes.get(1), nodes.get(10), 600);
		  
		  for(int i = 0; i < qtdVertex; i++)
		  {
			  System.out.println("------------------------------------");
			  router.get(i).setGraph(graph);
			  router.get(i).execute(nodes.get(i));
			  router.get(i).updateRoutingTable();
			  router.get(i).printRoutingTable();
		  }
*/		
			
			
		  ArrayList<Router> router = new ArrayList<Router>();
		  Entrada entrada = new Entrada();
		  Graph grafo = entrada.lerGrafo(router);
		  grafo.toString();
		  
		  Thread t = new Thread(new Verificator(router,grafo));
		  t.start();
		  
		  while(true){
			  grafo = entrada.lerInterrupcao(grafo);
			  Thread.currentThread().notifyAll();
		  }	
	}
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Entrada {
	
	 Scanner sc = new Scanner(System.in); 
	
	public Graph lerGrafo(){
		
		List<Vertex> nodes = new ArrayList<Vertex>();
		List<Edge> edges =  new ArrayList<Edge>();
		int quantVertices = sc.nextInt();
		
		 for (int i = 0; i < quantVertices; i++) //começa do 0
		  {
			  Vertex location = new Vertex("Node_" + i, "Node_" + i);
		    	nodes.add(location);
		  }
		 
		 int quantAresta = sc.nextInt();
		 
		 for (int j = 0; j < quantAresta; j ++){
			 
			 int no1 = sc.nextInt();
			 int no2 = sc.nextInt();
			 int custo = sc.nextInt();
			 edges.add(new Edge("Edge_0",nodes.get(no1), nodes.get(no2), custo));
			 
		 }
		 
		  Graph graph = new Graph(nodes, edges);
		
		return graph;
		
	}
	
	
	
	public Graph lerInterupcao(Graph grafo){
		
		
		int opcao = sc.nextInt();
		
		switch (opcao){
		
			case 1: 
				int numVertice = sc.nextInt();
				//remover vertice no grafo
				break;
				
			case 2:
				int no1 = sc.nextInt();
				int no2 = sc.nextInt();
				//remover aresta no grafo
				break;
				
			case 3:
				System.exit(0);
				
			default:
				System.out.println("Opção inválida!");
		}
		
		return grafo;
		
	}
	
}

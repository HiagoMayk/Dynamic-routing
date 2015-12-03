import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Entrada
{
	Scanner sc = new Scanner(System.in);

	public Graph lerGrafo(ArrayList<Router> router) 
	{
		List<Vertex> nodes = new ArrayList<Vertex>();
		List<Edge> edges = new ArrayList<Edge>();
		int quantVertices = sc.nextInt();
		
		// Inicializa vértices
		for (int i = 0; i < quantVertices; i++) // begin in 0
		{
			Vertex location = new Vertex(i, "Node_" + i);
			nodes.add(location);
			router.add(new Router(location));		
		}

		int quantAresta = sc.nextInt();
		
		// Recebe o grafo do terminal
		for (int j = 0; j < quantAresta; j++) 
		{
			int no1 = sc.nextInt();
			int no2 = sc.nextInt();
			int custo = sc.nextInt(); //FALTA DIVIDIR POR VALOR REFERENCIA!!!!!
			edges.add(new Edge(("Edge_"+j), nodes.get(no1), nodes.get(no2), custo));
		}

		Graph graph = new Graph(nodes);
		// Adiciona arestas em ambas as direções
		for(Edge e : edges)
		{
			graph.setBothEdges(e.getId(), e.getSource(), e.getDestination(), e.getWeight());
		}
		
		System.out.println("Grafo criado!");
		return graph;
	}

	public Graph lerInterrupcao(ArrayList<Router> router, Graph grafo) 
	{
		System.out.println("");
		System.out.println("----------------------------------------------------");
		System.out.println("    MENU    ");
		System.out.println("0   -------   Sair");
		System.out.println("1   -------   Remover vértice");
		System.out.println("2   -------   Remover aresta");
		System.out.println("3   -------   Inserir vértice");
		System.out.println("4   -------   Inserir aresta");
			
		System.out.println("Lendo instrução:");
		int opcao = sc.nextInt();
		List<Vertex> nodes = grafo.getVertexes();
		ArrayList<Edge> aux = new ArrayList<Edge>();

		switch (opcao) 
		{
			case 1:
				
				if(grafo.getVertexes().isEmpty())
				{
					System.out.println("Grafo Vazio!");
					
				}
				else
				{
					System.out.println("Digite o indice do vertice: ");
					int indexVertice = sc.nextInt();
					/*
					 * REMOVE O VÉRTICE
					 */
					boolean flag = true;
					while (flag) 
					{
						try 
						{
							Vertex v = grafo.getVertexes().get(indexVertice);
							List<Edge> edges = grafo.getEdges();
							// Remove arestas referentes a o vertice a ser removido
							
							for (int i = 0; i < edges.size(); i++) 
							{
								if (edges.get(i).getSource().equals(v) || edges.get(i).getSource().equals(v))
								{
									edges.remove(i);
								}
							}
							
							grafo.getVertexes().remove(v);
							grafo.setEdges(edges);
							
							// Remove o roteador referente ao vertice a ser removido
							for(Router r : router)
							{
								if(r.getId().equals(v))
								{
									router.remove(r);
									break;
								}
							}
							
							flag = false;
						} 
						catch (Exception e)
						{
							// TODO: handle exception
							System.out.println(
									"Número inválido! Insira um número entre 0  e " + (grafo.getVertexes().size() - 1));
						}
					}
				}
				
				break;
	
			case 2:
				System.out.println("Digite o indice do primeiro vértice: ");
				int no1 = sc.nextInt(); // Source
	
				System.out.println("Digite o indice do segundo vértice: ");
				int no2 = sc.nextInt(); // Target
				// remover aresta no grafo
				boolean flag1 = true;
				while (flag1)
				{
					try 
					{
						Vertex v1 = nodes.get(no1);
						Vertex v2 = nodes.get(no2);
												
						boolean r = false;
						for (int i = 0; i < grafo.getEdges().size(); i++)
						{
							if ((grafo.getEdges().get(i).getSource().equals(v1) && grafo.getEdges().get(i).getDestination().equals(v2))
									|| (grafo.getEdges().get(i).getSource().equals(v2) && grafo.getEdges().get(i).getDestination().equals(v1))) {
								grafo.getEdges().remove(i);
								r = true;
							}
						}
						
						if(!r)
						{
							System.out.println("Aresta não existe!");
						}
						flag1 = false;
					} 
					catch (Exception e) 
					{
						// TODO: handle exception
						System.out.println(
								"Número inválido! Insira dois número entre 0  e " + (grafo.getVertexes().size() - 1));
					}
				}
				break;
			case 3:
				System.out.println("Digite o ID do novo vértice: ");
				int nodeId = sc.nextInt(); // Source

				boolean flag3 = true;
				while (flag3)
				{	
					boolean r = false;
					for (Vertex ver : nodes) 
					{
						if(ver.getId() == nodeId )
						{
							System.out.println("Id já existe!");
							r = true;
						}
					}
					
					if(!r)
					{
						Vertex newVertex = new Vertex(nodeId, ("Node_" + nodeId));
						nodes.add(newVertex);
						router.add(new Router(newVertex));					
					}
					
					grafo.setVertexes(nodes);
					flag3 = false;
				}
				break;
			case 0:
				System.exit(0);
				return null;
	
			default:
				System.out.println("Opção inválida!");
			}		
			return grafo;

	}

}

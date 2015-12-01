import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Entrada {

	Scanner sc = new Scanner(System.in);

	public Graph lerGrafo(ArrayList<Router> router) {

		List<Vertex> nodes = new ArrayList<Vertex>();
		List<Edge> edges = new ArrayList<Edge>();
		int quantVertices = sc.nextInt();
				
		for (int i = 0; i < quantVertices; i++) // começa do 0
		{
			Vertex location = new Vertex(i, "Node_" + i);
			nodes.add(location);
			router.add(new Router(location));
			
		}

		int quantAresta = sc.nextInt();

		for (int j = 0; j < quantAresta; j++) {

			int no1 = sc.nextInt();
			int no2 = sc.nextInt();
			int custo = sc.nextInt(); //FALTA DIVIDIR POR VALOR REFERENCIA!!!!!
			edges.add(new Edge("Edge_0", nodes.get(no1), nodes.get(no2), custo));

		}

		Graph graph = new Graph(nodes, edges);
		System.out.println("grafo criado");
		return graph;

	}

	public Graph lerInterrupcao(Graph grafo) {

		System.out.println("Lendo interrupção:");
		int opcao = sc.nextInt();
		List<Vertex> nodes = grafo.getVertexes();
		ArrayList<Edge> aux = new ArrayList<Edge>();

		switch (opcao) {

		case 1:
			System.out.println("Digite o numero do vertice: ");
			int numVertice = sc.nextInt();
			/*
			 * REMOVE O VÉRTICE
			 */
			boolean flag = true;
			while (flag) {
				try {
					Vertex v = grafo.getVertexes().get(numVertice);
					List<Edge> edges = grafo.getEdges();
					for (int i = 0; i < edges.size(); i++) {
						if (edges.get(i).getDestination().equals(v) || edges.get(i).getSource().equals(v)) {
							edges.remove(i);
						}
					}
					grafo.getVertexes().remove(v);
					grafo.setEdges(edges);
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(
							"Número inválido! Insira um número entre 0  e " + (grafo.getVertexes().size() - 1));
				}

			}

			break;

		case 2:
			System.out.println("Digite o numero do vértice origem: ");
			int no1 = sc.nextInt(); // Source

			System.out.println("Digite o número do vértice de destino: ");
			int no2 = sc.nextInt(); // Target
			// remover aresta no grafo
			boolean flag1 = true;
			while (flag1){
				try {
					Vertex v1 = nodes.get(no1);
					Vertex v2 = nodes.get(no2);
					List<Edge> ed = grafo.getEdges();
					
					for (int i = 0; i < ed.size(); i++) {
						if ((ed.get(i).getSource().equals(v1) && ed.get(i).getDestination().equals(v2))
								|| (ed.get(i).getSource().equals(v2) && ed.get(i).getDestination().equals(v1))) {
							ed.remove(i);
						}
					}
					grafo.setEdges(ed);
					flag1 = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(
							"Número inválido! Insira dois número entre 0  e " + (grafo.getVertexes().size() - 1));
				}
			}
			break;
		case 3:
			System.exit(0);
			return null;

		default:
			System.out.println("Opção inválida!");
		}		
		return grafo;

	}

}

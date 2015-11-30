
public class Router 
{
	private RoutingTable routingTable;
	private Graph lsdb;
	private String id;
	
	public Router(String id, Graph lsdb)
	{
		routingTable = new RoutingTable();
		this.lsdb = new Graph();
		this.id = id;
	}
	
	/*
	 * Run the algorithm to update routingTable
	 */
	public void updateTable()
	{
		// Implementation
	}
	
	/*
	 * Recaculates the cost in for all router applying the dijkstra algorithm
	 */
	public void costsRecalculatesDijktra()
	{
		
	}
	
	/*
	 * Recaculates the cost in for all router applying the Bellman-Ford algorithm
	 */
	public void costsRecalculatesBellmanFord()
	{
		
	}
	
	/*
    // Algoritmo de Dijkstra
    public List<Vertice> encontrarMenorCaminhoDijkstra(Vertice v1, Vertice v2) {

            // No início, todos os vértices do grafo não foram visitados
            verticesNaoVisitados = this.la.size();

            // O primeiro nó a ser visitado é o da origem do caminho
            atual = v1;
            // Adiciona o primeiro nó no corte
            fronteira.add(atual);
            // Adiciona a origem na lista do menor caminho
            menorCaminho.add(atual);

            // Colocando a distancias iniciais
            for (int i = 0; i < this.la.size(); i++) {

                    // Nó atual tem distância zero, e todos os outros, 9999(infinita)
                    if (this.la.containsValue(atual.getDescricao())) {
                            
                     ((Vertice) this.la.get(i)).getDescricao();
                            //this.vertices.get(i).setDistancia(0);

                    } else {

                            ((Vertice) this.la.get(i)).setDistancia(9999);

                    }
            }

            // O algoritmo continua até que todos os vértices sejam visitados
            while (verticesNaoVisitados != 0) {

                    // Toma-se sempre o vértice com menor distância, que é o primeiro da
                    // lista do corte
                    atual = this.fronteira.get(0);
                    /*
                     * Para cada vizinho (cada aresta), calcula-se a sua possível
                     * distância, somando a distância do vértice atual com a da aresta
                     * correspondente. Se essa distância for menor que a distância do
                     * vizinho, esta é atualizada.
                     
                    for (int i = 0; i < la.size(); i++) {

                            vizinho = atual.getArestas().get(i).getDestino();
                            if (!vizinho.verificarVisita()) {

                                    vizinho.setPai(atual);

                                    // Comparando a distância do vizinho com a possível
                                    // distância
                                    if (vizinho.getDistancia() > (atual.getDistancia() + atual
                                                    .getArestas().get(i).getPeso())) {

                                            vizinho.setDistancia(atual.getDistancia()
                                                            + atual.getArestas().get(i).getPeso());

                                            /*
                                             * Se o vizinho é o vértice procurado, e foi feita uma
                                             * mudança na distância, a lista com o menor caminho
                                             * anterior é apagada, pois existe um caminho menor
                                             * ainda. Cria-se a nova lista do menor caminho, com os
                                             * vértices pais, até o vértice origem.
                                             
                                            if (vizinho == v2) {
                                                    menorCaminho.clear();
                                                    verticeCaminho = vizinho;
                                                    menorCaminho.add(vizinho);
                                                    while (verticeCaminho.getPai() != null) {

                                                            menorCaminho.add(verticeCaminho.getPai());
                                                            verticeCaminho = verticeCaminho.getPai();

                                                    }
                                                    // Ordena a lista do menor caminho, para que ele
                                                    // seja exibido da origem ao destino.
                                                    Collections.sort(menorCaminho);

                                            }
                                    }
                                    // Cada vizinho, depois de visitado, é adicionado ao corte
                                    this.fronteira.add(vizinho);
                            }

                    }
                    // Marca o vértice atual como visitado e o retira do corte
                    atual.visitar();
                    verticesNaoVisitados--;
                    this.fronteira.remove(atual);
                    /*
                     * Ordena a lista do corte, para que o vértice com menor distância
                     * fique na primeira posição
                     

                    Collections.sort(fronteira);

            }

            return menorCaminho;
    }
*/
}

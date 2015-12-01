import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private List<Vertex> vertexes;
	private List<Edge> edges;

	public void setVertexes(List<Vertex> vertexes) {
		this.vertexes = vertexes;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public Graph(List<Vertex> vertexes, List<Edge> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public Graph(List<Vertex> vertexes) {
		this.vertexes = vertexes;
		this.edges = new ArrayList<Edge>();
	}

	public List<Vertex> getVertexes() {
		return vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setBothEdges(String id, Vertex source, Vertex destination, int weight) {
		Edge newEdge = new Edge(id, source, destination, weight);
		edges.add(newEdge);

		newEdge = new Edge(id, destination, source, weight);
		edges.add(newEdge);
	}

}

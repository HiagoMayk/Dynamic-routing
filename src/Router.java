import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Router 
{
	private List<Vertex> nodes;
	private List<Edge> edges;
	private Set<Vertex> settledNodes;
	private Set<Vertex> unSettledNodes;
	private Map<Vertex, Vertex> predecessors;
	private Map<Vertex, Integer> distance;
	
	private RoutingTable routingTable;
	private Boolean flag;
	private Vertex id;
	
	public Router(Vertex id, Graph graph)
	{
	    this.nodes = new ArrayList<Vertex>(graph.getVertexes());
	    this.edges = new ArrayList<Edge>(graph.getEdges());
	    this.routingTable = new RoutingTable();
	    this.id = id;
	}
	
	public Router(Vertex id)
	{
		this.nodes = new ArrayList<Vertex>();
	    this.edges = new ArrayList<Edge>();
	    this.routingTable = new RoutingTable();
	    this.id = id;
	}
	
	public void setGraph(Graph graph)
	{
		this.nodes = new ArrayList<Vertex>(graph.getVertexes());
	    this.edges = new ArrayList<Edge>(graph.getEdges());
	}
	
	public void execute(Vertex source) 
	{
	    settledNodes = new HashSet<Vertex>();
	    unSettledNodes = new HashSet<Vertex>();
	    distance = new HashMap<Vertex, Integer>();
	    predecessors = new HashMap<Vertex, Vertex>();
	    distance.put(source, 0);
	    unSettledNodes.add(source);
	    while (unSettledNodes.size() > 0) 
	    {
	    	Vertex node = getMinimum(unSettledNodes);
	    	settledNodes.add(node);
	    	unSettledNodes.remove(node);
	    	findMinimalDistances(node);
	    }
	}

	private void findMinimalDistances(Vertex node) 
	{
	    List<Vertex> adjacentNodes = getNeighbors(node);
	    for (Vertex target : adjacentNodes) 
	    {
	    	if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target))
	    	{
	    		distance.put(target, getShortestDistance(node) + getDistance(node, target));
	    		predecessors.put(target, node);
	    		unSettledNodes.add(target);
	    	}
	    }
	}

	private int getDistance(Vertex node, Vertex target) 
	{
	    for (Edge edge : edges) 
	    {
	    	if (edge.getSource().equals(node) && edge.getDestination().equals(target)) 
	    	{
	    		return edge.getWeight();
	    	}
	    }
	    throw new RuntimeException("Should not happen");
	}

	private List<Vertex> getNeighbors(Vertex node) 
	{
	    List<Vertex> neighbors = new ArrayList<Vertex>();
	    for (Edge edge : edges) 
	    {
	    	if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) 
	    	{
	    		neighbors.add(edge.getDestination());
	    	}
	    }
	    return neighbors;
	}

	private Vertex getMinimum(Set<Vertex> vertexes) 
	{
	    Vertex minimum = null;
	    for (Vertex vertex : vertexes) 
	    {
	    	if (minimum == null) 
	    	{
	    		minimum = vertex;
	    	} 
	    	else 
	    	{
	    		if (getShortestDistance(vertex) < getShortestDistance(minimum)) 
	    		{
	    			minimum = vertex;
	    		}
	    	}
	    }
	    return minimum;
	}

	private boolean isSettled(Vertex vertex) 
	{
	    return settledNodes.contains(vertex);
	}

	private int getShortestDistance(Vertex destination) 
	{
	    Integer d = distance.get(destination);
	    if (d == null)
	    {
	    	return Integer.MAX_VALUE;
	    } 
	    else 
	    {
	    	return d;
	    }
	}

	public LinkedList<Vertex> getPath(Vertex target) 
	{
	    LinkedList<Vertex> path = new LinkedList<Vertex>();
	    Vertex step = target;
	    // check if a path exists
	    if (predecessors.get(step) == null) 
	    {
	      return null;
	    }
	    path.add(step);
	    while (predecessors.get(step) != null) 
	    {
	      step = predecessors.get(step);
	      path.add(step);
	    }
	    // Put it into the correct order
	    Collections.reverse(path);
	    return path;
	}
	
	public void updateRoutingTable()
	{
		for(Vertex n : nodes)
		{
			if(getPath(n) != null) // If error, use it -> if(getPath(n) != null && !(getPath(n).getFirst().equals(getPath(n).getLast())))
			{
				routingTable.setRouter(n, distance.get(n), getPath(n).get(1));
			}
		}
	}
	 
	public void printRoutingTable()
	{
		System.out.println("");
		System.out.println("Index  -------- " + id.getName() + " --------");
		int i = 0; 
		for(Vertex v : nodes)
		{
			System.out.println(i + "     " + v.getName() + ": Next - " + routingTable.getNextTable().get(v) + " | cost - " + routingTable.getCostTable().get(v));
			i++;
		}
	}
}

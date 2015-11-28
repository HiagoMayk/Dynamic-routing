
public class Router 
{
	private RoutingTable routingTable;
	private Graph lsdb;
	private String id;
	
	public Router(String id)
	{
		routingTable = new RoutingTable();
		lsdb = new Graph();
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
}

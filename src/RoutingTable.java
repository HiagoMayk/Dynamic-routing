import java.util.HashMap;
import java.util.Map;

public class RoutingTable
{
	private Map<Vertex, Integer> costTable;
	private Map<Vertex, Vertex> nextTable;
	
	public RoutingTable()
	{
		costTable = new HashMap<Vertex, Integer>();
		nextTable = new HashMap<Vertex, Vertex>();
	}
	
	public void setRouter(Vertex target, int cost, Vertex nextVertex)
	{
		costTable.put(target, cost);
		nextTable.put(target, nextVertex);
	}
	
	public float getCustRouter(Vertex target)
	{
		return costTable.get(target);
	}
	
	public Map<Vertex, Integer> getCostTable()
	{
		return costTable;
	}
	
	public Map<Vertex, Vertex> getNextTable()
	{
		return nextTable;
	}
}

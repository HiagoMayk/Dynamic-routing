import java.util.HashMap;
import java.util.Map;

public class RoutingTable 
{
	private Map<String, Float> table; 
	
	public RoutingTable()
	{
		table = new HashMap<String, Float>();
	}
	
	public void setRouter(String id, float cost)
	{
		table.put(id, cost);
	}
	
	public float getCustRouter(String id)
	{
		return table.get(id);
	}
	
	public Map<String, Float> getTable()
	{
		return table;
	}
}

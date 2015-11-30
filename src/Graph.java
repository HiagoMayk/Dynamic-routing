import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph 
{
	private ArrayList<Vertex> vertex = null;
	private Map<Vertex, Map<Vertex, Float>> listAdj  = new HashMap<Vertex, Map<Vertex, Float>>();
	
	public Graph(ArrayList vertex)
	{
		this.vertex = vertex;
		this.init();
	}
	
	public Graph()
	{
		if(this.vertex != null)
			this.init();
	}
	
	public void init()
	{	        
		for(int i = 0; i < this.vertex.size(); i++){
			this.listAdj.put(this.vertex.get(i), new HashMap<Vertex, Float>());
		}
	}
	
	/*
	 * Conecta dois vértices no grafo;
	 */
	public void addEdge(Vertex v1, Vertex v2, float cost)// throws Exception
	{
		if(this.vertex.contains(v1) && this.vertex.contains(v2))
		{
			this.listAdj.get(v1).put(v2, cost);
			this.listAdj.get(v2).put(v1, cost);
			v1.increaseDegreeOut();
			v2.increaseDegreeOut();
			v2.increaseDegreeIn();
			v1.increaseDegreeIn();
			
		}		
		else
		{
			System.out.println("Não pode conectar " + v1.getId() + " e " + v1.getId() + ".");
			//throw new Exception("Erro ao conectar dois vértices!  Classe: " + this.getClass().getName());
		}
	}
	
	/*
	 * Desconecta dois vértices no grafo;
	 */
	public void removeEdge(Vertex v1, Vertex v2) throws Exception
	{
		if(this.vertex.contains(v1) && this.vertex.contains(v2))
		{
			if(!this.listAdj.get(v1).isEmpty() && !this.listAdj.get(v2).isEmpty())
			{
				this.listAdj.get(v1).remove(v2);
				this.listAdj.get(v2).remove(v1);
			}
			else
			{
				throw new Exception("Vértice 'source' não possui adjacentes! Classe: " + this.getClass().getName());
			}		
		}
		else
		{
			throw new Exception("Erro ao remover a aresta! Classe: "+ this.getClass().getName());
		}
	}
	
	/*
	 * Verifica se existe uma aresta entre dado dois vértices
	 *	Retorna true caso exista, false caso contrário
	 */
	public boolean isConnected(Vertex v1, Vertex v2) throws Exception
	{
		if(this.vertex.contains(v1) && this.vertex.contains(v2))
		{
			if(this.listAdj.get(v1).containsKey(v2) == true)
			{
				return true;
			}
			return false;
		}
		else
		{
			throw new Exception("Nos nao existem!!!");			
		}
	}
	
	/*
	 * Add um nó
	 */
	public void addNode(Vertex v)
	{
		this.vertex.add(v);
	}
	
	/*
	 * Exclui um nó
	 */
	public void delNode(Vertex v) throws Exception
	{
		if(this.vertex.contains(v))
		{
			this.vertex.remove(v);
		}
		else
		{
			throw new Exception("Nodo nao existe!!\n");
		}
	}
	
	public void delNode(int index) throws Exception
	{
		if(this.vertex.contains(this.vertex.get(index)))
		{
			this.vertex.remove(index);
		}
		else
		{
			throw new Exception("Nodo nao existe!!\n");
		}
	}
	
	/*
	 * 
	 * Getters e Setters
	 */
	public Map<Vertex, Map<Vertex, Float>> getListAdj()
	{
		return this.listAdj;
	}
	
	public ArrayList<Vertex> getNodes()
	{
		return this.vertex;
	}
	
	public void setVertex(ArrayList<Vertex> v)
	{
		this.vertex = v;
	}
	
	public void setListAdj(Map<Vertex, Map<Vertex, Float>> l)
	{
		this.listAdj = l;
	}
	
	/*
	 * toString method
	 * 
	 */
	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		String out = " ";
		for(int i = 0; i < this.vertex.size(); i++)
		{
			out += "--- " + this.vertex.get(i).getNome() + "--- \n";
			for(Vertex v : this.listAdj.get(this.vertex.get(i)).keySet())
			{
					out += v.getNome() + " - " + this.listAdj.get(this.vertex.get(i)).get(v) + "\n";
			}
			out += "\n";
		}
		return out;
	}
	
	public static void main(String args[]) 
	{
		ArrayList<Vertex> vertex = new ArrayList<Vertex>();
		
		vertex.add(new Vertex(0));
		vertex.add(new Vertex(1));
		vertex.add(new Vertex(2));
		vertex.add(new Vertex(3));
		vertex.add(new Vertex(4));
		
        Graph g = new Graph(vertex);
 
        g.addEdge(g.getNodes().get(0), g.getNodes().get(1), 4);
        g.addEdge(g.getNodes().get(0), g.getNodes().get(3), 6);
        

        System.out.println(g.toString());
	}
}

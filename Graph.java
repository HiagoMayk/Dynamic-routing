import java.util.ArrayList;



public class Graph {
	private ArrayList<Vertex> vertex = null;
	private ArrayList<ArrayList<Vertex>> listAdj  = new ArrayList<ArrayList<Vertex>>();
	
	
	public Graph(ArrayList vertex){
		this.vertex = vertex;
		this.init();
	}
	
	public Graph(){
		if(this.vertex != null)
			this.init();
	}
	
	public void init(){			
		for(int i =0; i < this.vertex.size(); i++){
			this.listAdj.add(i, new ArrayList<Vertex>());
		}
	}
	
	/*
	 * Conecta dois vértices no grafo;
	 */
	public void addEdge(Vertex v1, Vertex v2) throws Exception{
		if(this.vertex.contains(v1) && this.vertex.contains(v2)){
			this.listAdj.get(this.vertex.indexOf(v1)).add(v2);
			v1.increaseDegreeOut();
			v2.increaseDegreeIn();
		}		
		else
			throw new Exception("Erro ao conectar dois vértices!  Classe: " + this.getClass().getName());
	}
	
	/*
	 * Desconecta dois vértices no grafo;
	 */
	
	public void removeEdge(Vertex v1, Vertex v2) throws Exception{
		if(this.vertex.contains(v1) && this.vertex.contains(v2)){
			if(!this.listAdj.get(this.vertex.indexOf(v1)).isEmpty())
				this.listAdj.get(this.vertex.indexOf(v1)).remove(v2);
			else
				throw new Exception("Vértice 'source' não possui adjacentes! Classe: " + this.getClass().getName());
			
		}
		else
			throw new Exception("Erro ao remover a aresta! Classe: "+ this.getClass().getName());		
	}
	/*
	 * Verifica se existe uma aresta entre dado dois vértices
	 *	Retorna true caso exista, false caso contrário
	 */
	public boolean isConnected(Vertex v1, Vertex v2) throws Exception{
		if(this.vertex.contains(v1) && this.vertex.contains(v2)){
			if(this.listAdj.get(this.vertex.indexOf(v1)).indexOf(v2) != -1){
				return true;
			}
			return false;			
		}
		else{
			throw new Exception("Nos nao existem!!!");			
		}
			
	}
	
	/*
	 * Add um nó
	 */
	public void addNode(Vertex v){
		this.vertex.add(v);
	}
	/*
	 * Exclui um nó
	 */
	
	public void delNode(Vertex v) throws Exception{
		if(this.vertex.contains(v)){
			this.vertex.remove(v.getId());
		}
		else
			throw new Exception("Nodo nao existe!!\n");
	}
	
	public void delNode(int index) throws Exception{
		if(this.vertex.contains(this.vertex.get(index))){
			this.vertex.remove(index);
		}
		else
			throw new Exception("Nodo nao existe!!\n");
	}
	
	/*
	 * 
	 * Getters e Setters
	 */
	public ArrayList<ArrayList<Vertex>> getListAdj(){
		return this.listAdj;
	}
	
	public ArrayList<Vertex> getNodes(){
		return this.vertex;
	}
	
	public void setVertex(ArrayList<Vertex> v){
		this.vertex = v;
	}
	
	public void setListAdj(ArrayList<ArrayList<Vertex>> l){
		this.listAdj = l;
	}
	
	/*
	 * toString method
	 * 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out = " ";
		for(int i =0; i < this.vertex.size(); i++){
			out += "--- " + this.vertex.get(i).getNome() + "--- \n";
			for(int j = 0; j < this.listAdj.get(i).size(); j++){
				out += this.listAdj.get(i).get(j).getNome() + "\n";
			}
		}
		
		return out;
	}
	
	
	
	
	
	
}

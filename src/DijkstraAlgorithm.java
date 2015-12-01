import java.util.ArrayList;

public class DijkstraAlgorithm {
	
	private Graph g;
	private ArrayList<ArrayList<Vertex>> listAdj;

	public DijkstraAlgorithm(Graph g){
		this.g = g;
//		this.listAdj = g.getListAdj();
	}	
	
	public void run(Vertex s){
//		s.setDistance(0);
//		int i = 0;
//		
//		while(i < this.listAdj.get(s.getId()).size()){
//			if(this.listAdj.get(s.getId()).get(i).getDistance() > this.g.getNodes().get(s.getId()).
//					getDistance() + this.listAdj.get(s.getId()).get(i).getCost()){
//				this.listAdj.get(s.getId()).get(i).setDistance((double)this.g.getNodes().get(s.getId()).
//						getDistance() + this.listAdj.get(s.getId()).get(i).getCost());
//			}			
//			i+=1;
//		}		
	}	
	
	public void relax(Vertex s, Vertex v){
		
	}
	
	public Graph getGraph() {
		return g;
	}

	public void setGraph(Graph g) {
		this.g = g;
	}
	
	
	
	
	
}

import java.util.ArrayList;
import java.util.List;

public class Verificator implements Runnable {
	private ArrayList<Router> router;
	private Graph graph;
	private List<Vertex> nodes = new ArrayList<Vertex>();

	public Verificator(ArrayList<Router> router, Graph graph) {
		this.router = router;
		this.graph = graph;
		this.nodes = graph.getVertexes();

	}

	public void runUpdate() {
		for (int i = 0; i < router.size(); i++) {
			this.router.get(i).setGraph(this.graph);
			this.router.get(i).execute(this.nodes.get(i));
			this.router.get(i).updateRoutingTable();
			this.router.get(i).printRoutingTable();
		}

		

	}

	@Override
	public void run() {
		while(true){
			try {
				wait();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
			
			System.out.println("Verificator iniciado!");
			this.runUpdate();
		}
	}
}

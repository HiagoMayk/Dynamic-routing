
public class Vertex {
	private String nome;// 'Nome' do roteador
	private int id; //Ip do roteador
	private int degreeOut; //Grau de saída
	private int degreeIn; //Graud de entrada
	private float cost; //Custo do arco adjacente
	private double distance; //Estimativa de distância
	private Vertex parent;  
	
	public Vertex(int id, String nome){
		this.nome = nome;
		this.id = id;
		this.cost = 0;
		this.degreeOut = 0; 
		this.degreeIn = 0;
		this.distance = Double.POSITIVE_INFINITY;
		this.parent = null;
	}
	
	public Vertex(int id){
		this.nome = "Default_"+id;
		this.id = id;
		this.cost = 0;
		this.degreeOut = 0; 
		this.degreeIn = 0;
		this.distance = Double.POSITIVE_INFINITY;
		this.parent = null;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getDistance(){
		return this.distance;
	}
	
	public void setDistance(double d){
		this.distance = d;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setDegreeOut(int d){
		this.degreeOut = d;
	}
	
	public void setDegreeIn(int d){
		this.degreeIn = d;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getDegreeOut(){
		return this.degreeOut;
	}
	
	public int getDegreeIn(){
		return this.degreeIn;
	} 
	
	public void increaseDegreeOut(){
		this.degreeOut += 1;
	}
	
	public void increaseDegreeIn(){
		this.degreeIn += 1;
	}
	
	public void decreaseDegreeOut(){
		if(this.degreeOut -1 >= 0)
			this.degreeOut -= 1;
	}
	
	public void decreaseDegreeIn(){
		if(this.degreeIn -1 >= 0)
			this.degreeIn -= 1;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
}

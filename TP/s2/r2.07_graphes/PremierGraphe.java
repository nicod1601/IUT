import  org.graphstream.graph.implementations.SingleGraph;

public class PremierGraphe {
	public static void main(String args[]) {
		SingleGraph graph = new SingleGraph("Premier Graphe");
		graphique.affichage();
		graph.addNode("a");
		graph.addNode("b");
		graph.addNode("c");
		graph.addEdge("ab","a","b",true);
		graph.addEdge("ac", "a", "c");
	}
}
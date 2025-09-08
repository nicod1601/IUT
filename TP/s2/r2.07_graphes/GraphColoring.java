import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.algorithm.Toolkit;
import java.util.Iterator;

public class GraphColoring {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Graphe");
        
        // Ajout des nœuds
        char[] nodes = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (char node : nodes) {
            graph.addNode(String.valueOf(node)).setAttribute("ui.label", node);
        }
        
        // Ajout des arêtes
        graph.addEdge("AB", "A", "B");
        graph.addEdge("AC", "A", "C");
        graph.addEdge("BD", "B", "D");
        graph.addEdge("BE", "B", "E");
        graph.addEdge("CF", "C", "F");
        graph.addEdge("EF", "E", "F");
        
        // Choisir un sommet aléatoire
        Node randomNode = Toolkit.randomNode(graph);
        randomNode.setAttribute("ui.style", "fill-color: red;");
        
        // Colorier ses voisins
        Iterator<Node> neighbors = randomNode.getNeighborNodeIterator();
        while (neighbors.hasNext()) {
            Node neighbor = neighbors.next();
            neighbor.setAttribute("ui.style", "fill-color: blue;");
        }
        
        // Affichage du graphe
        graph.display();
    }
}
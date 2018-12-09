package fordFulkerson;
import java.util.ArrayList;

/**
 * This class represents a graph
 * with a list of nodes
 * @author Cameron Moore
 * @version 2018.12.08
 */
public class DiGraph {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    
    /**
     * Instantiates a new DiGraph object
     */
    public DiGraph()
    {
        vertices = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
    }
    
    /**
     * Creates a DiGraph from the given vertices and edge lists
     * @param vertices The list of vertices
     * @param edges The list of edges
     */
    public DiGraph(ArrayList<Vertex> vertices, ArrayList<Edge> edges)
    {
        this.vertices = vertices;
        this.edges = edges;
    }
    
    /**
     * Adds a vertex to the DiGraph
     * @param ver The vertex to add to the DiGraph
     */
    public void addVertex(Vertex ver)
    {
        vertices.add(ver);
    }
    
    /**
     * Adds an edge to the DiGraph
     * @param edge The edge to add
     */
    public void addEdge(Edge edge)
    {
        edges.add(edge);
    }
    
    /**
     * Creates a copy of the current DiGraph
     * @return A copy of the current DiGraph
     */
    public DiGraph copy()
    {
        DiGraph copyGraph = new DiGraph();
        
        for (int i = 0; i < vertices.size(); i++)
        {
            copyGraph.addVertex(vertices.get(i).copy());
        }
        relink(copyGraph);
        return copyGraph;
    }
    
    /**
     * Relinks the vertices in the graph
     * @param copy The graph to relink the vertices in
     */
    private void relink(DiGraph copy)
    {
        for (int i = 0; i < edges.size(); i++)
        {
            Vertex src = null;
            Vertex dest = null;
            Edge curr = edges.get(i);
            for (int j = 0; j < copy.getVertices().size(); j++)
            {
                Vertex currV = copy.getVertices().get(j);
                if (curr.getSrc().getName().equals(currV.getName()))
                {
                    src = currV;
                }
                else if (curr.getDest().getName().equals(currV.getName()))
                {
                    dest = currV;
                }
            }
            Edge copyEdge = src.link(dest, curr.getCapacity(), 
                curr.getWeight(), curr.getValue());
            copy.addEdge(copyEdge);
        }
    }
    
    /**
     * Gets the current list of vertices
     * @return The list of vertices
     */
    public ArrayList<Vertex> getVertices()
    {
        return vertices;
    }
    
    /**
     * Gets the current list of edges
     * @return The list of edges
     */
    public ArrayList<Edge> getEdges()
    {
        return edges;
    }
    
    /**
     * Returns a string representation of the graph
     * @return String representing the graph
     */
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < vertices.size(); i++)
        {
            s.append(vertices.get(i).toString());
        }
        return s.toString();
    }
}

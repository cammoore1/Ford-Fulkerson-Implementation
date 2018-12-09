package fordFulkerson;
import java.util.ArrayList;

/**
 * This class represents a vertex
 * @author Cameron Moore
 * @version 2018.12.08
 */
public class Vertex {
    // A list of the directed edges
    private ArrayList<Edge> edges;
    // The name of the vertex
    private String name;
    
    /**
     * Makes a vertex with the given name
     * @param name The name of the vertex
     */
    public Vertex(String name)
    {
        edges = new ArrayList<Edge>();
        this.name = name;
    }
    
    /**
     * Links this vertex to another vertex with a directed edge
     * @param dest The destination of the flow
     * @param maxWeight The maximum magnitude of the flow
     * @param currWeight The current magnitude of the flow
     * @param currValue The current value of the edge
     */
    public Edge link(Vertex dest, int maxWeight, int currWeight, int currValue)
    {
        if (dest == null || maxWeight < currWeight || currWeight < 0 ||
            maxWeight < 0)
        {
            return null;
        }
        Edge newEdge = new Edge(maxWeight, currWeight, currValue, this, dest);
        edges.add(newEdge);
        return newEdge;
    }
    
    /**
     * Links this vertex to another vertex with a directed edge
     * @param dest The destination of the flow
     * @param maxWeight The maximum magnitude of the flow
     * @param currWeight The current magnitude of the flow
     */
    public Edge link(Vertex dest, int maxWeight, int currWeight)
    {
        if (dest == null || maxWeight < currWeight || currWeight < 0 ||
            maxWeight < 0)
        {
            return null;
        }
        Edge newEdge = new Edge(maxWeight, currWeight, this, dest);
        edges.add(newEdge);
        return newEdge;
    }
    
    /**
     * Returns the name of the vertex
     * @return The name of the vertex
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Makes a string representation of the vertex
     * and all its edges
     * @return String representation of the vertex
     */
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Vertex ").append(name).append(":\n");
        for (int i = 0; i < edges.size(); i++)
        {
            s.append("\t");
            s.append(edges.get(i).toString());
            s.append("\n");
        }
        String out = s.toString();
        out.trim();
        return out;
    }
    
    /**
     * Creates a copy of the current vertex
     * @return A copy of the current vertex
     */
    public Vertex copy()
    {
        Vertex newVer = new Vertex(name);
        return newVer;
    }
    
    /**
     * Gets the edges of the vertex
     * @return The ArrayList of edges
     */
    public ArrayList<Edge> getEdges()
    {
        return edges;
    }
}

package fordFulkerson;

import java.util.ArrayList;

/**
 * This class is an implementation of the Ford-Fulkerson
 * algorithm that attempts to find the maximum flow of
 * a network.
 * 
 * Based on the implementation described here:
 * https://ieeexplore.ieee.org/document/7423216
 * 
 * @author Cameron Moore
 * @version 2018.12.08
 */
public class FordFulkersonAlgo {
    
    /**
     * Makes a DiGraph showing the current values that can be
     * put into the network
     * @param network The network being made into a residual network
     * @return A DiGraph with zeroed weights and capacities that 
     *         are equal to the max flow of the network minus the 
     *         current flow of the network
     */
    private static DiGraph residualNetwork(DiGraph network)
    {
        DiGraph copy = network.copy();
        ArrayList<Edge> copyEdges = copy.getEdges();
        for (int i = 0; i < copyEdges.size(); i++)
        {
            Edge curr = copyEdges.get(i);
            curr.setValue(curr.getCapacity() - curr.getWeight());
        }
        return copy;
    }
    
    
    /**
     * Finds an augmenting path from origin to dest
     * @param origin The source node
     * @param dest The sink node
     * @return A list of edges from the origin to the destination
     */
    private static ArrayList<Edge> findAP(Vertex origin, Vertex dest)
    {
        ArrayList<Vertex> visited = new ArrayList<Vertex>();
        ArrayList<Vertex> queue = new ArrayList<Vertex>();
        ArrayList<Edge> path = new ArrayList<Edge>();
        queue.add(origin);
        
        while (queue.size() > 0)
        {
            Vertex v = queue.remove(0);
            ArrayList<Edge> vEdges = v.getEdges();
            for (int i = 0; i < vEdges.size(); i++)
            {
                Edge curr = vEdges.get(i);
                
                if (!visited.contains(curr.getDest()) && 
                    curr.getDest() != origin &&
                    curr.getValue() != 0)
                {
                    visited.add(curr.getDest());
                    queue.add(curr.getDest());
                    path.add(curr);
                }
            }
        }
        return path;
    }
    
    
    /**
     * Gets the edge with the smallest capacity
     * @param augmentingPath The augmenting path to find the smallest
     *        value in
     * @return The smallest capacity in the list of provided edges
     */
    private static int getSmallestAugment(ArrayList<Edge> augmentingPath)
    {
        if (augmentingPath.size() > 0)
        {   
            int smallestCapacity = augmentingPath.get(0).getCapacity();
            for (int i = 0; i < augmentingPath.size(); i++)
            {
                Edge curr = augmentingPath.get(i);
                if (curr.getCapacity() < smallestCapacity)
                {
                    smallestCapacity = curr.getValue();
                }
            }
            return smallestCapacity;
        } 
        return 0;
    }
    
    
    /**
     * Fills the augmenting path with the smallest augment
     * @param augmentingPath The augmenting path to fill
     * @param smallestAugment The limiting value within the augmenting path
     */
    public static void fillAugmentingPath( 
        ArrayList<Edge> augmentingPath, int smallestAugment)
    {
        for (int i = 0; i < augmentingPath.size(); i++)
        {
            Edge curr = augmentingPath.get(i);
            curr.setWeight(smallestAugment + curr.getWeight());
        }
    }
    
    /**
     * Finds the maximum flow of the network
     * @param network
     * @param src
     * @param sink
     * @return
     */
    public static DiGraph findMaxFlow(DiGraph network, Vertex src, Vertex sink)
    {
        DiGraph newNetwork = network.copy();
        DiGraph residualNetwork = residualNetwork(newNetwork);
        ArrayList<Vertex> vertices = residualNetwork.getVertices();
        for (int i = 0; i < vertices.size(); i++)
        {
            if (src.getName().equals(vertices.get(i).getName()))
            {
                src = vertices.get(i);
            }
            else if (sink.getName().equals(vertices.get(i).getName()))
            {
                sink = vertices.get(i);
            }
        }
        ArrayList<Edge> path = findAP(src, sink);
        while (path.size() != 0)
        {
            int smallestAugment = getSmallestAugment(path);
            fillAugmentingPath(path, smallestAugment);
            residualNetwork = residualNetwork(residualNetwork);
            vertices = residualNetwork.getVertices();
            for (int i = 0; i < vertices.size(); i++)
            {
                if (src.getName().equals(vertices.get(i).getName()))
                {
                    src = vertices.get(i);
                }
                else if (sink.getName().equals(vertices.get(i).getName()))
                {
                    sink = vertices.get(i);
                }
            }
            path = findAP(src, sink);
        }
        return residualNetwork;
    }
}

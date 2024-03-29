package fordFulkerson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

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
//        for (int i = 0; i < copyEdges.size(); i++)
//        {
//            Edge curr = copyEdges.get(i);
//            curr.setValue(curr.getCapacity() - curr.getWeight());
//        }
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
        Stack<Edge> path = new Stack<>();

        findAPHelper(origin, dest, path, visited);


        ArrayList<Edge> pathList = new ArrayList<>(path);

        return pathList;
    }

    private static void findAPHelper(Vertex origin, Vertex dest, Stack<Edge> path, ArrayList<Vertex> visited)
    {
        if (origin == dest || (path.size() > 0 && path.peek().getDest() == dest))
        {
            return;
        }

        visited.add(origin);
        ArrayList<Edge> vEdges = origin.getEdges();


        for (int i = 0; i < vEdges.size(); i++)
        {
            if (path.size() > 0 && path.peek().getDest() == dest) {
                return;
            }
            Edge curr = vEdges.get(i);
            if (!visited.contains(dest)  &&
                    curr.getCapacity() - curr.getValue() != 0)
            {
                path.push(curr);
                if (curr.getDest() == dest)
                {
                    return;
                }
                findAPHelper(curr.getDest(), dest, path, visited);
                if (path.size() > 0 && path.peek().getDest() != dest)
                {
                    while (path.size() > 0 && path.peek().getDest() != origin)
                    {
                        path.pop();
                    }
                }
            }
        }
        if (path.size() > 0 && path.peek().getDest() != dest)
        {
            while (path.size() > 0 && path.peek().getDest() != origin)
            {
                path.pop();
            }
        }
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
            int smallestCapacity = augmentingPath.get(0).getCapacity() - augmentingPath.get(0).getValue();
            for (int i = 0; i < augmentingPath.size(); i++)
            {
                Edge curr = augmentingPath.get(i);
                if (curr.getCapacity() - curr.getValue() < smallestCapacity)
                {
                    smallestCapacity = curr.getCapacity() - curr.getValue();
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
            curr.setValue(smallestAugment + curr.getValue());
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
//            residualNetwork = residualNetwork(residualNetwork);
//            vertices = residualNetwork.getVertices();
//            for (int i = 0; i < vertices.size(); i++)
//            {
//                if (src.getName().equals(vertices.get(i).getName()))
//                {
//                    src = vertices.get(i);
//                }
//                else if (sink.getName().equals(vertices.get(i).getName()))
//                {
//                    sink = vertices.get(i);
//                }
//            }
            path = findAP(src, sink);
        }
        return residualNetwork;
    }
}

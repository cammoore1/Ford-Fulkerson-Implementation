package fordFulkerson;

/**
 * This class represents an edge in a graph
 * @author Cameron Moore 
 * @version 2018.12.08
 */
public class Edge {
    private int capacity;
    private int weight;
    private int value;
    private Vertex src;
    private Vertex dest;
    
    /**
     * Makes a directed edge within a graph
     * @param capacity The max weight of the edge
     * @param weight The current weight of the edge
     * @param src The vertex the flow is coming from
     * @param dest The vertex the flow is flowing towards
     */
    public Edge(int capacity, int weight, Vertex src, Vertex dest)
    {
        if (capacity < 0 || weight < 0 || capacity < weight)
        {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.weight = weight;
        this.value = 0;
        this.src = src;
        this.dest = dest;
    }
    
    /**
     * Makes a directed edge within a graph
     * @param capacity The max weight of the edge
     * @param weight The current weight of the edge
     * @param src The vertex the flow is coming from
     * @param value The value of the vertex
     * @param dest The vertex the flow is flowing towards
     */
    public Edge(int capacity, int weight, int value, Vertex src, Vertex dest)
    {
        if (capacity < 0 || weight < 0 || capacity < weight)
        {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.weight = weight;
        this.value = value;
        this.src = src;
        this.dest = dest;
    }
    
    /**
     * Sets the weight of the edge
     * @param weight The new weight of the edge
     * @return True if the value is legal and updated
     *         False otherwise
     */
    public boolean setWeight(int weight)
    {
        if (weight <= capacity)
        {
            this.weight = weight;
            return true;
        }
        return false;
    }
    
    /**
     * Sets the capacity of the edge
     * @param weight The new Capacity
     * @return True if the value is legal and updated
     *         False otherwise
     */
    public boolean setCapacity(int newCap)
    {
        if (weight <= newCap)
        {
            capacity = newCap;
            return true;
        }
        return false;
    }
    
    /**
     * Sets the value of the edge
     * @param newVal The new value of the edge
     */
    public void setValue(int newVal)
    {
        value = newVal;
    }
    
    /**
     * Sets the source of the edge
     * @param newSrc The new source of the edge
     */
    public void setSource(Vertex newSrc)
    {
        src = newSrc;
    }
    
    /**
     * Sets the destination of the edge
     * @param newDest The new destination of the edge
     */
    public void setDest(Vertex newDest)
    {
        dest = newDest;
    }
    
    /**
     * Gets the maximum weight of the edge
     * @return The maximum capacity the edge can support
     */
    public int getCapacity()
    {
        return capacity;
    }
    
    /**
     * Gets the current weight of the edge
     * @return The current flow within the edge
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * Gets the value of the edge
     * @return The current available capacity left
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * Gets the source of the flow
     * @return The source vertex of the edge
     */
    public Vertex getSrc()
    {
        return src;
    }
    
    /**
     * Gets the destination of the flow
     * @return The destination of the edge
     */
    public Vertex getDest()
    {
        return dest;
    }
    
    /**
     * Makes a string representation of the edge in the form
     * of       {src} --> {dest}
     *          currWeight / maxWeight
     *          
     * @return A string representation of the edge 
     */
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder(src.getName());
        s.append(" --> ");
        s.append(dest.getName());
        s.append("\n\t");
        s.append(value);
        s.append(" / ");
        s.append(capacity);
        return s.toString();
    }
    
    /**
     * Makes a copy of the edge that calls this
     * @return The copy of the edge
     */
    public Edge copy()
    {
        return new Edge(capacity, weight, src, dest);
    }
}

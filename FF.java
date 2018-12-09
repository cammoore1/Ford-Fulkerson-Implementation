package fordFulkerson;

import java.util.ArrayList;

public class FF {    
    
    public static void main(String[] args)
    {        
        testOne();
        
        
        
    }
    
    public static void testOne()
    {
        Vertex src = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex sink = new Vertex("F");
        Edge srcB = src.link(B, 10, 0);
        Edge BC = B.link(C, 100, 0);
        Edge CD = C.link(D, 10, 0);
        Edge DE = D.link(E, 10, 0);
        Edge Esink = E.link(sink, 20, 0);
        
        ArrayList<Vertex> v = new ArrayList<Vertex>();
        ArrayList<Edge> e = new ArrayList<Edge>();
        
        v.add(src);
        v.add(B);
        v.add(C);
        v.add(D);
        v.add(E);
        v.add(sink);
        e.add(srcB);
        e.add(BC);
        e.add(CD);
        e.add(DE);
        e.add(Esink);
        DiGraph graph = new DiGraph(v, e);
        
        System.out.println(graph.toString());
        
        DiGraph maxGraph = FordFulkersonAlgo.findMaxFlow(graph, src, sink);
        
        System.out.println(maxGraph.toString());
    }
    
    
    public static void testTwo()
    {
        Vertex src = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");
        Vertex I = new Vertex("I");
        Vertex J = new Vertex("J");
        Vertex sink = new Vertex("K");
        
        Edge srcB = src.link(B, 1024, 0);
        Edge BC = B.link(C, 10, 0);
        Edge BE = B.link(E, 100, 0);
        Edge CD = C.link(D, 100, 0);
        Edge Dsink = D.link(sink, 100, 0);
        Edge DG = D.link(G, 100, 0);
        
        Edge srcE = src.link(E, 10, 0);
        Edge EF = E.link(F, 100, 0);
        Edge FG = F.link(G, 10, 0);
        Edge Gsink = G.link(sink, 110, 0);
        Edge GJ = G.link(J, 1024, 0);
        
        Edge srcH = src.link(H, 100, 0);
        Edge HI = H.link(I, 100, 0);
        Edge HE = H.link(E, 100, 0);
        Edge IJ = I.link(J, 100, 0);
        Edge IF = I.link(F, 1024, 0);
        Edge Jsink = J.link(sink, 2048, 0);
        
        ArrayList<Vertex> v = new ArrayList<Vertex>();
        ArrayList<Edge> e = new ArrayList<Edge>();
        
        v.add(src);
        v.add(B);
        v.add(C);
        v.add(D);
        v.add(E);
        v.add(F);
        v.add(G);
        v.add(H);
        v.add(I);
        v.add(J);
        v.add(sink);
        
        e.add(srcB);
        e.add(BC);
        e.add(BE);
        e.add(CD);
        e.add(Dsink);
        e.add(DG);

        e.add(srcE);
        e.add(EF);
        e.add(FG);
        e.add(Gsink);
        e.add(GJ);
        
        e.add(srcH);
        e.add(HI);
        e.add(HE);
        e.add(IJ);
        e.add(IF);
        e.add(Jsink);
        
        DiGraph graph = new DiGraph(v, e);
        
        System.out.println(graph.toString());
        
        DiGraph maxGraph = FordFulkersonAlgo.findMaxFlow(graph, src, sink);
        
        System.out.println(maxGraph.toString());
    }
}

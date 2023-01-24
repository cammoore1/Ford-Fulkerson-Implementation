package fordFulkerson;

import java.util.ArrayList;

public class FF {

    public static void main(String[] args) {
        testThree();


    }

    public static void testOne() {
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


    public static void testTwo() {
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


    public static void testThree() {
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
        Vertex K = new Vertex("K");
        Vertex L = new Vertex("L");
        Vertex M = new Vertex("M");
        Vertex N = new Vertex("N");
        Vertex O = new Vertex("O");
        Vertex P = new Vertex("P");
        Vertex Q = new Vertex("Q");
        Vertex R = new Vertex("R");
        Vertex S = new Vertex("S");
        Vertex T = new Vertex("T");
        Vertex U = new Vertex("U");
        Vertex sink = new Vertex("V");

        Edge srcF = src.link(F, 10240, 0);
        Edge FB = F.link(B, 1024, 0);
        Edge BC = B.link(C, 10240, 0);
        Edge CD = C.link(D, 102400, 0);
        Edge CG = C.link(G, 1024, 0);
        Edge DE = D.link(E, 1024, 0);
        Edge Esink = E.link(sink, 10240, 0);
        Edge EI = E.link(I, 102400, 0);
        Edge IM = I.link(M, 10240, 0);
        Edge Msink = M.link(sink, 11264, 0);
        Edge FG = F.link(G, 1024, 0);
        Edge GH = G.link(H, 10240, 0);
        Edge HL = H.link(L, 1024, 0);
        Edge HD = H.link(D, 1024, 0);
        Edge LM = L.link(M, 1024, 0);
        Edge srcJ = src.link(J, 10240, 0);
        Edge JK = J.link(K, 102400, 0);
        Edge KL = K.link(L, 10240, 0);
        Edge srcN = src.link(N, 102400, 0);
        Edge NO = N.link(O, 1024, 0);
        Edge OK = O.link(K, 1024, 0);
        Edge OP = O.link(P, 1024, 0);
        Edge PQ = P.link(Q, 10240, 0);
        Edge QM = Q.link(M, 1024, 0);
        Edge NR = N.link(R, 1024, 0);
        Edge RS = R.link(S, 1024, 0);
        Edge ST = S.link(T, 10240, 0);
        Edge TU = T.link(U, 1024, 0);
        Edge UQ = U.link(Q, 1024, 0);



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
        v.add(K);
        v.add(L);
        v.add(M);
        v.add(N);
        v.add(O);
        v.add(P);
        v.add(Q);
        v.add(R);
        v.add(S);
        v.add(T);
        v.add(U);
        v.add(sink);

        e.add(srcF);
        e.add(FB);
        e.add(BC);
        e.add(CD);
        e.add(CG);
        e.add(DE);
        e.add(Esink);
        e.add(EI);
        e.add(IM);
        e.add(Msink);
        e.add(FG);
        e.add(GH);
        e.add(HL);
        e.add(HD);
        e.add(LM);
        e.add(srcJ);
        e.add(JK);
        e.add(KL);
        e.add(srcN);
        e.add(NO);
        e.add(OK);
        e.add(OP);
        e.add(PQ);
        e.add(QM);
        e.add(NR);
        e.add(RS);
        e.add(ST);
        e.add(TU);
        e.add(UQ);

        DiGraph graph = new DiGraph(v, e);

        System.out.println(graph.toString());

        DiGraph maxGraph = FordFulkersonAlgo.findMaxFlow(graph, src, sink);

        System.out.println(maxGraph.toString());
    }
}

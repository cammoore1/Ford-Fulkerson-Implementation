# Ford-Fulkerson Implementation
<br />
I successfully replicated the algorithm described here for
the Ford-Fulkerson algorithm which finds the maximum flow 
for a network: 
https://ieeexplore.ieee.org/document/7423216.

The article's implementation algorithms are inconsistant and
hard to follow. However, I managed to implement the algorithm
regardless with a bit of changes and through the use of a 
depth-first-search.

Three tests are included that output text representing the set 
of six figures from the paper. The algorithm matches the first
two sets. However, it varies slightly from the third. This seems
to just be a difference in the paths taken by the algorithms.
Both still achieve the same max flow.


## This is the original graph from Figure 2 which is testOne() within FF.java
Vertex A:<br />
	&nbsp; &nbsp; &nbsp; &nbsp; A --> B<br /> 
	&nbsp; &nbsp; &nbsp; &nbsp;0 / 10<br />
Vertex B:<br />
	&nbsp; &nbsp; &nbsp; &nbsp;B --> C<br />
	&nbsp; &nbsp; &nbsp; &nbsp;0 / 100<br />
Vertex C:<br />
	&nbsp; &nbsp; &nbsp; &nbsp;C --> D<br />
	&nbsp; &nbsp; &nbsp; &nbsp;0 / 10<br />
Vertex D:<br />
	&nbsp; &nbsp; &nbsp; &nbsp;D --> E<br />
	&nbsp; &nbsp; &nbsp; &nbsp;0 / 10<br />
Vertex E:<br />
	&nbsp; &nbsp; &nbsp; &nbsp;E --> F<br />
	&nbsp; &nbsp; &nbsp; &nbsp;0 / 20<br />
Vertex F:<br />


## This is the graph after the algorithm runs
Vertex A:<br />
	&nbsp; &nbsp; &nbsp; &nbsp;A --> B<br />
	&nbsp; &nbsp; &nbsp; &nbsp;10 / 10<br />
Vertex B:<br />
	&nbsp; &nbsp; &nbsp; &nbsp;B --> C<br />
	&nbsp; &nbsp; &nbsp; &nbsp;10 / 100<br />
Vertex C:<br />
	&nbsp; &nbsp; &nbsp; &nbsp;C --> D<br />
	&nbsp; &nbsp; &nbsp; &nbsp;10 / 10<br />
Vertex D:<br />
	&nbsp; &nbsp; &nbsp; &nbsp;D --> E<br />
	&nbsp; &nbsp; &nbsp; &nbsp;10 / 10<br />
Vertex E:<br />
	&nbsp; &nbsp; &nbsp; &nbsp;E --> F<br />
	&nbsp; &nbsp; &nbsp; &nbsp;10 / 20<br />
Vertex F:<br />


Output for each vertex is as follows:
Vertex {src}:<br />
  &nbsp; &nbsp; &nbsp; &nbsp;{src} --> {dest}<br />
  &nbsp; &nbsp; &nbsp; &nbsp;{flow} / {capacity}<br />

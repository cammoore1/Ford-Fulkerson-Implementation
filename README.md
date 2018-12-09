# Ford-Fulkerson-Implementation

This repository is for a school project. 
I failed to successfully replicate the algorithm described here: 
https://ieeexplore.ieee.org/document/7423216.

The article's implementation algorithms are inconsistant and
hard to follow. However, I failed to replicate it regardless
from a lack of time from working against other deadlines.

However, I did get it to work for a simple linear graph in 
figure 2 from the article. That was able to be reproduced
which resulted in the following output:

# This is the original graph
Vertex A:
	A --> B
	0 / 10
Vertex B:
	B --> C
	0 / 100
Vertex C:
	C --> D
	0 / 10
Vertex D:
	D --> E
	0 / 10
Vertex E:
	E --> F\n
	0 / 20\n
Vertex F:


# This is the graph after the algorithm runs
Vertex A:
	A --> B
	10 / 10
Vertex B:
	B --> C
	10 / 100
Vertex C:
	C --> D
	10 / 10
Vertex D:
	D --> E
	10 / 10
Vertex E:
	E --> F
	10 / 20
Vertex F:


Output for each vertex is as follows:
Vertex {src}:
  {src} --> {dest}
  {flow} / {capacity}

# Ford-Fulkerson Implementation
Hours work on: 10 - 12 or so. <br />
This repository is for a school project. 
I failed to successfully replicate the algorithm described here: 
https://ieeexplore.ieee.org/document/7423216.

The article's implementation algorithms are inconsistant and
hard to follow. However, I failed to replicate it regardless
from a lack of time from working against other deadlines.

I could not reproduce Figure 4 from the article because my
implemenation would keep looping when finding an augmenting
path. This could probably be fixed if I had more time.
However, I did get it to work for a simple linear graph in 
figure 2 from the article. That was able to be reproduced
which resulted in the following output:

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

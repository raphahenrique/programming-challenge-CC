# Programming Challenge 

*Description of the problem is written below.

## Tasks
### What is the O() complexity of your solution?

The complexity of my solution is O(n²).
Since we have 2 for's inside a while loop, and these for's are not nested, our complexity would be O(2n²) that is equal to O(n²).


### How can you improve your existing solution? If that is possible, what would your new solution's O() complexity be?
What is the complexity class  (P, NP, NP-complete, etc) of this problem ?
One way that probably improve the current solution, would be analysing the values of the substraction, to assertain about the next value.
What I found in the internet, was people using the bubble sort algorithm to compare the next two values.
However, these two approaches would still run in a O(n²) complexity

The complexity class is of P, since it can be solved on a polynomial time.


### Provide us a diagram containing the state machine automata of your algorithm;
I've included the diagram inside the folder **Diagram** 


### Bonus point: Provide us the abstract syntax tree (AST) representation of your algorithm;
I've included the AST inside the folder **ast**



## Problem
There are n people queued up, and each person wears a sticker indicating their initial position in the
queue (i.e.:1,2,...,n-1,n with the first number denoting the frontmost position).

Any person in the queue can bribe the person directly in front of them to swap positions. If two people
swap positions, they still wear the same sticker denoting their original place in line. One person can bribe
at most two other persons .
That is to say, if n = 8 and Person 5 bribes Person 4, the queue will look like this: 1,2,3,5,4,6,7,8.

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took
place to get the queue into its current state!

-> Input Format
The first line contains an integer, T, denoting the number of test cases.
Each test case is comprised of two lines; the first line has n(an integer indicating the number of people in
the queue), and the second line has n space-separated integers describing the final state of the queue.
-Constraints
   1<=T<=10
   1<=n<=10⁵
-Subtasks
   For 60% score 1<=n<=10³
   For 100% score 1<=n<=10⁵

-> Output Format
Print an integer denoting the minimum number of bribes needed to get the queue into its final state; print
Too chaotic if the state is invalid (requires Person X to bribe more than 2 people).



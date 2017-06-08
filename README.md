# counting-out
The counting-out problem (aka the Josephus problem)

To build and run this project, you will need sbt.

The program accepts two integers as arguments:
arg1 = n, the total number of people 
arg2 = k, the number of skips

The program returns an integer, the position of the last-standing person. The position is for a 1-based index.

Assuming you have sbt installed, cd to the project directory (once cloned).  From there, you can run the project in two ways:

$ sbt "run $n $k"

OR

$ sbt
> run n k



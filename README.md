# counting-out

The counting-out problem (aka the Josephus problem)  

To build and run this project, you will need sbt.
The program accepts two integers as arguments:

    arg1 = n, the total number of people 
    arg2 = k, the number of skips

An integer is returned - the position of the last-standing person for a 1-based index.

Assuming you have sbt installed, cd to the project directory (once cloned).  From there, you can run the project in two ways:

    $ sbt "run $n $k"

or


    $ sbt
    > run n k



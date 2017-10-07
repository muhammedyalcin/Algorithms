package BKQuestions

import scala.collection.LinearSeq
import scala.collection.mutable.ArrayBuffer

/**
  * Created by asuskobay on 5/9/17.
  */

/*
-Take the total number of points from graph
-According to total points create multi-dimension.
-Create for loop which can able to place '1' if touches the another point or place 0
-Print adjacency matrix
-Iterate multi-dimension, if 2 points touches each other then must be 2 , 3 points x 2 must be 6 , 4 points x 3 must be 12
 */
object Clique extends App{

  val kenarList = List(('A','B'),('A','C'),('A','D'),('B','C'),('B','D')
    ,('B','F'),('C','D'),('C','E'),('D','F') )

  var points = ArrayBuffer[Char]()

  val adMatrix =  Array.ofDim[Int](6,6)

  def maxClique(edges: List[(Char,Char)]): Unit = {

    var maxCliq,totalnum = 0

    //Tum noktalari bir kumede topla----Gelistirilebilir
    for( k <- 0 until edges.length){

      println(edges(k))

      var (x,y) = edges(k)

        if( !(points.contains(x))){
          points += x

        }
        if (!(points.contains(y))){
          points += y
        }
    }

    //Sorted ArrayBuffer according to alphabet
     val srtpoints = points.sorted


    // Adjacency Matrix
    for (i <- 0 until 6) {
      for (j <- 0 until 6 ){

          if (edges.contains(srtpoints(i), srtpoints(j)) || edges.contains(srtpoints(j), srtpoints(i))){

           adMatrix(i)(j) = 1

          }else adMatrix(i)(j) = 0
        }
      }


    //Calculate the first to points in Adjacency Matrix then upto 6
    for(p <- 2 until srtpoints.length){

      for(i <- 0 until p){
        for (j <- 0 until p){

          totalnum += adMatrix(i)(j)

        }
      }

      if(totalnum > maxCliq && totalnum==p * (p-1)){
        maxCliq = totalnum / (p -1)
      }
      totalnum = 0
    }

    println(maxCliq)

    }

maxClique(kenarList)

}

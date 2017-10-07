package Kruskals

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.io.Source
import scala.io.StdIn

/**
  * Created by asuskobay on 19/8/17.
  */
/*
-Read txt which contains distance matrix file by line
-take the First line as vertices number
-According to Vertices number create a List which contains Sets
-Sets type is Edge case class which contains v1,v2 and weight
-Apply all vertices and weights in list[set]
-List the Sets based on their weights
====
- Create a union to combine sets.
- Based on the Sets , if the set is non-cycles
-and  then  make union.
In union if v1,v2 both is non-included in union then
 -create new union otherwise combine both
 - print new created list of set
 */
case class Edge(v1: Int, v2: Int, weight : Int)

object KruskalsAlgorithm extends App{

val lines =Source.fromFile("/media/asuskobay/Linux/workspaceIntellij/AlgorithmCodes/src/Kruskals/distancematrix").getLines().toArray
  val edges = ArrayBuffer[Edge]()
  val unionList = ArrayBuffer[Edge]()
  var sets = ListBuffer[Set[Int]]()

  def mst() = {
    var v1 = 0

    for (line <- lines.tail) {

      sets += Set(v1)

      val row = line.split(",").map(_.toInt)

      for (i <- 0 until row.length) {
        if (row(i) != -1) {
          edges += Edge(v1, i, row(i))
        }
      }
      v1 += 1
    }

    val orderedEdges = edges.sortBy(_.weight)

    for (i <- 0 until orderedEdges.length){

      if(orderedEdges(i).v1 != orderedEdges(i).v2){

        val subset = orderedEdges(i)

        union(subset,orderedEdges(i).v1 ,orderedEdges(i).v2)

      }
    }


    println(sets)
    println(orderedEdges)
    println(unionList)
  }

  //Union of Sets
  def union(edge: Edge,v1: Int, v2: Int) = {

   val set1 = sets.find(_.contains(v1)).get
    val set2 = sets.find(_.contains(v2)).get
      if(!(set1.contains(set2.head))){
        sets -= set1
        sets -= set2
        sets += set1 ++ set2
        println(sets)
        unionList += edge
      }


  }

  mst()

}

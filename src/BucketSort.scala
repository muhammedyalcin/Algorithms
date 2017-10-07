import java.util

import scala.collection.mutable.ArrayBuffer

/**
  * Created by asuskobay on 18/7/17.
  */
/*
Bucket Sort;

1-Find lentgh of array, max and min value
2-then create a 10 bucket which takes sequence of elements.
3-Find the divider by this formal (max+1)/bucket then tahe the round
4-In order to insert values in buckets use this formal; array value / divider  then round equal to bucket index.
5-Then apply insertion sort to each bucket
6-At the last, concentrate the buckets

 */
object BucketSort extends App{

  val unsortedArr= Array(22,45,12,8,10,6,72,81,33,18,50,14,9999)

  def applyBucketSort( arr: Array[Int]) : ArrayBuffer[Int] = {

    val max : Double= arr.max
    val min = arr.min
    val n = arr.length - 1

    var f = 0

    val buckets = ArrayBuffer.fill(10,0)(0)


    val divider = Math.ceil((max + 1) / 10).toInt


    //Step 4
    for (i <- 0 to n){

      val j = Math.floor(arr(i) / divider).toInt

      buckets(j) += arr(i)


    }
    //Step 5
   buckets.filter(_.nonEmpty).map( arrbuff => InsertionSort.applyInsertionSort(arrbuff))

    //Step 6
    buckets.flatten


  }

  println("Haci iste bu" + applyBucketSort(unsortedArr))

}

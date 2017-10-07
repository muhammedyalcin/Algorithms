import scala.collection.immutable.Range.BigDecimal
import scala.collection.mutable.ArrayBuffer

/**
  * Created by asuskobay on 17/7/17.
  */

/*
Radix Sort Algorithm With Bucket

-Create 0 to 9 labeled buckets
-find the max value of digits
-Convert all values digits to max value digit
-As max value digits, create passes
-In each pass, put in the buckets according to the digits
 -After completion of each passes, concentrate buckets and so on.
 */
object RadixSort extends  App{

  val unordered = ArrayBuffer(170, 45, 75, 90, 802, 2, 24, 66,23,234,3,232,44)

  def findTheDigit(num: Int, dig:Int = 1) : Int = {
    if (num < 10) dig
    else findTheDigit(num / 10, dig + 1 )
  }

  def applyRadixSort(elements : ArrayBuffer[Int]) : ArrayBuffer[Int] ={

    var expr = 1

    val maxDigit =findTheDigit(elements.max)

    var buckets = ArrayBuffer.fill(10,0)(0)

    for( pass <- 0 until maxDigit){

     for (i <- 0 until elements.length){
       buckets((elements(i)  / expr ) % 10)  += elements(i)
     }

      val newBuckets = buckets.filter(_.nonEmpty).flatten

      for (i <- 0 until elements.length){
        elements(i) = newBuckets(i)
      }

      buckets = ArrayBuffer.fill(10,0)(0)

      expr *= 10

    }
     elements

  }




  println("Bakalim dogurumu " + applyRadixSort(unordered))

}

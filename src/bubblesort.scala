import scala.collection.mutable.ArrayBuffer

/**
  * Created by asuskobay on 13/7/17.
  */
/*
Bubble Sort Algorthim

-compare the each  element n time and for each element  compare n -1 time for not comparing last compared biggest elements
-if  the first element is greater than  next element then swap
 */

object bubblesort extends App{

  val set = ArrayBuffer(2,7,4,1,5,3)

  def applyBubbleSortAlgorithm(elements : ArrayBuffer[Int]) : ArrayBuffer[Int] = {

    var size = elements.length

    for (n <- 0 until elements.length ){

      for (i <-0 until size -1 ){

        val p= elements(i)

        if (elements(i) > elements(i+1)){

          elements(i) = elements(i + 1)
          elements(i + 1)= p

        }
      }
    }
    elements

  }

  println("Iste buu!!" + applyBubbleSortAlgorithm(set))
}

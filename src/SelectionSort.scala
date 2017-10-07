import scala.collection.mutable.ArrayBuffer

/**
  * Created by asuskobay on 10/7/17.
  */

/*
-In the given array find the min element by checking each elements
- swap the found min values with first element of array
-then come to second element and check the remaining values.


 */
object SelectionSort extends App{

  val givenArray = ArrayBuffer(6,2,1,8,4,3,9)

  def applySelectionSort (elements : ArrayBuffer[Int]) : ArrayBuffer[Int]= {

    var min = 0
    var tmp = 0

    for (i <- 0 until  elements.length -1 ){

      min= i

      for (j <- i until   elements.length  ){

        if (elements(min) > elements(j)) min = j

      }
      
      tmp = elements(i)
      elements(i) = elements(min)
      elements(min) = tmp

    }
    elements
  }
 val a = 0 until 10
  println("Siralnmis hali " + applySelectionSort(givenArray) )

}

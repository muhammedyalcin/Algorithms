import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

/**
  * Created by asuskobay on 20/7/17.
  */
/*
Shell Sort Algorith
-Take avarage of elements length
-According to avarage length , swap the elements.
-Then divide the avarage length by 2 up to getting 1
-When the avarage length equal to 1 then apply bubble sort algorithm
 */
object ShellSort extends  App{

  val unordered = ArrayBuffer(9,7,2,5,6,1,3)

  def applyShellSort(elements: ArrayBuffer[Int]) : ArrayBuffer[Int] = {

    var numberRange = (elements.length -1) / 2


for (k <- 0 until numberRange if numberRange > 1){

  for(i <- 0 until elements.length if (i+numberRange) <= elements.length -1){

    val tmp = elements(i)

    if(elements(i) > elements(i+numberRange)){

      elements(i) = elements(i+numberRange)
      elements(i+numberRange) = tmp

    }

  }
  numberRange / 2

}
    bubblesort.applyBubbleSortAlgorithm(elements)


  }
  println("Sonuc " + applyShellSort(unordered))

}

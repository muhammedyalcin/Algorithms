import scala.collection.mutable.ArrayBuffer

/**
  * Created by asuskobay on 15/7/17.
  */

/*
-Find the maximum value in the input array
-Create new count array according to  found maximum value range index
-Each element is 0
-Create a new array as length of input array
-In count array, add +1 for index of input array
-End of the loop, take the sum of element first and next , next and next
-In the created new array, take the each element of input array as a index of count array ,
-and take the count value as index of new array and add the input value.
 */
object CountSort extends  App{

  val input = ArrayBuffer(7,3,1,5,51,23,51,23,51,12,5,23,7)

  def applyCountSort(elements : ArrayBuffer[Int]) : Array[Int] ={

    val maxvalue= {
      var max = 0
      for (n <- 1 until elements.length){
        if (elements(max) < elements(n) ) {
          max = n
        }
      }
      elements(max)
    }

    var count = (0 to maxvalue).toArray

    for(c <- 0 until count.length){
      count(c)=0
    }

    val newArray = new Array[Int](elements.length )

    //Count array adds +1
   for (i <- 0 until elements.length){
       count(elements(i)) +=1

   }
    println("Count array is" + count.toList)

    //count(0,1,0,1,0,2)
   // count(0,1,1,2,2,4)
    //Take sum of first count element and next and second element with next and so on.
    for(s <- 0 until count.length -1){
      count(s+1) += count(s)
    }
    println("sum of Count array is" + count.toList)

    for(e <- 0 until elements.length){
      count(elements(e)) -= 1
      newArray(count(elements(e))) = elements(e)
    }

    newArray

  }

  println("Hadi iyisin gene " + applyCountSort(input).toList)

}

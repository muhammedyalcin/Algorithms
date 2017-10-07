import scala.collection.mutable.ArrayBuffer

/**
  * Created by asuskobay on 13/7/17.
  */

/*
Instertion Sort Algorithm
-
-In array, start with first element , in the first pass , the first element will be order then
-in the second pass, second element and first element compare and smallest element relace with first element then...
-in third pass, second element and third element compare if small replace with second element and then first element and so on..
-it continues up to n number

 */
object InsertionSort extends App{

  val set = ArrayBuffer(33,11,21,83,56,73,22)

  def applyInsertionSort(elements: ArrayBuffer[Int]) : ArrayBuffer[Int] = {

    for (n <- 1 until elements.length ){

      var k = elements(n)
      var i = n - 1

      while (i >= 0 && k < elements(i)){

        elements(i + 1) = elements(i)
        elements(i) = k
        i = i - 1

      }
    }
   elements
  }

  println("sayi buuu " + applyInsertionSort(set))

}

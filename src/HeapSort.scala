import sun.security.util.Length

import scala.annotation.tailrec

/**
  * Created by asuskobay on 11/8/17.
  */
/*
- Transform the array to Heap structure (heapify)
- Delete the root node
- Put the last node in place of root then heapify again
- Repeat this process until all elements are covered.
 */
/*
object HeapSort extends App{
  def left(i: Int) = (2*i) + 1                    //> left: (i: Int)Int
  def right(i: Int) = left(i) + 1                 //> right: (i: Int)Int
  def parent(i: Int) = (i - 1) / 2                //> parent: (i: Int)Int

  def swap(a: Array[Int], i: Int, j: Int): Unit = {
    val t = a(i)
    a(i) = a(j)
    a(j) = t
  }                                         //> swap: (a: Array[Int], i: Int, j: Int)Unit

  def maxHeap (a: Array[Int], i: Int, size: Int): Unit = {
    val l = left(i)
    val r = right(i)
    var m = -1
    m = if (l < size && a(l) > a(i)) {l} else {i}
    m = if (r < size && a(r) > a(m)) {r} else {m}
    if (m != i) {
      swap(a, i, m)
      maxHeap(a, m, size)
    }
  }                                         //> maxHeap: (a: Array[Int], i: Int, size: Int)Unit

  def buildMaxHeap (a: Array[Int], size: Int): Unit = {

    val hs = size / 2
    for (i <- 0 to hs) {

      maxHeap(a, hs - i, size)
    }
  }                                         //> buildMaxHeap: (a: Array[Int], size: Int)Unit

  def heapSort (a: Array[Int]) {
    buildMaxHeap(a, a.length)
    for (i <- (0 until a.length).reverse) {
      swap(a, 0, i)
      maxHeap(a, 0, i)
    }
  }

  val data = (500000 to 0 by -1).toArray
  heapSort (data)
  println("sonuc " +data.toList)
}*/

//This algorithm doesn't fit to O(n log n).
//Because heapify  algorithm must be changed.
//To improve this algrithm, keep here.
object HeapSort extends  App{

  val element = Array(40,60,10,20,50,30)

  def parent(i: Int) : Int = (i / 2) -1
  def left(i : Int) : Int = (i*2)-1
  def right(i: Int) : Int = ((2 * i) +1 ) -1


  def heapify(elements: Array[Int], com : Int ,length: Int): Array[Int]={
    //parent(i) = [i /2] , left(i) = 2i ,  right(i) = 2i + 1
    //left and  right

      if(left(com) <= length  && elements(com-1) > elements(left(com))  ){

        if (right(com) <= length && elements(left(com)) > elements(right(com))){

          swap(elements,com -1, right(com))

        }else swap(elements,com -1, left(com))

      }else if (right(com) <= length && elements(com-1) > elements(right(com))){

        swap(elements,com -1, right(com))

      }else elements



  }

  def swap(elements : Array[Int], i: Int, j: Int) : Array[Int] = {

    val tmp = elements(i)
    elements(i) = elements(j)
    elements(j) = tmp

    elements
  }
/*
  def checkStructure(elements: Array[Int], com : Int, result: Boolean = true) : Boolean = {

    if (result == true && com >0 ){

        if (left(com) <= elements.length -1 && elements(com-1) > elements(left(com)) ){
          checkStructure(elements,com-1, false)
        } else if ( right(com) <= elements.length-1 && elements(com-1) > elements(right(com))) {
          checkStructure(elements,com-1 , false)
        }else  checkStructure(elements,com - 1, true)

      }else result

  }

*/
  def heap(elements : Array[Int], length: Int) : Array[Int] = {

    val comp = Math.floor(length +1 / 2).toInt

    val heapified = for (i <- comp to 1 by -1) {
        heapify(elements, i,length)
      }

    elements

  }

    @annotation.tailrec
    def heapSort(elements: Array[Int] ,length: Int) : Array[Int]= {
println("Array   "+ elements.toList)
      if(length >= 0){
        heap(elements,length)

        swap(elements,0,length)


        heapSort(elements ,length -1)

      }else elements.reverse


  }

   println("Sonuc : "+ heapSort(heap(element,element.length-1),element.length-1).toList)



}
/*
object HeapSort {
  def main(args: Array[String]): Unit = {
    var mess = (500000 to 1 by -1).toArray

    sort(mess)
    // buildHeap(mess, mess.length-1)

    println("sonuc " + mess.toList)
  }

  def sort(a: Array[Int]): Unit = {
    var m = a.length - 1
    buildHeap(a, m)
    while (m >= 1) {
      swap(a, 0, m)
      m-=1
      heapify(a, 0, m)
    }
  }

  def buildHeap(a: Array[Int], m: Int): Unit = {
    for (i <- m/2 to 0 by -1) {
      heapify(a, i, m)
    }
  }

  /**Pushes an illegally located element down the heap to restore heap property.*/
  @annotation.tailrec
  def heapify(a: Array[Int], loc: Int, lastLeaf: Int): Unit = {
    val l = left(loc)
    val r = right(loc)

    var max = loc

    if(l <= lastLeaf && a(l) > a(max)) max = l
    if(r <= lastLeaf && a(r) > a(max)) max = r

    if(max != loc) {
      swap(a, max, loc)
      heapify(a, max, lastLeaf)
    }
  }

  /**Returns position of left child (possibly empty). */
  def left(loc: Int): Int = {
    return 2*loc
  }

  /**Returns position of right child (possibly empty). */
  def right(loc: Int): Int = {
    return 2*loc+1
  }

  def swap(a: Array[Int], i: Int, j:Int): Unit = {
    val staging = a(i)
    a(i) = a(j)
    a(j) = staging
  }
}
*/
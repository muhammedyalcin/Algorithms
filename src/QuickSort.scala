/**
  * Created by asuskobay on 31/7/17.
  */
/*
Quick Sort

-Select the first element as pivot
-And according to pivot, take the smaller elements to left and bigger elements to right
-Then by applying same process to left and right it goes on
-
 */
object QuickSort extends App{

  def quickSort (list : List[Int]) :List[Int] = {

    if(list.length > 1) {

      val pivot = list.head

      val (left, right) = divideIt(list.tail, pivot, Nil, Nil)



      println("left  " + left, "right  " + right, " pivot    " + pivot)


      merge(Nil, quickSort(left), quickSort(right), pivot)

    }else list


  }

  def merge(res : List[Int], left: List[Int], right: List[Int],pivot : Int) : List[Int] = (left,right) match {
    case (left, Nil) => left ::: res.reverse
    case (Nil, right) => res.reverse ::: right
    case (x :: xs, y :: ys) =>{
      if (x < y) {
       merge(x :: res,xs,right,pivot)
      }else merge(y :: res, left, ys,pivot)
    }
  }

  //divide  elements of array into left smaller than and right  bigger than   pivot
  def divideIt(list: List[Int], pivot: Int, left: List[Int], right: List[Int]) : (List[Int], List[Int]) = {

    if (list.nonEmpty){

      if (list.head < pivot ) {
        divideIt(list.tail,pivot,list.head :: left,right)
      }
      else {
        divideIt(list.tail,pivot,left,list.head :: right )

      }

    }else (left ::: pivot::Nil,  right)


  }



println("Sonuc  :"+ quickSort(List(12,19,22,26,11,33,35)))

}

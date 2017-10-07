import scala.annotation.tailrec

/**
  * Created by asuskobay on 21/7/17.
  */
object MergeSort extends App{

  def mergerSort(list: List[Int]) : List[Int] ={

    @tailrec
    def patternEx(res: List[Int], left : List[Int], right: List[Int]): List[Int]= (left,right) match {
      case (left, Nil) => res.reverse ::: left
      case (Nil,right) => res.reverse ::: right
      case (x :: xs, y :: ys) => {
        if ( x < y) patternEx(x :: res,xs, right)
        else  patternEx(y:: res,left,ys)
      }
    }


    val middle = list.length / 2

    if(middle == 0) list
    else {
      val(left,right) = list.splitAt(middle)
      println("left  " + left + "                 right "+right)

      patternEx(Nil,mergerSort(left),mergerSort(right))
    }

  }
  println("Result " + mergerSort((0 until 10).reverse.toList))

}

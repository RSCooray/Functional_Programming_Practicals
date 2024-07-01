import scala.io.StdIn.readLine

object EvenSum {
  def main(args: Array[String]): Unit = {
    
    println("Enter a list of integers:") // Get input
    val input = readLine()

    val numbers = input.split(" ").map(_.toInt).toList // Convert the input string to a list of integers

    val sumOfEvens = sumEvenNumbers(numbers) //Calculate the sum

    println(s"The sum of all even numbers in the list is: $sumOfEvens")//Print
  }

  def sumEvenNumbers(numbers: List[Int]): Int = {
    numbers.filter(_ % 2 == 0).sum // calculate sum 
  }
}

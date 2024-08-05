import scala.io.StdIn._

object CalculateSquare extends App {
  
  // Function to calculate the square of each number in a list using a lambda function
  def calculateSquare(numbers: List[Int]): List[Int] = {
    numbers.map(n => n * n)  //lambda function
  }

  println("Enter numbers separated by spaces:")
  val input = readLine() 
  val numbers = input.split(" ").map(_.toInt).toList 
  
  val squareNumbers = calculateSquare(numbers)  // Call the function
  
  println(s"Square numbers: ${squareNumbers.mkString(", ")}")  // Print the result
}

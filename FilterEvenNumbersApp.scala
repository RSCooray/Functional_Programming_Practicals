import scala.io.StdIn._

object FilterEvenNumbersApp extends App {
  
  def filterEvenNumbers(numbers: List[Int]): List[Int] = { // Function to filter even numbers
    numbers.filter(n => n % 2 == 0) 
  }

  println("Enter numbers separated by spaces:")
  val input = readLine()  // Read input from the user
  val numbers = input.split(" ").map(_.toInt).toList  // Convert input to a list of integers
  
  val evenNumbers = filterEvenNumbers(numbers)  // Call the functions
  
  println(s"Even numbers: ${evenNumbers.mkString(", ")}")  // Print the result
}

import scala.io.StdIn._

object FilterPrimeNumbersApp extends App {

  def isPrime(n: Int): Boolean = { //function to check if a number is prime
    if (n <= 1) false
    else if (n == 2) true
    else !(2 to math.sqrt(n).toInt).exists(x => n % x == 0)
  }

  // Function to filter prime numbers
  def filterPrime(numbers: List[Int]): List[Int] = {
    numbers.filter(n => isPrime(n))  //lambda function 
  }

  println("Enter numbers separated by spaces:")
  val input = readLine() 
  val numbers = input.split(" ").map(_.toInt).toList 
  
  val primeNumbers = filterPrime(numbers)  // Call the function
  
  println(s"Prime numbers: ${primeNumbers.mkString(", ")}")  // Print the result
}

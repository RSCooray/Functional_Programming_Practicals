object Pattern extends App {

  println("Enter a number:") // Get a number as an input
  val number = scala.io.StdIn.readInt()

  val patternMatch = (n: Int) => n match { // Define lambda function
    case _ if n == 0   => "Zero"    
    case _ if n < 0  => "Negative Number"  
    case _ if n % 2 == 0 => "Even Number" 
    case _                 => "Odd Number"
  }

  // Call the lambda function and print the result
  val result = patternMatch(number)
  println(s"The number $number is $result")
}

object NumberCategorizer extends App {

  println("Enter an integer:") // Get integer input
  val input = scala.io.StdIn.readInt()

  val categorize = (n: Int) => n match { // Define a lambda functions
      case _ if n % 3 == 0 && n % 5 == 0 => "Multiple of Both Three and Five"
      case _ if n % 3 == 0               => "Multiple of Three"
      case _ if n % 5 == 0               => "Multiple of Five"
      case _                             => "Not a Multiple of Three or Five"
    
  }

  // Call lamda function and print results
  val result = categorize(input)
  println(result)
}

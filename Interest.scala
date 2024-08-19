object Interest extends App {

  println("Enter a deposit amount:") // Get deposit amount as an input
  val deposit = scala.io.StdIn.readInt()

  val interest = (d: Int) => d match { // Define lambda function
    case _ if d <= 20000   => d * 2.00 / 100    
    case _ if d <= 200000  => d * 4.00 / 100  
    case _ if d <= 2000000 => d * 3.50 / 100 
    case _                 => d * 6.50 / 100
  }

  // Call the lambda function and print the result
  val result = interest(deposit)
  println(s"The interest earned on Rs. $deposit is Rs. $result")
}

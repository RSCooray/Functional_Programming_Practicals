import scala.io.StdIn.readLine

object ReverseString {
  
  def main(args: Array[String]): Unit = {
    println("Enter a string to reverse:") //get input
    val input = readLine() //read input
    val reversed = reverse(input) //call reverse function
    println(s"Original: $input") //print
    println(s"Reversed: $reversed")
  }

  def reverse(s: String): String = {
    if (s.isEmpty) "" 
    else reverse(s.tail) + s.head 
  } //reverse function
}

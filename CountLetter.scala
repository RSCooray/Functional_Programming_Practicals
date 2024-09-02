//Q5
import scala.io.StdIn._

object CountLetter extends App {
  
  def countLetterOccurrences(words: List[String]): Int = {
  
    words.map(_.length).reduce(_ + _)
  }

  // Get input from the user
  println("Enter words separated by spaces:")
  val input = readLine()  
   
  val words = input.split("\\s+").toList
  
  // Calculate the total letter occurrences
  val totalOccurrences = countLetterOccurrences(words)
  
  // Print the result
  println(s"Total count of letter occurrences: $totalOccurrences")
}

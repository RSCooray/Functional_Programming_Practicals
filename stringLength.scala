import scala.io.StdIn

object stringLength {
  def main(args: Array[String]): Unit = {
    filterAndPrint()
  }

  def filterAndPrint(): Unit = {
    println("Enter a list of strings:") //get input list from user
    
    val input = StdIn.readLine() //Read input list
    
    val inputList = input.split("\\s+").toList //Split the input
    
    val filteredList = inputList.filter(_.length > 5) //Filter the list
    
    println("Strings with length greater than 5:")
    println(filteredList.mkString(", "))// Print the list
  }
}

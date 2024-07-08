object StringFormatter {
  
  def toUpper(str: String): String = { // convert a string to upper case
    str.toUpperCase()
  }

  def toLower(str: String): String = { //onvert a string to lower case
    str.toLowerCase()
  }

  def formatNames(name: String)(formatFunction: String => String): String = { //format names using a given function
    formatFunction(name)
  }

  def main(args: Array[String]): Unit = {
    print("Enter a string: ")
    val input = scala.io.StdIn.readLine()

    println("Choose a format option:")
    println("1. Upper Case")
    println("2. Lower Case")
    val choice = scala.io.StdIn.readInt()

    val formattedName = choice match {
      case 1 => formatNames(input)(toUpper)
      case 2 => formatNames(input)(toLower)
      case _ => println("Invalid choice. Please select 1 or 2.")
      return
    }

    println(s"Formatted Name: $formattedName")
  }
}

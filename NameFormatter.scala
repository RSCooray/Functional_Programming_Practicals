object NameFormatter extends App {

  // Uppercase method
  val toUpper: String => String = _.toUpperCase

  // Lowercase method
  val toLower: String => String = _.toLowerCase

  // Format name method
  def formatNames(name: String)(formatFunction: String => String): String = {
    formatFunction(name)
  }

  // Using lambda functions
  val Name1 = formatNames("Benny")(toUpper)
  val Name2 = formatNames("Niroshan")(name => name.substring(0, 2).toUpperCase + name.substring(2).toLowerCase)
  val Name3 = formatNames("Saman")(toLower)
  val Name4 = formatNames("Kumara")(name => name.substring(0, 1).toUpperCase + name.substring(1, 5).toLowerCase + name.last.toUpper)

  // Print the formatted names
  println(Name1) 
  println(Name2) 
  println(Name3) 
  println(Name4)
}

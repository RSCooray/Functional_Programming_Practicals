object PatternMatching {
  def main(args: Array[String]): Unit = {
    print("Enter an integer: ")
    val input = scala.io.StdIn.readInt()

    input match {
      case x if x == 0 => println("Zero")
      case x if x < 0 => println("Negative Number")
      case x if x % 2 == 0 => println("Even number is given")
      case _ => println("Odd number is given")
    }
  }
}

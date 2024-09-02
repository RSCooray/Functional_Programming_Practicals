//Q1
import scala.io.StdIn._

class Rational(n: Int, d: Int) {
  
  require(d != 0, "Denominator cannot be zero")

  private val gcdValue: Int = gcd(n.abs, d.abs)
  val numerator: Int = n / gcdValue
  val denominator: Int = d / gcdValue

  // negate the rational number
  def neg: Rational = new Rational(-numerator, denominator)

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  override def toString: String = s"$numerator/$denominator"
}

object RationalApp extends App {
  // Get user input
  println("Enter the numerator:")
  val num = readInt()

  println("Enter the denominator:")
  val denom = readInt()

  // Create a Rational number
  val x = new Rational(num, denom)
  
  // Negate the Rational number
  val negX = x.neg

  // Display the results
  println(s"Rational number x: $x")
  println(s"Negated x: $negX")
}

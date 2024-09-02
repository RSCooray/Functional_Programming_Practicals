//Q2
class Rational(n: Int, d: Int) {

  require(d != 0, "Denominator cannot be zero")

  private val gcdValue: Int = gcd(n.abs, d.abs)
  val numerator: Int = n / gcdValue
  val denominator: Int = d / gcdValue

  // negate the rational number
  def neg: Rational = new Rational(-numerator, denominator)

  // subtract two rational numbers
  def sub(that: Rational): Rational = {
    new Rational(
      numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator
    )
  }

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  override def toString: String = s"$numerator/$denominator"
}

object RationalApp extends App {

  // Define x = 3/4, y = 5/8, z = 2/7
  val x = new Rational(3, 4)
  val y = new Rational(5, 8)
  val z = new Rational(2, 7)

  // Calculate x - y - z
  val result = x.sub(y).sub(z)

  // Display the result
  println(s"Result of x - y - z: $result")
}

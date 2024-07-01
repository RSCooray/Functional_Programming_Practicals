object ArithmeticMean {
  def main(args: Array[String]): Unit = {
    val num1 = 10
    val num2 = 20
    println(f"The arithmetic mean is: ${calculateMean(num1, num2)}%.2f")//print
  }

  def calculateMean(num1: Int, num2: Int): Double = {
    val mean = (num1 + num2) / 2
    BigDecimal(mean).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble //rounded to two decimal places
  }
}

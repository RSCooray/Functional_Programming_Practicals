object RunTime {
  def easyPace(d: Int) = d * 8
  
  def tempo(d: Int) = d * 7
  
  def totalT(d1: Int, d2: Int, d3: Int) = easyPace(d1) + tempo(d2) + easyPace(d3)

  def main(args: Array[String]): Unit = {
    println(totalT(2, 3, 2))
  }
}


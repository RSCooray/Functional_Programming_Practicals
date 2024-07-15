object InventoryManagementSystem {

  import scala.io.StdIn.readLine
  
  def getProductList: List[String] = {
    var products: List[String] = List()
    var continue = true
    
    while (continue) {
      val product = readLine("Enter product name (or type 'ok' to finish): ")
      if (product.toLowerCase == "ok") {
        continue = false
      } else {
        products = products :+ product
      }
    }
    
    products
  }

  def printProductList(products: List[String]): Unit = {
    products.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.length
  }
  
  def main(args: Array[String]): Unit = {
    val products = getProductList
    println("\nProduct List:")
    printProductList(products)
    println(s"\nTotal number of products: ${getTotalProducts(products)}")
  }
}

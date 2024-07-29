import scala.io.StdIn._

case class Product(name: String, quantity: Int, price: Double)

object InventorySystem extends App { //display product
  def getProductNames(inventory: Map[Int, Product]): List[String] = {
    inventory.values.map(_.name).toList
  }

  def calculateTotalValue(inventory: Map[Int, Product]): Double = { //calculate the total value
    inventory.values.map(product => product.quantity * product.price).sum
  }

  def isInventoryEmpty(inventory: Map[Int, Product]): Boolean = { //check if inventory is empty
    inventory.isEmpty
  }

  def mergeInventories(inventory1: Map[Int, Product], inventory2: Map[Int, Product]): Map[Int, Product] = { //merge
    (inventory1.keySet ++ inventory2.keySet).map { id =>
      val product1 = inventory1.get(id)
      val product2 = inventory2.get(id)
      
      val mergedProduct = (product1, product2) match {
        case (Some(p1), Some(p2)) =>
          Product(p1.name, p1.quantity + p2.quantity, math.max(p1.price, p2.price))
        case (Some(p1), None) => p1
        case (None, Some(p2)) => p2
        case _ => throw new IllegalStateException("Unexpected case")
      }
      
      id -> mergedProduct
    }.toMap
  }

  def checkProductById(inventory: Map[Int, Product], productId: Int): Unit = { //search product
    inventory.get(productId) match {
      case Some(product) =>
        println(s"Product ID: $productId")
        println(s"Name: ${product.name}")
        println(s"Quantity: ${product.quantity}")
        println(s"Price: ${product.price}")
      case None =>
        println(s"Product with ID $productId does not exist.")
    }
  }

  println("Enter inventory1 details (ID, name, quantity, price). Enter 'done' to finish:")
  var input = readLine()
  var inventory1: Map[Int, Product] = Map()
  while (input != "done") {
    val parts = input.split(" ")
    val id = parts(0).toInt
    val name = parts(1)
    val quantity = parts(2).toInt
    val price = parts(3).toDouble
    inventory1 += (id -> Product(name, quantity, price))
    input = readLine()
  }

  println("Enter inventory2 details (ID, name, quantity, price). Enter 'done' to finish:")
  input = readLine()
  var inventory2: Map[Int, Product] = Map()
  while (input != "done") {
    val parts = input.split(" ")
    val id = parts(0).toInt
    val name = parts(1)
    val quantity = parts(2).toInt
    val price = parts(3).toDouble
    inventory2 += (id -> Product(name, quantity, price))
    input = readLine()
  }
 
  println("Product names in inventory1:")
  val productNames = getProductNames(inventory1)
  productNames.foreach(println)

  val totalValue = calculateTotalValue(inventory1)
  println(s"Total value of all products in inventory1: $$${totalValue}")

  println(s"Is inventory1 empty? ${isInventoryEmpty(inventory1)}")

  val mergedInventory = mergeInventories(inventory1, inventory2)
  println("Merged inventory:")
  mergedInventory.foreach { case (id, product) =>
    println(s"ID: $id, Name: ${product.name}, Quantity: ${product.quantity}, Price: ${product.price}")
  }

  println("Enter a product ID to check in inventory1:")
  val productIdToCheck = readLine().toInt
  checkProductById(inventory1, productIdToCheck)

}
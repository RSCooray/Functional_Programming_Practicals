import scala.io.StdIn._

object Inventory {
  var itemNames = Array("Apple", "Banana", "Orange", "Mango", "Water Melon")
  var itemQuantities = Array(20, 40, 35, 100, 15)

  def displayInventory(): Unit = {
    println("Inventory:")
    for ((name, quantity) <- itemNames.zip(itemQuantities)) {
      println(s"$name: $quantity")
    }
    println()
  }

  def restockItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      itemQuantities(index) += quantity
      println(s"Restocked $quantity of $itemName. New quantity: ${itemQuantities(index)}")
    } else {
      println(s"Item '$itemName' not found in inventory.")
    }
    println()
  }

  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
        println(s"Sold $quantity of $itemName. Remaining quantity: ${itemQuantities(index)}")
      } else {
        println(s"Not enough $itemName in inventory to sell. Available quantity: ${itemQuantities(index)}")
      }
    } else {
      println(s"Item '$itemName' not found in inventory.")
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    var continue = true
    while (continue) {
      println("1. Display Inventory")
      println("2. Restock Item")
      println("3. Sell Item")
      println("4. Exit")
      
      print("Enter your choice: ")
      val choice = readLine()
      
      choice match {
        case "1" => displayInventory()
        case "2" =>
          print("Enter the item name to restock: ")
          val itemName = readLine()
          print("Enter the quantity to restock: ")
          val quantity = readInt()
          restockItem(itemName, quantity)
        case "3" =>
          print("Enter the item name to sell: ")
          val itemName = readLine()
          print("Enter the quantity to sell: ")
          val quantity = readInt()
          sellItem(itemName, quantity)
        case "4" =>
          println("Exiting the program.")
          continue = false
        case _ => println("Invalid choice. Please try again.")
      }
      println()
    }
  }
}

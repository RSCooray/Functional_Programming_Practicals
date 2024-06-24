object price{

	def attendees(price:Int):Int=120+(15-price)/5*20

	def revenue(price:Int):Int = attendees(price)*price

	def cost(price:Int):Int=500 + 3*attendees(price)

	def profit(price:Int):Int =revenue(price)- cost(price)

	def main(arg:Array[String]):Unit={
		println(s"Price = 05 -> Profit=${profit(5)}")
		println(s"Price = 10 -> Profit=${profit(10)}")
		println(s"Price = 15 -> Profit=${profit(15)}")
		println(s"Price = 20 -> Profit=${profit(20)}")
		println(s"Price = 25 -> Profit=${profit(25)}")
		println(s"Price = 30 -> Profit=${profit(30)}")
		println(s"Price = 35 -> Profit=${profit(35)}")
	}
}

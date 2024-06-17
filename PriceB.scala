object PriceB{
	def bookPrice(numOfBooks:Double)=numOfBooks*24.95
	
	def discount(totalCovPrice:Double)=totalCovPrice*0.4

	def shippingCost(numOfBooks:Double)=if(numOfBooks>50){3*numOfBooks+(numOfBooks-50)*0.75} else{numOfBooks*3}

	def total(numOfBooks:Double)= bookPrice(numOfBooks) - discount(bookPrice(numOfBooks)) + shippingCost(numOfBooks)

	def main(args:Array[String]):Unit={
		println(total(60))
	}
}



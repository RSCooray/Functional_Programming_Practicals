object salary{
	def salary(hours:Int)=if(hours<40){hours*250} else{(40*250)+(hours-40)*85}

	def tax(hours:Int)=salary(hours)*12/100

	def totalsalary(hours:Int)=salary(hours)-tax(hours)

	def main(arg:Array[String]):Unit={
		println(s"Salary=${totalsalary(70)}")
	}
}
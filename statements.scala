object statements{
	var a: Int = 2
	var b: Int = 3
	var c: Int = 4
	var d: Int = 5
	var k: Float = 4.3f


	def main(arg:Array[String]):Unit={
		println(-(-b)*a+c*d) //println(--b*a+c*d--)
		
		println(a)//println(a++)
		a+=1
		
		var g:Float = 1.0f
		println(-2*(g-k)+c)
		
		c+=1
		println(c)//println(c=c++)
		
		
		c+=1
		println(c*a)//println(c=++c*a++)
		a+=1
	}
}
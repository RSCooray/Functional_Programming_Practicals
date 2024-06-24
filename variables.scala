object variables{
	var i,j,k=2
	var m,n=5
	var f=12.0f
	var g=4.0f
	var c='X'

	def main(arg:Array[String]):Unit={
		printf(s"k + 12 * m = ${k+12*m} \n")
		printf(s"m / j = ${m/j} \n")
		printf(s"n %% j = ${n%j} \n")
		printf(s"m / j * j = ${m/j*j} \n")
		printf(s"f + 10*5 +g = ${f+10*5+g} \n")
		i=i+1
		printf(s"++i * n = ${i*n} \n")
	}
}
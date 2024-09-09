class Rational(n:Int,d:Int){
    require(d != 0, "Denominator cannot be zero")

    private val gcd = greatestCommonDivisor(n.abs, d.abs)
    val numerator: Int = n / gcd
    val denominator: Int = d / gcd

    def this(n: Int) = this(n, 1)

    private def greatestCommonDivisor(a: Int, b: Int): Int = {
        if (b == 0) a else greatestCommonDivisor(b, a % b)
    }

    def sub(that: Rational): Rational = {
        val newNumerator = this.numerator * that.denominator - that.numerator * this.denominator
        val newDenominator = this.denominator * that.denominator
        new Rational(newNumerator, newDenominator)
    }

    override def toString: String = s"$numerator/$denominator"
}

object SubstractFunction{
  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)  // x = 3/4
    val y = new Rational(5, 8)  // y = 5/8
    val z = new Rational(2, 7)  // z = 2/7

    
    val result_y_minus_z = y.sub(z)
    println(s"y - z = $result_y_minus_z")  


    val result_x_minus_yz = x.sub(result_y_minus_z)
    println(s"x - (y - z) = $result_x_minus_yz") 
  }
}
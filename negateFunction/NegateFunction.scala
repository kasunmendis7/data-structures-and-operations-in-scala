class Rational(n:Int,d:Int){
    require(d != 0, "Denominator cannot be zero")

    private val gcd = greatestCommonDivisor(n.abs, d.abs);
    val numerator: Int = n/gcd;
    val denominator: Int = d/gcd;

    def this(n:Int)=this(n,1)

    def neg:Rational=new Rational(-numerator, denominator)

    private def greatestCommonDivisor(a:Int,b:Int):Int={
        if(b==0) a else greatestCommonDivisor(b, a%b)
    }

    override def toString(): String = s"$numerator/$denominator"
}
object NegateFunction{
    def main(args: Array[String]):Unit={
        val x = new Rational(3,4)
        println(s"Rational number x: $x")
        println(s"Negated Rational Number x: ${x.neg}")
    }
}
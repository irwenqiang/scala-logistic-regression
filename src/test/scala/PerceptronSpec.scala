import org.scalatest.FlatSpec
import org.scalatest.PrivateMethodTester._
import perceptron.Perceptron

class PerceptronSpec extends FlatSpec {

    behavior of "A Perceptron"

    it should "inner product from two vector" in {
        val perceptron = new Perceptron
        val innerProduct = PrivateMethod[Double]('innerProduct)

        val a = List[Double](2.0, 3.0)
        val b = List[Double](4.0, 2.0)

        val real:Double = perceptron invokePrivate innerProduct(a, b)
        val expect = 14.0
        assert(real === expect)
    }

}

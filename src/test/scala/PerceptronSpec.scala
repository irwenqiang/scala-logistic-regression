import org.scalatest.FlatSpec
import org.scalatest.PrivateMethodTester._
import perceptron.Perceptron

class PerceptronSpec extends FlatSpec {

    behavior of "A Perceptron"


    it should "predicate if >=0 then true else false from two List" in {
        val perceptron = new Perceptron
        val predicate = PrivateMethod[Boolean]('predicate)

        val pos_one = List[Double](1.0)
        val zero = List[Double](0.0)
        val neg_one = List[Double](-1.0)

        val pos_pos = perceptron invokePrivate predicate(pos_one, pos_one)
        val pos_zero = perceptron invokePrivate predicate(pos_one, zero)
        val pos_neg = perceptron invokePrivate predicate(pos_one, neg_one)

        assert(pos_pos === true)
        assert(pos_zero === true)
        assert(pos_neg === false)
    }


    it should "inner product from two List" in {
        val perceptron = new Perceptron
        val innerProduct = PrivateMethod[Double]('innerProduct)

        val a = List[Double](2.0, 3.0)
        val b = List[Double](4.0, 2.0)

        val real:Double = perceptron invokePrivate innerProduct(a, b)
        val expect = 14.0
        assert(real === expect)
    }

}

import org.scalatest.FlatSpec
import org.scalatest.PrivateMethodTester._
import perceptron.Perceptron

class PerceptronSpec extends FlatSpec {

    behavior of "A Perceptron"

    it should "recursive trial" in {
        val perceptron = new Perceptron
        val trial = PrivateMethod[List[Double]]('trial)

        val gold = List((1.0, 4.0, 1.0),
                        (-2.0, -1.0, -1.0))
        val w:List[Double] = List[Double](0.0, 0.0, 0.0)
        val real = perceptron.train(gold, w, 2)
        val ones_w = perceptron invokePrivate trial(gold, w)
        val expect = perceptron invokePrivate trial(gold, ones_w)
        assert(real === expect)
    }


    it should "update w(a, b, c) parmeter in trial." in {
        val perceptron = new Perceptron
        val trial = PrivateMethod[List[Double]]('trial)

        val gold = List((1.0, 2.0, 1.0))
        val w = List[Double](3.0, -4.0, 1.0)
        val expect = List[Double](4.0, -2.0, 2.0)
        val real:List[Double] = perceptron invokePrivate trial(gold, w)
        assert(real !== w)
        assert(real === expect)
    }


    it should "predicate if >=0 then true else false from two List." in {
        val perceptron = new Perceptron
        val predicate = PrivateMethod[Double]('predicate)

        val pos_one = List[Double](1.0)
        val zero = List[Double](0.0)
        val neg_one = List[Double](-1.0)

        val pos_pos = perceptron invokePrivate predicate(pos_one, pos_one)
        val pos_zero = perceptron invokePrivate predicate(pos_one, zero)
        val pos_neg = perceptron invokePrivate predicate(pos_one, neg_one)

        assert(pos_pos === 1.0)
        assert(pos_zero === 1.0)
        assert(pos_neg === -1.0)
    }


    it should "inner product from two List." in {
        val perceptron = new Perceptron
        val innerProduct = PrivateMethod[Double]('innerProduct)

        val a = List[Double](2.0, 3.0)
        val b = List[Double](4.0, 2.0)

        val real:Double = perceptron invokePrivate innerProduct(a, b)
        val expect = 14.0
        assert(real === expect)
    }

    it should "phi is return (x,y,1.0) List." in {
        val perceptron = new Perceptron
        val phi = PrivateMethod[List[Double]]('phi)

        val real:List[Double] = perceptron invokePrivate phi(1.0,2.0)
        val expect = List[Double](1.0, 2.0, 1.0)
        assert(real === expect)
    }

}

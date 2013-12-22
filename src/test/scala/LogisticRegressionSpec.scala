import org.scalatest.FlatSpec
import org.scalatest.PrivateMethodTester._
import logisticregression.LogisticRegression

class LogisticRegressionSpec extends FlatSpec {

    behavior of "A LogisticRegression"

    it should "update w(a, b, c) parmeter in trial." in {
        val logisticregression = new LogisticRegression
        val trial = PrivateMethod[List[Double]]('trial)

        val gold = List((1.0, 2.0, 1.0))
        val w = List[Double](3.0, -4.0, 1.0)
        val expect = List[Double](3.098201379003791, -3.8035972419924184, 1.0982013790037908)
        val real:List[Double] = logisticregression invokePrivate trial(gold, w, 0.1)
        assert(real !== w)
        assert(real === expect)
    }

    it should "predicate return x | 0 <= x <= 1." in {
        val logisticregression = new LogisticRegression
        val predicate = PrivateMethod[Double]('predicate)
        val sigmoid = PrivateMethod[Double]('sigmoid)

        val pos_one = List[Double](1.0)
        val zero = List[Double](0.0)
        val neg_one = List[Double](-1.0)

        val real1 = logisticregression invokePrivate predicate(pos_one, pos_one)
        val real2 = logisticregression invokePrivate predicate(pos_one, zero)
        val real3 = logisticregression invokePrivate predicate(pos_one, neg_one)

        val expect1 = logisticregression invokePrivate sigmoid(1.0)
        val expect2 = logisticregression invokePrivate sigmoid(0.0)
        val expect3 = logisticregression invokePrivate sigmoid(-1.0)

        assert(real1 === expect1)
        assert(real2 === expect2)
        assert(real3 === expect3)
    }

    it should "inner product from two List." in {
        val logisticregression = new LogisticRegression
        val innerProduct = PrivateMethod[Double]('innerProduct)

        val a = List[Double](2.0, 3.0)
        val b = List[Double](4.0, 2.0)

        val real:Double = logisticregression invokePrivate innerProduct(a, b)
        val expect = 14.0
        assert(real === expect)
    }

    it should "phi is return (x,y,1.0) List." in {
        val logisticregression = new LogisticRegression
        val phi = PrivateMethod[List[Double]]('phi)

        val real:List[Double] = logisticregression invokePrivate phi(1.0,2.0)
        val expect = List[Double](1.0, 2.0, 1.0)
        assert(real === expect)
    }

    it should "sigmoid fuction" in {
        val logisticregression = new LogisticRegression
        val sigmoid = PrivateMethod[Double]('sigmoid)
        val real:Double = logisticregression invokePrivate sigmoid(0.0)
        val expect:Double = 0.5
        assert(real === expect)
    }

}

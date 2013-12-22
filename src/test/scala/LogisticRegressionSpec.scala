import org.scalatest.FlatSpec
import org.scalatest.PrivateMethodTester._
import logisticregression.LogisticRegression

class LogisticRegressionSpec extends FlatSpec {

    behavior of "A LogisticRegression"

    it should "recursive trial" in {
        val logisticregression = new LogisticRegression
        val trial = PrivateMethod[List[Double]]('trial)

        val gold = List((1.0, 4.0, 1.0),
                        (-2.0, -1.0, -1.0))
        val w:List[Double] = List[Double](0.0, 0.0, 0.0)
        val real = logisticregression.train(gold, w, 2)
        val ones_w = logisticregression invokePrivate trial(gold, w)
        val expect = logisticregression invokePrivate trial(gold, ones_w)
        assert(real === expect)
    }


    it should "update w(a, b, c) parmeter in trial." in {
        val logisticregression = new LogisticRegression
        val trial = PrivateMethod[List[Double]]('trial)

        val gold = List((1.0, 2.0, 1.0))
        val w = List[Double](3.0, -4.0, 1.0)
        val expect = List[Double](4.0, -2.0, 2.0)
        val real:List[Double] = logisticregression invokePrivate trial(gold, w)
        assert(real !== w)
        assert(real === expect)
    }


    it should "predicate if >=0 then true else false from two List." in {
        val logisticregression = new LogisticRegression
        val predicate = PrivateMethod[Double]('predicate)

        val pos_one = List[Double](1.0)
        val zero = List[Double](0.0)
        val neg_one = List[Double](-1.0)

        val pos_pos = logisticregression invokePrivate predicate(pos_one, pos_one)
        val pos_zero = logisticregression invokePrivate predicate(pos_one, zero)
        val pos_neg = logisticregression invokePrivate predicate(pos_one, neg_one)

        assert(pos_pos === 1.0)
        assert(pos_zero === 1.0)
        assert(pos_neg === -1.0)
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

}

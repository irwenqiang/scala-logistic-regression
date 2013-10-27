package perceptron {

    import scala.util.Random

    class Perceptron {

        def train(gold:List[(Double, Double, Double)], w:List[Double] = List[Double](0.0, 0.0, 0.0), limit:Int = 10000): List[Double] = {
            val r = new Random
            val new_w:List[Double] = this.trial(r.shuffle(gold), w)
            if (w == new_w || limit <= 0) {
                return new_w
            } else {
                train(gold, new_w, limit-1)
            }
        }

        private def trial(gold:List[(Double, Double, Double)], w:List[Double]): List[Double] = {
            var new_w:List[Double] = w

            gold.foreach { p =>

                val pred = this.predicate(this.phi(p._1, p._2), new_w)
                if (pred != p._3) {
                    new_w = new_w.zip(this.phi(p._1, p._2)).map((t) =>
                        t._1 + p._3 * t._2 // aw + agold._3 * aphi
                    )
                }
            }

            new_w
        }

        private def predicate(w: List[Double], phi: List[Double]):Double = {
            if (this.innerProduct(w, phi) >= 0.0) 1.0 else -1.0
        }

        private def innerProduct(a: List[Double], b: List[Double]): Double = {
            if (a.size != b.size) {
                throw new RuntimeException("list size isn't equal.")
            }

            val products:List[Double] = a.zip(b).map((t) => t._1 * t._2)
            products.reduceLeft {(a,b) => a + b}
        }

        private def phi(x:Double, y:Double):List[Double] = {
            List[Double](x * 1.0, y * 1.0, 1.0)
        }


    }

}

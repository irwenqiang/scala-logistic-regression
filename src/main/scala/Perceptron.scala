package perceptron {

    class Perceptron {

        private def trial(gold:List[(Int, Int, Double)], w:List[Double]): List[Double] = {
            var new_w:List[Double] = w

            gold.foreach { p =>
                val isValid = this.predicate(this.phi(p._1, p._2), w)
                if (!isValid) {
                    new_w = new_w.zip(this.phi(p._1, p._2)).map((t) =>
                        t._1 + p._3 * t._2 // aw + agold._3 * aphi
                    )
                }
            }

            new_w
        }

        private def predicate(w: List[Double], phi: List[Double]):Boolean = {
            this.innerProduct(w, phi) >= 0.0
        }

        private def innerProduct(a: List[Double], b: List[Double]): Double = {
            if (a.size != b.size) {
                throw new RuntimeException("list size isn't equal.")
            }

            val products:List[Double] = a.zip(b).map((t) => t._1 * t._2)
            products.reduceLeft {(a,b) => a + b}
        }

        private def phi(x:Int, y:Int):List[Double] = {
            List[Double](x * 1.0, y * 1.0, 1.0)
        }


    }

}


object Main {

    def main(args: Array[String]) {
        println("hello world.")
    }

}

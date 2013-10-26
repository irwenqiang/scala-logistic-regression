package perceptron {

    class Perceptron {

        private def innerProduct(a: List[Double], b: List[Double]): Double = {
            if (a.size != b.size) {
                throw new RuntimeException("list size isn't equal.")
            }

            val products:List[Double] = a.zip(b).map((t) => t._1 * t._2)
            products.reduceLeft {(a,b) => a + b}
        }

    }

}


object Main {

    def main(args: Array[String]) {
        println("hello world.")
    }

}

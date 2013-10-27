# Scala - Perceptron
===

## How to use
```scala
val gold:List:List[(Double, Double, Double)] = YOUR_TRAINING_DATSET
val perceptron = new Perceptron
val w:List[Double] = perceptron.train(gold)
```

## Exmaple
![data](./output/example.png "data")

### Run
```
$ cd scala-perceptron
$ sbt run
```

### plot use R
```
$ cd scala-perceptron/output/
$ R
> lo <- read.table("lower.tsv", sep="\t")
> up <- read.table("upper.tsv", sep="\t")
> r = c(-3, 3)
> plot(lo, col=2, xlim=r, ylim=r)
> par(new=T)
> plot(up, col=4, xlim=r, ylim=r)
```

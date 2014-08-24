package com.hulu.xuxin.spark.examples
import scala.math.random
import org.apache.spark._
object SparkPi {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("spark://mac.local:7077").setAppName("SparkPi")
    val spark = new SparkContext(conf)
    //val iterators = conf.getInt("spark.pi.iterators", 100000)
    //val slices = conf.getInt("spark.pi.slices", 2)
    //val n = iterators * slices
    //val count = spark.parallelize(1 to n, slices).map { i =>
    val n = 10000
    val count = (1 to n).map { i =>
      val x = random * 2 - 1 
      val y = random * 2 - 1 
      if (x*x + y*y < 1) 1 else 0
    }.reduce(_ + _)
    println("Pi is roughly " + 4.0 * count / n)
    spark.stop()
  }
}

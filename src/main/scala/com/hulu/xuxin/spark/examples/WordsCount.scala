package com.hulu.xuxin.spark.examples

import org.apache.spark._

object WordsCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordsCount").setMaster("local")
    val sc = new SparkContext(conf)
    sc.addFile("build.sbt")
    val lines = sc.textFile(SparkFiles.get("build.sbt"))
    println(lines.count)
  }
}
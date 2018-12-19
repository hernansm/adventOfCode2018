/**
  * https://adventofcode.com/2018/day/1
  *
  * Starting with a frequency of zero, what is the resulting frequency after all of the changes in frequency have been applied?
  *
  */

package day1

import scala.io.Source

object Day1 extends App {

  println("starting..")

  val file: List[String] = Source.fromResource("problems/day1.txt").getLines.toList

  val frequency = file.foldLeft(0) {_ + _.toInt}

  println("frequency: " + frequency)


  def calibrateFrequency(list: List[String], freq: Int = 0): Int = {
    println("calibrating frequency..")
    list.foldLeft(freq) { _ + _.toInt}
  }

  def firstFrequencyReached(list: List[String], freq: Int = 0): Int = {
    println("finding first repeated frequency..")
//    list.foldLeft(freq) {
//      //val sum = _ + _.toInt
//      sum
//
//    }
    ???
  }
}
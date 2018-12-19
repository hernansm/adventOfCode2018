/**
  * https://adventofcode.com/2018/day/2
  *
  * What is the checksum for the given list of box IDs?
  *
  */

package day2

import scala.io.Source

object Day2 extends App {

  println("starting..")

  val file: List[String] = Source.fromResource("problems/day2.txt").getLines.toList

  val checksum = findChecksum(file)
  println("checksum: " + checksum)


//  def findRepeatingLetters(list: List[String]): Int = {
//    val characters = file.flatten.toSet
//
//    file.foreach(boxID => {
//      println("boxID: " + boxID + "    ")
//      boxID.sorted
//      print(" sorted: " + boxID.sorted + "\n")
//    })
//    1
//  }

  def findChecksum(list: List[String]): Int = {
    var doubleDigits = 0
    var tripleDigits = 0

    list.foreach(boxId => {
      // println("boxID: " + boxId)
      var frequencies = collection.mutable.Map[Char, Int]()

      boxId.foreach( character => {
        frequencies.get(character) match {
          case Some(e) => frequencies.update(character, e+1)
          case None => frequencies += (character -> 1)
        }
      })

      // println("\tfrequencies: "  + frequencies)

      val uniqueFrequencies: Set[Int] = frequencies.values.toSet

      // println("\t\tunique: " + uniqueFrequencies)

      if (uniqueFrequencies.contains(2)) doubleDigits += 1
      if (uniqueFrequencies.contains(3)) tripleDigits += 1

    })
    doubleDigits * tripleDigits
  }

}

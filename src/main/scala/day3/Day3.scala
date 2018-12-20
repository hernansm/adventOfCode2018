/**
  * Day3: No Matter How You Slice It
  * https://adventofcode.com/2018/day/3
  *
  * How many square inches of fabric are within two or more claims?
  *
  * #1 @ 817,273: 26x26
  * #2 @ 974,796: 18x19
  * #3 @ 207,456: 14x29
  *
  *   - grid size is NOT specified so can't create a grid..
  *   - Must create a list of all the cells with the "use count" --> https://www.reddit.com/r/adventofcode/comments/a2qohl/day_3_part_1_help_needed_i_understand_the/
  *     - use map (cell coordinate -> use count)
  *     - add cellCoord to Set once "use count" gets to 2
  *     - return Set size
  *
  */

/*
   claims:
     #1 @ 1,3: 4x4
     #2 @ 3,1: 4x4
     #3 @ 5,5: 2x2

   visually:
     ........
     ...2222.
     ...2222.
     .11XX22.
     .11XX22.
     .111133.
     .111133.
     ........

    */


package day3

object Day3 {

  def fabricOverlapCounter(claims: List[String]): Int = {
    // create a map - this will hold all used cells
    // create a set - this will hold all used cells with 2+ claims
    // for each claim:
    //    find the starting coordinate
    //    loop through the height and width of claim
    //    check if coord is in set. if so move on
    //    check if coord is in map. if so, increment value. if value is 2 add coord to set
    // return set.size

    // might not need to use a set.. could just check the map. check the value. if 2+ increment counter. save on space

    // map of fabricCoordinate -> claimedAmt
    val usedFabricMap = Map[Int,Int]()

    claims.foreach( claim => {
      // find starting coord
      // loop through claimed area

    })

    ???
  }

}

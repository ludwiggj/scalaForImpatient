package ch11.questions.q8

import scala.collection.mutable.ArrayBuffer
import scala.Array

//m x n matrix
//ops + and *, scalar 2 * m
//access single element mat (row, col)

//     2 x 3        3 x 1     2 x 1
//  r11 r12 r13  *  t11        M11
//  r21 r22 r23     t21        M22
//                  t31
//
//  M11 = r11× t11  +  r12× t21  +   r13×t31
//  M12 = r21× t11  +  r22× t21   +  r23×t31

class Matrix(private val data: Array[Array[String]]) {
  override def toString = {
    var rep = new StringBuilder
    for (row <- data) {
      for (cell <- row) {
        rep = rep.append(cell).append(" | ")
      }
      rep = rep.append("\n")
    }
    rep.toString()
  }

  private def row(rowId: Int) = data(rowId)

  private def column(columnId: Int) = for (row <- data) yield row(columnId)

  def *(other: Matrix) = {
    val result =
      (for (rowId <- 0 until data.length) yield {
        Array(
          row(rowId) zip (other.column(rowId)) map {
            case (x, y) => s"($x * $y)"
          } reduceLeft (_ + " + " + _)
        )
      }).toArray
    new Matrix(result)
  }

  def *(scalar: Int) = {
    new Matrix(for (row <- data) yield {
      row map { cell =>
          s"$scalar * ($cell)"
      }
    })
  }

  def +(other: Matrix) = {
    val result =
      (for (rowId <- 0 until data.length) yield {
        row(rowId) zip (other.row(rowId)) map {
          case (x, y) => s"($x + $y)"
        }
      }).toArray
    new Matrix(result)
  }

  def apply(row: Int, col: Int) = data(row-1)(col-1)
}

object Matrix {
  def apply(matrixName: String, numberOfRows: Int, numberOfColumns: Int) =
    makeMatrix(matrixName, numberOfRows, numberOfColumns)

  private def makeMatrix(matrixName: String, numberOfRows: Int, numberOfColumns: Int) = {
    def makeRow(rowId: Int) = {
      val rowBuf = new ArrayBuffer[String]()
      (1 to numberOfColumns).foreach {
        colId: Int =>
          rowBuf += s"$matrixName$rowId$colId"
      }
      rowBuf.toArray
    }
    val matrix = new ArrayBuffer[Array[String]]()
    (1 to numberOfRows).foreach {
      rowId: Int =>
        matrix += makeRow(rowId)
    }
    new Matrix(matrix.toArray)
  }
}

object Main extends App {
  private val a = Matrix("a", 2, 3)
  private val b = Matrix("b", 3, 2)
  private val c = Matrix("c", 3, 2)
  println(a)
  println(b)
  println(b + c)
  println(a * b)
  println(c * 3)
  println(b * a * 4)
  println(a(1, 1))
  println(a(2, 3))
  println(c(2, 1))
  println((b * a * 4)(3, 1))
}
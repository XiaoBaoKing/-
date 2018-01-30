/**
  * Created by yang on 2018/1/30.
  */
object main {
  def main(args: Array[String]): Unit = {
    val x = 1
    val x0 = 2
    val y = 2
    val y0 = 3
    val s0 = if (x > 0) 1 else 0
    println(s0) //1
    val s1 = if (x > 2) 1
    println(s1) //()

    val distance = {
      val dx = x - x0;
      val dy = y - y0;
      dx * dx + dy * dy
    }
    println(distance) //返回 dx * dx + dy * dy = 2

    println({
      val n = 1
    })
    //()
    var n = 5
    var r = 1
    while (n > 0) {
      r = r * n
      println(r)
      n -= 1
    }
    //    5
    //    20
    //    60
    //    120
    //    120
    for (i <- 1 to 10) println(i) //1,2,3....10

    val v = for (i <- 1 to 10)
      yield i % 3
    println(v)
    //Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
  }
}


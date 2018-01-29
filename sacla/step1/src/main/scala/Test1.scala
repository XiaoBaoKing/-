/**
  * Created by yang on 2018/1/29.
  */
object Test1 {
  def main(args: Array[String]): Unit = {
    // 不可变变量
    val answer = 8 * 5 + 3
    println(answer)
    //answer = 5 Error:(8, 12) reassignment to val

    //可变变量
    var message: String = "Hello "
    message += "world"
    println(message)

    //赋值
    val xmax, ymax = 100
    println("xmax = " + xmax.toString + ",ymax = " + ymax.toString)

    val ex = "Hello".intersect("world")
    println(ex) //lo

    println(1.to(10)) //Range 1 to 10
    println(2 to 10)  //Range 1 to 10
  }
}

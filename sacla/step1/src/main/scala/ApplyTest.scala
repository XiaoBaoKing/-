/**
  * Created by yang on 2018/1/29.
  */
object Test {
  def main(args: Array[String]): Unit = {
    val a = ApplyTest()
    a.haveTry()
    a()


  }
}

class ApplyTest{
  def apply() = {
    println("i'm class apply")
  }

  def haveTry() = {
    println("Hava a try on apply!")
  }
}

object ApplyTest {
  def apply() = {
    println("i'm object apply")
    new ApplyTest()
  }
}

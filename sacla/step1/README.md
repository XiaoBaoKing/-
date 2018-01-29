1.1、声明和变量
val answer = 8 * 5 + 2
以val定义的值实际上是一个常量，无法改变它的内容
var counter = 0
counter  = 1	//OK
以var 定义的变量是可变的变量

在scala中鼓励使用val——除非真的需要改变其内容。

我们不需要给出值或者变量的类型，这个信息可以从用来初始化它的表达式中推断出来。
不过在必要的时候，我们也可以指出类型。例如：
val greeting:String  =  null
val greeting:Any = "Hello"

我们可以将多个值或者变量放在一起声明：
val xmax,ymax = 100//将xmax和ymax设为100
val greeting,message:String = null 

1.2、常用类型
scala 也有7种数据类型:
Byte、Char、Short、Int、Long、Float、Double、Boolean
与JAVA不同的是这些类型是类，scala并不刻意区分基本类型和引用类型

1.3、算数和操作符重载
scala的算数操作符合JAVA中预期的效果预期一样：
val answer = 8 * 5 +3
\+ - * / % 等操作符完成的是它们通常的工作，位操作符 & | ^ >> << 也是如此。
只是有一点特别的：这些操作符实际上是方法。例如:
a + b  === a.+(b)
这里+是方法名
特别的scala 没有提供++或者--操作符，我们需要+=1 或-=1
因为Int类是不可变的

1.4、关于方法调用
"Hello".intersect("world") //得到lo 获取两个字符串中相同的部分
如果方法没有参数，我们并不需要使用括号
"Bonjour".sorted //Bjnooru

1.5、apply方法
apply方法类似于类的初始化方法，在遇到Object(参数1，参数2，......，参数n)时就会自动调用apply()方法。
Scala中的 apply 方法有着不同的含义, 对于函数来说该方法意味着调用function本身, 以下说明摘自Programming in Scala, 3rd Edition,在scala语言中, 函数也是对象, 每一个对象都是scala.FunctionN(1-22)的实例, 其中N是函数参数的数量。


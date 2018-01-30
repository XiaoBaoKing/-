2.1、条件表达式
scala的if/else语法结构和Java一样，不过，在scala中if/else表达式有值，这个值就是跟在if或者else之后的表达式的值
val s = if(x>0) 1 else -1

如果else部分缺失了，比如：
if(x>0) 1
那么有可能if语句没有交出任何值。但在scala中每个表达式都应该有某种值。这个问题的解决方案是引入一个Unit类，写作()。不带else的这个if语句等同于
if(x>0) 1 else ()

2.2、块表达式和赋值
{ }块包含一系列表达式，其结果也是一个表达式。块中最后一个表达式的值就是块值
这个特性对于某个val 的初始化需要分多步完成的情况很有用
val distance = {val dx = x- x0 ;val dy = y - y0;sqrt(dx*dx+dy*dy)}
{ }块的值取其最后一个表达式，变量dx和dy仅作为计算所需要的中间值，对程序的其他部分不可见。

在scala 中赋值动作本身没有值——更严格的说，它们的值是Unit类型的。
{r = r * n;n -= 1} //将返回Unit
x = y = 1 //别这样做 x的值会是Unit

2.3、循环
while
while(n > 0){
r = r * n
n -= 1
}
scala没有与for循环直接对应的结构。如果真的需要这样的循环有两种选择
1、while循环
2、使用如下for循环
for(i <- 1 to 10){
r = r * i
}
其中 for ( i <- 表达式)
让变量i遍历右边表达式的所有值

2.4、高级for循环
scala 中for 循环比Java中的功能丰富的多
我们可以以变量<-表达式的形式提供多个生成器，用分号将它们隔开。例如：
for(i<- 1 to 3;j<- 1 to 3)
print(f"$10 * i + j%3d")
//输出 11 12 13 21 22 23 31 32 33
每个生成器都可以带上守卫，一个以if开头的Boolean表达式
for(i<- 1 to 3 ; j<- 1to 3 if i!=j)
print(f"$10 * i + j%3d")
//输出 12 13 21 23 31 32
如果for 循环体以yield开始，则该循环会构造出一个集合，每次迭代生成集合中的一个值
for(i <- 1 to 10 )
yield i % 3
//输出 Vector(1,2,0,1,2,0.....)
生成的集合与第一个生成器的类型是兼容的

2.5、函数
要定义函数，我们需要给出函数的名称、参数和函数体
def abs(x:Double) = if(x>=0) x else -x
如果是递归函数，必须指定其返回值
def fac(n:Int):Int = if(n <= 0) 1 else fac(n -1)

2.6、变长参数
def sum(args : Int*) = {
var result = 0
for (arg <- args) result += arg
result
}
val s0 = sum(1,2,3,4)
val s1 = sum(1 to 4 :_*)

2.7、过程
scala 对于不返回值的函数有特别的写法
def box(s:String){
val border = "-" * (s.length +2)
print(f"$border%n|$s|%nborder%n")
}
这个写法相当于
def box(s:String):Unit={
....
}
2.8、懒值
当val被声明为lazy时，它的初始化将被推迟，直到我们首次对它取值。例如：
lazy val words = scala.io.Source.fromFile("/share/words").makeString
如果程序不访问words 那么这个文件不会被打开

我们可以把lazy 当做介于val 和def 的中间状态。
val words = scala.io.Source.fromFile("/share/words").makeString
//在words被定义时初始化
lazy val words = scala.io.Source.fromFile("/share/words").makeString
//在words被调用时初始化
def words = scala.io.Source.fromFile("/share/words").makeString
//每次words被使用时初始化

说明：懒值并没有额外开销。每次我们访问懒值时，都会有一个方法被调用，而这个方法会以线程安全的方式检查该值是否被初始化。

2.9、异常
val url = new URL("http://www.baidu.com")
try{
process(url)
}catch{
case _: MalformedURLException => print("Bad Url")
case ex:IOException => ex.printStackTrace()
}
注意：如果不需要使用捕获异常的对象，可以使用_来代替变量名





package com.returnnotfound.stain

fun main(args: Array<String>) {
  val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
  fruits.map {

  }
  for (x in 10..122 step 12) {

  }

  val map = mapOf("a" to 1, "b" to 2, "c" to "f")
  var abc: String? = "abc"

  val price = "${'$'} $$$\n9.// $99\\"

  val price2 = """
${'$'}9.99''\n ${"\n"}fdsf
"""
  println(price2)
  println(price)

  var aboonlean: Boolean? = null
  if (aboonlean == false) {
    print("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF")
  } else {
    println("FJDJFLDKJl")
  }

  test("2") { b: String, c: String ->
    "2"
  }

}
class Testq{
  val a: Int = 1
    get() = field
}

fun test(a: String, c: Int.(a: String, b: String) -> String) {
  c.invoke(2, "2", "abc")
}
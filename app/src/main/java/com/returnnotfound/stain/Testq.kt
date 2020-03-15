package com.returnnotfound.stain

import android.app.Activity
import kotlin.reflect.KClass

fun main(args: Array<String>) {
  val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
  fruits.map {

  }

  test("2") { b: String, c: String ->
    ""
    print(this)
    ""
  }
  var c: Double = 12.0
}

fun test(a: String, c: Double.(a: String, b: String) -> String) {
  c(2.0, "2", "abc")

  testClass(Activity::class.java, CharSequence::class)
}

fun testClass(classd: Class<out Any>, classcc: KClass<in String>) {

}
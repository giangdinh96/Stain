package com.returnnotfound.stain.base.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import com.returnnotfound.stain.base.utils.FontUtils
import java.util.*
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

class WatchView : View {
  private lateinit var paint: Paint
  private lateinit var paintNumberText: Paint
  private lateinit var paintHand: Paint
  private lateinit var paintHandSecond: Paint
  private var centerX: Float = 0f
  private var centerY: Float = 0f
  private var radius: Float = 0f
  private var isTouchCircle = false
  private var numberArr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

  //  var numberArr2 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"}
  private lateinit var gestureDetector: GestureDetector

  constructor(context: Context?) : super(context) {
    init(null)
  }

  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
    init(attrs)
  }

  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  ) {
    init(attrs)
  }

  private fun init(attrs: AttributeSet?) {
    gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
      override fun onLongPress(e: MotionEvent?) {
        super.onLongPress(e)
        if (e != null) {
          if (isTouchCircle(e.x, e.y)) {
            isTouchCircle = true
            paint.color = Color.RED
            paintNumberText.color = Color.RED
            postInvalidate()
          }
        }
      }
    })
    radius = 250f

    //paintPrimary
    paint = Paint(Paint.ANTI_ALIAS_FLAG)
    paint.color = Color.BLACK
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = 5f

    //paintNumberText
    paintNumberText = Paint(Paint.ANTI_ALIAS_FLAG)
    paintNumberText.textSize = 32f

    //paintHand
    paintHand = Paint(Paint.ANTI_ALIAS_FLAG)
    paintHand.color = Color.BLACK
    paintHand.strokeWidth = 5f

    //paintHandSecond
    paintHandSecond = Paint(Paint.ANTI_ALIAS_FLAG)
    paintHandSecond.color = Color.BLACK
    paintHandSecond.strokeWidth = 2f

    viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
      override fun onGlobalLayout() {
        viewTreeObserver.removeOnGlobalLayoutListener(this)
        centerX = width / 2.toFloat()
        centerY = height / 2.toFloat()
      }
    })
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    drawCenter(canvas)
    drawCircle(canvas)
    drawHand(canvas)
    drawHandMore(canvas)
    drawNumber(canvas)
  }

  private fun drawCircle(canvas: Canvas) {
    canvas.drawCircle(centerX, centerY, radius, paint)
  }

  private fun drawCenter(canvas: Canvas) {
    canvas.drawCircle(centerX, centerY, 1f, paint)
  }

  private fun drawHand(canvas: Canvas) {
    val calendar = Calendar.getInstance()
    val second = calendar.get(Calendar.SECOND)
    val minus = calendar.get(Calendar.MINUTE)
    val hour = calendar.get(Calendar.HOUR)

    // Second
    val angleSecond = (second / 60F) * 2 * Math.PI - Math.PI / 2
    val xSecond = centerX + cos(angleSecond) * 0.8 * radius
    val ySecond = centerY + sin(angleSecond) * 0.8 * radius
    canvas.drawLine(centerX, centerY, xSecond.toFloat(), ySecond.toFloat(), paintHandSecond)

    // Minus
    val angleMinus = (minus / 60F) * 2 * Math.PI - Math.PI / 2
    val xMinus = centerX + cos(angleMinus) * 0.8 * radius
    val yMinus = centerY + sin(angleMinus) * 0.8 * radius
    canvas.drawLine(centerX, centerY, xMinus.toFloat(), yMinus.toFloat(), paintHand)

    // Hour
    val angleHour = ((hour + minus / 60F) / 12F) * 2 * Math.PI - Math.PI / 2
    val xHour = centerX + cos(angleHour) * 0.5 * radius
    val yHour = centerY + sin(angleHour) * 0.5 * radius
    canvas.drawLine(centerX, centerY, xHour.toFloat(), yHour.toFloat(), paintHand)

    postInvalidateDelayed(500)
  }

  private fun drawHandMore(canvas: Canvas) {
    val perAngle = 2 * Math.PI / 60
    for (i in 1..60) {
      val angle = perAngle * i
      if (i % 5 == 0) {
        val x = centerX + cos(angle) * radius
        val y = centerY + sin(angle) * radius
        canvas.drawCircle(x.toFloat(), y.toFloat(), 8f, paint)
      } else {
        val x = centerX + cos(angle) * radius * 0.97f
        val y = centerY + sin(angle) * radius * 0.97f
        canvas.drawCircle(x.toFloat(), y.toFloat(), 1f, paint)
      }

    }
  }

  private fun drawNumber(canvas: Canvas) {
    val perAngle = Math.PI / 6
    for (i in numberArr) {
      val text = i.toString()
      val textRect = Rect()
      paintNumberText.typeface =
        FontUtils.get(
          context,
          "fonts/" + (if (i % 3 == 0) "BeVietnam-Bold" else "BeVietnam-Regular") + ".ttf"
        )
      paintNumberText.getTextBounds(text, 0, text.length, textRect)
      val angle = perAngle * (i - 3)
      val xText = cos(angle) * 1.2 * radius + centerX - textRect.width() / 2
      val yText = sin(angle) * 1.2 * radius + centerY + textRect.height() / 2
      canvas.drawText(text, xText.toFloat(), yText.toFloat(), paintNumberText)
    }
  }


  // Touch event
  override fun onTouchEvent(event: MotionEvent?): Boolean {
    val valueSuper = super.onTouchEvent(event)
    gestureDetector.onTouchEvent(event)
    when (event?.action) {
      MotionEvent.ACTION_DOWN -> {
        return true
      }

      MotionEvent.ACTION_UP -> {
        isTouchCircle = false
        paint.color = Color.BLACK
        paintNumberText.color = Color.BLACK
        postInvalidate()
        return false
      }

      MotionEvent.ACTION_MOVE -> {
        val x = event.x
        val y = event.y
        if (isTouchCircle) {
          centerX = x
          centerY = y
          postInvalidate()
        }
        return true
      }
      else -> {

      }
    }
    return valueSuper
  }

  private fun isTouchCircle(x: Float, y: Float): Boolean {
    val dx = (x - centerX).toDouble().pow(2)
    val dy = (y - centerY).toDouble().pow(2)
    return (dx + dy <= radius * radius)
  }
}
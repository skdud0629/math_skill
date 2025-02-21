    package com.refactoring_android.math_skill.core

    import android.content.Context
    import android.graphics.Canvas
    import android.graphics.Color
    import android.graphics.Paint
    import android.util.AttributeSet

    import android.view.View
    import androidx.core.content.ContextCompat

    class InputNumber @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
    ) : View(context, attrs, defStyleAttr) {
        private var redis: Int = 0
        private var fontSize: Int = 20
        private var number: Int = 1  // 표시할 숫자


        init{
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.InputNumber)
            redis = typedArray.getInteger(R.styleable.InputNumber_redis, 0)
            fontSize = typedArray.getInteger(R.styleable.InputNumber_fontSize, 30)
            typedArray.recycle() // ??이건 머지?
        }


        private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = ContextCompat.getColor(context, R.color.primaryColor)
            style = Paint.Style.FILL
        }

        private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.WHITE // 숫자 색상
            textSize = fontSize.toFloat()     // 숫자 크기
            textAlign = Paint.Align.CENTER
        }


        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            val radius = (width.coerceAtMost(height) / 2).toFloat()
            val centerX = width / 2f
            val centerY = height / 2f

            canvas.drawCircle(centerX, centerY, radius, circlePaint)

            val textOffsetY = (textPaint.descent() + textPaint.ascent()) / 2
            canvas.drawText(number.toString(), centerX, centerY - textOffsetY, textPaint)
        }
    }

package com.example.bankuish_technical_challenge.utils.helpers

import android.graphics.BlurMaskFilter
import android.graphics.BlurMaskFilter.Blur.NORMAL
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bankuish_technical_challenge.ui.theme.BtcPrimaryBlue
import com.example.bankuish_technical_challenge.ui.theme.BtcShadowColor

fun Modifier.shadow(
    intensity: Float = 1f,
    color: Color = BtcShadowColor,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
) = then(
    drawBehind {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            val blurRadius: Float = if (intensity == 1f)  0.01f else (1 - intensity) * 20
            if (intensity in 0f..1f) {
                frameworkPaint.maskFilter = BlurMaskFilter(blurRadius, NORMAL)
                frameworkPaint.color = color.toArgb()
                val startX = 0f + offsetX.toPx()
                val startY = 0f + offsetY.toPx()
                val rightPixel = size.width + offsetX.toPx()
                val bottomPixel = size.height + offsetY.toPx()

                canvas.drawPath(
                    path = Path().apply {
                        moveTo(startX, startY)
                        lineTo(rightPixel, startY)
                        lineTo(rightPixel, bottomPixel)
                        lineTo(startX, bottomPixel)
                        lineTo(startX, startY)
                    },
                    paint = paint
                )
            }
        }
    }
)

@Preview(showBackground = true)
@Composable
private fun ShadowPreview() {

    Column(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .shadow(
                    intensity = 0.5f,
                    offsetX = 4.dp,
                    offsetY = 4.dp
                )
                .background(BtcPrimaryBlue)
                .width(100.dp)
                .height(100.dp)
        ) { }
    }
}
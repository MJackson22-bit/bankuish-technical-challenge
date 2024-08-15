package com.example.bankuish_technical_challenge.utils.helpers

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.bankuish_technical_challenge.ui.theme.BtcDarkTextColor

fun TextStyle.Companion.btcText(
    size: TextUnit = 15.sp,
    color: Color = Color.White
) = TextStyle(fontSize = size, fontFamily = FontFamily.montserratSemiBold, color = color)

fun TextStyle.Companion.btcLightText(
    size: TextUnit = 13.sp,
    color: Color = BtcDarkTextColor
) = TextStyle(fontSize = size, fontFamily = FontFamily.montserratRegular, color = color)
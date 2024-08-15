package com.example.bankuish_technical_challenge.utils.helpers

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.bankuish_technical_challenge.ui.theme.BtcAccentBlue
import com.example.bankuish_technical_challenge.ui.theme.BtcDarkTextColor

fun TextStyle.Companion.mtcTitle(
    size: TextUnit = 25.sp,
    color: Color = Color.Black
) = TextStyle(fontSize = size, fontFamily = FontFamily.montserratBold, color = color)

fun TextStyle.Companion.mtcSubtitle(
    size: TextUnit = 20.sp,
    color: Color = Color.Black
) = TextStyle(fontSize = size, fontFamily = FontFamily.montserratRegular, color = color)

fun TextStyle.Companion.mtcText(
    size: TextUnit = 15.sp,
    color: Color = Color.White
) = TextStyle(fontSize = size, fontFamily = FontFamily.montserratSemiBold, color = color)

fun TextStyle.Companion.mtcLightText(
    size: TextUnit = 13.sp,
    color: Color = BtcDarkTextColor
) = TextStyle(fontSize = size, fontFamily = FontFamily.montserratRegular, color = color)

fun TextStyle.Companion.mtcMediumText(
    size: TextUnit = 13.sp,
    color: Color = BtcDarkTextColor
) = TextStyle(fontSize = size, fontFamily = FontFamily.montserratMedium, color = color)

fun TextStyle.Companion.mtcTextAccent(
    size: TextUnit = 15.sp,
    color: Color = BtcAccentBlue
) = TextStyle(fontSize = size, fontFamily = FontFamily.montserratSemiBold, color = color)

fun TextStyle.Companion.mtcButtonText(
    size: TextUnit = 14.sp,
    color: Color = Color.White
) = TextStyle(fontSize = size, fontFamily = FontFamily.montserratSemiBold, color = color)

fun TextStyle.Companion.mtcTabText(
    size: TextUnit = 17.sp,
    color: Color = Color.Black
) = TextStyle(fontSize = size, fontFamily = FontFamily.montserratRegular, color = color)
package org.example.project.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import composemultiplatformproject.composeapp.generated.resources.BonaNova_Bold
import composemultiplatformproject.composeapp.generated.resources.BonaNova_Regular
import composemultiplatformproject.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font


val bonaNovaSC
    @Composable get() = FontFamily(
        Font(Res.font.BonaNova_Bold, FontWeight.Bold),
        Font(Res.font.BonaNova_Regular, FontWeight.Normal),
    )

val Typography: Typography
    @Composable get() = Typography(
        headlineLarge = TextStyle(
            fontFamily = bonaNovaSC,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = bonaNovaSC,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        displaySmall = TextStyle(
            fontFamily = bonaNovaSC,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        ),
        labelMedium = TextStyle(
            fontFamily = bonaNovaSC,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
    )

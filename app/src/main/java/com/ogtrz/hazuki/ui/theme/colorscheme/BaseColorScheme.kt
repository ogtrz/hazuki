package com.ogtrz.hazuki.ui.theme.colorscheme

import androidx.compose.material3.ColorScheme

internal abstract class BaseColorScheme {
    abstract val darkScheme: ColorScheme
    abstract val lightScheme: ColorScheme

    fun getColorScheme(isDark: Boolean): ColorScheme {
        if (isDark) return darkScheme

        return lightScheme
    }
}
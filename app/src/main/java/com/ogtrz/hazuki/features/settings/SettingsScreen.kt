package com.ogtrz.hazuki.features.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ogtrz.hazuki.R
import com.ogtrz.hazuki.ui.components.AppBar

class SettingsScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                AppBar(
                    title = stringResource(R.string.label_settings),
                    onNavigationIconClick = {
                        navigator.pop()
                    }
                )
            }
        ) { padding ->
            Box(modifier = Modifier.Companion.padding(padding)) {
            }
        }
    }

}
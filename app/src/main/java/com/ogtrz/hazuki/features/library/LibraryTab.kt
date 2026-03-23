package com.ogtrz.hazuki.features.library

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.ogtrz.hazuki.R

object LibraryTab : Tab {
    override val options: TabOptions
        @Composable get() {
            val icon = rememberVectorPainter(ImageVector.vectorResource(R.drawable.library))
            val title = stringResource(R.string.label_library)
            return remember {
                TabOptions(index = 0u, title = title, icon = icon)
            }
        }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(topBar = { TopAppBar(title = { Text(stringResource(R.string.label_library)) }) }) { padding ->
            Box(Modifier.padding(padding)) {}
        }
    }
}
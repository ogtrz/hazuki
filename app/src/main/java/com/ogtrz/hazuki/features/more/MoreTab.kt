package com.ogtrz.hazuki.features.more

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.ogtrz.hazuki.R

object MoreTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(ImageVector.vectorResource(R.drawable.more))
            val title = stringResource(R.string.label_more)

            return remember {
                TabOptions(index = 3u, title = title, icon = icon)
            }
        }

    @Composable
    override fun Content() {
        MoreContent()
    }
}
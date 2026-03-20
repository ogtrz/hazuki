package com.ogtrz.hazuki.features.more

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
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
        Scaffold { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val name = stringResource(R.string.app_name)
                val version = stringResource(R.string.app_version)
                Text(
                    text = "$name v$version",
                    modifier = Modifier.padding(vertical = 24.dp)
                )
            }
        }

    }
}
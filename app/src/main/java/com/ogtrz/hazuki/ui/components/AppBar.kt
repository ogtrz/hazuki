package com.ogtrz.hazuki.ui.components

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import com.ogtrz.hazuki.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    subtitle: String? = null,
    navigationIcon: ImageVector? = null,
    onNavigationIconClick: (() -> Unit)? = null,
    actions: @Composable (RowScope.() -> Unit) = {},
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        modifier = modifier,
        title = { AppBarTitle(title = title, subtitle = subtitle) },
        actions = actions,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            onNavigationIconClick?.let {
                val icon = navigationIcon ?: ImageVector.vectorResource(R.drawable.arrow_back)

                IconButton(onClick = it) {
                    Icon(
                        icon,
                        contentDescription = "Back arrow"
                    )
                }
            }
        }
    )
}

@Composable
fun AppBarTitle(
    modifier: Modifier = Modifier,
    title: String? = null,
    subtitle: String? = null
) {
    Column(modifier = modifier) {
        title?.let {
            Text(
                text = it,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        subtitle?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.basicMarquee(
                    repeatDelayMillis = 2_000
                )
            )
        }
    }
}
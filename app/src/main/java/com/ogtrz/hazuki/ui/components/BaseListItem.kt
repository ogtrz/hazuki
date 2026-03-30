package com.ogtrz.hazuki.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun BaseListItem(
    modifier: Modifier = Modifier,
    headline: String? = null,
    headlineFontWeight: FontWeight = FontWeight.Normal,
    leadingContent: @Composable (() -> Unit)? = null,
    supportingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    ListItem(
        headlineContent = {
            if (!headline.isNullOrBlank()) {
                Text(
                    text = headline,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = headlineFontWeight,
                    ),
                    modifier = Modifier.padding(bottom = 2.dp)
                )
            }
        },
        leadingContent = leadingContent,
        supportingContent = supportingContent,
        trailingContent = trailingContent,
        modifier = modifier.clickable(enabled = onClick != null, onClick = { onClick?.invoke() })
    )
}

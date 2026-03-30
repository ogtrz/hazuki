package com.ogtrz.hazuki.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.ogtrz.hazuki.ui.theme.SECONDARY_TEXT_ALPHA

@Composable
fun TextListItem(
    modifier: Modifier = Modifier,
    title: String? = null,
    subtitle: String? = null,
    icon: ImageVector? = null,
    iconTint: Color = MaterialTheme.colorScheme.primary,
    trailingContent: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    BaseListItem(
        modifier = modifier,
        headline = title,
        leadingContent = if (icon != null) {
            {
                Icon(
                    modifier = Modifier.padding(end = 8.dp),
                    imageVector = icon,
                    tint = iconTint,
                    contentDescription = null
                )
            }
        } else null,
        supportingContent =
            if (!subtitle.isNullOrBlank()) {
                {
                    Text(
                        text = subtitle,
                        maxLines = 10,
                        style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface),
                        modifier = Modifier.alpha(SECONDARY_TEXT_ALPHA)
                    )
                }
            } else null,
        trailingContent = trailingContent,
        onClick = onClick
    )
}
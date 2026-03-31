package com.ogtrz.hazuki.features.more

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.ogtrz.hazuki.R
import com.ogtrz.hazuki.ui.components.TextListItem

@Composable
fun MoreContent(
    onClickAbout: () -> Unit
) {
    Scaffold { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            item {
                LogoHeader()
                HorizontalDivider()
                TextListItem(
                    title = stringResource(R.string.label_about),
                    icon = ImageVector.vectorResource(R.drawable.ic_info),
                    onClick = onClickAbout
                )
            }
        }
    }
}
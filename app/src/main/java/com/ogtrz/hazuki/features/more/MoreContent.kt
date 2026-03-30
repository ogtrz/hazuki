package com.ogtrz.hazuki.features.more

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.ogtrz.hazuki.R
import com.ogtrz.hazuki.ui.components.TextListItem

@Composable
fun MoreContent(
    onClickAbout: () -> Unit
) {
    Scaffold { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_launcher_monochrome),
                        contentDescription = null,
                        modifier = Modifier.size(152.dp)
                    )
                }
                HorizontalDivider()
                TextListItem(
                    title = stringResource(R.string.label_about),
                    icon = ImageVector.vectorResource(R.drawable.info),
                    onClick = onClickAbout
                )
            }
        }
    }
}
@file:OptIn(ExperimentalMaterial3Api::class)

package com.ogtrz.hazuki.features.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
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
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ogtrz.hazuki.R
import com.ogtrz.hazuki.ui.components.AppBar
import com.ogtrz.hazuki.ui.components.LinkIcon
import com.ogtrz.hazuki.ui.components.TextListItem

class AboutScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                AppBar(
                    title = stringResource(R.string.label_about),
                    onNavigationIconClick = { navigator.pop() }
                )
            }
        ) { padding ->
            LazyColumn(modifier = Modifier.padding(padding)) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_hazuki),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 56.dp)
                                .size(64.dp)
                        )
                    }
                }
                item { HorizontalDivider() }
                item {
                    TextListItem(
                        title = stringResource(R.string.version),
                        subtitle = stringResource(R.string.app_version)
                    )
                }
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        LinkIcon(
                            label = stringResource(R.string.website),
                            icon = ImageVector.vectorResource(R.drawable.ic_public),
                            url = "https://github.com/ogtrz/hazuki"
                        )
                    }
                }
            }
        }
    }
}
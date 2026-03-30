package com.ogtrz.hazuki.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.util.fastForEach
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.ogtrz.hazuki.features.browse.BrowseTab
import com.ogtrz.hazuki.features.history.HistoryTab
import com.ogtrz.hazuki.features.library.LibraryTab
import com.ogtrz.hazuki.features.more.MoreTab

object HomeScreen : Screen {
    private val TABS = listOf(
        LibraryTab,
        HistoryTab,
        BrowseTab,
        MoreTab
    )

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow;
        TabNavigator(LibraryTab) { tabNavigator ->
            CompositionLocalProvider(LocalNavigator provides navigator) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(), bottomBar = {
                        NavigationBar {
                            TABS.fastForEach {
                                TabNavigationItem(it)
                            }
                        }
                    }) { padding ->
                    Box(
                        modifier = Modifier
                            .padding(padding)
                            .consumeWindowInsets(padding)
                    ) {
                        CurrentTab()
                    }
                }
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(selected = tabNavigator.current == tab, onClick = {
        tabNavigator.current = tab
    }, label = { Text(tab.options.title) }, icon = {
        Icon(painter = tab.options.icon!!, contentDescription = tab.options.title)
    })
}

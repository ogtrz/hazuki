package com.ogtrz.hazuki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.ogtrz.hazuki.features.browse.BrowseTab
import com.ogtrz.hazuki.features.history.HistoryTab
import com.ogtrz.hazuki.features.library.LibraryTab
import com.ogtrz.hazuki.features.more.MoreTab
import com.ogtrz.hazuki.ui.theme.HazukiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            HazukiTheme {
                TabNavigator(LibraryTab) { tabNavigator ->
                    Scaffold(
                        modifier = Modifier.fillMaxSize(), bottomBar = {
                            NavigationBar {
                                TabNavigationItem(LibraryTab)
                                TabNavigationItem(HistoryTab)
                                TabNavigationItem(BrowseTab)
                                TabNavigationItem(MoreTab)
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
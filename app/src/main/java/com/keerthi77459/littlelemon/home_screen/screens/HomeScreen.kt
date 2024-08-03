package com.keerthi77459.littlelemon.home_screen.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.keerthi77459.littlelemon.home_screen.components.BuildHeroSection
import com.keerthi77459.littlelemon.home_screen.components.BuildMenuView
import com.keerthi77459.littlelemon.home_screen.components.BuildSelectionOption
import com.keerthi77459.littlelemon.home_screen.components.HomeScreenHeader
import com.keerthi77459.littlelemon.home_screen.data.AppDatabase
import com.keerthi77459.littlelemon.home_screen.data.MenuItemEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke

@Composable
fun HomeScreen(database: AppDatabase, navController: NavController) {

    val menuDao = database.menuDao()
    val menuItems = remember {
        mutableStateListOf<MenuItemEntity>()
    }
    val filteredItems = remember { mutableStateListOf<MenuItemEntity>() }
    var selectedCategory: String? by remember { mutableStateOf(null) }
    var searchQuery by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        (Dispatchers.IO){
            val items = menuDao.getAllMenuItems()
            menuItems.addAll(items)
            filteredItems.addAll(items)
        }
    }

    LaunchedEffect(selectedCategory) {
        filteredItems.clear()
        selectedCategory?.let { category ->
            filteredItems.addAll(menuItems.filter { it.category == category })
        } ?: run {
            filteredItems.addAll(menuItems)
        }
    }

    LaunchedEffect(searchQuery) {
        filteredItems.clear()
        filteredItems.addAll(menuItems.filter {
            it.name.contains(searchQuery, ignoreCase = true)
        })
    }

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
        ) {
            HomeScreenHeader(navController)
            BuildHeroSection(searchQuery) { query ->
                searchQuery = query
            }
            BuildSelectionOption(selectedCategory) { change ->
                selectedCategory = change
            }
            LazyColumn {
                items(filteredItems) { item ->
                    BuildMenuView(menuItem = item)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        AppDatabase.getDatabase(LocalContext.current),
        rememberNavController(),
    )
}
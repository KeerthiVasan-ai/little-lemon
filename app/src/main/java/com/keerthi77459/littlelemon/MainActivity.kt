package com.keerthi77459.littlelemon

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.keerthi77459.littlelemon.home_screen.data.AppDatabase
import com.keerthi77459.littlelemon.home_screen.data.DataRepository
import com.keerthi77459.littlelemon.home_screen.data.MenuItemEntity
import com.keerthi77459.littlelemon.navigation.NavigationRouteMap
import com.keerthi77459.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : ComponentActivity() {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }
    private lateinit var dataRepository: DataRepository
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val isLogin = getLoginData()
        database = AppDatabase.getDatabase(this)
        dataRepository = DataRepository(httpClient)

        lifecycleScope.launch {
            fetchMenuAndStore()
        }

        setContent {
            LittleLemonTheme {
                NavigationRouteMap(
                    database = database,
                    context = this,
                    isLogin = isLogin,
                )
            }
        }
    }

    private suspend fun fetchMenuAndStore() {
        val menuItems = dataRepository.fetchMenuItems()
        println("Entering")
        val menuEntities = menuItems.items.map {
            MenuItemEntity(
                id = it.id,
                name = it.title,
                description = it.description,
                price = it.price,
                image = it.image,
                category = it.category
            )
        }

        withContext(Dispatchers.IO) {
            println("Inserting")
            database.menuDao().insertMenuItems(menuEntities)
        }
    }

    private fun getLoginData(): Boolean {
        val sharedPref: SharedPreferences =
            getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE)
        val firstName = sharedPref.getString("first_name", null)
        val secondName = sharedPref.getString("last_name", null)
        val email = sharedPref.getString("email", null)

        return !(firstName.isNullOrEmpty() && secondName.isNullOrEmpty() && email.isNullOrEmpty())
    }
}
package com.example.budgetapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.budgetapplication.ui.theme.BudgetApplicationTheme
import com.example.budgetapplication.BottomNavigationBar
import com.example.budgetapplication.ExpenseIncomeDashboard
import com.example.budgetapplication.AddEntryScreen
import com.example.budgetapplication.AnalyticsScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetApplicationTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) {
                    Column(modifier = Modifier.padding(it)) {
                        NavHost(navController = navController, startDestination = "dashboard") {
                            composable("dashboard") { ExpenseIncomeDashboard() }
                            composable("add_entry") { AddEntryScreen() }
                            composable("analytics") { AnalyticsScreen() }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AppPreview() {
    BudgetApplicationTheme {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = { BottomNavigationBar(navController = navController) }
        ) {
            Column(modifier = Modifier.padding(it)) {
                NavHost(navController = navController, startDestination = "dashboard") {
                    composable("dashboard") { ExpenseIncomeDashboard() }
                    composable("add_entry") { AddEntryScreen() }
                    composable("analytics") { AnalyticsScreen() }
                }
            }
        }
    }
}
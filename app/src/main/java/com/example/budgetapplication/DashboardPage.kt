package com.example.budgetapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpenseIncomeDashboard() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Expense & Income Dashboard") },
                actions = {
                    IconButton(onClick = {  }) {
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            OverviewSection()
            Spacer(modifier = Modifier.height(16.dp))
            RecentTransactionsSection()
        }
    }
}

@Composable
fun OverviewSection() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        OverviewCard(title = "Total Expenses", amount = "$3,450")
        OverviewCard(title = "Total Incomes", amount = "$5,200")
        OverviewCard(title = "Balance", amount = "$1,750")
    }
}

@Composable
fun OverviewCard(title: String, amount: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.height(100.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            Text(text = amount, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun RecentTransactionsSection() {
    Text(
        text = "Recent Transactions",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(16.dp)
    )
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(4) { index ->
            TransactionCard(
                title = when (index) {
                    0 -> "Groceries"
                    1 -> "Salary"
                    2 -> "Gym Membership"
                    3 -> "Freelance"
                    else -> "Transaction"
                },
                description = when (index) {
                    0 -> "Supermarket"
                    1 -> "Monthly Pay"
                    2 -> "Fitness Center"
                    3 -> "Project Payment"
                    else -> "Details"
                },
                amount = when (index) {
                    0 -> "$75 - 10/14/2023"
                    1 -> "$3000 - 10/15/2023"
                    2 -> "$60 - 10/16/2023"
                    3 -> "$500 - 10/18/2023"
                    else -> "$0 - 00/00/0000"
                },
                isExpense = index % 2 == 0
            )
        }
    }
}

@Composable
fun TransactionCard(title: String, description: String, amount: String, isExpense: Boolean) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = description, fontSize = 14.sp, color = Color.Gray)
                Text(
                    text = amount,
                    fontSize = 14.sp,
                    color = if (isExpense) Color.Red else Color.Green
                )
            }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = if (isExpense) Color(0xFFEEEEFF) else Color(0xFFCCFFCC))
            ) {
                Text(text = if (isExpense) "Expense" else "Income")
            }
        }
    }
}

package com.example.catapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.catapp.ui.theme.screens.bmicalc.BMIcalcScreen
import com.example.catapp.ui.theme.screens.calculator.CalculatorScreen
import com.example.catapp.ui.theme.screens.home.HomeScreen
import com.example.catapp.ui.theme.screens.intents.IntentsScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUTE_HOME
){
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ){
        composable(ROUTE_HOME){
            HomeScreen(navController = navController)
        }
        composable(ROUTE_BMICALC){
            BMIcalcScreen(navController = navController)
        }
        composable(ROUTE_CALCULATOR){
            CalculatorScreen(navController = navController)
        }
        composable(ROUTE_INTENTS){
            IntentsScreen(navController = navController)
        }

    }

}
package com.example.laryssadomingos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource

import androidx.navigation.NavController
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "tela1"
    ) {

        composable("tela1") {
            Tela1(navController)
        }

        composable("tela2") {
            Tela2(navController)
        }
    }
}

@Composable
fun Tela1(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.imagem1),
            contentDescription = "Imagem 1",
            modifier = Modifier
                .size(200.dp)
                .clickable {
                    navController.navigate("tela2")
                }
        )
    }
}

@Composable
fun Tela2(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.imagem2),
            contentDescription = "Imagem 2",
            modifier = Modifier
                .size(200.dp)
                .clickable {
                    navController.navigate("tela1")
                }
        )
    }
}
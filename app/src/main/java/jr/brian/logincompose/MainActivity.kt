package jr.brian.logincompose

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jr.brian.logincompose.ui.theme.LoginComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppUI(applicationContext)
                }
            }
        }
    }
}

@Composable
fun AppUI(context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login_page", builder = {
        composable(
            "login_page",
            content = { LoginPage(navController = navController, context = context) })
        composable(
            "register_page",
            content = { RegistrationPage(navController = navController, context = context) })
    })
}
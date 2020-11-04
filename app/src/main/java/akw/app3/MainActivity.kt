package akw.app3

import akw.app3.ui.App3Theme
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App3Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                            topBar = {
                                TopAppBar(
                                        title = { Text("abc123") },
                                        navigationIcon = {
                                            IconButton(onClick = {}) {
                                                Icon(Icons.Filled.Menu)
                                            }
                                        }

                                )
                            },
                            bodyContent = { innerPadding ->
                                Greeting("Android")
                            },
                            floatingActionButton = { ExtendedFloatingActionButton(text = { Text("fab") }, onClick = {}) }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App3Theme {
        Greeting("Android")
    }
}
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
                    ScaffoldDemo()
                }
            }
        }
    }


}

@Composable
fun ScaffoldDemo() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = { Text("Drawer Content") },
            topBar = {
                TopAppBar(
                        title = { Text("abc123") },
                        navigationIcon = {
                            IconButton(onClick = { scaffoldState.drawerState.open() }) {
                                Icon(Icons.Filled.Menu)
                            }
                        }

                )
            },
            bodyContent = { innerPadding ->
                Text("Body Content")
            },
            floatingActionButton = { ExtendedFloatingActionButton(text = { Text("fab") }, onClick = {}) }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App3Theme {
        ScaffoldDemo()
    }
}
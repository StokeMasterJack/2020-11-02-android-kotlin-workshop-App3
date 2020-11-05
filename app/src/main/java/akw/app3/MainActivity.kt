package akw.app3

import akw.app3.ui.App3Theme
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
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
    val (rowCount, setRowCount) = remember { mutableStateOf(60) }
    Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {
                Column(modifier = Modifier.padding(all = 20.dp)) {
                    Text("Drawer Content")
                    Spacer(modifier = Modifier.preferredHeight(20.dp))
                    Button(onClick = {
                        setRowCount(rowCount - 20)
                        scaffoldState.drawerState.close()
                    }) {
                        Text("Reduce Item Count by 20")

                    }
                    Spacer(modifier = Modifier.preferredHeight(20.dp))
                    Button(onClick = {
                        setRowCount(rowCount + 20)
                        scaffoldState.drawerState.close()
                    }) {
                        Text("Increase Item Count by 20")
                    }
                }

            },
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
                ScrollableColumn(contentPadding = innerPadding,modifier = Modifier.padding(all = 5.dp)) {
                    repeat(rowCount) { Text("Row ${it+1}", modifier = Modifier.fillMaxWidth()) }
                }
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
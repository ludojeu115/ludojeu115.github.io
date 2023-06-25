import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainPage() {
        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())

            , horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Hello World!", color = Color.Red)
            Button(onClick = { println("Button clicked!") }) {
                Text("Click me!")
            }
            Button(onClick = { println("Button clicked!") }) {
                Text("Click me!")
            }
            Button(onClick = { println("Button clicked!") }) {
                Text("Click me!")
            }
            Button(onClick = { println("Button clicked!") }) {
                Text("Click me!")
            }
            Button(onClick = { println("Button clicked!") }) {
                Text("Click me!")
            }
            Button(onClick = { println("Button clicked!") }) {
                Text("Click me!")
            }
            Button(onClick = { println("Button clicked!") }) {
                Text("Click me!")
            }
            Button(onClick = { println("Button clicked!") }) {
                Text("Click me!")
            }
            Button(onClick = { println("Button clicked!") }) {
                Text("Click me!")
            }
        }
}
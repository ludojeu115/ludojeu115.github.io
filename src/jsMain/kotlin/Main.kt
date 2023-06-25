import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import org.jetbrains.compose.web.attributes.height
import org.jetbrains.compose.web.attributes.width
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.jetbrains.skiko.wasm.onWasmReady
fun main() {


    renderComposable(rootElementId = "root") {
        //Create canvas of size 600 400 with name ComposeTarget

        Header({classes("primary")}){//Portfolio
            Div({classes("Ludo","on-primary-text","title-medium")}){
                H1{ Text("Ludovic Lonlas") }
            }
            Div({classes("Infos","on-primary-text","title-small")}){
                H2{ Text("CV") }
                H2{ Text("Projets") }
                H2{ Text("Compétences") }
                H2{ Text("Formations") }
            }

        }
        Div({classes("blurred-picture")})
        Img(src = "images/Ludo.png",alt = "Photo de Ludovic Lonlas"){classes("picture")}

        Canvas({//Composable canvas
            width(600)
            height(400)
            id ("ComposeTarget")

        })

    }
    onWasmReady {//launch composable when wasm is ready
        Window {
            MainPage()
        }
    }
}


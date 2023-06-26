import androidx.compose.ui.window.Window
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.A
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

        Div({classes("Intro","primary-text","title-medium")}){
            H1{ Text("Salut !") }
            H4{ Text("  Je suis un jeune étudiant passionné d'informatique, actuellement en formation pour un master spécialisé dans l'image et la 3D ") }
            }
        Div({classes("CV","primary","on-primary-text","title-small")}) {
            H1 {
                Text("Pour voir mon CV c'est ")
                A("CV.html"){ Text("ICI") }
                Text(" !")
            }
        }
/*        Canvas({//Composable canvas
            width(600)
            height(400)
            id ("ComposeTarget")

        })*/

    }
    onWasmReady {//launch composable when wasm is ready
        Window {
            MainPage()
        }
    }
}


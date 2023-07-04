import androidx.compose.ui.window.Window
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.internal.runtime.ComposeWebInternalApi
import org.jetbrains.compose.web.renderComposable
import org.jetbrains.skiko.wasm.onWasmReady
fun main() {


    renderComposable(rootElementId = "root") {
        //Create canvas of size 600 400 with name ComposeTarget

        Header({classes("surface","on-surface-text")}){//Portfolio
            Div({classes("Ludo","title-medium")}){
                H1{ Text("Ludovic Lonlas") }
            }
            Div({classes("Infos","title-small")}){
                H2{ Text("CV") }
                H2{ Text("Projets") }
                H2{ Text("Compétences") }
                H2{ Text("Formations") }
            }

        }


            Div({ classes("blurred-picture") })

        Div({classes("big-div")}) {
            Img(src = "images/Ludo.png", alt = "Photo de Ludovic Lonlas") { classes("picture") }

            Div({ classes("Intro", "on-background-text", "title-large") }) {
                H1 { Text("Salut !") }
                H4 { Text("  Je suis un jeune étudiant passionné d'informatique, actuellement en formation pour un master spécialisé dans l'image et la 3D")
                    Br()
                    Text("Sur mon site vous trouverez les projets sur lesquels j'ai travaillé ainsi que les formations que j'ai suivi.") }
            }
        }
        Div({classes("Main","surface-variant","on-surface-variant-text")}) {



            Div({ classes("CV",  "title-small") }) {
                H1 {
                    Text("Pour voir mon CV c'est ")
                    A("CV.html") { Text("ICI") }
                    Text(" !")
                }
            }



            Post(
                titre = "Projet 2",
                description = "Description du projet 2",
                duree = "1 mois",
                membres = "1",
                images = {
                    Img(src = "images/projets/workshop-01.png", alt = "Mod vu depuis le workshop Steam")
                    Img(src = "images/projets/workshop-02.png", alt = "Image du mod en jeu")
                },
                attrs = {
                    classes("projet")
                }

            )

        }
/*        Canvas({//Composable canvas
            width(600)
            height(400)
            id ("ComposeTarget")

        })*/
        Footer {


            Text("© 2021 Ludovic Lonlas")
        }

    }
    onWasmReady {//launch composable when wasm is ready
        Window {
            MainPage()
        }
    }
}


import androidx.compose.ui.window.Window
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.A
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
                H2({classes("buttonCV")}){ Text("CV") }
                H2({classes("buttonProjets")}){ Text("Projets") }
                H2({classes("buttonComp")}){ Text("Compétences") }
                H2({classes("buttonForm")}){ Text("Formations") }
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
        Div({classes("Main","surface","on-surface-text")}) {



            Div({ classes("CV",  "body-large") }) {
                H1 { Text("CV") }
                P({classes("separator", "on-surface-variant" )}) { }

                H3({classes("text-container","surface-variant","on-surface-variant-text")})
                {
                    Text("Pour voir mon CV c'est ")
                    A("CV.html") { Text("ICI") }
                    Text(" !")
                    Br()
                    Text("Dernière mise à jour le 04/07/2023")
                }
            }


        Div ({ classes("Projets", "body-large") } )


            {
                H1 { Text("Projets") }
                P({classes("separator", "on-surface-variant")}) { }
            }
            Post(
                titre = "Mod pour Starbound",
                description = {
                    Text("C'est mon premier projet personnel . Il s'agit de un mod pour le jeu Starbound. " +
                            "Ce mod ajoute une nouvelle armure et de nouvelles armes et a été publié il y a environs 6 ans")
                              },
                duree = "2 jours",
                groupe = "1 personne",
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


import androidx.compose.ui.window.Window
import org.jetbrains.compose.web.attributes.height
import org.jetbrains.compose.web.attributes.width
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.renderComposable
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {


    renderComposable(rootElementId = "root") {
        //Create canvas of size 600 400 with name ComposeTarget

        Header({ classes("surface", "on-surface-text") }) {//Portfolio
            Div({ classes("Ludo", "title-medium") }) {
                H1 { Text("Ludovic Lonlas") }
            }
            Div({ classes("Infos", "title-small") }) {
                H2({ classes("buttonCV") }) { Text("CV") }
                H2({ classes("buttonProjets") }) { Text("Projets") }
                H2({ classes("buttonComp") }) { Text("Compétences") }
                H2({ classes("buttonForm") }) { Text("Formations") }
            }

        }


        Div({ classes("blurred-picture") })

        Div({ classes("big-div") }) {
            Img(src = "images/Ludo.png", alt = "Photo de Ludovic Lonlas") { classes("picture") }

            Div({ classes("Intro", "on-background-text", "title-large") }) {
                H1 { Text("Salut !") }
                H4 {
                    Text("  Je suis un jeune étudiant passionné d'informatique, actuellement en formation pour un master spécialisé dans l'image et la 3D")
                    Br()
                    Text("Sur mon site vous trouverez les projets sur lesquels j'ai travaillé ainsi que les formations que j'ai suivi.")
                }
            }
        }
        Div({ classes("Main", "surface", "on-surface-text") }) {


            Div({ classes("CV", "body-large") }) {
                H1 { Text("CV") }
                P({ classes("separator", "on-surface-variant") }) { }

                H3({ classes("text-container", "surface-variant", "on-surface-variant-text") })
                {
                    Text("Pour voir mon CV c'est ")
                    A("CV.html") { Text("ICI") }
                    Text(" !")
                    Br()
                    Text("Dernière mise à jour le 04/07/2023")
                }
            }


            Div({ classes("Projets", "body-large") })


            {
                H1 { Text("Projets") }
                P({ classes("separator", "on-surface-variant") }) { }
            }

            Post(
                titre = "Mod pour Starbound",
                description = {
                    P {
                        Text(
                            "Il y a environs 6 ans j'ai créer un mod pour le jeu Starbound, il s'agit de mon premier projet personnel ." +
                                    "Dans un premier temps le mod devait juste rajouter une armure, rajouté un objet au jeu se fait en utilisant du"
                        )
                        B { Text(" JSON") }
                        Text(". En cherchant les fichiers du jeu j'ai découvert que le jeu utilisait du ")
                        B { Text("LUA") }
                        Text(" pour les scripts, j'ai donc décidé de faire un mod plus complet.")
                    }
                },
                duree = "2 jours",
                groupe = "1 personne",
                tech = "LUA, JSON, Workshop Steam",
                lien = "https://steamcommunity.com/sharedfiles/filedetails/?id=747556858",
                nomduLien = "Lien vers le workshop Steam",
                images = {
                    Img(src = "images/projets/workshop-01.png", alt = "Mod vu depuis le workshop Steam")
                    Img(src = "images/projets/workshop-02.png", alt = "Image du mod en jeu")
                },
                attrs = {
                    classes("projet")
                }

            )
            Post(
                titre = "Importer/Exporter modèles 3D au format MD3 dans blender",
                description = {
                    P {
                        Text(
                            "Je souhaitais créer des modèles 3D pour un jeu auquel je jouais, cependant le format de fichier qui est le format MD3 n'est pas pris en charge par blender."
                        )
                        Br()
                        Text(
                            "J'ai donc créer un addon pour blender qui permet d'importer et d'exporter des modèles au format MD3." +
                                    "Le format MD3 fut créer pour le jeu Quake 3 Arena, mais il est aussi utilisé par d'autres jeux comme Jedi Knight 2."
                        )
                        Br()
                        Text("On peut retrouver la documentation du format MD3 ")
                        A(href = "https://icculus.org/~phaethon/q3a/formats/md3format.html#:~:text=MD3%20is%20the%203D%20data,%2C%20and%2For%20the%20environment.") {
                            Text(
                                "ICI"
                            )
                        }
                    }
                },
                duree = "1 mois",
                groupe = "1 personne",
                tech = "Python, Blender",
                lien = "https://github.com/ludojeu115/MD3-blender-addon",
                nomduLien = "Code Source",
                images = {
                    Img(src = "images/projets/md3-01.jpg", alt = "Importer dans blender")
                    Img(src = "images/projets/md3-02.jpg", alt = "Shape keys Fonctionnels dans blender")
                    Img(src = "images/projets/md3-03.jpg", alt = "Modèle créer dans blender")
                    Img(src = "images/projets/md3-04.jpg", alt = "Modèle exporté visible dans le jeu")

                },
                attrs = {
                    classes("projet")
                }

            )
            Post(
                titre = "Bot discord de blind test musical et de téléchargement de musique",
                description = {
                    P {
                        Text(
                            "J'ai repris le code source de "
                        )
                        A(href = "https://github.com/GroovyGab/lavalink-music-bot") { Text("GroovyGab") }
                        Text(" et j'y ai ajouté les fonctionnalités qu'il manquais au bot pour qu'il fonctionne comme je le souhaitais. J'ai aussi rajouté la possibilité de faire des blind test (jeu où il faut trouver le titre d'une musique) et le bot peut aussi télécharger des musiques et les mets sur un serveur web.")
                        Br()
                    }
                    Canvas({//Composable canvas
                        width(600)
                        height(400)
                        id ("ComposeTarget")

                    })
                },
                duree = "3 semaines",
                groupe = "1 personne",
                tech = "NodeJS, DiscordJS, Lavalink, YT-DLP, Sapphire Framework",

                images = {
                    Img(src = "images/projets/discord-01.png", alt = "Exemple Blind Test")
                    Img(src = "images/projets/discord-02.png", alt = "Exemple téléchargement de musique")

                },
                attrs = {
                    classes("projet")
                }

            )
        }
               Canvas({//Composable canvas
/*                    width(600)
                    height(400)*/
                    id ("ComposeTarget")

                })
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


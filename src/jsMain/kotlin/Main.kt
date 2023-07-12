import androidx.compose.ui.window.Window
import org.jetbrains.compose.web.attributes.height
import org.jetbrains.compose.web.attributes.width
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.renderComposable
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {


    renderComposable(rootElementId = "root") {

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
            Div({                    style {
                property("height", "20vw")
                property("max-height", "15em")
                property("flex-grow", "0")
            }}){
                Img(src = "images/Ludo.png", alt = "Photo de Ludovic Lonlas") { classes("picture") }


            }

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
                    A("CV.pdf") { Text("ICI") }
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
            Post(
                titre = "Application Android",
                description = {

                    P {
                        Text(
                            "Lors d'un projet scolaire, un collègue et moi avons créer une application Android qui permet de proposer et de postuler à des offres d'emploi, J'ai été chargé de réalisé l'interface utilisateur."
                        )
                        Br()
                        Text("Pour réaliser l'interface j'ai utilisé Jetpack Compose. L'avantage de compose est qu'il est multiplateforme, il est possible de l'utiliser pour créer des applications Android, des applications IOS et des applications web(beta)." +
                                "De plus on peut utiliser Material3 Design qui nous permet de faire des applications plus jolies, sur android 12 on peu faire correspondre le thème avec les couleurs du système .")
                        Br()
                        Br()
                        Text("Voici un exemple interactif de ce que j'ai réalisé ( il utilise le même code que l'application android ):")

                    }
                    Canvas({//Composable canvas
                        width(400)
                        height(300)
                        id ("ComposeTarget")
                        classes("android")

                    })
                },
                duree = "2 mois",
                groupe = "2 personne",
                tech = "Kotlin, Jetpack Compose, Android Studio, Material3 Design",

                images = {
                    Img(src = "images/projets/mobile-01.jpg", alt = "Login avec un thème personnalisé")
                    Img(src = "images/projets/mobile-02.jpg", alt = "Login avec un autre thème personnalisé")
                    Img(src = "images/projets/mobile-03.jpg", alt = "Login avec thème sombre")

                },
                attrs = {
                    classes("projet")
                }

            )
            Post(
                titre = "Application de rendu par lancé de rayons en C++",
                description = {

                    P {
                        Text(
                            "Le plus gros projet de ma première année de master. J'ai réalisé une application de rendu par lancé de rayons en C++ avec l'aide des librairies  "
                        )

                        A(href = "https://github.com/nothings/stb") { Text("stb_image.h ") }
                        Text(", ")
                        A(href = "https://github.com/assimp/assimp") { Text("Assimp ") }
                        Text("et ")
                        A(href = "https://www.glfw.org/") { Text("GLFW ") }

                        Br()
                        Text("L'application posséde beaucoup de fonctionnalités, notamment :")
                        Ul {
                            Li {
                                Text("L'importation de modèles 3D et de textures")
                                }
                            Li {
                                Text("Rendu en multi-thread")
                            }
                            Li {
                                Text("Affichage des pixels rendus en temps réel")
                            }
                            Li {
                                Text("Utilisation d'un KD-Tree pour accélérer le rendu")
                            }
                            Li {
                                Text("Reflexion, réfraction, caustics, transparence, ombres dures et douces, textures diffuses")
                            }
                        }


                    }

                },
                duree = "4 mois",
                groupe = "1 personne",
                tech = "C++, OpenGl, GLFW, Assimp, stb_image.h, WSL 2",

                images = {
                    Img(src = "images/projets/3D-01.png", alt = "Modèle simple importé et rendu")
                    Img(src = "images/projets/3D-02.png", alt = "Rendu en temps réel")
                    Img(src = "images/projets/3D-03.png", alt = "Rendu d'une scène complexe ")

                },
                attrs = {
                    classes("projet")
                }

            )

        }

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


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeViewport
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.renderComposable
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {


    renderComposable(rootElementId = "root") {

        Header({ classes("surface") }) {//Portfolio
            Div({ classes("Ludo", "title-medium") }) {
                Img(src = "images/logoweb.png",
                            alt = "Identité visuelle de Ludovic Lonlas",
                            attrs = {style {
                                height(3.em)
                            }})
                H1({style{
                    marginLeft(0.5.em)
                    }}) { Text("Ludovic ")}    
                H1({style{
                    property("color", "var(--md-sys-color-primary)")
                    marginLeft(0.5.em)
                    }}){Text(" Lonlas") }
            }
            Div({ classes("Infos", "title-small") }) {
                H2({ classes("buttonCV") }) { Text("CV") }
                H2({ classes("buttonProjets") }) { Text("Projets") }
                H2({ classes("buttonForm") }) { Text("Formations") }
            }
            Div({ classes("Ludo") })

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

            Div({ classes("Intro", "display-large") }) {
                H2({style{
                    property("color", "var(--md-sys-color-primary)")
                    }}) { Text("Salut !") }
            }
        }
        Div({ classes("display-large") }) {

                H6({style{
                    textAlign("center")
                    margin(2.em)
                    lineHeight(1.5.em)
                    }
                    
                    }) {
                    Text("  Je suis un jeune ex-étudiant passionné d'informatique, actuellement en formation pour un master spécialisé dans l'image et la 3D")
                    Br()
                    Br()
                    Text("Sur mon site vous trouverez les projets sur lesquels j'ai travaillé ainsi que les formations que j'ai suivies.")
                }
            }
        Div({ classes("Main") }) {

            Div({ classes("CVHEAD","headline-medium") }){H1 { Text("CV") }}
            Div({ classes("CV","Projet","body-large") }) {
                
                H3()
                {
                    Text("Pour voir mon CV c'est ")
                    A("CV.pdf") { Text("ICI") }
                    Text(" !")
                }
                H5{
                    Text("Dernière mise à jour le 22/04/2025")
                }
            }


            Div({ classes("Projets", "headline-medium") }){
                H1 { Text("Projets") }
                P({ classes("separator") }) { }
            }

            Div({ classes("Projects-list") }) {
                Experience(
                    titre = "Réalisation d'une application de visualisation",
                    description = {

                        P {
                            Text("Durant mon stage de fin d'étude, j'ai été chargé de la réalisation d'une application de visualisation des données propriétaires de l'entreprise qui m'a accueilli.")
                            Br()
                            Text("J'ai travaillé avec mon encadrant et le chef du département pour réalisé l'application selon les demandes établies chaque semaines.")
                            Br()
                            Text("L'application permet de mieux visualiser les données de positionnement et de rotations de pilotes de moto et cavaliers.")
                            Br()
                            Br()
                            Text("L'application contient les fonctionnalités suivantes :")
                            Ul {
                                Li {
                                    Text("Importation des données propriétaires de l'entreprise et création de configurations de chargement")
                                }
                                Li {
                                    Text("Rendu de route conforme a la trajectoire du pilote ou à OpenStreetMap")
                                }
                                Li {
                                    Text("Contrôles temporelle avancé ( Ralenti, Saut dans le temps, synchronisation vidéo/multi moto )")
                                }
                                Li {
                                    Text("Interpretation des rotation en utilisant l'algorithme de Mahony")
                                }
                                Li {
                                    Text("Animations équestres réalisées à la main, Animation procédurale de la moto et du pilote ")
                                }
                                Li {
                                    Text("Optimisations permettant à l'application de fonctionner sur une page web.")
                                }
                            }
                        }

                    },
                    duree = "6 mois",
                    groupe = "3 personnes",
                    tech = "Unity, OpenStreetMap, C#, Blender, IK, Mahony, Unity Shaders, CSV",
                    images = {
                        Img(src = "images/projets/job/FinishedProduct.png", alt = "L'application Fini")
                        Img(src = "images/projets/job/Road.png", alt = "Segmentation du mesh de la route pour une meilleur optimisation")
                        Img(src = "images/projets/job/Replays.png", alt = "Visualisation de multiples pilotes")
                        Img(src = "images/projets/job/ModelRigging.png", alt = "Rigging d'un modèle de moto pour l'utilisation dans l'application")

                    }

                )
                Experience(
                    titre = "Jeu en réalité virtuelle",
                    description = {

                        P {
                            Text("Durant la seconde année de mon master, nous avions pour projet la réalisation d'un jeu en ")
                            B { Text("réalité augmenté.") }
                            Br()
                            Br()
                            Text("Ayant d'autres projets plus complexe en parallèle, le jeu fut réalisé pendant 2 sprints d'un jour chacun après une période de réflection et la réalisation du ")
                            A(href = "ProjectVR_GDD_LONLAS_Ludovic.pdf") { Text("GDD.") }
                        }

                    },
                    duree = "1 mois",
                    groupe = "1 personne",
                    tech = "Unity, Oculus Quest 2, C#, Visual shaders, VR Toolkit, Blender",
                    lien = "https://github.com/ludojeu115/StereoCook",
                    nomduLien = "Code Source",
                    images = {
                        Iframe({
                            attr("src","https://www.youtube-nocookie.com/embed/TXPFmlUS9nk?si=kjmFWeNMnyJgGIJz")
                            attr("title","YouTube video player")
                            attr("frameborder","0")
                            attr("allow","accelerometer")
                            attr("width","560")
                            attr("height","315")
                            attr("clipboard-write","")
                            attr("encrypted-media","")
                            attr("gyroscope","")
                            attr("picture-in-picture","")
                            attr("web-share","")
                            attr("allowfullscreen","")
                            attr("referrerpolicy","strict-origin-when-cross-origin")
                        })
                        Img(src = "images/projets/VR/1.png", alt = "Zone de jeu")
                        Img(src = "images/projets/VR/2.png", alt = "système de cuisson")
                        Img(src = "images/projets/VR/3.png", alt = "Empilage des aliments")
                    }

                )
                Experience(
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
                            Br()
                            Text("L'application possède beaucoup de fonctionnalités, notamment :")
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

                            Text("Pour mieux comprendre les fonctionnalités et le développement de l'application, vous pouvez lire les rapports de projet :")
                            Br()
                            A("Prog3d-1.pdf") { Text("Première partie") }
                            Br()
                            A("Prog3d-2.pdf") { Text("Deuxième partie") }
                            Br()
                            A("Prog3d-3.pdf") { Text("Troisième partie") }


                        }

                    },
                    duree = "4 mois",
                    groupe = "1 personne",
                    tech = "C++, OpenGl, GLFW, Assimp, stb_image.h, WSL 2",

                    images = {
                        Img(src = "images/projets/3D-01.png", alt = "Modèle simple importé et rendu")
                        Img(src = "images/projets/3D-02.png", alt = "Rendu en temps réel")
                        Img(src = "images/projets/3D-03.png", alt = "Rendu d'une scène complexe ")

                    }
                )
                Experience(
                    titre = "Cette page web",
                    description = {

                        P {
                            Text("Pour réaliser cette page web, je voulais utiliser ")
                            B { Text("Compose") }
                            Text(" pour avoir accès au même composable que ceux de la version android, cependant ")
                            B {
                                Text(
                                    "Compose pour le web"
                                )
                            }
                            Text(
                                " ne possède pas les mêmes composables que Compose Multiplatform" +
                                        ", il est quand même possible d'intégrer des composables android via un canvas.  "
                            )
                            Br()
                            Text("J'utilise aussi ")
                            B { Text("jQuery") }
                            Text(" avec compose pour utiliser un afficheur d'image interactif et pour naviguer la page à l'aide de boutons.")
                            Br()
                            Br()
                            Text(
                                "J'ai remarqué que créer une page web en utilisant compose est plus compliqué qu'en utilisant html," +
                                        " cependant compose permet d'avoir un meilleur contrôle de la page et de pouvoir réutiliser le code, " +
                                        "ce qui est très utile pour les pages web avec beaucoup de contenu."
                            )
                        }

                    },
                    duree = "2 mois",
                    groupe = "1 personne",
                    tech = "Kotlin, Gradle, Jetpack Compose, Compose for web, Github pages, Github actions, Material3 Design, jQuery",
                    lien = "https://github.com/ludojeu115/ludojeu115.github.io",
                    nomduLien = "Code Source",
                    images = {
                        Img(src = "images/projets/page-01.jpg", alt = "Composable des projets")
                        Img(src = "images/projets/page-02.jpg", alt = "Afficheur d'image interactif en plein écran")
                        Img(src = "images/projets/page-03.jpg", alt = "utilisation de l'afficheur d'image interactif")
                        Img(src = "images/projets/page-04.jpg", alt = "Code de la page web de ce projet")
                        Img(src = "images/projets/page-05.jpg", alt = "Github actions pour déployer la page web sur Github pages")
                    }
                )

                Experience(
                    titre = "Prototype d'application Android",
                    description = {

                        P {
                            Text(
                                "Lors d'un projet universitaire et en collaboration avec un collègue, nous avons créé une application Android qui permet de proposer et de postuler à des offres d'emploi. J'ai été chargé de réaliser l'interface utilisateur."
                            )
                            Br()
                            Text(
                                "Pour réaliser l'interface j'ai utilisé Kotlin et Jetpack Compose. L'avantage de compose est qu'il est multiplateforme, il est possible de l'utiliser pour créer des applications Android, des applications IOS et des applications web(beta)." +
                                        "De plus nous avons implémenté Material3 Design qui nous permet de faire des applications plus sobres et esthétiques, sur android 12+ les couleurs de l'applications sont contrôlées par le système ."
                            )
                            Br()
                            Br()
                            Text("Voici un exemple interactif de ce que j'ai réalisé ( il utilise le même code que l'application android ):")

                        }
                        Div({//Composable canvas
                            style {
                                width(400.px)
                                height(300.px)
                            }

                            id("ComposeTarget")
                            classes("android")

                        })

                    },
                    duree = "2 mois",
                    groupe = "2 personne",
                    tech = "Kotlin, Jetpack Compose, Android Studio, Material3 Design",
                    lien = "https://gitlab.com/doctor.dalek66/projet-android",
                    nomduLien = "Code Source",
                    images = {
                        Img(src = "images/projets/mobile-01.jpg", alt = "Login avec un thème personnalisé")
                        Img(src = "images/projets/mobile-02.jpg", alt = "Login avec un autre thème personnalisé")
                        Img(src = "images/projets/mobile-03.jpg", alt = "Login avec thème sombre")

                    }
                )
                Experience(
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
                    }
                )
                Experience(
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

                    }
                )
                Experience(
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

                    }
                )
            }

            Div({classes("FormationTitle", "headline-medium")}){
                H1 { Text("Formations") }
                P({ classes("separator") }) { }
            }
            Div({ classes("Projects-list") }) 
            {
                Formation(
                    nom = "Baccalauréat Général Scientifique",
                    lieu = "Lycée Paul Sabatier, Carcassonne",
                    duree = "2015 - 2018",
                    images = {
                        Img(src = "images/formation/Academie_de_Montpellier.svg",
                            alt = "Identité visuelle de l'académie de Montpellier",
                            attrs = {style {
                                height(8.em)
                            }})
                    }
                )
                Formation(
                    nom = "Licence informatique",
                    lieu = "Faculté des sciences, Montpellier",
                    duree = "2018 - 2022",
                    images = {
                        Img(src = "images/formation/logo_fds.jpg",
                            alt = "Identité visuelle de la faculté des sciences",
                            attrs = {style {
                                height(4.em)
                            }})
                        Img(src = "images/formation/logo_um_2022_rouge_RVB.svg",
                            alt = "Identité visuelle de l'université de Montpellier",
                            attrs = {style {
                                height(4.em)
                            }})
                    }
                )
                Formation(
                    nom = "Master Informatique - Imagine",
                    lieu = "Faculté des sciences, Montpellier",
                    duree = "2022 - 2024",
                    images = {
                        Img(src = "images/formation/logo_fds.jpg",
                            alt = "Identité visuelle de la faculté des sciences",
                            attrs = {style {
                                height(4.em)
                            }})
                        Img(src = "images/formation/logo_um_2022_rouge_RVB.svg",
                            alt = "Identité visuelle de l'université de Montpellier",
                            attrs = {style {
                                height(4.em)
                            }})
                    }
                )
            }           
        }

        Footer {
            Div({style{
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)

            }}){
                H4{Text("Contact")}
                P{Text("Email : ")
                A(href = "mailto: ludovic.lonlas@etu.umontpellier.fr",{style { property("color","inherit") }}) { Text("ludovic.lonlas@etu.umontpellier.fr") }}
                Br()
                Br()
                P {
                    Text("LinkedIn : ")
                    A(href = "https://www.linkedin.com/in/ludovic-lonlas-358692180/",
                        { style { property("color", "inherit") } }) { Text("Ludovic Lonlas") }
                }
            }

            H3{Text("© 2021 Ludovic Lonlas")}
            Div({style{
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
            }}){
                H4{Text("Autres sites")}
                P {
                    Text("Github : ")
                    A(href = "https://github.com/ludojeu115",{style { property("color","inherit") }}) { Text("Github") }
                }
                Br()

            }

        }

    }
    onWasmReady {//launch composable when wasm is ready
        ComposeViewport("ComposeTarget") {
            Box(
                modifier = Modifier.fillMaxSize().background(androidx.compose.ui.graphics.Color(29, 32, 36))
            )
            {
                MainPage()
            }
        }
    }
}


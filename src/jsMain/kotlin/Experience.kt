import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.attributes.height
import org.jetbrains.compose.web.attributes.width
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

@Composable
fun Experience(
    titre: String,
    description: ContentBuilder<HTMLDivElement>? = null,
    duree: String = "",
    groupe: String = "",
    tech: String = "",
    lien: String = "",
    nomduLien: String = "",
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    images: ContentBuilder<HTMLDivElement>? = null
) {


    Div(attrs = {
        if (attrs != null) apply(attrs)
        classes("Projet")
    }) {

        H1({style {
            alignItems(AlignItems.Center)
            textAlign("center")
        }}) {
            Text(titre)
        }
        Div({ classes("post-content", "body-large") }) {

                if (images != null) Div({
                    classes("imgviewer")
                    style {
                        property("float", "right")
                        property("height", "10em")
                    }
                }) {
                    images()
                }
                if (description != null) description()



        }
        Div({ classes("post-footer", "label-large" ) }) {
            if (lien != "") {
                A(href = lien ,{
                    classes("button")
                }) {
                    Text(nomduLien)
                }
            }
            H5 { Text("Durée : $duree") }
            H5 { Text("Groupe : $groupe") }
            H5 { Text("technologies utilisées : $tech")}
        }
    }
}
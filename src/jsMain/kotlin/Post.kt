import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

@Composable
fun Post(
    titre: String,
    description: ContentBuilder<HTMLDivElement>? = null,
    duree: String = "",
    groupe: String = "",
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    images: ContentBuilder<HTMLDivElement>? = null
) {


    Div(attrs = {
        if (attrs != null) apply(attrs)
        classes("post", "surface-variant", "on-surface-variant-text")
    }) {

        H1 {
            Text(titre)
        }
        Div({ classes("post-content") }) {
            P {
                if (images != null) Div({
                    classes("imgviewer")
                    style {
                        property("float", "right")
                        property("height", "10em")
                        property("margin-right", "2em")
                    }
                }) {
                    images()
                }
                if (description != null) description()


            }
        }
        Div({ classes("post-footer","on-surface-variant-text" ) }) {
            H5 { Text("Durée : $duree") }
            H5 { Text("Groupe : $groupe") }
        }
    }
}
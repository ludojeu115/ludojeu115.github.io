import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.internal.runtime.ComposeWebInternalApi
import org.w3c.dom.HTMLDivElement

@Composable
fun Post(
    titre: String,
    description: String = "",
    duree: String = "",
    membres: String = "",
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    images: ContentBuilder<HTMLDivElement>? = null
) {


    Div(attrs = {
        if (attrs != null) apply(attrs)
        classes("post", "secondary", "on-secondary-text")
    }) {

        H1 {
            Text(titre)
        }
        Div({ classes("post-content") }) {
            H3 {
                Text(description)
                Div({
                    classes("imgviewer")
                    style {
                        property("float", "right")
                        property("height", "10em")
                    }
                }) {
                    if (images != null) images()

                }

            }
        }
        Div({ classes("post-footer") }) {
            H5 { Text("Durée : $duree") }
            H5 { Text("Membres : $membres") }
        }
    }
}
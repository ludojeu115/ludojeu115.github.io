import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.attributes.height
import org.jetbrains.compose.web.attributes.width
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

@Composable
fun Formation(
    nom: String,
    lieu: String = "",
    duree: String = "",
    images: ContentBuilder<HTMLDivElement>? = null,
    attrs: AttrBuilderContext<HTMLDivElement>? = null
) {


    Div(attrs = {
        if (attrs != null) apply(attrs)
        classes("Formation", "body-medium")
        style { width ( 80.percent )
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            justifyContent(JustifyContent.SpaceBetween)
            alignItems(AlignItems.Center)
            flexWrap(FlexWrap.Wrap)
            gap(1.em)
            }
        }
    ) 
    {
        Div() {
            H1{ Text("$nom") }
            P { Text("$lieu") }
            P { Text("$duree") }
        }

        Div({style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            justifyContent(JustifyContent.SpaceBetween)
            alignItems(AlignItems.Center)
            flexWrap(FlexWrap.Wrap)
            gap(1.em)
        }})
        {
            if (images != null) images()
        }
    }
}
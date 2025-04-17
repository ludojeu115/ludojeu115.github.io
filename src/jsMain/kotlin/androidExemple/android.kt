package androidExemple
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import portfolio.generated.resources.*
import org.jetbrains.compose.resources.painterResource
/// What the Chercheur sees


@Composable
fun AnnonceChercheur(
    modifier: Modifier = Modifier,
    isOpenAtLaunch: Boolean = false,
    titreAnnonce: String = "Titre de l'annonce",
    annonceImage: String = "images/Ludo.png",
    entreprise: String = "Entreprise",
    lieu: String = "Lieu",
    jobOffer: JobOffer,
    tempsDeTravail: String = "Non renseigné",
    contrat: String = "Non renseigné",
    description: String = "Description",
    onAnnonceShare: (JobOffer) -> Unit = { _ -> },
    onAnnoncePostuler: (JobOffer) -> Unit = { _ -> },

    ) {
    val transitionSpeed = 500
    var AnnonceState by remember { mutableStateOf(isOpenAtLaunch) }
    val opened by animateFloatAsState(
        targetValue = if (AnnonceState) 1f else 0f,
        tween(durationMillis = transitionSpeed)
    )
    //debug print le nom de l'entreprise

    ElevatedCard(
        modifier = modifier
            .padding(14.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = titreAnnonce, modifier = Modifier.fillMaxWidth(), /// Title
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Left,
                maxLines = 1
            )
            Divider(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),         /// Image + Entreprise + Lieu + Temps de travail + Contrat
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp),
                    painter = painterResource(resource = Res.drawable.Ludo),
                    contentDescription = "Image de l'annonce",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))

                Column(                                                   /// Entreprise + Lieu + Temps de travail + Contrat
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text( /// nom de l'entreprise
                        text = entreprise, modifier = modifier.padding(2.dp),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Left,
                        maxLines = 1
                    )
                    Text( /// lieu
                        text = lieu, modifier = modifier.padding(2.dp),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Left,
                        maxLines = 1
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text( /// temps de travail
                            text = tempsDeTravail,
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Center,
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text( /// contrat
                            text = contrat,
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Center,
                            maxLines = 1
                        )
                    }
                }

            }

            /// Transition between states
            AnimatedVisibility(
                visible = AnnonceState,
                enter = expandIn(
                    expandFrom = Alignment.TopCenter,
                    animationSpec = tween(durationMillis = transitionSpeed)
                ) { fullSize ->
                    IntSize(fullSize.width, 0)
                },
                exit = shrinkOut(
                    shrinkTowards = Alignment.TopCenter,
                    animationSpec = tween(durationMillis = transitionSpeed)
                ) { fullSize ->
                    IntSize(fullSize.width, 0)
                }

            ) {

                Column(modifier = Modifier.fillMaxWidth()) {       /// description + share and postulate

                    Divider(
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
/// Description
                        text = description, modifier = Modifier.fillMaxWidth(), /// Description
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Left,
                    )
                    Spacer(modifier = Modifier.height(8.dp))/// Postulate
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) { /// Share and postulate
                        Button(modifier = Modifier.height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = MaterialTheme.colorScheme.onSecondary
                            ), onClick = { onAnnoncePostuler(jobOffer) }) {

                            Text(
                                text = "Postuler",
                                style = MaterialTheme.typography.labelMedium,
                                textAlign = TextAlign.Center,
                                maxLines = 1
                            )
                        }
                        Button(modifier = Modifier.height(50.dp), /// Share
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                            ), onClick = { onAnnonceShare(jobOffer) }) {

                            Image(
                                painter = painterResource(resource = Res.drawable.share),
                                contentDescription = "Partager l'annonce",
                                modifier = Modifier.size(24.dp)
                            )
                            Text(
                                text = "Partager",
                                style = MaterialTheme.typography.labelMedium,
                                textAlign = TextAlign.Center,
                                maxLines = 1
                            )
                        }
                    }
                }

            }


            Image(
                /// Open and close button
                painter = painterResource(resource = Res.drawable.expand),
                contentDescription = "Ouvrir l'annonce",
                modifier = Modifier
                    .clickable(onClick = { AnnonceState = !AnnonceState })
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .height(24.dp)
                    .rotate(opened * 180f),


            )

        }
    }
}

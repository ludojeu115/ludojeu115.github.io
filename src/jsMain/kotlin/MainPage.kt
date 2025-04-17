import androidExemple.AnnonceChercheur
import androidExemple.JobOffer
import androidExemple.ui.theme.AppTheme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun MainPage(modifier: Modifier = Modifier) {
    val jobOffer = JobOffer()
    AppTheme() {
        AnnonceChercheur(jobOffer = jobOffer, modifier = modifier)
    }
}
import androidExemple.AnnonceChercheur
import androidExemple.JobOffer
import androidExemple.ui.theme.AppTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainPage() {
    var jobOffer = JobOffer()
    AppTheme(darkTheme = false) {
        AnnonceChercheur(jobOffer = jobOffer)
    }




}
@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.primerinterfaz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.primerinterfaz.ui.theme.PrimerInterfazTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimerInterfazTheme() {
                    MyApp(imagenes = listOf(R.drawable.paisajedamian, R.drawable.paisajejeje))
            }
        }
    }
}
@Composable
fun Login(onContinueClicked: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ahorasi),
            contentDescription = "Logo",
            modifier = Modifier.size(300.dp)
        )
        SimpleOutlinedTextFieldSample()
        Text("¿Has olvidado la contraseña?")
        Button (onClick = { onContinueClicked() }, modifier = Modifier.padding(8.dp) ) {
            Text("Login")
        }
    }
}
@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    imagenes: List<Int> = List(2){
              R.drawable.paisajedamian
              R.drawable.paisajejeje}

){
    var shouldShowOnboarding = rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboarding.value) {
        Login(onContinueClicked = { shouldShowOnboarding.value = false })
    } else {
            SegundaPantalla(modifier = modifier, imagenes)
    }
}
@Composable
fun ForPublicaciones(modifier: Modifier = Modifier, imagenes: List<Int>) {
    LazyColumn(modifier = modifier
        .padding(vertical = 4.dp)
        .background(MaterialTheme.colorScheme.background)) {
        items(items = imagenes) { imagen ->
            Publicaciones(modifier,imagen)
        }
    }
}
@Composable
fun Publicaciones(modifier: Modifier = Modifier,imagen: Int) {
    Column(
    ) {
        Image(
            painter = painterResource(id = imagen),
            contentDescription = "Logo",
            modifier = Modifier.size(400.dp)
        )
        Row {
            Image(
                painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                contentDescription = "Corazon"
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_mode_comment_24),
                contentDescription = "Comentario"
            )
                Image(
                    painter = painterResource(id = R.drawable.baseline_save_alt_24),
                    contentDescription = "Favorito"
                )
        }
        Text("Le ha gustado a Lady, Jowy y 20 personas más")
        Text("Rodrigo - Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed dp eiusmod tempor incididunt ut labore et dolore magna aliqua")
    }
}
@Composable
fun SegundaPantalla(modifier :Modifier = Modifier,imagenes: List<Int>) {
    //Historias
    Column {
        Row() {


            Box(
                modifier = Modifier
                    .padding(15.dp)
                    .clip(CircleShape)
                    .size(90.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.persona1),
                    contentDescription = "Historia1",
                )
            }
            Box(
                modifier = Modifier
                    .padding(15.dp)
                    .clip(CircleShape)
                    .size(90.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.persona2),
                    contentDescription = "Historia2",
                )
            }
            Box(
                modifier = Modifier
                    .padding(15.dp)
                    .clip(CircleShape)
                    .size(90.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.persona3),
                    contentDescription = "Logo",
                )
            }
        }
        ForPublicaciones(modifier, imagenes)
    }

}

@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Usuario")},
        modifier = Modifier.padding(10.dp)
    )
    var password by rememberSaveable { mutableStateOf("") }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Contraseña") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}







package com.example.etanolougasolina


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.etanolougasolina.ui.theme.EtanolOuGasolinaTheme
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.mutableFloatStateOf


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EtanolOuGasolinaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
            AppEtanolOuGasolina()
                }


            }
        }
    }
}

@Composable
@Preview (showBackground = true)
fun AppEtanolOuGasolina() {
    TextBoxesAndTitles(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize())

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextBoxesAndTitles(modifier: Modifier = Modifier){
    var valorEtanol by rememberSaveable { mutableStateOf("") }
    var valorGasolina by rememberSaveable { mutableStateOf("") }
    var efyRatio by rememberSaveable { mutableFloatStateOf(70f) }

    Column(modifier = modifier,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Este aplicativo vai lhe ajudar a escolher entre abastecer com etanol ou gasolina",
            textAlign = TextAlign.Left,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .padding(bottom = 20.dp)
                .padding(horizontal = 26.dp))
        Text(
            text = "- Abaixo, digite os valores dos combustíveis e selecione a eficiência do etanol para seu motor.",
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .padding(horizontal = 26.dp)
        )

        OutlinedTextField(
            value = valorGasolina,
            onValueChange = { valorGasolina = it },
            label = {Text(
                "Valor da Gasolina",
                fontFamily = FontFamily.Monospace,
            )},
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(horizontal = 26.dp)
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = valorEtanol,
            onValueChange = { valorEtanol = it },
            label = {Text(
                "Valor do Etanol",
                fontFamily = FontFamily.Monospace,
            )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Monospace,
            ),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(horizontal = 26.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Eficiencia do Etanol: ${efyRatio.toInt()}%",
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .padding(horizontal = 40.dp)
        )
        GradientSlider(
            value = efyRatio,
            onValueChange = { efyRatio = it },
            valueRange = 70f..80f ,
            modifier = Modifier.padding(horizontal = 40.dp),
            trackHeight = 12.dp,
            thumbRadius = 12.dp
        )
        Text(etanolOuGasolina(valorEtanol, valorGasolina, efyRatio/100))

    }
}


fun etanolOuGasolina(valorEtanol: String, valorGasolina: String, efyRatio: Float): String {
    val etanol = valorEtanol.replace(',', '.').toFloatOrNull()
    val gasolina = valorGasolina.replace(',', '.').toFloatOrNull()
    if (etanol == null || gasolina == null) {
        return "Preencha valores válidos (ex.: 4.80)."
    }
    if (etanol <= 0f || gasolina <= 0f) {
        return "Preços devem ser maiores que zero."
    }
    return if (etanol / gasolina <= efyRatio) {
        "Você deve abastecer com Etanol"
    }
    else {
        "Você deve abastecer com Gasolina"
    }
}


@Composable
fun GradientSlider(
    modifier: Modifier = Modifier,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>,
    trackHeight: Dp = 12.dp,
    thumbRadius: Dp = 12.dp
){
    Box (modifier = modifier) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(thumbRadius * 2)
                .pointerInput(Unit) {
                    detectDragGestures { change, _ ->
                        val width = size.width
                        val newValue =
                            (change.position.x / width) * (valueRange.endInclusive - valueRange.start) + valueRange.start
                        onValueChange(newValue.coerceIn(valueRange))
                    }
                }
        ){
            val width = size.width
            val height = size.height
            val thumbOffsetX = (value - valueRange.start) / (valueRange.endInclusive - valueRange.start) * width
            drawLine(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color(0xFFFFC107), Color(0xFF00FF02))),
                start = Offset (x = 0f, y = height / 2),
                end = Offset (x = width, y = height / 2),
                strokeWidth = trackHeight.toPx(),
                cap = StrokeCap.Round
            )
            drawCircle(
                color = Color.White,
                radius = thumbRadius.toPx(),
                center = Offset(x = thumbOffsetX.coerceIn(0f, width), y = height / 2),
                )
            drawCircle(
                color = Color.Gray,
                radius = trackHeight.toPx(),
                center = Offset(x = thumbOffsetX.coerceIn(0f, width), y = height / 2),
                style = Stroke(width = 1.dp.toPx()))
        }
    }
}
package com.example.custommodifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.custommodifier.ui.theme.CustomModifierTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomModifierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

/**
 * Criando Modifiers customizados que customizaram layouts
 */

@Composable
fun MainScreen() {
    // utilizando custom modifier
    /*Box(
        Modifier.size(120.dp, 80.dp)
    ) {
        ColorBox(
            Modifier.exampleLayoutCustom(90, 50)
                .background(Color.Red)
        )
    }*/
    // utilizando modificadores em linha
    Box(
        Modifier.size(120.dp, 80.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            ColorBox(
                Modifier
                    .exampleLayout(0.0f)
                    .background(Color.Blue)
            )

            ColorBox(
                Modifier
                    .exampleLayout(0.25f)
                    .background(Color.Green)
            )

            ColorBox(
                Modifier
                    .exampleLayout(0.5f)
                    .background(Color.Yellow)
            )

            ColorBox(
                Modifier
                    .exampleLayout(0.25f)
                    .background(Color.Red)
            )

            ColorBox(
                Modifier
                    .exampleLayout(0.0f)
                    .background(Color.Magenta)
            )
        }
    }
}

@Composable
private fun ColorBox(modifier: Modifier) {
    Box(
        modifier = modifier
            .padding(1.dp)
            .size(50.dp, 10.dp)
            .then(modifier)
    )
}

// Layout trabalhado com linhas de alinhamento
fun Modifier.exampleLayout(fraction: Float) = layout {measurable, constraints ->
    val placeable = measurable.measure(constraints)
    val x = -(placeable.width * fraction).roundToInt()
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x, 0)
    }
}

// layout trbalhado com modificador customizado
fun Modifier.exampleLayoutCustom(x: Int, y: Int) = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x, y)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomModifierTheme {
        MainScreen()
    }
}
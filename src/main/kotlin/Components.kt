import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonConstants
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SideOption(text: String, imageBitmap: ImageBitmap, index: Int, state: MutableState<Int>) {
    val activeColor = Color(192, 27, 54)
    val inactiveColor = Color(42, 39, 41)
    val isActive = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = if (isActive.value) Color(86, 82, 85) else inactiveColor)
            .pointerMoveFilter(
                onEnter = {
                    isActive.value = true
                    false
                },
                onExit = {
                    isActive.value = false
                    false
                }
            )
            .clickable(onClick = { state.value = index })
    ) {
        Row {
            Box(
                modifier = Modifier
                    .background(color = if (state.value == index) activeColor else inactiveColor)
                    .width(10.dp)
                    .fillMaxHeight()
            )
            Image(
                bitmap = imageBitmap,
                modifier = Modifier.padding(start = 15.dp).align(Alignment.CenterVertically)
            )
            Text(text = text, color = Color.White, modifier = Modifier.padding(start = 15.dp).align(Alignment.CenterVertically))
        }
    }
}

@Composable
fun OrderNowButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        modifier = modifier,
        colors = ButtonConstants.defaultButtonColors(backgroundColor = Color(187, 163, 0)),
        shape = RectangleShape,
        contentPadding = ButtonConstants.DefaultTextContentPadding.copy(top = 4.dp, bottom = 4.dp)
    ) {
        Text(
            text = "Order now",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun CollectionItem(modifier: Modifier = Modifier, image: String, price: Int, name: String) {
    Box(modifier = modifier.width(160.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 10.dp)) {
            Image(bitmap = imageFromResource("img/$image"))
            Text(text = name, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(51, 51, 51))
            OrderNowButton(Modifier.fillMaxWidth().padding(top = 10.dp))
        }
        Box(modifier = Modifier.padding(start = 120.dp), contentAlignment = Alignment.Center) {
            Image(bitmap = imageFromResource("img/price.png"))
            Text(text = "$$price", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun CollectionContent() {
    Box(
        modifier = Modifier
            .padding(start = 180.dp, top = 110.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            CollectionItem(image = "01.png", name = "FRIT Ravich", price = 25)
            CollectionItem(image = "02.png", name = "Condia", price = 15)
            CollectionItem(image = "03.png", name = "Weber", price = 25)
            CollectionItem(image = "04.png", name = "Solabiol", price = 35)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun HomeContent() {
    Box(
        modifier = Modifier
            .padding(start = 180.dp, top = 110.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.padding(start = 48.dp, end = 48.dp),
            horizontalArrangement = Arrangement.spacedBy(56.dp)
        ) {
            Column(modifier = Modifier.width(300.dp)) {
                AnimatedVisibility(
                    visible = true,
                    enter = slideIn(
                        { IntOffset(-600, 0) },
                        tween(delayMillis = 12, easing = LinearEasing)
                    ),
                    initiallyVisible = false
                ) {
                    Text(
                        text = "Only",
                        color = Color(255, 153, 0),
                        fontSize = TextUnit.Sp(12),
                        fontWeight = FontWeight.Bold
                    )
                }

                AnimatedVisibility(
                    visible = true,
                    enter = slideIn(
                        { IntOffset(-500, 0) },
                        tween(delayMillis = 12, easing = LinearEasing)
                    ),
                    initiallyVisible = false
                ) {
                    Text(
                        text = "$25",
                        color = Color(255, 153, 0),
                        fontSize = TextUnit.Sp(70),
                        fontWeight = FontWeight.Bold
                    )
                }

                AnimatedVisibility(
                    visible = true,
                    enter = slideIn(
                        { IntOffset(-200, 0) },
                        tween(delayMillis = 12, easing = LinearEasing)
                    ),
                    initiallyVisible = false
                ) {
                    Text(
                        text = "FRIT RAVICH",
                        color = Color(187, 187, 187),
                        fontSize = TextUnit.Sp(36)
                    )
                }

                AnimatedVisibility(
                    visible = true,
                    enter = slideIn(
                        { IntOffset(-300, 0) },
                        tween(delayMillis = 12, easing = LinearEasing)
                    ),
                    initiallyVisible = false
                ) {
                    Text(
                        text = "On sait depuis longtemps que travailler",
                        modifier = Modifier.padding(bottom = 18.dp),
                        color = Color(102, 102, 102),
                        fontSize = TextUnit.Sp(16)
                    )
                }

                AnimatedVisibility(
                    visible = true,
                    enter = slideIn(
                        { IntOffset(-320, 0) },
                        tween(delayMillis = 12, easing = LinearEasing)
                    ),
                    initiallyVisible = false
                ) {
                    Text(
                        text = "On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. L'avantage du Lorem Ipsum sur un texte générique comme 'Du texte.",
                        color = Color(102, 102, 102),
                        fontSize = TextUnit.Sp(12)
                    )
                }

                AnimatedVisibility(
                    visible = true,
                    enter = slideIn(
                        { IntOffset(-550, 0) },
                        tween(delayMillis = 12, easing = LinearEasing)
                    ),
                    initiallyVisible = false
                ) {
                    OrderNowButton(modifier = Modifier.width(220.dp).padding(top = 16.dp))
                }
            }
            AnimatedVisibility(
                visible = true,
                enter = slideIn(
                    { IntOffset(800, 0) },
                    tween(delayMillis = 12, easing = LinearEasing)
                ),
                initiallyVisible = false
            ) {
                Image(
                    bitmap = imageFromResource("img/001.png"),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}

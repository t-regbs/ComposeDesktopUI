
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.desktop.AppManager
import androidx.compose.desktop.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
fun main() = Window(size = IntSize(900, 550), centered = true, undecorated = true) {
    Box(modifier = Modifier.fillMaxSize()) {
        val clicked: MutableState<Int> = remember { mutableStateOf(0) }
        when (clicked.value) {
            0 -> {
                HomeContent()
            }
            1 -> {
                CollectionContent()
            }
        }
        Box(
            modifier = Modifier
                .background(color = Color(42, 39, 41))
                .fillMaxHeight()
                .fillMaxWidth(0.2f)
        ) {
            Column(modifier = Modifier.padding(top = 70.dp)) {
                SideOption(
                    text = "Home",
                    imageBitmap = imageFromResource("img/home.png"),
                    index = 0,
                    state = clicked
                )
                SideOption(
                    text = "Collection",
                    imageBitmap = imageFromResource("img/009.png"),
                    index = 1,
                    state = clicked
                )
                SideOption(
                    text = "Delivery",
                    imageBitmap = imageFromResource("img/delivery.png"),
                    index = 2,
                    state = clicked
                )
                SideOption(
                    text = "Search",
                    imageBitmap = imageFromResource("img/002_1.png"),
                    index = 3,
                    state = clicked
                )
                SideOption(
                    text = "Statistics",
                    imageBitmap = imageFromResource("img/007.png"),
                    index = 4,
                    state = clicked
                )
                SideOption(
                    text = "Help",
                    imageBitmap = imageFromResource("img/006.png"),
                    index = 5,
                    state = clicked
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(start = 180.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .background(color = Color(192, 27, 54))
                        .fillMaxWidth()
                        .height(10.dp)
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .padding(start = 30.dp)
                            .background(color = Color(192, 27, 54))
                            .height(105.dp)
                            .width(105.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(bitmap = imageFromResource("img/logo.png"))
                            Text(text = "Products", color = Color.White)
                        }
                    }
                    Row(
                        modifier = Modifier.padding(top = 20.dp, start = 480.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(bitmap = imageFromResource("img/notif.png"))
                        Image(bitmap = imageFromResource("img/008.png"), modifier = Modifier.padding(start = 10.dp))
                        Image(
                            bitmap = imageFromResource("img/closing.png"),
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .clickable(onClick = { AppManager.focusedWindow?.close() })
                        )
                    }
                }
            }
        }
    }
}

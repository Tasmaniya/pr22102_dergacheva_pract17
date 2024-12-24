package com.example.pr22102_dergacheva_pract17
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pr22102_dergacheva_pract17.ui.theme.Pr22102_dergacheva_pract17Theme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pr22102_dergacheva_pract17Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "LoadingScreen") {
        composable(route = "LoadingScreen") { LoadingScreen(navController) }
        composable(route = "SignIn") { SignIn(navController) }
        composable(route = "SignUp") { SignUp(navController) }
        composable(route = "StartScreen") { StartScreen(navController) }
        composable(route = "History") { History(navController) }
        composable(route = "Settings") { Settings(navController) }
    }
}
@Composable
fun LoadingScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(1000)
        navController.navigate("SignIn")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.fon),
                contentDescription = null,
                modifier = Modifier.fillMaxSize().align(Alignment.CenterStart),
                colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply{setToScale(0.15f, 0.15f, 0.15f, 1f)}),
                contentScale = ContentScale.Crop
            )
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.fon1),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center).size(128.dp)
            )
        }
    }

}
@Composable
fun SignIn(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Фон с изображением
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.auto),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().graphicsLayer(alpha = 0.6f),
            contentScale = ContentScale.Crop,
        )

        // Градиентный фон
        Box(
            modifier = Modifier.fillMaxSize().background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.White.copy(alpha = 1f)),
                    startY = 0f,
                    endY = 1100f
                )
            )
        ) {
            var text by remember { mutableStateOf("") }

            // Поля для ввода
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("login") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 43.dp, vertical = 300.dp)
                    .clip(RoundedCornerShape(30.dp)),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    unfocusedTextColor = Color(0x009aaaaa),
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color(0x009aaaaa),
                ),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.login), contentDescription = null, modifier = Modifier.size(15.dp))
                }
            )

            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 43.dp, vertical = 370.dp)
                    .clip(RoundedCornerShape(30.dp)),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    unfocusedTextColor = Color(0x009aaaaa),
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color(0x009aaaaa),
                ),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.password), contentDescription = null, modifier = Modifier.size(15.dp))
                }
            )
        }
        // Кнопка "Forgot Password?"
        TextButton(
            onClick = {},
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 500.dp)
        ) {
            Text(text = "Forgot Password?", color = Color.Black)
        }

        // Основная кнопка
        Button(
            onClick = { navController.navigate("StartScreen")},
            colors = ButtonDefaults.buttonColors(containerColor = Color(red = 0x3f, green = 0x42, blue = 0x5c, alpha = 0xFF)),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 550.dp, start = 43.dp, end = 43.dp)
        ) {
            Text(
                text = "SIGN IN",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        // Кнопка "Create A New Account?"
        TextButton(
            onClick = { navController.navigate("SignUp")},
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 600.dp)
        ) {
            Text(text = "Create A New Account?", color = Color.Black)
        }
    }
}
@Composable
fun SignUp(navController: NavController) { //сделать чтобы при записи пароля вводилось * такими штуками
    Box(modifier = Modifier.fillMaxSize()) {
        // Фон с изображением
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.auto),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().graphicsLayer(alpha = 0.6f),
            contentScale = ContentScale.Crop,
        )

        // Градиентный фон
        Box(
            modifier = Modifier.fillMaxSize().background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.White.copy(alpha = 1f)),
                    startY = 0f,
                    endY = 1100f
                )
            )
        ) {
            var text by remember { mutableStateOf("") }

            // login
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("login") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 43.dp, vertical = 300.dp)
                    .clip(RoundedCornerShape(30.dp)),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    unfocusedTextColor = Color(0x009aaaaa),
                    focusedContainerColor = Color.White
                ),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.login), contentDescription = null, modifier = Modifier.size(15.dp))
                }
            )
            //email
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("login@mail.ru") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 43.dp, vertical = 370.dp)
                    .clip(RoundedCornerShape(30.dp)),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    unfocusedTextColor = Color(0x009aaaaa),
                    focusedContainerColor = Color.White
                ),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.mail), contentDescription = null, modifier = Modifier.size(15.dp))
                }
            )
            //password
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(top = 440.dp, start = 43.dp, end = 43.dp)
                    .clip(RoundedCornerShape(30.dp)),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    unfocusedTextColor = Color(0x009aaaaa),
                    focusedContainerColor = Color.White
                ),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.password), contentDescription = null, modifier = Modifier.size(15.dp))
                }
            )
            //password 2
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("repeat password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(top = 510.dp, start = 43.dp, end = 43.dp)
                    .clip(RoundedCornerShape(30.dp)),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    unfocusedTextColor = Color(0x009aaaaa),
                    focusedContainerColor = Color.White
                ),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.password), contentDescription = null, modifier = Modifier.size(15.dp))
                }
            )
            // Основная кнопка
            Button(
                onClick = { navController.navigate("StartScreen")},
                colors = ButtonDefaults.buttonColors(containerColor = Color(red = 0x3f, green = 0x42, blue = 0x5c, alpha = 0xFF)),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(top = 580.dp, start = 43.dp, end = 43.dp)
            ) {
                Text(
                    text = "SIGN IN",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
@Composable
fun StartScreen(navController: NavController){
    //карта
    var isMenuOpen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.Builder()
                .target(LatLng(55.044026, 82.917393)) // Задайте координаты
                .zoom(10f)
                .build()
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = remember { MarkerState(position = LatLng(55.044026, 82.917393)) },
                title = "San Francisco",
                snippet = "Marker in San Francisco"
            )
        }
        // Кнопка меню
        IconButton(
            onClick = {isMenuOpen=true},
            modifier = Modifier
                .padding(top = 40.dp, start = 20.dp)
                .align(Alignment.TopStart)
                .size(55.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Menu",
                modifier = Modifier.size(60.dp)
            )
        }
        // Меню
        AnimatedVisibility(visible = isMenuOpen) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(300.dp)
                    .background(Color(red = 0x2a, green = 0x2e, blue = 0x43, alpha = 0xFF))
                    .align(Alignment.CenterStart)
                    .padding(top=100.dp, start=30.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    // Содержимое меню с отступами
                    Image(
                        painter = painterResource(id = R.drawable.foto), // Замените на ваш ресурс
                        contentDescription = "Circular Image",
                        modifier = Modifier
                            .size(65.dp) // Укажите размер изображения
                            .clip(CircleShape) // Примените круглый клип
                            .border(3.dp, Color.White, CircleShape) // (опционально) добавление границы
                        //.padding(vertical = 15.dp)
                    )
                    // Кнопка "History"
                    Box(modifier = Modifier.padding(top = 30.dp, start = 10.dp)) {
                        TextButton(onClick = {navController.navigate("History")}) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = R.drawable.history),
                                    contentDescription = "Menu",
                                    modifier = Modifier.size(30.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp)) // добавляем небольшой отступ между иконкой и текстом
                                Text(
                                    "History",
                                    modifier = Modifier.padding(top = 0.dp, start = 30.dp),
                                    style = androidx.compose.ui.text.TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        lineHeight = 16.41.sp,
                                        textAlign = TextAlign.Center,
                                        color = Color.White
                                    )
                                )
                            }
                        }
                    }
                    //кнопка сеттингс
                    Box(modifier = Modifier.padding(top = 60.dp, start = 10.dp)) {
                        TextButton(onClick = {navController.navigate("Settings")}) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = R.drawable.settings),
                                    contentDescription = "Menu",
                                    modifier = Modifier.size(30.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp)) // добавляем небольшой отступ между иконкой и текстом
                                Text(
                                    "Settings",
                                    modifier = Modifier.padding(top = 0.dp, start = 30.dp),
                                    style = androidx.compose.ui.text.TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        lineHeight = 16.41.sp,
                                        textAlign = TextAlign.Center,
                                        color = Color.White
                                    )
                                )
                            }
                        }
                    }
                }
            }
            Text("Ivanov Ivan", modifier = Modifier
                .padding(top=115.dp,start = 105.dp),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 16.41.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            )
            Text("Driver", modifier = Modifier
                .padding(top=135.dp,start = 105.dp),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 16.41.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            )
            //кнопка при открытой менюшке
            //не работает(((
            IconButton(
                onClick = {isMenuOpen=false},
                modifier = Modifier
                    .padding(top = 45.dp, start = 230.dp)
                    .align(Alignment.TopStart)
                    .size(55.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.menu2),
                    contentDescription = "Menu",
                    modifier = Modifier.size(60.dp)
                )
            }
        }

    }
}
@Composable
fun History(navController: NavController){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color(red = 0x2a, green = 0x2e, blue = 0x43, alpha = 0xFF))
        .padding(top=50.dp)){
        // Кнопка "History"
        TextButton(onClick = {navController.navigate("History")}, modifier = Modifier.align(Alignment.CenterStart)) {

            Icon(
                painter = painterResource(id = R.drawable.history),
                contentDescription = "Menu",
                modifier = Modifier.size(30.dp)
            )

            Text(
                "History",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 16.41.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            )

        }
    }
    Box(
        modifier = Modifier
            .fillMaxHeight()

    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.padding(top = 130.dp, start = 10.dp)) {
                Text(
                    "Kia Rio",
                    modifier = Modifier.padding(top = 0.dp, start = 30.dp),
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 16.41.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                )
            }
        }
    }
    Box(modifier = Modifier.padding(top = 160.dp, start = 10.dp)) {

        Text(
            "Kia Rio",
            modifier = Modifier.padding(top = 0.dp, start = 30.dp),
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.41.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        )
    }
}
@Composable
fun Settings(navController: NavController){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color(red = 0x2a, green = 0x2e, blue = 0x43, alpha = 0xFF))
        .padding(top=50.dp)){
        // Кнопка "History"
        TextButton(onClick = {navController.navigate("Settings")}, modifier = Modifier.align(Alignment.CenterStart)) {

            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "Menu",
                modifier = Modifier.size(30.dp)
            )

            Text(
                "History",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 16.41.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            )

        }
    }
}
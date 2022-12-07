package com.bir.birthdaywishcard

import android.media.Image
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bir.birthdaywishcard.ui.theme.BirthdayWishCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayWishCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(message = "Happy birthday Shiv!", from = "-from Shivam")
                }
            }
        }
    }
}
@Composable
fun BirthdayGreetingWithImage(message: String, from: String){
    val image = painterResource(id = R.drawable.birthday)
    Box{
        androidx.compose.foundation
            .Image(painter = image, contentDescription = null ,
                modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
                contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from )
    }

}

@Composable
fun BirthdayGreetingWithText(message: String, from: String){
    Column(content = {
        Text(text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 16.dp, top = 15.dp)
        )
        Text(text  = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End)
                .padding(start = 16.dp, end = 16.dp)

        )
    })
}

@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithImagePreview() {
    BirthdayWishCardTheme {
        BirthdayGreetingWithImage(message = stringResource(R.string.happy_birthday_text), from = "-from Shivam")
    }
}
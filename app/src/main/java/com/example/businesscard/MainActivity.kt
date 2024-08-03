package com.example.businesscard
import android.os.Bundle
import android.provider.MediaStore.Images
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.sourceInformationMarkerEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White){
                    BusinessCard(imagePainter = painterResource(id = R.drawable.blackme), fullName = "Abigail Gyebi", title ="Android Developer", department = "Mobile App Development")
                }

                }
            }
        }
    }


@Composable
fun BusinessCard(imagePainter: Painter, fullName: String, title: String, department: String, modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(10.dp)

    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Column(horizontalAlignment = AbsoluteAlignment.Left) {
            Text(
                text = fullName,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(bottom = 2.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = title,
                fontSize = 16.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = department,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
        Column(
            horizontalAlignment = AbsoluteAlignment.Left,
            modifier = Modifier
                .padding(top = 10.dp)
        ) {
            ContactInfo(icon = painterResource(id = R.drawable.email_1_svgrepo_com), text = "abigailgyebi@gmail.com")
            ContactInfo(icon = painterResource(id = R.drawable.phone_svgrepo_com), text ="090-786-8652" )
            ContactInfo(icon = painterResource(id = R.drawable.mention_circle_svgrepo_com), text ="LinkedAcct" )

        }

    }

}

@Composable
fun ContactInfo(icon: Painter, text: String, modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(0.1.dp)

    ){
        Image(
            painter = icon,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(10.dp))
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            text = text,
            fontSize = 10.sp,

        )

    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard(imagePainter = painterResource(id = R.drawable.blackme), fullName ="Abigail Gyebi" , title = "Android Developer", department = "Mobile App Development",)

    }
}
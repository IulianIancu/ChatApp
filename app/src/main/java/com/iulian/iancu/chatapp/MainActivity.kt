package com.iulian.iancu.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iulian.iancu.chatapp.ui.theme.ChatAppTheme
import com.iulian.iancu.chatapp.ui.theme.PinkHot
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content()
                }
            }
        }
    }

    @Composable
    fun Content() {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                for (i in 1..25) {
                    item {
                        when (i % 3) {
                            1 -> MyMessage(message = "Marco")
                            2 -> OtherMessage(message = "Pollo")
                            else -> Separator(day = "Yesterday", time = "12:60")
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = PinkHot
                    ),
                    shape = RoundedCornerShape(32.dp)
                )
                FilledIconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(Icons.Filled.Send, contentDescription = "Send Message")
                }
            }
        }
    }

    @Composable
    fun MyMessage(message: String) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .weight(0.7f, false)
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                    .background(
                        Color.LightGray,
                        RoundedCornerShape(16.dp, 16.dp, 16.dp, 0.dp)
                    )
            ) {
                Text(
                    text = message,
                    modifier = Modifier.padding(8.dp)
                )
            }
            //EmptyBox for spacing
            Box(modifier = Modifier.weight(0.3f))
        }
    }

    @Composable
    fun OtherMessage(message: String) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            //EmptyBox for spacing
            Box(modifier = Modifier.weight(0.3f))

            Box(
                modifier = Modifier
                    .weight(0.7f, false)
                    .padding(end = 16.dp, top = 8.dp, bottom = 8.dp)
                    .background(
                        PinkHot,
                        RoundedCornerShape(16.dp, 16.dp, 0.dp, 16.dp)
                    )
            ) {
                Text(
                    text = message,
                    modifier = Modifier.padding(8.dp),
                    color = Color.White
                )
            }
        }
    }

    @Composable
    fun Separator(day: String, time: String) {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = day,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
            Text(
                text = time,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            )
        }
    }


    @Composable
    @Preview
    fun Preview() {
        ChatAppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Content()
            }
        }
    }
}
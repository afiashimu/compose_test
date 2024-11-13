package com.app.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Text( text = "Welcome to Shushi",
            fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }

    LazyColumDemo()
    
}

@Composable
fun LazyColumDemo() {
    var mylist = getAllMarvelChar()
    LazyColumn(content = {
        itemsIndexed(mylist, itemContent = { index,item->
           MarvelItem(item= item)
        })
        })


    }
@Composable
fun MarvelItem (item: MarvelChar) {
    Row(

        modifier = Modifier.fillMaxWidth()
            .padding(25.dp)
    ){


        Image(painter = painterResource(id = item.imageRes),
            contentDescription = item.name,
            modifier = Modifier
                .clip(CircleShape)
                .size(64.dp)
                .scale(1.0f)
            )
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp)
        ){
            Text(
                text= item.charName,
                style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)
            )

            Text(
                text= item.charName,
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
            )
        }
    }

}
@Composable
fun SimpleColum() {
    var scrollState= rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for( i in 1..100){
            Text(text = "Item $i")
        }
    }
    
}

@Composable
fun TextItem(text: String) {

    Text(text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.Center,
        fontSize = 20.sp
    )

}
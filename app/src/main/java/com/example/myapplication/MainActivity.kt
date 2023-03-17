package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {


    Ingredients()
}


// chuwx phía trên các ô
@Composable
fun Ingredients(modifier: Modifier = Modifier){
    ConstraintLayout {
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp
        val itemWith = (screenWidth *0.25).dp

        val (tvIngredients,imgArrow) = createRefs()// định nghĩa id
        Text(text = "Ingredients", style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            lineHeight = 14.sp,
            color = Color(0xffFB7D8A)
        ),
            modifier = Modifier.constrainAs(tvIngredients){
                top.linkTo(parent.top)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowRight,
            contentDescription = null,
            tint = Color(0xffFB7D8A),
            modifier = Modifier
                .size(24.dp)
                .constrainAs(imgArrow) {
                    start.linkTo(
                        tvIngredients.end,
                        margin = 6.dp
                    )// khaoảng cach giữa 2 phần tử mũi tên và chữ
                    bottom.linkTo(tvIngredients.bottom)
                }
        )
         val (lineOne, lineTwo) = createRefs()
        ConstraintLayout(modifier = Modifier
                .fillMaxSize()
                .constrainAs(lineOne) {
                    start.linkTo(tvIngredients.start)
                    top.linkTo(tvIngredients.bottom, margin = 14.dp)
                }) {

            val (e1,e2,e3) = createRefs()
            val lineOneChain = createHorizontalChain(e1,e2,e3, chainStyle = ChainStyle.Spread)// đổi cách căn giữa các hình trong một hàng
            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 8, unit = " ",
                name = "Mint leaves",
                modifier = Modifier
                    .size(itemWith)
                    .constrainAs(e1){lineOneChain}
            )
            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 2,
                unit = " ",
                name = "Mint leaves",
                modifier = Modifier
                    .size(itemWith)
                    .constrainAs(e2){lineOneChain}
            )
            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 30,
                unit = "ml",
                name = "Mint leaves",
                modifier = Modifier
                    .size(itemWith)
                    .constrainAs(e3){lineOneChain}
            )
        }
///line 2

        ConstraintLayout(modifier = Modifier
            .fillMaxSize()
            .constrainAs(lineTwo) {
                start.linkTo(tvIngredients.start)
                top.linkTo(lineOne.bottom, margin = 20.dp)
            }) {

            val (e1,e2,e3) = createRefs()
            val lineOneChain = createHorizontalChain(e1,e2,e3, chainStyle = ChainStyle.Spread)// đổi cách căn giữa các hình trong một hàng
            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 8, unit = " ",
                name = "Mint leaves",
                modifier = Modifier
                    .size(itemWith)
                    .constrainAs(e1){lineOneChain}
            )
            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 2,
                unit = " ",
                name = "Mint leaves",
                modifier = Modifier
                    .size(itemWith)
                    .constrainAs(e2){lineOneChain}
            )
            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 30,
                unit = "ml",
                name = "Mint leaves",
                modifier = Modifier
                    .size(itemWith)
                    .constrainAs(e3){lineOneChain}
            )
        }


        
    }
}

@Composable
fun Ingredient(
    @DrawableRes icon: Int,
    value: Int,
    unit: String,
    name: String,
    modifier: Modifier = Modifier){

    val backgroundColor = Color(0xFFFEF9E4)
    val borderColor = Color(0xFFFBE897).copy(alpha = 0.7f)
    ConstraintLayout(
        modifier = modifier
            .background(color = backgroundColor)
            .border(BorderStroke(width = 1.dp, color = borderColor))) {
        //tạo guiline(chia giữa cái hình 2 pâhfn trên và dưới)
//        val verticalGuideLine50 = createGuidelineFromTop(0.5f)
        val horizontalGuideLine = createGuidelineFromTop(0.5f)
        val imgIcon = createRef()
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.constrainAs(imgIcon){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(horizontalGuideLine)
                height = Dimension.fillToConstraints // tối đa độ cao

        },
        contentScale =  ContentScale.FillHeight)
        val verticalGuideLine = createGuidelineFromStart(0.5f)
        val valueTextColor = Color(0xFFFB7D8A)
        val (tvValue, tvUnit, tvName) = createRefs() // cho phép tạo 1 lần 3 cái

        Text(text = value.toString(), style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 28.sp,
            lineHeight =  14.sp,
            color = valueTextColor),
            modifier = Modifier.constrainAs(tvValue){
                top.linkTo(horizontalGuideLine, margin = 2.dp) // khoảng cách
                end.linkTo(verticalGuideLine, margin = 2.dp)
            }
        )
        unit?.let { //check ko null
            Text(text = unit, style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                lineHeight =  14.sp,
                color = valueTextColor),
                modifier = Modifier.constrainAs(tvUnit){
                    top.linkTo(tvValue.bottom, margin = 2.dp)
                    end.linkTo(tvValue.end)
                }
            )

        }

        val bottomBarrier = createBottomBarrier(tvValue, tvUnit)
        val endGuideLine20 = createGuidelineFromEnd(0.2f)
        Text(
            text = name,
            style = TextStyle(
                color = Color(0xff1E2742),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 14.sp,
            ), modifier = Modifier.constrainAs(tvName){
                start.linkTo(verticalGuideLine)
                bottom.linkTo(bottomBarrier)
                top.linkTo(tvValue.top)
                end.linkTo(endGuideLine20)
                width = Dimension.fillToConstraints
            },
            maxLines = 2,
            textAlign = TextAlign.Start
        )
    }
} // phải có modifier để truyền các phần tử vào



@Preview(showBackground = true)
@Composable
fun IngredientPreview() {
    Row() {
        Ingredient(
            icon = R.drawable.ic_lemon,
            value = 30,
            unit = "ml",
            name="bbbbb aaaaaaa",
            modifier = Modifier
                .size(150.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        HomeScreen()
    }
}
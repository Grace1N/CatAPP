package com.example.catapp.ui.theme.screens.intents

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.catapp.R
import com.example.catapp.navigation.ROUTE_BMICALC
import com.example.catapp.navigation.ROUTE_CALCULATOR
import com.example.catapp.navigation.ROUTE_HOME
import com.example.catapp.navigation.ROUTE_INTENTS
import com.example.catapp.ui.theme.CatAPPTheme

@Composable
fun IntentsScreen(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        var context = LocalContext.current
        Button(onClick = {
            val uri = Uri.parse("smsto:0707826578")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "The SMS text")
            context.startActivity(intent)


        },
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)) {
            Image(
                painterResource(id = R.drawable.baseline_textsms_24),
                contentDescription ="SMS icon",
                modifier = Modifier.size(20.dp))
            Text(text = "SMS")

        }
        Button(onClick = {

            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "graceapp@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear M..........")
            context.startActivity(Intent.createChooser(emailIntent, "Send email..."))

        },
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)) {
            Image(
                painterResource(id = R.drawable.baseline_attach_email_24),
                contentDescription ="Email icon",
                modifier = Modifier.size(20.dp))
            Text(text = "Email")

        }
        Button(onClick = {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            ActivityCompat.startActivityForResult(context as Activity, takePictureIntent, 1,null)

        },
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)) {
            Image(
                painterResource(id = R.drawable.baseline_camera_alt_24),
                contentDescription ="Camera icon",
                modifier = Modifier.size(20.dp))
            Text(text = "Camera")

        }
        Button(onClick = {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app from ......!")
            context.startActivity(shareIntent)

        }, shape = CutCornerShape(10),
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)) {
            Image(
                painterResource(id = R.drawable.baseline_share_24),
                contentDescription ="Share icon",
                modifier = Modifier.size(20.dp))
            Text(text = "Share")

        }
        Button(onClick = {

            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                .getLaunchIntentForPackage("com.android.stk")!!
            if (simToolKitLaunchIntent != null) {
                context.startActivity(simToolKitLaunchIntent)
            }
        }, shape = CutCornerShape(10),
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)) {
            Image(
                painterResource(id = R.drawable.baseline_attach_money_24),
                contentDescription ="Money icon",
                modifier = Modifier.size(20.dp))
            Text(text = "Mpesa")

        }
        Button(onClick = {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0707826908"))
            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf<String>(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                context.startActivity(intent)
            }

        }, shape = CutCornerShape(10),
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)) {
            Image(
                painterResource(id = R.drawable.baseline_call_24),
                contentDescription ="Call icon",
                modifier = Modifier.size(20.dp))

            Text(text = "Call")

        }
        BottomAppBar(
            modifier = Modifier
                .background(Color.Transparent)
                .fillMaxWidth().padding(top = 40.dp)



        ) {
            IconButton(
                onClick = {
                    navController.navigate(ROUTE_HOME)
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = "home"
                )
//            Icon(imageVector = Icons.Default.home, contentDescription = )
                Text(
                    text = "Home",
                    modifier = Modifier.padding(top = 35.dp, bottom = 1.dp)
                )
            }
            IconButton(
                onClick = {
                    navController.navigate(ROUTE_CALCULATOR)
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_calculate_24),
                    contentDescription = "calculator"
                )
                Text(
                    text = "calculator",
                    modifier = Modifier.padding(top = 35.dp, bottom = 1.dp)
                )
            }
            IconButton(
                onClick = {
                    navController.navigate(ROUTE_INTENTS)
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_contact_page_24),
                    contentDescription = "intents"
                )
                Text(
                    text = "intents",
                    modifier = Modifier.padding(top = 40.dp, bottom = 1.dp)
                )
            }
            IconButton(
                onClick = {
                    navController.navigate(ROUTE_BMICALC)
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_accessibility_new_24),
                    contentDescription = "BMI Calc"
                )
                Text(
                    text = "BMI Calc",
                    modifier = Modifier.padding(top = 35.dp, bottom = 1.dp)
                )
            }
        }

    }





}




@Preview(showBackground = true)
@Composable
fun IntentsScreenPreview(){
    CatAPPTheme {
        IntentsScreen(rememberNavController())
    }
}
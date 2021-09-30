package com.example.jetpackcompose

import android.app.Activity
import android.widget.Toast
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.orangish
import com.example.jetpackcompose.ui.theme.purplish
import java.util.regex.Pattern


//@Preview(showBackground = true)
@Composable
fun LoginPage(activity:MainActivity) {
    Box(modifier = Modifier.fillMaxSize()) {
        BgCard()
        MainPage(activity)
    }

}

@Composable
fun BgCard() {
    val signupText = buildAnnotatedString {
        append("Don't have an account? ")
        withStyle(SpanStyle(color = orangish)) {
            append("Sign up here!")
        }
    }
    Surface(color = purplish, modifier = Modifier.fillMaxSize(1.0f)) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.offset(y = (-30).dp)
        ) {
            Row() {
                Image(
                    painter = painterResource(R.drawable.ic_fb),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Image(
                    painter = painterResource(R.drawable.ic_google),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Image(
                    painter = painterResource(R.drawable.ic_twitter),
                    contentDescription = null
                )

            }
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = signupText, color = Color.White)
        }
    }
}

@Composable
fun MainPage(activity: Activity) {

    Surface(
        color = Color.White, modifier = Modifier
            .height(600.dp)
            .border(
                BorderStroke(0.1.dp, Black),
                shape = RoundedCornerShape(60.dp).copy(
                    topStart = ZeroCornerSize,
                    topEnd = ZeroCornerSize
                )
            )

    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(R.drawable.login),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(15.dp))


            val emailState = remember { mutableStateOf("nirmala@ril.com")}
            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("Email Address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Green,
                    unfocusedBorderColor = Yellow
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_email),
                        contentDescription = null, modifier = Modifier
                            .height(20.dp)
                            .width(20.dp), tint = Black
                    )
                }
            )

            Spacer(modifier = Modifier.padding(10.dp))
            val password = rememberSaveable { mutableStateOf("1234") }
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Enter Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Green,
                    unfocusedBorderColor = Yellow
                ),
                leadingIcon = {
                    Image(
                        painter = painterResource(R.drawable.password),
                        contentDescription = null, modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            CompositionLocalProvider(LocalContentAlpha provides 1.00f) {
                Text(
                    text = "Forgot password?", textAlign = TextAlign.End, modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .focusable(true)
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Button(
                onClick = {
                    Toast.makeText(activity,validateData(email = emailState.value,password = password.value),Toast.LENGTH_SHORT).show()
                     },
                shape = shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                Text(text = "Log In")
            }
        }

    }
}


fun validateData(email:String,password:String):String{
    if(email.isEmpty()){
        return "Email is empty"
    }else if(password.isEmpty()){
        return "Password is empty"
    }else if(!VALID_EMAIL_ADDRESS_REGEX.matcher(email).find()){
        return "invalid email ID"
    }else if(!VALID_PASSWORD_REGEX.matcher(password).matches()){
        return PASSWORD_CONTAINS
    }
    return "Log in successfully"
}

val VALID_EMAIL_ADDRESS_REGEX: Pattern =
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)

val VALID_PASSWORD_REGEX: Pattern =
    Pattern.compile(
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$", Pattern.CASE_INSENSITIVE)

val PASSWORD_CONTAINS:String="A password is considered valid if all the following constraints are satisfied:\n" +
        "\n" +
        "It contains at least 8 characters and at most 20 characters.\n" +
        "It contains at least one digit.\n" +
        "It contains at least one upper case alphabet.\n" +
        "It contains at least one lower case alphabet.\n" +
        "It contains at least one special character which includes !@#\$%&*()-+=^.\n" +
        "It doesn’t contain any white space."

@Preview(showBackground = true)
@Composable
fun display() {
    LoginPage(activity = MainActivity())
}

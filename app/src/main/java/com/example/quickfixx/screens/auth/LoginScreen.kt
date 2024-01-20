package com.example.quickfixx.screens.auth

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quickfixx.navigation.Screens
import com.google.firebase.auth.FirebaseAuth


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val googleSignInHelper = remember { GoogleSignInHelper(context as Activity) }
    var gmail = remember {
        mutableStateOf("")
    }

    var password = remember {
        mutableStateOf("")
    }
//    var loggedInUserName by remember { mutableStateOf<String?>(null) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Login",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBackIos,
                                contentDescription = "back icon",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                )
            }
        ) {
            Surface(
                modifier = Modifier.padding(it.calculateTopPadding())
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Gmail",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                    OutlinedTextField(
                        value = gmail.value,
                        onValueChange ={
                            gmail.value = it
                         },
                        enabled = true,
                        placeholder = { Text(text = "Gmail") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Rounded.MailOutline,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.padding(3.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Password",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                    OutlinedTextField(
                        value = password.value,
                        onValueChange = { password.value = it },
                        enabled = true,
                        placeholder = { Text(text = "Password") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.padding(3.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            navController.navigate(Screens.VisitorsScreen.route)
                        },
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = ButtonDefaults.ContentPadding,
                        modifier = Modifier
                            .width(300.dp)
                    ) {
                        Text(
                            text = "Login",
                            letterSpacing = 1.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "                   OR",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            googleSignInHelper.signInWithGoogle()
                                  },
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = ButtonDefaults.ContentPadding,
                        modifier = Modifier
                            .width(300.dp)
                    ) {
                        Text(
                            text = "Continue with Google",
                            letterSpacing = 1.sp
                        )
                    }

//                    val user = FirebaseAuth.getInstance().currentUser
//                    if (user != null) {
//                        loggedInUserName = user.displayName
//                        Text(
//                            text = "Logged in as: $loggedInUserName",
//                            modifier = Modifier.padding(16.dp)
//                        )
//                    } else {
//                        Text(
//                            text = "Not logged in",
//                            modifier = Modifier.padding(16.dp)
//                        )
//                    }
                }
            }
        }
    }
}
//fun loginWithGoogle(googleSignInHelper: GoogleSignInHelper, navController: NavController) {
//    try {
//        // Initiate Google Sign-In
//        val user = googleSignInHelper.signInWithGoogle()
//
//        // Check if the sign-in was successful and user is not null
//        if (user != null) {
//            // Navigate to the HomePage
//            navController.navigate(Screens.HomePage.route)
//        } else {
//            // Handle sign-in failure (optional)
//            // You may want to show an error message or take appropriate action
//        }
//    } catch (e: Exception) {
//        // Handle any exceptions that may occur during the sign-in process
//        // You may want to show an error message or take appropriate action
//    }
//}

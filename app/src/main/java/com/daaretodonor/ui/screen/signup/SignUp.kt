package com.daaretodonor.ui.screen.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.daaretodonor.R
import com.daaretodonor.navigation.NavigationItem.Screen
import com.daaretodonor.ui.components.ButtonLoginGoogle
import com.daaretodonor.ui.theme.MainColor

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SignUp(modifier: Modifier = Modifier, navController: NavHostController,) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 15.dp, start = 15.dp)
                    .size(30.dp)
                    .clickable {
                        navController.navigate(Screen.Welcome.route)
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                modifier = Modifier.padding(20.dp),
                text = stringResource(R.string.signin),
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(5.dp))
            SignInForm(
                email = email,
                onEmailChange = { email = it },
                password = password,
                navController = navController,
                onPasswordChange = { password = it },
                phoneNumber = phoneNumber,
                onPhoneNumberChange = { phoneNumber = it },
                username = username,
                onUsernameChange = { username = it }
            )
        }
    }
}

@Composable
fun SignInForm(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    navController: NavHostController,
    onPasswordChange: (String) -> Unit,
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    username: String,
    onUsernameChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(
                MaterialTheme.shapes.medium.copy(
                    bottomEnd = CornerSize(0.dp),
                    bottomStart = CornerSize(0.dp),
                )
            )
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Text(
                text =  stringResource(R.string.join),
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                fontSize = 30.sp,
            )
            SignUpTextField(label = stringResource(R.string.username), value = username, onValueChange = onUsernameChange, keyboardType = KeyboardType.Text)
            SignUpTextField(label = stringResource(R.string.email), value = email, onValueChange = onEmailChange, keyboardType = KeyboardType.Email)
            SignUpTextField(label = stringResource(R.string.no_hp), value = phoneNumber, onValueChange = onPhoneNumberChange, keyboardType = KeyboardType.Phone)
            SignUpTextField(label = stringResource(R.string.password), value = password, onValueChange = onPasswordChange, keyboardType = KeyboardType.Password, visualTransformation = PasswordVisualTransformation())
            SignUpButton(onClick = {})
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                )
                Text(
                    text = "Atau",
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )
                Divider(
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                )
            }
            ButtonLoginGoogle(navController = navController)
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.no_have_accout),
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.signup),
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier,
                    fontWeight = FontWeight.Bold,
                )
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTextField(label: String, value: String, onValueChange: (String) -> Unit, keyboardType: KeyboardType, visualTransformation: VisualTransformation? = null) {
    Text(
        text = label,
        fontWeight = FontWeight.Normal,
        color = Color.Gray,
        fontSize = 16.sp,
        modifier = Modifier.padding(bottom = 5.dp)
    )
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        label = { Text("Masukan $label") },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType
        ),
        singleLine = true,
    )
}

@Composable
fun SignUpButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(MainColor),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(stringResource(id = R.string.daftar))
    }
}

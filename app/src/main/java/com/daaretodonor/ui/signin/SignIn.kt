package com.daaretodonor.ui.signin

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.daaretodonor.R
import com.daaretodonor.di.Injection
import com.daaretodonor.ui.LoginViewModel
import com.daaretodonor.ui.ViewModelFactory
import com.daaretodonor.ui.theme.MainColor

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SignIn(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = "image back",
                modifier = Modifier
                    .padding(top = 30.dp, start = 15.dp)
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                modifier = Modifier.padding(20.dp),
                text = stringResource(R.string.signin),
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            SignInForm(
                email = email,
                onEmailChange = { email = it },
                password = password,
                onPasswordChange = { password = it },
                onSignInClick = {
                    viewModel.login(email, password)
                },
                showPassword = showPassword,
                onTogglePasswordVisibility = { showPassword = !showPassword }
            )

            viewModel.loginSuccess.observeAsState().value?.let { loginResponse ->
                Log.d("respon", "$loginResponse")
            }


        }
    }
}

@Composable
fun SignInForm(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onSignInClick: () -> Unit,
    showPassword: Boolean,
    onTogglePasswordVisibility: () -> Unit
)  {
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
                text = stringResource(R.string.welcome),
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                fontSize = 30.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.teks_login),
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            SignInTextField(
                label = stringResource(R.string.email),
                value = email,
                onValueChange = onEmailChange,
                keyboardType = KeyboardType.Email
            )
            SignInTextField(
                label = stringResource(R.string.password),
                value = password,
                onValueChange = onPasswordChange,
                keyboardType = KeyboardType.Password,
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { onTogglePasswordVisibility() }) {
                        Image(
                            painter = painterResource(id = if (showPassword) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24),
                            contentDescription = "Toggle password visibility"
                        )
                    }
                }
            )
            SignInButton(onClick = onSignInClick)
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
fun SignInTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Text(
        text = label,
        fontWeight = FontWeight.Normal,
        color = Color.Gray,
        fontSize = 16.sp,
        modifier = Modifier.padding(bottom = 8.dp)
    )
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        label = { Text("Masukan $label") },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType
        ),
        singleLine = true,
        visualTransformation = visualTransformation ?: VisualTransformation.None,
        trailingIcon = trailingIcon
    )
}

@Composable
fun SignInButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(MainColor),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(stringResource(id = R.string.signin))
    }
}


package com.daaretodonor.ui.screen.chatbot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChatScreen() {
    var messages by remember { mutableStateOf(listOf<Message>()) }
    var newMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MessagesList(messages = messages)
        SendMessageInput(
            value = newMessage,
            onValueChange = { newMessage = it },
            onSendClick = {
                if (newMessage.isNotBlank()) {
                    messages = messages + Message("User", newMessage)
                    newMessage = ""
                }
            }
        )
    }
}

@Composable
fun MessagesList(messages: List<Message>) {
    LazyColumn {
        items(messages.size) { index ->
            MessageItem(message = messages[index])
        }
    }
}

@Composable
fun MessageItem(message: Message) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = if (message.sender == "User") Arrangement.End else Arrangement.Start
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = message.content,
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SendMessageInput(
    value: String,
    onValueChange: (String) -> Unit,
    onSendClick: () -> Unit
) {
    var keyboardController by remember { mutableStateOf<SoftwareKeyboardController?>(null) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        DisposableEffect(LocalView.current) {
            onDispose {
                keyboardController = null
            }
        }

        TextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    onSendClick()
                    keyboardController?.hide()
                }
            ),
            singleLine = true,
            trailingIcon = {
                IconButton(
                    onClick = {
                        onSendClick()
                        keyboardController?.hide()
                    }
                ) {
                    Icon(imageVector = Icons.Default.Send, contentDescription = "Send")
                }
            },
            placeholder = { Text("Type a message...") }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}

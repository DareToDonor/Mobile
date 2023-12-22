package com.daaretodonor.ui.screen.donor

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.daaretodonor.R
import com.daaretodonor.di.Injection
import com.daaretodonor.navigation.NavigationItem.Screen
import com.daaretodonor.ui.components.LocationAdapter
import com.daaretodonor.ui.screen.ViewModelFactory
import com.daaretodonor.ui.theme.MainColor

@Composable
fun Donor(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: DonorViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository(LocalContext.current)))


    ) {
    viewModel.getLocations()
    val locations = viewModel.locations.value
    var selectedLocationId by remember { mutableStateOf(-1) }

    Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(MainColor)
                        .padding(top = 20.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clickable {
                                navController.navigate(Screen.Home.route)
                            }
                    ) {
                        Icon(
                            modifier = Modifier
                                .fillMaxSize(),
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(R.string.place),
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        fontSize = 35.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
                ) {
                    items(locations) { location ->
                        LocationAdapter(
                            location = location,
                            selectedLocationId = selectedLocationId,
                            onItemClick = { selectedId ->
                                println("Selected ID: $selectedId")
                                selectedLocationId = selectedId
                            }
                        )
                    }
                }


            }
        DonorButton(modifier = Modifier.align(Alignment.BottomCenter))

        }

}
@Composable
fun DonorButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(MainColor),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(stringResource(id = R.string.signin))
    }
}

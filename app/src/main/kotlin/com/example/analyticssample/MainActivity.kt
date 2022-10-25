package com.example.analyticssample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.analyticssample.ApplicationExtension.Companion.analyticsWrapper
import com.example.analyticssample.ui.theme.AnalyticsSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnalyticsSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        SimpleButton(title = stringResource(id = R.string.login_title),
                            click = {
                                analyticsWrapper.login()
                        })
                        SimpleButton(title = stringResource(id = R.string.logout_title),
                            click = {
                                analyticsWrapper.logout()
                        })
                        SimpleButton(title = stringResource(id = R.string.send_event_title),
                            click = {
                                analyticsWrapper.sendEvent()
                        })
                        SimpleButton(title = stringResource(id = R.string.simulate_crash_title),
                            click = {
                                analyticsWrapper.simulateCrash()
                        })
                    }
                }
            }
        }
    }
}

@Composable
fun SimpleButton(title: String, click: (() -> Unit)) {
    Button(onClick = click) {
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginButton() {
    SimpleButton(stringResource(id = R.string.login_title),
        click = {
    })
}
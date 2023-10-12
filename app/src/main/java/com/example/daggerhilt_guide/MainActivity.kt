package com.example.daggerhilt_guide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.daggerhilt_guide.ui.theme.DaggerHiltGuideTheme
import dagger.hilt.android.AndroidEntryPoint

// Where ever we initialize the dagger hilt component we add the AndroidEntryPoint there.
// Encases of activity, services etc as these all are the components of android.
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltGuideTheme {
                val viewModel = hiltViewModel<MyViewModel>()
            }
        }
    }
}


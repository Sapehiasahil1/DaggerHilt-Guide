package com.example.daggerhilt_guide

import androidx.lifecycle.ViewModel
import com.example.daggerhilt_guide.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {
}
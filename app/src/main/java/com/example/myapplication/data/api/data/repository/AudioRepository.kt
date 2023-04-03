package com.example.myapplication.data.api.data.repository





import com.example.myapplication.data.api.data.ContentResolverHelper
import com.example.myapplication.data.api.data.model.Audio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AudioRepository @Inject
constructor(private val contentResolverHelper: ContentResolverHelper) {
    suspend fun getAudioData(): Unit = withContext(Dispatchers.IO){
        contentResolverHelper.getAudioData()
    }
}
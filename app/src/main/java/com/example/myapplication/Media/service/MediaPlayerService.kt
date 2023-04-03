package com.example.myapplication.Media.service

import android.media.browse.MediaBrowser
import dagger.hilt.android.AndroidEntryPoint
import android.os.Bundle
import android.service.media.MediaBrowserService
import com.example.myapplication.Media.constants.K


class MediaPlayerService : MediaBrowserService(){
    override fun onGetRoot(
        clientPackageName: String,
        clientUid: Int,
        rootHints: Bundle?
    ): BrowserRoot? {
        return BrowserRoot(K.MEDIA_ROOT_ID, null)
    }
    override fun onLoadChildren(
        parentId: String,
        result: Result<MutableList<MediaBrowser.MediaItem>>
    ) {
        TODO("Not yet implemented")
    }

}
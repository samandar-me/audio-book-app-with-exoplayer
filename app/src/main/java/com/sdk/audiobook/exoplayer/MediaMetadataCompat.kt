package com.sdk.audiobook.exoplayer

import android.support.v4.media.MediaMetadataCompat
import com.sdk.audiobook.data.model.Story

fun MediaMetadataCompat.toSong(): Story? {
    return description?.let {
        Story(
            it.mediaId ?: "",
            it.title.toString(),
            it.subtitle.toString(),
            it.mediaUri.toString(),
            it.iconUri.toString()
        )
    }
}
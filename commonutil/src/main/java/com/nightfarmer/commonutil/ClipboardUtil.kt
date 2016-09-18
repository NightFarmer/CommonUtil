package com.nightfarmer.commonutil

import android.content.ClipData
import android.content.Context

/**
 * 粘贴板工具
 * Created by zhangfan on 16-9-18.
 */
object ClipboardUtil {

    fun append(context: Context, text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        val primaryClip = clipboard.primaryClip
        primaryClip.addItem(ClipData.Item(text, text))
        clipboard.primaryClip = primaryClip
    }

    fun copyToClipboard(context: Context, text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        clipboard.primaryClip = ClipData.newPlainText(null, text)
    }

    fun getItemCount(context: Context): Int {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        val data = clipboard.primaryClip
        return data.itemCount
    }

    fun getText(context: Context, index: Int): String? {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        val clip = clipboard.primaryClip
        return if (clip != null && clip.itemCount > index) clip.getItemAt(index).coerceToText(context).toString() else null
    }

    fun getLatestText(context: Context): String? {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        val clip = clipboard.primaryClip
        return if (clip != null && clip.itemCount > 0) clip.getItemAt(clip.itemCount - 1).coerceToText(context).toString() else null
    }

}
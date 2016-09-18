package com.nightfarmer.commonutil

import java.io.Closeable
import java.io.File
import java.nio.charset.Charset
import java.text.DecimalFormat

/**
 * 文件读写类
 * Created by zhangfan on 16-9-18.
 */

class FileHelper {
    var file: File? = null

    fun with(file: File) {
        this.file = file
    }

    fun writeText(text: String) {
        file?.writeText(text)
    }

    fun appendText(text: String) {
        file?.appendText(text)
    }

    fun readText(): String {
        return file?.readText().orEmpty()
    }

    fun writeText(text: String, charset: Charset = Charsets.UTF_8) {
        file?.writeText(text, charset)
    }

    fun appendText(text: String, charset: Charset = Charsets.UTF_8) {
        file?.appendText(text, charset)
    }

    fun readText(charset: Charset = Charsets.UTF_8): String {
        return file?.readText(charset).orEmpty()
    }

    fun writeBytes(array: ByteArray) {
        file?.writeBytes(array)
    }

    fun appendBytes(array: ByteArray) {
        file?.appendBytes(array)
    }

    fun readBytes(): ByteArray {
        return file?.readBytes() ?: ByteArray(0)
    }

    fun foreachBlog(blockSize: Int, action: (ByteArray, Int) -> Unit) {
        file?.forEachBlock(blockSize, action)
    }

    fun foreachBlog(action: (ByteArray, Int) -> Unit) {
        file?.forEachBlock(action)
    }

    fun forEachLine(charset: Charset = Charsets.UTF_8, action: (line: String) -> Unit) {
        file?.forEachLine(charset, action)
    }

    fun forEachLine(action: (line: String) -> Unit) {
        file?.forEachLine(Charsets.UTF_8, action)
    }

    fun readLines(charset: Charset = Charsets.UTF_8): List<String> {
        return file?.readLines(charset).orEmpty()
    }

    fun readLines(): List<String> {
        return file?.readLines().orEmpty()
    }

    fun formatFileSize(): String {
        val df = DecimalFormat("#.00")
        var fileSizeString = ""
        if (file?.length() ?: 0 < 1024L) {
            fileSizeString = df.format(file?.length()) + "B"
        } else if (file?.length() ?: 0 < 1048576L) {
            fileSizeString = df.format(file?.length() ?: 0 / 1024.0) + "K"
        } else if (file?.length() ?: 0 < 1073741824L) {
            fileSizeString = df.format(file?.length() ?: 0 / 1048576.0) + "M"
        } else {
            fileSizeString = df.format(file?.length() ?: 0 / 1.073741824E9) + "G"
        }
        return fileSizeString
    }
}
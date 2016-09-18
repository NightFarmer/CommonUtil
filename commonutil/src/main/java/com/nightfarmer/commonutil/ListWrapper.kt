package com.nightfarmer.commonutil

/**
 * Created by zhangfan on 16-9-18.
 */
class ListWrapper<E>(val dataList: List<E>) {


    fun foreach(action: (E) -> Unit): Unit {
        dataList.forEach(action)
    }

    fun forEachIndexed(action: (Int, E) -> Unit): Unit {
        dataList.forEachIndexed { i, e -> action(i, e) }
    }

    fun filter(action: (E) -> Boolean): ListWrapper<E> {
        return ListWrapper(dataList.filter(action))
    }

    fun <R> map(transform: (E) -> R): ListWrapper<R> {
        return ListWrapper(dataList.map { transform(it) })
    }

    fun <R> mapIndexed(transform: (Int, E) -> R): ListWrapper<R> {
        return ListWrapper(dataList.mapIndexed { i, e -> transform(i, e) })
    }

    fun joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((E) -> CharSequence)? = null): String {
        return dataList.joinToString(separator, prefix, postfix, limit, truncated, transform)
    }

    fun joinToString(separator: CharSequence = ", "): String {
        return dataList.joinToString(separator, "", "", -1, "...", null)
    }

    fun isNotEmpty(): Boolean {
        return dataList.isNotEmpty()
    }

    fun isEmpty(): Boolean {
        return dataList.isEmpty()
    }



//    fun reduceRight(operation: (T, S) -> S): CollectionsWrapper<E> {
//        return CollectionsWrapper(dataList.reduceRight { e, e -> operation(e,e) })
//    }
}
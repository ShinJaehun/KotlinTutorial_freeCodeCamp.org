//fun printFilterString(list: List<String>, predicate: (String) -> Boolean) {
//    list.forEach {
//        if(predicate(it)) {
//            println(it)
//        }
//    }
//}

fun printFilterString(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        if(predicate?.invoke(it) == true) {
            println(it)
        }
    }
}

val predicate: (String) -> Boolean = {
    it.startsWith("J")
}

fun getPrintPredicate(): (String) -> Boolean {
    return { it.startsWith("J") }
}

fun main() {
//    val list = listOf("Kotlin", "Java", "C++", "Javascript")
//    printFilterString(list, {it.startsWith("K")})
//    printFilterString(list){
//        it.startsWith("J")
//    }

//    printFilterString(list, predicate)
//    printFilterString(list, getPrintPredicate())

//    printFilterString(list, null)

    val list = listOf("Kotlin", "Java", "C++", "Javascript", null, null)

//    list.filterNotNull() // null을 filtering
//        .filter {
//            it.startsWith("J") // null???
//        }
//        .map {
//            it.length
//        }
//        .forEach {
//            println(it)
//        }

//    list.filterNotNull()
////        .take(3)
//        .takeLast(3)
//        .forEach {
//            println(it)
//        }

//    list.filterNotNull()
//        .associate { it to it.length }
//        .forEach { // k, v
//            println("${it.value}, ${it.key}")
//        }

    val map = list.filterNotNull()
        .associate { it to it.length }

//    val language = list.first() // Kotlin
//    val language = list.last() // null
//    val language = list.filterNotNull().last() // Javascript
//    val language = list.filterNotNull().find { it.startsWith("J") } // Java
//    val language = list.filterNotNull().findLast { it.startsWith("J") } // Javascript
//    val language = list.filterNotNull().findLast { it.startsWith("foo") } // null
    val language = list.filterNotNull().findLast { it.startsWith("foo") }.orEmpty()
    println(language)
}
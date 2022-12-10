package utils

val PATH_START = "/inputs/"
val PATH_END = ".txt"

object Utils {
    fun getInputReader(name: String) =
        this.javaClass.getResourceAsStream(PATH_START  + name + PATH_END)
            .bufferedReader()
}
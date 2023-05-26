package si.uni_lj.fe.mis.maticadetection.util

sealed class Resource<out T:Any>{
    data class Success<out T:Any> (val data:T):Resource<T>()
    data class Error(val errorMessage:String):Resource<Nothing>()
    data class Loading<out T:Any>(val data:T? = null, val message:String? = null):Resource<T>()
}
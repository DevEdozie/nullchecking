package com.rsk.java.kotlin


fun main(args: Array<String>) {
    var m:Meeting? = Meeting()
    var newMeeting = Meeting()

    //Elvis operator
    newMeeting = m ?: Meeting()
    /*
    Equivalent to
    if(m != null){
        newMeeting = m
    }else{
        newMeeting = Meeting()
    }
     */

    closeMeeting(m)
    closeMeeting(newMeeting)

    m?.let {
        closeMeetingNonNull(m)
    }



}

fun closeMeetingNonNull(m:Meeting):Boolean{
    return if(m.canClose) m.close()
    else false
}
fun closeMeeting(m:Meeting?):Boolean?{
    return if(m?.canClose == true) m?.close()
    else false
}

class Meeting{
    val canClose:Boolean = false
     lateinit var address:Address

    fun close():Boolean{
        return true
    }

    fun save(o:Any){
        val saveable = o as? ISaveable
        /*
        Only called if saveable is not null
        It's a safe call operator(?)
         */
        saveable?.save()
        /*
        Equivalent to
        if(saveable != null){
            saveable.save()
         }else{
         //do nothing
         }
         */
    }

    fun init(addr:Address){
        address = addr
    }
}

interface ISaveable{
    fun save(){
        "Saved"
    }
}

class Address{

}
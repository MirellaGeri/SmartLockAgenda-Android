package com.mirellageri.smartlockagenda.data

data class BlockHour(
    val hour : String,
    var titleTask : String = "",
    var isFocus : Boolean = false,
    var isActive : Boolean = false
)

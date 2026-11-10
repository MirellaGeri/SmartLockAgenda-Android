package com.mirellageri.smartlockagenda.data

data class BlockHour(
    val hour : String,
    var tasks: List<Task> = emptyList(),
    var isFocus : Boolean = false,
    var isActive : Boolean = false,
    var taskId: Int? = null
)

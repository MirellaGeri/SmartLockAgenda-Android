package com.mirellageri.smartlockagenda.data

data class Task(
    val id: Int,
    val parentHour: String,
    val startTime: String,
    val endTime: String,
    val title: String,
    val isActive: Boolean,
    val blacklist: String
){
    companion object {
        const val TABLE_NAME = "tasks"
        const val COLUMN_ID = "id"
        const val COLUMN_PARENT_HOUR = "parent_hour" // El bloque del RecyclerView (Ej: "08:00")
        const val COLUMN_START_TIME = "start_time"   // Hora exacta de inicio (Ej: "08:15")
        const val COLUMN_END_TIME = "end_time"       // Hora exacta de fin (Ej: "08:45")
        const val COLUMN_TITLE = "title"
        const val COLUMN_IS_ACTIVE = "is_active"
        const val COLUMN_BLACKLIST = "blacklist"
        const val SQL_CREATE_TABLE =
            "CREATE TABLE $TABLE_NAME("+
                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "$COLUMN_PARENT_HOUR TEXT,"+
                    "$COLUMN_START_TIME TEXT,"+
                    "$COLUMN_END_TIME TEXT,"+
                    "$COLUMN_TITLE TEXT,"+
                    "$COLUMN_IS_ACTIVE INTEGER,"+
                    "$COLUMN_BLACKLIST TEXT)"
        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}
package com.example.todo.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

data class Task(
    var id: Int? = null,
    var title: String? = null,
    var details: String? = null,
    var date: LocalDateTime? = null,
    var isDone: Boolean = false
)

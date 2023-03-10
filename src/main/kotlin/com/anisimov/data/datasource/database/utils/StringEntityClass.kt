package com.anisimov.data.datasource.database.utils

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.IdTable

abstract class StringEntityClass<out E: Entity<String>>(
    table: IdTable<String>, entityType: Class<E>? = null
) : EntityClass<String, E>(table, entityType)
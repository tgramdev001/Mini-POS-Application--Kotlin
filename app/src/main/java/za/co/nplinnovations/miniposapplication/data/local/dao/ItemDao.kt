package za.co.nplinnovations.miniposapplication.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import za.co.nplinnovations.miniposapplication.data.local.entity.Item

interface ItemDao {
    @Insert
    suspend fun insert(item: Item)

    @Query("SELECT * FROM Item")
    suspend fun getAllItems(): List<Item>

    @Query("SELECT * FROM ITEM WHERE id LIKE :id LIMIT 1")
    fun findByID(id: Long): Item

    @Delete
    fun delete(item: Item)
}
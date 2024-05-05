package za.co.nplinnovations.miniposapplication.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import za.co.nplinnovations.miniposapplication.data.local.entity.Item

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Query("SELECT * FROM Item")
    suspend fun getAllItems(): Flow<List<Item>>

    @Query("SELECT * FROM ITEM WHERE id LIKE :id LIMIT 1")
    fun findByID(id: Long): Item

    @Delete
    fun delete(item: Item)
}
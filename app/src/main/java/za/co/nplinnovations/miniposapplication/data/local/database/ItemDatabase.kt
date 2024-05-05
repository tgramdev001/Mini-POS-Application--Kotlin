package za.co.nplinnovations.miniposapplication.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import za.co.nplinnovations.miniposapplication.data.local.dao.ItemDao
import za.co.nplinnovations.miniposapplication.data.local.entity.Item


@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}
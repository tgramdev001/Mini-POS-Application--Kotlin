package za.co.nplinnovations.miniposapplication.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import za.co.nplinnovations.miniposapplication.data.local.dao.ItemDao
import za.co.nplinnovations.miniposapplication.data.local.entity.Item


// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Item::class), version = 1, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ItemDatabase? = null

        fun getDatabase(context: Context): ItemDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    "item_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}
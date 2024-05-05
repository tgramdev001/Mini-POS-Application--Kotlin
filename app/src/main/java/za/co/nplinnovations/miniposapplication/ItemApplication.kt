package za.co.nplinnovations.miniposapplication

import android.app.Application
import za.co.nplinnovations.miniposapplication.data.local.database.ItemDatabase
import za.co.nplinnovations.miniposapplication.data.local.repositories.ItemRepository

class ItemApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { ItemDatabase.getDatabase(this) }
    val repository by lazy { ItemRepository(database.itemDao()) }

}
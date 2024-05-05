package za.co.nplinnovations.miniposapplication.data.local.repositories

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import za.co.nplinnovations.miniposapplication.data.local.dao.ItemDao
import za.co.nplinnovations.miniposapplication.data.local.entity.Item

class ItemRepository(private val itemDao: ItemDao) {
    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allItems: Flow<List<Item>> = itemDao.getAllItems()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(item: Item) {
        itemDao.insert(item)
    }

}
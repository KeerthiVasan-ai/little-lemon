package com.keerthi77459.littlelemon.home_screen.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMenuItems(menuItems: List<MenuItemEntity>)

    @Query("SELECT * FROM menu_items")
    fun getAllMenuItems(): List<MenuItemEntity>
}

/* TODO: THE INFORMATION TO WORK IN ROOM
CREATE A DATABASE FILE
CREATE A DAO
    CREATE A QUERY FUNCTION AS NORMAL FUNCTION
    CALL THOSE FUNCTIONS WITH (DISPATCHER.IO)
CREATE A APP DATABASE CLASS
CALL THE APP DATABASE INSTANCE IN MAIN ACTIVITY
*/
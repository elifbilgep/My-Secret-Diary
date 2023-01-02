package msku.ceng.mysecretdiary

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import msku.ceng.mysecretdiary.Dao.UserDao
import msku.ceng.mysecretdiary.Database.UserDatabase
import msku.ceng.mysecretdiary.Database.UserEntity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserDatabaseTest : TestCase() {
    private lateinit var db: UserDatabase
    private lateinit var dao: UserDao

    @Before
    override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()
        dao = db.userDao()
    }

    @After
    fun closeDb(){
        db.close()
    }

    @Test
    fun writeAndReadUser(){
        val user = UserEntity()
        user.setEmailAddress("testUser")
        user.setPassword("12345")

        val users = dao.getLast10Users()
//        assertThat(users.contains(user))
    }


}
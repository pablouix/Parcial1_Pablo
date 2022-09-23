package edu.ucne.parcial1_pablo.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.parcial1_pablo.data.AppDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provide(@ApplicationContext context: Context): AppDataBase =
        Room.databaseBuilder(
            context, AppDataBase::class.java,
            "SpellingDb"
        ).fallbackToDestructiveMigration().build()


}
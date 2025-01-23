package com.example.todo.ui.home

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowInsets
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.todo.ui.home.fragments.addtask.AddTaskFragment
import com.example.todo.ui.home.fragments.settings.SettingsFragment
import com.example.todo.ui.home.fragments.taskslist.TasksFragment
import com.route.todo.R
import com.route.todo.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val tasksFragment = TasksFragment()
    private val settingsFragment = SettingsFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavigation()
    }


    private fun setNavigation() {
        binding.fabAddTask.setOnClickListener {
            val bottomSheet = AddTaskFragment()
            bottomSheet.show(supportFragmentManager, null)
        }
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.tasks -> {
                    pushFragment(tasksFragment)
                }

                R.id.settings -> {
                    pushFragment(settingsFragment)
                }
            }
            return@setOnItemSelectedListener true
        }
        binding.bottomNavigationView.selectedItemId = R.id.tasks
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.content.fragmentContainer.id, fragment)
            .commit()

    }
}
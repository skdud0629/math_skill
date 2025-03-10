package com.refactoring_android.math_skill

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.refactoring_android.math_skill.databinding.ActivityMainBinding
import com.refactoring_android.math_skill.studentList.StudentListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()

        if (savedInstanceState == null) {
            val studentListFragment = StudentListFragment()
            val attendanceNumberFragment = AttendanceNumberFragment()

            supportFragmentManager.beginTransaction()
                .replace(R.id.attendanceNumber, attendanceNumberFragment)
                .commit()

            supportFragmentManager.beginTransaction()
                .replace(R.id.studentList, studentListFragment)
                .commit()
        }
    }
}
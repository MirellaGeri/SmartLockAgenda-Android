package com.mirellageri.smartlockagenda.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirellageri.smartlockagenda.R
import com.mirellageri.smartlockagenda.data.BlockHour
import com.mirellageri.smartlockagenda.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var listAgenda : MutableList<BlockHour>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //obtener fecha actual del sistema
        val calendar = Calendar.getInstance()
        //armar un buen formato
        val dateWithoutForm = SimpleDateFormat(getString(R.string.todayFormat), Locale.getDefault())
        val formDate = dateWithoutForm.format(calendar.time)
        binding.todayTextView.text =formDate.replaceFirstChar { it.uppercase() }
        //genera las horas del dia
        getHourToday()
        //configurar el recyclerview
        configurationRecyclerView()
    }
    fun getHourToday(){
        listAgenda = (1..23).map{ hour ->
            val hourForm = String.format("%02d:00", hour)
            BlockHour(hour = hourForm)
        } as MutableList<BlockHour>
    }
    fun configurationRecyclerView(){
        binding.hoursRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
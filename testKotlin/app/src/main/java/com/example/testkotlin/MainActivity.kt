package com.example.testkotlin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.testkotlin.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.NumberFormatException

// if statement : 자신을 둘러싸고 있는 블록의 최상위 요소이구요.또한 statement 자체가 값을 반환해주지는 않아요.
// if expression : 이 if식 자체로 값을 반환해줘요. (값을 만들어 냄.) 또 이 값이 다른 식의 하위 요소로 참여가 된다.

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        val num1 = 1
        val num2 = 2

        var biggerNum = 0

        biggerNum = if (num1 > num2) num1 else num2

        binding.fab.setOnClickListener { view: View ->
            Toast.makeText(this, biggerNum.toString(), Toast.LENGTH_SHORT).show()
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val list = arrayListOf(1, 6, "")
        val mapTest = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

        val rectangle = Rectangle(3, 3)
        rectangle.isSquare
        propertyOne++
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        println("this is not a number")
        -1
    }
    println(number)
}

var propertyOne = 0
val propertyTwo = 1

fun methodWithBlock(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun methodWithExpression(a: Int, b: Int): Int = if(a >b) a else b

// 본문이 블럭인 함수, 식인 함수 용도 차이가 가독성 제외하고 다른 것이 있는지?
// try catch 추가 블럭이 있을 때... 그냥 중괄호
// try catch 식으로 넘겨주는 거 내부에서 어떻게 주고 있는 거야..?
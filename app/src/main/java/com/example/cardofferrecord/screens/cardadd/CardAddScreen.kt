package com.example.cardofferrecord.screens.cardadd

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.cardofferrecord.navigation.CardScreen
import java.util.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardAddScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar() {

            }
        }
    ) {

        Column {
            val mContext = LocalContext.current
            val mCalendar = Calendar.getInstance()
            val mYear = mCalendar.get(Calendar.YEAR)
            val mMonth = mCalendar.get(Calendar.MONTH)
            val mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
            mCalendar.time = Date()

            val mDate = remember {
                mutableStateOf("")
            }

            val mDatePickerDialog = DatePickerDialog(
                mContext,
                { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                    mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
                }, mYear, mMonth, mDay
            )

            Button(onClick = { mDatePickerDialog.show() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
                Text(text = "Open Date Picker", color = Color.White)
            }
            Spacer(modifier = Modifier.size(100.dp))
            
            Text(
                text = "Selected Date: ${mDate.value}",
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun dropDownMenu() {
    val listItems = arrayOf("Favorites", "Options", "Settings", "Share")

    var selectedItem by remember {
        mutableStateOf("")
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {

        TextField(
            value = selectedItem,
            onValueChange = { selectedItem = it },
            label = { Text(text = "Label") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )

        // filter options based on text field value
        val filteringOptions =
            listItems.filter { it.contains(selectedItem, ignoreCase = true) }

        if (filteringOptions.isNotEmpty()) {

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                filteringOptions.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            selectedItem = selectionOption
                            expanded = false
                        }
                    ) {
                        Text(text = selectionOption)
                    }
                }
            }
        }
    }

}



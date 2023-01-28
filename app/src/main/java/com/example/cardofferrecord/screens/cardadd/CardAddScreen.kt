package com.example.cardofferrecord.screens.cardadd

import android.app.DatePickerDialog
import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cardofferrecord.R
import com.example.cardofferrecord.model.CardApplicationInfo
import com.example.cardofferrecord.model.WelcomeOffer
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun CardAddScreen(navController: NavController, viewModel: CardAddScreenViewModel = hiltViewModel()) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar() {

            }
        }
    ) {

        //Card Application Info
        val cardApplicationId = UUID.randomUUID().toString()
        val cardImageId: Int = R.drawable.dbs_blackworldcard
        val cardName = remember {
            mutableStateOf("")
        }
        val cardBank = remember {
            mutableStateOf("")
        }
        val cardApplicationDate = remember {
            mutableStateOf(Date())
        }
        val cardApprovalDate = remember {
            mutableStateOf(Date())
        }

        //3rd party welcome offer
        val thirdPartyOfferId = UUID.randomUUID().toString()
        val provider = remember {
            mutableStateOf("")
        }
        val thirdPartyOfferDateFrom = remember {
            mutableStateOf(Date())
        }
        val thirdPartyOfferDateTo = remember {
            mutableStateOf(Date())
        }
        val thirdPartyOfferDetail = remember {
            mutableStateOf("")
        }
        val thirdPartyOfferSpendingCondition = remember {
            mutableStateOf("")
        }
        val thirdPartyOfferPeriodCondition = remember {
            mutableStateOf("")
        }
        val thirdPartyOfferFulfillmentDate = remember {
            mutableStateOf(Date())
        }

        //bank welcome offer
        val bankOfferId = UUID.randomUUID().toString()

        val bankOfferDateFrom = remember {
            mutableStateOf(Date())
        }
        val bankOfferDateTo = remember {
            mutableStateOf(Date())
        }
        val bankOfferDetail = remember {
            mutableStateOf("")
        }
        val bankOfferSpendingCondition = remember {
            mutableStateOf("")
        }
        val bankOfferPeriodCondition = remember {
            mutableStateOf("")
        }
        val bankOfferFulfillmentDate = remember {
            mutableStateOf(Date())
        }

        val cardApplicationInfo = CardApplicationInfo(
            cardApplicationId,
            cardImageId,
            cardName.value,
            cardBank.value,
            cardApplicationDate.value,
            cardApprovalDate.value
        )


        val thirdPartyWelcomeOffer = WelcomeOffer(
            thirdPartyOfferId,
            cardApplicationId,
            provider.value,
            thirdPartyOfferDateFrom.value,
            thirdPartyOfferDateTo.value,
            thirdPartyOfferDetail.value,
            thirdPartyOfferSpendingCondition.value,
            thirdPartyOfferPeriodCondition.value,
            thirdPartyOfferFulfillmentDate.value
        )

        val bankWelcomeOffer = WelcomeOffer(
            bankOfferId,
            cardApplicationId,
            "Bank",
            bankOfferDateFrom.value,
            bankOfferDateTo.value,
            bankOfferDetail.value,
            bankOfferSpendingCondition.value,
            bankOfferPeriodCondition.value,
            bankOfferFulfillmentDate.value
        )


        val listItems = arrayOf("DBS Card", "HSBC Card")

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            //Card Application Info
            dropDownMenu(
                selectedItem = cardName,
                listItems = listItems
            )
            DatePicker(dateInput = cardApplicationDate)
            DatePicker(dateInput = cardApprovalDate)

            //3rd party Welcome Offer
            TextField(
                value = provider.value,
                label = {
                    Text(text = "Provider")
                },
                onValueChange = { provider.value = it }
            )
            DatePicker(dateInput = thirdPartyOfferDateFrom)
            DatePicker(dateInput = thirdPartyOfferDateTo)
            TextField(
                value = thirdPartyOfferDetail.value,
                label = {
                    Text(text = "Offer Detail")
                },
                onValueChange = { thirdPartyOfferDetail.value = it }
            )
            TextField(
                value = thirdPartyOfferSpendingCondition.value,
                label = {
                    Text(text = "Spending Condition")
                },
                onValueChange = { thirdPartyOfferSpendingCondition.value = it }
            )
            TextField(value = thirdPartyOfferPeriodCondition.value, label = {
                Text(text = "Period Condition")},  onValueChange = {thirdPartyOfferPeriodCondition.value = it})
            DatePicker(dateInput = thirdPartyOfferFulfillmentDate)

            //Bank Welcome Offer
            DatePicker(dateInput = bankOfferDateFrom)
            DatePicker(dateInput = bankOfferDateTo)
            TextField(
                value = bankOfferDetail.value,
                label = {
                    Text(text = "Offer Detail")
                },
                onValueChange = { bankOfferDetail.value = it }
            )
            TextField(value = bankOfferSpendingCondition.value, label = {
                Text(text = "Spending Condition")},  onValueChange = {bankOfferSpendingCondition.value = it})
            TextField(value = bankOfferPeriodCondition.value, label = {
                Text(text = "Period Condition")},  onValueChange = {bankOfferPeriodCondition.value = it})
            DatePicker(dateInput = bankOfferFulfillmentDate)

            Log.d("TAG", cardApplicationInfo.toString())
            Log.d("TAG", thirdPartyWelcomeOffer.toString())
            
            Button(onClick = { viewModel.addCardApplication(cardApplicationInfo)
            viewModel.addWelcomeOffer(thirdPartyWelcomeOffer)
            viewModel.addWelcomeOffer(bankWelcomeOffer)}) {
                Text(text = "Save")
            }
    }

    }
}

@Composable
fun DatePicker(dateInput: MutableState<Date>) {
    val mContext = LocalContext.current
    val mCalendar = Calendar.getInstance()
    val mYear = mCalendar.get(Calendar.YEAR)
    val mMonth = mCalendar.get(Calendar.MONTH)
    val mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    mCalendar.time = Date()

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            val dateString = "$mDayOfMonth/${mMonth + 1}/$mYear"
            dateInput.value = SimpleDateFormat("dd/MM/yyyy").parse(dateString)
        }, mYear, mMonth, mDay
    )
    Log.d("Date", dateInput.value.toString())

    Button(
        onClick = { mDatePickerDialog.show() },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))
    ) {
        Text(text = "Application Date: $dateInput.value")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun dropDownMenu(selectedItem: MutableState<String>, listItems: Array<String>) {

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
            value = selectedItem.value,
            onValueChange = { selectedItem.value = it },
            label = { Text(text = "Select Card") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )

        // filter options based on text field value
        val filteringOptions =
            listItems.filter { it.contains(selectedItem.value, ignoreCase = true) }

        if (filteringOptions.isNotEmpty()) {

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                filteringOptions.forEach { selectedOption ->
                    DropdownMenuItem(
                        onClick = {
                            selectedItem.value = selectedOption
                            expanded = false
                        }
                    ) {
                        Text(text = selectedOption)
                    }
                }
            }
        }
    }

}



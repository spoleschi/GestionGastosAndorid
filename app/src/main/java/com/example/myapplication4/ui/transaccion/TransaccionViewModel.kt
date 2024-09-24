package com.example.myapplication4.ui.transaccion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication4.Clases.Categoria
import com.example.myapplication4.Clases.Transaccion
import java.util.Calendar

//class TransaccionViewModel : ViewModel() {
//
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is Transaction Fragment"
//    }
//    val text: LiveData<String> = _text
//}


class TransaccionViewModel : ViewModel() {

//    private val _categories = MutableLiveData<List<Categoria>>()
//    val categories: LiveData<List<Categoria>> = _categories

    private val _expenseCategories = MutableLiveData<List<Categoria>>()
    val expenseCategories: LiveData<List<Categoria>> = _expenseCategories

    private val _incomeCategories = MutableLiveData<List<Categoria>>()
    val incomeCategories: LiveData<List<Categoria>> = _incomeCategories

    private val _currentCategories = MutableLiveData<List<Categoria>>()
    val currentCategories: LiveData<List<Categoria>> = _currentCategories


    private val _selectedCategory = MutableLiveData<Categoria>()
    val selectedCategory: LiveData<Categoria> = _selectedCategory

    private val _transactionType = MutableLiveData<TransactionType>()
    val transactionType: LiveData<TransactionType> = _transactionType

    private var currentType: String = "Gasto"

    private val _amount = MutableLiveData<Double>()
    val amount: LiveData<Double> = _amount

    private val _selectedDate = MutableLiveData<Calendar>()
    val selectedDate: LiveData<Calendar> = _selectedDate

    private val _installments = MutableLiveData<Int>()
    val installments: LiveData<Int> = _installments

    private val _interestRate = MutableLiveData<Double>()
    val interestRate: LiveData<Double> = _interestRate

    init {
//        // Inicializar con categorías de ejemplo
//        _categories.value = listOf(
//            Categoria(1, "Alimentos", "", "#3EC54A", "Gasto"),
//            Categoria(2, "Trasporte", "", "#FFEB3c", "Gasto"),
//            Categoria(3, "Ocio", "", "#800080", "Gasto"),
//            Categoria(4,"Salud", "", "#FF0000","Gasto"),
//            Categoria(5,"Casa", "", "#287FD2","Gasto"),
//            Categoria(6,"Educación","", "#FF00FF","Gasto"),
//            Categoria(7,"Regalos","", "#00FFFF","Gasto"),
//            Categoria(8, "Salario", "", "#808080", "Ingreso"),
//            Categoria(9, "Inversiones", "", "#FF9300", "Ingreso")
//        )
        _transactionType.value = TransactionType.EXPENSE
        _selectedDate.value = Calendar.getInstance() // Inicializar con la fecha actual
    }

    init {
        loadInitialCategories()
    }

    private fun loadInitialCategories() {
        val initialExpenseCategories = listOf(
            Categoria(1, "Alimentos", "", "#3EC54A", "Gasto"),
            Categoria(2, "Trasporte", "", "#FFEB3C", "Gasto"),
            Categoria(3, "Ocio", "", "#800080", "Gasto"),
            Categoria(4,"Salud", "", "#FF0000","Gasto"),
            Categoria(5,"Casa", "", "#287FD2","Gasto"),
            Categoria(6,"Educación","", "#FF00FF","Gasto"),
            Categoria(7,"Regalos","", "#00FFFF","Gasto")
        )
        _expenseCategories.value = initialExpenseCategories

        val initialIncomeCategories = listOf(
            Categoria(8, "Salario", "", "#808080", "Ingreso"),
            Categoria(9, "Inversiones", "", "#FF9300", "Ingreso")
        )
        _incomeCategories.value = initialIncomeCategories

        // Inicialmente mostramos las categorías de gasto
        _currentCategories.value = initialExpenseCategories
    }

    fun setTransactionType(type: TransactionType) {
        _transactionType.value = type
    }

    fun showExpenseCategories() {
        currentType = "Gasto"
        _currentCategories.value = _expenseCategories.value
    }

    fun showIncomeCategories() {
        currentType = "Ingreso"
        _currentCategories.value = _incomeCategories.value
    }

    fun setSelectedDate(year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month)
            set(Calendar.DAY_OF_MONTH, dayOfMonth)
        }
        _selectedDate.value = calendar
    }

    fun setSelectedCategory(category: Categoria) {
        _selectedCategory.value = category
    }

    fun setAmount(amount: Double) {
        _amount.value = amount
    }

    fun setInstallments(installments: Int) {
        _installments.value = installments
    }

    fun setInterestRate(rate: Double) {
        _interestRate.value = rate
    }

    fun addTransaction(amount: Double, comment: String, date: Calendar, installments: Int, interestRate: Double) {
        // Aquí implementar la lógica para añadir la transacción a la base de datos o repositorio
//        val transaction = Transaccion(
//            monto = amount,
//            categoria = _selectedCategory.value!!,
//            tipo = _transactionType.value!!,
//            desc = comment
//        )
    }
}

enum class TransactionType {
    EXPENSE, INCOME
}


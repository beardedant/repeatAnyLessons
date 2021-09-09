package com.example.repeatanylessons.vewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.repeatanylessons.model.AnyData

class MainFragmentViewModel(private val liveData: MutableLiveData<AnyData> = MutableLiveData()) :
    ViewModel() {

    fun getDataFromModel() = liveData

    //кривая функция обновления модели
    fun modelUpdate() {
        liveData.postValue(AnyData(12, "hohoNut"))
    }
}
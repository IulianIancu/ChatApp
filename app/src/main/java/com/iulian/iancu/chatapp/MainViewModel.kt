package com.iulian.iancu.chatapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iulian.iancu.domain.GetChatUseCase
import com.iulian.iancu.domain.Message
import com.iulian.iancu.domain.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getChatUseCase: GetChatUseCase,
    private val sendMessageUseCase: SendMessageUseCase
) : ViewModel() {
    private val _messagesList = MutableStateFlow<List<Message>>(emptyList())
    val messagesList = _messagesList.asStateFlow()
    init {
        viewModelScope.launch {
            getChatUseCase().collect{
                _messagesList.value = it
            }
        }
    }

    private var _currentMessage = MutableStateFlow("")
    val currentMessage = _currentMessage.asStateFlow()

    fun sendMessage() {
        viewModelScope.launch {
            val message = _currentMessage.value
            sendMessageUseCase(Message(message, "ME", Calendar.getInstance().time))
            delay(500)
            if (message.contains("marco", true)) {
                sendMessageUseCase(Message("POLO", "OTHER", Calendar.getInstance().time))
                sendMessageUseCase(Message("1", "SEPARATOR", Calendar.getInstance().time))
            }
        }
    }

    fun onCurrentMessageChanged(message: String) {
        _currentMessage.value = message
    }
}
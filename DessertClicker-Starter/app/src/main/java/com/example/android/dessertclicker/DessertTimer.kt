package com.example.android.dessertclicker///*


import android.os.Handler
import timber.log.Timber
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


class DessertTimer(lifecycle: Lifecycle) : LifecycleObserver { //    // The number of seconds counted since the timer started
    var secondsCount = 0

    private var handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable
    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startTimer() {
        runnable = Runnable {
            secondsCount++
            Timber.i("Timer is at : $secondsCount")

            handler.postDelayed(runnable, 1000)
        }

        handler.postDelayed(runnable, 1000)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopTimer() {
        handler.removeCallbacks(runnable)
    }
}
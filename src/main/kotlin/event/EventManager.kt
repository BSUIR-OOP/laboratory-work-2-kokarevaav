package event

interface EventManager {
    fun subscribe(listener: Listener)
    fun unsubscribe(listener: Listener)
    fun notifyListeners()
}
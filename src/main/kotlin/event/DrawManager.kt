package event

class DrawManager: EventManager {
    private var listeners: ArrayList<Listener> = ArrayList()

    override fun subscribe(listener: Listener) {
        listeners.add(listener)
    }

    override fun unsubscribe(listener: Listener) {
        listeners.remove(listener)
    }

    override fun notifyListeners() {
        listeners.forEach { listener ->
            listener.update()
        }
    }
}
package event

class DrawManager private constructor(): EventManager {
    private var listeners: ArrayList<Listener> = ArrayList()

    companion object {
        private val instance = DrawManager()

        fun getInstance(): DrawManager {
            return instance
        }
    }

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
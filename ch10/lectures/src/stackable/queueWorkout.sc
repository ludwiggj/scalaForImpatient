import stackable.{Filtering, Incrementing, Doubling, BasicIntQueue}

val queue1 = new BasicIntQueue
queue1.put(10)
queue1.put(20)
queue1.get()
queue1.get()

class MyQueue extends BasicIntQueue with Doubling

val queue2 = new MyQueue

queue2.put(10)
queue2.get()

val queue3 = new BasicIntQueue with Doubling
queue3.put(20)
queue3.get()

val queue4 = new BasicIntQueue with Incrementing with Filtering

queue4.put(-1)
queue4.put(0)
queue4.put(1)

queue4.get()
queue4.get()
//queue4.get() - generates IndexOutOfBoundsException

val queue5 = new BasicIntQueue with Filtering with Incrementing

queue5.put(-1)
queue5.put(0)
queue5.put(1)
queue5.get()
queue5.get()
queue5.get()
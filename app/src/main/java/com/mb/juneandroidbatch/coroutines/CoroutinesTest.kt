package com.mb.juneandroidbatch.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class CoroutinesTest {



//    fun fetchData(){
//
//        fetchUser {
//            user -> showUser(user)
//        }
//    }
//

//    // coroutine function to fetch user
//    suspend fun fetchUser(){
//        val user = fetchUser()
//        showUser(user)
//    }
//
//
//
//GlobalScope.launch(Dispatchers.Main) {
//    val user = fetchUser() // fetch on IO thread
//    showUser(user) // back to UI thread
//}


//    GlobalScope.launch(Dispatcher.Main)
//    {
//        // This block runs on the Main thread
//        // You can update UI here
//        doSomething() //no-suspend function, UI thread
//        doLongRunningTask() //suspend function,  IO background thread
//     doSomethingelse() // non-suspend function, UI thread
//    }
//
//
//    fun doSomething() {
//        //todo
//    }
//
//    suspend  fun doLongRunningTask() {
//        withContext(Dispatchers.IO){
//            delay(2000)
//        }
//
//    }
//
//
//    fun doSomethingelse() {
//        //todo
//    }
//
//
//    launch{} // result not expected  // fire and forget
//    async{} // result expected, returns Deferred<T> // perform a task and return a result
//    await
}





//Dispatchers.IO
//Dispatchers.Main
//Dispatchers.Default

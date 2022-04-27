package com.logan.callback.Import;

import android.util.Log;

public class Worker {

    ActionListenerCallback callBack;

    public Worker() {

        //initializing the callback object from the constructor
        this.callBack = null;
//        if (this.callBack == null){
//            Log.d("TEST","Initialize interface obj is not null!!! ");
//        }
        Log.d("TEST","Init callback to null");

    }

    public void setActionListener(ActionListenerCallback callBack) {

        this.callBack = callBack;

        Log.d("TEST","Performing some task, prior to invoking the callback");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        if (this.callBack != null){
//            Log.d("TEST","callback is not null");
//        }


        if (this.callBack != null) {

//            callBack.onActionSuccess("Testing");

        }

    }
}

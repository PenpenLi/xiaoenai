package com.alimama.mobile.sdk.lab;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityResult;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

class InstrumentationHook$1
  implements InstrumentationHook.ExecStartActivityCallback
{
  InstrumentationHook$1(InstrumentationHook paramInstrumentationHook, Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Activity paramActivity, Intent paramIntent, int paramInt) {}
  
  public Instrumentation.ActivityResult execStartActivity()
  {
    return InstrumentationHook.access$000(this.this$0).execStartActivity(this.val$who, this.val$contextThread, this.val$token, this.val$target, this.val$intent, this.val$requestCode);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\lab\InstrumentationHook$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
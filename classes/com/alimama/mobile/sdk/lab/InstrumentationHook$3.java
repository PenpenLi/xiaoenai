package com.alimama.mobile.sdk.lab;

import android.app.Fragment;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityResult;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

class InstrumentationHook$3
  implements InstrumentationHook.ExecStartActivityCallback
{
  InstrumentationHook$3(InstrumentationHook paramInstrumentationHook, Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Fragment paramFragment, Intent paramIntent, int paramInt) {}
  
  public Instrumentation.ActivityResult execStartActivity()
  {
    return InstrumentationHook.access$000(this.this$0).execStartActivity(this.val$who, this.val$contextThread, this.val$token, this.val$target, this.val$intent, this.val$requestCode);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\lab\InstrumentationHook$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
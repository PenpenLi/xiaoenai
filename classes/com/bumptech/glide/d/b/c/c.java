package com.bumptech.glide.d.b.c;

import android.util.Log;

 enum c
{
  c()
  {
    super(paramString, paramInt, null);
  }
  
  protected void a(Throwable paramThrowable)
  {
    if (Log.isLoggable("PriorityExecutor", 6)) {
      Log.e("PriorityExecutor", "Request threw uncaught throwable", paramThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
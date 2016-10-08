package com.xiaoenai.app.service;

import android.app.Service;
import android.os.Binder;

public class j
  extends Binder
{
  Service a = null;
  
  public j(Service paramService)
  {
    this.a = paramService;
  }
  
  public Service a()
  {
    return this.a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
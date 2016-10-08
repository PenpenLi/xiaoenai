package com.ut.mini;

import android.app.Activity;

public class UTInterfaceCallDelegate
{
  public static void pageAppearByAuto(Activity paramActivity)
  {
    UTPageHitHelper.getInstance().pageAppearByAuto(paramActivity);
  }
  
  public static void pageDisAppearByAuto(Activity paramActivity)
  {
    UTPageHitHelper.getInstance().pageDisAppearByAuto(paramActivity);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\UTInterfaceCallDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.alimama.config;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.alimama.mobile.sdk.config.MmuProperties;

public abstract interface MMUConfigInterface
{
  public abstract void addMogoView(ViewGroup paramViewGroup, RelativeLayout.LayoutParams paramLayoutParams);
  
  public abstract boolean getDownloadIsShowDialog();
  
  public abstract Handler getHandler();
  
  public abstract MmuProperties getMMUConfigCenter();
  
  public abstract void setBackGround(int paramInt);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\config\MMUConfigInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
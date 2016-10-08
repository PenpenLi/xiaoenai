package com.alibaba.sdk.android.config;

public abstract interface PropertyChangeListener
{
  public static final String PROPETY_NAME_KEY = "property_name";
  
  public abstract void propertyChanged(String paramString1, String paramString2, String paramString3);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\config\PropertyChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
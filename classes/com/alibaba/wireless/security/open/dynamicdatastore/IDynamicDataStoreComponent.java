package com.alibaba.wireless.security.open.dynamicdatastore;

import com.alibaba.wireless.security.open.IComponent;

public abstract interface IDynamicDataStoreComponent
  extends IComponent
{
  public abstract boolean getBoolean(String paramString);
  
  public abstract byte[] getByteArray(String paramString);
  
  public abstract byte[] getByteArrayDDp(String paramString);
  
  public abstract float getFloat(String paramString);
  
  public abstract int getInt(String paramString);
  
  public abstract long getLong(String paramString);
  
  public abstract String getString(String paramString);
  
  public abstract String getStringDDp(String paramString);
  
  public abstract int putBoolean(String paramString, boolean paramBoolean);
  
  public abstract int putByteArray(String paramString, byte[] paramArrayOfByte);
  
  public abstract int putByteArrayDDp(String paramString, byte[] paramArrayOfByte);
  
  public abstract int putFloat(String paramString, float paramFloat);
  
  public abstract int putInt(String paramString, int paramInt);
  
  public abstract int putLong(String paramString, long paramLong);
  
  public abstract int putString(String paramString1, String paramString2);
  
  public abstract int putStringDDp(String paramString1, String paramString2);
  
  public abstract void removeBoolean(String paramString);
  
  public abstract void removeByteArray(String paramString);
  
  public abstract void removeByteArrayDDp(String paramString);
  
  public abstract void removeFloat(String paramString);
  
  public abstract void removeInt(String paramString);
  
  public abstract void removeLong(String paramString);
  
  public abstract void removeString(String paramString);
  
  public abstract void removeStringDDp(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\dynamicdatastore\IDynamicDataStoreComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.alibaba.wireless.security.open.staticdatastore;

import com.alibaba.wireless.security.open.SecException;
import com.taobao.wireless.security.adapter.JNICLibrary;

public final class a
  implements IStaticDataStoreComponent
{
  public final String getAppKeyByIndex(int paramInt, String paramString)
  {
    if (paramInt < 0) {
      throw new SecException("", 201);
    }
    return (String)JNICLibrary.a().doCommandNative(com.taobao.wireless.security.adapter.a.b, new int[] { paramInt }, new String[] { paramString }, null, null);
  }
  
  public final String getExtraData(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      throw new SecException("", 201);
    }
    return (String)JNICLibrary.a().doCommandNative(com.taobao.wireless.security.adapter.a.d, null, new String[] { paramString1, paramString2 }, null, null);
  }
  
  public final int getKeyType(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      throw new SecException("", 201);
    }
    return ((Integer)JNICLibrary.a().doCommandNative(com.taobao.wireless.security.adapter.a.c, null, new String[] { paramString1, paramString2 }, null, null)).intValue();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\staticdatastore\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
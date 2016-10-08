package com.alibaba.wireless.security.open.dynamicdatastore;

import android.content.ContextWrapper;
import com.alibaba.wireless.security.open.SecException;
import com.taobao.wireless.security.adapter.JNICLibrary;
import com.taobao.wireless.security.adapter.common.SPUtility2;
import com.taobao.wireless.security.adapter.common.f;

public final class a
  implements IDynamicDataStoreComponent
{
  private ContextWrapper a;
  
  public a(ContextWrapper paramContextWrapper)
  {
    this.a = paramContextWrapper;
  }
  
  private int a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString1 })) {
      throw new SecException("Parameter key is empty", 501);
    }
    if (com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString2 })) {
      throw new SecException("Parameter value is empty", 501);
    }
    if (com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString3 })) {
      throw new SecException("Parameter valueType is empty", 501);
    }
    for (;;)
    {
      try
      {
        localJNICLibrary = JNICLibrary.a();
        if (paramBoolean)
        {
          i = 1;
          paramString3 = localJNICLibrary.a(paramString1, paramString3, i);
        }
      }
      catch (Exception paramString2)
      {
        JNICLibrary localJNICLibrary;
        int i;
        paramString1 = null;
        a(paramString2);
        paramString2 = paramString1;
        paramString1 = null;
        continue;
        paramString3 = paramString2;
        if (paramBoolean) {
          paramString3 = paramString2 + "_stable";
        }
        String.format("key = %s value = %s", new Object[] { paramString3, paramString1 });
        if (!com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString3 }))
        {
          if (!com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString1 })) {}
        }
        else {
          return 0;
        }
      }
      try
      {
        if (com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString3 })) {
          break label307;
        }
        paramString1 = f.a(this.a);
        localJNICLibrary = JNICLibrary.a();
        if (!paramBoolean) {
          continue;
        }
        i = 1;
        paramString1 = localJNICLibrary.a(303, paramString2, paramString1, i);
        if (paramString1 == null) {
          break label307;
        }
        paramString1 = new String(paramString1, "UTF-8");
      }
      catch (Exception paramString2)
      {
        paramString1 = paramString3;
        continue;
        paramString1 = null;
        continue;
      }
      paramString2 = paramString3;
      if (!com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString1 })) {
        continue;
      }
      return 0;
      i = 0;
      continue;
      i = 0;
    }
    if (SPUtility2.saveToSPUnified("DynamicData", paramString3, paramString1, true)) {
      return 1;
    }
    return 0;
  }
  
  private String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    localObject2 = null;
    if (com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString1 })) {
      throw new SecException("Parameter key is empty", 501);
    }
    if (com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString2 })) {
      throw new SecException("Parameter valueType is empty", 501);
    }
    try
    {
      localObject1 = JNICLibrary.a();
      if (!paramBoolean) {
        break label381;
      }
      i = 1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          paramString2 = JNICLibrary.a();
          if (paramBoolean)
          {
            i = 1;
            paramString1 = paramString2.a(302, (String)localObject1, paramString1, i);
            if (paramString1 == null) {
              continue;
            }
            paramString2 = new String(paramString1, "UTF-8");
            paramString1 = null;
            if ((paramString2 != null) && (!"".equals(paramString2))) {
              continue;
            }
            localObject2 = f.b(this.a);
          }
        }
        catch (Exception localException2)
        {
          try
          {
            localObject3 = JNICLibrary.a();
            if (paramBoolean)
            {
              i = 1;
              localObject2 = ((JNICLibrary)localObject3).a(302, (String)localObject1, (String[])localObject2, i);
              if (localObject2 == null) {
                continue;
              }
              localObject2 = new String((byte[])localObject2, "UTF-8");
              paramString2 = (String)localObject2;
              if ((paramString2 != null) && (!"".equals(paramString2))) {
                continue;
              }
              localObject2 = this.a;
              localObject2 = f.a();
              localObject3 = this.a;
              localObject3 = f.b();
            }
          }
          catch (Exception localException2)
          {
            try
            {
              Object localObject1;
              int i;
              Object localObject3;
              JNICLibrary localJNICLibrary = JNICLibrary.a();
              if (paramBoolean)
              {
                i = 1;
                localObject1 = localJNICLibrary.a(302, (String)localObject1, new String[] { localObject2, localObject3 }, i);
                if (localObject1 != null)
                {
                  localObject1 = new String((byte[])localObject1, "UTF-8");
                  paramString2 = (String)localObject1;
                  if ((paramString2 == null) && (paramString1 != null)) {
                    a(paramString1);
                  }
                  return paramString2;
                  i = 0;
                  continue;
                  paramString1 = paramString1;
                  a(paramString1);
                  paramString1 = null;
                  continue;
                  localObject1 = SPUtility2.readFromSPUnified("DynamicData", paramString2, null);
                  continue;
                  i = 0;
                  continue;
                  paramString1 = paramString1;
                  paramString2 = null;
                  continue;
                  i = 0;
                  continue;
                  localException2 = localException2;
                  continue;
                }
              }
              else
              {
                i = 0;
                continue;
                continue;
              }
            }
            catch (Exception localException1) {}
            continue;
          }
          continue;
          paramString2 = null;
          continue;
        }
        paramString1 = null;
        paramString2 = localException2;
      }
    }
    paramString1 = ((JNICLibrary)localObject1).a(paramString1, paramString2, i);
    if (!com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString1 }))
    {
      paramString2 = paramString1;
      if (paramBoolean) {
        paramString2 = paramString1 + "_stable";
      }
      if (com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString2 }))
      {
        localObject1 = null;
        if (com.taobao.wireless.security.adapter.common.a.a(new String[] { localObject1 })) {
          break label454;
        }
        paramString1 = f.a(this.a);
      }
    }
  }
  
  private static void a(Exception paramException)
  {
    if ((paramException != null) && ((paramException instanceof SecException)))
    {
      int i = ((SecException)paramException).getErrorCode();
      if ((i > 0) && (i <= 5)) {
        throw new SecException(paramException.getMessage(), paramException.getCause(), i + 500);
      }
      throw new SecException(paramException.getMessage(), paramException.getCause(), 599);
    }
  }
  
  private static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString1 })) {
      throw new SecException("Parameter key is empty", 501);
    }
    if (com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString2 })) {
      throw new SecException("Parameter valueType is empty", 501);
    }
    for (;;)
    {
      try
      {
        JNICLibrary localJNICLibrary = JNICLibrary.a();
        if (!paramBoolean) {
          continue;
        }
        i = 1;
        paramString1 = localJNICLibrary.a(paramString1, paramString2, i);
      }
      catch (Exception paramString1)
      {
        int i;
        a(paramString1);
        paramString1 = null;
        continue;
      }
      paramString2 = paramString1;
      if (paramBoolean) {
        paramString2 = paramString1 + "_stable";
      }
      String.format("key = %s", new Object[] { paramString2 });
      if (!com.taobao.wireless.security.adapter.common.a.a(new String[] { paramString2 })) {
        SPUtility2.removeFromSPUnified("DynamicData", paramString2, true);
      }
      return;
      i = 0;
    }
  }
  
  public final boolean getBoolean(String paramString)
  {
    boolean bool = false;
    paramString = a(paramString, "Z", false);
    if (paramString != null) {}
    try
    {
      bool = "1".equals(paramString);
      return bool;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public final byte[] getByteArray(String paramString)
  {
    Object localObject = null;
    String str = a(paramString, "[B", false);
    paramString = (String)localObject;
    if (str != null) {}
    try
    {
      paramString = com.alibaba.wireless.security.open.a.a.a(str);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public final byte[] getByteArrayDDp(String paramString)
  {
    Object localObject = null;
    String str = a(paramString, "[B", true);
    paramString = (String)localObject;
    if (str != null) {}
    try
    {
      paramString = com.alibaba.wireless.security.open.a.a.a(str);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public final float getFloat(String paramString)
  {
    float f = -1.0F;
    paramString = a(paramString, "F", false);
    if (paramString != null) {}
    try
    {
      f = Float.parseFloat(paramString);
      return f;
    }
    catch (Throwable paramString) {}
    return -1.0F;
  }
  
  public final int getInt(String paramString)
  {
    int i = -1;
    paramString = a(paramString, "I", false);
    if (paramString != null) {}
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString) {}
    return -1;
  }
  
  public final long getLong(String paramString)
  {
    long l = -1L;
    paramString = a(paramString, "J", false);
    if (paramString != null) {}
    try
    {
      l = Long.parseLong(paramString);
      return l;
    }
    catch (Throwable paramString) {}
    return -1L;
  }
  
  public final String getString(String paramString)
  {
    return a(paramString, "LString", false);
  }
  
  public final String getStringDDp(String paramString)
  {
    return a(paramString, "LString", true);
  }
  
  public final int putBoolean(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0") {
      return a(paramString, str, "Z", false);
    }
  }
  
  public final int putByteArray(String paramString, byte[] paramArrayOfByte)
  {
    return a(paramString, com.alibaba.wireless.security.open.a.a.a(paramArrayOfByte), "[B", false);
  }
  
  public final int putByteArrayDDp(String paramString, byte[] paramArrayOfByte)
  {
    return a(paramString, com.alibaba.wireless.security.open.a.a.a(paramArrayOfByte), "[B", true);
  }
  
  public final int putFloat(String paramString, float paramFloat)
  {
    return a(paramString, Float.toString(paramFloat), "F", false);
  }
  
  public final int putInt(String paramString, int paramInt)
  {
    return a(paramString, Integer.toString(paramInt), "I", false);
  }
  
  public final int putLong(String paramString, long paramLong)
  {
    return a(paramString, Long.toString(paramLong), "J", false);
  }
  
  public final int putString(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "LString", false);
  }
  
  public final int putStringDDp(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "LString", true);
  }
  
  public final void removeBoolean(String paramString)
  {
    b(paramString, "Z", false);
  }
  
  public final void removeByteArray(String paramString)
  {
    b(paramString, "[B", false);
  }
  
  public final void removeByteArrayDDp(String paramString)
  {
    b(paramString, "[B", true);
  }
  
  public final void removeFloat(String paramString)
  {
    b(paramString, "F", false);
  }
  
  public final void removeInt(String paramString)
  {
    b(paramString, "I", false);
  }
  
  public final void removeLong(String paramString)
  {
    b(paramString, "J", false);
  }
  
  public final void removeString(String paramString)
  {
    b(paramString, "LString", false);
  }
  
  public final void removeStringDDp(String paramString)
  {
    b(paramString, "LString", true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\dynamicdatastore\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
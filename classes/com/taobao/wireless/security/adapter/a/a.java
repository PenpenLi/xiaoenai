package com.taobao.wireless.security.adapter.a;

import android.content.Context;
import com.taobao.wireless.security.adapter.JNICLibrary;
import java.util.HashSet;

public final class a
{
  private JNICLibrary a = JNICLibrary.a();
  private Context b;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public final int a(String... paramVarArgs)
  {
    Object localObject1 = new HashSet();
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      i = 0;
      while (i < j)
      {
        localObject2 = paramVarArgs[i];
        if (!com.taobao.wireless.security.adapter.common.a.a(new String[] { localObject2 })) {
          ((HashSet)localObject1).add(localObject2);
        }
        i += 1;
      }
    }
    paramVarArgs = new String[((HashSet)localObject1).size()];
    ((HashSet)localObject1).toArray(paramVarArgs);
    localObject1 = this.a;
    int i = paramVarArgs.length;
    Object localObject2 = this.b;
    return ((Integer)((JNICLibrary)localObject1).doCommandNative(1503, new int[] { i }, null, null, new Object[] { paramVarArgs, localObject2 })).intValue();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
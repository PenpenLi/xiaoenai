package com.mob.tools.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.e;
import com.mob.tools.log.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class i
{
  private Context a;
  private SharedPreferences b;
  
  public i(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  public String a(String paramString)
  {
    return this.b.getString(paramString, "");
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = paramString + "_" + paramInt;
    this.b = this.a.getSharedPreferences(paramString, 0);
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putBoolean(paramString, paramBoolean.booleanValue());
    localEditor.commit();
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putInt(paramString, paramInteger.intValue());
    localEditor.commit();
  }
  
  public void a(String paramString, Long paramLong)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putLong(paramString, paramLong.longValue());
    localEditor.commit();
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      a(paramString, Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
      return;
    }
    catch (Throwable paramString)
    {
      e.a().w(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public boolean b(String paramString)
  {
    return this.b.getBoolean(paramString, false);
  }
  
  public long c(String paramString)
  {
    return this.b.getLong(paramString, 0L);
  }
  
  public int d(String paramString)
  {
    return this.b.getInt(paramString, 0);
  }
  
  public Object e(String paramString)
  {
    try
    {
      paramString = a(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(paramString, 2)));
      Object localObject = paramString.readObject();
      paramString.close();
      return localObject;
    }
    catch (Throwable paramString)
    {
      e.a().w(paramString);
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.mob.tools.b;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.e;
import com.mob.tools.log.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.HashMap;

public class f
{
  private File a;
  private HashMap<String, Object> b;
  
  private void a()
  {
    if (this.b == null) {}
    while (this.a == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.a.getParentFile().exists()) {
          this.a.getParentFile().mkdirs();
        }
        synchronized (this.b)
        {
          Object localObject1 = new FileOutputStream(this.a);
          if (((FileOutputStream)localObject1).getChannel().tryLock() != null)
          {
            localObject1 = new ObjectOutputStream((OutputStream)localObject1);
            ((ObjectOutputStream)localObject1).writeObject(this.b);
            ((ObjectOutputStream)localObject1).flush();
            ((ObjectOutputStream)localObject1).close();
            return;
          }
        }
        ((FileOutputStream)localObject2).close();
      }
      catch (Throwable localThrowable)
      {
        e.a().w(localThrowable);
        return;
      }
    }
  }
  
  private void b(String paramString, Object paramObject)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    this.b.put(paramString, paramObject);
  }
  
  private Object e(String paramString)
  {
    if (this.b == null) {
      return null;
    }
    return this.b.get(paramString);
  }
  
  public void a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.a = new File(paramString);
      if (this.a.exists())
      {
        paramString = new ObjectInputStream(new FileInputStream(this.a));
        this.b = ((HashMap)paramString.readObject());
        paramString.close();
        return;
      }
    }
    catch (Throwable paramString)
    {
      e.a().w(paramString);
    }
  }
  
  public void a(String paramString, Long paramLong)
  {
    b(paramString, paramLong);
    a();
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
    b(paramString1, paramString2);
    a();
  }
  
  public String b(String paramString)
  {
    paramString = e(paramString);
    if (paramString == null) {
      return null;
    }
    if ((paramString instanceof String)) {
      return (String)paramString;
    }
    return String.valueOf(paramString);
  }
  
  public long c(String paramString)
  {
    paramString = e(paramString);
    if (paramString == null) {
      return 0L;
    }
    if ((paramString instanceof Long)) {
      return ((Long)paramString).longValue();
    }
    return 0L;
  }
  
  public Object d(String paramString)
  {
    try
    {
      paramString = b(paramString);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
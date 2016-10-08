package cn.sharesdk.framework.statistics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.statistics.a.e;
import cn.sharesdk.framework.statistics.b.f;
import cn.sharesdk.framework.statistics.b.f.a;
import com.mob.tools.b.g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

public class a
{
  private static a a;
  private c b;
  private e c;
  private boolean d;
  
  private a(Context paramContext, String paramString)
  {
    this.b = new c(paramContext, paramString);
    this.c = e.a(paramContext);
  }
  
  public static a a(Context paramContext, String paramString)
  {
    if (a == null) {
      a = new a(paramContext, paramString);
    }
    return a;
  }
  
  private String a(Bitmap paramBitmap, b paramb)
  {
    File localFile = File.createTempFile("bm_tmp", ".png");
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
    return a(localFile.getAbsolutePath(), paramb);
  }
  
  private String a(String paramString, b paramb)
  {
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
      return null;
    }
    Bitmap.CompressFormat localCompressFormat = com.mob.tools.b.a.b(paramString);
    float f = 200.0F;
    if (paramb == b.b) {
      f = 600.0F;
    }
    paramb = new BitmapFactory.Options();
    paramb.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, paramb);
    paramb.inJustDecodeBounds = false;
    int i = paramb.outWidth;
    int j = paramb.outHeight;
    if ((i >= j) && (j > f)) {}
    for (i = (int)Math.ceil(paramb.outHeight / f);; i = (int)Math.ceil(paramb.outWidth / f))
    {
      j = i;
      if (i <= 0) {
        j = 1;
      }
      paramb = new BitmapFactory.Options();
      paramb.inSampleSize = j;
      paramb.inPurgeable = true;
      paramb.inInputShareable = true;
      paramString = BitmapFactory.decodeFile(paramString, paramb);
      paramString.getHeight();
      paramString.getWidth();
      paramb = File.createTempFile("bm_tmp2", "." + localCompressFormat.name().toLowerCase());
      FileOutputStream localFileOutputStream = new FileOutputStream(paramb);
      paramString.compress(localCompressFormat, 80, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return c(paramb.getAbsolutePath());
      if ((i >= j) || (i <= f)) {
        break;
      }
    }
    return c(paramString);
  }
  
  private String a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    Object localObject2;
    String str;
    do
    {
      do
      {
        return paramString1;
        localObject1 = new ArrayList();
        paramString2 = Pattern.compile(paramString2);
        localObject2 = paramString2.matcher(paramString1);
        while (((Matcher)localObject2).find())
        {
          str = ((Matcher)localObject2).group();
          if ((str != null) && (str.length() > 0)) {
            ((ArrayList)localObject1).add(str);
          }
        }
      } while (((ArrayList)localObject1).size() == 0);
      paramString3 = this.b.a(paramString1, (ArrayList)localObject1, paramInt, paramString3);
    } while ((paramString3 == null) || (paramString3.size() <= 0) || (!paramString3.containsKey("data")));
    Object localObject1 = (ArrayList)paramString3.get("data");
    paramString3 = new HashMap();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (HashMap)((Iterator)localObject1).next();
      str = String.valueOf(((HashMap)localObject2).get("surl"));
      paramString3.put(String.valueOf(((HashMap)localObject2).get("source")), str);
    }
    paramString2 = paramString2.matcher(paramString1);
    localObject1 = new StringBuilder();
    for (paramInt = 0; paramString2.find(); paramInt = paramString2.end())
    {
      ((StringBuilder)localObject1).append(paramString1.substring(paramInt, paramString2.start()));
      ((StringBuilder)localObject1).append((String)paramString3.get(paramString2.group()));
    }
    ((StringBuilder)localObject1).append(paramString1.substring(paramInt, paramString1.length()));
    paramString1 = ((StringBuilder)localObject1).toString();
    cn.sharesdk.framework.utils.d.a().i("> SERVER_SHORT_LINK_URL content after replace link ===  %s", new Object[] { paramString1 });
    return paramString1;
  }
  
  private void a(cn.sharesdk.framework.statistics.b.b paramb)
  {
    boolean bool = this.c.c();
    String str = paramb.c;
    if ((bool) && (!TextUtils.isEmpty(str)))
    {
      paramb.c = com.mob.tools.b.b.b(str, paramb.f.substring(0, 16));
      return;
    }
    paramb.d = null;
    paramb.c = null;
  }
  
  private void a(f paramf)
  {
    int k = 0;
    int i = this.c.e();
    boolean bool = this.c.c();
    f.a locala = paramf.d;
    int j;
    String str;
    if ((i == 1) || ((i == 0) && (this.d)))
    {
      if ((locala == null) || (locala.e == null)) {}
      for (i = 0;; i = locala.e.size())
      {
        j = 0;
        while (j < i)
        {
          str = a((String)locala.e.get(j), b.a);
          if (!TextUtils.isEmpty(str)) {
            locala.d.add(str);
          }
          j += 1;
        }
      }
      if ((locala == null) || (locala.f == null))
      {
        i = 0;
        j = k;
      }
    }
    while (j < i)
    {
      str = a((Bitmap)locala.f.get(j), b.a);
      if (!TextUtils.isEmpty(str)) {
        locala.d.add(str);
      }
      j += 1;
      continue;
      i = locala.f.size();
      j = k;
      continue;
      paramf.d = null;
    }
    if (!bool) {
      paramf.n = null;
    }
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return this.b.a(paramString, paramBoolean);
  }
  
  private String c(String paramString)
  {
    paramString = this.b.c(paramString);
    if ((paramString == null) || (paramString.size() <= 0)) {}
    while ((!paramString.containsKey("status")) || (g.d(String.valueOf(paramString.get("status"))) != 200) || (!paramString.containsKey("url"))) {
      return null;
    }
    return (String)paramString.get("url");
  }
  
  private String d(String paramString)
  {
    paramString = new ByteArrayInputStream(paramString.getBytes());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject = new GZIPOutputStream(localByteArrayOutputStream);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramString.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      ((GZIPOutputStream)localObject).write(arrayOfByte, 0, i);
    }
    ((GZIPOutputStream)localObject).flush();
    ((GZIPOutputStream)localObject).close();
    localObject = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    paramString.close();
    return Base64.encodeToString((byte[])localObject, 2);
  }
  
  public String a(Bitmap paramBitmap)
  {
    try
    {
      paramBitmap = a(paramBitmap, b.b);
      return paramBitmap;
    }
    catch (Throwable paramBitmap)
    {
      cn.sharesdk.framework.utils.d.a().w(paramBitmap);
    }
    return null;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = a(paramString, b.b);
      return paramString;
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
    }
    return null;
  }
  
  public String a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    try
    {
      if (this.c.i())
      {
        if (!this.c.d()) {
          return paramString1;
        }
        if (paramBoolean)
        {
          String str = a(paramString1, "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>", paramInt, paramString2);
          if ((str != null) && (!str.equals(paramString1))) {
            return str;
          }
        }
        paramString2 = a(paramString1, "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+", paramInt, paramString2);
        if (paramString2 != null)
        {
          paramBoolean = paramString2.equals(paramString1);
          if (!paramBoolean) {
            return paramString2;
          }
        }
      }
    }
    catch (Throwable paramString2)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString2);
    }
    return paramString1;
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        long l1 = this.c.j().longValue();
        long l2 = System.currentTimeMillis();
        Object localObject = Calendar.getInstance();
        ((Calendar)localObject).setTimeInMillis(l1);
        int i = ((Calendar)localObject).get(5);
        ((Calendar)localObject).setTimeInMillis(l2);
        int j = ((Calendar)localObject).get(5);
        if ((l2 - l1 < 86400000L) && (i == j)) {
          return;
        }
        localObject = this.b.a();
        if (((HashMap)localObject).containsKey("res"))
        {
          bool = "true".equals(String.valueOf(((HashMap)localObject).get("res")));
          this.c.a(bool);
          if ((localObject == null) || (((HashMap)localObject).size() <= 0)) {
            break;
          }
          this.c.b(System.currentTimeMillis());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable);
        return;
      }
      boolean bool = true;
    }
  }
  
  public void a(cn.sharesdk.framework.statistics.b.c paramc)
  {
    for (;;)
    {
      try
      {
        if (!this.c.i()) {
          return;
        }
        if ((paramc instanceof cn.sharesdk.framework.statistics.b.b))
        {
          a((cn.sharesdk.framework.statistics.b.b)paramc);
          if (!this.c.b()) {
            paramc.m = null;
          }
          long l2 = this.c.a();
          long l1 = l2;
          if (l2 == 0L) {
            l1 = this.b.b();
          }
          paramc.e = (System.currentTimeMillis() - l1);
          this.b.a(paramc);
          return;
        }
      }
      catch (Throwable paramc)
      {
        cn.sharesdk.framework.utils.d.a().w(paramc);
        return;
      }
      if ((paramc instanceof f)) {
        a((f)paramc);
      }
    }
  }
  
  public void a(String paramString, ArrayList<HashMap<String, String>> paramArrayList)
  {
    try
    {
      if (!this.c.i()) {
        return;
      }
      this.b.a(paramString, paramArrayList);
      return;
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
    }
  }
  
  public void a(HashMap<String, Object> paramHashMap)
  {
    try
    {
      this.b.c(paramHashMap);
      return;
    }
    catch (Throwable paramHashMap)
    {
      cn.sharesdk.framework.utils.d.a().w(paramHashMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    try
    {
      this.b.a(paramInt1, paramInt2);
      return true;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
    }
    return false;
  }
  
  public HashMap<String, Object> b(String paramString)
  {
    try
    {
      paramString = this.b.d(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
    }
    return new HashMap();
  }
  
  public void b()
  {
    try
    {
      if (!this.c.i()) {
        return;
      }
      this.c.a(System.currentTimeMillis());
      HashMap localHashMap = this.b.c();
      if ((localHashMap.containsKey("status")) && (g.d(String.valueOf(localHashMap.get("status"))) == 65336))
      {
        cn.sharesdk.framework.utils.d.a().d((String)localHashMap.get("error"), new Object[0]);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
      return;
    }
    if (localThrowable.containsKey("timestamp"))
    {
      long l1 = g.e(String.valueOf(localThrowable.get("timestamp")));
      long l2 = System.currentTimeMillis();
      this.c.a("service_time", Long.valueOf(l2 - l1));
    }
    Object localObject4;
    Object localObject2;
    Object localObject3;
    String str;
    if (localThrowable.containsKey("switchs"))
    {
      localObject4 = (HashMap)localThrowable.get("switchs");
      if (localObject4 != null)
      {
        localObject2 = String.valueOf(((HashMap)localObject4).get("device"));
        localObject3 = String.valueOf(((HashMap)localObject4).get("share"));
        str = String.valueOf(((HashMap)localObject4).get("auth"));
        localObject4 = String.valueOf(((HashMap)localObject4).get("backflow"));
        this.c.b((String)localObject2);
        this.c.d((String)localObject3);
        this.c.c(str);
        this.c.a((String)localObject4);
      }
    }
    if (localThrowable.containsKey("serpaths"))
    {
      localObject2 = (HashMap)localThrowable.get("serpaths");
      if (localObject2 != null)
      {
        Object localObject1 = String.valueOf(((HashMap)localObject2).get("defhost"));
        localObject3 = String.valueOf(((HashMap)localObject2).get("defport"));
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
          this.b.a("http://" + (String)localObject1 + ":" + (String)localObject3);
        }
        localObject1 = new HashMap();
        if (((HashMap)localObject2).containsKey("assigns"))
        {
          localObject2 = (HashMap)((HashMap)localObject2).get("assigns");
          if ((localObject2 == null) || (((HashMap)localObject2).size() == 0))
          {
            this.b.a(null);
            return;
          }
          localObject3 = ((HashMap)localObject2).keySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            str = (String)((Iterator)localObject3).next();
            Object localObject5 = (HashMap)((HashMap)localObject2).get(str);
            localObject4 = String.valueOf(((HashMap)localObject5).get("host"));
            localObject5 = String.valueOf(((HashMap)localObject5).get("port"));
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject5))) {
              ((HashMap)localObject1).put(str, "http://" + (String)localObject4 + ":" + (String)localObject5);
            }
          }
          this.b.a((HashMap)localObject1);
        }
      }
    }
  }
  
  public void c()
  {
    try
    {
      if (!this.c.i()) {
        return;
      }
      String str1 = this.c.f();
      HashMap localHashMap = this.b.d();
      String str2 = String.valueOf(localHashMap);
      if (!str2.equals(str1))
      {
        this.c.f(str2);
        this.b.b(localHashMap);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
    }
  }
  
  public void d()
  {
    try
    {
      if (!this.c.i()) {
        return;
      }
      String str1 = this.c.g();
      String str2 = com.mob.tools.b.b.b(this.b.e(), "sdk.sharesdk.sdk");
      if (!str2.equals(str1))
      {
        this.c.g(str2);
        this.b.b(str2);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
    }
  }
  
  public void e()
  {
    for (;;)
    {
      int i;
      try
      {
        if (!this.c.i()) {
          return;
        }
        ArrayList localArrayList = this.b.g();
        i = 0;
        if (i < localArrayList.size())
        {
          cn.sharesdk.framework.statistics.a.c localc = (cn.sharesdk.framework.statistics.a.c)localArrayList.get(i);
          boolean bool;
          if (localc.b.size() == 1)
          {
            bool = a(localc.a, false);
            if (bool) {
              this.b.a(localc.b);
            }
          }
          else
          {
            bool = a(d(localc.a), true);
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable);
      }
      i += 1;
    }
  }
  
  public HashMap<String, Object> f()
  {
    try
    {
      HashMap localHashMap = this.b.h();
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
    }
    return new HashMap();
  }
  
  public HashMap<String, Object> g()
  {
    try
    {
      HashMap localHashMap = this.b.f();
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
    }
    return new HashMap();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\statistics\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package d.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.f.a.e;
import java.io.File;
import org.json.JSONObject;

public class dg
{
  private final byte[] a = { 0, 0, 0, 0, 0, 0, 0, 0 };
  private final int b = 1;
  private final int c = 0;
  private String d = "1.0";
  private String e = null;
  private byte[] f = null;
  private byte[] g = null;
  private byte[] h = null;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private byte[] l = null;
  private byte[] m = null;
  private boolean n = false;
  
  private dg(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      throw new Exception("entity is null or empty");
    }
    this.e = paramString;
    this.k = paramArrayOfByte1.length;
    this.l = au.a(paramArrayOfByte1);
    this.j = ((int)(System.currentTimeMillis() / 1000L));
    this.m = paramArrayOfByte2;
  }
  
  public static dg a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      String str2 = av.o(paramContext);
      String str3 = av.c(paramContext);
      SharedPreferences localSharedPreferences = t.a(paramContext);
      String str1 = localSharedPreferences.getString("signature", null);
      int i1 = localSharedPreferences.getInt("serial", 1);
      paramString = new dg(paramArrayOfByte, paramString, (str3 + str2).getBytes());
      paramString.a(str1);
      paramString.a(i1);
      paramString.b();
      localSharedPreferences.edit().putInt("serial", i1 + 1).putString("signature", paramString.a()).commit();
      paramString.b(paramContext);
      return paramString;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = t.a(paramContext);
    if (paramContext == null) {
      return null;
    }
    return paramContext.getString("signature", null);
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i6 = 0;
    byte[] arrayOfByte1 = e.b(this.m);
    byte[] arrayOfByte2 = e.b(this.l);
    int i7 = arrayOfByte1.length;
    byte[] arrayOfByte3 = new byte[i7 * 2];
    int i5 = 0;
    while (i5 < i7)
    {
      arrayOfByte3[(i5 * 2)] = arrayOfByte2[i5];
      arrayOfByte3[(i5 * 2 + 1)] = arrayOfByte1[i5];
      i5 += 1;
    }
    i5 = 0;
    while (i5 < 2)
    {
      arrayOfByte3[i5] = paramArrayOfByte[i5];
      arrayOfByte3[(arrayOfByte3.length - i5 - 1)] = paramArrayOfByte[(paramArrayOfByte.length - i5 - 1)];
      i5 += 1;
    }
    int i1 = (byte)(paramInt & 0xFF);
    int i2 = (byte)(paramInt >> 8 & 0xFF);
    int i3 = (byte)(paramInt >> 16 & 0xFF);
    int i4 = (byte)(paramInt >>> 24);
    paramInt = i6;
    while (paramInt < arrayOfByte3.length)
    {
      arrayOfByte3[paramInt] = ((byte)(arrayOfByte3[paramInt] ^ new byte[] { i1, i2, i3, i4 }[(paramInt % 4)]));
      paramInt += 1;
    }
    return arrayOfByte3;
  }
  
  public static dg b(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      String str2 = av.o(paramContext);
      String str3 = av.c(paramContext);
      SharedPreferences localSharedPreferences = t.a(paramContext);
      String str1 = localSharedPreferences.getString("signature", null);
      int i1 = localSharedPreferences.getInt("serial", 1);
      paramString = new dg(paramArrayOfByte, paramString, (str3 + str2).getBytes());
      paramString.a(true);
      paramString.a(str1);
      paramString.a(i1);
      paramString.b();
      localSharedPreferences.edit().putInt("serial", i1 + 1).putString("signature", paramString.a()).commit();
      paramString.b(paramContext);
      return paramString;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private byte[] d()
  {
    return a(this.a, (int)(System.currentTimeMillis() / 1000L));
  }
  
  private byte[] e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e.a(this.f));
    localStringBuilder.append(this.i);
    localStringBuilder.append(this.j);
    localStringBuilder.append(this.k);
    localStringBuilder.append(e.a(this.g));
    return e.b(localStringBuilder.toString().getBytes());
  }
  
  public String a()
  {
    return e.a(this.f);
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(String paramString)
  {
    this.f = e.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void b()
  {
    if (this.f == null) {
      this.f = d();
    }
    byte[] arrayOfByte;
    if (this.n) {
      arrayOfByte = new byte[16];
    }
    try
    {
      System.arraycopy(this.f, 1, arrayOfByte, 0, 16);
      this.l = e.a(this.l, arrayOfByte);
      this.g = a(this.f, this.j);
      this.h = e();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void b(Context paramContext)
  {
    String str1 = this.e;
    String str2 = dk.a(paramContext).b().c(null);
    String str3 = e.a(this.f);
    Object localObject = new byte[16];
    System.arraycopy(this.f, 2, localObject, 0, 16);
    localObject = e.a(e.b((byte[])localObject));
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appkey", str1);
      if (str2 != null) {
        localJSONObject.put("umid", str2);
      }
      localJSONObject.put("signature", str3);
      localJSONObject.put("checksum", localObject);
      str1 = localJSONObject.toString();
      paramContext = new File(paramContext.getFilesDir(), ".umeng");
      if (!paramContext.exists()) {
        paramContext.mkdir();
      }
      aw.a(new File(paramContext, "exchangeIdentity.json"), str1);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public byte[] c()
  {
    Object localObject = new aq();
    ((aq)localObject).a(this.d);
    ((aq)localObject).b(this.e);
    ((aq)localObject).c(e.a(this.f));
    ((aq)localObject).a(this.i);
    ((aq)localObject).b(this.j);
    ((aq)localObject).c(this.k);
    ((aq)localObject).a(this.l);
    if (this.n) {}
    for (int i1 = 1;; i1 = 0)
    {
      ((aq)localObject).d(i1);
      ((aq)localObject).d(e.a(this.g));
      ((aq)localObject).e(e.a(this.h));
      try
      {
        localObject = new bf().a((ba)localObject);
        return (byte[])localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public String toString()
  {
    int i1 = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("version : %s\n", new Object[] { this.d }));
    localStringBuilder.append(String.format("address : %s\n", new Object[] { this.e }));
    localStringBuilder.append(String.format("signature : %s\n", new Object[] { e.a(this.f) }));
    localStringBuilder.append(String.format("serial : %s\n", new Object[] { Integer.valueOf(this.i) }));
    localStringBuilder.append(String.format("timestamp : %d\n", new Object[] { Integer.valueOf(this.j) }));
    localStringBuilder.append(String.format("length : %d\n", new Object[] { Integer.valueOf(this.k) }));
    localStringBuilder.append(String.format("guid : %s\n", new Object[] { e.a(this.g) }));
    localStringBuilder.append(String.format("checksum : %s ", new Object[] { e.a(this.h) }));
    if (this.n) {}
    for (;;)
    {
      localStringBuilder.append(String.format("codex : %d", new Object[] { Integer.valueOf(i1) }));
      return localStringBuilder.toString();
      i1 = 0;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
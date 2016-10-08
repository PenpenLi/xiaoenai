package com.baidu.location;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class d
  extends s
{
  private static d c1 = null;
  Handler c2 = null;
  String c3 = null;
  String c4 = null;
  String c5 = null;
  
  private boolean U()
  {
    if (this.c3 == null) {}
    while (new File(c.jdMethod_goto() + File.separator + this.c3).exists()) {
      return true;
    }
    return jdMethod_for("http://" + this.c5 + "/" + this.c3, this.c3);
  }
  
  private void V()
  {
    if (this.c4 == null) {}
    File localFile2;
    do
    {
      return;
      localFile2 = new File(c.jdMethod_goto() + File.separator + this.c4);
    } while ((localFile2.exists()) || (!jdMethod_for("http://" + this.c5 + "/" + this.c4, this.c4)));
    File localFile1 = new File(c.jdMethod_goto() + File.separator + f.replaceFileName);
    if (localFile1.exists()) {
      localFile1.delete();
    }
    try
    {
      jdMethod_if(localFile2, localFile1);
      return;
    }
    catch (Exception localException)
    {
      localFile1.delete();
    }
  }
  
  private Handler W()
  {
    return this.c2;
  }
  
  public static d X()
  {
    if (c1 == null) {
      c1 = new d();
    }
    return c1;
  }
  
  private void Y()
  {
    if (this.c5 == null) {}
    while (!ar.bU()) {
      return;
    }
    new d.3(this).start();
  }
  
  private static boolean jdMethod_for(String paramString1, String paramString2)
  {
    File localFile = new File(c.jdMethod_goto() + File.separator + "tmp");
    if (localFile.exists()) {
      localFile.delete();
    }
    FileOutputStream localFileOutputStream;
    try
    {
      localFileOutputStream = new FileOutputStream(localFile);
      byte[] arrayOfByte = new byte['က'];
      paramString1 = (HttpURLConnection)new URL(paramString1).openConnection();
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramString1.getInputStream());
      for (;;)
      {
        int i = localBufferedInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
      paramString1.disconnect();
    }
    catch (Exception paramString1)
    {
      localFile.delete();
      return false;
    }
    localFileOutputStream.close();
    if (localFile.length() < 10240L)
    {
      localFile.delete();
      return false;
    }
    localFile.renameTo(new File(c.jdMethod_goto() + File.separator + paramString2));
    return true;
  }
  
  /* Error */
  public static void jdMethod_if(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 126	java/io/BufferedInputStream
    //   5: dup
    //   6: new 161	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 162	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: invokespecial 133	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: new 164	java/io/BufferedOutputStream
    //   21: dup
    //   22: new 112	java/io/FileOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: invokespecial 167	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   33: astore_1
    //   34: sipush 5120
    //   37: newarray <illegal type>
    //   39: astore_2
    //   40: aload_0
    //   41: aload_2
    //   42: invokevirtual 137	java/io/BufferedInputStream:read	([B)I
    //   45: istore 4
    //   47: iload 4
    //   49: iconst_m1
    //   50: if_icmpeq +37 -> 87
    //   53: aload_1
    //   54: aload_2
    //   55: iconst_0
    //   56: iload 4
    //   58: invokevirtual 168	java/io/BufferedOutputStream:write	([BII)V
    //   61: goto -21 -> 40
    //   64: astore_3
    //   65: aload_0
    //   66: astore_2
    //   67: aload_3
    //   68: astore_0
    //   69: aload_2
    //   70: ifnull +7 -> 77
    //   73: aload_2
    //   74: invokevirtual 169	java/io/BufferedInputStream:close	()V
    //   77: aload_1
    //   78: ifnull +7 -> 85
    //   81: aload_1
    //   82: invokevirtual 170	java/io/BufferedOutputStream:close	()V
    //   85: aload_0
    //   86: athrow
    //   87: aload_1
    //   88: invokevirtual 173	java/io/BufferedOutputStream:flush	()V
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 169	java/io/BufferedInputStream:close	()V
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 170	java/io/BufferedOutputStream:close	()V
    //   107: return
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_1
    //   111: goto -42 -> 69
    //   114: astore_3
    //   115: aconst_null
    //   116: astore_1
    //   117: aload_0
    //   118: astore_2
    //   119: aload_3
    //   120: astore_0
    //   121: goto -52 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramFile1	File
    //   0	124	1	paramFile2	File
    //   1	118	2	localObject1	Object
    //   64	4	3	localObject2	Object
    //   114	6	3	localObject3	Object
    //   45	12	4	i	int
    // Exception table:
    //   from	to	target	type
    //   34	40	64	finally
    //   40	47	64	finally
    //   53	61	64	finally
    //   87	91	64	finally
    //   2	18	108	finally
    //   18	34	114	finally
  }
  
  void T()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&sdk=");
    localStringBuffer.append(4.2F);
    localStringBuffer.append("&fw=");
    localStringBuffer.append(f.getFrameVersion());
    localStringBuffer.append("&suit=");
    localStringBuffer.append(2);
    if (az.cn().iP == null)
    {
      localStringBuffer.append("&im=");
      localStringBuffer.append(az.cn().iL);
    }
    for (;;)
    {
      localStringBuffer.append("&mb=");
      localStringBuffer.append(Build.MODEL);
      localStringBuffer.append("&sv=");
      String str2 = Build.VERSION.RELEASE;
      String str1 = str2;
      if (str2 != null)
      {
        str1 = str2;
        if (str2.length() > 10) {
          str1 = str2.substring(0, 10);
        }
      }
      localStringBuffer.append(str1);
      localStringBuffer.append("&pack=");
      localStringBuffer.append(az.iH);
      this.cR = (c.jdMethod_int() + "?&it=" + Jni.l(localStringBuffer.toString()));
      return;
      localStringBuffer.append("&cu=");
      localStringBuffer.append(az.cn().iP);
    }
  }
  
  public void Z()
  {
    long l = e.jdMethod_do().jdMethod_if();
    if (System.currentTimeMillis() - l > 172800000L) {
      W().postDelayed(new d.1(this), 10000L);
    }
  }
  
  void jdMethod_do(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(EntityUtils.toString(this.cS, "utf-8"));
      if ("up".equals(localJSONObject.getString("res")))
      {
        this.c5 = localJSONObject.getString("upath");
        if (localJSONObject.has("u1")) {
          this.c4 = localJSONObject.getString("u1");
        }
        if (localJSONObject.has("u2")) {
          this.c3 = localJSONObject.getString("u2");
        }
        W().post(new d.2(this));
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    e.jdMethod_do().a(System.currentTimeMillis());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
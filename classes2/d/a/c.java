package d.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
  extends de
{
  private static final Pattern a = Pattern.compile("UTDID\">([^<]+)");
  private Context b;
  
  public c(Context paramContext)
  {
    super("utdid");
    this.b = paramContext;
  }
  
  private String b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = a.matcher(paramString);
    } while (!paramString.find());
    return paramString.group(1);
  }
  
  /* Error */
  private String g()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 53	d/a/c:h	()Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: invokevirtual 58	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 60	java/io/FileInputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 63	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: invokestatic 68	d/a/aw:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   32: invokespecial 70	d/a/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_2
    //   36: aload_1
    //   37: invokestatic 74	d/a/aw:c	(Ljava/io/InputStream;)V
    //   40: aload_2
    //   41: areturn
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   47: aconst_null
    //   48: areturn
    //   49: astore_2
    //   50: aload_1
    //   51: invokestatic 74	d/a/aw:c	(Ljava/io/InputStream;)V
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	c
    //   4	33	1	localObject1	Object
    //   42	9	1	localException	Exception
    //   35	6	2	str	String
    //   49	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	27	42	java/lang/Exception
    //   36	40	42	java/lang/Exception
    //   50	56	42	java/lang/Exception
    //   27	36	49	finally
  }
  
  private File h()
  {
    if (!av.a(this.b, "android.permission.WRITE_EXTERNAL_STORAGE")) {}
    while (!Environment.getExternalStorageState().equals("mounted")) {
      return null;
    }
    File localFile = Environment.getExternalStorageDirectory();
    try
    {
      localFile = new File(localFile.getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
      return localFile;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String a()
  {
    try
    {
      String str = (String)Class.forName("com.ut.device.UTDevice").getMethod("getUtdid", new Class[] { Context.class }).invoke(null, new Object[] { this.b });
      return str;
    }
    catch (Exception localException) {}
    return g();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
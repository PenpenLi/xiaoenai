package d.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

public class aa
  implements s
{
  private static aa h = null;
  private boolean a = false;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private float e = 0.0F;
  private float f = 0.0F;
  private Context g = null;
  
  private aa(Context paramContext, String paramString, int paramInt)
  {
    this.g = paramContext;
    a(paramString, paramInt);
  }
  
  public static aa a(Context paramContext)
  {
    try
    {
      if (h == null)
      {
        dk.a locala = dk.a(paramContext).b();
        h = new aa(paramContext, locala.b(null), locala.d(0));
      }
      paramContext = h;
      return paramContext;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return false;
          paramString = paramString.split("\\|");
        } while (paramString.length != 6);
        if ((paramString[0].startsWith("SIG7")) && (paramString[1].split(",").length == paramString[5].split(",").length)) {
          return true;
        }
      } while (!paramString[0].startsWith("FIXED"));
      i = paramString[5].split(",").length;
      j = Integer.parseInt(paramString[1]);
    } while ((i < j) || (j < 1));
    return true;
  }
  
  private float b(String paramString, int paramInt)
  {
    paramInt *= 2;
    if (paramString == null) {
      return 0.0F;
    }
    return Integer.valueOf(paramString.substring(paramInt, paramInt + 5), 16).intValue() / 1048576.0F;
  }
  
  private void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String[] arrayOfString = paramString.split("\\|");
    if (arrayOfString[2].equals("SIG13")) {}
    for (float f1 = Float.valueOf(arrayOfString[3]).floatValue();; f1 = 0.0F)
    {
      if (this.e > f1)
      {
        this.a = false;
        return;
      }
      float[] arrayOfFloat = null;
      int i;
      if (arrayOfString[0].equals("SIG7"))
      {
        paramString = arrayOfString[1].split(",");
        arrayOfFloat = new float[paramString.length];
        i = 0;
        while (i < paramString.length)
        {
          arrayOfFloat[i] = Float.valueOf(paramString[i]).floatValue();
          i += 1;
        }
      }
      int[] arrayOfInt = null;
      paramString = null;
      Object localObject;
      if (arrayOfString[4].equals("RPT"))
      {
        localObject = arrayOfString[5].split(",");
        paramString = new int[localObject.length];
        i = 0;
        while (i < localObject.length)
        {
          paramString[i] = Integer.valueOf(localObject[i]).intValue();
          i += 1;
        }
        label181:
        f1 = 0.0F;
        i = 0;
        if (i >= arrayOfFloat.length) {
          break label361;
        }
        f1 += arrayOfFloat[i];
        if (this.f >= f1) {
          break label340;
        }
      }
      for (;;)
      {
        if (i != -1)
        {
          this.a = true;
          this.d = (i + 1);
          if (paramString == null) {
            break;
          }
          this.b = paramString[i];
          return;
          if (!arrayOfString[4].equals("DOM")) {
            break label181;
          }
          if (av.l(this.g))
          {
            this.a = false;
            return;
          }
          localObject = arrayOfInt;
        }
        try
        {
          arrayOfString = arrayOfString[5].split(",");
          localObject = arrayOfInt;
          arrayOfInt = new int[arrayOfString.length];
          i = 0;
          for (;;)
          {
            paramString = arrayOfInt;
            localObject = arrayOfInt;
            if (i >= arrayOfString.length) {
              break;
            }
            localObject = arrayOfInt;
            arrayOfInt[i] = Integer.valueOf(arrayOfString[i]).intValue();
            i += 1;
          }
          label340:
          i += 1;
        }
        catch (Exception paramString)
        {
          paramString = (String)localObject;
        }
        this.a = false;
        return;
        break label181;
        label361:
        i = -1;
      }
    }
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String[] arrayOfString = paramString.split("\\|");
    float f1 = 0.0F;
    if (arrayOfString[2].equals("SIG13")) {
      f1 = Float.valueOf(arrayOfString[3]).floatValue();
    }
    if (this.e > f1)
    {
      this.a = false;
      return;
    }
    if (arrayOfString[0].equals("FIXED")) {}
    for (int i = Integer.valueOf(arrayOfString[1]).intValue();; i = -1)
    {
      int[] arrayOfInt = null;
      paramString = null;
      Object localObject;
      int j;
      if (arrayOfString[4].equals("RPT"))
      {
        localObject = arrayOfString[5].split(",");
        paramString = new int[localObject.length];
        j = 0;
        while (j < localObject.length)
        {
          paramString[j] = Integer.valueOf(localObject[j]).intValue();
          j += 1;
        }
      }
      for (;;)
      {
        if (i != -1)
        {
          this.a = true;
          this.d = i;
          if (paramString == null) {
            break;
          }
          this.b = paramString[(i - 1)];
          return;
          if (!arrayOfString[4].equals("DOM")) {
            continue;
          }
          if (av.l(this.g))
          {
            this.a = false;
            return;
          }
          localObject = arrayOfInt;
        }
        try
        {
          arrayOfString = arrayOfString[5].split(",");
          localObject = arrayOfInt;
          arrayOfInt = new int[arrayOfString.length];
          j = 0;
          for (;;)
          {
            paramString = arrayOfInt;
            localObject = arrayOfInt;
            if (j >= arrayOfString.length) {
              break;
            }
            localObject = arrayOfInt;
            arrayOfInt[j] = Integer.valueOf(arrayOfString[j]).intValue();
            j += 1;
          }
          this.a = false;
          return;
        }
        catch (Exception paramString)
        {
          paramString = (String)localObject;
        }
      }
    }
  }
  
  public void a(dk.a parama)
  {
    a(parama.b(null), parama.d(0));
  }
  
  public void a(z paramz)
  {
    if (!this.a) {
      return;
    }
    paramz.b.f.put("client_test", Integer.valueOf(this.d));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.c = paramInt;
    String str = dg.a(this.g);
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString))) {
      this.a = false;
    }
    do
    {
      return;
      try
      {
        this.e = b(str, 12);
        this.f = b(str, 6);
        if (paramString.startsWith("SIG7"))
        {
          b(paramString);
          return;
        }
      }
      catch (Exception localException)
      {
        this.a = false;
        ax.b("v:" + paramString, localException);
        return;
      }
    } while (!paramString.startsWith("FIXED"));
    c(paramString);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" p13:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" p07:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" policy:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" interval:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
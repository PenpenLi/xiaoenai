package com.xiaoenai.app.classes.chat.input.faces;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.utils.f.a;
import java.text.DecimalFormat;
import java.util.HashMap;

public class d
{
  private static d a = null;
  private HashMap<String, Bitmap> b = new HashMap();
  private HashMap<String, Integer> c = new HashMap();
  private final String[] d = Xiaoenai.j().getResources().getStringArray(2131427328);
  private int e = 6;
  
  private d()
  {
    b();
  }
  
  private int a(int paramInt)
  {
    return 57600 / paramInt;
  }
  
  /* Error */
  public static d a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 19	com/xiaoenai/app/classes/chat/input/faces/d:a	Lcom/xiaoenai/app/classes/chat/input/faces/d;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 19	com/xiaoenai/app/classes/chat/input/faces/d:a	Lcom/xiaoenai/app/classes/chat/input/faces/d;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/xiaoenai/app/classes/chat/input/faces/d
    //   21: dup
    //   22: invokespecial 57	com/xiaoenai/app/classes/chat/input/faces/d:<init>	()V
    //   25: putstatic 19	com/xiaoenai/app/classes/chat/input/faces/d:a	Lcom/xiaoenai/app/classes/chat/input/faces/d;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 19	com/xiaoenai/app/classes/chat/input/faces/d:a	Lcom/xiaoenai/app/classes/chat/input/faces/d;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	locald	d
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private void b()
  {
    Thread localThread = new Thread(new e(this));
    localThread.setPriority(1);
    localThread.start();
  }
  
  private Bitmap c(String paramString)
  {
    Resources localResources = Xiaoenai.j().getResources();
    String[] arrayOfString = this.d;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (str.equals(paramString))
      {
        i = localResources.getIdentifier("emoji_" + str.substring(1, str.length() - 1), "drawable", "com.xiaoenai.app");
        paramString = BitmapFactory.decodeResource(localResources, i, d());
        this.b.put(str, paramString);
        this.c.put(str, Integer.valueOf(i));
        return paramString;
      }
      i += 1;
    }
    return null;
  }
  
  private void c()
  {
    Object localObject = Xiaoenai.j().getResources();
    String[] arrayOfString1 = ((Resources)localObject).getStringArray(2131427331);
    int k = arrayOfString1.length;
    DecimalFormat localDecimalFormat = new DecimalFormat("000");
    String[] arrayOfString2 = ((Resources)localObject).getStringArray(2131427332);
    int j = arrayOfString1.length;
    BitmapFactory.Options localOptions = d();
    int i = 1;
    if (i < k)
    {
      if (i < 64) {
        localObject = "face" + localDecimalFormat.format(i);
      }
      for (;;)
      {
        int m = Xiaoenai.j().getResources().getIdentifier((String)localObject, "drawable", "com.xiaoenai.app");
        localObject = BitmapFactory.decodeResource(Xiaoenai.j().getResources(), m, localOptions);
        this.b.put(arrayOfString1[i], localObject);
        this.c.put(arrayOfString1[i], Integer.valueOf(m));
        i += 1;
        break;
        if (i < k - 1) {
          localObject = "emoji_" + arrayOfString1[i].substring(1, arrayOfString1[i].length() - 1);
        } else {
          localObject = "face063";
        }
      }
    }
    i = 1;
    while (i < j)
    {
      if (i < 64)
      {
        localObject = "face" + localDecimalFormat.format(i);
        k = Xiaoenai.j().getResources().getIdentifier((String)localObject, "drawable", "com.xiaoenai.app");
        localObject = BitmapFactory.decodeResource(Xiaoenai.j().getResources(), k, localOptions);
        this.b.put(arrayOfString2[i], localObject);
        this.c.put(arrayOfString1[i], Integer.valueOf(k));
      }
      i += 1;
    }
  }
  
  private BitmapFactory.Options d()
  {
    int i = Xiaoenai.j().getResources().getDisplayMetrics().densityDpi;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (i > 0)
    {
      if (i >= 320) {
        break label125;
      }
      localOptions.inScaled = true;
      localOptions.inTargetDensity = 240;
      if (i >= 240) {
        break label115;
      }
      localOptions.inDensity = 480;
    }
    for (;;)
    {
      a.c("ClassicFaceFactory {} {} {} {} {}", new Object[] { Integer.valueOf(i), Integer.valueOf(localOptions.inDensity), Integer.valueOf(localOptions.outHeight), Integer.valueOf(localOptions.outWidth), Integer.valueOf(Build.VERSION.SDK_INT) });
      return localOptions;
      label115:
      localOptions.inDensity = 360;
      continue;
      label125:
      if (Build.VERSION.SDK_INT >= 20)
      {
        localOptions.inScaled = true;
        localOptions.inDensity = (i / 5);
      }
      else
      {
        localOptions.inScaled = true;
        localOptions.inTargetDensity = a(i);
        localOptions.inDensity = a(i);
      }
    }
  }
  
  public Bitmap a(String paramString)
  {
    Bitmap localBitmap2 = (Bitmap)this.b.get(paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = c(paramString);
    }
    return localBitmap1;
  }
  
  public SpannableStringBuilder a(String paramString, Context paramContext, int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    if (this.b.size() == 0) {
      return localSpannableStringBuilder;
    }
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i3;
    int i4;
    int i1;
    int i2;
    for (;;)
    {
      if (n < 300)
      {
        i3 = paramString.indexOf("[", i);
        i4 = paramString.indexOf("]", j);
        i1 = paramString.indexOf("{", k);
        i2 = paramString.indexOf("}", m);
        if ((i3 != -1) || (i4 != -1) || (i1 != -1) || (i2 != -1)) {}
      }
      else
      {
        return localSpannableStringBuilder;
      }
      if ((i3 == -1) || (i4 == -1)) {
        break label476;
      }
      if (i4 >= i3) {
        break;
      }
      i1 = i4 + 1;
      i = m;
      j = k;
      m = i3;
      k = i1;
      i1 = m;
      i2 = j;
      n += 1;
      j = k;
      m = i;
      k = i2;
      i = i1;
    }
    String str = paramString.substring(i3, i4 + 1);
    if ((a(str) != null) && (this.c.get(str) != null)) {
      localSpannableStringBuilder.setSpan(new j(paramContext, ((Integer)this.c.get(str)).intValue(), paramInt, paramInt), i3, str.length() + i3, 33);
    }
    j = i4 + 1;
    i = j;
    label476:
    for (;;)
    {
      n += 1;
      if ((i1 != -1) && (i2 != -1))
      {
        if (i2 < i1)
        {
          k = j;
          m = i;
          i = i2 + 1;
          j = i1;
          break;
        }
        str = paramString.substring(i1, i2 + 1);
        if (a(str) != null)
        {
          if (this.c.get(str) != null) {
            localSpannableStringBuilder.setSpan(new j(paramContext, ((Integer)this.c.get(str)).intValue(), paramInt, paramInt), i1, str.length() + i1, 33);
          }
          i2 += 1;
          k = i2;
          m = j;
          i1 = i;
          i = i2;
          j = k;
          k = m;
          m = i1;
          break;
        }
        m = i;
        i = i2;
        k = j;
        j = i1;
        break;
      }
      i1 = j;
      j = m;
      m = i;
      i = j;
      j = k;
      k = i1;
      break;
    }
  }
  
  public void a(TextView paramTextView)
  {
    paramTextView.setText(a(paramTextView.getText().toString().trim(), paramTextView.getContext(), (int)paramTextView.getTextSize() + this.e));
  }
  
  public void a(TextView paramTextView, boolean paramBoolean)
  {
    String str = paramTextView.getText().toString();
    if (paramBoolean) {
      str.trim();
    }
    paramTextView.setText(a(str, paramTextView.getContext(), (int)paramTextView.getTextSize() + this.e));
  }
  
  public Integer b(String paramString)
  {
    return (Integer)this.c.get(paramString);
  }
  
  public void b(TextView paramTextView)
  {
    paramTextView.setText(a(paramTextView.getText().toString().trim(), paramTextView.getContext(), (int)paramTextView.getTextSize() + this.e + 6));
  }
  
  public void c(TextView paramTextView)
  {
    paramTextView.setText(a(paramTextView.getText().toString().trim(), paramTextView.getContext(), (int)paramTextView.getTextSize() + this.e));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
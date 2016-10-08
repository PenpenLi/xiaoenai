package com.unionpay.mobile.android.pboctransaction;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.h;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public static String a = "A0000003330101010000000000010000";
  public static String b = "A0000003330101020001050001000000";
  private static Date l = new Date(System.currentTimeMillis());
  private static String m = new SimpleDateFormat("yyyyMMddhhmmss").format(l);
  private static HashMap<String, String> o = new HashMap();
  private static d r = null;
  c c;
  a d;
  public boolean e = false;
  private String f = "1.4";
  private byte g = 0;
  private byte h = 0;
  private byte i = 1;
  private boolean j = true;
  private boolean k = true;
  private String n = null;
  private boolean p = false;
  private String q = "";
  
  public d(c paramc, a parama, String paramString)
  {
    this.f = paramString;
    this.c = paramc;
    this.d = parama;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    int i3 = 1;
    if (paramString1 == null) {
      return null;
    }
    paramString1 = e.a(paramString1);
    int i1 = 0;
    if (i1 < paramString1.length) {
      if ((byte)(paramString1[i1] & 0x1F) != 31) {
        break label506;
      }
    }
    label496:
    label506:
    for (int i2 = 2;; i2 = 1)
    {
      byte[] arrayOfByte = new byte[i2];
      System.arraycopy(paramString1, i1, arrayOfByte, 0, i2);
      int i4;
      if (e.a(arrayOfByte, i2).compareToIgnoreCase(paramString2) == 0)
      {
        i4 = i2 + i1;
        if ((byte)(paramString1[i4] & 0x80) != Byte.MIN_VALUE)
        {
          i1 = paramString1[i4] & 0xFF;
          i2 = i3;
        }
      }
      for (;;)
      {
        paramString2 = new byte[i1];
        System.arraycopy(paramString1, i4 + i2, paramString2, 0, i1);
        return e.a(paramString2, i1);
        i2 = (paramString1[i4] & 0x7F) + 1;
        if (i2 == 2)
        {
          i1 = paramString1[(i4 + 1)] & 0xFF;
        }
        else if (i2 == 3)
        {
          i1 = (paramString1[(i4 + 1)] & 0xFF) << 8 | paramString1[(i4 + 2)] & 0xFF;
        }
        else if (i2 == 4)
        {
          i1 = (paramString1[(i4 + 1)] & 0xFF) << 16 | (paramString1[(i4 + 2)] & 0xFF) << 8 | paramString1[(i4 + 3)] & 0xFF;
          continue;
          if ((paramString1[i1] & 0x20) == 32)
          {
            i2 += i1;
            if ((i2 >= paramString1.length) || ((byte)(paramString1[i2] & 0x80) != Byte.MIN_VALUE)) {
              break label496;
            }
          }
          for (i1 = (paramString1[i2] & 0x7F) + 1;; i1 = 1)
          {
            i1 += i2;
            break;
            i4 = i1 + i2;
            if ((i4 < paramString1.length) && ((byte)(paramString1[i4] & 0x80) == 0))
            {
              i1 = paramString1[i4] & 0xFF;
              i2 = 1;
              i1 = i1 + i2 + i4;
              break;
            }
            if (i4 < paramString1.length) {}
            for (i2 = (paramString1[i4] & 0x7F) + 1;; i2 = 0)
            {
              if ((i2 == 2) && (i4 + 1 < paramString1.length))
              {
                i1 = paramString1[(i4 + 1)] & 0xFF;
                break;
              }
              if ((i2 == 3) && (i4 + 2 < paramString1.length))
              {
                i1 = (paramString1[(i4 + 1)] & 0xFF) << 8 | paramString1[(i4 + 2)] & 0xFF;
                break;
              }
              if ((i2 == 4) && (i4 + 2 < paramString1.length))
              {
                i1 = (paramString1[(i4 + 1)] & 0xFF) << 16 | (paramString1[(i4 + 2)] & 0xFF) << 8 | paramString1[(i4 + 3)] & 0xFF;
                break;
                return null;
              }
              i1 = 0;
              break;
            }
          }
        }
        else
        {
          i1 = 0;
        }
      }
    }
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.toUpperCase().getBytes();
    int i2 = paramString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localStringBuffer.append(String.format("%02X", new Object[] { Byte.valueOf(paramString[i1]) }));
      i1 += 1;
    }
    i1 = localStringBuffer.length() / 2;
    i2 = localStringBuffer.length() % 2 + i1;
    if (!paramBoolean) {
      if (i2 % 8 == 0) {
        break label184;
      }
    }
    label184:
    for (i1 = 8 - i2 % 8 + i2;; i1 = i2)
    {
      paramString = new byte[i1];
      System.arraycopy(e.a(localStringBuffer.toString()), 0, paramString, 0, i2);
      return e.a(paramString, i1);
      int i3 = i2 + 1;
      i1 = i3;
      if (i3 % 8 != 0) {
        i1 = i3 + (8 - i3 % 8);
      }
      paramString = new byte[i1];
      System.arraycopy(e.a(localStringBuffer.toString()), 0, paramString, 0, i2);
      paramString[i2] = -128;
      return e.a(paramString, i1);
    }
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    int i5 = 0;
    paramArrayOfByte[0] = ((byte)(paramArrayOfByte[0] | this.g));
    byte[] arrayOfByte = this.c.a(paramArrayOfByte, this.g);
    int i4;
    int i3;
    Object localObject;
    if (arrayOfByte != null)
    {
      i4 = arrayOfByte.length;
      i3 = i4;
      localObject = arrayOfByte;
      if (i4 >= 2)
      {
        i3 = i4;
        localObject = arrayOfByte;
        if (arrayOfByte[(i4 - 2)] == 97)
        {
          int i1 = arrayOfByte[(i4 - 1)];
          int i2 = this.g;
          localObject = this.c;
          i3 = this.g;
          localObject = ((c)localObject).a(new byte[] { i2, -64, 0, 0, i1 }, i3);
          if (localObject == null) {
            break label253;
          }
          i3 = localObject.length;
        }
      }
      label145:
      if ((i3 < 2) || (localObject[(i3 - 2)] != 108)) {
        break label293;
      }
      paramArrayOfByte[(paramArrayOfByte.length - 1)] = localObject[(i3 - 1)];
      localObject = this.c.a(paramArrayOfByte, this.g);
      paramArrayOfByte = (byte[])localObject;
      i3 = i5;
      if (localObject != null) {
        i3 = localObject.length;
      }
    }
    label253:
    label293:
    for (paramArrayOfByte = (byte[])localObject;; paramArrayOfByte = (byte[])localObject)
    {
      if ((i3 > 2) && (paramArrayOfByte[(i3 - 2)] == -112) && (paramArrayOfByte[(i3 - 1)] == 0))
      {
        return e.a(paramArrayOfByte, i3 - 2);
        i4 = 0;
        break;
        i3 = 0;
        break label145;
      }
      if ((i3 == 2) && (paramArrayOfByte[(i3 - 2)] == -112) && (paramArrayOfByte[(i3 - 1)] == 0)) {
        return e.a(paramArrayOfByte, 2);
      }
      return null;
    }
  }
  
  private String a(byte[] paramArrayOfByte, String paramString)
  {
    paramArrayOfByte[(paramArrayOfByte.length - 1)] = ((byte)(paramString.length() / 2));
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + paramString.length() / 2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(e.a(paramString), 0, arrayOfByte, paramArrayOfByte.length, paramString.length() / 2);
    return a(arrayOfByte);
  }
  
  private static void a(String paramString, StringBuffer paramStringBuffer)
  {
    String str = (String)o.get(paramString);
    Object localObject = new byte[1];
    localObject[0] = ((byte)(str.length() / 2));
    localObject = e.a((byte[])localObject, localObject.length);
    paramStringBuffer.append(paramString);
    paramStringBuffer.append((String)localObject);
    paramStringBuffer.append(str);
  }
  
  private String b(String paramString)
  {
    this.g = this.h;
    Object localObject = null;
    if (paramString != null)
    {
      int i1 = paramString.length() / 2;
      localObject = new byte[1];
      localObject[0] = Integer.valueOf(i1).byteValue();
      localObject = e.a((byte[])localObject, localObject.length);
      localObject = a(e.a("00a40400" + (String)localObject + paramString));
    }
    return (String)localObject;
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    int i1 = m.length() / 2 + 1;
    byte[] arrayOfByte1 = new byte[i1];
    System.arraycopy(e.a(m), 0, arrayOfByte1, 0, m.length() / 2);
    arrayOfByte1[(i1 - 1)] = Byte.MIN_VALUE;
    paramArrayOfByte[(paramArrayOfByte.length - 1)] = ((byte)arrayOfByte1.length);
    byte[] arrayOfByte2 = new byte[paramArrayOfByte.length + arrayOfByte1.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 0, paramArrayOfByte.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, paramArrayOfByte.length, arrayOfByte1.length);
    a(arrayOfByte2);
  }
  
  private String c(String paramString)
  {
    int i2 = 0;
    paramString = a(paramString, "80");
    if (paramString == null) {
      return null;
    }
    o.put("82", paramString.substring(0, 4));
    paramString = e.a(paramString.substring(4));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("5A");
    localArrayList.add("5F34");
    localArrayList.add("9F1F");
    localArrayList.add("57");
    localArrayList.add("5F24");
    localArrayList.add("9F10");
    localArrayList.add("8C");
    localArrayList.add("8D");
    try
    {
      if (i2 < paramString.length)
      {
        byte[] arrayOfByte1 = new byte[5];
        byte[] tmp134_132 = arrayOfByte1;
        tmp134_132[0] = 0;
        byte[] tmp139_134 = tmp134_132;
        tmp139_134[1] = -78;
        byte[] tmp144_139 = tmp139_134;
        tmp144_139[2] = 0;
        byte[] tmp149_144 = tmp144_139;
        tmp149_144[3] = 0;
        byte[] tmp154_149 = tmp149_144;
        tmp154_149[4] = 0;
        tmp154_149;
        byte[] arrayOfByte2 = new byte[4];
        System.arraycopy(paramString, i2, arrayOfByte2, 0, 4);
        int i1 = arrayOfByte2[1];
        label180:
        if (i1 <= arrayOfByte2[2])
        {
          arrayOfByte1[4] = 0;
          arrayOfByte1[3] = ((byte)(arrayOfByte2[0] & 0xFFFFFFF8 | 0x4));
          arrayOfByte1[2] = i1;
          i1 = (byte)(i1 + 1);
          String str1 = a(arrayOfByte1);
          if (str1 != null)
          {
            Iterator localIterator = localArrayList.iterator();
            while (localIterator.hasNext())
            {
              String str2 = (String)localIterator.next();
              String str3 = a(str1, str2);
              if (str3 != null)
              {
                o.put(str2, str3);
                continue;
                return (String)o.get("8C");
              }
            }
          }
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    for (;;)
    {
      break label180;
      i2 += 4;
      break;
      paramString = new StringBuffer((String)o.get("5F34"));
      paramString.insert(0, "0");
      o.put("5F34", paramString.toString());
    }
  }
  
  private String d(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer("80AE800034");
    paramString = h(paramString).iterator();
    for (;;)
    {
      if (!paramString.hasNext()) {
        break label103;
      }
      String str1 = (String)paramString.next();
      Iterator localIterator = o.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (str1.compareToIgnoreCase(str2) != 0) {
          break;
        }
        localStringBuffer.append((String)o.get(str2));
      }
    }
    label103:
    paramString = a(e.a(localStringBuffer.toString()));
    if (paramString != null)
    {
      o.put("9F27", paramString.substring(4, 6));
      o.put("9F36", paramString.substring(6, 10));
      o.put("9F26", paramString.substring(10, 26));
      o.put("9F10", paramString.substring(26));
    }
    return paramString;
  }
  
  private static void d()
  {
    String str = m.substring(2, 8);
    o.put("9F26", "");
    o.put("9F27", "80");
    o.put("9F10", "");
    o.put("9F37", "00000000");
    o.put("9F36", "");
    o.put("95", "0000000800");
    o.put("9A", str);
    o.put("9C", "45");
    o.put("9F02", "000000000000");
    o.put("5F2A", "0156");
    o.put("82", "");
    o.put("9F1A", "0156");
    o.put("9F03", "000000000000");
    o.put("9F33", "A04000");
    o.put("9F34", "000000");
    o.put("9F35", "34");
    o.put("9F1E", "3030303030303030");
    o.put("84", "");
    o.put("9F09", "0001");
    o.put("9F74", "");
    o.put("9F63", "");
    o.put("9F7A", "01");
    o.put("9F21", m.substring(8));
    o.put("9F4E", "0000000000000000000000000000000000000000");
    o.put("DF31", "0100000000");
  }
  
  private String e(String paramString)
  {
    this.g = this.i;
    paramString = a(paramString, false);
    b(new byte[] { -128, 26, 19, 1, 0 });
    paramString = a(new byte[] { -128, -6, 0, 0, 0 }, paramString);
    this.g = this.h;
    return paramString;
  }
  
  private boolean e()
  {
    for (String str = (String)o.get("5A"); str.substring(str.length() - 1, str.length()).equalsIgnoreCase("f"); str = str.substring(0, str.length() - 1)) {}
    str = e(str);
    if ((str == null) || (str.length() == 0)) {
      return false;
    }
    o.put("AN1", str);
    str = e("00000001");
    if ((str == null) || (str.length() == 0)) {
      return false;
    }
    o.put("TID", str);
    str = e((String)o.get("9F02"));
    if ((str == null) || (str.length() == 0)) {
      return false;
    }
    o.put("AMT", str);
    str = e("156");
    if ((str == null) || (str.length() == 0)) {
      return false;
    }
    o.put("CUR", str);
    for (str = (String)o.get("57"); (str.substring(str.length() - 1, str.length()).equalsIgnoreCase("f")) || (str.substring(str.length() - 1, str.length()).equalsIgnoreCase("F")); str = str.substring(0, str.length() - 1)) {}
    str = e(str);
    if ((str == null) || (str.length() == 0)) {
      return false;
    }
    o.put("TD2", str);
    if ((o.get("5F24") != null) && (((String)o.get("5F24")).length() == 6))
    {
      str = e(((String)o.get("5F24")).substring(0, 4));
      if ((str == null) || (str.length() == 0)) {
        return false;
      }
      o.put("ED", str);
    }
    return true;
  }
  
  private String f()
  {
    StringBuffer localStringBuffer = new StringBuffer("80A800000b8309");
    Iterator localIterator1 = h("9F7A019F02065F2A02").iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label105;
      }
      String str1 = (String)localIterator1.next();
      Iterator localIterator2 = o.keySet().iterator();
      if (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        if (str1.compareToIgnoreCase(str2) != 0) {
          break;
        }
        localStringBuffer.append((String)o.get(str2));
      }
    }
    label105:
    return a(e.a(localStringBuffer.toString()));
  }
  
  private String f(String paramString)
  {
    int i1 = 0;
    this.g = this.i;
    paramString = String.format("%02d", new Object[] { Integer.valueOf(paramString.length()) }) + paramString;
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    while (i1 < 16 - paramString.length())
    {
      localStringBuffer.append("F");
      i1 += 1;
    }
    b(new byte[] { -128, 26, 20, 1, 0 });
    paramString = localStringBuffer.toString();
    paramString = a(new byte[] { -128, -6, 0, 0, 0 }, paramString);
    if (paramString != null) {
      o.put("PIN", paramString);
    }
    this.g = this.h;
    return paramString;
  }
  
  private String g()
  {
    this.g = this.i;
    String str = a(new byte[] { 0, -80, -126, 0, 10 });
    if ((str != null) && (str.length() != 0)) {
      o.put("CSN", str);
    }
    this.g = this.h;
    return str;
  }
  
  private String g(String paramString)
  {
    this.g = this.i;
    Object localObject = new byte[5];
    Object tmp13_12 = localObject;
    tmp13_12[0] = -128;
    Object tmp19_13 = tmp13_12;
    tmp19_13[1] = -6;
    Object tmp25_19 = tmp19_13;
    tmp25_19[2] = 1;
    Object tmp31_25 = tmp25_19;
    tmp31_25[3] = 0;
    Object tmp36_31 = tmp31_25;
    tmp36_31[4] = 0;
    tmp36_31;
    paramString = a(paramString, true);
    b(new byte[] { -128, 26, 21, 1, 8 });
    while (paramString.length() > 448)
    {
      localObject[2] = 3;
      a((byte[])localObject, paramString.substring(0, 448).toUpperCase());
      paramString = paramString.substring(448);
    }
    localObject[2] = 1;
    if (Build.VERSION.SDK_INT <= 10) {}
    try
    {
      Thread.sleep(1000L);
      localObject = a((byte[])localObject, paramString);
      if (localObject != null) {
        o.put("MAC", ((String)localObject).toUpperCase());
      }
      this.g = this.h;
      paramString = (String)localObject;
      if (localObject != null) {
        paramString = ((String)localObject).toUpperCase();
      }
      return paramString;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  private static Bundle h()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("action_resp_code", "0000");
    return localBundle;
  }
  
  private static List<String> h(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null) {
      return localArrayList;
    }
    paramString = e.a(paramString);
    int i1 = 0;
    if (i1 < paramString.length) {
      if ((byte)(paramString[i1] & 0x1F) != 31) {
        break label121;
      }
    }
    label121:
    for (int i2 = 2;; i2 = 1)
    {
      byte[] arrayOfByte = new byte[i2];
      System.arraycopy(paramString, i1, arrayOfByte, 0, i2);
      localArrayList.add(e.a(arrayOfByte, i2));
      i2 += i1;
      if ((i2 < paramString.length) && ((byte)(paramString[i2] & 0x80) == Byte.MIN_VALUE)) {}
      for (i1 = (paramString[i2] & 0x7F) + 1;; i1 = 1)
      {
        i1 += i2;
        break;
        return localArrayList;
      }
    }
  }
  
  /* Error */
  public final Bundle a(int paramInt, String paramString1, HashMap<String, String> paramHashMap, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 439
    //   5: ldc_w 441
    //   8: invokestatic 446	com/unionpay/mobile/android/utils/h:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   11: pop
    //   12: invokestatic 448	com/unionpay/mobile/android/pboctransaction/d:h	()Landroid/os/Bundle;
    //   15: astore 5
    //   17: aload_0
    //   18: getfield 105	com/unionpay/mobile/android/pboctransaction/d:c	Lcom/unionpay/mobile/android/pboctransaction/c;
    //   21: invokeinterface 450 1 0
    //   26: aload_0
    //   27: invokevirtual 452	com/unionpay/mobile/android/pboctransaction/d:a	()Ljava/lang/String;
    //   30: astore 6
    //   32: aload 6
    //   34: ifnull +11 -> 45
    //   37: aload 6
    //   39: invokevirtual 168	java/lang/String:length	()I
    //   42: ifne +28 -> 70
    //   45: aload_0
    //   46: getfield 105	com/unionpay/mobile/android/pboctransaction/d:c	Lcom/unionpay/mobile/android/pboctransaction/c;
    //   49: invokeinterface 454 1 0
    //   54: aload 5
    //   56: ldc_w 426
    //   59: ldc_w 456
    //   62: invokevirtual 432	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: monitorexit
    //   67: aload 5
    //   69: areturn
    //   70: ldc_w 439
    //   73: new 187	java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 458
    //   80: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: getstatic 60	com/unionpay/mobile/android/pboctransaction/d:m	Ljava/lang/String;
    //   86: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 446	com/unionpay/mobile/android/utils/h:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   95: pop
    //   96: getstatic 66	com/unionpay/mobile/android/pboctransaction/d:o	Ljava/util/HashMap;
    //   99: ldc_w 395
    //   102: aload_2
    //   103: invokevirtual 211	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: aload_0
    //   108: getstatic 66	com/unionpay/mobile/android/pboctransaction/d:o	Ljava/util/HashMap;
    //   111: ldc_w 395
    //   114: invokevirtual 175	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: checkcast 122	java/lang/String
    //   120: aload 4
    //   122: invokestatic 463	com/unionpay/mobile/android/utils/PreferenceUtils:decPrefData	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   125: invokespecial 465	com/unionpay/mobile/android/pboctransaction/d:f	(Ljava/lang/String;)Ljava/lang/String;
    //   128: astore_2
    //   129: aload_2
    //   130: ifnull +10 -> 140
    //   133: aload_2
    //   134: invokevirtual 168	java/lang/String:length	()I
    //   137: ifne +26 -> 163
    //   140: aload_0
    //   141: getfield 105	com/unionpay/mobile/android/pboctransaction/d:c	Lcom/unionpay/mobile/android/pboctransaction/c;
    //   144: invokeinterface 454 1 0
    //   149: aload 5
    //   151: ldc_w 426
    //   154: ldc_w 456
    //   157: invokevirtual 432	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -95 -> 65
    //   163: ldc_w 439
    //   166: new 187	java/lang/StringBuilder
    //   169: dup
    //   170: ldc_w 467
    //   173: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   176: getstatic 60	com/unionpay/mobile/android/pboctransaction/d:m	Ljava/lang/String;
    //   179: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 446	com/unionpay/mobile/android/utils/h:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   188: pop
    //   189: aload_0
    //   190: iload_1
    //   191: getstatic 60	com/unionpay/mobile/android/pboctransaction/d:m	Ljava/lang/String;
    //   194: invokevirtual 470	com/unionpay/mobile/android/pboctransaction/d:a	(ILjava/lang/String;)Ljava/lang/String;
    //   197: astore_2
    //   198: aload_2
    //   199: ifnull +10 -> 209
    //   202: aload_2
    //   203: invokevirtual 168	java/lang/String:length	()I
    //   206: ifne +26 -> 232
    //   209: aload_0
    //   210: getfield 105	com/unionpay/mobile/android/pboctransaction/d:c	Lcom/unionpay/mobile/android/pboctransaction/c;
    //   213: invokeinterface 454 1 0
    //   218: aload 5
    //   220: ldc_w 426
    //   223: ldc_w 456
    //   226: invokevirtual 432	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: goto -164 -> 65
    //   232: aload_0
    //   233: invokespecial 472	com/unionpay/mobile/android/pboctransaction/d:g	()Ljava/lang/String;
    //   236: astore 4
    //   238: aload 4
    //   240: ifnull +11 -> 251
    //   243: aload 4
    //   245: invokevirtual 168	java/lang/String:length	()I
    //   248: ifne +26 -> 274
    //   251: aload_0
    //   252: getfield 105	com/unionpay/mobile/android/pboctransaction/d:c	Lcom/unionpay/mobile/android/pboctransaction/c;
    //   255: invokeinterface 454 1 0
    //   260: aload 5
    //   262: ldc_w 426
    //   265: ldc_w 456
    //   268: invokevirtual 432	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: goto -206 -> 65
    //   274: aload_2
    //   275: bipush 40
    //   277: bipush 60
    //   279: invokevirtual 207	java/lang/String:substring	(II)Ljava/lang/String;
    //   282: invokestatic 474	com/unionpay/mobile/android/pboctransaction/e:c	(Ljava/lang/String;)Ljava/lang/String;
    //   285: astore 6
    //   287: aload_2
    //   288: bipush 60
    //   290: bipush 100
    //   292: invokevirtual 207	java/lang/String:substring	(II)Ljava/lang/String;
    //   295: astore 7
    //   297: aload_2
    //   298: bipush 100
    //   300: sipush 208
    //   303: invokevirtual 207	java/lang/String:substring	(II)Ljava/lang/String;
    //   306: astore 8
    //   308: aload_2
    //   309: sipush 216
    //   312: sipush 232
    //   315: invokevirtual 207	java/lang/String:substring	(II)Ljava/lang/String;
    //   318: astore 9
    //   320: new 476	org/json/JSONObject
    //   323: dup
    //   324: invokespecial 477	org/json/JSONObject:<init>	()V
    //   327: astore_2
    //   328: aload_2
    //   329: ldc_w 479
    //   332: aload_0
    //   333: getfield 83	com/unionpay/mobile/android/pboctransaction/d:f	Ljava/lang/String;
    //   336: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   339: pop
    //   340: aload_2
    //   341: ldc_w 484
    //   344: ldc_w 486
    //   347: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   350: pop
    //   351: new 476	org/json/JSONObject
    //   354: dup
    //   355: invokespecial 477	org/json/JSONObject:<init>	()V
    //   358: astore 4
    //   360: aload_2
    //   361: ldc_w 488
    //   364: aload 4
    //   366: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   369: pop
    //   370: aload 4
    //   372: ldc_w 490
    //   375: ldc_w 492
    //   378: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   381: pop
    //   382: aload 4
    //   384: ldc_w 494
    //   387: ldc_w 496
    //   390: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload 4
    //   396: ldc_w 498
    //   399: ldc_w 500
    //   402: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   405: pop
    //   406: aload 4
    //   408: ldc_w 502
    //   411: ldc_w 496
    //   414: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   417: pop
    //   418: aload 4
    //   420: ldc_w 504
    //   423: aload 7
    //   425: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   428: pop
    //   429: aload 4
    //   431: ldc_w 506
    //   434: aload 8
    //   436: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   439: pop
    //   440: aload 4
    //   442: ldc_w 508
    //   445: getstatic 66	com/unionpay/mobile/android/pboctransaction/d:o	Ljava/util/HashMap;
    //   448: ldc_w 400
    //   451: invokevirtual 175	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   454: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   457: pop
    //   458: aload 4
    //   460: ldc_w 510
    //   463: getstatic 60	com/unionpay/mobile/android/pboctransaction/d:m	Ljava/lang/String;
    //   466: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   469: pop
    //   470: aload 4
    //   472: ldc_w 512
    //   475: ldc_w 514
    //   478: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   481: pop
    //   482: aload 4
    //   484: ldc_w 516
    //   487: getstatic 66	com/unionpay/mobile/android/pboctransaction/d:o	Ljava/util/HashMap;
    //   490: ldc_w 395
    //   493: invokevirtual 175	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   496: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   499: pop
    //   500: aload 4
    //   502: ldc_w 518
    //   505: aload 6
    //   507: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   510: pop
    //   511: aload 4
    //   513: ldc_w 520
    //   516: aload 9
    //   518: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   521: pop
    //   522: aload 4
    //   524: ldc_w 522
    //   527: ldc_w 496
    //   530: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   533: pop
    //   534: aload_3
    //   535: ifnull +155 -> 690
    //   538: aload_3
    //   539: invokevirtual 274	java/util/HashMap:keySet	()Ljava/util/Set;
    //   542: ifnull +148 -> 690
    //   545: aload_3
    //   546: invokevirtual 274	java/util/HashMap:keySet	()Ljava/util/Set;
    //   549: invokeinterface 525 1 0
    //   554: ifle +136 -> 690
    //   557: aload_3
    //   558: ldc_w 518
    //   561: invokevirtual 528	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   564: pop
    //   565: aload_3
    //   566: ldc_w 516
    //   569: invokevirtual 528	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   572: pop
    //   573: aload_3
    //   574: invokevirtual 274	java/util/HashMap:keySet	()Ljava/util/Set;
    //   577: invokeinterface 277 1 0
    //   582: astore 6
    //   584: aload 6
    //   586: invokeinterface 251 1 0
    //   591: ifeq +99 -> 690
    //   594: aload 6
    //   596: invokeinterface 255 1 0
    //   601: checkcast 122	java/lang/String
    //   604: astore 7
    //   606: aload 4
    //   608: aload 7
    //   610: aload_3
    //   611: aload 7
    //   613: invokevirtual 175	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   616: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   619: pop
    //   620: goto -36 -> 584
    //   623: astore_2
    //   624: aload_2
    //   625: invokevirtual 529	org/json/JSONException:printStackTrace	()V
    //   628: ldc 101
    //   630: astore_2
    //   631: ldc_w 439
    //   634: new 187	java/lang/StringBuilder
    //   637: dup
    //   638: ldc_w 531
    //   641: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   644: getstatic 60	com/unionpay/mobile/android/pboctransaction/d:m	Ljava/lang/String;
    //   647: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: invokestatic 446	com/unionpay/mobile/android/utils/h:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   656: pop
    //   657: aload 5
    //   659: ldc_w 533
    //   662: aload_0
    //   663: getfield 107	com/unionpay/mobile/android/pboctransaction/d:d	Lcom/unionpay/mobile/android/fully/a;
    //   666: aload_2
    //   667: invokeinterface 537 2 0
    //   672: invokevirtual 432	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   675: aload_0
    //   676: getfield 105	com/unionpay/mobile/android/pboctransaction/d:c	Lcom/unionpay/mobile/android/pboctransaction/c;
    //   679: invokeinterface 454 1 0
    //   684: invokestatic 539	com/unionpay/mobile/android/pboctransaction/d:d	()V
    //   687: goto -622 -> 65
    //   690: aload_2
    //   691: invokevirtual 540	org/json/JSONObject:toString	()Ljava/lang/String;
    //   694: astore_2
    //   695: goto -64 -> 631
    //   698: astore_2
    //   699: aload_0
    //   700: monitorexit
    //   701: aload_2
    //   702: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	703	0	this	d
    //   0	703	1	paramInt	int
    //   0	703	2	paramString1	String
    //   0	703	3	paramHashMap	HashMap<String, String>
    //   0	703	4	paramString2	String
    //   15	643	5	localBundle	Bundle
    //   30	565	6	localObject	Object
    //   295	317	7	str1	String
    //   306	129	8	str2	String
    //   318	199	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   320	534	623	org/json/JSONException
    //   538	584	623	org/json/JSONException
    //   584	620	623	org/json/JSONException
    //   690	695	623	org/json/JSONException
    //   2	32	698	finally
    //   37	45	698	finally
    //   45	65	698	finally
    //   70	129	698	finally
    //   133	140	698	finally
    //   140	160	698	finally
    //   163	198	698	finally
    //   202	209	698	finally
    //   209	229	698	finally
    //   232	238	698	finally
    //   243	251	698	finally
    //   251	271	698	finally
    //   274	320	698	finally
    //   320	534	698	finally
    //   538	584	698	finally
    //   584	620	698	finally
    //   624	628	698	finally
    //   631	687	698	finally
    //   690	695	698	finally
  }
  
  public final Bundle a(AppIdentification paramAppIdentification, String paramString1, String paramString2, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString3)
  {
    for (;;)
    {
      try
      {
        this.c.b();
        h.c("uppay", "startPBOCPurchase() +++");
        d();
        o.put("PIN", paramString1);
        o.put("9F02", paramHashMap1.get("trans_amt"));
        o.put("9F1A", "0156");
        o.put("5F2A", paramHashMap1.get("trans currcy code"));
        o.put("9C", paramHashMap1.get("trans_type"));
        paramAppIdentification = paramAppIdentification.a();
        paramString1 = h();
        l = new Date(System.currentTimeMillis());
        m = new SimpleDateFormat("yyyyMMddHHmmss").format(l);
        this.n = new String(m);
        paramHashMap1 = a();
        if ((paramHashMap1 == null) || (paramHashMap1.length() == 0))
        {
          paramString1.putString("action_resp_code", "10019");
          if (paramString1.getString("action_resp_code") == "0000") {
            break label365;
          }
          this.c.c();
          return paramString1;
        }
        paramAppIdentification = b(paramAppIdentification);
        if ((paramAppIdentification == null) || (paramAppIdentification.length() == 0))
        {
          paramString1.putString("action_resp_code", "10019");
          continue;
        }
        paramAppIdentification = f();
      }
      finally {}
      if ((paramAppIdentification == null) || (paramAppIdentification.length() == 0))
      {
        paramString1.putString("action_resp_code", "10020");
      }
      else
      {
        paramAppIdentification = c(paramAppIdentification);
        if ((paramAppIdentification == null) || (paramAppIdentification.length() == 0))
        {
          paramString1.putString("action_resp_code", "10019");
        }
        else
        {
          paramAppIdentification = d(paramAppIdentification);
          if ((paramAppIdentification == null) || (paramAppIdentification.length() == 0))
          {
            paramString1.putString("action_resp_code", "10019");
          }
          else
          {
            paramAppIdentification = g();
            if ((paramAppIdentification == null) || (paramAppIdentification.length() == 0))
            {
              paramString1.putString("action_resp_code", "10019");
              continue;
              label365:
              paramAppIdentification = f(PreferenceUtils.decPrefData((String)o.get("PIN"), paramString3));
              if ((paramAppIdentification == null) || (paramAppIdentification.length() == 0))
              {
                this.c.c();
                paramString1.putString("action_resp_code", "10019");
              }
              else if (!e())
              {
                this.c.c();
                paramString1.putString("action_resp_code", "10019");
              }
              else
              {
                paramAppIdentification = new StringBuffer();
                a("9F26", paramAppIdentification);
                a("9F27", paramAppIdentification);
                a("9F10", paramAppIdentification);
                a("9F37", paramAppIdentification);
                a("9F36", paramAppIdentification);
                a("95", paramAppIdentification);
                a("9A", paramAppIdentification);
                a("9C", paramAppIdentification);
                a("9F02", paramAppIdentification);
                a("5F2A", paramAppIdentification);
                a("82", paramAppIdentification);
                a("9F1A", paramAppIdentification);
                a("9F03", paramAppIdentification);
                a("9F33", paramAppIdentification);
                a("9F34", paramAppIdentification);
                a("9F35", paramAppIdentification);
                a("9F1E", paramAppIdentification);
                paramAppIdentification = paramAppIdentification.toString();
                o.put("DCD", paramAppIdentification);
                if ((o.get("TID") != null) && (o.get("AMT") != null) && (o.get("CUR") != null) && (o.get("AN1") != null) && (o.get("CSN") != null) && (o.get("5F34") != null)) {
                  break;
                }
                this.c.c();
                paramString1.putString("action_resp_code", "10019");
              }
            }
          }
        }
      }
    }
    paramHashMap1 = new ArrayList();
    paramHashMap1.add(m);
    if (o.get("TID") != null) {
      paramHashMap1.add(o.get("TID"));
    }
    if (o.get("AMT") != null) {
      paramHashMap1.add(o.get("AMT"));
    }
    if (o.get("CUR") != null) {
      paramHashMap1.add(o.get("CUR"));
    }
    if (o.get("AN1") != null) {
      paramHashMap1.add(o.get("AN1"));
    }
    o.put("AN1", e.c((String)o.get("5A")));
    if (o.get("CSN") != null) {
      paramHashMap1.add(o.get("CSN"));
    }
    if ((this.p) && (o.get("ED") != null)) {
      paramHashMap1.add(o.get("ED"));
    }
    if (o.get("5F34") != null) {
      paramHashMap1.add(o.get("5F34"));
    }
    if (o.get("DCD") != null) {
      paramHashMap1.add(o.get("DCD"));
    }
    paramAppIdentification = "";
    paramHashMap1 = paramHashMap1.iterator();
    for (;;)
    {
      if (paramHashMap1.hasNext())
      {
        paramString3 = (String)paramHashMap1.next();
        if (paramString3 != null) {
          paramAppIdentification = paramAppIdentification + paramString3 + " ";
        }
      }
      else
      {
        paramAppIdentification = g(paramAppIdentification.trim());
        if ((paramAppIdentification == null) || (paramAppIdentification.length() == 0))
        {
          this.c.c();
          paramString1.putString("action_resp_code", "10019");
          break;
        }
        for (;;)
        {
          try
          {
            paramHashMap1 = new JSONObject();
            paramHashMap1.put("v", this.f);
            paramHashMap1.put("cmd", "pay");
            paramString3 = new JSONObject();
            paramHashMap1.put("params", paramString3);
            paramString3.put("pay_type", "2");
            paramString3.put("pay_mode", "1");
            paramString3.put("bind", "no");
            paramString3.put("carrier_tp", paramString2);
            paramString3.put("icc_data", o.get("DCD"));
            paramString3.put("csn", o.get("CSN"));
            if (o.get("5F34") != null)
            {
              paramAppIdentification = (String)o.get("5F34");
              paramString3.put("card_seq_id", paramAppIdentification);
              paramString3.put("submit_time", m);
              paramString3.put("sp_id", "8889");
              paramString3.put("pin", o.get("PIN"));
              paramString3.put("pan", o.get("AN1"));
              paramString3.put("carrier_app_tp", "2");
              if (o.get("ED") != null) {
                paramString3.put("expire", o.get("ED"));
              }
              if (o.get("TD2") != null) {
                paramString3.put("track2_data", o.get("TD2"));
              }
              if ((paramHashMap2 == null) || (paramHashMap2.keySet() == null) || (paramHashMap2.keySet().size() <= 0)) {
                break label1474;
              }
              paramHashMap2.remove("pan");
              paramHashMap2.remove("pin");
              paramAppIdentification = paramHashMap2.keySet().iterator();
              if (!paramAppIdentification.hasNext()) {
                break label1474;
              }
              paramString2 = (String)paramAppIdentification.next();
              paramString3.put(paramString2, paramHashMap2.get(paramString2));
              continue;
            }
          }
          catch (JSONException paramAppIdentification)
          {
            this.c.c();
            paramString1.putString("action_resp_code", "10019");
          }
          paramAppIdentification = "";
        }
        label1474:
        paramAppIdentification = paramHashMap1.toString();
        paramString1.putString("action_resp_message", this.d.a(paramAppIdentification));
        this.c.c();
        d();
        break;
      }
    }
  }
  
  public final String a()
  {
    this.g = this.i;
    return a(new byte[] { 0, -92, 4, 0, 15, -96, 0, 0, 3, 51, 67, 85, 80, 45, 77, 79, 66, 73, 76, 69 });
  }
  
  public final String a(int paramInt, String paramString)
  {
    this.g = this.i;
    if (Integer.toHexString(paramInt).length() == 1) {}
    for (String str = "0" + Integer.toHexString(paramInt);; str = Integer.toHexString(paramInt)) {
      return a(e.a("80F802" + str + "08" + paramString + "80"));
    }
  }
  
  /* Error */
  public final String a(AppIdentification paramAppIdentification)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokevirtual 553	com/unionpay/mobile/android/pboctransaction/AppIdentification:a	()Ljava/lang/String;
    //   8: astore_1
    //   9: invokestatic 539	com/unionpay/mobile/android/pboctransaction/d:d	()V
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial 561	com/unionpay/mobile/android/pboctransaction/d:b	(Ljava/lang/String;)Ljava/lang/String;
    //   17: pop
    //   18: aload_0
    //   19: invokespecial 563	com/unionpay/mobile/android/pboctransaction/d:f	()Ljava/lang/String;
    //   22: astore_3
    //   23: aload_2
    //   24: astore_1
    //   25: aload_3
    //   26: ifnull +16 -> 42
    //   29: aload_3
    //   30: invokevirtual 168	java/lang/String:length	()I
    //   33: istore 4
    //   35: iload 4
    //   37: ifne +9 -> 46
    //   40: aload_2
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_0
    //   47: aload_3
    //   48: invokespecial 566	com/unionpay/mobile/android/pboctransaction/d:c	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_3
    //   52: aload_2
    //   53: astore_1
    //   54: aload_3
    //   55: ifnull -13 -> 42
    //   58: aload_2
    //   59: astore_1
    //   60: aload_3
    //   61: invokevirtual 168	java/lang/String:length	()I
    //   64: ifeq -22 -> 42
    //   67: getstatic 66	com/unionpay/mobile/android/pboctransaction/d:o	Ljava/util/HashMap;
    //   70: ldc -37
    //   72: invokevirtual 175	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast 122	java/lang/String
    //   78: astore_1
    //   79: goto -37 -> 42
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	d
    //   0	87	1	paramAppIdentification	AppIdentification
    //   1	58	2	localObject	Object
    //   22	39	3	str	String
    //   33	3	4	i1	int
    // Exception table:
    //   from	to	target	type
    //   4	23	82	finally
    //   29	35	82	finally
    //   46	52	82	finally
    //   60	79	82	finally
  }
  
  public final String a(String paramString)
  {
    this.c.d();
    paramString = b(paramString);
    this.c.d();
    return a(paramString, "84");
  }
  
  public final ArrayList<com.unionpay.mobile.android.model.c> b()
  {
    this.c.d();
    this.c.b();
    ArrayList localArrayList = this.c.a(this);
    this.c.c();
    return localArrayList;
  }
  
  public final String c()
  {
    this.g = this.i;
    return a(e.a("80F2000102"));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\pboctransaction\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
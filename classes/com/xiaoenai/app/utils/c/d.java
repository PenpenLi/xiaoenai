package com.xiaoenai.app.utils.c;

import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.f.a;
import java.util.Calendar;

public class d
{
  public static int a(long paramLong)
  {
    int j = 0;
    int k = 1;
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).clear();
    Calendar localCalendar = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(1000L * paramLong);
    localObject = c.b(((Calendar)localObject).get(5), ((Calendar)localObject).get(2) + 1, ((Calendar)localObject).get(1));
    int[] arrayOfInt = c.b(localCalendar.get(5), localCalendar.get(2) + 1, localCalendar.get(1));
    int i = j;
    int n;
    int m;
    int i2;
    int i1;
    if (localObject != null)
    {
      i = j;
      if (arrayOfInt != null)
      {
        n = localObject[0];
        m = localObject[1];
        i = localObject[2];
        i2 = arrayOfInt[0];
        i1 = arrayOfInt[1];
        i = arrayOfInt[2];
        if (arrayOfInt[3] != 1) {
          break label161;
        }
        i = k;
        if ((i1 != m) || (i2 > n)) {
          break label173;
        }
        if (i == 0) {
          break label167;
        }
        i = n - i2;
      }
    }
    label161:
    label167:
    label173:
    do
    {
      return i;
      i = 0;
      break;
      return n - i2;
      if (((i1 == m) && (i2 > n)) || (i1 < m)) {
        return a((int[])localObject, localCalendar);
      }
      i = j;
    } while (i1 <= m);
    return a((int[])localObject, localCalendar);
  }
  
  private static int a(int[] paramArrayOfInt, Calendar paramCalendar)
  {
    paramArrayOfInt = a(paramArrayOfInt[2], paramArrayOfInt[1], paramArrayOfInt[0]);
    int i;
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt = c.a(paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2], false);
      if (paramArrayOfInt != null)
      {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.clear();
        localCalendar.set(11, 0);
        localCalendar.set(12, 0);
        localCalendar.set(13, 0);
        localCalendar.set(14, 0);
        localCalendar.set(paramArrayOfInt[2], paramArrayOfInt[1] - 1, paramArrayOfInt[0]);
        a.c("{}-{}-{}", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]), Integer.valueOf(paramArrayOfInt[2]) });
        i = ak.l(localCalendar.getTimeInMillis() - paramCalendar.getTimeInMillis());
        if (i >= 0) {
          return i;
        }
      }
    }
    return 0;
    return i;
  }
  
  public static String a(int paramInt)
  {
    return b(paramInt - 1900 + 36);
  }
  
  private static int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = new int[3];
    try
    {
      Object localObject2 = Calendar.getInstance();
      paramInt1 = ((Calendar)localObject2).get(1);
      int i = ((Calendar)localObject2).get(2);
      localObject2 = c.b(((Calendar)localObject2).get(5), i + 1, paramInt1);
      if (localObject2[3] == 1)
      {
        localObject2[1] += 1;
        paramInt1 = Integer.MIN_VALUE;
      }
      while (localObject2 != null)
      {
        localObject1 = localObject2;
        if ((localObject1 != null) && (paramInt2 - localObject1[1] <= 0) && ((paramInt2 - localObject1[1] != 0) || (paramInt3 - localObject1[0] < 0))) {
          break label210;
        }
        label100:
        localObject1[1] = paramInt2;
        localObject1[0] = paramInt3;
        return (int[])localObject1;
        i = c.e(localObject2[2]);
        paramInt1 = i;
        if (i != Integer.MIN_VALUE)
        {
          paramInt1 = i;
          if (i < localObject2[1])
          {
            localObject2[1] += 1;
            paramInt1 = i;
            continue;
            localException1.printStackTrace();
          }
        }
      }
    }
    catch (Exception localException1) {}
    for (;;)
    {
      return (int[])localObject1;
      label210:
      do
      {
        if (paramInt3 == 30) {}
        try
        {
          if (b.a(localObject1[2] + 1) == 29) {
            break label100;
          }
          localObject1[2] += 1;
        }
        catch (Exception localException2) {}
        localObject1[2] += 1;
        break label100;
        break;
      } while ((paramInt1 == Integer.MIN_VALUE) || (paramInt1 >= paramInt2) || (paramInt2 < localObject1[1]));
      break label100;
    }
  }
  
  public static String[] a(int paramInt1, int paramInt2)
  {
    String[] arrayOfString = new String[paramInt2 - paramInt1 + 1];
    int i = 0;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt1 < arrayOfString.length)
    {
      arrayOfString[paramInt1] = (paramInt2 + "(" + b(paramInt2 - 1900 + 36) + "年)");
      paramInt2 += 1;
      paramInt1 += 1;
    }
    return arrayOfString;
  }
  
  public static int b(long paramLong)
  {
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).clear();
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(1000L * paramLong);
    localObject2 = c.b(((Calendar)localObject2).get(5), ((Calendar)localObject2).get(2) + 1, ((Calendar)localObject2).get(1));
    localObject1 = c.b(((Calendar)localObject1).get(5), ((Calendar)localObject1).get(2) + 1, ((Calendar)localObject1).get(1));
    if ((localObject2 != null) && (localObject1 != null))
    {
      int i = localObject2[0];
      int j = localObject2[1];
      j = localObject2[2];
      j = localObject1[0];
      int k = localObject1[1];
      int m = localObject1[2];
      if (localObject1[3] == 1) {}
      k = c.b(k, m);
      if (j <= i)
      {
        if (i <= k) {
          return i - j;
        }
        return k - j;
      }
      return k - j + i;
    }
    return -1;
  }
  
  public static String b(int paramInt)
  {
    return new String[] { "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸" }[(paramInt % 10)] + new String[] { "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥" }[(paramInt % 12)];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.xiaoenai.app.classes.extentions.anniversary;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.xiaoenai.app.d.v;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.service.RemindReceiver;
import com.xiaoenai.app.utils.c.c;
import com.xiaoenai.app.utils.d.d;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.utils.w;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ad
{
  public static int a = 11000;
  private static v b = new v();
  private static String c = "xiaoenai.anniversary.local";
  
  private static String a(Context paramContext, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int i = localCalendar.get(1);
    int j = Calendar.getInstance().get(1);
    return String.format(paramContext.getString(2131099940), new Object[] { Integer.valueOf(j - i) });
  }
  
  public static void a(Context paramContext)
  {
    if ((AppModel.getInstance().isLogined()) && (!User.isSingle()))
    {
      d(paramContext);
      return;
    }
    b(paramContext);
  }
  
  private static void a(Context paramContext, ah paramah)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.clear();
    localCalendar1.setTimeInMillis(paramah.b() * 1000L);
    localCalendar1.get(1);
    int k = localCalendar1.get(2);
    int i = localCalendar1.get(5);
    Calendar localCalendar2 = Calendar.getInstance();
    int m = localCalendar2.get(1);
    int n = localCalendar2.get(2);
    int j = localCalendar2.get(5);
    if (paramah.b() * 1000L > System.currentTimeMillis()) {
      if (a(paramah.b())) {
        d(paramContext, paramah);
      }
    }
    label263:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!ah.b.equals(paramah.a())) {
                    break;
                  }
                  paramah = b(paramContext, paramah);
                } while ((paramah == null) || (paramah.length() <= 0));
                a(paramContext, paramah);
                return;
              } while (paramah.c() == 0);
              if (paramah.c() != 3) {
                break;
              }
            } while (!b(paramah.b()));
            d(paramContext, paramah);
            return;
            if (paramah.c() != 2) {
              break label263;
            }
            if ((i != 1) || ((n + 1) % 12 != k)) {
              break;
            }
          } while (j != c.a(n + 1, m));
          d(paramContext, paramah);
          return;
        } while (i == 1);
        k = c.a(n + 1, m);
        if ((i > k) && (j + 1 == k))
        {
          d(paramContext, paramah);
          return;
        }
      } while (j + 1 != i);
      d(paramContext, paramah);
      return;
    } while ((paramah.c() != 1) || (localCalendar1.get(7) != localCalendar2.get(7) % 7 + 1));
    d(paramContext, paramah);
  }
  
  private static void a(Context paramContext, String paramString)
  {
    w.a(c, paramString);
    int i = a + 1;
    a = i;
    w.b(paramContext, paramString, i);
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt2 == 1) && (paramInt3 == 1))
    {
      paramInt2 = c.b(paramInt4, paramInt5);
      if ((paramInt1 != paramInt4 + 1) || ((paramInt5 != 12) && (paramInt5 != 13)) || (paramInt6 != paramInt2)) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if (paramInt1 != paramInt4) {
          break label102;
        }
        if ((paramInt3 != 1) || (paramInt2 != paramInt5 + 1)) {
          break;
        }
      } while (paramInt6 == c.b(paramInt1, paramInt5));
      return false;
      if ((paramInt3 == 1) || (paramInt2 != paramInt5)) {
        break;
      }
    } while (paramInt6 + 1 == paramInt3);
    return false;
    return false;
    label102:
    return false;
  }
  
  private static boolean a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTimeInMillis((paramLong - 86400L) * 1000L);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    localCalendar = Calendar.getInstance();
    int m = localCalendar.get(1);
    int n = localCalendar.get(2);
    int i1 = localCalendar.get(5);
    return (i == m) && (j == n) && (i1 == k);
  }
  
  private static String b(Context paramContext, long paramLong)
  {
    int i = (int)(paramLong / 100L + 1L);
    return String.format(paramContext.getString(2131099939), new Object[] { Integer.valueOf(i) });
  }
  
  private static String b(Context paramContext, ah paramah)
  {
    String str = "";
    if (520L == paramah.k() + 1L) {
      str = paramContext.getString(2131099937);
    }
    do
    {
      return str;
      if (1314L == paramah.k() + 1L) {
        return paramContext.getString(2131099936);
      }
      if ((paramah.k() + 1L) % 100L == 0L) {
        return b(paramContext, paramah.k());
      }
    } while (!b(paramah.b()));
    return a(paramContext, paramah.b());
  }
  
  public static void b(Context paramContext)
  {
    Object localObject = new Intent("com.xiaoenai.app.REMIND_ANNIVERSARY");
    ((Intent)localObject).setClass(paramContext, RemindReceiver.class);
    localObject = PendingIntent.getBroadcast(paramContext, 125, (Intent)localObject, 134217728);
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel((PendingIntent)localObject);
  }
  
  private static boolean b(long paramLong)
  {
    boolean bool = true;
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.clear();
    localCalendar1.setTimeInMillis(1000L * paramLong);
    int i = localCalendar1.get(2);
    int j = localCalendar1.get(5);
    if ((i == 1) && (j == 29) && (!c.d(Calendar.getInstance().get(1)))) {
      return false;
    }
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(2, i);
    localCalendar2.set(5, j);
    localCalendar1.clear();
    localCalendar1.setTimeInMillis(localCalendar2.getTimeInMillis() - 86400000L);
    i = localCalendar1.get(2);
    j = localCalendar1.get(5);
    localCalendar1 = Calendar.getInstance();
    int k = localCalendar1.get(2);
    int m = localCalendar1.get(5);
    if ((i == k) && (m == j)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static void c(Context paramContext)
  {
    b(paramContext);
    Object localObject = Calendar.getInstance();
    if (((Calendar)localObject).get(11) >= 9) {
      ((Calendar)localObject).set(5, ((Calendar)localObject).get(5) + 1);
    }
    ((Calendar)localObject).set(11, 9);
    ((Calendar)localObject).set(12, 0);
    long l2 = ((Calendar)localObject).getTimeInMillis();
    a.c("time={}", new Object[] { d.a((Calendar)localObject) });
    long l1 = l2;
    if (l2 <= System.currentTimeMillis()) {
      l1 = l2 + 86400000L;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    Intent localIntent = new Intent("com.xiaoenai.app.REMIND_ANNIVERSARY");
    localIntent.setClass(paramContext, RemindReceiver.class);
    localIntent.putExtra("from", "AlarmManager");
    ((AlarmManager)localObject).setRepeating(0, l1, 86400000L, PendingIntent.getBroadcast(paramContext, 125, localIntent, 134217728));
  }
  
  private static void c(Context paramContext, ah paramah)
  {
    if (paramah.b() * 1000L > System.currentTimeMillis()) {
      if (a(paramah.b())) {
        d(paramContext, paramah);
      }
    }
    Calendar localCalendar;
    int i;
    int j;
    int m;
    int n;
    int i1;
    label223:
    label319:
    do
    {
      do
      {
        do
        {
          int k;
          do
          {
            return;
            localCalendar = Calendar.getInstance();
            localCalendar.clear();
            localCalendar.setTimeInMillis(paramah.b() * 1000L);
            i = localCalendar.get(1);
            j = localCalendar.get(2);
            int[] arrayOfInt1 = c.b(localCalendar.get(5), j + 1, i);
            if (arrayOfInt1 == null) {
              break label368;
            }
            if (arrayOfInt1[3] == 1) {}
            for (i = arrayOfInt1[1];; i = arrayOfInt1[1])
            {
              k = arrayOfInt1[2];
              j = arrayOfInt1[0];
              m = Calendar.getInstance().get(1);
              n = Calendar.getInstance().get(2);
              int[] arrayOfInt2 = c.b(Calendar.getInstance().get(5), n + 1, m);
              if (arrayOfInt2 == null) {
                break label351;
              }
              m = arrayOfInt2[0];
              n = arrayOfInt2[1];
              i1 = arrayOfInt2[2];
              if ((arrayOfInt1[3] == 1) && (paramah.c() == 0)) {
                break;
              }
              if (paramah.c() != 1) {
                break label223;
              }
              if (localCalendar.get(7) != Calendar.getInstance().get(7) % 7 + 1) {
                break;
              }
              d(paramContext, paramah);
              return;
            }
            if (paramah.c() != 2) {
              break label319;
            }
            if ((j != 1) || (i != n % 12 + 1)) {
              break;
            }
          } while (m != c.b(k, i));
          d(paramContext, paramah);
          return;
        } while (j == 1);
        i = c.b(n, i1);
        if ((j > i) && (m + 1 == i))
        {
          d(paramContext, paramah);
          return;
        }
      } while (m + 1 != j);
      d(paramContext, paramah);
      return;
    } while ((paramah.c() != 3) || (!a(i1, i, j, i1, n, m)));
    d(paramContext, paramah);
    return;
    label351:
    a.a("solar date convert to lunar date fail:{}", new Object[] { d.a(localCalendar) });
    return;
    label368:
    a.a("solar date convert to lunar date fail:{}", new Object[] { d.a(localCalendar) });
  }
  
  private static void d(Context paramContext)
  {
    Object localObject = ai.a().b();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ah localah = (ah)((Iterator)localObject).next();
        if (localah.d()) {
          c(paramContext, localah);
        } else {
          a(paramContext, localah);
        }
      }
    }
  }
  
  private static void d(Context paramContext, ah paramah)
  {
    paramah = paramContext.getResources().getString(2131099954) + paramah.i();
    w.a(c, paramah);
    int i = a + 1;
    a = i;
    w.b(paramContext, paramah, i);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
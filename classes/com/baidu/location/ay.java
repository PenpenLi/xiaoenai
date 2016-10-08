package com.baidu.location;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

class ay
  implements ax, n
{
  private static ay im = null;
  private volatile boolean iA = false;
  private final String iB = I + "/ls.db";
  private int iC = 0;
  private final String iD = "wof";
  private boolean iE = false;
  private final int iF = 10000;
  private String iG = null;
  private boolean in = false;
  private String io = null;
  private long ip = 0L;
  private final int iq = 6;
  private double ir = 0.0D;
  private double is = 0.0D;
  private final String it = "bdcltb09";
  private double iu = 0.0D;
  private double iv = 0.0D;
  private boolean iw = false;
  private boolean ix = true;
  private boolean iy = false;
  private double iz = 0.0D;
  
  private ay()
  {
    try
    {
      cg();
      return;
    }
    catch (Exception localException) {}
  }
  
  private String jdMethod_byte(boolean paramBoolean)
  {
    double d1 = 0.0D;
    double d2 = 0.0D;
    boolean bool = false;
    int i;
    double d3;
    if (this.iE)
    {
      d1 = this.is;
      d2 = this.ir;
      bool = true;
      i = 1;
      d3 = 246.4D;
    }
    for (;;)
    {
      j.cZ().jdMethod_if(this.iy, this.iE, d1, d2);
      if (i != 0)
      {
        String str;
        if (paramBoolean)
        {
          str = "{\"result\":{\"time\":\"" + c.jdMethod_new() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}";
          return String.format(Locale.CHINA, str, new Object[] { Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d3), Boolean.valueOf(true) });
          if (this.iy)
          {
            d1 = this.iv;
            d2 = this.iu;
            d3 = this.iz;
            bool = ah.ay().aA();
            i = 1;
          }
        }
        else
        {
          str = "{\"result\":{\"time\":\"" + c.jdMethod_new() + "\",\"error\":\"68\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}";
          return String.format(Locale.CHINA, str, new Object[] { Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d3), Boolean.valueOf(bool) });
        }
      }
      else
      {
        if (paramBoolean) {
          return "{\"result\":{\"time\":\"" + c.jdMethod_new() + "\",\"error\":\"67\"}}";
        }
        return "{\"result\":{\"time\":\"" + c.jdMethod_new() + "\",\"error\":\"63\"}}";
      }
      i = 0;
      d3 = 0.0D;
    }
  }
  
  public static ay cd()
  {
    if (im == null) {
      im = new ay();
    }
    return im;
  }
  
  private void ce()
  {
    SQLiteDatabase localSQLiteDatabase2;
    long l2;
    try
    {
      SQLiteDatabase localSQLiteDatabase1 = SQLiteDatabase.openOrCreateDatabase(this.iB, null);
      if (localSQLiteDatabase1 == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localSQLiteDatabase2 = null;
      }
      long l1 = DatabaseUtils.queryNumEntries(localSQLiteDatabase2, "wof");
      l2 = DatabaseUtils.queryNumEntries(localSQLiteDatabase2, "bdcltb09");
      if (l1 <= 10000L) {
        break label106;
      }
    }
    boolean bool1 = true;
    if (l2 > 10000L) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((bool1) || (bool2)) {
        new a(null).execute(new Boolean[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      }
      localSQLiteDatabase2.close();
      return;
      label106:
      bool1 = false;
      break;
    }
  }
  
  private void cf()
  {
    t.a locala = t.an().ak();
    if (locala != null) {
      r(locala.a());
    }
    jdMethod_for(ar.bW().bS());
  }
  
  private void cg()
  {
    try
    {
      Object localObject = new File(I);
      File localFile = new File(this.iB);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      if (localFile.exists())
      {
        localObject = SQLiteDatabase.openOrCreateDatabase(localFile, null);
        ((SQLiteDatabase)localObject).execSQL("CREATE TABLE IF NOT EXISTS bdcltb09(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
        ((SQLiteDatabase)localObject).execSQL("CREATE TABLE IF NOT EXISTS wof(id CHAR(15) PRIMARY KEY,mktime DOUBLE,time DOUBLE, ac INT, bc INT, cc INT);");
        ((SQLiteDatabase)localObject).setVersion(1);
        ((SQLiteDatabase)localObject).close();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void jdMethod_for(ar.b paramb)
  {
    System.currentTimeMillis();
    this.iE = false;
    if (paramb.jdField_for == null) {}
    for (;;)
    {
      return;
      try
      {
        SQLiteDatabase localSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.iB, null);
        if ((localSQLiteDatabase == null) || (paramb == null)) {
          continue;
        }
        Iterator localIterator = paramb.jdField_for.iterator();
        j = 0;
        paramb = null;
        k = 0;
        i = 0;
        d2 = 0.0D;
        d1 = 0.0D;
        int m = 0;
        n = i;
        d3 = d2;
        d4 = d1;
        if (localIterator.hasNext())
        {
          localObject2 = (ScanResult)localIterator.next();
          m += 1;
          if (m > 10)
          {
            d4 = d1;
            d3 = d2;
            n = i;
          }
        }
        else
        {
          if (n > 0)
          {
            this.iE = true;
            this.is = (d4 / n);
            this.ir = (d3 / n);
          }
          localSQLiteDatabase.close();
          return;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          int j;
          int k;
          int i;
          double d2;
          double d1;
          Object localObject1 = null;
          continue;
          Object localObject2 = Jni.j(((ScanResult)localObject2).BSSID.replace(":", ""));
          int i1 = k;
          int n = i;
          double d4 = d2;
          double d3 = d1;
          try
          {
            localObject2 = ((SQLiteDatabase)localObject1).rawQuery("select * from wof where id = \"" + (String)localObject2 + "\";", null);
            i1 = k;
            n = i;
            d4 = d2;
            d3 = d1;
            double d5;
            double d6;
            int i2;
            if (((Cursor)localObject2).moveToFirst())
            {
              i1 = k;
              n = i;
              d4 = d2;
              d3 = d1;
              d5 = ((Cursor)localObject2).getDouble(1) - 113.2349D;
              i1 = k;
              n = i;
              d4 = d2;
              d3 = d1;
              d6 = ((Cursor)localObject2).getDouble(2) - 432.1238D;
              i1 = k;
              n = i;
              d4 = d2;
              d3 = d1;
              ((Cursor)localObject2).getInt(3);
              i1 = k;
              n = i;
              d4 = d2;
              d3 = d1;
              i2 = ((Cursor)localObject2).getInt(4);
              i1 = k;
              n = i;
              d4 = d2;
              d3 = d1;
              int i3 = ((Cursor)localObject2).getInt(5);
              i1 = k;
              n = i;
              d4 = d2;
              d3 = d1;
              ((Cursor)localObject2).close();
              if ((i3 > 8) && (i3 > i2)) {
                continue;
              }
              i1 = k;
              n = i;
              d4 = d2;
              d3 = d1;
              if (this.iy)
              {
                i1 = k;
                n = i;
                d4 = d2;
                d3 = d1;
                localObject2 = new float[1];
                i1 = k;
                n = i;
                d4 = d2;
                d3 = d1;
                Location.distanceBetween(d6, d5, this.iu, this.iv, (float[])localObject2);
                i1 = k;
                n = i;
                d4 = d2;
                d3 = d1;
                if (localObject2[0] <= this.iz + 2000.0D) {
                  break label949;
                }
                continue;
              }
              if (k != 0)
              {
                i1 = k;
                n = i;
                d4 = d2;
                d3 = d1;
                localObject2 = new float[1];
                i1 = k;
                n = i;
                d4 = d2;
                d3 = d1;
                Location.distanceBetween(d6, d5, d2 / i, d1 / i, (float[])localObject2);
                if (localObject2[0] <= 1000.0F) {
                  break label1009;
                }
                continue;
              }
              if (paramb != null) {
                break label1022;
              }
              i1 = k;
              n = i;
              d4 = d2;
              d3 = d1;
              localObject2 = new double[8];
              n = j + 1;
              localObject2[j] = d5;
              localObject2[n] = d6;
              j = n + 1;
              paramb = (ar.b)localObject2;
              d3 = d1;
              d1 = d2;
              d2 = d3;
              break label974;
            }
            for (;;)
            {
              label682:
              if (i2 < j)
              {
                i1 = k;
                n = i;
                d4 = d2;
                d3 = d1;
                localObject2 = new float[1];
                i1 = k;
                n = i;
                d4 = d2;
                d3 = d1;
                Location.distanceBetween(d6, d5, paramb[(i2 + 1)], paramb[i2], (float[])localObject2);
                float f = localObject2[0];
                if (f >= 1000.0F) {
                  break label936;
                }
                k = 1;
                d4 = paramb[i2];
                d3 = paramb[(i2 + 1)] + d2;
                i += 1;
                d2 = d1 + d4;
                d1 = d3;
              }
              for (;;)
              {
                i2 += 2;
                d3 = d2;
                d2 = d1;
                d1 = d3;
                break label682;
                if (k != 0)
                {
                  i += 1;
                  d2 += d6;
                  d3 = d1 + d5;
                  d1 = d2;
                  d2 = d3;
                  break label974;
                }
                if (j < 8)
                {
                  n = j + 1;
                  paramb[j] = d5;
                  paramb[n] = d6;
                  j = n + 1;
                  d3 = d1;
                  d1 = d2;
                  d2 = d3;
                  break label974;
                }
                i1 = k;
                n = i;
                d4 = d2;
                d3 = d1;
                ((SQLiteDatabase)localObject1).close();
                return;
                i1 = k;
                n = i;
                d4 = d2;
                d3 = d1;
                ((Cursor)localObject2).close();
                break;
                label936:
                d3 = d1;
                d1 = d2;
                d2 = d3;
              }
              label949:
              k = 1;
              i += 1;
              d3 = d2 + d6;
              d2 = d1 + d5;
              d1 = d3;
              for (;;)
              {
                label974:
                n = j;
                j = i;
                d4 = d1;
                d3 = d2;
                if (i <= 4) {
                  break label1046;
                }
                n = i;
                d3 = d1;
                d4 = d2;
                break;
                label1009:
                d3 = d1;
                d1 = d2;
                d2 = d3;
              }
              label1022:
              i2 = 0;
            }
          }
          catch (Exception localException2)
          {
            i = j;
            k = i1;
            j = n;
            n = i;
            label1046:
            i = j;
            d2 = d4;
            d1 = d3;
            j = n;
          }
        }
      }
    }
  }
  
  private void jdMethod_if(ar.b paramb, BDLocation paramBDLocation, SQLiteDatabase paramSQLiteDatabase)
  {
    if ((paramBDLocation == null) || (paramBDLocation.getLocType() != 161) || ((!"wf".equals(paramBDLocation.getNetworkLocationType())) && (paramBDLocation.getRadius() >= 300.0F))) {
      break label38;
    }
    label38:
    label689:
    label695:
    for (;;)
    {
      return;
      if (paramb.jdField_for != null)
      {
        int n = (int)(System.currentTimeMillis() >> 28);
        System.currentTimeMillis();
        paramb = paramb.jdField_for.iterator();
        int i = 0;
        for (;;)
        {
          if (!paramb.hasNext()) {
            break label695;
          }
          Object localObject1 = (ScanResult)paramb.next();
          if (((ScanResult)localObject1).level != 0)
          {
            i += 1;
            if (i > 6) {
              break;
            }
            ContentValues localContentValues = new ContentValues();
            localObject1 = Jni.j(((ScanResult)localObject1).BSSID.replace(":", ""));
            do
            {
              try
              {
                Object localObject2 = paramSQLiteDatabase.rawQuery("select * from wof where id = \"" + (String)localObject1 + "\";", null);
                double d2;
                double d1;
                int j;
                int k;
                if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst()))
                {
                  d2 = ((Cursor)localObject2).getDouble(1);
                  d1 = ((Cursor)localObject2).getDouble(2);
                  ((Cursor)localObject2).getInt(3);
                  j = ((Cursor)localObject2).getInt(4);
                  m = ((Cursor)localObject2).getInt(5);
                  d2 -= 113.2349D;
                  k = 1;
                }
                for (d1 -= 432.1238D;; d1 = 0.0D)
                {
                  ((Cursor)localObject2).close();
                  if (k != 0) {
                    break label689;
                  }
                  localContentValues.put("mktime", Double.valueOf(paramBDLocation.getLongitude() + 113.2349D));
                  localContentValues.put("time", Double.valueOf(paramBDLocation.getLatitude() + 432.1238D));
                  localContentValues.put("bc", Integer.valueOf(1));
                  localContentValues.put("cc", Integer.valueOf(1));
                  localContentValues.put("ac", Integer.valueOf(n));
                  localContentValues.put("id", (String)localObject1);
                  paramSQLiteDatabase.insert("wof", null, localContentValues);
                  break;
                  localObject2 = new float[1];
                  Location.distanceBetween(d1, d2, paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), (float[])localObject2);
                  if (localObject2[0] > 1500.0F)
                  {
                    k = m + 1;
                    if ((k > 10) && (k > j * 3))
                    {
                      localContentValues.put("mktime", Double.valueOf(paramBDLocation.getLongitude() + 113.2349D));
                      localContentValues.put("time", Double.valueOf(paramBDLocation.getLatitude() + 432.1238D));
                      localContentValues.put("bc", Integer.valueOf(1));
                      localContentValues.put("cc", Integer.valueOf(1));
                      localContentValues.put("ac", Integer.valueOf(n));
                    }
                  }
                  try
                  {
                    for (;;)
                    {
                      j = paramSQLiteDatabase.update("wof", localContentValues, "id = \"" + (String)localObject1 + "\"", null);
                      if (j > 0) {
                        break;
                      }
                      break;
                      localContentValues.put("cc", Integer.valueOf(k));
                      continue;
                      d2 = (d2 * j + paramBDLocation.getLongitude()) / (j + 1);
                      d1 = (d1 * j + paramBDLocation.getLatitude()) / (j + 1);
                      localContentValues.put("mktime", Double.valueOf(d2 + 113.2349D));
                      localContentValues.put("time", Double.valueOf(d1 + 432.1238D));
                      localContentValues.put("bc", Integer.valueOf(j + 1));
                      localContentValues.put("ac", Integer.valueOf(n));
                    }
                    m = 0;
                  }
                  catch (Exception localException1) {}
                  j = 0;
                  d2 = 0.0D;
                  k = 0;
                }
              }
              catch (Exception localException2)
              {
                int m;
                for (;;) {}
              }
            } while (m != 0);
          }
        }
      }
    }
  }
  
  private void jdMethod_if(String paramString, t.a parama, SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    double d2 = 0.0D;
    if ((!parama.jdMethod_for()) || (!ah.ay().aA())) {
      return;
    }
    System.currentTimeMillis();
    int j = (int)(System.currentTimeMillis() >> 28);
    parama = parama.a();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int k = Integer.parseInt(paramString.getJSONObject("result").getString("error"));
        if (k == 161)
        {
          paramString = paramString.getJSONObject("content");
          if (!paramString.has("clf")) {
            break label372;
          }
          Object localObject = paramString.getString("clf");
          if (((String)localObject).equals("0"))
          {
            localObject = paramString.getJSONObject("point");
            d2 = Double.parseDouble(((JSONObject)localObject).getString("x"));
            d1 = Double.parseDouble(((JSONObject)localObject).getString("y"));
            f = Float.parseFloat(paramString.getString("radius"));
            if (i != 0) {
              break;
            }
            paramString = new ContentValues();
            paramString.put("time", Double.valueOf(d2 + 1235.4323D));
            paramString.put("tag", Float.valueOf(4326.0F + f));
            paramString.put("type", Double.valueOf(d1 + 2367.3217D));
            paramString.put("ac", Integer.valueOf(j));
            try
            {
              if (paramSQLiteDatabase.update("bdcltb09", paramString, "id = \"" + parama + "\"", null) > 0) {
                break;
              }
              paramString.put("id", parama);
              paramSQLiteDatabase.insert("bdcltb09", null, paramString);
              return;
            }
            catch (Exception paramString)
            {
              return;
            }
          }
          paramString = ((String)localObject).split("\\|");
          d2 = Double.parseDouble(paramString[0]);
          d1 = Double.parseDouble(paramString[1]);
          f = Float.parseFloat(paramString[2]);
          continue;
        }
        if (k == 167)
        {
          paramSQLiteDatabase.delete("bdcltb09", "id = \"" + parama + "\"", null);
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      label372:
      i = 1;
      float f = 0.0F;
      double d1 = 0.0D;
    }
  }
  
  private void k(Message paramMessage)
  {
    k.p().jdMethod_if(jdMethod_case(true), paramMessage);
  }
  
  private void r(String paramString)
  {
    Object localObject1 = null;
    if ((paramString == null) || (paramString.equals(this.iG))) {
      return;
    }
    try
    {
      localObject2 = SQLiteDatabase.openOrCreateDatabase(this.iB, null);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;) {}
    }
    if ((localObject1 == null) || (paramString == null))
    {
      this.iy = false;
      return;
    }
    this.iy = false;
    try
    {
      localObject2 = ((SQLiteDatabase)localObject1).rawQuery("select * from bdcltb09 where id = \"" + paramString + "\";", null);
      this.iG = paramString;
      this.ip = System.currentTimeMillis();
      if (localObject2 != null)
      {
        if (((Cursor)localObject2).moveToFirst())
        {
          this.iv = (((Cursor)localObject2).getDouble(1) - 1235.4323D);
          this.iz = (((Cursor)localObject2).getDouble(2) - 4326.0D);
          this.iu = (((Cursor)localObject2).getDouble(3) - 2367.3217D);
          this.iy = true;
        }
        ((Cursor)localObject2).close();
      }
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    ((SQLiteDatabase)localObject1).close();
  }
  
  public BDLocation jdMethod_case(boolean paramBoolean)
  {
    cf();
    return new BDLocation(jdMethod_byte(paramBoolean));
  }
  
  public void ch() {}
  
  public void ci()
  {
    this.ix = true;
    ab.bj().postDelayed(new ay.1(this), 3000L);
  }
  
  public void jdMethod_if(String paramString, t.a parama, ar.b paramb, BDLocation paramBDLocation)
  {
    if ((!parama.jdMethod_for()) || (!ah.ay().aA())) {}
    for (int j = 1;; j = 0)
    {
      if ((paramBDLocation == null) || (paramBDLocation.getLocType() != 161) || ((!"wf".equals(paramBDLocation.getNetworkLocationType())) && (paramBDLocation.getRadius() >= 300.0F))) {}
      for (int i = 1;; i = 0)
      {
        if (paramb.jdField_for == null) {
          i = 1;
        }
        if ((j != 0) && (i != 0)) {}
        while (this.iA) {
          return;
        }
        this.iA = true;
        new b(null).execute(new Object[] { paramString, parama, paramb, paramBDLocation });
        return;
      }
    }
  }
  
  public void j(Message paramMessage)
  {
    k(paramMessage);
  }
  
  private class a
    extends AsyncTask
  {
    private a() {}
    
    protected Boolean a(Boolean... paramVarArgs)
    {
      Object localObject1 = null;
      if (paramVarArgs.length != 4) {
        return Boolean.valueOf(false);
      }
      try
      {
        localObject2 = SQLiteDatabase.openOrCreateDatabase(ay.jdMethod_if(ay.this), null);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        Object localObject2;
        int i;
        for (;;) {}
      }
      if (localObject1 == null) {
        return Boolean.valueOf(false);
      }
      i = (int)(System.currentTimeMillis() >> 28);
      for (;;)
      {
        try
        {
          ((SQLiteDatabase)localObject1).beginTransaction();
          if (paramVarArgs[0].booleanValue()) {
            localObject2 = "delete from wof where ac < " + (i - 35);
          }
        }
        catch (Exception paramVarArgs)
        {
          continue;
        }
        try
        {
          ((SQLiteDatabase)localObject1).execSQL((String)localObject2);
          if (paramVarArgs[1].booleanValue()) {
            paramVarArgs = "delete from bdcltb09 where ac is NULL or ac < " + (i - 130);
          }
        }
        catch (Exception localException1)
        {
          try
          {
            ((SQLiteDatabase)localObject1).execSQL(paramVarArgs);
            ((SQLiteDatabase)localObject1).setTransactionSuccessful();
            ((SQLiteDatabase)localObject1).endTransaction();
            ((SQLiteDatabase)localObject1).close();
            return Boolean.valueOf(true);
            localException1 = localException1;
          }
          catch (Exception paramVarArgs) {}
        }
      }
    }
  }
  
  private class b
    extends AsyncTask
  {
    private b() {}
    
    protected Boolean a(Object... paramVarArgs)
    {
      if (paramVarArgs.length != 4)
      {
        ay.jdMethod_if(ay.this, false);
        return Boolean.valueOf(false);
      }
      SQLiteDatabase localSQLiteDatabase2;
      try
      {
        SQLiteDatabase localSQLiteDatabase1 = SQLiteDatabase.openOrCreateDatabase(ay.jdMethod_if(ay.this), null);
        if (localSQLiteDatabase1 == null)
        {
          ay.jdMethod_if(ay.this, false);
          return Boolean.valueOf(false);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localSQLiteDatabase2 = null;
        }
      }
      try
      {
        localSQLiteDatabase2.beginTransaction();
        ay.jdMethod_if(ay.this, (String)paramVarArgs[0], (t.a)paramVarArgs[1], localSQLiteDatabase2);
        ay.jdMethod_if(ay.this, (ar.b)paramVarArgs[2], (BDLocation)paramVarArgs[3], localSQLiteDatabase2);
        localSQLiteDatabase2.setTransactionSuccessful();
        localSQLiteDatabase2.endTransaction();
        localSQLiteDatabase2.close();
        ay.jdMethod_if(ay.this, false);
        return Boolean.valueOf(true);
      }
      catch (Exception paramVarArgs)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
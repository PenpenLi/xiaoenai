package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

class ActivityChooserModel
  extends DataSetObservable
{
  private static final String a = ActivityChooserModel.class.getSimpleName();
  private static final Object b = new Object();
  private static final Map<String, ActivityChooserModel> c = new HashMap();
  private final Object d = new Object();
  private final List<ActivityResolveInfo> e = new ArrayList();
  private final List<HistoricalRecord> f = new ArrayList();
  private final Context g;
  private final String h;
  private Intent i;
  private ActivitySorter j = new a(null);
  private int k = 50;
  private boolean l = true;
  private boolean m = false;
  private boolean n = true;
  private boolean o = false;
  private OnChooseActivityListener p;
  
  private ActivityChooserModel(Context paramContext, String paramString)
  {
    this.g = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml")))
    {
      this.h = (paramString + ".xml");
      return;
    }
    this.h = paramString;
  }
  
  public static ActivityChooserModel a(Context paramContext, String paramString)
  {
    synchronized (b)
    {
      ActivityChooserModel localActivityChooserModel2 = (ActivityChooserModel)c.get(paramString);
      ActivityChooserModel localActivityChooserModel1 = localActivityChooserModel2;
      if (localActivityChooserModel2 == null)
      {
        localActivityChooserModel1 = new ActivityChooserModel(paramContext, paramString);
        c.put(paramString, localActivityChooserModel1);
      }
      return localActivityChooserModel1;
    }
  }
  
  private boolean a(HistoricalRecord paramHistoricalRecord)
  {
    boolean bool = this.f.add(paramHistoricalRecord);
    if (bool)
    {
      this.n = true;
      j();
      e();
      g();
      notifyChanged();
    }
    return bool;
  }
  
  private void e()
  {
    if (!this.m) {
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    }
    if (!this.n) {}
    do
    {
      return;
      this.n = false;
    } while (TextUtils.isEmpty(this.h));
    AsyncTaskCompat.executeParallel(new b(null), new Object[] { new ArrayList(this.f), this.h });
  }
  
  private void f()
  {
    boolean bool1 = h();
    boolean bool2 = i();
    j();
    if ((bool1 | bool2))
    {
      g();
      notifyChanged();
    }
  }
  
  private boolean g()
  {
    if ((this.j != null) && (this.i != null) && (!this.e.isEmpty()) && (!this.f.isEmpty()))
    {
      this.j.sort(this.i, this.e, Collections.unmodifiableList(this.f));
      return true;
    }
    return false;
  }
  
  private boolean h()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.o)
    {
      bool1 = bool2;
      if (this.i != null)
      {
        this.o = false;
        this.e.clear();
        List localList = this.g.getPackageManager().queryIntentActivities(this.i, 0);
        int i2 = localList.size();
        int i1 = 0;
        while (i1 < i2)
        {
          ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i1);
          this.e.add(new ActivityResolveInfo(localResolveInfo));
          i1 += 1;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean i()
  {
    if ((this.l) && (this.n) && (!TextUtils.isEmpty(this.h)))
    {
      this.l = false;
      this.m = true;
      k();
      return true;
    }
    return false;
  }
  
  private void j()
  {
    int i2 = this.f.size() - this.k;
    if (i2 <= 0) {}
    for (;;)
    {
      return;
      this.n = true;
      int i1 = 0;
      while (i1 < i2)
      {
        HistoricalRecord localHistoricalRecord = (HistoricalRecord)this.f.remove(0);
        i1 += 1;
      }
    }
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 111	android/support/v7/widget/ActivityChooserModel:g	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 137	android/support/v7/widget/ActivityChooserModel:h	Ljava/lang/String;
    //   8: invokevirtual 245	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_1
    //   12: invokestatic 251	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_2
    //   16: aload_2
    //   17: aload_1
    //   18: ldc -3
    //   20: invokeinterface 259 3 0
    //   25: iconst_0
    //   26: istore 4
    //   28: iload 4
    //   30: iconst_1
    //   31: if_icmpeq +20 -> 51
    //   34: iload 4
    //   36: iconst_2
    //   37: if_icmpeq +14 -> 51
    //   40: aload_2
    //   41: invokeinterface 262 1 0
    //   46: istore 4
    //   48: goto -20 -> 28
    //   51: ldc_w 264
    //   54: aload_2
    //   55: invokeinterface 267 1 0
    //   60: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifne +55 -> 118
    //   66: new 239	org/xmlpull/v1/XmlPullParserException
    //   69: dup
    //   70: ldc_w 272
    //   73: invokespecial 273	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   76: athrow
    //   77: astore_2
    //   78: getstatic 64	android/support/v7/widget/ActivityChooserModel:a	Ljava/lang/String;
    //   81: new 127	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 275
    //   91: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: getfield 137	android/support/v7/widget/ActivityChooserModel:h	Ljava/lang/String;
    //   98: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: aload_2
    //   105: invokestatic 280	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   108: pop
    //   109: aload_1
    //   110: ifnull +7 -> 117
    //   113: aload_1
    //   114: invokevirtual 285	java/io/FileInputStream:close	()V
    //   117: return
    //   118: aload_0
    //   119: getfield 88	android/support/v7/widget/ActivityChooserModel:f	Ljava/util/List;
    //   122: astore_3
    //   123: aload_3
    //   124: invokeinterface 208 1 0
    //   129: aload_2
    //   130: invokeinterface 262 1 0
    //   135: istore 4
    //   137: iload 4
    //   139: iconst_1
    //   140: if_icmpne +14 -> 154
    //   143: aload_1
    //   144: ifnull -27 -> 117
    //   147: aload_1
    //   148: invokevirtual 285	java/io/FileInputStream:close	()V
    //   151: return
    //   152: astore_1
    //   153: return
    //   154: iload 4
    //   156: iconst_3
    //   157: if_icmpeq -28 -> 129
    //   160: iload 4
    //   162: iconst_4
    //   163: if_icmpeq -34 -> 129
    //   166: ldc_w 287
    //   169: aload_2
    //   170: invokeinterface 267 1 0
    //   175: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   178: ifne +57 -> 235
    //   181: new 239	org/xmlpull/v1/XmlPullParserException
    //   184: dup
    //   185: ldc_w 289
    //   188: invokespecial 273	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   191: athrow
    //   192: astore_2
    //   193: getstatic 64	android/support/v7/widget/ActivityChooserModel:a	Ljava/lang/String;
    //   196: new 127	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 275
    //   206: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_0
    //   210: getfield 137	android/support/v7/widget/ActivityChooserModel:h	Ljava/lang/String;
    //   213: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: aload_2
    //   220: invokestatic 280	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   223: pop
    //   224: aload_1
    //   225: ifnull -108 -> 117
    //   228: aload_1
    //   229: invokevirtual 285	java/io/FileInputStream:close	()V
    //   232: return
    //   233: astore_1
    //   234: return
    //   235: aload_3
    //   236: new 17	android/support/v7/widget/ActivityChooserModel$HistoricalRecord
    //   239: dup
    //   240: aload_2
    //   241: aconst_null
    //   242: ldc_w 291
    //   245: invokeinterface 295 3 0
    //   250: aload_2
    //   251: aconst_null
    //   252: ldc_w 297
    //   255: invokeinterface 295 3 0
    //   260: invokestatic 303	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   263: aload_2
    //   264: aconst_null
    //   265: ldc_w 305
    //   268: invokeinterface 295 3 0
    //   273: invokestatic 311	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   276: invokespecial 314	android/support/v7/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
    //   279: invokeinterface 158 2 0
    //   284: pop
    //   285: goto -156 -> 129
    //   288: astore_2
    //   289: aload_1
    //   290: ifnull +7 -> 297
    //   293: aload_1
    //   294: invokevirtual 285	java/io/FileInputStream:close	()V
    //   297: aload_2
    //   298: athrow
    //   299: astore_1
    //   300: return
    //   301: astore_1
    //   302: goto -5 -> 297
    //   305: astore_1
    //   306: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	ActivityChooserModel
    //   11	137	1	localFileInputStream	java.io.FileInputStream
    //   152	77	1	localIOException1	IOException
    //   233	61	1	localIOException2	IOException
    //   299	1	1	localIOException3	IOException
    //   301	1	1	localIOException4	IOException
    //   305	1	1	localFileNotFoundException	FileNotFoundException
    //   15	40	2	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   77	93	2	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   192	72	2	localIOException5	IOException
    //   288	10	2	localObject	Object
    //   122	114	3	localList	List
    //   26	138	4	i1	int
    // Exception table:
    //   from	to	target	type
    //   12	25	77	org/xmlpull/v1/XmlPullParserException
    //   40	48	77	org/xmlpull/v1/XmlPullParserException
    //   51	77	77	org/xmlpull/v1/XmlPullParserException
    //   118	129	77	org/xmlpull/v1/XmlPullParserException
    //   129	137	77	org/xmlpull/v1/XmlPullParserException
    //   166	192	77	org/xmlpull/v1/XmlPullParserException
    //   235	285	77	org/xmlpull/v1/XmlPullParserException
    //   147	151	152	java/io/IOException
    //   12	25	192	java/io/IOException
    //   40	48	192	java/io/IOException
    //   51	77	192	java/io/IOException
    //   118	129	192	java/io/IOException
    //   129	137	192	java/io/IOException
    //   166	192	192	java/io/IOException
    //   235	285	192	java/io/IOException
    //   228	232	233	java/io/IOException
    //   12	25	288	finally
    //   40	48	288	finally
    //   51	77	288	finally
    //   78	109	288	finally
    //   118	129	288	finally
    //   129	137	288	finally
    //   166	192	288	finally
    //   193	224	288	finally
    //   235	285	288	finally
    //   113	117	299	java/io/IOException
    //   293	297	301	java/io/IOException
    //   0	12	305	java/io/FileNotFoundException
  }
  
  public int a()
  {
    synchronized (this.d)
    {
      f();
      int i1 = this.e.size();
      return i1;
    }
  }
  
  public int a(ResolveInfo paramResolveInfo)
  {
    for (;;)
    {
      int i1;
      synchronized (this.d)
      {
        f();
        List localList = this.e;
        int i2 = localList.size();
        i1 = 0;
        if (i1 < i2)
        {
          if (((ActivityResolveInfo)localList.get(i1)).resolveInfo == paramResolveInfo) {
            return i1;
          }
        }
        else {
          return -1;
        }
      }
      i1 += 1;
    }
  }
  
  public ResolveInfo a(int paramInt)
  {
    synchronized (this.d)
    {
      f();
      ResolveInfo localResolveInfo = ((ActivityResolveInfo)this.e.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }
  
  public void a(Intent paramIntent)
  {
    synchronized (this.d)
    {
      if (this.i == paramIntent) {
        return;
      }
      this.i = paramIntent;
      this.o = true;
      f();
      return;
    }
  }
  
  public void a(OnChooseActivityListener paramOnChooseActivityListener)
  {
    synchronized (this.d)
    {
      this.p = paramOnChooseActivityListener;
      return;
    }
  }
  
  public Intent b(int paramInt)
  {
    synchronized (this.d)
    {
      if (this.i == null) {
        return null;
      }
      f();
      Object localObject2 = (ActivityResolveInfo)this.e.get(paramInt);
      localObject2 = new ComponentName(((ActivityResolveInfo)localObject2).resolveInfo.activityInfo.packageName, ((ActivityResolveInfo)localObject2).resolveInfo.activityInfo.name);
      Intent localIntent1 = new Intent(this.i);
      localIntent1.setComponent((ComponentName)localObject2);
      if (this.p != null)
      {
        Intent localIntent2 = new Intent(localIntent1);
        if (this.p.onChooseActivity(this, localIntent2)) {
          return null;
        }
      }
      a(new HistoricalRecord((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      return localIntent1;
    }
  }
  
  public ResolveInfo b()
  {
    synchronized (this.d)
    {
      f();
      if (!this.e.isEmpty())
      {
        ResolveInfo localResolveInfo = ((ActivityResolveInfo)this.e.get(0)).resolveInfo;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  public int c()
  {
    synchronized (this.d)
    {
      f();
      int i1 = this.f.size();
      return i1;
    }
  }
  
  public void c(int paramInt)
  {
    for (;;)
    {
      synchronized (this.d)
      {
        f();
        ActivityResolveInfo localActivityResolveInfo1 = (ActivityResolveInfo)this.e.get(paramInt);
        ActivityResolveInfo localActivityResolveInfo2 = (ActivityResolveInfo)this.e.get(0);
        if (localActivityResolveInfo2 != null)
        {
          f1 = localActivityResolveInfo2.weight - localActivityResolveInfo1.weight + 5.0F;
          a(new HistoricalRecord(new ComponentName(localActivityResolveInfo1.resolveInfo.activityInfo.packageName, localActivityResolveInfo1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f1));
          return;
        }
      }
      float f1 = 1.0F;
    }
  }
  
  public static abstract interface ActivityChooserModelClient
  {
    public abstract void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel);
  }
  
  public final class ActivityResolveInfo
    implements Comparable<ActivityResolveInfo>
  {
    public final ResolveInfo resolveInfo;
    public float weight;
    
    public ActivityResolveInfo(ResolveInfo paramResolveInfo)
    {
      this.resolveInfo = paramResolveInfo;
    }
    
    public int compareTo(ActivityResolveInfo paramActivityResolveInfo)
    {
      return Float.floatToIntBits(paramActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (ActivityResolveInfo)paramObject;
      } while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo)paramObject).weight));
      return false;
    }
    
    public int hashCode()
    {
      return Float.floatToIntBits(this.weight) + 31;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface ActivitySorter
  {
    public abstract void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1);
  }
  
  public static final class HistoricalRecord
  {
    public final ComponentName activity;
    public final long time;
    public final float weight;
    
    public HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      this.activity = paramComponentName;
      this.time = paramLong;
      this.weight = paramFloat;
    }
    
    public HistoricalRecord(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (HistoricalRecord)paramObject;
        if (this.activity == null)
        {
          if (((HistoricalRecord)paramObject).activity != null) {
            return false;
          }
        }
        else if (!this.activity.equals(((HistoricalRecord)paramObject).activity)) {
          return false;
        }
        if (this.time != ((HistoricalRecord)paramObject).time) {
          return false;
        }
      } while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(((HistoricalRecord)paramObject).weight));
      return false;
    }
    
    public int hashCode()
    {
      if (this.activity == null) {}
      for (int i = 0;; i = this.activity.hashCode()) {
        return ((i + 31) * 31 + (int)(this.time ^ this.time >>> 32)) * 31 + Float.floatToIntBits(this.weight);
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("; activity:").append(this.activity);
      localStringBuilder.append("; time:").append(this.time);
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface OnChooseActivityListener
  {
    public abstract boolean onChooseActivity(ActivityChooserModel paramActivityChooserModel, Intent paramIntent);
  }
  
  private final class a
    implements ActivityChooserModel.ActivitySorter
  {
    private final Map<ComponentName, ActivityChooserModel.ActivityResolveInfo> b = new HashMap();
    
    private a() {}
    
    public void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1)
    {
      paramIntent = this.b;
      paramIntent.clear();
      int j = paramList.size();
      int i = 0;
      Object localObject;
      while (i < j)
      {
        localObject = (ActivityChooserModel.ActivityResolveInfo)paramList.get(i);
        ((ActivityChooserModel.ActivityResolveInfo)localObject).weight = 0.0F;
        paramIntent.put(new ComponentName(((ActivityChooserModel.ActivityResolveInfo)localObject).resolveInfo.activityInfo.packageName, ((ActivityChooserModel.ActivityResolveInfo)localObject).resolveInfo.activityInfo.name), localObject);
        i += 1;
      }
      i = paramList1.size();
      float f1 = 1.0F;
      i -= 1;
      if (i >= 0)
      {
        localObject = (ActivityChooserModel.HistoricalRecord)paramList1.get(i);
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo = (ActivityChooserModel.ActivityResolveInfo)paramIntent.get(((ActivityChooserModel.HistoricalRecord)localObject).activity);
        if (localActivityResolveInfo == null) {
          break label195;
        }
        float f2 = localActivityResolveInfo.weight;
        localActivityResolveInfo.weight = (((ActivityChooserModel.HistoricalRecord)localObject).weight * f1 + f2);
        f1 = 0.95F * f1;
      }
      label195:
      for (;;)
      {
        i -= 1;
        break;
        Collections.sort(paramList);
        return;
      }
    }
  }
  
  private final class b
    extends AsyncTask<Object, Void, Void>
  {
    private b() {}
    
    public Void a(Object... paramVarArgs)
    {
      int i = 0;
      List localList = (List)paramVarArgs[0];
      Object localObject2 = (String)paramVarArgs[1];
      for (;;)
      {
        try
        {
          paramVarArgs = ActivityChooserModel.a(ActivityChooserModel.this).openFileOutput((String)localObject2, 0);
          localObject2 = Xml.newSerializer();
          int j;
          ActivityChooserModel.HistoricalRecord localHistoricalRecord;
          ((XmlSerializer)localObject2).endTag(null, "historical-records");
        }
        catch (FileNotFoundException paramVarArgs)
        {
          try
          {
            ((XmlSerializer)localObject2).setOutput(paramVarArgs, null);
            ((XmlSerializer)localObject2).startDocument("UTF-8", Boolean.valueOf(true));
            ((XmlSerializer)localObject2).startTag(null, "historical-records");
            j = localList.size();
            if (i >= j) {
              break label204;
            }
            localHistoricalRecord = (ActivityChooserModel.HistoricalRecord)localList.remove(0);
            ((XmlSerializer)localObject2).startTag(null, "historical-record");
            ((XmlSerializer)localObject2).attribute(null, "activity", localHistoricalRecord.activity.flattenToString());
            ((XmlSerializer)localObject2).attribute(null, "time", String.valueOf(localHistoricalRecord.time));
            ((XmlSerializer)localObject2).attribute(null, "weight", String.valueOf(localHistoricalRecord.weight));
            ((XmlSerializer)localObject2).endTag(null, "historical-record");
            i += 1;
            continue;
            paramVarArgs = paramVarArgs;
            Log.e(ActivityChooserModel.d(), "Error writing historical recrod file: " + (String)localObject2, paramVarArgs);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            Log.e(ActivityChooserModel.d(), "Error writing historical recrod file: " + ActivityChooserModel.b(ActivityChooserModel.this), localIllegalArgumentException);
            ActivityChooserModel.a(ActivityChooserModel.this, true);
            if (paramVarArgs == null) {
              continue;
            }
            try
            {
              paramVarArgs.close();
              return null;
            }
            catch (IOException paramVarArgs)
            {
              return null;
            }
          }
          catch (IllegalStateException localIllegalStateException)
          {
            Log.e(ActivityChooserModel.d(), "Error writing historical recrod file: " + ActivityChooserModel.b(ActivityChooserModel.this), localIllegalStateException);
            ActivityChooserModel.a(ActivityChooserModel.this, true);
            if (paramVarArgs == null) {
              continue;
            }
            try
            {
              paramVarArgs.close();
              return null;
            }
            catch (IOException paramVarArgs)
            {
              return null;
            }
          }
          catch (IOException localIOException)
          {
            Log.e(ActivityChooserModel.d(), "Error writing historical recrod file: " + ActivityChooserModel.b(ActivityChooserModel.this), localIOException);
            ActivityChooserModel.a(ActivityChooserModel.this, true);
            if (paramVarArgs == null) {
              continue;
            }
            try
            {
              paramVarArgs.close();
              return null;
            }
            catch (IOException paramVarArgs)
            {
              return null;
            }
          }
          finally
          {
            ActivityChooserModel.a(ActivityChooserModel.this, true);
            if (paramVarArgs == null) {
              break label428;
            }
          }
          return null;
        }
        label204:
        ((XmlSerializer)localObject2).endDocument();
        ActivityChooserModel.a(ActivityChooserModel.this, true);
        if (paramVarArgs != null) {
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
      }
      try
      {
        paramVarArgs.close();
        label428:
        throw ((Throwable)localObject1);
      }
      catch (IOException paramVarArgs)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ActivityChooserModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
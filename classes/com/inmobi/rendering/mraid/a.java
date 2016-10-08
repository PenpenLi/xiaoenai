package com.inmobi.rendering.mraid;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract.Events;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

public class a
{
  private static final SimpleDateFormat[] a = { new SimpleDateFormat("yyyy-MM-dd'T'hh:mmZ", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US), new SimpleDateFormat("yyyy-MM-dd", Locale.US), new SimpleDateFormat("yyyy-MM", Locale.US), new SimpleDateFormat("yyyyMMddHHmmssZ", Locale.US), new SimpleDateFormat("yyyyMMddHHmm", Locale.US), new SimpleDateFormat("yyyyMMdd", Locale.US), new SimpleDateFormat("yyyyMM", Locale.US), new SimpleDateFormat("yyyy", Locale.US) };
  private static String b = a.class.getSimpleName();
  
  @TargetApi(14)
  public static int a(Context paramContext)
  {
    int j = 0;
    paramContext = paramContext.getContentResolver().query(CalendarContract.Events.CONTENT_URI, new String[] { "_id", "title" }, null, null, null);
    int i = j;
    String str2;
    if (paramContext != null)
    {
      i = j;
      if (paramContext.moveToLast())
      {
        i = paramContext.getColumnIndex("title");
        j = paramContext.getColumnIndex("_id");
        String str1 = paramContext.getString(i);
        str2 = paramContext.getString(j);
        if (str1 == null) {
          break label103;
        }
      }
    }
    label103:
    for (i = Integer.parseInt(str2);; i = 0)
    {
      paramContext.close();
      return i;
    }
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public static String a(String paramString)
  {
    Object localObject2 = null;
    int j = 0;
    Object localObject1 = localObject2;
    Object localObject3;
    int k;
    int i;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (!"".equals(paramString))
      {
        localObject3 = a;
        k = localObject3.length;
        i = 0;
        if (i >= k) {
          break label165;
        }
        localObject1 = localObject3[i];
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((SimpleDateFormat)localObject1).parse(paramString);
        paramString = (String)localObject1;
        localObject1 = localObject2;
        if (paramString != null)
        {
          localObject3 = new DateFormat[3];
          localObject3[0] = new SimpleDateFormat("yyyyMMdd'T'HHmmssZ", Locale.US);
          localObject3[1] = new SimpleDateFormat("yyyyMMdd'T'HHmm", Locale.US);
          localObject3[2] = new SimpleDateFormat("yyyyMMdd", Locale.US);
          k = localObject3.length;
          i = j;
          localObject1 = localObject2;
          if (i < k) {
            localObject1 = localObject3[i];
          }
        }
      }
      catch (ParseException localParseException)
      {
        try
        {
          localObject1 = ((DateFormat)localObject1).format(Long.valueOf(paramString.getTime()));
          return (String)localObject1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          i += 1;
        }
        localParseException = localParseException;
        i += 1;
      }
      continue;
      label165:
      paramString = null;
    }
  }
  
  public static String a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      Object localObject1 = new StringBuilder();
      int i = 0;
      for (;;)
      {
        if (i < paramJSONArray.length()) {
          try
          {
            Object localObject2 = paramJSONArray.get(i);
            ((StringBuilder)localObject1).append(localObject2 + ",");
            i += 1;
          }
          catch (JSONException paramJSONArray)
          {
            Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Could not parse day object " + paramJSONArray.toString());
            paramJSONArray = null;
          }
        }
      }
      do
      {
        return paramJSONArray;
        localObject1 = ((StringBuilder)localObject1).toString();
        i = ((String)localObject1).length();
        if (i == 0) {
          return null;
        }
        paramJSONArray = (JSONArray)localObject1;
      } while (((String)localObject1).charAt(i - 1) != ',');
      return ((String)localObject1).substring(0, i - 1);
    }
    return null;
  }
  
  public static String a(JSONArray paramJSONArray, int paramInt1, int paramInt2)
  {
    Object localObject;
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      localObject = new StringBuilder();
      i = 0;
    }
    for (;;)
    {
      if (i < paramJSONArray.length()) {
        try
        {
          int j = paramJSONArray.getInt(i);
          if ((j < paramInt1) || (j > paramInt2) || (j == 0)) {
            Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Value not in range");
          } else {
            ((StringBuilder)localObject).append(j).append(",");
          }
        }
        catch (JSONException paramJSONArray)
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Could not parse day " + paramJSONArray.getMessage());
          paramJSONArray = null;
        }
      }
      do
      {
        return paramJSONArray;
        localObject = ((StringBuilder)localObject).toString();
        paramInt1 = ((String)localObject).length();
        if (paramInt1 == 0) {
          return null;
        }
        paramJSONArray = (JSONArray)localObject;
      } while (((String)localObject).charAt(paramInt1 - 1) != ',');
      return ((String)localObject).substring(0, paramInt1 - 1);
      return null;
      i += 1;
    }
  }
  
  public static GregorianCalendar b(String paramString)
  {
    SimpleDateFormat[] arrayOfSimpleDateFormat = a;
    int j = arrayOfSimpleDateFormat.length;
    int i = 0;
    while (i < j)
    {
      SimpleDateFormat localSimpleDateFormat = arrayOfSimpleDateFormat[i];
      try
      {
        Object localObject = localSimpleDateFormat.parse(paramString);
        GregorianCalendar localGregorianCalendar = new GregorianCalendar();
        localGregorianCalendar.setTime((Date)localObject);
        Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Date format: " + localSimpleDateFormat.toPattern());
        localObject = (GregorianCalendar)localGregorianCalendar;
        return (GregorianCalendar)localObject;
      }
      catch (ParseException localParseException)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Skipping format: " + localSimpleDateFormat.toPattern());
        i += 1;
      }
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
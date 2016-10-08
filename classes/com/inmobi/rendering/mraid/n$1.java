package com.inmobi.rendering.mraid;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Reminders;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.InMobiAdActivity.a;
import com.inmobi.rendering.RenderView;
import java.util.Calendar;
import java.util.GregorianCalendar;

class n$1
  implements InMobiAdActivity.a
{
  n$1(n paramn, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(int paramInt, Intent paramIntent)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, n.a(), "Result code: " + paramInt);
    paramInt = a.a(this.a);
    if (this.b == paramInt)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, n.a(), "User cancelled the create calendar event");
      return;
    }
    ContentValues localContentValues = new ContentValues();
    paramIntent = this.c;
    paramInt = -1;
    switch (paramIntent.hashCode())
    {
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        paramIntent = this.a.getContentResolver();
        paramIntent.update(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, a.a(this.a)), localContentValues, null, null);
        if ((this.d == null) || ("".equals(this.d))) {
          break;
        }
      case 0: 
      case 1: 
      case 2: 
        try
        {
          label136:
          if (this.d.startsWith("+")) {}
          for (paramInt = Integer.parseInt(this.d.substring(1)) / 60000;; paramInt = Integer.parseInt(this.d) / 60000)
          {
            paramInt = -paramInt;
            paramIntent.delete(CalendarContract.Reminders.CONTENT_URI, "event_id=?", new String[] { a.a(this.a) + "" });
            if (paramInt >= 0) {
              break label468;
            }
            n.a(this.g).a(this.f, "Reminder format is incorrect. Reminder can be set only before the event starts", "createCalendarEvent");
            return;
            if (!paramIntent.equals("tentative")) {
              break;
            }
            paramInt = 0;
            break;
            if (!paramIntent.equals("confirmed")) {
              break;
            }
            paramInt = 1;
            break;
            if (!paramIntent.equals("cancelled")) {
              break;
            }
            paramInt = 2;
            break;
            localContentValues.put("eventStatus", Integer.valueOf(0));
            break label136;
            localContentValues.put("eventStatus", Integer.valueOf(1));
            break label136;
            localContentValues.put("eventStatus", Integer.valueOf(2));
            break label136;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int i;
          do
          {
            localObject = a.b(this.d);
            if (localObject == null)
            {
              Logger.a(Logger.InternalLogLevel.INTERNAL, n.a(), "Invalid reminder date provided. date string: " + this.d);
              return;
            }
            i = (int)(((Calendar)localObject).getTimeInMillis() - a.b(this.e).getTimeInMillis()) / 60000;
            paramInt = i;
          } while (i <= 0);
          n.a(this.g).a(this.f, "Reminder format is incorrect. Reminder can be set only before the event starts", "createCalendarEvent");
          return;
        }
      }
    }
    label468:
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("event_id", Integer.valueOf(a.a(this.a)));
    ((ContentValues)localObject).put("method", Integer.valueOf(1));
    ((ContentValues)localObject).put("minutes", Integer.valueOf(paramInt));
    paramIntent.insert(CalendarContract.Reminders.CONTENT_URI, (ContentValues)localObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\n$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
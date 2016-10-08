package com.google.gson.a.a;

import com.google.gson.ab;
import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.c.c;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

public final class d
  extends af<Date>
{
  public static final ah a = new e();
  private final DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
  private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
  
  private Date a(String paramString)
  {
    try
    {
      Date localDate1 = this.c.parse(paramString);
      paramString = localDate1;
    }
    catch (ParseException localParseException1)
    {
      try
      {
        Date localDate2 = this.b.parse(paramString);
        paramString = localDate2;
      }
      catch (ParseException localParseException2)
      {
        try
        {
          Date localDate3 = com.google.gson.a.a.a.a.a(paramString, new ParsePosition(0));
          paramString = localDate3;
        }
        catch (ParseException localParseException3)
        {
          throw new ab(paramString, localParseException3);
        }
      }
    }
    finally {}
    return paramString;
  }
  
  public Date a(com.google.gson.c.a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    return a(parama.h());
  }
  
  public void a(com.google.gson.c.d paramd, Date paramDate)
  {
    if (paramDate == null) {}
    for (;;)
    {
      try
      {
        paramd.f();
        return;
      }
      finally {}
      paramd.b(this.b.format(paramDate));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
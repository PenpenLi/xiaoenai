package a.a.a;

import android.database.SQLException;

public class d
  extends SQLException
{
  private static final long serialVersionUID = -5877937327907457779L;
  
  public d() {}
  
  public d(String paramString)
  {
    super(paramString);
  }
  
  public d(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    a(paramThrowable);
  }
  
  protected void a(Throwable paramThrowable)
  {
    try
    {
      initCause(paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      e.c("Could not set initial cause", localThrowable);
      e.c("Initial cause is:", paramThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
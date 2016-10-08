package b.a.a;

import b.a.f;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class m
  extends f
{
  m(d.c paramc, String paramString, Object[] paramArrayOfObject, p paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void b()
  {
    try
    {
      d.f(this.c.c).a(this.a);
      return;
    }
    catch (IOException localIOException1)
    {
      b.a.d.a.log(Level.INFO, "FramedConnection.Listener failure for " + d.a(this.c.c), localIOException1);
      try
      {
        this.a.a(a.b);
        return;
      }
      catch (IOException localIOException2) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
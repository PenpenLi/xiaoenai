package b;

import b.a.b;
import b.a.e;
import java.io.Closeable;
import java.io.Flushable;

public final class d
  implements Closeable, Flushable
{
  final e a;
  private final b b;
  
  public void close()
  {
    this.b.close();
  }
  
  public void flush()
  {
    this.b.flush();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
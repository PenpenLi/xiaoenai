package d.a;

import java.io.Serializable;

public class bj
  implements Serializable
{
  public final byte a;
  private final boolean b;
  private final String c;
  private final boolean d;
  
  public bj(byte paramByte)
  {
    this(paramByte, false);
  }
  
  public bj(byte paramByte, boolean paramBoolean)
  {
    this.a = paramByte;
    this.b = false;
    this.c = null;
    this.d = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
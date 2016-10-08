package d.a;

import java.io.ByteArrayOutputStream;

public class bf
{
  private final ByteArrayOutputStream a = new ByteArrayOutputStream();
  private final ce b = new ce(this.a);
  private bs c;
  
  public bf()
  {
    this(new bo.a());
  }
  
  public bf(bu parambu)
  {
    this.c = parambu.a(this.b);
  }
  
  public byte[] a(ba paramba)
  {
    this.a.reset();
    paramba.b(this.c);
    return this.a.toByteArray();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
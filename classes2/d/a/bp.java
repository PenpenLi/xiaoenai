package d.a;

public class bp
{
  public final String a;
  public final byte b;
  public final short c;
  
  public bp()
  {
    this("", (byte)0, (short)0);
  }
  
  public bp(String paramString, byte paramByte, short paramShort)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramShort;
  }
  
  public String toString()
  {
    return "<TField name:'" + this.a + "' type:" + this.b + " field-id:" + this.c + ">";
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
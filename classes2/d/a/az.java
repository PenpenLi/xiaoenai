package d.a;

public class az
{
  private short[] a;
  private int b = -1;
  
  public az(int paramInt)
  {
    this.a = new short[paramInt];
  }
  
  private void c()
  {
    short[] arrayOfShort = new short[this.a.length * 2];
    System.arraycopy(this.a, 0, arrayOfShort, 0, this.a.length);
    this.a = arrayOfShort;
  }
  
  public short a()
  {
    short[] arrayOfShort = this.a;
    int i = this.b;
    this.b = (i - 1);
    return arrayOfShort[i];
  }
  
  public void a(short paramShort)
  {
    if (this.a.length == this.b + 1) {
      c();
    }
    short[] arrayOfShort = this.a;
    int i = this.b + 1;
    this.b = i;
    arrayOfShort[i] = paramShort;
  }
  
  public void b()
  {
    this.b = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<ShortStack vector:[");
    int i = 0;
    while (i < this.a.length)
    {
      if (i != 0) {
        localStringBuilder.append(" ");
      }
      if (i == this.b) {
        localStringBuilder.append(">>");
      }
      localStringBuilder.append(this.a[i]);
      if (i == this.b) {
        localStringBuilder.append("<<");
      }
      i += 1;
    }
    localStringBuilder.append("]>");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
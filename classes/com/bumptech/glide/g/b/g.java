package com.bumptech.glide.g.b;

public abstract class g<Z>
  extends a<Z>
{
  private final int a;
  private final int b;
  
  public g()
  {
    this(Integer.MIN_VALUE, Integer.MIN_VALUE);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public final void a(h paramh)
  {
    if (!com.bumptech.glide.i.h.a(this.a, this.b)) {
      throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.a + " and height: " + this.b + ", either provide dimensions in the constructor" + " or call override()");
    }
    paramh.a(this.a, this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\g\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
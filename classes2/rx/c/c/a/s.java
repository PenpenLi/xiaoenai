package rx.c.c.a;

abstract class s<E>
  extends a<E>
{
  private static final Integer e = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
  protected final int d;
  
  public s(int paramInt)
  {
    super(paramInt);
    this.d = Math.min(paramInt / 4, e.intValue());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
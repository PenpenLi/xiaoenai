package d.a;

public class ay
{
  public static final byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    return (byte)a(paramByte, paramInt, paramBoolean);
  }
  
  public static final int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1 << paramInt2 | paramInt1;
    }
    return b(paramInt1, paramInt2);
  }
  
  public static final boolean a(byte paramByte, int paramInt)
  {
    return a(paramByte, paramInt);
  }
  
  public static final boolean a(int paramInt1, int paramInt2)
  {
    return (1 << paramInt2 & paramInt1) != 0;
  }
  
  public static final int b(int paramInt1, int paramInt2)
  {
    return (1 << paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
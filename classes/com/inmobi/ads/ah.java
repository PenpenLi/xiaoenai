package com.inmobi.ads;

import android.support.annotation.NonNull;
import java.util.Locale;

class ah
  extends NativeStrandAsset
{
  public ah(String paramString1, NativeStrandAsset.AssetType paramAssetType, t paramt, String paramString2)
  {
    super(paramString1, paramAssetType, paramt);
    this.d = paramString2;
  }
  
  public ah(String paramString1, t paramt, String paramString2)
  {
    super(paramString1, NativeStrandAsset.AssetType.ASSET_TYPE_TEXT, paramt);
    this.d = paramString2;
  }
  
  static class a
    extends t
  {
    protected int f;
    protected String g;
    protected int h;
    protected a[] i;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NonNull t.b paramb, @NonNull t.a parama, @NonNull String paramString1, @NonNull String paramString2)
    {
      this(paramInt1, paramInt2, paramInt3, paramInt4, paramb, parama, paramString1, paramString2, 12);
    }
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NonNull t.b paramb, @NonNull t.a parama, @NonNull String paramString1, @NonNull String paramString2, int paramInt5)
    {
      this(paramInt1, paramInt2, paramInt3, paramInt4, paramb, parama, paramString1, paramString2, paramInt5, "#ff000000");
    }
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NonNull t.b paramb, @NonNull t.a parama, @NonNull String paramString1, @NonNull String paramString2, int paramInt5, int paramInt6, @NonNull String paramString3, a[] paramArrayOfa)
    {
      super(paramInt2, paramInt3, paramInt4, paramb, parama, paramString1, paramString2);
      this.f = paramInt5;
      paramb = paramString3;
      if (paramString3.length() == 0) {
        paramb = "#ff000000";
      }
      this.g = paramb;
      this.h = paramInt6;
      paramInt1 = Math.min(paramArrayOfa.length, 4);
      this.i = new a[paramInt1];
      System.arraycopy(paramArrayOfa, 0, this.i, 0, paramInt1);
    }
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NonNull t.b paramb, @NonNull t.a parama, @NonNull String paramString1, @NonNull String paramString2, int paramInt5, String paramString3)
    {
      this(paramInt1, paramInt2, paramInt3, paramInt4, paramb, parama, paramString1, paramString2, paramInt5, paramString3, new a[] { a.a });
    }
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NonNull t.b paramb, @NonNull t.a parama, @NonNull String paramString1, @NonNull String paramString2, int paramInt5, String paramString3, a[] paramArrayOfa)
    {
      this(paramInt1, paramInt2, paramInt3, paramInt4, paramb, parama, paramString1, paramString2, paramInt5, Integer.MAX_VALUE, paramString3, paramArrayOfa);
    }
    
    public String g()
    {
      return this.e.toLowerCase(Locale.US);
    }
    
    public int h()
    {
      return this.f;
    }
    
    public String i()
    {
      return this.g.toLowerCase(Locale.US);
    }
    
    public int j()
    {
      return this.h;
    }
    
    public a[] k()
    {
      return this.i;
    }
    
    static enum a
    {
      private final String f;
      
      private a(String paramString)
      {
        this.f = paramString;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
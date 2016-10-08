package com.inmobi.ads;

import java.util.Iterator;
import org.json.JSONObject;

class v
  extends NativeStrandAsset
  implements Iterable<NativeStrandAsset>
{
  private long m = 0L;
  private NativeStrandAsset[] n;
  private int o;
  
  public v(String paramString, t paramt, JSONObject paramJSONObject)
  {
    this(paramString, paramt, new ai[0], paramJSONObject);
  }
  
  public v(String paramString, t paramt, ai[] paramArrayOfai, JSONObject paramJSONObject)
  {
    super(paramString, NativeStrandAsset.AssetType.ASSET_TYPE_CONTAINER, paramt, paramArrayOfai);
    this.e = paramJSONObject;
    this.n = new NativeStrandAsset[1];
    this.o = 0;
  }
  
  private void b(int paramInt)
  {
    NativeStrandAsset[] arrayOfNativeStrandAsset = new NativeStrandAsset[paramInt];
    System.arraycopy(this.n, 0, arrayOfNativeStrandAsset, 0, this.o);
    this.n = arrayOfNativeStrandAsset;
  }
  
  public NativeStrandAsset a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < n())) {
      return this.n[paramInt];
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    this.m = paramLong;
  }
  
  public boolean b(NativeStrandAsset paramNativeStrandAsset)
  {
    if (this.o < 16)
    {
      if (this.o == this.n.length) {
        b(this.n.length * 2);
      }
      NativeStrandAsset[] arrayOfNativeStrandAsset = this.n;
      int i = this.o;
      this.o = (i + 1);
      arrayOfNativeStrandAsset[i] = paramNativeStrandAsset;
      return true;
    }
    return false;
  }
  
  public Iterator<NativeStrandAsset> iterator()
  {
    return new a();
  }
  
  public long m()
  {
    return this.m;
  }
  
  public int n()
  {
    return this.o;
  }
  
  public boolean o()
  {
    return "root".equalsIgnoreCase(this.c);
  }
  
  public boolean p()
  {
    return "card_scrollable".equalsIgnoreCase(this.c);
  }
  
  private class a
    implements Iterator<NativeStrandAsset>
  {
    private int b = 0;
    
    public a() {}
    
    public NativeStrandAsset a()
    {
      NativeStrandAsset[] arrayOfNativeStrandAsset = v.b(v.this);
      int i = this.b;
      this.b = (i + 1);
      return arrayOfNativeStrandAsset[i];
    }
    
    public boolean hasNext()
    {
      return this.b < v.a(v.this);
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.inmobi.ads;

import android.support.annotation.NonNull;
import org.json.JSONObject;

class w
  extends ah
{
  public w(String paramString1, t paramt, String paramString2, NativeStrandAsset.AssetInteractionMode paramAssetInteractionMode, JSONObject paramJSONObject)
  {
    this(paramString1, paramt, paramString2, new ai[0], paramAssetInteractionMode, paramJSONObject);
  }
  
  public w(String paramString1, t paramt, String paramString2, ai[] paramArrayOfai, NativeStrandAsset.AssetInteractionMode paramAssetInteractionMode, JSONObject paramJSONObject)
  {
    super(paramString1, NativeStrandAsset.AssetType.ASSET_TYPE_CTA, paramt, paramString2);
    a(paramArrayOfai);
    this.g = true;
    if (paramJSONObject != null)
    {
      this.h = paramAssetInteractionMode;
      this.e = paramJSONObject;
    }
  }
  
  static class a
    extends ah.a
  {
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NonNull t.b paramb, @NonNull t.a parama, @NonNull String paramString1, @NonNull String paramString2, int paramInt5, String paramString3, ah.a.a[] paramArrayOfa)
    {
      super(paramInt2, paramInt3, paramInt4, paramb, parama, paramString1, paramString2);
      this.f = paramInt5;
      this.h = Integer.MAX_VALUE;
      paramb = paramString3;
      if (paramString3.length() == 0) {
        paramb = "#ff000000";
      }
      this.g = paramb;
      paramInt1 = Math.min(paramArrayOfa.length, 1);
      this.i = new ah.a.a[paramInt1];
      System.arraycopy(paramArrayOfa, 0, this.i, 0, paramInt1);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
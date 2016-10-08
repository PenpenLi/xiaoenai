package com.inmobi.ads;

import org.json.JSONObject;

class aa
  extends NativeStrandAsset
{
  public aa(String paramString1, t paramt, String paramString2, NativeStrandAsset.AssetInteractionMode paramAssetInteractionMode, JSONObject paramJSONObject)
  {
    this(paramString1, paramt, paramString2, new ai[0], paramAssetInteractionMode, paramJSONObject);
  }
  
  public aa(String paramString1, t paramt, String paramString2, ai[] paramArrayOfai, NativeStrandAsset.AssetInteractionMode paramAssetInteractionMode, JSONObject paramJSONObject)
  {
    super(paramString1, NativeStrandAsset.AssetType.ASSET_TYPE_IMAGE, paramt, paramArrayOfai);
    this.d = paramString2;
    if (paramJSONObject != null)
    {
      this.g = true;
      this.h = paramAssetInteractionMode;
      this.e = paramJSONObject;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.xiaoenai.app.classes.store.sticker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.model.RedHintsInfo;
import java.util.Vector;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="name", b="name"), @com.xiaoenai.app.annotation.json.JsonElement(a="free", b="free"), @com.xiaoenai.app.annotation.json.JsonElement(a="price", b="price"), @com.xiaoenai.app.annotation.json.JsonElement(a="vip_price", b="vip_price"), @com.xiaoenai.app.annotation.json.JsonElement(a="sort", b="sort"), @com.xiaoenai.app.annotation.json.JsonElement(a="count", b="count"), @com.xiaoenai.app.annotation.json.JsonElement(a="thumb_url", b="thumb_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="cover_url", b="cover_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="cover_bg_url", b="cover_bg_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="intro", b="intro"), @com.xiaoenai.app.annotation.json.JsonElement(a="zipUrl", b="zip_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="purchased", b="purchased"), @com.xiaoenai.app.annotation.json.JsonElement(a="count", b="count")})
public class FaceSticker
  extends BaseSticker
{
  public static final Parcelable.Creator<BaseSticker> CREATOR = new a();
  private int count;
  private RedHintsInfo redHintsInfo;
  private Vector<Sticker> stickers;
  
  public FaceSticker() {}
  
  private FaceSticker(Parcel paramParcel)
  {
    read(paramParcel);
    this.count = paramParcel.readInt();
  }
  
  public void freeJsonTransformer(String paramString)
  {
    setFree(Integer.valueOf(paramString).intValue());
  }
  
  public void fromJson(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(FaceSticker.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public RedHintsInfo getRedHintsInfo()
  {
    return this.redHintsInfo;
  }
  
  public Vector<Sticker> getStickers()
  {
    return this.stickers;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setRedHintsInfo(RedHintsInfo paramRedHintsInfo)
  {
    this.redHintsInfo = paramRedHintsInfo;
  }
  
  public void setStickers(Vector<Sticker> paramVector)
  {
    this.stickers = paramVector;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.count);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\sticker\FaceSticker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
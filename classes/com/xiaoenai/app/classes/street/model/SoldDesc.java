package com.xiaoenai.app.classes.street.model;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="Color", b="color"), @com.xiaoenai.app.annotation.json.JsonElement(a="Count", b="quantity"), @com.xiaoenai.app.annotation.json.JsonElement(a="Desc", b="quantity_desc")})
public class SoldDesc
  extends a
{
  private String mColor = "";
  private int mCount = 0;
  private String mDesc = "";
  private Spannable mSpanDesc = null;
  
  public SoldDesc() {}
  
  public SoldDesc(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(SoldDesc.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String getColor()
  {
    return this.mColor;
  }
  
  public int getCount()
  {
    return this.mCount;
  }
  
  public String getDesc()
  {
    return this.mDesc;
  }
  
  public Spannable getDescSpan()
  {
    if (this.mSpanDesc == null)
    {
      this.mSpanDesc = new SpannableString(this.mDesc);
      String str = String.valueOf(this.mCount);
      if ((!this.mDesc.contains(str)) || (this.mDesc.length() <= 0) || (this.mColor.length() <= 0)) {
        break label142;
      }
      Spannable localSpannable = this.mSpanDesc;
      ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(Color.parseColor("#" + this.mColor));
      int i = this.mDesc.indexOf(str);
      int j = this.mDesc.indexOf(str);
      localSpannable.setSpan(localForegroundColorSpan, i, str.length() + j, 33);
    }
    for (;;)
    {
      return this.mSpanDesc;
      label142:
      this.mSpanDesc.setSpan(new ForegroundColorSpan(Color.parseColor("#" + this.mColor)), 0, this.mDesc.length(), 33);
    }
  }
  
  public void setColor(String paramString)
  {
    this.mColor = paramString;
  }
  
  public void setCount(int paramInt)
  {
    this.mCount = paramInt;
  }
  
  public void setDesc(String paramString)
  {
    this.mDesc = paramString;
    if ((this.mDesc.length() > 0) && (this.mColor.length() > 0))
    {
      paramString = this.mDesc.split(String.valueOf(this.mCount));
      if ((paramString != null) && (3 == paramString.length))
      {
        Spannable localSpannable = this.mSpanDesc;
        ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(Color.parseColor("#" + this.mColor));
        int i = paramString[0].length();
        int j = paramString[0].length();
        localSpannable.setSpan(localForegroundColorSpan, i, paramString[1].length() + j, 33);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\SoldDesc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
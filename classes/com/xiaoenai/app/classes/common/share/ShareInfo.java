package com.xiaoenai.app.classes.common.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class ShareInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ShareInfo> CREATOR = new o();
  public static final String[] a = { "wxs", "wxt", "qq", "qzone", "sinawb" };
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String[] i = a;
  private int j = 1;
  private int k = 0;
  private int l = -1;
  private int m = 2;
  private int n = 0;
  
  public ShareInfo() {}
  
  public ShareInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.optString("title") != null) {
        this.b = paramJSONObject.optString("title");
      }
      if (paramJSONObject.optString("content") != null) {
        this.c = paramJSONObject.optString("content");
      }
      if (paramJSONObject.optString("short_content") != null) {
        this.e = paramJSONObject.optString("short_content");
      }
      if (paramJSONObject.optString("image_url") != null) {
        this.d = paramJSONObject.optString("image_url");
      }
      if (paramJSONObject.optString("thumb_image_url") != null) {
        this.f = paramJSONObject.optString("thumb_image_url");
      }
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.i = paramArrayOfString;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public void d(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public void e(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void e(String paramString)
  {
    this.f = paramString;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public void f(String paramString)
  {
    this.g = paramString;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public void g(String paramString)
  {
    this.h = paramString;
  }
  
  public String[] h()
  {
    return this.i;
  }
  
  public int i()
  {
    return this.j;
  }
  
  public int j()
  {
    return this.k;
  }
  
  public int k()
  {
    return this.l;
  }
  
  public int l()
  {
    return this.n;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.i.length);
    paramParcel.writeStringArray(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeInt(this.n);
    paramParcel.writeInt(this.m);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\share\ShareInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
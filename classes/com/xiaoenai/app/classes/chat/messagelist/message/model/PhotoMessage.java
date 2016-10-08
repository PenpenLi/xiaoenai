package com.xiaoenai.app.classes.chat.messagelist.message.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.n;
import com.xiaoenai.app.net.socket.e;
import com.xiaoenai.app.net.socket.f;
import com.xiaoenai.app.utils.e.b;
import org.json.JSONException;
import org.json.JSONObject;

public class PhotoMessage
  extends com.xiaoenai.app.classes.chat.messagelist.message.a.a
  implements Parcelable
{
  public static final Parcelable.Creator<PhotoMessage> CREATOR = new j();
  protected String b = null;
  protected int c = 0;
  protected int d = 0;
  protected String e = null;
  protected boolean f = false;
  protected boolean g = false;
  protected String h = null;
  private long i = 0L;
  
  public PhotoMessage()
  {
    a("image");
  }
  
  private void A()
  {
    e locale = new e(new i(this));
    locale.b("sendMessage");
    locale.a("message");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("types", b());
      localJSONObject.put("content", B());
      locale.a(localJSONObject);
      locale.b();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private String B()
  {
    if ((this.h == null) || (this.c == 0) || (this.d == 0)) {
      return null;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("url", this.h);
      ((JSONObject)localObject).put("height", this.c);
      ((JSONObject)localObject).put("width", this.d);
      ((JSONObject)localObject).put("isOriginal", this.f);
      ((JSONObject)localObject).put("originalSize", this.i);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  private void b(JSONObject paramJSONObject)
  {
    e(paramJSONObject.getString("key"));
    c(paramJSONObject.getString("url"));
    a(paramJSONObject.getInt("width"), paramJSONObject.getInt("height"));
    c(this.f);
    b.b(Xiaoenai.b(t()), w());
    if (B() != null)
    {
      k();
      com.xiaoenai.app.classes.chat.messagelist.a.l();
      A();
      return;
    }
    b(Integer.valueOf(-2));
    k();
    com.xiaoenai.app.classes.chat.messagelist.a.l();
  }
  
  private void e(boolean paramBoolean)
  {
    new n(new g(this, Xiaoenai.j(), paramBoolean)).a(w(), paramBoolean);
  }
  
  private void y()
  {
    if ((this.h == null) && (this.b != null))
    {
      if (!this.b.startsWith("http://")) {
        break label60;
      }
      String str = this.b.substring(7);
      int j = str.indexOf("/");
      if (j != -1) {
        this.h = str.substring(j + 1);
      }
    }
    return;
    label60:
    this.h = this.b;
  }
  
  private void z()
  {
    new n(new h(this, Xiaoenai.j())).b(w());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.c = paramInt2;
  }
  
  public void b(String paramString)
  {
    str = "";
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("width")) {
        this.d = paramString.getInt("width");
      }
      if (paramString.has("height")) {
        this.c = paramString.getInt("height");
      }
      if (paramString.has("url")) {
        this.b = paramString.getString("url");
      }
      if (paramString.has("imagePath")) {
        this.e = paramString.getString("imagePath");
      }
      if (paramString.has("isOriginal")) {
        this.f = paramString.getBoolean("isOriginal");
      }
      if (paramString.has("originalSize")) {
        this.i = paramString.getLong("originalSize");
      }
      paramString = paramString.toString();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = str;
      }
    }
    super.b(paramString);
  }
  
  public String c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.d != 0) {
        localJSONObject.put("width", this.d);
      }
      if (this.c != 0) {
        localJSONObject.put("height", this.c);
      }
      if (this.b != null) {
        localJSONObject.put("url", this.b);
      }
      if (this.e != null) {
        localJSONObject.put("imagePath", this.e);
      }
      localJSONObject.put("isOriginal", this.f);
      localJSONObject.put("originalSize", this.i);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject.toString();
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
    y();
  }
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void d(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public void d(boolean paramBoolean)
  {
    b(Integer.valueOf(-1));
    if (B() != null)
    {
      A();
      return;
    }
    e(paramBoolean);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(String paramString)
  {
    this.h = paramString;
  }
  
  public void j()
  {
    b(Integer.valueOf(-1));
    if (B() != null)
    {
      A();
      return;
    }
    z();
  }
  
  public long r()
  {
    return this.i;
  }
  
  public boolean s()
  {
    return this.f;
  }
  
  public String t()
  {
    return this.b;
  }
  
  public int u()
  {
    return this.d;
  }
  
  public int v()
  {
    return this.c;
  }
  
  public String w()
  {
    return this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(h());
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.h);
    if (s()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.i);
      return;
    }
  }
  
  public String x()
  {
    y();
    return this.h;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\PhotoMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
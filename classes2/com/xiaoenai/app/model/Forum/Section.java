package com.xiaoenai.app.model.Forum;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Section
  implements Parcelable
{
  public static final Parcelable.Creator<Section> CREATOR = new e();
  public int a;
  public String b;
  public int c;
  public String d;
  public int e;
  public int f;
  
  public Section() {}
  
  private Section(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
  }
  
  public Section(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getInt("id");
      this.b = paramJSONObject.getString("name");
      this.c = paramJSONObject.getInt("position");
      this.e = paramJSONObject.getInt("topics_count");
      this.f = paramJSONObject.optInt("unread_count");
      this.d = paramJSONObject.getString("url");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static List<Section> a(JSONObject paramJSONObject)
  {
    localArrayList = new ArrayList();
    if ((paramJSONObject != null) && (paramJSONObject.has("categories"))) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("categories");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          localArrayList.add(new Section(paramJSONObject.getJSONObject(i)));
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\Forum\Section.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
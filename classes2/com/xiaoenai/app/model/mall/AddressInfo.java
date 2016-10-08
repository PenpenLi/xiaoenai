package com.xiaoenai.app.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.utils.f.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddressInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AddressInfo> CREATOR = new AddressInfo.1();
  public static String MALL_ADDRESS_INFO_KEY = "mall_address_info_key";
  private String addressDetail;
  private String coupleId;
  private long createdAt;
  private String data = "";
  private int id = 0;
  private boolean isDefault;
  private String name;
  private String phoneNumber;
  private String province_city_zone;
  private int uid;
  private long updatedAt;
  
  public AddressInfo() {}
  
  protected AddressInfo(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.uid = paramParcel.readInt();
    this.coupleId = paramParcel.readString();
    this.createdAt = paramParcel.readLong();
    this.updatedAt = paramParcel.readLong();
    this.name = paramParcel.readString();
    this.phoneNumber = paramParcel.readString();
    this.addressDetail = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.isDefault = bool;
      this.province_city_zone = paramParcel.readString();
      this.data = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public AddressInfo(JSONObject paramJSONObject)
  {
    this.data = paramJSONObject.toString();
    try
    {
      a.a(paramJSONObject.toString());
      this.id = paramJSONObject.getInt("id");
      this.uid = paramJSONObject.getInt("uid");
      this.coupleId = paramJSONObject.getString("couple_id");
      this.name = paramJSONObject.getString("name");
      this.province_city_zone = paramJSONObject.getString("province_city_zone");
      this.addressDetail = paramJSONObject.getString("address");
      this.phoneNumber = paramJSONObject.getString("phone");
      this.isDefault = paramJSONObject.optBoolean("default", false);
      this.createdAt = paramJSONObject.getLong("created_at");
      this.updatedAt = paramJSONObject.getLong("updated_at");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static List<AddressInfo> getAddressInfosFromJson(JSONObject paramJSONObject, String paramString)
  {
    localArrayList = new ArrayList();
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray(paramString);
        int i = 0;
        while (i < paramJSONObject.length())
        {
          localArrayList.add(new AddressInfo(paramJSONObject.getJSONObject(i)));
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
  
  public String getAddressDetail()
  {
    return this.addressDetail;
  }
  
  public String getCoupleId()
  {
    return this.coupleId;
  }
  
  public long getCreatedAt()
  {
    return this.createdAt;
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }
  
  public String getProvince_city_zone()
  {
    return this.province_city_zone;
  }
  
  public int getUid()
  {
    return this.uid;
  }
  
  public long getUpdatedAt()
  {
    return this.updatedAt;
  }
  
  public boolean isDefault()
  {
    return this.isDefault;
  }
  
  public void setAddressDetail(String paramString)
  {
    this.addressDetail = paramString;
  }
  
  public void setCoupleId(String paramString)
  {
    this.coupleId = paramString;
  }
  
  public void setCreatedAt(long paramLong)
  {
    this.createdAt = paramLong;
  }
  
  public void setDefault(boolean paramBoolean)
  {
    this.isDefault = paramBoolean;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPhoneNumber(String paramString)
  {
    this.phoneNumber = paramString;
  }
  
  public void setProvince_city_zone(String paramString)
  {
    this.province_city_zone = paramString;
  }
  
  public void setUid(int paramInt)
  {
    this.uid = paramInt;
  }
  
  public void setUpdatedAt(long paramLong)
  {
    this.updatedAt = paramLong;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.uid);
    paramParcel.writeString(this.coupleId);
    paramParcel.writeLong(this.createdAt);
    paramParcel.writeLong(this.updatedAt);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.phoneNumber);
    paramParcel.writeString(this.addressDetail);
    if (this.isDefault) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.province_city_zone);
      paramParcel.writeString(this.data);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\mall\AddressInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
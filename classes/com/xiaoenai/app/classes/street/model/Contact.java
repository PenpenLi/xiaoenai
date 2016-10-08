package com.xiaoenai.app.classes.street.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="ProvinceCityZone", b="province_city_zone"), @com.xiaoenai.app.annotation.json.JsonElement(a="Default", b="is_default"), @com.xiaoenai.app.annotation.json.JsonElement(a="Id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="Receiver", b="receiver"), @com.xiaoenai.app.annotation.json.JsonElement(a="Address", b="address"), @com.xiaoenai.app.annotation.json.JsonElement(a="Phone", b="phone")})
public class Contact
  extends a
  implements Parcelable
{
  public static final Parcelable.Creator<Contact> CREATOR = new Contact.1();
  private String address;
  private int id;
  private int isDefault;
  private String phone;
  private String province_city_zone;
  private String receiver;
  
  public Contact() {}
  
  public Contact(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    this.id = paramInt1;
    this.receiver = paramString1;
    this.address = paramString2;
    this.phone = paramString3;
    this.province_city_zone = paramString4;
    this.isDefault = paramInt2;
  }
  
  protected Contact(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.receiver = paramParcel.readString();
    this.address = paramParcel.readString();
    this.phone = paramParcel.readString();
    this.province_city_zone = paramParcel.readString();
    this.isDefault = paramParcel.readInt();
  }
  
  public Contact(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Contact.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static ArrayList<Contact> getContactList(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        localArrayList.add(new Contact(paramJSONArray.optJSONObject(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public int getDefault()
  {
    return this.isDefault;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public String getProvinceCityZone()
  {
    return this.province_city_zone;
  }
  
  public String getReceiver()
  {
    return this.receiver;
  }
  
  public boolean isDefault()
  {
    return this.isDefault == 1;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setDefault(int paramInt)
  {
    this.isDefault = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setProvinceCityZone(String paramString)
  {
    this.province_city_zone = paramString;
  }
  
  public void setReceiver(String paramString)
  {
    this.receiver = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.receiver);
    paramParcel.writeString(this.address);
    paramParcel.writeString(this.phone);
    paramParcel.writeString(this.province_city_zone);
    paramParcel.writeInt(this.isDefault);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\Contact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.xiaoenai.app.classes.store.sticker;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaoenai.app.annotation.json.a;

public abstract class BaseSticker
  extends a
  implements Parcelable
{
  private String cover_bg_url;
  private String cover_url;
  private int free;
  private int id;
  private String intro;
  private boolean isDownload;
  private boolean isDownloading;
  private boolean isMine;
  private boolean isNew;
  private String name;
  private int price;
  private boolean purchased;
  private int sort;
  private String thumb_url;
  private int type = 1;
  private int vip_price;
  private String zipUrl;
  
  public BaseSticker() {}
  
  private BaseSticker(Parcel paramParcel)
  {
    read(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCover_bg_url()
  {
    return this.cover_bg_url;
  }
  
  public String getCover_url()
  {
    return this.cover_url;
  }
  
  public int getFree()
  {
    return this.free;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getIntro()
  {
    return this.intro;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getPrice()
  {
    return this.price;
  }
  
  public int getSort()
  {
    return this.sort;
  }
  
  public String getThumb_url()
  {
    return this.thumb_url;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int getVip_price()
  {
    return this.vip_price;
  }
  
  public String getZipUrl()
  {
    return this.zipUrl;
  }
  
  public boolean isDownload()
  {
    return this.isDownload;
  }
  
  public boolean isDownloading()
  {
    return this.isDownloading;
  }
  
  public boolean isMine()
  {
    return this.isMine;
  }
  
  public boolean isNew()
  {
    return this.isNew;
  }
  
  public boolean isPurchased()
  {
    return this.purchased;
  }
  
  public String isValid(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public void read(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.id = paramParcel.readInt();
    this.type = paramParcel.readInt();
    this.free = paramParcel.readInt();
    this.sort = paramParcel.readInt();
    this.price = paramParcel.readInt();
    this.vip_price = paramParcel.readInt();
    this.name = paramParcel.readString();
    this.thumb_url = paramParcel.readString();
    this.cover_url = paramParcel.readString();
    this.cover_bg_url = paramParcel.readString();
    this.intro = paramParcel.readString();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.purchased = bool1;
      if (paramParcel.readByte() != 1) {
        break label179;
      }
      bool1 = true;
      label115:
      this.isNew = bool1;
      if (paramParcel.readByte() != 1) {
        break label184;
      }
      bool1 = true;
      label130:
      this.isDownload = bool1;
      this.zipUrl = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label189;
      }
      bool1 = true;
      label153:
      this.isDownloading = bool1;
      if (paramParcel.readByte() != 1) {
        break label194;
      }
    }
    label179:
    label184:
    label189:
    label194:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isMine = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label115;
      bool1 = false;
      break label130;
      bool1 = false;
      break label153;
    }
  }
  
  public void setCover_bg_url(String paramString)
  {
    this.cover_bg_url = paramString;
  }
  
  public void setCover_url(String paramString)
  {
    this.cover_url = paramString;
  }
  
  public void setDownload(boolean paramBoolean)
  {
    this.isDownload = paramBoolean;
  }
  
  public void setDownloading(boolean paramBoolean)
  {
    this.isDownloading = paramBoolean;
  }
  
  public void setFree(int paramInt)
  {
    this.free = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIntro(String paramString)
  {
    this.intro = paramString;
  }
  
  public void setMine(boolean paramBoolean)
  {
    this.isMine = paramBoolean;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNew(boolean paramBoolean)
  {
    this.isNew = paramBoolean;
  }
  
  public void setPrice(int paramInt)
  {
    this.price = paramInt;
  }
  
  public void setPurchased(boolean paramBoolean)
  {
    this.purchased = paramBoolean;
  }
  
  public void setSort(int paramInt)
  {
    this.sort = paramInt;
  }
  
  public void setThumb_url(String paramString)
  {
    this.thumb_url = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setVip_price(int paramInt)
  {
    this.vip_price = paramInt;
  }
  
  public void setZipUrl(String paramString)
  {
    this.zipUrl = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.free);
    paramParcel.writeInt(this.sort);
    paramParcel.writeInt(this.price);
    paramParcel.writeInt(this.vip_price);
    paramParcel.writeString(isValid(this.name));
    paramParcel.writeString(isValid(this.thumb_url));
    paramParcel.writeString(isValid(this.cover_url));
    paramParcel.writeString(isValid(this.cover_bg_url));
    paramParcel.writeString(isValid(this.intro));
    if (this.purchased)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.isNew) {
        break label199;
      }
      paramInt = 1;
      label134:
      paramParcel.writeByte((byte)paramInt);
      if (!this.isDownload) {
        break label204;
      }
      paramInt = 1;
      label149:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.zipUrl);
      if (!this.isDownloading) {
        break label209;
      }
      paramInt = 1;
      label172:
      paramParcel.writeByte((byte)paramInt);
      if (!this.isMine) {
        break label214;
      }
    }
    label199:
    label204:
    label209:
    label214:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label134;
      paramInt = 0;
      break label149;
      paramInt = 0;
      break label172;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\sticker\BaseSticker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
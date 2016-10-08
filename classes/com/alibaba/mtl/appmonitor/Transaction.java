package com.alibaba.mtl.appmonitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import java.util.UUID;

public class Transaction
  implements Parcelable
{
  public static final Parcelable.Creator<Transaction> CREATOR = new Transaction.1();
  protected Integer a;
  protected DimensionValueSet b;
  private Object lock;
  protected String o;
  protected String p;
  protected String r;
  
  public Transaction() {}
  
  Transaction(Integer paramInteger, String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet)
  {
    this.a = paramInteger;
    this.o = paramString1;
    this.p = paramString2;
    this.r = UUID.randomUUID().toString();
    this.b = paramDimensionValueSet;
    this.lock = new Object();
  }
  
  static Transaction a(Parcel paramParcel)
  {
    Transaction localTransaction = new Transaction();
    try
    {
      localTransaction.b = ((DimensionValueSet)paramParcel.readParcelable(Transaction.class.getClassLoader()));
      localTransaction.a = Integer.valueOf(paramParcel.readInt());
      localTransaction.o = paramParcel.readString();
      localTransaction.p = paramParcel.readString();
      localTransaction.r = paramParcel.readString();
      return localTransaction;
    }
    catch (Throwable paramParcel)
    {
      paramParcel.printStackTrace();
    }
    return localTransaction;
  }
  
  public void addDimensionValues(DimensionValueSet paramDimensionValueSet)
  {
    synchronized (this.lock)
    {
      if (this.b == null)
      {
        this.b = paramDimensionValueSet;
        return;
      }
      this.b.addValues(paramDimensionValueSet);
    }
  }
  
  public void addDimensionValues(String paramString1, String paramString2)
  {
    synchronized (this.lock)
    {
      if (this.b == null) {
        this.b = ((DimensionValueSet)a.a().a(DimensionValueSet.class, new Object[0]));
      }
      this.b.setValue(paramString1, paramString2);
      return;
    }
  }
  
  public void begin(String paramString)
  {
    if (AppMonitor.a == null) {
      return;
    }
    try
    {
      AppMonitor.a.transaction_begin(this, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void end(String paramString)
  {
    if (AppMonitor.a == null) {
      return;
    }
    try
    {
      AppMonitor.a.transaction_end(this, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeInt(this.a.intValue());
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.r);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\Transaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
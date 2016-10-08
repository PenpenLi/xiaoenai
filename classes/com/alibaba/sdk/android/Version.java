package com.alibaba.sdk.android;

public class Version
{
  private int major;
  private int micro;
  private int minor;
  
  public Version(int paramInt1, int paramInt2, int paramInt3)
  {
    this.major = paramInt1;
    this.minor = paramInt2;
    this.micro = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (Version)paramObject;
      if (this.major != ((Version)paramObject).major) {
        return false;
      }
      if (this.micro != ((Version)paramObject).micro) {
        return false;
      }
    } while (this.minor == ((Version)paramObject).minor);
    return false;
  }
  
  public int getMajor()
  {
    return this.major;
  }
  
  public int getMicro()
  {
    return this.micro;
  }
  
  public int getMinor()
  {
    return this.minor;
  }
  
  public int hashCode()
  {
    return ((this.major + 31) * 31 + this.micro) * 31 + this.minor;
  }
  
  void setVersion(String paramString)
  {
    if (paramString == null) {
      throw new IllegalStateException("null version");
    }
    String[] arrayOfString = paramString.split("[.]");
    if (arrayOfString.length != 3) {
      throw new IllegalArgumentException(paramString + " is not a valid version");
    }
    this.major = Integer.parseInt(arrayOfString[0]);
    this.minor = Integer.parseInt(arrayOfString[1]);
    int i = arrayOfString[2].indexOf("-");
    if (i != -1)
    {
      this.micro = Integer.parseInt(arrayOfString[2].substring(0, i));
      return;
    }
    this.micro = Integer.parseInt(arrayOfString[2]);
  }
  
  public String toString()
  {
    return this.major + "." + this.minor + "." + this.micro;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
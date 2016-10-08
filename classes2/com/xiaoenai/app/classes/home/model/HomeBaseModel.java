package com.xiaoenai.app.classes.home.model;

public class HomeBaseModel
{
  private boolean isShowRed;
  private String mRedString;
  private int mResId;
  private int mStringId;
  
  public HomeBaseModel(int paramInt1, int paramInt2)
  {
    this.mResId = paramInt1;
    this.mStringId = paramInt2;
  }
  
  public String getRedString()
  {
    return this.mRedString;
  }
  
  public int getResId()
  {
    return this.mResId;
  }
  
  public int getStringId()
  {
    return this.mStringId;
  }
  
  public boolean isShow()
  {
    return this.isShowRed;
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.isShowRed = paramBoolean;
  }
  
  public void setRedString(String paramString)
  {
    this.mRedString = paramString;
  }
  
  public void setResId(int paramInt)
  {
    this.mResId = paramInt;
  }
  
  public void setStringId(int paramInt)
  {
    this.mStringId = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\model\HomeBaseModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
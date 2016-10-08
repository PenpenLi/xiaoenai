package com.xiaoenai.app.classes.street.model;

public class SceneTextType
{
  public static final int SCENE_TEXT_TYPE_NOMORE = 0;
  public static final int SCENE_TEXT_TYPE_SPECIAL = 1;
  public static final int SCENE_TEXT_TYPE_SPECIAL_TODAY = 2;
  private String text;
  private int type;
  
  public SceneTextType(String paramString, int paramInt)
  {
    this.text = paramString;
    this.type = paramInt;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\model\SceneTextType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.xiaoenai.app.classes.home.model;

import com.google.gson.j;
import com.xiaoenai.app.utils.ae;
import java.util.List;

public class HomeLifeServiceItem
  extends HomeDiscoverBaseItem
{
  private List<HomeDiscoverItem> mLifeServiceItemList;
  
  public List<HomeDiscoverItem> getmLifeServiceItemList()
  {
    return this.mLifeServiceItemList;
  }
  
  public void setmLifeServiceItemList(String paramString)
  {
    if (!ae.a(paramString)) {
      this.mLifeServiceItemList = ((List)new j().a(paramString, new HomeLifeServiceItem.1(this).getType()));
    }
  }
  
  public void setmLifeServiceItemList(List<HomeDiscoverItem> paramList)
  {
    this.mLifeServiceItemList = paramList;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\model\HomeLifeServiceItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
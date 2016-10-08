package com.xiaoenai.app.classes.forum;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class w<T extends ForumMineActivity>
  implements Unbinder
{
  protected T a;
  
  public w(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.myInfoLayout = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558636, "field 'myInfoLayout'", RelativeLayout.class));
    paramT.myTopicLayout = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558642, "field 'myTopicLayout'", RelativeLayout.class));
    paramT.myFollowedLayout = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558646, "field 'myFollowedLayout'", RelativeLayout.class));
    paramT.showoffLayout = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558650, "field 'showoffLayout'", RelativeLayout.class));
    paramT.ruleLayout = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558654, "field 'ruleLayout'", RelativeLayout.class));
    paramT.nightThemeLayout = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558658, "field 'nightThemeLayout'", RelativeLayout.class));
    paramT.nightThemeToggleBtn = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558660, "field 'nightThemeToggleBtn'", ImageView.class));
    paramT.wifiLoadedFlagLayout = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558662, "field 'wifiLoadedFlagLayout'", RelativeLayout.class));
    paramT.wifiLoadedFlagToggleBtn = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558664, "field 'wifiLoadedFlagToggleBtn'", ImageView.class));
    paramT.avatarImg = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558638, "field 'avatarImg'", ImageView.class));
    paramT.nickNameTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131558639, "field 'nickNameTxt'", TextView.class));
    paramT.arrow1 = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558641, "field 'arrow1'", ImageView.class));
    paramT.sexImg = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558640, "field 'sexImg'", ImageView.class));
    paramT.wifiNotifyImg = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558665, "field 'wifiNotifyImg'", ImageView.class));
    paramT.loadedFlagTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131558666, "field 'loadedFlagTxt'", TextView.class));
  }
  
  public void unbind()
  {
    ForumMineActivity localForumMineActivity = this.a;
    if (localForumMineActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localForumMineActivity.myInfoLayout = null;
    localForumMineActivity.myTopicLayout = null;
    localForumMineActivity.myFollowedLayout = null;
    localForumMineActivity.showoffLayout = null;
    localForumMineActivity.ruleLayout = null;
    localForumMineActivity.nightThemeLayout = null;
    localForumMineActivity.nightThemeToggleBtn = null;
    localForumMineActivity.wifiLoadedFlagLayout = null;
    localForumMineActivity.wifiLoadedFlagToggleBtn = null;
    localForumMineActivity.avatarImg = null;
    localForumMineActivity.nickNameTxt = null;
    localForumMineActivity.arrow1 = null;
    localForumMineActivity.sexImg = null;
    localForumMineActivity.wifiNotifyImg = null;
    localForumMineActivity.loadedFlagTxt = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
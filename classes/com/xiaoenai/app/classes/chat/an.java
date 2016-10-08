package com.xiaoenai.app.classes.chat;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaoenai.app.model.UserConfig;

public class an
  extends Fragment
{
  private LinearLayout a;
  private boolean b = false;
  
  private void a(View paramView)
  {
    this.a = ((LinearLayout)paramView.findViewById(2131558824));
    this.a.setOnClickListener(new ao(this));
    paramView.findViewById(2131558863).setOnClickListener(new ap(this));
    paramView.findViewById(2131558866).setOnClickListener(new aq(this));
    paramView.findViewById(2131558869).setOnClickListener(new ar(this));
    if (UserConfig.getInt("chat_title_color", Integer.valueOf(-1864528)).intValue() == -1864528) {}
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    return paramLayoutInflater.inflate(2130903119, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
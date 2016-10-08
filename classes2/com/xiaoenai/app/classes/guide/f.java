package com.xiaoenai.app.classes.guide;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.sina.weibo.SinaWeibo.ShareParams;
import com.xiaoenai.app.utils.e.b;
import org.json.JSONObject;

public class f
  extends Fragment
{
  private int a;
  private boolean b = true;
  private JSONObject c;
  
  private void a(View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131558738);
    switch (this.a)
    {
    default: 
      return;
    case 0: 
      localImageView.setImageResource(2130838494);
      return;
    case 1: 
      localImageView.setImageResource(2130838495);
      return;
    case 2: 
      localImageView.setImageResource(2130838496);
      return;
    }
    localImageView.setImageResource(2130838497);
    b(paramView);
  }
  
  private void a(Platform paramPlatform)
  {
    SinaWeibo.ShareParams localShareParams = new SinaWeibo.ShareParams();
    try
    {
      localShareParams.text = this.c.getString("content");
      localShareParams.imagePath = b.a(this.c.getString("image_url"));
      paramPlatform.share(localShareParams);
      return;
    }
    catch (Exception paramPlatform)
    {
      paramPlatform.printStackTrace();
    }
  }
  
  private void b()
  {
    this.c = ((NewVersionIntroActivity)getActivity()).a;
    if (this.c == null) {}
    Platform localPlatform;
    do
    {
      return;
      localPlatform = ShareSDK.getPlatform(getActivity(), SinaWeibo.NAME);
    } while ((localPlatform == null) || (!localPlatform.isValid()));
    localPlatform.followFriend("小恩爱");
    a(localPlatform);
  }
  
  private void b(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131559365);
    localTextView.setVisibility(0);
    paramView.setOnClickListener(new g(this));
    localTextView.setOnClickListener(new h(this, localTextView));
  }
  
  public void a()
  {
    if (this.b) {
      new Handler().post(new i(this));
    }
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903230, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\guide\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
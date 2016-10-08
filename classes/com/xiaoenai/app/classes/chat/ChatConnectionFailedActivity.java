package com.xiaoenai.app.classes.chat;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.TitleBarActivity;

public class ChatConnectionFailedActivity
  extends TitleBarActivity
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView i;
  
  private void c()
  {
    this.i.setText(Html.fromHtml("<b>若亲使用的是Wi-Fi网络，可参考以下方法：</b>"));
    this.c.setText(Html.fromHtml("<b>若亲使用的是移动网络，可参考以下方法：</b>"));
    this.a.setText(Html.fromHtml("1.切换至另一个可用的Wi-Fi网络；<br>2.尝试关闭 Wi-Fi，切换至移动网络。需前往手机设备的<font color=’#1b1a1a’><b>「设置」</b></font>，选择开启<font color=‘#1b1a1a’><b>「移动网络」</b></font>(不同手机设置方式可能不同)；<br>3.尝试结束小恩爱后台进程，重新启动应用；<br>4.以上方法都无效时，请亲通过 <font color=’＃1b1a1a’><b>「我」-「设置」-「意见反馈」</b></font>和我们联系。"));
    this.b.setText(Html.fromHtml("1.尝试连接至一个可用的Wi-Fi网络；<br>2.前往手机设备的<font color=’＃1b1a1a’><b>「设置」</b></font>，选择开启<font color=’＃1b1a1a’><b>「移动网络」</b></font>(不同手机设置方式可能不同)；<br>3.开启系统 <font color=’＃1b1a1a’><b>「飞行模式」</b></font>之后再关闭<font color=’＃1b1a1a’><b>「飞行模式」</b></font>；<br>4.尝试结束小恩爱后台进程，重新启动应用；<br>5.以上方法都无效时，请亲通过 <font color=’＃1b1a1a’><b>「我」-「设置」-「意见反馈」</b></font>和我们联系。"));
  }
  
  private void d()
  {
    this.a = ((TextView)findViewById(2131558617));
    this.b = ((TextView)findViewById(2131558619));
    this.c = ((TextView)findViewById(2131558618));
    this.i = ((TextView)findViewById(2131558616));
  }
  
  public int a()
  {
    return 2130903065;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d();
    c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\ChatConnectionFailedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
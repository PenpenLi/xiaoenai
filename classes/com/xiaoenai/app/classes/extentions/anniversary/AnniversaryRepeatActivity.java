package com.xiaoenai.app.classes.extentions.anniversary;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.xiaoenai.app.classes.common.TitleBarActivity;

public class AnniversaryRepeatActivity
  extends TitleBarActivity
{
  private int a = 0;
  
  private void a(int paramInt)
  {
    int i = 0;
    if (i < 4)
    {
      Object localObject = "repeatSelectView" + i;
      localObject = (ImageView)findViewById(getResources().getIdentifier((String)localObject, "id", "com.xiaoenai.app"));
      if (paramInt == i)
      {
        ((ImageView)localObject).setImageResource(2130838829);
        ((ImageView)localObject).setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ImageView)localObject).setVisibility(8);
      }
    }
  }
  
  private void c()
  {
    int i = 0;
    while (i < 4)
    {
      Object localObject = "repeatItem" + i;
      localObject = findViewById(getResources().getIdentifier((String)localObject, "id", "com.xiaoenai.app"));
      ((View)localObject).setTag(Integer.valueOf(i));
      ((View)localObject).setOnClickListener(new ak(this));
      i += 1;
    }
  }
  
  public int a()
  {
    return 2130903169;
  }
  
  public void a_(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("repeat", this.a);
    setResult(-1, localIntent);
    super.a_(paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = 2;
    this.a = getIntent().getIntExtra("repeat", 0);
    c();
    a(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\AnniversaryRepeatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
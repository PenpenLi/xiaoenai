package com.xiaoenai.app.classes.common;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaoenai.app.model.UserConfig;

public class ColorPickerActivity
  extends TitleBarActivity
{
  private int[] a = { -1864528, -16746279, -13684686, -4892189, -16399699, -1888220, -13738361, -33368, -2504799 };
  private boolean b = false;
  private String c = null;
  
  private void a(int paramInt)
  {
    UserConfig.setInt("chat_title_color", this.a[paramInt]);
    UserConfig.setInt("chat_title_color_index", paramInt);
  }
  
  private void a(int[] paramArrayOfInt)
  {
    int i = 1;
    while (i < 10)
    {
      Object localObject = "colorView" + i;
      localObject = findViewById(getResources().getIdentifier((String)localObject, "id", "com.xiaoenai.app"));
      ((View)localObject).setTag(Integer.valueOf(i - 1));
      ((View)localObject).setOnClickListener(new d(this));
      localObject = "color" + i;
      findViewById(getResources().getIdentifier((String)localObject, "id", "com.xiaoenai.app")).setBackgroundColor(paramArrayOfInt[(i - 1)]);
      i += 1;
    }
    findViewById(2131558670).setOnClickListener(new e(this));
  }
  
  private void c(int paramInt)
  {
    int i = 1;
    if (i < 10)
    {
      Object localObject = "selectedView" + i;
      localObject = (ImageView)findViewById(getResources().getIdentifier((String)localObject, "id", "com.xiaoenai.app"));
      if (paramInt == i)
      {
        ((ImageView)localObject).setImageResource(2130839086);
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
  
  public int a()
  {
    return 2130903237;
  }
  
  public void a_(int paramInt)
  {
    if (this.b) {
      setResult(-1);
    }
    for (;;)
    {
      super.a_(paramInt);
      return;
      setResult(0);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = getIntent().getStringExtra("mode");
    this.f = 0;
    paramBundle = (TextView)findViewById(2131558923);
    if ((this.c == null) || (this.c.equals("home"))) {
      paramBundle.setText(2131100083);
    }
    for (;;)
    {
      return;
      if (this.c.equals("chat"))
      {
        paramBundle.setText(2131100084);
        a(this.a);
        int j = UserConfig.getInt("chat_title_color", Integer.valueOf(-1864528)).intValue();
        int i = 0;
        while (i < this.a.length)
        {
          if (j == this.a[i])
          {
            c(i + 1);
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\ColorPickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
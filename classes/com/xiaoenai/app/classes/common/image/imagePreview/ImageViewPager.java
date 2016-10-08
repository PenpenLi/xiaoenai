package com.xiaoenai.app.classes.common.image.imagePreview;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.domain.e.d;
import com.xiaoenai.app.g.a.a.a.b;
import com.xiaoenai.app.g.a.a.a.b.a;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.TitleBarView;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageViewPager
  extends TitleBarActivity
{
  @Inject
  protected d a;
  private ImageViewPagerWidget b;
  private int c;
  private int i;
  private RelativeLayout j;
  private Button k;
  private LinearLayout l;
  private TextView m;
  private TextView n;
  private ImageButton o;
  private ImageButton s;
  private RelativeLayout t;
  private Button u;
  private m v;
  private boolean w = true;
  private int x;
  private LinearLayout y = null;
  private com.xiaoenai.app.g.a.a.a.a z;
  
  private void a(int paramInt)
  {
    int i1 = 0;
    if (i1 < this.y.getChildCount())
    {
      if (paramInt == i1) {
        this.y.getChildAt(i1).setSelected(true);
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.y.getChildAt(i1).setSelected(false);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.b.setOnPageChangeListener(new au(this));
    int i1 = getIntent().getIntExtra("position", 0);
    int i2 = getIntent().getIntExtra("max_selected_size", -1);
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      i();
      this.v = new t(getIntent().getParcelableArrayListExtra("photo_data"), this, this.b, paramInt1);
      this.g.a(getResources().getDrawable(2130839000), null);
      this.g.setVisibility(8);
    }
    for (;;)
    {
      this.b.setAdapter(this.v);
      this.g.setTitle(i1 + 1 + " / " + this.v.getCount());
      this.b.setCurrentItem(i1);
      this.b.setPageMargin(ab.a(60.0F));
      this.b.setOffscreenPageLimit(1);
      paramInt1 = 0;
      Object localObject1;
      Object localObject2;
      while (paramInt1 < this.v.getCount())
      {
        localObject1 = new ImageView(this);
        localObject2 = new LinearLayout.LayoutParams(ab.a(4.0F), ab.a(4.0F));
        ((LinearLayout.LayoutParams)localObject2).leftMargin = ab.a(4.0F);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = ab.a(4.0F);
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ImageView)localObject1).setImageResource(2130837787);
        ((ImageView)localObject1).setSelected(false);
        this.y.addView((View)localObject1);
        paramInt1 += 1;
      }
      if ((paramInt1 == 3) || (paramInt1 == 4))
      {
        localObject1 = getIntent().getStringArrayExtra("imageUrls");
        localObject2 = getIntent().getIntArrayExtra("image_select_map");
        boolean bool = getIntent().getBooleanExtra("image_origin_flag", false);
        int[] arrayOfInt = getIntent().getIntArrayExtra("image_index_list");
        h();
        this.v = new ak(this, (String[])localObject1, (int[])localObject2, bool, arrayOfInt, this.k, this.b, this.l, this.m, paramInt2, this.g, i1, i2, this.x);
        if (!this.w) {
          this.l.setVisibility(8);
        }
      }
      else if (paramInt1 == 6)
      {
        i();
        this.t.setVisibility(0);
        this.v = new a(this, this.n, this.o, this.s, this.u, this.g, this.b, i1);
      }
      else if (paramInt1 == 7)
      {
        localObject1 = getIntent().getStringArrayExtra("imageUrls");
        i();
        this.g.b(getResources().getDrawable(2130839005), null);
        this.v = new z(this, this.g, (String[])localObject1, this.b);
      }
      else if (paramInt1 == 8)
      {
        localObject1 = getIntent().getStringArrayExtra("imageUrls");
        i();
        this.v = new z(this, this.g, (String[])localObject1, this.b, true);
        this.g.setVisibility(8);
        this.y.setVisibility(0);
      }
      else if (paramInt1 == 9)
      {
        localObject1 = getIntent().getStringArrayExtra("imageUrls");
        i();
        this.g.setVisibility(8);
        this.v = new z(this, this.g, (String[])localObject1, this.b, true);
      }
      else if (paramInt1 == 10)
      {
        localObject1 = getIntent().getStringArrayExtra("imageUrls");
        i();
        this.v = new z(this, this.g, (String[])localObject1, this.b, true);
        this.g.setVisibility(8);
        this.y.setVisibility(0);
      }
    }
    a(i1);
  }
  
  private void f()
  {
    this.b = ((ImageViewPagerWidget)findViewById(2131558719));
    this.j = ((RelativeLayout)findViewById(2131558724));
    this.k = ((Button)findViewById(2131558980));
    this.l = ((LinearLayout)findViewById(2131558977));
    this.m = ((TextView)findViewById(2131558979));
    this.t = ((RelativeLayout)findViewById(2131558981));
    this.n = ((TextView)findViewById(2131558879));
    this.o = ((ImageButton)findViewById(2131558983));
    this.s = ((ImageButton)findViewById(2131558984));
    this.u = ((Button)findViewById(2131558982));
    this.c = getIntent().getIntExtra("from", 0);
    this.i = getIntent().getIntExtra("from_text", 0);
    this.w = getIntent().getBooleanExtra("original_flag", true);
    this.x = getIntent().getIntExtra("image_picker_mode", -1);
    this.y = ((LinearLayout)findViewById(2131558785));
    a(this.c, this.i);
  }
  
  private int g()
  {
    int i1 = 0;
    while (i1 < this.y.getChildCount())
    {
      if (this.y.getChildAt(i1).isSelected()) {
        return i1;
      }
      i1 += 1;
    }
    return 0;
  }
  
  private void h()
  {
    this.j.setVisibility(0);
    this.k.setVisibility(0);
    this.l.setVisibility(0);
  }
  
  private void i()
  {
    this.j.setVisibility(8);
    this.k.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  public int a()
  {
    return 2130903148;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1 = 0;
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    a(null, false);
    try
    {
      localJSONObject.put("height", paramInt2);
      paramInt2 = i1;
      if (paramBoolean) {
        paramInt2 = 1;
      }
      localJSONObject.put("is_origin", paramInt2);
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("url", paramString);
      localJSONObject.put("fsize", 0);
      localJSONArray.put(localJSONObject);
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    rx.a.a(new as(this, localJSONArray)).a(new ar(this));
  }
  
  public void c()
  {
    this.g.setVisibility(8);
    if (this.c == 6)
    {
      this.t.setVisibility(8);
      return;
    }
    this.j.setVisibility(8);
  }
  
  public void d()
  {
    this.g.setVisibility(0);
    if (this.c == 6)
    {
      this.t.setVisibility(0);
      return;
    }
    this.j.setVisibility(0);
  }
  
  protected void l()
  {
    super.l();
    this.z = b.a().a(A()).a(z()).a(new com.xiaoenai.app.feature.photoalbum.d.a.b.a()).a();
    this.z.a(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = false;
    f();
  }
  
  public void r()
  {
    if ((this.c == 1) || (this.c == 9))
    {
      finish();
      overridePendingTransition(2130968586, 2130968587);
    }
    do
    {
      return;
      if (this.c == 8)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("position", g());
        setResult(-1, localIntent);
        finish();
        overridePendingTransition(2130968586, 2130968587);
      }
    } while (this.v.a("merge_action"));
    super.r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\ImageViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
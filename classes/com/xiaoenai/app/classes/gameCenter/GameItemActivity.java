package com.xiaoenai.app.classes.gameCenter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.gameCenter.model.GameInfoEntry;
import com.xiaoenai.app.classes.gameCenter.view.HorizontalListView;
import com.xiaoenai.app.classes.street.model.ImageInfo;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.l;
import com.xiaoenai.app.widget.TitleBarView;
import org.json.JSONException;
import org.json.JSONObject;

public class GameItemActivity
  extends TitleBarActivity
{
  private LinearLayout a = null;
  private ImageView b;
  private TextView c;
  private TextView i;
  private Button j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private a s;
  private HorizontalListView t;
  private GameInfoEntry u = null;
  private String v = null;
  private ProgressView w = null;
  private View.OnClickListener x = null;
  
  private void a(JSONObject paramJSONObject)
  {
    paramJSONObject = l.g(paramJSONObject.toString());
    this.u = paramJSONObject;
    this.c.setText(paramJSONObject.getName());
    this.i.setText(paramJSONObject.getApp_type() + "   " + paramJSONObject.getApp_size());
    if (paramJSONObject.getIcon_url() != null)
    {
      int i1 = ab.a(51.0F);
      com.xiaoenai.app.utils.e.b.b(this.b, paramJSONObject.getIcon_url() + "?imageView/1/w/" + i1 + "/h/" + i1, ab.b(13.0F));
    }
    this.k.setText(paramJSONObject.getDesc());
    this.l.setText(paramJSONObject.getApp_developer());
    this.m.setText(paramJSONObject.getApp_size());
    this.n.setText(paramJSONObject.getApp_version());
    this.o.setText(ak.d(paramJSONObject.getLast_modify_at()));
    this.s.a(paramJSONObject.getDesc_icon_url());
    paramJSONObject = as.f(this, this.u.getPackageName());
    if (paramJSONObject != null)
    {
      if (this.u.getApp_version().equals(paramJSONObject.versionName)) {
        this.j.setText(2131100521);
      }
      for (;;)
      {
        this.j.setBackgroundResource(2130838489);
        this.j.setTextColor(getResources().getColor(2131493206));
        return;
        this.j.setText(2131100523);
      }
    }
    this.j.setText(2131100512);
    this.j.setBackgroundResource(2130839084);
    this.j.setTextColor(getResources().getColor(2131493073));
  }
  
  private void b(String paramString)
  {
    new k(this).a(String.format(getResources().getString(2131100524), new Object[] { paramString }), 2131099973, new g(this), 2131101308, new h(this));
  }
  
  private int c()
  {
    int i2 = -1;
    Intent localIntent = getIntent();
    int i1 = i2;
    Object localObject;
    if (localIntent != null)
    {
      localObject = localIntent.getStringExtra("param");
      if (ae.a((String)localObject)) {
        break label120;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        i1 = i2;
        if (localObject != null)
        {
          i1 = i2;
          if (((JSONObject)localObject).has("game_id"))
          {
            String str = ((JSONObject)localObject).optString("game_id");
            if (ae.a(str)) {
              continue;
            }
            i1 = Integer.parseInt(str);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        i1 = i2;
        continue;
      }
      this.v = localIntent.getStringExtra("from");
      return i1;
      i1 = ((JSONObject)localObject).optInt("game_id");
      continue;
      label120:
      i1 = localIntent.getIntExtra("game_id", -1);
    }
  }
  
  private void d()
  {
    this.a = ((LinearLayout)findViewById(2131558633));
    this.b = ((ImageView)findViewById(2131559348));
    this.c = ((TextView)findViewById(2131559350));
    this.i = ((TextView)findViewById(2131559351));
    this.j = ((Button)findViewById(2131559349));
    this.k = ((TextView)findViewById(2131559354));
    this.l = ((TextView)findViewById(2131559360));
    this.m = ((TextView)findViewById(2131559362));
    this.n = ((TextView)findViewById(2131559361));
    this.o = ((TextView)findViewById(2131559363));
    this.w = ((ProgressView)findViewById(2131558669));
    this.t = ((HorizontalListView)findViewById(2131559352));
    this.s = new a(null, this, this.t);
    this.t.setAdapter(this.s);
    this.j.setOnClickListener(new d(this));
    this.t.setOnItemClickListener(new e(this));
  }
  
  private void f()
  {
    if ((this.v != null) && (this.v.length() > 0))
    {
      if (this.v.equals("notification")) {
        this.g.a(2130839000, 2131100897);
      }
    }
    else {
      return;
    }
    if (this.v.equals("push"))
    {
      this.g.a(2130839000, 0);
      return;
    }
    if (this.v.equals("discovery"))
    {
      this.g.a(2130839000, 2131100545);
      return;
    }
    this.g.a(getResources().getDrawable(2130839000), this.v);
  }
  
  public int a()
  {
    return 2130903228;
  }
  
  protected void b()
  {
    super.b();
    this.g.setLeftButtonClickListener(new f(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i1 = c();
    this.f = 2;
    d();
    f();
    paramBundle = new com.xiaoenai.app.net.b(new c(this, this));
    if (i1 != -1) {
      paramBundle.a(i1);
    }
  }
  
  protected void onResume()
  {
    if (getRequestedOrientation() != 1) {
      setRequestedOrientation(1);
    }
    super.onResume();
    if (this.u != null)
    {
      PackageInfo localPackageInfo = as.f(this, this.u.getPackageName());
      if (localPackageInfo == null) {
        break label104;
      }
      if (!this.u.getApp_version().equals(localPackageInfo.versionName)) {
        break label92;
      }
      this.j.setText(2131100521);
    }
    for (;;)
    {
      this.j.setBackgroundResource(2130838489);
      this.j.setTextColor(getResources().getColor(2131493206));
      return;
      label92:
      this.j.setText(2131100523);
    }
    label104:
    this.j.setText(2131100512);
    this.j.setBackgroundResource(2130839084);
    this.j.setTextColor(getResources().getColor(2131493073));
  }
  
  class a
    extends BaseAdapter
  {
    private ImageInfo[] b;
    private Context c;
    private HorizontalListView d;
    private int e = 0;
    private int f = 0;
    
    a(ImageInfo[] paramArrayOfImageInfo, Context paramContext, HorizontalListView paramHorizontalListView)
    {
      this.b = paramArrayOfImageInfo;
      this.c = paramContext;
      this.d = paramHorizontalListView;
      this.f = ab.a(181.0F);
      this.e = ab.a(272.0F);
    }
    
    public void a(ImageInfo[] paramArrayOfImageInfo)
    {
      this.b = paramArrayOfImageInfo;
      if ((paramArrayOfImageInfo != null) && (paramArrayOfImageInfo.length > 0))
      {
        if ((this.b[0].getWidth() > 0) && (this.b[0].getHeight() > 0)) {
          this.e = (this.f * this.b[0].getHeight() / this.b[0].getWidth());
        }
        this.d.getLayoutParams().height = this.e;
      }
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      if (this.b != null) {
        return this.b.length;
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((this.b != null) && (paramInt < getCount())) {
        return this.b[paramInt];
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramInt >= getCount()) {
        paramView = null;
      }
      ImageView localImageView;
      do
      {
        do
        {
          do
          {
            return paramView;
            paramViewGroup = new LinearLayout(this.c);
            localImageView = new ImageView(this.c);
            paramViewGroup.setTag(2131558426, Integer.valueOf(paramInt));
            paramViewGroup.setTag(2131558427, this.b);
            localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ((LinearLayout)paramViewGroup).addView(localImageView);
            paramView = paramViewGroup;
          } while (this.b == null);
          paramView = paramViewGroup;
        } while (this.b.length <= paramInt);
        paramView = paramViewGroup;
      } while (this.b[paramInt] == null);
      paramView = new LinearLayout.LayoutParams(this.f, this.e);
      localImageView.setLayoutParams(paramView);
      paramView.gravity = 17;
      paramView.rightMargin = ab.a(7.0F);
      if (paramInt == 0) {}
      for (paramView.leftMargin = ab.a(14.0F);; paramView.leftMargin = 0)
      {
        com.xiaoenai.app.utils.e.b.a(localImageView, this.b[paramInt].getUrl() + "?imageView/1/w/" + this.f + "/h/" + this.e);
        return paramViewGroup;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\GameItemActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
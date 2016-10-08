package com.xiaoenai.app.classes.chat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.image.ImagePicker;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.e;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.TitleBarView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChangeBgActivity
  extends TitleBarActivity
{
  private static int m = 0;
  private ImageView a;
  private GridView b;
  private b c;
  private ScrollView i;
  private String j;
  private boolean k = false;
  private int l = 0;
  private List<a> n = new ArrayList();
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("list"))
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("list");
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i1);
          a locala = new a();
          locala.c = localJSONObject.getString("thumb");
          locala.d = localJSONObject.getString("image");
          localArrayList.add(locala);
          i1 += 1;
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        this.n.addAll(localArrayList);
        this.c.notifyDataSetChanged();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    new l(new u(this, this, paramBoolean)).p();
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (paramString.startsWith("/")))
    {
      this.j = paramString;
      if (!paramString.startsWith(e.b))
      {
        Object localObject = new File(paramString);
        localObject = e.b + ((File)localObject).getName();
        if (e.a(paramString, (String)localObject) == 0) {
          this.j = ((String)localObject);
        }
      }
      b.a(this.a, "file://" + this.j);
      ak.a("chat_bg_photo_path", this.j);
      ak.a("chat_bg_type", -1);
      this.k = true;
      this.l = -1;
      this.c.notifyDataSetChanged();
      ak.a("chat_bg_origin_url");
      g();
    }
  }
  
  private void d()
  {
    a locala = new a();
    locala.b = 2130837652;
    locala.a = 2130837653;
    this.n.add(locala);
    locala = new a();
    locala.b = 2130837654;
    locala.a = 2130837655;
    this.n.add(locala);
    locala = new a();
    locala.b = 2130837656;
    locala.a = 2130837657;
    this.n.add(locala);
  }
  
  private void f()
  {
    findViewById(2131558764).setOnClickListener(new s(this));
    this.a = ((ImageView)findViewById(2131558765));
    if ((this.l == -1) && (this.j != null) && (this.j.startsWith("/"))) {
      b.a(this.a, "file://" + this.j);
    }
    this.b = ((GridView)findViewById(2131558739));
    this.c = new b();
    this.b.setAdapter(this.c);
    this.i = ((ScrollView)findViewById(2131558587));
  }
  
  private void g()
  {
    this.i.postDelayed(new v(this), 300L);
  }
  
  public int a()
  {
    return 2130903092;
  }
  
  public void a(int paramInt)
  {
    if (!as.c())
    {
      as.a(this);
      return;
    }
    ImagePicker localImagePicker = new ImagePicker(this);
    localImagePicker.a(new t(this));
    localImagePicker.b(ab.b(), ab.a());
    if (paramInt == 0)
    {
      localImagePicker.a(1);
      return;
    }
    localImagePicker.a(0);
  }
  
  public void a_(int paramInt)
  {
    if (this.k) {
      setResult(-1);
    }
    super.a_(paramInt);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 21) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getData() != null)) {
      b(paramIntent.getData().getPath());
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.l = ak.a("chat_bg_type", Integer.valueOf(0)).intValue();
    this.j = ak.b("chat_bg_photo_path", null);
    d();
    f();
    this.i.post(new r(this));
    paramBundle = ak.b("chat_bg_urls", null);
    if (paramBundle != null) {
      a(false);
    }
    for (;;)
    {
      try
      {
        a(new JSONObject(paramBundle));
        paramBundle = getIntent().getAction();
        if ((paramBundle != null) && (paramBundle.equals("chat_to_bg_action"))) {
          this.g.a(2130839000, 2131099966);
        }
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
      }
      a(true);
    }
  }
  
  class a
  {
    int a;
    int b;
    String c;
    String d;
    
    a() {}
  }
  
  class b
    extends BaseAdapter
  {
    b() {}
    
    public ChangeBgActivity.a a(int paramInt)
    {
      return (ChangeBgActivity.a)ChangeBgActivity.b(ChangeBgActivity.this).get(paramInt);
    }
    
    public int getCount()
    {
      return ChangeBgActivity.b(ChangeBgActivity.this).size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = LayoutInflater.from(ChangeBgActivity.this).inflate(2130903093, null);
      paramViewGroup = a(paramInt);
      Object localObject = (ImageView)paramView.findViewById(2131558766);
      if (ChangeBgActivity.c() == 0) {
        ChangeBgActivity.c((ab.b() - ab.a(30.0F)) / 3);
      }
      ((ImageView)localObject).getLayoutParams().height = ChangeBgActivity.c();
      ((ImageView)localObject).getLayoutParams().width = ChangeBgActivity.c();
      ImageView localImageView = (ImageView)paramView.findViewById(2131558767);
      if (ChangeBgActivity.d(ChangeBgActivity.this) == paramInt)
      {
        localImageView.setImageResource(2130837658);
        localImageView.setVisibility(0);
        if (paramInt >= 3) {
          break label179;
        }
        ((ImageView)localObject).setImageResource(paramViewGroup.a);
      }
      for (;;)
      {
        if (ChangeBgActivity.d(ChangeBgActivity.this) == paramInt)
        {
          localImageView.setImageResource(2130837658);
          localImageView.setVisibility(0);
        }
        paramView.setTag(Integer.valueOf(paramInt));
        paramView.setOnClickListener(new w(this));
        return paramView;
        localImageView.setVisibility(8);
        break;
        label179:
        b.a((ImageView)localObject, paramViewGroup.c);
        localObject = b.b(paramViewGroup.d);
        String str = ak.b("chat_bg_photo_path", "");
        if ((paramViewGroup.d.equals(str)) || ((localObject != null) && (((File)localObject).getAbsolutePath().equals(str))))
        {
          localImageView.setImageResource(2130837658);
        }
        else if ((localObject != null) && (((File)localObject).exists()))
        {
          localImageView.setVisibility(8);
        }
        else
        {
          localImageView.setImageResource(2130837651);
          localImageView.setVisibility(0);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\ChangeBgActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
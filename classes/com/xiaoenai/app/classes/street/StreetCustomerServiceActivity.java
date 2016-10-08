package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.dialog.q;
import com.xiaoenai.app.classes.street.d.e;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.utils.a.d;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.d.f;
import com.xiaoenai.app.utils.k;
import com.xiaoenai.app.widget.TitleBarView;
import com.xiaoenai.app.widget.wheel.a.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StreetCustomerServiceActivity
  extends StreetBaseActivity
{
  private RelativeLayout a;
  private LinearLayout b;
  private TextView c;
  private q i;
  private long j;
  private int k = 1;
  private String l = null;
  private e m;
  private b n;
  private String[] o;
  private int s;
  private int t = 0;
  
  private void a(int paramInt)
  {
    this.m.a(paramInt);
    this.m.b();
  }
  
  private void a(JSONArray paramJSONArray)
  {
    int i1 = 0;
    if (paramJSONArray != null)
    {
      this.o = new String[paramJSONArray.length() + 1];
      this.o[0] = getResources().getString(2131101476);
      for (;;)
      {
        if (i1 >= paramJSONArray.length()) {
          return;
        }
        try
        {
          this.o[(i1 + 1)] = paramJSONArray.get(i1).toString();
          i1 += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    this.o = new String[1];
    this.o[0] = getResources().getString(2131101476);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", paramJSONObject.optJSONObject("data"));
      f.a(localJSONObject, f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), "street_refund_reason_file_name"));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  private void c(String paramString)
  {
    this.g.setTitle(getResources().getString(2131101478));
    this.a.setVisibility(8);
    this.b.setVisibility(0);
    this.c.setText(paramString);
  }
  
  private void f()
  {
    this.a = ((RelativeLayout)findViewById(2131559806));
    this.n = new b();
    this.n.b = ((LinearLayout)findViewById(2131559846));
    this.n.c = ((RelativeLayout)findViewById(2131559847));
    this.n.d = ((ImageButton)findViewById(2131559848));
    this.n.e = ((ImageButton)findViewById(2131559849));
    this.n.f = ((RelativeLayout)findViewById(2131559850));
    this.n.g = ((ImageButton)findViewById(2131559851));
    this.n.h = ((ImageButton)findViewById(2131559852));
    this.n.i = ((RelativeLayout)findViewById(2131559853));
    this.n.j = ((ImageButton)findViewById(2131559854));
    this.n.k = ((ImageButton)findViewById(2131559855));
    this.n.l = ((Button)findViewById(2131559856));
    this.n.a = ((EditText)findViewById(2131559845));
    this.n.a.setFilters(new InputFilter[] { new InputFilter.LengthFilter(200) });
    this.n.m = ((RelativeLayout)findViewById(2131559809));
    this.n.n = ((TextView)findViewById(2131559844));
    this.b = ((LinearLayout)findViewById(2131559815));
    this.c = ((TextView)findViewById(2131559816));
  }
  
  private void g()
  {
    this.n.m.setVisibility(0);
    h();
    p();
    o();
    this.n.m.setOnClickListener(new ax(this));
  }
  
  private void h()
  {
    k.a(((BitmapDrawable)getResources().getDrawable(2130838709)).getBitmap(), (ImageView)findViewById(2131559811), 90.0F);
    findViewById(2131559811).getLayoutParams().height = -2;
    findViewById(2131559811).getLayoutParams().width = ab.a(12.0F);
  }
  
  private void i()
  {
    k.a(((BitmapDrawable)getResources().getDrawable(2130838709)).getBitmap(), (ImageView)findViewById(2131559811), 270.0F);
    findViewById(2131559811).getLayoutParams().height = -2;
    findViewById(2131559811).getLayoutParams().width = ab.a(12.0F);
  }
  
  private void j()
  {
    this.n.l.setOnClickListener(new ay(this));
    this.n.e.setOnClickListener(new az(this));
    this.n.h.setOnClickListener(new ba(this));
    this.n.k.setOnClickListener(new bb(this));
  }
  
  private void k()
  {
    if (this.i == null)
    {
      this.i = new q(this);
      this.i.a(new a(this, this.o), new bc(this));
      this.i.a(new bd(this));
      this.i.a(new be(this));
    }
    i();
    this.i.show();
  }
  
  private void o()
  {
    ae localae = new ae(new bf(this, this));
    if (this.k == com.xiaoenai.app.c.a.b) {
      localae.c();
    }
    while (this.k != com.xiaoenai.app.c.a.c) {
      return;
    }
    localae.d();
  }
  
  private void p()
  {
    JSONObject localJSONObject = f.a(f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), "street_refund_reason_file_name"));
    if ((localJSONObject != null) && (localJSONObject.optJSONArray("data") != null)) {
      a(localJSONObject.optJSONArray("data"));
    }
  }
  
  public int a()
  {
    return 2130903339;
  }
  
  public void b(String paramString)
  {
    c(paramString);
    this.t = -1;
    d.a(StreetOrderDetailActivity.class.getName() + StreetCustomerServiceActivity.class.getName(), "result_ok");
  }
  
  protected void c()
  {
    if (this.k == com.xiaoenai.app.c.a.a)
    {
      this.g.setTitle(getResources().getString(2131101355));
      return;
    }
    if (this.k == com.xiaoenai.app.c.a.b)
    {
      this.g.setTitle(getResources().getString(2131101356));
      return;
    }
    if (this.k == com.xiaoenai.app.c.a.c)
    {
      this.g.setTitle(getResources().getString(2131101354));
      return;
    }
    this.g.setTitle(getResources().getString(2131101478));
  }
  
  public void d()
  {
    setResult(this.t);
    super.r();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21) {
        break label58;
      }
      paramIntent = paramIntent.getStringArrayExtra("image_url_array");
      com.xiaoenai.app.utils.f.a.c("====从相册获取图片的地址====={}", new Object[] { paramIntent[0] });
      this.m.a(paramIntent);
      this.m.b();
    }
    label58:
    do
    {
      do
      {
        return;
        if (paramInt1 != 0) {
          break;
        }
      } while ((paramIntent == null) || (paramIntent.getData() == null) || (paramIntent.getData().getPath() == null));
      String str = paramIntent.getData().getPath();
      paramIntent = str;
      if (!str.startsWith("file://")) {
        paramIntent = "file://" + str;
      }
      this.m.a(paramIntent);
      this.m.b();
      return;
    } while (paramInt1 != 2);
    paramIntent = paramIntent.getIntArrayExtra("image_position_array");
    if (paramIntent != null) {
      this.m.a(paramIntent);
    }
    this.m.b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.j = getIntent().getLongExtra("street_order_id_key", 0L);
    this.k = getIntent().getIntExtra("street_service_type_key", com.xiaoenai.app.c.a.a);
    this.l = getIntent().getStringExtra("street_service_msg_key");
    f();
    c();
    if (this.k == com.xiaoenai.app.c.a.d) {
      c(this.l);
    }
    for (;;)
    {
      this.m = new e(this, this.n);
      this.m.a(this.j);
      this.m.b(this.k);
      j();
      return;
      if ((this.k == com.xiaoenai.app.c.a.c) || (this.k == com.xiaoenai.app.c.a.b))
      {
        g();
      }
      else
      {
        this.n.a.setHint(2131101474);
        this.n.b.setVisibility(8);
      }
    }
  }
  
  public void r()
  {
    if (this.t == -1) {
      com.xiaoenai.app.classes.common.a.a().a(StreetServiceChooseActivity.class);
    }
    d();
  }
  
  class a
    extends b
  {
    private String[] g;
    
    public a(Context paramContext, String[] paramArrayOfString)
    {
      super();
      this.g = paramArrayOfString;
    }
    
    public int a()
    {
      return this.g.length;
    }
    
    protected CharSequence a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < a())) {
        return this.g[paramInt];
      }
      return null;
    }
    
    protected void a(TextView paramTextView)
    {
      paramTextView.setTextColor(-14013652);
      paramTextView.setGravity(17);
      paramTextView.setTextSize(20.0F);
      paramTextView.setLines(1);
      paramTextView.setPadding(0, 15, 0, 15);
    }
  }
  
  public class b
  {
    public EditText a;
    public LinearLayout b;
    public RelativeLayout c;
    public ImageButton d;
    public ImageButton e;
    public RelativeLayout f;
    public ImageButton g;
    public ImageButton h;
    public RelativeLayout i;
    public ImageButton j;
    public ImageButton k;
    public Button l;
    public RelativeLayout m;
    public TextView n;
    
    public b() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetCustomerServiceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
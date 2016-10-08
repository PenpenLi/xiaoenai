package com.xiaoenai.app.classes.extentions.anniversary;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.stat.c;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.ArrayList;

public class AnniversaryActivity
  extends TitleBarActivity
{
  private ListView a;
  private a b;
  private TextView c;
  private TextView i;
  private TextView j;
  
  private void a(TextView paramTextView, int paramInt, String paramString)
  {
    Rect localRect = new Rect();
    int k = paramTextView.getLayoutParams().width;
    paramTextView.setTextSize(1, paramInt);
    paramTextView.getPaint().getTextBounds(paramString, 0, paramString.length(), localRect);
    if (localRect.width() >= k) {
      a(paramTextView, paramInt - 5, paramString);
    }
  }
  
  private void d()
  {
    this.a = ((ListView)findViewById(2131559027));
    as.a(this.a);
    this.b = new a();
    this.a.setAdapter(this.b);
    this.c = ((TextView)findViewById(2131559025));
    this.i = ((TextView)findViewById(2131559024));
    this.j = ((TextView)findViewById(2131559023));
  }
  
  private void f()
  {
    new com.xiaoenai.app.net.b(new d(this, this)).a();
  }
  
  public int a()
  {
    return 2130903164;
  }
  
  public int a(int paramInt)
  {
    paramInt = ab.a(42.0F) * paramInt;
    a.c("getContentHeight: {}", new Object[] { Integer.valueOf(paramInt) });
    return paramInt;
  }
  
  protected void b()
  {
    super.b();
    this.g.setRightButtonClickListener(new b(this));
  }
  
  public int c()
  {
    return this.a.getMeasuredHeight();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d();
    f();
    c.a().a(104);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      overridePendingTransition(2130968606, 2130968607);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.b.a();
    long l = ((ah)ai.a().b().get(0)).k();
    if (l <= 0L) {
      this.c.setText("1");
    }
    for (;;)
    {
      this.i.setText(((ah)ai.a().b().get(0)).e());
      this.j.setText(((ah)ai.a().b().get(0)).a(this, Xiaoenai.j().z().m().a().j()));
      return;
      this.c.setText(String.valueOf(l));
    }
  }
  
  public class a
    extends BaseAdapter
  {
    private ArrayList<ah> b = new ArrayList();
    
    public a() {}
    
    public void a()
    {
      this.b.clear();
      this.b.addAll(ai.a().b());
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      label36:
      RelativeLayout localRelativeLayout1;
      TextView localTextView;
      RelativeLayout localRelativeLayout2;
      ImageView localImageView;
      label154:
      RelativeLayout.LayoutParams localLayoutParams;
      int i;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(Xiaoenai.j()).inflate(2130903168, null);
        paramView.setTag(paramView);
        if (paramInt != 0) {
          break label362;
        }
        paramView.findViewById(2131559045).setVisibility(0);
        paramViewGroup = (ah)getItem(paramInt);
        localRelativeLayout1 = (RelativeLayout)paramView.findViewById(2131559046);
        ((TextView)paramView.findViewById(2131559051)).setText(paramViewGroup.j());
        localTextView = (TextView)paramView.findViewById(2131559049);
        localRelativeLayout2 = (RelativeLayout)paramView.findViewById(2131559047);
        Object localObject = (ImageView)paramView.findViewById(2131559053);
        localImageView = (ImageView)paramView.findViewById(2131559052);
        localRelativeLayout2.setBackgroundResource(paramViewGroup.f());
        ((ImageView)localObject).setImageResource(paramViewGroup.g());
        if (paramViewGroup.k() != 0L) {
          break label389;
        }
        if (paramInt != 0) {
          break label376;
        }
        localTextView.setText("1");
        AnniversaryActivity.a(AnniversaryActivity.this, localTextView, 23, localTextView.getText().toString());
        localObject = (RelativeLayout.LayoutParams)localRelativeLayout1.getLayoutParams();
        localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
        paramViewGroup = (ViewGroup)localObject;
        if (localObject == null)
        {
          paramViewGroup = new RelativeLayout.LayoutParams(-1, AnniversaryActivity.this.c());
          paramViewGroup.leftMargin = ab.a(5.0F);
        }
        if (paramInt != getCount() - 1) {
          break label414;
        }
        if (AnniversaryActivity.this.a(getCount()) - AnniversaryActivity.this.c() >= 0) {
          break label404;
        }
        i = Math.abs(AnniversaryActivity.this.c() - AnniversaryActivity.this.a(getCount())) + ab.a(46.0F);
        label290:
        paramViewGroup.width = -1;
        paramViewGroup.height = i;
        localLayoutParams.width = -2;
      }
      for (localLayoutParams.height = i;; localLayoutParams.height = ab.a(42.0F))
      {
        localRelativeLayout1.setLayoutParams(paramViewGroup);
        localImageView.setLayoutParams(localLayoutParams);
        localTextView.setGravity(17);
        localRelativeLayout2.setOnClickListener(new e(this, paramInt));
        return paramView;
        paramView = (View)paramView.getTag();
        break;
        label362:
        paramView.findViewById(2131559045).setVisibility(8);
        break label36;
        label376:
        localTextView.setText(as.a(2131099953));
        break label154;
        label389:
        localTextView.setText(String.valueOf(paramViewGroup.k()));
        break label154;
        label404:
        i = ab.a(50.0F);
        break label290;
        label414:
        paramViewGroup.width = -1;
        paramViewGroup.height = -2;
        localLayoutParams.width = -2;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\AnniversaryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
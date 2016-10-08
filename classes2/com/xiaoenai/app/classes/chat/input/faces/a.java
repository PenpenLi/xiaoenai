package com.xiaoenai.app.classes.chat.input.faces;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.model.RecentFace;
import com.xiaoenai.app.widget.CustomViewPager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class a
  extends com.xiaoenai.app.common.view.a.a
  implements AdapterView.OnItemClickListener
{
  protected static HashMap<String, Integer> d = new HashMap();
  protected List<String> a = new ArrayList();
  protected com.xiaoenai.app.d.ab b = new com.xiaoenai.app.d.ab();
  protected String c;
  private CustomViewPager f = null;
  private List<View> g = null;
  private LinearLayout h;
  private int i = 0;
  private p j;
  
  private int a(int paramInt)
  {
    if (paramInt % 8 == 0) {
      return paramInt / 8;
    }
    return paramInt / 8 + 1;
  }
  
  private View a(LayoutInflater paramLayoutInflater, List<String> paramList)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903100, null);
    GridView localGridView = (GridView)paramLayoutInflater.findViewById(2131558421);
    int k = com.xiaoenai.app.utils.ab.d();
    if (k > 0)
    {
      k = ((k - com.xiaoenai.app.utils.ab.a(44.0F)) * 4 / 5 / 2 - com.xiaoenai.app.utils.ab.a(48.0F)) / 2;
      com.xiaoenai.app.utils.f.a.c("=======setVerticalSpacing======={}", new Object[] { Integer.valueOf(k) });
      if (k > com.xiaoenai.app.utils.ab.a(3.0F))
      {
        localGridView.setVerticalSpacing(k);
        localGridView.setPadding(0, k, 0, 0);
      }
    }
    localGridView.setAdapter(new a(getActivity(), paramList));
    localGridView.setOnTouchListener(new t(this.f, this.j, new c(this, localGridView), 1));
    localGridView.setOnItemClickListener(this);
    return paramLayoutInflater;
  }
  
  private void a(View paramView, int paramInt)
  {
    this.h.removeAllViews();
    int k = 0;
    if (k < paramInt)
    {
      paramView = new ImageView(getActivity());
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      int m = com.xiaoenai.app.utils.ab.a(5.0F);
      paramView.setPadding(m, m, m, m);
      if (k == 0) {
        paramView.setImageResource(2130837672);
      }
      for (;;)
      {
        paramView.setSelected(false);
        this.h.addView(paramView);
        k += 1;
        break;
        paramView.setImageResource(2130837673);
      }
    }
  }
  
  private void b(View paramView)
  {
    int n = this.a.size();
    int i1 = a(n);
    a(paramView, i1);
    int m = 0;
    if (m < i1)
    {
      int i2 = m * 8;
      int k = n - m * 8;
      if (k % 8 == 0) {
        k = i2 + 8;
      }
      for (;;)
      {
        this.g.add(a(LayoutInflater.from(getActivity()), this.a.subList(i2, k)));
        m += 1;
        break;
        if (k / 8 == 0) {
          k += i2;
        } else {
          k = i2 + 8;
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    this.g = new Vector();
    b(paramView);
    this.f.setAdapter(new b(this.g));
    this.f.setCurrentItem(this.i, false);
  }
  
  protected void a(String paramString)
  {
    ((ChatActivity)getActivity()).c(paramString);
    this.b.a(new RecentFace(System.currentTimeMillis(), paramString));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.a = paramBundle.getStringArrayList("url-list");
      this.c = paramBundle.getString("faceName");
      if (d.get(this.c) != null) {
        this.i = ((Integer)d.get(this.c)).intValue();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2130903099, paramViewGroup, false);
    if (this.j == null) {
      this.j = new p(getActivity());
    }
    return paramLayoutInflater;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(((a)paramAdapterView.getAdapter()).a(paramInt));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f = ((CustomViewPager)paramView.findViewById(2131558784));
    this.h = ((LinearLayout)paramView.findViewById(2131558785));
    this.f.setOnPageChangeListener(new b(this));
    a(paramView);
  }
  
  private class a
    extends BaseAdapter
  {
    private List<String> b;
    private Context c;
    
    public a(List<String> paramList)
    {
      this.c = paramList;
      List localList;
      this.b = localList;
    }
    
    public String a(int paramInt)
    {
      return (String)this.b.get(paramInt);
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.c).inflate(2130903101, null);
        paramView.setTag(paramView);
      }
      for (;;)
      {
        com.xiaoenai.app.utils.e.b.a((ImageView)paramView.findViewById(2131558786), a(paramInt), Boolean.valueOf(true));
        return paramView;
        paramView = (View)paramView.getTag();
      }
    }
  }
  
  private class b
    extends PagerAdapter
  {
    private List<View> b = null;
    
    public b()
    {
      List localList;
      this.b = localList;
    }
    
    public void destroyItem(View paramView, int paramInt, Object paramObject)
    {
      ((ViewPager)paramView).removeView((View)this.b.get(paramInt));
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public Object instantiateItem(View paramView, int paramInt)
    {
      ((ViewPager)paramView).addView((View)this.b.get(paramInt), 0);
      return this.b.get(paramInt);
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
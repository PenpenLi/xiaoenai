package com.xiaoenai.app.classes.street.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.f.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StreetProductTypeItemLayout
  extends LinearLayout
{
  private Context a = null;
  private LinearLayout b = null;
  private LinearLayout c = null;
  private List<StreetProductTypeItemView> d = new ArrayList();
  private List<a> e = new ArrayList();
  private int f = 0;
  private StreetProductTypeItemView.a g = null;
  private StreetProductTypeItemView.a h = null;
  
  public StreetProductTypeItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  @TargetApi(11)
  public StreetProductTypeItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private LinearLayout a(int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.c.getWidth(), -2);
    localLayoutParams.topMargin = ab.a(16.0F);
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setId(paramInt);
    localLinearLayout.setOrientation(0);
    this.c.addView(localLinearLayout);
    return localLinearLayout;
  }
  
  private void a(Context paramContext)
  {
    setOrientation(1);
    this.a = paramContext;
    this.b = ((LinearLayout)RelativeLayout.inflate(this.a, 2130903282, this));
    this.b.setOrientation(1);
    this.c = ((LinearLayout)this.b.findViewById(2131558670));
    this.c.setOrientation(1);
    this.f = (ab.b() - ab.a(16.0F) * 2);
  }
  
  public void a()
  {
    this.c.removeAllViews();
    this.d.clear();
    this.h = new ay(this);
    int i = 0;
    Object localObject1;
    while (i < this.e.size())
    {
      localObject1 = new StreetProductTypeItemView(this.a, (a)this.e.get(i));
      ((StreetProductTypeItemView)localObject1).setId(i * 100 + 1);
      if (((a)this.e.get(i)).e <= 0) {
        ((StreetProductTypeItemView)localObject1).setItemEnable(false);
      }
      ((StreetProductTypeItemView)localObject1).setOnClickListener(this.h);
      ((StreetProductTypeItemView)localObject1).setVisibility(0);
      this.d.add(localObject1);
      i += 1;
    }
    int m = ab.b(this.c.getWidth());
    i = 0;
    for (int j = 0; i < this.d.size(); j = k)
    {
      k = j;
      if (j < ((StreetProductTypeItemView)this.d.get(i)).getItemWidth()) {
        k = ((StreetProductTypeItemView)this.d.get(i)).getItemWidth();
      }
      i += 1;
    }
    a.c(" itemMaxWidth = {}", new Object[] { Integer.valueOf(j) });
    Object localObject2 = null;
    int k = 0;
    i = m;
    if (k < this.d.size())
    {
      ((StreetProductTypeItemView)this.d.get(k)).setItemWidth(j);
      if (k != 0)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = a(k);
        i = ab.b(this.c.getWidth());
      }
      if (i - ((StreetProductTypeItemView)this.d.get(k)).getItemWidth() - 10 > 0)
      {
        m = ((StreetProductTypeItemView)this.d.get(k)).getItemWidth();
        ((LinearLayout)localObject1).addView((View)this.d.get(k));
        localObject2 = new View(this.a);
        ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(ab.a(10), -1));
        ((LinearLayout)localObject1).addView((View)localObject2);
        i -= m + 10;
      }
      for (;;)
      {
        k += 1;
        localObject2 = localObject1;
        break;
        if (i - ((StreetProductTypeItemView)this.d.get(k)).getItemWidth() > 0)
        {
          m = ((StreetProductTypeItemView)this.d.get(k)).getItemWidth();
          ((LinearLayout)localObject1).addView((View)this.d.get(k));
          i -= m;
        }
        else
        {
          localObject1 = a(k);
          i = ab.b(this.c.getWidth());
          if (i < ((StreetProductTypeItemView)this.d.get(k)).getItemWidth())
          {
            ((StreetProductTypeItemView)this.d.get(k)).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            ((LinearLayout)localObject1).addView((View)this.d.get(k));
            localObject1 = a(k);
          }
          else if (i - ((StreetProductTypeItemView)this.d.get(k)).getItemWidth() - 10 > 0)
          {
            m = ((StreetProductTypeItemView)this.d.get(k)).getItemWidth();
            if (((StreetProductTypeItemView)this.d.get(k)).getTextView() != null)
            {
              ((StreetProductTypeItemView)this.d.get(k)).getTextView().setSingleLine(true);
              ((StreetProductTypeItemView)this.d.get(k)).getTextView().setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            }
            ((LinearLayout)localObject1).addView((View)this.d.get(k));
            localObject2 = new View(this.a);
            ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(ab.a(10), -1));
            ((LinearLayout)localObject1).addView((View)localObject2);
            i -= m + 10;
          }
          else
          {
            m = ((StreetProductTypeItemView)this.d.get(k)).getItemWidth();
            ((LinearLayout)localObject1).addView((View)this.d.get(k));
            i -= m;
          }
        }
      }
    }
  }
  
  public boolean a(a parama)
  {
    int i = 0;
    boolean bool = false;
    if (i < this.d.size())
    {
      if (parama.a == ((StreetProductTypeItemView)this.d.get(i)).getProductItem().a)
      {
        ((StreetProductTypeItemView)this.d.get(i)).setPressState(true);
        bool = true;
      }
      for (;;)
      {
        i += 1;
        break;
        ((StreetProductTypeItemView)this.d.get(i)).setPressState(false);
      }
    }
    return bool;
  }
  
  public int getItemCount()
  {
    return this.e.size();
  }
  
  public void setItemData(JSONObject paramJSONObject)
  {
    this.e.clear();
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("list");
      if (paramJSONObject != null)
      {
        i = 0;
        if (i >= paramJSONObject.length()) {}
      }
    }
    catch (JSONException paramJSONObject)
    {
      try
      {
        for (;;)
        {
          int i;
          a locala = new a(paramJSONObject.getJSONObject(i));
          this.e.add(locala);
          i += 1;
        }
        paramJSONObject = paramJSONObject;
        paramJSONObject.printStackTrace();
        paramJSONObject = null;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      a();
    }
  }
  
  public void setItemOnClickListener(StreetProductTypeItemView.a parama)
  {
    this.g = parama;
  }
  
  public void setSelectIndex(int paramInt)
  {
    int i = 0;
    if (i < this.d.size())
    {
      if (paramInt - 1 == i)
      {
        ((StreetProductTypeItemView)this.d.get(i)).setPressState(true);
        this.g.a((a)this.e.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        ((StreetProductTypeItemView)this.d.get(i)).setPressState(false);
        this.g.a(null);
      }
    }
  }
  
  public static class a
  {
    public int a = 0;
    public String b = "";
    public int c = 0;
    public long d = 0L;
    public int e = 0;
    public int f = 0;
    public String g = "";
    
    public a(JSONObject paramJSONObject)
    {
      this.g = paramJSONObject.toString();
      a(paramJSONObject);
    }
    
    private void a(JSONObject paramJSONObject)
    {
      this.a = paramJSONObject.optInt("id", 0);
      this.b = paramJSONObject.optString("name");
      this.c = paramJSONObject.optInt("product_id", 0);
      this.d = paramJSONObject.optLong("price");
      this.e = paramJSONObject.optInt("store_count");
      this.f = paramJSONObject.optInt("selling_count");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetProductTypeItemLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
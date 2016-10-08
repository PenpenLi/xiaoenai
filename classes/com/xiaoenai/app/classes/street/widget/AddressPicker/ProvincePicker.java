package com.xiaoenai.app.classes.street.widget.AddressPicker;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.xiaoenai.app.widget.wheel.WheelView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;

public class ProvincePicker
  extends LinearLayout
  implements View.OnClickListener, com.xiaoenai.app.widget.wheel.b
{
  private static int g = 18;
  private static int h = -16777216;
  protected String a;
  protected String b;
  protected String c = "";
  protected List<c> d = null;
  protected Map<String, c> e = new HashMap();
  private int f = 7;
  private WheelView i;
  private WheelView j;
  private WheelView k;
  private a l;
  
  public ProvincePicker(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ProvincePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private String[] a(List<c> paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    int m = 0;
    while (m < paramList.size())
    {
      arrayOfString[m] = ((c)paramList.get(m)).a();
      m += 1;
    }
    return arrayOfString;
  }
  
  private String[] b(List<a> paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    int m = 0;
    while (m < paramList.size())
    {
      arrayOfString[m] = ((a)paramList.get(m)).a();
      m += 1;
    }
    return arrayOfString;
  }
  
  private void c()
  {
    d();
    e();
    f();
  }
  
  private String[] c(List<b> paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    int m = 0;
    while (m < paramList.size())
    {
      arrayOfString[m] = ((b)paramList.get(m)).a();
      m += 1;
    }
    return arrayOfString;
  }
  
  private void d()
  {
    View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130903284, this);
    this.i = ((WheelView)localView.findViewById(2131559647));
    this.j = ((WheelView)localView.findViewById(2131559648));
    this.k = ((WheelView)localView.findViewById(2131559649));
  }
  
  private void e()
  {
    this.i.a(this);
    this.j.a(this);
    this.k.a(this);
  }
  
  private void f()
  {
    b();
    this.i.setViewAdapter(new com.xiaoenai.app.widget.wheel.a.c(getContext(), a(this.d)));
    this.i.setVisibleItems(this.f);
    this.j.setVisibleItems(this.f);
    this.k.setVisibleItems(this.f);
    this.i.setTextSize(g);
    this.i.setTextColor(h);
    this.i.setProvincePicker(true);
    g();
    h();
  }
  
  private void g()
  {
    int m = this.i.getCurrentItem();
    this.a = ((c)this.d.get(m)).a();
    String[] arrayOfString2 = b(((c)this.e.get(this.a)).b());
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2 == null)
    {
      arrayOfString1 = new String[1];
      arrayOfString1[0] = "";
    }
    this.j.setViewAdapter(new com.xiaoenai.app.widget.wheel.a.c(getContext(), arrayOfString1));
    this.j.setCurrentItem(0);
    h();
    this.j.setTextSize(g);
    this.j.setTextColor(h);
    this.j.setProvincePicker(true);
  }
  
  private void h()
  {
    com.xiaoenai.app.utils.f.a.c("updateAreas：{} {} {}", new Object[] { this.a, this.b, this.c });
    int m = this.j.getCurrentItem();
    this.b = ((a)((c)this.e.get(this.a)).b().get(m)).a();
    String[] arrayOfString2 = c(((a)((c)this.e.get(this.a)).c().get(this.b)).b());
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2 == null)
    {
      arrayOfString1 = new String[1];
      arrayOfString1[0] = "";
    }
    this.k.setViewAdapter(new com.xiaoenai.app.widget.wheel.a.c(getContext(), arrayOfString1));
    this.k.setCurrentItem(0);
    this.k.setTextSize(g);
    this.k.setTextColor(h);
    this.k.setProvincePicker(true);
  }
  
  public void a()
  {
    com.xiaoenai.app.utils.f.a.c("省市区初始值：{} {} {}", new Object[] { this.a, this.b, this.c });
    if (this.l != null)
    {
      this.l.a(this.a + " " + this.b + " " + this.c);
      this.l.a(this.a, this.b, this.c);
    }
  }
  
  public void a(WheelView paramWheelView, int paramInt1, int paramInt2)
  {
    if (paramWheelView == this.i)
    {
      g();
      this.c = ((b)((a)((c)this.e.get(this.a)).c().get(this.b)).b().get(0)).a();
    }
    for (;;)
    {
      a();
      return;
      if (paramWheelView == this.j)
      {
        h();
        this.c = ((b)((a)((c)this.e.get(this.a)).c().get(this.b)).b().get(0)).a();
      }
      else if (paramWheelView == this.k)
      {
        this.c = ((b)((a)((c)this.e.get(this.a)).c().get(this.b)).b().get(paramInt2)).a();
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    int n = 0;
    if (this.e == null) {
      return;
    }
    if (this.e.get(paramString1) != null)
    {
      m = ((c)this.e.get(paramString1)).d();
      this.i.setCurrentItem(m);
      if (((c)this.e.get(paramString1)).c().get(paramString2) == null) {
        break label245;
      }
      m = ((a)((c)this.e.get(paramString1)).c().get(paramString2)).d();
      label106:
      this.j.setCurrentItem(m);
      if (((a)((c)this.e.get(paramString1)).c().get(paramString2)).c().get(paramString3) == null) {
        break label280;
      }
    }
    for (int m = ((b)((a)((c)this.e.get(paramString1)).c().get(paramString2)).c().get(paramString3)).c();; m = n)
    {
      this.k.setCurrentItem(m);
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      return;
      paramString1 = ((c)this.e.get(this.a)).a();
      m = 0;
      break;
      label245:
      paramString2 = ((a)((c)this.e.get(paramString1)).b().get(0)).a();
      m = 0;
      break label106;
      label280:
      paramString3 = ((b)((a)((c)this.e.get(paramString1)).c().get(paramString2)).b().get(0)).a();
    }
  }
  
  protected void b()
  {
    Object localObject1 = getContext().getAssets();
    for (;;)
    {
      int m;
      try
      {
        localObject1 = ((AssetManager)localObject1).open("province_data.xml");
        localObject3 = SAXParserFactory.newInstance().newSAXParser();
        localObject4 = new d();
        ((SAXParser)localObject3).parse((InputStream)localObject1, (DefaultHandler)localObject4);
        ((InputStream)localObject1).close();
        this.d = ((d)localObject4).a();
        if ((this.d == null) || (this.d.isEmpty())) {
          break label414;
        }
        this.a = ((c)this.d.get(0)).a();
        localObject1 = ((c)this.d.get(0)).b();
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break label414;
        }
        this.b = ((a)((List)localObject1).get(0)).a();
        this.c = ((b)((a)((List)localObject1).get(0)).b().get(0)).a();
        break label414;
      }
      catch (Throwable localThrowable)
      {
        Object localObject3;
        Object localObject4;
        int n;
        ArrayList localArrayList;
        int i1;
        localThrowable = localThrowable;
        localThrowable.printStackTrace();
        return;
      }
      finally {}
      if (m < this.d.size())
      {
        localObject1 = ((c)this.d.get(m)).b();
        localObject3 = new ArrayList();
        n = 0;
        if (n < ((List)localObject1).size())
        {
          localObject4 = ((a)((List)localObject1).get(n)).b();
          localArrayList = new ArrayList();
          i1 = 0;
          if (i1 < ((List)localObject4).size())
          {
            localArrayList.add(new b(((b)((List)localObject4).get(i1)).a(), ((b)((List)localObject4).get(i1)).b(), i1));
            i1 += 1;
          }
          else
          {
            ((List)localObject3).add(new a(((a)((List)localObject1).get(n)).a(), localArrayList, n));
            n += 1;
          }
        }
        else
        {
          localObject1 = new c(((c)this.d.get(m)).a(), (List)localObject3, m);
          this.e.put(((c)localObject1).a(), localObject1);
          m += 1;
        }
      }
      else
      {
        label414:
        m = 0;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    a();
  }
  
  public void setProvincePickerListener(a parama)
  {
    this.l = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
    
    public abstract void a(String paramString1, String paramString2, String paramString3);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\AddressPicker\ProvincePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
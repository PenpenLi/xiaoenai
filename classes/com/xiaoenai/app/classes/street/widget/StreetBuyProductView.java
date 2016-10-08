package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.ea;
import com.xiaoenai.app.classes.street.model.BuyInfo;
import com.xiaoenai.app.classes.street.model.BuyProduct;
import com.xiaoenai.app.classes.street.model.BuyProducts;
import com.xiaoenai.app.classes.street.model.ImageInfo;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.b;
import java.util.ArrayList;
import java.util.List;

public class StreetBuyProductView
  extends LinearLayout
{
  private Context a = null;
  private LinearLayout b = null;
  private BuyProducts c = null;
  private List<a> d = new ArrayList();
  
  public StreetBuyProductView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StreetBuyProductView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a()
  {
    this.b.removeAllViews();
    this.d.clear();
    int i = 0;
    while (i < this.c.getBuyProducts().length)
    {
      a locala = new a(this.a);
      locala.a(this.c.getBuyProducts()[i]);
      this.b.addView(locala);
      this.d.add(locala);
      i += 1;
    }
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    RelativeLayout.inflate(paramContext, 2130903333, this);
    this.b = ((LinearLayout)findViewById(2131559819));
  }
  
  public BuyInfo[] getBuyInfos()
  {
    BuyInfo[] arrayOfBuyInfo = new BuyInfo[this.d.size()];
    int i = 0;
    while (i < this.d.size())
    {
      arrayOfBuyInfo[i] = ((a)this.d.get(i)).a();
      i += 1;
    }
    return arrayOfBuyInfo;
  }
  
  public void setProducts(BuyProducts paramBuyProducts)
  {
    this.c = paramBuyProducts;
    if (this.c != null) {
      a();
    }
  }
  
  private class a
    extends LinearLayout
  {
    TextWatcher a = new c(this);
    private ImageView c = null;
    private TextView d = null;
    private TextView e = null;
    private TextView f = null;
    private TextView g = null;
    private EditText h = null;
    private RelativeLayout i = null;
    private BuyProduct j = null;
    private BuyInfo k = null;
    
    public a(Context paramContext)
    {
      super();
      a(paramContext);
    }
    
    private void a(Context paramContext)
    {
      RelativeLayout.inflate(paramContext, 2130903334, this);
      this.c = ((ImageView)findViewById(2131559821));
      this.d = ((TextView)findViewById(2131559822));
      this.d.setWidth(c());
      this.f = ((TextView)findViewById(2131559823));
      this.e = ((TextView)findViewById(2131559825));
      this.g = ((TextView)findViewById(2131559824));
      this.h = ((EditText)findViewById(2131559826));
      this.h.addTextChangedListener(this.a);
      this.i = ((RelativeLayout)findViewById(2131559827));
      this.i.setVisibility(8);
      this.k = new BuyInfo();
      b();
    }
    
    private void b()
    {
      this.i.setOnClickListener(new d(this));
      this.h.setOnFocusChangeListener(new e(this));
      this.h.setOnEditorActionListener(new f(this));
    }
    
    private int c()
    {
      float f1 = 0.4F;
      if (ab.b() > 480) {
        f1 = 0.5F;
      }
      return (int)(f1 * ab.b());
    }
    
    public BuyInfo a()
    {
      return this.k;
    }
    
    public void a(BuyProduct paramBuyProduct)
    {
      this.j = paramBuyProduct;
      String str;
      if (paramBuyProduct != null)
      {
        if ((paramBuyProduct.getImageInfo() != null) && (paramBuyProduct.getImageInfo().getUrl() != null) && (paramBuyProduct.getImageInfo().getUrl().length() > 0))
        {
          str = paramBuyProduct.getImageInfo().getUrl() + "?imageView/1/w/" + ab.a(88.0F) + "/h/" + ab.a(88.0F);
          b.a(this.c, str);
        }
        if (paramBuyProduct.getRushId() <= 0) {
          break label363;
        }
        this.d.setText(ea.b(StreetBuyProductView.a(StreetBuyProductView.this), paramBuyProduct.getTitle()));
      }
      for (;;)
      {
        this.d.setTextColor(getResources().getColor(2131493131));
        str = StreetBuyProductView.a(StreetBuyProductView.this).getString(2131101450) + String.format("%.2f", new Object[] { Double.valueOf(paramBuyProduct.getPrice() / 100.0D) });
        this.f.setText(str);
        this.f.setTextColor(getResources().getColor(2131493132));
        this.g.setText("x" + String.valueOf(paramBuyProduct.getCount()));
        this.g.setTextColor(getResources().getColor(2131493130));
        this.e.setText(paramBuyProduct.getSkuDesc().replace(";", " "));
        this.e.setTextColor(getResources().getColor(2131493130));
        this.h.setText("");
        this.k.setPrice(paramBuyProduct.getPrice());
        this.k.setCount(paramBuyProduct.getCount());
        this.k.setSkuId(paramBuyProduct.getSkuId());
        this.k.setRushId(paramBuyProduct.getRushId());
        this.k.setCartId(paramBuyProduct.getCartId());
        return;
        label363:
        this.d.setText(paramBuyProduct.getTitle());
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetBuyProductView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
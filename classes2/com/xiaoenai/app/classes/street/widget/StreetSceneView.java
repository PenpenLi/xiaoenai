package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.marshalchen.ultimaterecyclerview.RefreshCustomUltimateRecyclerview;
import com.marshalchen.ultimaterecyclerview.uiUtils.BasicGridLayoutManager;
import com.xiaoenai.app.classes.common.c.f;
import com.xiaoenai.app.classes.common.c.g;
import com.xiaoenai.app.classes.home.model.HomeDiscoverItem;
import com.xiaoenai.app.classes.street.a.o;
import com.xiaoenai.app.classes.street.d.bo;
import com.xiaoenai.app.classes.street.model.ProductItemInfo;
import com.xiaoenai.app.classes.street.model.SceneTextType;
import com.xiaoenai.app.stat.j;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.f.a;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class StreetSceneView
  extends RelativeLayout
{
  private Context a = null;
  private View b;
  private o c;
  private StreetImageViewPager.d d;
  private int e = 0;
  private int f;
  private String g;
  private com.xiaoenai.app.classes.street.widget.viewHolder.e h;
  private bo i;
  private long j = -1L;
  @BindView(2131560056)
  TextView mProductNewCountTextView;
  @BindView(2131560053)
  RefreshCustomUltimateRecyclerview mProductRecyclerView;
  @BindView(2131558669)
  ProgressView progressView;
  
  public StreetSceneView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = RelativeLayout.inflate(this.a, 2130903367, this);
    ButterKnife.bind(this, this.b);
    c();
    e();
  }
  
  private void a(ProductItemInfo paramProductItemInfo)
  {
    j.a().a(this.a, this.g, paramProductItemInfo.getClick_url());
    if (ae.a(paramProductItemInfo.getClick_url())) {
      return;
    }
    g localg = new f().a(paramProductItemInfo.getClick_url(), "discovery");
    new com.xiaoenai.app.classes.common.c.e().a(this.a, localg);
    this.i.a(paramProductItemInfo.getId());
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString(paramString);
    if (!ae.a(str))
    {
      this.f = Integer.parseInt(str);
      return;
    }
    this.f = paramJSONObject.optInt(paramString);
  }
  
  private void c()
  {
    this.mProductRecyclerView.a.setBackgroundColor(getResources().getColor(2131493152));
    this.mProductRecyclerView.e.setBackgroundColor(getResources().getColor(2131493152));
    this.mProductRecyclerView.setHasFixedSize(true);
    this.c = new o(this.b.getContext(), this.e);
    this.mProductRecyclerView.setAdapter(this.c);
    this.i = new bo(this);
    this.h = new com.xiaoenai.app.classes.street.widget.viewHolder.e(getResources().getDrawable(2130837829), getItemMargin(), this.e, this.c);
  }
  
  private void d()
  {
    Object localObject;
    if (1 == this.e) {
      localObject = new LinearLayoutManager(this.b.getContext());
    }
    for (;;)
    {
      this.mProductRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
      this.mProductRecyclerView.b(this.h);
      this.mProductRecyclerView.a(this.h);
      return;
      localObject = new BasicGridLayoutManager(this.b.getContext(), 2, this.c);
      ((BasicGridLayoutManager)localObject).setSpanSizeLookup(new bb(this, (RecyclerView.LayoutManager)localObject));
    }
  }
  
  private void e()
  {
    this.d = new bc(this);
    this.c.a(this.d);
    this.c.a(new bd(this));
    this.mProductRecyclerView.a.setPtrHandler(new be(this));
    this.mProductRecyclerView.setOnLoadMoreListener(new bg(this));
  }
  
  private void getData()
  {
    if (this.e == 0)
    {
      this.j = b(this.f, this.e);
      a.c("street_get_new_scene_product_list_ts {} {} {} ", new Object[] { a(this.e), Integer.valueOf(this.f), Long.valueOf(this.j) });
      if (this.j != -1L) {
        this.i.a(this.f, this.j);
      }
    }
    JSONObject localJSONObject = a(this.f, this.e);
    if (localJSONObject != null)
    {
      b();
      this.i.a(localJSONObject, false, this.f, this.e);
      return;
    }
    this.i.a(0, this.e, this.f);
  }
  
  private int getItemMargin()
  {
    if (1 == this.e) {
      return 1;
    }
    return ab.a(6.0F);
  }
  
  private void setParamData(String paramString)
  {
    if (!ae.a(paramString))
    {
      this.g = paramString;
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString == null) {
          return;
        }
        str = paramString.optString("module_id");
        if (ae.a(str)) {
          return;
        }
        if (str.equalsIgnoreCase("xiaoenai.life.scene"))
        {
          this.e = 0;
          a(paramString, "scene_id");
          return;
        }
        if (str.equalsIgnoreCase("xiaoenai.life.special"))
        {
          this.e = 1;
          a(paramString, "special_id");
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (str.equalsIgnoreCase("xiaoenai.life.activity"))
      {
        this.e = 2;
        a(paramString, "activity_id");
      }
    }
  }
  
  public String a(int paramInt)
  {
    String str = "xiaoenai.life.scene";
    if (paramInt == 1) {
      str = "xiaoenai.life.special";
    }
    while (paramInt != 2) {
      return str;
    }
    return "xiaoenai.life.activity";
  }
  
  public JSONObject a(int paramInt1, int paramInt2)
  {
    return com.xiaoenai.app.utils.a.d.b("street_scene_product_list_data" + a(paramInt2) + paramInt1);
  }
  
  public void a()
  {
    if (8 == this.mProductRecyclerView.getVisibility()) {
      this.progressView.a();
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if (paramJSONObject != null) {
      if (paramInt2 == 0) {
        com.xiaoenai.app.utils.a.d.a("street_scene_product_list_data" + a(paramInt2) + paramInt1, paramJSONObject, true);
      }
    }
    for (;;)
    {
      com.xiaoenai.app.utils.a.d.a("street_get_new_scene_product_list_ts" + a(paramInt2) + paramInt1, String.valueOf(ak.b()));
      return;
      com.xiaoenai.app.utils.a.d.a("street_scene_product_list_data" + a(paramInt2) + paramInt1, paramJSONObject, 3600, true);
      continue;
      com.xiaoenai.app.utils.a.d.e("street_scene_product_list_data" + a(paramInt2) + paramInt1);
    }
  }
  
  public void a(boolean paramBoolean, List<Object> paramList, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      this.c.c(paramInt);
      this.c.c(paramList);
    }
    while (paramList.size() < 20)
    {
      paramList = new SceneTextType(paramString, 0);
      this.c.a(paramList, this.c.a());
      this.mProductRecyclerView.f();
      return;
      if (this.mProductNewCountTextView.getVisibility() == 0) {
        this.mProductNewCountTextView.setVisibility(8);
      }
      this.c.b(paramInt);
      this.c.a(paramList);
    }
    this.mProductRecyclerView.postDelayed(new bj(this), 300L);
  }
  
  public long b(int paramInt1, int paramInt2)
  {
    return com.xiaoenai.app.utils.a.d.a("street_get_new_scene_product_list_ts" + a(paramInt2) + paramInt1, -1L);
  }
  
  public void b()
  {
    if (8 == this.mProductRecyclerView.getVisibility()) {
      this.mProductRecyclerView.setVisibility(0);
    }
    this.progressView.b();
    this.mProductRecyclerView.a.d();
  }
  
  public void b(int paramInt)
  {
    if (paramInt > 0)
    {
      String str = String.format(this.a.getString(2131101493), new Object[] { Integer.valueOf(paramInt) });
      this.mProductNewCountTextView.setText(str);
      this.mProductNewCountTextView.setVisibility(0);
      return;
    }
    this.mProductNewCountTextView.setVisibility(8);
  }
  
  @OnClick({2131560056})
  void productNewCountTextClick()
  {
    this.mProductNewCountTextView.setVisibility(8);
    this.mProductRecyclerView.a(0);
    this.mProductRecyclerView.postDelayed(new bi(this), 500L);
  }
  
  public void setData(HomeDiscoverItem paramHomeDiscoverItem)
  {
    paramHomeDiscoverItem = new f().a(paramHomeDiscoverItem, null);
    if (paramHomeDiscoverItem != null) {
      setParamData(paramHomeDiscoverItem.e());
    }
    this.c.a(this.e);
    this.h.a(this.e, getItemMargin());
    d();
    getData();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetSceneView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
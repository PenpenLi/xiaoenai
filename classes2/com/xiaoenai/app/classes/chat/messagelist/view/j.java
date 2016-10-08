package com.xiaoenai.app.classes.chat.messagelist.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.chat.history.ChatHisEditActivity;
import com.xiaoenai.app.classes.chat.history.w;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.classes.common.image.imagePreview.ImageViewPager;
import com.xiaoenai.app.classes.settings.feedback.FeedbackPhoto;
import com.xiaoenai.app.d.f;
import com.xiaoenai.app.ui.component.view.MaskableFrameLayout;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.a.b.a;
import com.xiaoenai.app.utils.e.c.d.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class j
  extends BaseItemView
  implements View.OnClickListener
{
  protected MaskableFrameLayout b;
  protected ImageView c;
  private ProgressView d;
  private ImageView e;
  private String f;
  private boolean g = false;
  private int h = 1;
  private int i = 0;
  private int j = 0;
  
  public j(Context paramContext)
  {
    super(paramContext);
    getMessageBody().setOnClickListener(this);
  }
  
  private void a(String paramString, ImageView paramImageView, com.xiaoenai.app.utils.e.a.b paramb)
  {
    if (paramb != null)
    {
      if (b.a.a == paramb.a()) {
        com.xiaoenai.app.utils.e.b.a(paramImageView, paramString, new l(this));
      }
      while (b.a.b != paramb.a()) {
        return;
      }
      paramb = com.xiaoenai.app.utils.k.a(paramString);
      if (paramb != null)
      {
        paramImageView.setImageBitmap(paramb);
        return;
      }
      com.xiaoenai.app.utils.e.b.d(paramString);
      com.xiaoenai.app.utils.e.b.e(paramString);
      com.xiaoenai.app.utils.e.b.a(paramImageView, paramString, new m(this));
      return;
    }
    com.xiaoenai.app.utils.e.b.a(paramImageView, paramString, 2131492898);
  }
  
  private void b()
  {
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.g = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    com.xiaoenai.app.utils.f.a.c("width = {} height = {}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    int m = (int)(ab.b() * 0.3125D);
    int k = ab.a(56.0F);
    com.xiaoenai.app.utils.f.a.c("size = {} minSize = {}", new Object[] { Integer.valueOf(m), Integer.valueOf(k) });
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.width = m;
    localLayoutParams.height = m;
    if (paramInt1 > paramInt2) {
      if (paramInt1 > m)
      {
        localLayoutParams.width = m;
        m = m * paramInt2 / paramInt1;
        if (m < k) {
          localLayoutParams.height = k;
        }
      }
      else
      {
        if ((paramInt1 != 0) && (paramInt2 != 0)) {
          break label241;
        }
        this.i = 0;
        this.j = 0;
      }
    }
    for (;;)
    {
      com.xiaoenai.app.utils.f.a.c("width = {} height = {}", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      this.b.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.height = m;
      break;
      if (paramInt2 <= m) {
        break;
      }
      localLayoutParams.height = m;
      if (paramInt1 == 0) {
        break;
      }
      m = m * paramInt1 / paramInt2;
      if (m < k)
      {
        localLayoutParams.width = k;
        break;
      }
      localLayoutParams.width = m;
      break;
      label241:
      if (paramInt1 > paramInt2)
      {
        this.j = localLayoutParams.height;
        this.i = (this.j * paramInt1 / paramInt2);
      }
      else
      {
        this.i = localLayoutParams.width;
        this.j = (this.i * paramInt2 / paramInt1);
      }
    }
  }
  
  public int getImageViewMaxWidth()
  {
    return (int)(ab.b() * 0.3125D);
  }
  
  public View getMsgContentView()
  {
    View localView = inflate(getContext(), 2130903114, null);
    this.c = ((ImageView)localView.findViewById(2131558851));
    this.b = ((MaskableFrameLayout)localView.findViewById(2131558850));
    this.d = ((ProgressView)localView.findViewById(2131558669));
    this.e = ((ImageView)localView.findViewById(2131558852));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    int m = 0;
    int k = 0;
    com.xiaoenai.app.utils.f.a.c("{}", new Object[] { paramView.getContext() });
    if ((paramView.getContext() instanceof ChatActivity)) {
      ((ChatActivity)paramView.getContext()).f();
    }
    com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)paramView.getTag(2131558412);
    if (locala == null) {}
    for (;;)
    {
      return;
      Object localObject1;
      if (this.h == 1) {
        localObject1 = com.xiaoenai.app.classes.chat.messagelist.a.a().b();
      }
      while ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        Object localObject2 = new Intent(paramView.getContext(), ImageViewPager.class);
        ((Intent)localObject2).putExtra("photo_data", (Serializable)localObject1);
        if ((locala instanceof FeedbackPhoto)) {
          ((Intent)localObject2).putExtra("from", 2);
        }
        for (;;)
        {
          if (k < ((ArrayList)localObject1).size())
          {
            if (locala.a() == ((PhotoMessage)((ArrayList)localObject1).get(k)).a()) {
              ((Intent)localObject2).putExtra("position", k);
            }
          }
          else
          {
            paramView.getContext().startActivity((Intent)localObject2);
            ((Activity)paramView.getContext()).overridePendingTransition(2130968588, 2130968589);
            return;
            if (this.h == 2)
            {
              if (!(paramView.getContext() instanceof ChatHisEditActivity)) {
                break label467;
              }
              localObject2 = ((ChatHisEditActivity)paramView.getContext()).p();
              localObject1 = new ArrayList();
              localObject2 = ((w)localObject2).b().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)((Iterator)localObject2).next();
                if (((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localObject3).b().equals("image")) {
                  ((ArrayList)localObject1).add((PhotoMessage)localObject3);
                }
              }
              localObject2 = new Intent(paramView.getContext(), ImageViewPager.class);
              ((Intent)localObject2).putExtra("photo_data", (Serializable)localObject1);
              ((Intent)localObject2).putExtra("from", 1);
              k = m;
              for (;;)
              {
                if (k < ((ArrayList)localObject1).size())
                {
                  if (locala.h() == ((PhotoMessage)((ArrayList)localObject1).get(k)).h()) {
                    ((Intent)localObject2).putExtra("position", k);
                  }
                }
                else
                {
                  paramView.getContext().startActivity((Intent)localObject2);
                  return;
                }
                k += 1;
              }
            }
            if (this.h != 3) {
              break label467;
            }
            localObject2 = new ArrayList();
            Object localObject3 = new f().a().iterator();
            for (;;)
            {
              localObject1 = localObject2;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localObject1 = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)((Iterator)localObject3).next();
              if (((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localObject1).b().equals("image")) {
                ((ArrayList)localObject2).add((PhotoMessage)localObject1);
              }
            }
            ((Intent)localObject2).putExtra("from", 1);
            continue;
          }
          k += 1;
        }
        label467:
        localObject1 = null;
      }
    }
  }
  
  public void setFrom(int paramInt)
  {
    this.h = paramInt;
    getMessageBody().setOnClickListener(this);
  }
  
  public void setImage(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.startsWith("file://")) {
        if ((this.i == 0) || (this.j == 0)) {
          break label113;
        }
      }
    }
    label113:
    for (str = paramString + "?imageView/1/w/" + this.i + "/h/" + this.j;; str = paramString + "?imageView/2/w/" + getImageViewMaxWidth())
    {
      com.xiaoenai.app.utils.f.a.c("create url = {}", new Object[] { str });
      if ((this.f == null) || (!this.f.equals(str)) || (!this.g)) {
        break;
      }
      return;
    }
    if ((this.f == null) || (!this.f.equals(str))) {
      this.g = false;
    }
    this.f = str;
    com.xiaoenai.app.utils.f.a.c("show url = {}", new Object[] { str });
    this.e.setVisibility(8);
    com.xiaoenai.app.utils.e.b.b(this.c, str, new d.a().b(2131492898).a(), new k(this), null);
  }
  
  public void setImageResource(int paramInt)
  {
    this.c.setImageResource(paramInt);
    if (this.d != null) {
      this.d.b();
    }
  }
  
  public void setUserType(int paramInt)
  {
    super.setUserType(paramInt);
    if (paramInt == 2)
    {
      this.mMessageBody.setBackgroundResource(2130837638);
      this.b.setMask(2130837637);
      this.e.setPadding(ab.a(6.0F), 0, 0, 0);
      this.mRlStatus.setVisibility(8);
      return;
    }
    this.mMessageBody.setBackgroundResource(2130837642);
    this.b.setMask(2130837641);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.mRlStatus.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.mIvStatusFailed.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.mPvStatusSending.getLayoutParams();
    localLayoutParams1.addRule(1, -1);
    localLayoutParams1.addRule(0, this.mMessageBody.getId());
    localLayoutParams2.addRule(12, -1);
    localLayoutParams3.addRule(12, -1);
    this.mIvStatusFailed.setLayoutParams(localLayoutParams2);
    this.mPvStatusSending.setLayoutParams(localLayoutParams3);
    this.e.setPadding(0, 0, ab.a(6.0F), 0);
    this.mRlStatus.setGravity(80);
    this.mRlStatus.setLayoutParams(localLayoutParams1);
    this.mRlStatus.setVisibility(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\view\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
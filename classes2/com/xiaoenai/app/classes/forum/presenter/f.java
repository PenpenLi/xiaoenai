package com.xiaoenai.app.classes.forum.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaoenai.app.classes.forum.ForumReplyActivity;
import com.xiaoenai.app.classes.forum.dm;
import com.xiaoenai.app.classes.forum.widget.ForumMomentContentLayout.a;
import com.xiaoenai.app.model.Forum.Post;
import com.xiaoenai.app.model.Forum.Post.a;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.d.t;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class f
  implements com.xiaoenai.app.ui.component.view.a.e
{
  private Post a;
  private Context b;
  private Fragment c;
  private ForumMomentContentLayout.a d;
  
  private void a(TextView paramTextView, String paramString1, String paramString2)
  {
    Object localObject1 = paramTextView.getResources().getDrawable(2130838446);
    int i;
    SpannableStringBuilder localSpannableStringBuilder;
    if (localObject1 != null)
    {
      i = t.a(paramTextView.getContext(), 16.0F);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      localObject1 = new ImageSpan((Drawable)localObject1, 1);
      localSpannableStringBuilder = new SpannableStringBuilder(paramString1);
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        Iterator localIterator = paramString2.keys();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = localIterator.next().toString();
        Object localObject3 = paramString2.optString((String)localObject2, "");
        com.xiaoenai.app.utils.f.a.c("key = {}", new Object[] { localObject2 });
        com.xiaoenai.app.utils.f.a.c("value = {}", new Object[] { localObject3 });
        localObject3 = new JSONObject((String)localObject3);
        Object localObject4 = ((JSONObject)localObject3).optString("title");
        ((JSONObject)localObject3).optInt("type");
        localObject3 = ((JSONObject)localObject3).optString("value");
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
          continue;
        }
        localObject4 = new SpannableString("icon" + (String)localObject4);
        ((SpannableString)localObject4).setSpan(localObject1, 0, "icon".length(), 17);
        i = localSpannableStringBuilder.toString().indexOf((String)localObject2);
        int j = ((String)localObject2).length() + i;
        com.xiaoenai.app.utils.f.a.c("start = {} end = {} length = {}", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localSpannableStringBuilder.length()) });
        if ((i >= 0) && (j <= localSpannableStringBuilder.length()))
        {
          localSpannableStringBuilder.replace(i, j, (CharSequence)localObject4);
          localObject2 = new com.xiaoenai.app.ui.component.view.a.a();
          ((com.xiaoenai.app.ui.component.view.a.a)localObject2).a(i);
          ((com.xiaoenai.app.ui.component.view.a.a)localObject2).b(i + ((SpannableString)localObject4).length());
          ((com.xiaoenai.app.ui.component.view.a.a)localObject2).a(localSpannableStringBuilder);
          ((com.xiaoenai.app.ui.component.view.a.a)localObject2).a(this);
          ((com.xiaoenai.app.ui.component.view.a.a)localObject2).a(localObject3);
          com.xiaoenai.app.ui.component.view.a.b.a((com.xiaoenai.app.ui.component.view.a.a)localObject2);
          continue;
          return;
        }
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
        com.xiaoenai.app.utils.f.a.a(paramString2.getMessage(), new Object[0]);
        paramTextView.setText(paramString1);
      }
      com.xiaoenai.app.utils.f.a.b("endSpan > length", new Object[0]);
    }
    com.xiaoenai.app.ui.component.view.a.b.a(paramTextView, localSpannableStringBuilder, paramTextView.getResources().getColor(2131492964));
  }
  
  private void c()
  {
    if (!this.c.isAdded()) {
      return;
    }
    com.xiaoenai.app.utils.f.a.c("-------------TopImageUrl-------{}", new Object[] { ((Post.a)this.a.o.get(0)).c() });
    Object localObject1 = this.d.b.getLayoutParams();
    int i = ((Post.a)this.a.o.get(0)).a().intValue();
    ((ViewGroup.LayoutParams)localObject1).height = ((ab.b() - ab.a(20.0F)) * i / ((Post.a)this.a.o.get(0)).b().intValue());
    com.xiaoenai.app.utils.e.b.a(this.d.b, ((Post.a)this.a.o.get(0)).c() + "?imageView/2/w/" + (ab.b() - ab.a(20.0F)), Boolean.valueOf(true));
    this.d.c.setText(this.a.c);
    a(this.d.d, this.a.p, this.a.n);
    Object localObject2 = String.format(as.a(2131100427), new Object[] { Integer.valueOf(this.a.g) });
    localObject1 = this.a.g + "";
    localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
    ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(this.c.getResources().getColor(2131493068)), 0, ((String)localObject1).length(), 34);
    this.d.e.setText((CharSequence)localObject2);
    localObject1 = as.a(2131100429);
    long l = this.a.l - ak.b();
    if (l < 0L)
    {
      this.d.f.setVisibility(8);
      this.d.g.setText(as.a(2131100426));
      if (Build.VERSION.SDK_INT > 15) {
        this.d.g.setBackground(this.c.getResources().getDrawable(2130838417));
      }
      for (;;)
      {
        this.d.g.setClickable(false);
        return;
        this.d.g.setBackgroundResource(2130838417);
      }
    }
    this.d.g.setText(as.a(2131100424));
    localObject1 = String.format((String)localObject1, new Object[] { ak.m(l) });
    this.d.f.setText((CharSequence)localObject1);
    this.d.f.setVisibility(0);
    if (this.a.m)
    {
      this.d.g.setClickable(false);
      this.d.g.setText(as.a(2131100425));
      if (Build.VERSION.SDK_INT > 15)
      {
        this.d.g.setBackground(this.c.getResources().getDrawable(2130838417));
        return;
      }
      this.d.g.setBackgroundResource(2130838417);
      return;
    }
    if (Build.VERSION.SDK_INT > 15) {
      this.d.g.setBackground(this.c.getResources().getDrawable(2130838418));
    }
    for (;;)
    {
      this.d.g.setClickable(true);
      return;
      this.d.g.setBackgroundResource(2130838418);
    }
  }
  
  public void a()
  {
    if (dm.a(this.c.getActivity(), 2))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("forum_topic_id", this.a.b);
      localIntent.putExtra("forum_Reply_type", 2);
      localIntent.setClass(this.b, ForumReplyActivity.class);
      this.c.startActivityForResult(localIntent, 1);
      this.c.getActivity().overridePendingTransition(2130968608, 2130968609);
    }
  }
  
  public void a(View paramView, com.xiaoenai.app.ui.component.view.a.a parama)
  {
    parama = String.valueOf(parama.a());
    com.xiaoenai.app.utils.f.a.c("protocol = {}", new Object[] { parama });
    com.xiaoenai.app.classes.common.c.f localf = new com.xiaoenai.app.classes.common.c.f();
    paramView = new com.xiaoenai.app.classes.common.c.e();
    parama = localf.a(parama, "forum");
    paramView.a(this.b, parama);
  }
  
  public void a(ForumMomentContentLayout.a parama, Context paramContext, Fragment paramFragment)
  {
    this.b = paramContext;
    this.c = paramFragment;
    this.d = parama;
    c();
  }
  
  public void a(Post paramPost)
  {
    this.a = paramPost;
  }
  
  public void b()
  {
    com.xiaoenai.app.classes.extentions.forum.a.b(this.a, this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
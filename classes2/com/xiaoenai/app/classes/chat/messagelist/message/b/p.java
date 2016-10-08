package com.xiaoenai.app.classes.chat.messagelist.message.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.util.Patterns;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.xiaoenai.app.classes.chat.messagelist.message.model.m;
import com.xiaoenai.app.classes.chat.messagelist.view.o;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p
{
  public static final Linkify.MatchFilter a = new r();
  
  private static final String a(String paramString, String[] paramArrayOfString, Matcher paramMatcher, Linkify.TransformFilter paramTransformFilter)
  {
    int k = 1;
    if (paramTransformFilter != null) {}
    for (paramMatcher = paramTransformFilter.transformUrl(paramMatcher, paramString);; paramMatcher = paramString)
    {
      int i = 0;
      int j;
      if (i < paramArrayOfString.length) {
        if (paramMatcher.regionMatches(true, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
        {
          paramString = paramMatcher;
          j = k;
          if (!paramMatcher.regionMatches(false, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
          {
            paramString = paramArrayOfString[i] + paramMatcher.substring(paramArrayOfString[i].length());
            j = k;
          }
        }
      }
      for (;;)
      {
        paramMatcher = paramString;
        if (j == 0) {
          paramMatcher = paramArrayOfString[0] + paramString;
        }
        return paramMatcher;
        i += 1;
        break;
        j = 0;
        paramString = paramMatcher;
      }
    }
  }
  
  private static ArrayList<c> a(TextView paramTextView)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramTextView != null)
    {
      paramTextView = paramTextView.getText();
      if (paramTextView != null) {
        break label65;
      }
      paramTextView = "";
    }
    label65:
    for (;;)
    {
      paramTextView = new SpannableString(paramTextView);
      Pattern localPattern = Patterns.WEB_URL;
      Linkify.MatchFilter localMatchFilter = a;
      a(localArrayList, paramTextView, localPattern, new String[] { "http://", "https://" }, localMatchFilter, null);
      return localArrayList;
    }
  }
  
  private static void a(TextView paramTextView, ArrayList<c> paramArrayList)
  {
    if (paramTextView != null)
    {
      SpannableString localSpannableString = new SpannableString(paramTextView.getText());
      int i = 0;
      while (i < paramArrayList.size())
      {
        localSpannableString.setSpan(new ForegroundColorSpan(-11310200), ((c)paramArrayList.get(i)).b, ((c)paramArrayList.get(i)).c, 33);
        i += 1;
      }
      paramTextView.setText(localSpannableString);
    }
  }
  
  public static void a(m paramm, o paramo, View.OnLongClickListener paramOnLongClickListener)
  {
    paramo.setContentText(paramm.c());
    paramo.setStatus(paramm.f().intValue());
    if (paramo.getContentTextView() != null)
    {
      ArrayList localArrayList = a(paramo.getContentTextView());
      a(paramo.getContentTextView(), localArrayList);
      paramo.getContentTextView().setOnClickListener(new q(localArrayList, paramo));
      paramo.getContentTextView().setTag(2131558412, paramm);
      paramo.getContentTextView().setOnLongClickListener(paramOnLongClickListener);
    }
  }
  
  protected static void a(String paramString, Context paramContext)
  {
    paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
  }
  
  public static final void a(ArrayList<c> paramArrayList, Spannable paramSpannable, Pattern paramPattern, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    paramPattern = paramPattern.matcher(paramSpannable);
    while (paramPattern.find())
    {
      int i = paramPattern.start();
      int j = paramPattern.end();
      if ((paramMatchFilter == null) || (paramMatchFilter.acceptMatch(paramSpannable, i, j)))
      {
        c localc = new c();
        localc.a = a(paramPattern.group(0), paramArrayOfString, paramPattern, paramTransformFilter);
        localc.b = i;
        localc.c = j;
        paramArrayList.add(localc);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
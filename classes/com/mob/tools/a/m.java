package com.mob.tools.a;

import com.mob.tools.b.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;

class m
  implements h
{
  m(l paraml, HashMap paramHashMap) {}
  
  public void a(d paramd)
  {
    int i = paramd.a();
    if ((i == 200) || (i == 201))
    {
      localStringBuilder = new StringBuilder();
      localBufferedReader = new BufferedReader(new InputStreamReader(paramd.b(), Charset.forName("utf-8")));
      for (paramd = localBufferedReader.readLine(); paramd != null; paramd = localBufferedReader.readLine())
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append('\n');
        }
        localStringBuilder.append(paramd);
      }
      localBufferedReader.close();
      this.a.put("resp", localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramd.c(), Charset.forName("utf-8")));
    for (paramd = localBufferedReader.readLine(); paramd != null; paramd = localBufferedReader.readLine())
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append('\n');
      }
      localStringBuilder.append(paramd);
    }
    localBufferedReader.close();
    paramd = new HashMap();
    paramd.put("error", localStringBuilder.toString());
    paramd.put("status", Integer.valueOf(i));
    throw new Throwable(new e().a(paramd));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
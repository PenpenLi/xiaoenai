package com.alibaba.nb.android.trade.service.config.b;

import com.alibaba.nb.android.trade.constants.AliTradeConfigConstant;
import com.alibaba.nb.android.trade.service.config.a.d;
import com.alibaba.nb.android.trade.utils.http.AliTradeHttpHelper;
import com.alibaba.nb.android.trade.utils.http.AliTradeHttpHelper.HttpHelpterException;
import org.json.JSONException;
import org.json.JSONObject;

final class b
  implements Runnable
{
  b(a parama) {}
  
  public final void run()
  {
    try
    {
      if (!AliTradeConfigConstant.getConfigUrl().equals(a.a(this.a))) {
        a.a(this.a, AliTradeConfigConstant.getConfigUrl());
      }
      com.alibaba.nb.android.trade.utils.d.a.b("AliTradeConfigPullProcessor", "开始从网络拉取config数据,url为：" + a.a(this.a));
      Object localObject = new JSONObject(AliTradeHttpHelper.a(a.a(this.a)));
      com.alibaba.nb.android.trade.utils.d.a.b("AliTradeConfigPullProcessor", "网络拉取的config数据为" + ((JSONObject)localObject).toString());
      d locald = new d();
      locald.a((JSONObject)localObject);
      localObject = this.a;
      if (a.a(locald))
      {
        a.b(this.a).a(locald);
        com.alibaba.nb.android.trade.utils.d.a.b("AliTradeConfigPullProcessor", "网络拉取config数据成功");
        return;
      }
      a.b(this.a);
      com.alibaba.nb.android.trade.utils.d.a.d("AliTradeConfigPullProcessor", "config文件校验失败");
      return;
    }
    catch (AliTradeHttpHelper.HttpHelpterException localHttpHelpterException)
    {
      com.alibaba.nb.android.trade.utils.d.a.d("AliTradeConfigPullProcessor", "获取Http网络错误" + localHttpHelpterException.getMessage());
      a.b(this.a);
      localHttpHelpterException.getMessage();
      return;
    }
    catch (JSONException localJSONException)
    {
      com.alibaba.nb.android.trade.utils.d.a.d("AliTradeConfigPullProcessor", "解析JSON出错" + localJSONException.getMessage());
      a.b(this.a);
      localJSONException.getMessage();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\service\config\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.alibaba.nb.android.trade.model;

import java.io.Serializable;
import java.util.List;

public class AliPayResult
  implements Serializable
{
  public List<Long> payFailedOrders;
  public List<Long> paySuccessOrders;
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\model\AliPayResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
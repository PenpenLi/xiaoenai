package com.xiaoenai.app.classes.street;

import android.content.Context;
import com.xiaoenai.app.classes.street.a.e;
import com.xiaoenai.app.classes.street.model.Track;
import org.json.JSONArray;
import org.json.JSONObject;

class bi
  extends com.xiaoenai.app.net.m
{
  bi(StreetDeliveryActivity paramStreetDeliveryActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    Track[] arrayOfTrack = new Track[paramJSONObject.length()];
    int i = 0;
    for (;;)
    {
      if (i < paramJSONObject.length())
      {
        arrayOfTrack[i] = new Track();
        try
        {
          arrayOfTrack[i].fromJson(Track.class, paramJSONObject.optJSONObject(i), arrayOfTrack[i]);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    StreetDeliveryActivity.b(this.a).a(arrayOfTrack);
    com.xiaoenai.app.utils.m.a(StreetDeliveryActivity.d(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
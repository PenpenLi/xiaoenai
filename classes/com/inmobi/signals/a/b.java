package com.inmobi.signals.a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static final String a = b.class.getSimpleName();
  private String b;
  private int c;
  private int d;
  
  public b() {}
  
  @TargetApi(18)
  public b(CellInfo paramCellInfo, String paramString1, String paramString2, int paramInt)
  {
    if ((paramCellInfo instanceof CellInfoGsm))
    {
      this.d = paramInt;
      paramCellInfo = (CellInfoGsm)paramCellInfo;
      this.c = paramCellInfo.getCellSignalStrength().getDbm();
      paramCellInfo = paramCellInfo.getCellIdentity();
      this.b = a(paramString1, paramString2, paramCellInfo.getLac(), paramCellInfo.getCid(), -1, Integer.MAX_VALUE);
    }
    do
    {
      do
      {
        return;
        if ((paramCellInfo instanceof CellInfoCdma))
        {
          this.d = paramInt;
          paramCellInfo = (CellInfoCdma)paramCellInfo;
          this.c = paramCellInfo.getCellSignalStrength().getDbm();
          paramCellInfo = paramCellInfo.getCellIdentity();
          this.b = a(paramString1, paramCellInfo.getSystemId(), paramCellInfo.getNetworkId(), paramCellInfo.getBasestationId());
          return;
        }
        if (Build.VERSION.SDK_INT < 18) {
          break;
        }
      } while (!(paramCellInfo instanceof CellInfoWcdma));
      this.d = paramInt;
      paramCellInfo = (CellInfoWcdma)paramCellInfo;
      this.c = paramCellInfo.getCellSignalStrength().getDbm();
      paramCellInfo = paramCellInfo.getCellIdentity();
      this.b = a(paramString1, paramString2, paramCellInfo.getLac(), paramCellInfo.getCid(), paramCellInfo.getPsc(), Integer.MAX_VALUE);
      return;
    } while (!(paramCellInfo instanceof CellInfoLte));
    this.d = paramInt;
    paramCellInfo = (CellInfoLte)paramCellInfo;
    this.c = paramCellInfo.getCellSignalStrength().getDbm();
    paramCellInfo = paramCellInfo.getCellIdentity();
    this.b = a(paramString1, paramString2, paramCellInfo.getTac(), paramCellInfo.getCi(), -1, paramCellInfo.getPci());
  }
  
  public String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return paramString + "#" + paramInt1 + "#" + paramInt2 + "#" + paramInt3;
  }
  
  public String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramString2 = new StringBuilder().append(paramString1).append("#").append(paramString2).append("#").append(paramInt1).append("#").append(paramInt2).append("#");
    if (paramInt3 == -1)
    {
      paramString1 = "";
      paramString2 = paramString2.append(paramString1).append("#");
      if (paramInt4 != Integer.MAX_VALUE) {
        break label93;
      }
    }
    label93:
    for (paramString1 = "";; paramString1 = Integer.valueOf(paramInt4))
    {
      return paramString1;
      paramString1 = Integer.valueOf(paramInt3);
      break;
    }
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.b);
      if (this.c != Integer.MAX_VALUE) {
        localJSONObject.put("ss", this.c);
      }
      localJSONObject.put("nt", this.d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while converting CellTowerInfo to string.", localJSONException);
    }
    return localJSONObject;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
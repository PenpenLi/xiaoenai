package com.inmobi.ads;

import android.support.annotation.NonNull;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class InMobiStrandPositioning
{
  private static final String TAG = InMobiStrandPositioning.class.getSimpleName();
  
  public static class InMobiClientPositioning
  {
    public static final int NO_REPEAT = Integer.MAX_VALUE;
    private static final String TAG = InMobiClientPositioning.class.getSimpleName();
    private List<Integer> mAdPositions = new ArrayList();
    private int mRepeatInterval = Integer.MAX_VALUE;
    
    @NonNull
    public InMobiClientPositioning addFixedPosition(int paramInt)
    {
      if (paramInt < 0) {
        Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Ad positions must be non-negative");
      }
      int i;
      do
      {
        return this;
        i = Collections.binarySearch(this.mAdPositions, Integer.valueOf(paramInt));
      } while (i >= 0);
      this.mAdPositions.add(i ^ 0xFFFFFFFF, Integer.valueOf(paramInt));
      return this;
    }
    
    @NonNull
    public InMobiClientPositioning enableRepeatingPositions(int paramInt)
    {
      if (paramInt <= 1)
      {
        Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Repeating interval must be greater than 1");
        this.mRepeatInterval = Integer.MAX_VALUE;
        return this;
      }
      this.mRepeatInterval = paramInt;
      return this;
    }
    
    @NonNull
    List<Integer> getFixedPositions()
    {
      return this.mAdPositions;
    }
    
    int getRepeatingInterval()
    {
      return this.mRepeatInterval;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiStrandPositioning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
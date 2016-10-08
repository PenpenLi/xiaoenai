package com.inmobi.rendering;

public class RenderingProperties
{
  private PlacementType a;
  
  public RenderingProperties(PlacementType paramPlacementType)
  {
    this.a = paramPlacementType;
  }
  
  public PlacementType a()
  {
    return this.a;
  }
  
  public static enum PlacementType
  {
    FULL_SCREEN,  INLINE;
    
    private PlacementType() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\RenderingProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
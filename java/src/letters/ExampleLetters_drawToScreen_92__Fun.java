package letters;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class ExampleLetters_drawToScreen_92__Fun extends haxe.lang.Function
{
	public    ExampleLetters_drawToScreen_92__Fun(haxe.root.Array<haxe.root.Array> path)
	{
		super(1, 0);
		this.path = path;
	}
	
	
	@Override public   java.lang.Object __hx_invoke1_o(double __fn_float1, java.lang.Object __fn_dyn1)
	{
		java.awt.Graphics2D g2D = ( (( __fn_dyn1 == haxe.lang.Runtime.undefined )) ? (((java.awt.Graphics2D) (((java.lang.Object) (__fn_float1) )) )) : (((java.awt.Graphics2D) (__fn_dyn1) )) );
		java.awt.geom.GeneralPath gPath = new java.awt.geom.GeneralPath();
		haxe.root.Array<java.lang.Object> p = null;
		{
			int _g = 0;
			while (( _g < this.path.__get(0).length ))
			{
				java.lang.Object cmd = this.path.__get(0).__get(_g);
				 ++ _g;
				p = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(cmd, "v0", true)) );
				{
					java.lang.String _g1 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(cmd, "v1", true));
					{
						java.lang.String __temp_svar165 = (_g1);
						boolean __temp_executeDef166 = true;
						switch (__temp_svar165.hashCode())
						{
							case 77:
							{
								if (__temp_svar165.equals("M")) 
								{
									__temp_executeDef166 = false;
									gPath.moveTo(((double) (haxe.lang.Runtime.toDouble(p.__get(0))) ), ((double) (haxe.lang.Runtime.toDouble(p.__get(1))) ));
								}
								
								break;
							}
							
							
							case 81:
							{
								if (__temp_svar165.equals("Q")) 
								{
									__temp_executeDef166 = false;
									gPath.quadTo(((double) (haxe.lang.Runtime.toDouble(p.__get(0))) ), ((double) (haxe.lang.Runtime.toDouble(p.__get(1))) ), ((double) (haxe.lang.Runtime.toDouble(p.__get(2))) ), ((double) (haxe.lang.Runtime.toDouble(p.__get(3))) ));
								}
								
								break;
							}
							
							
							case 76:
							{
								if (__temp_svar165.equals("L")) 
								{
									__temp_executeDef166 = false;
									gPath.lineTo(((double) (haxe.lang.Runtime.toDouble(p.__get(0))) ), ((double) (haxe.lang.Runtime.toDouble(p.__get(1))) ));
								}
								
								break;
							}
							
							
						}
						
						if (__temp_executeDef166) 
						{
							{
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
		gPath.closePath();
		g2D.setColor(((java.awt.Color) (java.awt.Color.ORANGE) ));
		g2D.fill(((java.awt.Shape) (gPath) ));
		g2D.dispose();
		return null;
	}
	
	
	public  haxe.root.Array<haxe.root.Array> path;
	
}



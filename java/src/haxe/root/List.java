package haxe.root;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class List<T> extends haxe.lang.HxObject
{
	public    List(haxe.lang.EmptyObject empty)
	{
		{
		}
		
	}
	
	
	public    List()
	{
		haxe.root.List.__hx_ctor__List(this);
	}
	
	
	public static  <T_c> void __hx_ctor__List(haxe.root.List<T_c> __temp_me3)
	{
		__temp_me3.length = 0;
	}
	
	
	public static   java.lang.Object __hx_createEmpty()
	{
		return new haxe.root.List<java.lang.Object>(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
	}
	
	
	public static   java.lang.Object __hx_create(haxe.root.Array arr)
	{
		return new haxe.root.List<java.lang.Object>();
	}
	
	
	public  haxe.root.Array h;
	
	public  haxe.root.Array q;
	
	public  int length;
	
	public   void add(T item)
	{
		haxe.root.Array x = new haxe.root.Array(new java.lang.Object[]{item});
		if (( this.h == null )) 
		{
			this.h = x;
		}
		 else 
		{
			this.q.__set(1, x);
		}
		
		this.q = x;
		this.length++;
	}
	
	
	@Override public   double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		{
			boolean __temp_executeDef67 = true;
			switch (field.hashCode())
			{
				case -1106363674:
				{
					if (field.equals("length")) 
					{
						__temp_executeDef67 = false;
						this.length = ((int) (value) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef67) 
			{
				return super.__hx_setField_f(field, value, handleProperties);
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	@Override public   java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		{
			boolean __temp_executeDef68 = true;
			switch (field.hashCode())
			{
				case -1106363674:
				{
					if (field.equals("length")) 
					{
						__temp_executeDef68 = false;
						this.length = ((int) (haxe.lang.Runtime.toInt(value)) );
						return value;
					}
					
					break;
				}
				
				
				case 104:
				{
					if (field.equals("h")) 
					{
						__temp_executeDef68 = false;
						this.h = ((haxe.root.Array) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 113:
				{
					if (field.equals("q")) 
					{
						__temp_executeDef68 = false;
						this.q = ((haxe.root.Array) (value) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef68) 
			{
				return super.__hx_setField(field, value, handleProperties);
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	@Override public   java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		{
			boolean __temp_executeDef69 = true;
			switch (field.hashCode())
			{
				case 96417:
				{
					if (field.equals("add")) 
					{
						__temp_executeDef69 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("add"))) );
					}
					
					break;
				}
				
				
				case 104:
				{
					if (field.equals("h")) 
					{
						__temp_executeDef69 = false;
						return this.h;
					}
					
					break;
				}
				
				
				case -1106363674:
				{
					if (field.equals("length")) 
					{
						__temp_executeDef69 = false;
						return this.length;
					}
					
					break;
				}
				
				
				case 113:
				{
					if (field.equals("q")) 
					{
						__temp_executeDef69 = false;
						return this.q;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef69) 
			{
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	@Override public   double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		{
			boolean __temp_executeDef70 = true;
			switch (field.hashCode())
			{
				case -1106363674:
				{
					if (field.equals("length")) 
					{
						__temp_executeDef70 = false;
						return ((double) (this.length) );
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef70) 
			{
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	@Override public   java.lang.Object __hx_invokeField(java.lang.String field, haxe.root.Array dynargs)
	{
		{
			boolean __temp_executeDef71 = true;
			switch (field.hashCode())
			{
				case 96417:
				{
					if (field.equals("add")) 
					{
						__temp_executeDef71 = false;
						this.add(((T) (dynargs.__get(0)) ));
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef71) 
			{
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		return null;
	}
	
	
	@Override public   void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		baseArr.push("length");
		baseArr.push("q");
		baseArr.push("h");
		{
			super.__hx_getFields(baseArr);
		}
		
	}
	
	
}



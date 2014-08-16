package haxe.root;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class Lambda extends haxe.lang.HxObject
{
	public    Lambda(haxe.lang.EmptyObject empty)
	{
		{
		}
		
	}
	
	
	public    Lambda()
	{
		haxe.root.Lambda.__hx_ctor__Lambda(this);
	}
	
	
	public static   void __hx_ctor__Lambda(haxe.root.Lambda __temp_me3)
	{
		{
		}
		
	}
	
	
	public static  <A> haxe.root.Array<A> array(java.lang.Object it)
	{
		haxe.root.Array<A> a = new haxe.root.Array<A>();
		{
			java.lang.Object __temp_iterator21 = ((java.lang.Object) (haxe.lang.Runtime.callField(it, "iterator", null)) );
			while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator21, "hasNext", null)))
			{
				A i = ((A) (haxe.lang.Runtime.callField(__temp_iterator21, "next", null)) );
				a.push(i);
			}
			
		}
		
		return a;
	}
	
	
	public static  <A, B> haxe.root.List<B> map(java.lang.Object it, haxe.lang.Function f)
	{
		haxe.root.List<B> l = new haxe.root.List<B>();
		{
			java.lang.Object __temp_iterator22 = ((java.lang.Object) (haxe.lang.Runtime.callField(it, "iterator", null)) );
			while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator22, "hasNext", null)))
			{
				A x = ((A) (haxe.lang.Runtime.callField(__temp_iterator22, "next", null)) );
				l.add(((B) (f.__hx_invoke1_o(0.0, x)) ));
			}
			
		}
		
		return l;
	}
	
	
	public static   java.lang.Object __hx_createEmpty()
	{
		return new haxe.root.Lambda(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
	}
	
	
	public static   java.lang.Object __hx_create(haxe.root.Array arr)
	{
		return new haxe.root.Lambda();
	}
	
	
}



package haxe.root;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class Array_iterator_381__Fun<T> extends haxe.lang.Function
{
	public    Array_iterator_381__Fun(haxe.root.Array<java.lang.Object> i, haxe.root.Array<haxe.root.Array> _g)
	{
		super(0, 0);
		this.i = i;
		this._g = _g;
	}
	
	
	@Override public   java.lang.Object __hx_invoke0_o()
	{
		T[] __temp_stmt64 = ((haxe.root.Array<T>) (((haxe.root.Array) (this._g.__get(0)) )) ).__a;
		int __temp_stmt65 = 0;
		{
			int __temp_arrIndex21 = 0;
			int __temp_arrVal19 = ((int) (haxe.lang.Runtime.toInt(this.i.__get(__temp_arrIndex21))) );
			int __temp_arrRet20 = __temp_arrVal19++;
			int __temp_expr66 = ((int) (haxe.lang.Runtime.toInt(this.i.__set(__temp_arrIndex21, __temp_arrVal19))) );
			__temp_stmt65 = __temp_arrRet20;
		}
		
		return __temp_stmt64[__temp_stmt65];
	}
	
	
	public  haxe.root.Array<java.lang.Object> i;
	
	public  haxe.root.Array<haxe.root.Array> _g;
	
}



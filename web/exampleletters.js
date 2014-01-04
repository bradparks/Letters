(function () { "use strict";
var $hxClasses = {},$estr = function() { return js.Boot.__string_rec(this,''); };
var HxOverrides = function() { };
$hxClasses["HxOverrides"] = HxOverrides;
HxOverrides.__name__ = true;
HxOverrides.strDate = function(s) {
	var _g = s.length;
	switch(_g) {
	case 8:
		var k = s.split(":");
		var d = new Date();
		d.setTime(0);
		d.setUTCHours(k[0]);
		d.setUTCMinutes(k[1]);
		d.setUTCSeconds(k[2]);
		return d;
	case 10:
		var k = s.split("-");
		return new Date(k[0],k[1] - 1,k[2],0,0,0);
	case 19:
		var k = s.split(" ");
		var y = k[0].split("-");
		var t = k[1].split(":");
		return new Date(y[0],y[1] - 1,y[2],t[0],t[1],t[2]);
	default:
		throw "Invalid date format : " + s;
	}
};
HxOverrides.cca = function(s,index) {
	var x = s.charCodeAt(index);
	if(x != x) return undefined;
	return x;
};
HxOverrides.substr = function(s,pos,len) {
	if(pos != null && pos != 0 && len != null && len < 0) return "";
	if(len == null) len = s.length;
	if(pos < 0) {
		pos = s.length + pos;
		if(pos < 0) pos = 0;
	} else if(len < 0) len = s.length + len - pos;
	return s.substr(pos,len);
};
HxOverrides.iter = function(a) {
	return { cur : 0, arr : a, hasNext : function() {
		return this.cur < this.arr.length;
	}, next : function() {
		return this.arr[this.cur++];
	}};
};
var Lambda = function() { };
$hxClasses["Lambda"] = Lambda;
Lambda.__name__ = true;
Lambda.array = function(it) {
	var a = new Array();
	var $it0 = $iterator(it)();
	while( $it0.hasNext() ) {
		var i = $it0.next();
		a.push(i);
	}
	return a;
};
var List = function() {
	this.length = 0;
};
$hxClasses["List"] = List;
List.__name__ = true;
List.prototype = {
	add: function(item) {
		var x = [item];
		if(this.h == null) this.h = x; else this.q[1] = x;
		this.q = x;
		this.length++;
	}
	,__class__: List
};
var IMap = function() { };
$hxClasses["IMap"] = IMap;
IMap.__name__ = true;
Math.__name__ = true;
var Reflect = function() { };
$hxClasses["Reflect"] = Reflect;
Reflect.__name__ = true;
Reflect.isFunction = function(f) {
	return typeof(f) == "function" && !(f.__name__ || f.__ename__);
};
var Std = function() { };
$hxClasses["Std"] = Std;
Std.__name__ = true;
Std.string = function(s) {
	return js.Boot.__string_rec(s,"");
};
Std.parseInt = function(x) {
	var v = parseInt(x,10);
	if(v == 0 && (HxOverrides.cca(x,1) == 120 || HxOverrides.cca(x,1) == 88)) v = parseInt(x);
	if(isNaN(v)) return null;
	return v;
};
Std.parseFloat = function(x) {
	return parseFloat(x);
};
var StringTools = function() { };
$hxClasses["StringTools"] = StringTools;
StringTools.__name__ = true;
StringTools.urlDecode = function(s) {
	return decodeURIComponent(s.split("+").join(" "));
};
StringTools.hex = function(n,digits) {
	var s = "";
	var hexChars = "0123456789ABCDEF";
	do {
		s = hexChars.charAt(n & 15) + s;
		n >>>= 4;
	} while(n > 0);
	if(digits != null) while(s.length < digits) s = "0" + s;
	return s;
};
var Type = function() { };
$hxClasses["Type"] = Type;
Type.__name__ = true;
Type.resolveClass = function(name) {
	var cl = $hxClasses[name];
	if(cl == null || !cl.__name__) return null;
	return cl;
};
Type.resolveEnum = function(name) {
	var e = $hxClasses[name];
	if(e == null || !e.__ename__) return null;
	return e;
};
Type.createEmptyInstance = function(cl) {
	function empty() {}; empty.prototype = cl.prototype;
	return new empty();
};
Type.createEnum = function(e,constr,params) {
	var f;
	var v = null;
	try {
		v = e[constr];
	} catch( e1 ) {
	}
	f = v;
	if(f == null) throw "No such constructor " + constr;
	if(Reflect.isFunction(f)) {
		if(params == null) throw "Constructor " + constr + " need parameters";
		return f.apply(e,params);
	}
	if(params != null && params.length != 0) throw "Constructor " + constr + " does not need parameters";
	return f;
};
Type.getEnumConstructs = function(e) {
	var a = e.__constructs__;
	return a.slice();
};
var haxe = {};
haxe.Resource = function() { };
$hxClasses["haxe.Resource"] = haxe.Resource;
haxe.Resource.__name__ = true;
haxe.Resource.getString = function(name) {
	var _g = 0;
	var _g1 = haxe.Resource.content;
	while(_g < _g1.length) {
		var x = _g1[_g];
		++_g;
		if(x.name == name) {
			if(x.str != null) return x.str;
			var b = haxe.Unserializer.run(x.data);
			return b.toString();
		}
	}
	return null;
};
haxe.Unserializer = function(buf) {
	this.buf = buf;
	this.length = buf.length;
	this.pos = 0;
	this.scache = new Array();
	this.cache = new Array();
	var r = haxe.Unserializer.DEFAULT_RESOLVER;
	if(r == null) {
		r = Type;
		haxe.Unserializer.DEFAULT_RESOLVER = r;
	}
	this.setResolver(r);
};
$hxClasses["haxe.Unserializer"] = haxe.Unserializer;
haxe.Unserializer.__name__ = true;
haxe.Unserializer.initCodes = function() {
	var codes = new Array();
	var _g1 = 0;
	var _g = haxe.Unserializer.BASE64.length;
	while(_g1 < _g) {
		var i = _g1++;
		codes[haxe.Unserializer.BASE64.charCodeAt(i)] = i;
	}
	return codes;
};
haxe.Unserializer.run = function(v) {
	return new haxe.Unserializer(v).unserialize();
};
haxe.Unserializer.prototype = {
	setResolver: function(r) {
		if(r == null) this.resolver = { resolveClass : function(_) {
			return null;
		}, resolveEnum : function(_) {
			return null;
		}}; else this.resolver = r;
	}
	,readDigits: function() {
		var k = 0;
		var s = false;
		var fpos = this.pos;
		while(true) {
			var c = this.buf.charCodeAt(this.pos);
			if(c != c) break;
			if(c == 45) {
				if(this.pos != fpos) break;
				s = true;
				this.pos++;
				continue;
			}
			if(c < 48 || c > 57) break;
			k = k * 10 + (c - 48);
			this.pos++;
		}
		if(s) k *= -1;
		return k;
	}
	,unserializeObject: function(o) {
		while(true) {
			if(this.pos >= this.length) throw "Invalid object";
			if(this.buf.charCodeAt(this.pos) == 103) break;
			var k = this.unserialize();
			if(!js.Boot.__instanceof(k,String)) throw "Invalid object key";
			var v = this.unserialize();
			o[k] = v;
		}
		this.pos++;
	}
	,unserializeEnum: function(edecl,tag) {
		if((function($this) {
			var $r;
			var p = $this.pos++;
			$r = $this.buf.charCodeAt(p);
			return $r;
		}(this)) != 58) throw "Invalid enum format";
		var nargs = this.readDigits();
		if(nargs == 0) return Type.createEnum(edecl,tag);
		var args = new Array();
		while(nargs-- > 0) args.push(this.unserialize());
		return Type.createEnum(edecl,tag,args);
	}
	,unserialize: function() {
		var _g;
		var p = this.pos++;
		_g = this.buf.charCodeAt(p);
		switch(_g) {
		case 110:
			return null;
		case 116:
			return true;
		case 102:
			return false;
		case 122:
			return 0;
		case 105:
			return this.readDigits();
		case 100:
			var p1 = this.pos;
			while(true) {
				var c = this.buf.charCodeAt(this.pos);
				if(c >= 43 && c < 58 || c == 101 || c == 69) this.pos++; else break;
			}
			return Std.parseFloat(HxOverrides.substr(this.buf,p1,this.pos - p1));
		case 121:
			var len = this.readDigits();
			if((function($this) {
				var $r;
				var p = $this.pos++;
				$r = $this.buf.charCodeAt(p);
				return $r;
			}(this)) != 58 || this.length - this.pos < len) throw "Invalid string length";
			var s = HxOverrides.substr(this.buf,this.pos,len);
			this.pos += len;
			s = StringTools.urlDecode(s);
			this.scache.push(s);
			return s;
		case 107:
			return Math.NaN;
		case 109:
			return Math.NEGATIVE_INFINITY;
		case 112:
			return Math.POSITIVE_INFINITY;
		case 97:
			var buf = this.buf;
			var a = new Array();
			this.cache.push(a);
			while(true) {
				var c = this.buf.charCodeAt(this.pos);
				if(c == 104) {
					this.pos++;
					break;
				}
				if(c == 117) {
					this.pos++;
					var n = this.readDigits();
					a[a.length + n - 1] = null;
				} else a.push(this.unserialize());
			}
			return a;
		case 111:
			var o = { };
			this.cache.push(o);
			this.unserializeObject(o);
			return o;
		case 114:
			var n = this.readDigits();
			if(n < 0 || n >= this.cache.length) throw "Invalid reference";
			return this.cache[n];
		case 82:
			var n = this.readDigits();
			if(n < 0 || n >= this.scache.length) throw "Invalid string reference";
			return this.scache[n];
		case 120:
			throw this.unserialize();
			break;
		case 99:
			var name = this.unserialize();
			var cl = this.resolver.resolveClass(name);
			if(cl == null) throw "Class not found " + name;
			var o = Type.createEmptyInstance(cl);
			this.cache.push(o);
			this.unserializeObject(o);
			return o;
		case 119:
			var name = this.unserialize();
			var edecl = this.resolver.resolveEnum(name);
			if(edecl == null) throw "Enum not found " + name;
			var e = this.unserializeEnum(edecl,this.unserialize());
			this.cache.push(e);
			return e;
		case 106:
			var name = this.unserialize();
			var edecl = this.resolver.resolveEnum(name);
			if(edecl == null) throw "Enum not found " + name;
			this.pos++;
			var index = this.readDigits();
			var tag = Type.getEnumConstructs(edecl)[index];
			if(tag == null) throw "Unknown enum index " + name + "@" + index;
			var e = this.unserializeEnum(edecl,tag);
			this.cache.push(e);
			return e;
		case 108:
			var l = new List();
			this.cache.push(l);
			var buf = this.buf;
			while(this.buf.charCodeAt(this.pos) != 104) l.add(this.unserialize());
			this.pos++;
			return l;
		case 98:
			var h = new haxe.ds.StringMap();
			this.cache.push(h);
			var buf = this.buf;
			while(this.buf.charCodeAt(this.pos) != 104) {
				var s = this.unserialize();
				h.set(s,this.unserialize());
			}
			this.pos++;
			return h;
		case 113:
			var h = new haxe.ds.IntMap();
			this.cache.push(h);
			var buf = this.buf;
			var c;
			var p = this.pos++;
			c = this.buf.charCodeAt(p);
			while(c == 58) {
				var i = this.readDigits();
				h.set(i,this.unserialize());
				var p = this.pos++;
				c = this.buf.charCodeAt(p);
			}
			if(c != 104) throw "Invalid IntMap format";
			return h;
		case 77:
			var h = new haxe.ds.ObjectMap();
			this.cache.push(h);
			var buf = this.buf;
			while(this.buf.charCodeAt(this.pos) != 104) {
				var s = this.unserialize();
				h.set(s,this.unserialize());
			}
			this.pos++;
			return h;
		case 118:
			var d;
			var s = HxOverrides.substr(this.buf,this.pos,19);
			d = HxOverrides.strDate(s);
			this.cache.push(d);
			this.pos += 19;
			return d;
		case 115:
			var len = this.readDigits();
			var buf = this.buf;
			if((function($this) {
				var $r;
				var p = $this.pos++;
				$r = $this.buf.charCodeAt(p);
				return $r;
			}(this)) != 58 || this.length - this.pos < len) throw "Invalid bytes length";
			var codes = haxe.Unserializer.CODES;
			if(codes == null) {
				codes = haxe.Unserializer.initCodes();
				haxe.Unserializer.CODES = codes;
			}
			var i = this.pos;
			var rest = len & 3;
			var size;
			size = (len >> 2) * 3 + (rest >= 2?rest - 1:0);
			var max = i + (len - rest);
			var bytes = haxe.io.Bytes.alloc(size);
			var bpos = 0;
			while(i < max) {
				var c1 = codes[(function($this) {
					var $r;
					var index = i++;
					$r = buf.charCodeAt(index);
					return $r;
				}(this))];
				var c2 = codes[(function($this) {
					var $r;
					var index = i++;
					$r = buf.charCodeAt(index);
					return $r;
				}(this))];
				var pos = bpos++;
				bytes.b[pos] = (c1 << 2 | c2 >> 4) & 255;
				var c3 = codes[(function($this) {
					var $r;
					var index = i++;
					$r = buf.charCodeAt(index);
					return $r;
				}(this))];
				var pos = bpos++;
				bytes.b[pos] = (c2 << 4 | c3 >> 2) & 255;
				var c4 = codes[(function($this) {
					var $r;
					var index = i++;
					$r = buf.charCodeAt(index);
					return $r;
				}(this))];
				var pos = bpos++;
				bytes.b[pos] = (c3 << 6 | c4) & 255;
			}
			if(rest >= 2) {
				var c1 = codes[(function($this) {
					var $r;
					var index = i++;
					$r = buf.charCodeAt(index);
					return $r;
				}(this))];
				var c2 = codes[(function($this) {
					var $r;
					var index = i++;
					$r = buf.charCodeAt(index);
					return $r;
				}(this))];
				var pos = bpos++;
				bytes.b[pos] = (c1 << 2 | c2 >> 4) & 255;
				if(rest == 3) {
					var c3 = codes[(function($this) {
						var $r;
						var index = i++;
						$r = buf.charCodeAt(index);
						return $r;
					}(this))];
					var pos = bpos++;
					bytes.b[pos] = (c2 << 4 | c3 >> 2) & 255;
				}
			}
			this.pos += len;
			this.cache.push(bytes);
			return bytes;
		case 67:
			var name = this.unserialize();
			var cl = this.resolver.resolveClass(name);
			if(cl == null) throw "Class not found " + name;
			var o = Type.createEmptyInstance(cl);
			this.cache.push(o);
			o.hxUnserialize(this);
			if((function($this) {
				var $r;
				var p = $this.pos++;
				$r = $this.buf.charCodeAt(p);
				return $r;
			}(this)) != 103) throw "Invalid custom data";
			return o;
		default:
		}
		this.pos--;
		throw "Invalid char " + this.buf.charAt(this.pos) + " at position " + this.pos;
	}
	,__class__: haxe.Unserializer
};
haxe.ds = {};
haxe.ds.IntMap = function() {
	this.h = { };
};
$hxClasses["haxe.ds.IntMap"] = haxe.ds.IntMap;
haxe.ds.IntMap.__name__ = true;
haxe.ds.IntMap.__interfaces__ = [IMap];
haxe.ds.IntMap.prototype = {
	set: function(key,value) {
		this.h[key] = value;
	}
	,__class__: haxe.ds.IntMap
};
haxe.ds.ObjectMap = function() {
	this.h = { };
	this.h.__keys__ = { };
};
$hxClasses["haxe.ds.ObjectMap"] = haxe.ds.ObjectMap;
haxe.ds.ObjectMap.__name__ = true;
haxe.ds.ObjectMap.__interfaces__ = [IMap];
haxe.ds.ObjectMap.prototype = {
	set: function(key,value) {
		var id;
		if(key.__id__ != null) id = key.__id__; else id = key.__id__ = ++haxe.ds.ObjectMap.count;
		this.h[id] = value;
		this.h.__keys__[id] = key;
	}
	,__class__: haxe.ds.ObjectMap
};
haxe.ds.StringMap = function() {
	this.h = { };
};
$hxClasses["haxe.ds.StringMap"] = haxe.ds.StringMap;
haxe.ds.StringMap.__name__ = true;
haxe.ds.StringMap.__interfaces__ = [IMap];
haxe.ds.StringMap.prototype = {
	set: function(key,value) {
		this.h["$" + key] = value;
	}
	,get: function(key) {
		return this.h["$" + key];
	}
	,exists: function(key) {
		return this.h.hasOwnProperty("$" + key);
	}
	,__class__: haxe.ds.StringMap
};
haxe.io = {};
haxe.io.Bytes = function(length,b) {
	this.length = length;
	this.b = b;
};
$hxClasses["haxe.io.Bytes"] = haxe.io.Bytes;
haxe.io.Bytes.__name__ = true;
haxe.io.Bytes.alloc = function(length) {
	var a = new Array();
	var _g = 0;
	while(_g < length) {
		var i = _g++;
		a.push(0);
	}
	return new haxe.io.Bytes(length,a);
};
haxe.io.Bytes.prototype = {
	readString: function(pos,len) {
		if(pos < 0 || len < 0 || pos + len > this.length) throw haxe.io.Error.OutsideBounds;
		var s = "";
		var b = this.b;
		var fcc = String.fromCharCode;
		var i = pos;
		var max = pos + len;
		while(i < max) {
			var c = b[i++];
			if(c < 128) {
				if(c == 0) break;
				s += fcc(c);
			} else if(c < 224) s += fcc((c & 63) << 6 | b[i++] & 127); else if(c < 240) {
				var c2 = b[i++];
				s += fcc((c & 31) << 12 | (c2 & 127) << 6 | b[i++] & 127);
			} else {
				var c2 = b[i++];
				var c3 = b[i++];
				s += fcc((c & 15) << 18 | (c2 & 127) << 12 | c3 << 6 & 127 | b[i++] & 127);
			}
		}
		return s;
	}
	,toString: function() {
		return this.readString(0,this.length);
	}
	,__class__: haxe.io.Bytes
};
haxe.io.Error = $hxClasses["haxe.io.Error"] = { __ename__ : true, __constructs__ : ["Blocked","Overflow","OutsideBounds","Custom"] };
haxe.io.Error.Blocked = ["Blocked",0];
haxe.io.Error.Blocked.toString = $estr;
haxe.io.Error.Blocked.__enum__ = haxe.io.Error;
haxe.io.Error.Overflow = ["Overflow",1];
haxe.io.Error.Overflow.toString = $estr;
haxe.io.Error.Overflow.__enum__ = haxe.io.Error;
haxe.io.Error.OutsideBounds = ["OutsideBounds",2];
haxe.io.Error.OutsideBounds.toString = $estr;
haxe.io.Error.OutsideBounds.__enum__ = haxe.io.Error;
haxe.io.Error.Custom = function(e) { var $x = ["Custom",3,e]; $x.__enum__ = haxe.io.Error; $x.toString = $estr; return $x; };
var js = {};
js.Boot = function() { };
$hxClasses["js.Boot"] = js.Boot;
js.Boot.__name__ = true;
js.Boot.__string_rec = function(o,s) {
	if(o == null) return "null";
	if(s.length >= 5) return "<...>";
	var t = typeof(o);
	if(t == "function" && (o.__name__ || o.__ename__)) t = "object";
	switch(t) {
	case "object":
		if(o instanceof Array) {
			if(o.__enum__) {
				if(o.length == 2) return o[0];
				var str = o[0] + "(";
				s += "\t";
				var _g1 = 2;
				var _g = o.length;
				while(_g1 < _g) {
					var i = _g1++;
					if(i != 2) str += "," + js.Boot.__string_rec(o[i],s); else str += js.Boot.__string_rec(o[i],s);
				}
				return str + ")";
			}
			var l = o.length;
			var i;
			var str = "[";
			s += "\t";
			var _g = 0;
			while(_g < l) {
				var i1 = _g++;
				str += (i1 > 0?",":"") + js.Boot.__string_rec(o[i1],s);
			}
			str += "]";
			return str;
		}
		var tostr;
		try {
			tostr = o.toString;
		} catch( e ) {
			return "???";
		}
		if(tostr != null && tostr != Object.toString) {
			var s2 = o.toString();
			if(s2 != "[object Object]") return s2;
		}
		var k = null;
		var str = "{\n";
		s += "\t";
		var hasp = o.hasOwnProperty != null;
		for( var k in o ) {
		if(hasp && !o.hasOwnProperty(k)) {
			continue;
		}
		if(k == "prototype" || k == "__class__" || k == "__super__" || k == "__interfaces__" || k == "__properties__") {
			continue;
		}
		if(str.length != 2) str += ", \n";
		str += s + k + " : " + js.Boot.__string_rec(o[k],s);
		}
		s = s.substring(1);
		str += "\n" + s + "}";
		return str;
	case "function":
		return "<function>";
	case "string":
		return o;
	default:
		return String(o);
	}
};
js.Boot.__interfLoop = function(cc,cl) {
	if(cc == null) return false;
	if(cc == cl) return true;
	var intf = cc.__interfaces__;
	if(intf != null) {
		var _g1 = 0;
		var _g = intf.length;
		while(_g1 < _g) {
			var i = _g1++;
			var i1 = intf[i];
			if(i1 == cl || js.Boot.__interfLoop(i1,cl)) return true;
		}
	}
	return js.Boot.__interfLoop(cc.__super__,cl);
};
js.Boot.__instanceof = function(o,cl) {
	if(cl == null) return false;
	switch(cl) {
	case Int:
		return (o|0) === o;
	case Float:
		return typeof(o) == "number";
	case Bool:
		return typeof(o) == "boolean";
	case String:
		return typeof(o) == "string";
	case Dynamic:
		return true;
	default:
		if(o != null) {
			if(typeof(cl) == "function") {
				if(o instanceof cl) {
					if(cl == Array) return o.__enum__ == null;
					return true;
				}
				if(js.Boot.__interfLoop(o.__class__,cl)) return true;
			}
		} else return false;
		if(cl == Class && o.__name__ != null) return true;
		if(cl == Enum && o.__ename__ != null) return true;
		return o.__enum__ == cl;
	}
};
var letters = {};
letters.ExampleLetters = function() {
	var path;
	var y = 50.;
	var width = 300.;
	var lineSpace = 22.;
	var path1 = null;
	var highlightFunction = letters.Path.rainbowPencilHighlight;
	if(path1 == null) path1 = new Array();
	if(width == null) {
		width = 1000000;
		lineSpace = 0;
	}
	var temp;
	var x1 = 100.;
	var x2 = 100.;
	var dx = 0.;
	var y1 = y;
	var tempDim;
	var word = new Array();
	var lastLetterX1 = 0;
	var letterResource = new letters.LetterResource();
	var arrStr = "hi my name is justin and i live in bath a small city in the south west of the uk".split("");
	var counta = 0;
	if(highlightFunction != null) {
		var j = "";
		var count = counta + 1;
		var wordContent = "";
		if(count < arrStr.length) {
			while(j != " " && count < arrStr.length) {
				j = arrStr[count];
				if(j != " ") wordContent = wordContent + j;
				count++;
			}
			var float = [highlightFunction(wordContent)];
			var commandEnum = "F";
			var fillColor = { v0 : float, v1 : commandEnum};
			path1.push(fillColor);
		}
	}
	var _g = 0;
	while(_g < arrStr.length) {
		var i = arrStr[_g];
		++_g;
		x2 = x1;
		if(i != " " && i != "") {
			y1 = y;
			var vert;
			switch(i) {
			case "g":
				vert = -1.9;
				break;
			case "m":
				vert = -0.5;
				break;
			default:
				vert = 0.;
			}
			var preX;
			switch(i) {
			case "i":
				preX = 2.;
				break;
			case "s":
				preX = 2.;
				break;
			case "r":
				preX = 1.;
				break;
			default:
				preX = 0.;
			}
			if(vert != 0) y1 += vert * .7;
			if(preX != 0) x1 += preX * .7;
			var path2;
			if(letterResource.letters.exists(i)) path2 = letterResource.letters.get(i); else {
				var patha = new letters.Path(haxe.Resource.getString(i + "letter"));
				letterResource.letters.set(i,patha);
				path2 = patha;
			}
			var x = x1;
			var y2 = y1;
			var sx = .7;
			var sy = .7;
			var a = new Array();
			var $it0 = $iterator(path2)();
			while( $it0.hasNext() ) {
				var x3 = $it0.next();
				a.push((function($this) {
					var $r;
					var v0 = x3.v0;
					var v1 = x3.v1;
					switch(v1) {
					case "L":
						v0 = [sx * v0[0] + x,sy * v0[1] + y2];
						break;
					case "M":
						v0 = [sx * v0[0] + x,sy * v0[1] + y2];
						break;
					case "Q":
						v0 = [sx * v0[0] + x,sy * v0[1] + y2,sx * v0[2] + x,sy * v0[3] + y2];
						break;
					default:
					}
					var commandData = { v0 : v0, v1 : v1};
					$r = commandData;
					return $r;
				}(this)));
			}
			temp = a;
			var l = 1000000;
			var t = 1000000;
			var r = -1000000;
			var b = -1000000;
			var x;
			var y2;
			var count = 0;
			var $it1 = $iterator(temp)();
			while( $it1.hasNext() ) {
				var i1 = $it1.next();
				var v = i1.v0;
				var command = i1.v1;
				switch(command) {
				case "M":
					x = v[0];
					y2 = v[1];
					if(x < l) l = x;
					if(x > r) r = x;
					if(y2 < t) t = y2;
					if(y2 > b) b = y2;
					if(v.length > 2) {
						x = v[2];
						y2 = v[3];
						if(x < l) l = x;
						if(x > r) r = x;
						if(y2 < t) t = y2;
						if(y2 > b) b = y2;
					}
					break;
				case "L":
					x = v[0];
					y2 = v[1];
					if(x < l) l = x;
					if(x > r) r = x;
					if(y2 < t) t = y2;
					if(y2 > b) b = y2;
					if(v.length > 2) {
						x = v[2];
						y2 = v[3];
						if(x < l) l = x;
						if(x > r) r = x;
						if(y2 < t) t = y2;
						if(y2 > b) b = y2;
					}
					break;
				case "Q":
					x = v[0];
					y2 = v[1];
					if(x < l) l = x;
					if(x > r) r = x;
					if(y2 < t) t = y2;
					if(y2 > b) b = y2;
					if(v.length > 2) {
						x = v[2];
						y2 = v[3];
						if(x < l) l = x;
						if(x > r) r = x;
						if(y2 < t) t = y2;
						if(y2 > b) b = y2;
					}
					break;
				default:
				}
			}
			tempDim = { pos : { x : l, y : t}, dim : { x : r - l, y : b - t}, centre : { x : l + (r - l) / 2, y : t + (b - t) / 2}, end : { x : r, y : b}};
			dx = x2 - tempDim.pos.x;
			var postX;
			switch(i) {
			case "i":
				postX = 3.;
				break;
			case "j":
				postX = 3.;
				break;
			case "r":
				postX = -1.;
				break;
			case "f":
				postX = -2.;
				break;
			default:
				postX = 0.;
			}
			if(postX != 0) x1 += postX * .7;
			if(preX != 0) dx += preX * .7;
			x1 += tempDim.dim.x + 1.4;
			var x = dx;
			var y2 = 0;
			var x0 = x == 0;
			var y0 = y2 == 0;
			if(x0 && y0) temp = Lambda.array(temp); else if(x0) {
				var a = new Array();
				var $it2 = $iterator(temp)();
				while( $it2.hasNext() ) {
					var x3 = $it2.next();
					a.push((function($this) {
						var $r;
						var v0 = x3.v0;
						var v1 = x3.v1;
						switch(v1) {
						case "L":
							v0 = [v0[0],y2 + v0[1]];
							break;
						case "M":
							v0 = [v0[0],y2 + v0[1]];
							break;
						case "Q":
							v0 = [v0[0],y2 + v0[1],v0[2],y2 + v0[3]];
							break;
						default:
						}
						var commandData = { v0 : v0, v1 : v1};
						$r = commandData;
						return $r;
					}(this)));
				}
				temp = a;
			} else if(y0) {
				var a = new Array();
				var $it3 = $iterator(temp)();
				while( $it3.hasNext() ) {
					var x3 = $it3.next();
					a.push((function($this) {
						var $r;
						var v0 = x3.v0;
						var v1 = x3.v1;
						switch(v1) {
						case "L":
							v0 = [x + v0[0],v0[1]];
							break;
						case "M":
							v0 = [x + v0[0],v0[1]];
							break;
						case "Q":
							v0 = [x + v0[0],v0[1],x + v0[2],v0[3]];
							break;
						default:
						}
						var commandData = { v0 : v0, v1 : v1};
						$r = commandData;
						return $r;
					}(this)));
				}
				temp = a;
			} else {
				var a = new Array();
				var $it4 = $iterator(temp)();
				while( $it4.hasNext() ) {
					var x3 = $it4.next();
					a.push((function($this) {
						var $r;
						var v0 = x3.v0;
						var v1 = x3.v1;
						switch(v1) {
						case "L":
							v0 = [x + v0[0],y2 + v0[1]];
							break;
						case "M":
							v0 = [x + v0[0],y2 + v0[1]];
							break;
						case "Q":
							v0 = [x + v0[0],y2 + v0[1],x + v0[2],y2 + v0[3]];
							break;
						default:
						}
						var commandData = { v0 : v0, v1 : v1};
						$r = commandData;
						return $r;
					}(this)));
				}
				temp = a;
			}
			if(x1 > width) {
				y += lineSpace;
				word = word.concat(temp);
				var dim2;
				var l = 1000000;
				var t = 1000000;
				var r = -1000000;
				var b = -1000000;
				var x;
				var y2;
				var count = 0;
				var $it5 = $iterator(word)();
				while( $it5.hasNext() ) {
					var i1 = $it5.next();
					var v = i1.v0;
					var command = i1.v1;
					switch(command) {
					case "M":
						x = v[0];
						y2 = v[1];
						if(x < l) l = x;
						if(x > r) r = x;
						if(y2 < t) t = y2;
						if(y2 > b) b = y2;
						if(v.length > 2) {
							x = v[2];
							y2 = v[3];
							if(x < l) l = x;
							if(x > r) r = x;
							if(y2 < t) t = y2;
							if(y2 > b) b = y2;
						}
						break;
					case "L":
						x = v[0];
						y2 = v[1];
						if(x < l) l = x;
						if(x > r) r = x;
						if(y2 < t) t = y2;
						if(y2 > b) b = y2;
						if(v.length > 2) {
							x = v[2];
							y2 = v[3];
							if(x < l) l = x;
							if(x > r) r = x;
							if(y2 < t) t = y2;
							if(y2 > b) b = y2;
						}
						break;
					case "Q":
						x = v[0];
						y2 = v[1];
						if(x < l) l = x;
						if(x > r) r = x;
						if(y2 < t) t = y2;
						if(y2 > b) b = y2;
						if(v.length > 2) {
							x = v[2];
							y2 = v[3];
							if(x < l) l = x;
							if(x > r) r = x;
							if(y2 < t) t = y2;
							if(y2 > b) b = y2;
						}
						break;
					default:
					}
				}
				dim2 = { pos : { x : l, y : t}, dim : { x : r - l, y : b - t}, centre : { x : l + (r - l) / 2, y : t + (b - t) / 2}, end : { x : r, y : b}};
				var repos = 100. - dim2.pos.x;
				var x = repos;
				var y2 = lineSpace;
				var x0 = x == 0;
				var y0 = y2 == 0;
				if(x0 && y0) word = Lambda.array(word); else if(x0) {
					var a = new Array();
					var $it6 = $iterator(word)();
					while( $it6.hasNext() ) {
						var x3 = $it6.next();
						a.push((function($this) {
							var $r;
							var v0 = x3.v0;
							var v1 = x3.v1;
							switch(v1) {
							case "L":
								v0 = [v0[0],y2 + v0[1]];
								break;
							case "M":
								v0 = [v0[0],y2 + v0[1]];
								break;
							case "Q":
								v0 = [v0[0],y2 + v0[1],v0[2],y2 + v0[3]];
								break;
							default:
							}
							var commandData = { v0 : v0, v1 : v1};
							$r = commandData;
							return $r;
						}(this)));
					}
					word = a;
				} else if(y0) {
					var a = new Array();
					var $it7 = $iterator(word)();
					while( $it7.hasNext() ) {
						var x3 = $it7.next();
						a.push((function($this) {
							var $r;
							var v0 = x3.v0;
							var v1 = x3.v1;
							switch(v1) {
							case "L":
								v0 = [x + v0[0],v0[1]];
								break;
							case "M":
								v0 = [x + v0[0],v0[1]];
								break;
							case "Q":
								v0 = [x + v0[0],v0[1],x + v0[2],v0[3]];
								break;
							default:
							}
							var commandData = { v0 : v0, v1 : v1};
							$r = commandData;
							return $r;
						}(this)));
					}
					word = a;
				} else {
					var a = new Array();
					var $it8 = $iterator(word)();
					while( $it8.hasNext() ) {
						var x3 = $it8.next();
						a.push((function($this) {
							var $r;
							var v0 = x3.v0;
							var v1 = x3.v1;
							switch(v1) {
							case "L":
								v0 = [x + v0[0],y2 + v0[1]];
								break;
							case "M":
								v0 = [x + v0[0],y2 + v0[1]];
								break;
							case "Q":
								v0 = [x + v0[0],y2 + v0[1],x + v0[2],y2 + v0[3]];
								break;
							default:
							}
							var commandData = { v0 : v0, v1 : v1};
							$r = commandData;
							return $r;
						}(this)));
					}
					word = a;
				}
				x1 = x1 + repos;
			} else word = word.concat(temp);
		} else {
			path1 = path1.concat(word);
			if(highlightFunction != null) {
				var j = "";
				var count = counta + 1;
				var wordContent = "";
				if(count < arrStr.length) {
					while(j != " " && count < arrStr.length) {
						j = arrStr[count];
						if(j != " ") wordContent = wordContent + j;
						count++;
					}
					var float = [highlightFunction(wordContent)];
					var commandEnum = "F";
					var fillColor = { v0 : float, v1 : commandEnum};
					path1.push(fillColor);
				}
			}
			x1 += 15 * .7;
			word = new Array();
		}
		counta++;
	}
	path1 = path1.concat(word);
	path = path1;
	path = letters.Path.rotateXYZ(path,Math.PI / 10,Math.PI / 3,Math.PI / 10,1);
	this.drawToScreen(path);
};
$hxClasses["letters.ExampleLetters"] = letters.ExampleLetters;
letters.ExampleLetters.__name__ = true;
letters.ExampleLetters.main = function() {
	new letters.ExampleLetters();
};
letters.ExampleLetters.prototype = {
	drawToScreen: function(path) {
		var basicJs = new letters.targetJS.BasicJs();
		var surface = basicJs.surface;
		surface.fillStyle = "orange";
		surface.beginPath();
		var p;
		var lastCommand = "M";
		var _g = 0;
		while(_g < path.length) {
			var cmd = path[_g];
			++_g;
			p = cmd.v0;
			var command = cmd.v1;
			switch(command) {
			case "M":
				surface.moveTo(p[0],p[1]);
				break;
			case "L":
				surface.lineTo(p[0],p[1]);
				break;
			case "Q":
				surface.quadraticCurveTo(p[0],p[1],p[2],p[3]);
				break;
			case "O":
				surface.closePath();
				surface.stroke();
				surface.fill();
				surface.lineWidth = 5;
				surface.strokeStyle = "#" + StringTools.hex(p[0] | 0,6);
				break;
			case "F":
				if(lastCommand != "O") {
					surface.stroke();
					surface.closePath();
					surface.fill();
				}
				surface.fillStyle = "#" + StringTools.hex(p[0] | 0,6);
				surface.beginPath();
				break;
			}
			lastCommand = command;
		}
		surface.stroke();
		surface.closePath();
		surface.fill();
	}
	,__class__: letters.ExampleLetters
};
letters.LetterResource = function() {
	this.letters = new haxe.ds.StringMap();
};
$hxClasses["letters.LetterResource"] = letters.LetterResource;
letters.LetterResource.__name__ = true;
letters.LetterResource.prototype = {
	__class__: letters.LetterResource
};
letters.Path = function(str_) {
	this.hasIterated = false;
	this.bottom = -1000000;
	this.right = -1000000;
	this.top = 1000000;
	this.left = 1000000;
	this.count = 0;
	this.length = str_.length;
	this.str = str_;
};
$hxClasses["letters.Path"] = letters.Path;
letters.Path.__name__ = true;
letters.Path.rainbowPencilHighlight = function(str) {
	var rand;
	var x = Math.random() * ([13816001,13467688,13802769,14905640,15755121,13777201,11480113,9450302,8797520,5786205,5545667,2912413,4553390,3558765,3640429,7251784,3562916,4550210,12683310,8467492,4206116,2696224,5396305,1776409].length - 1);
	rand = x | 0;
	var col = [13816001,13467688,13802769,14905640,15755121,13777201,11480113,9450302,8797520,5786205,5545667,2912413,4553390,3558765,3640429,7251784,3562916,4550210,12683310,8467492,4206116,2696224,5396305,1776409][rand];
	return col;
};
letters.Path.rotateXYZ = function(path,rX,rY,rZ,zSpecial,ox,oy,oz) {
	if(ox == null || oy == null || oz == null) {
		var dim;
		var l = 1000000;
		var t = 1000000;
		var r = -1000000;
		var b = -1000000;
		var x;
		var y;
		var count = 0;
		var $it0 = $iterator(path)();
		while( $it0.hasNext() ) {
			var i = $it0.next();
			var v = i.v0;
			var command = i.v1;
			switch(command) {
			case "M":
				x = v[0];
				y = v[1];
				if(x < l) l = x;
				if(x > r) r = x;
				if(y < t) t = y;
				if(y > b) b = y;
				if(v.length > 2) {
					x = v[2];
					y = v[3];
					if(x < l) l = x;
					if(x > r) r = x;
					if(y < t) t = y;
					if(y > b) b = y;
				}
				break;
			case "L":
				x = v[0];
				y = v[1];
				if(x < l) l = x;
				if(x > r) r = x;
				if(y < t) t = y;
				if(y > b) b = y;
				if(v.length > 2) {
					x = v[2];
					y = v[3];
					if(x < l) l = x;
					if(x > r) r = x;
					if(y < t) t = y;
					if(y > b) b = y;
				}
				break;
			case "Q":
				x = v[0];
				y = v[1];
				if(x < l) l = x;
				if(x > r) r = x;
				if(y < t) t = y;
				if(y > b) b = y;
				if(v.length > 2) {
					x = v[2];
					y = v[3];
					if(x < l) l = x;
					if(x > r) r = x;
					if(y < t) t = y;
					if(y > b) b = y;
				}
				break;
			default:
			}
		}
		dim = { pos : { x : l, y : t}, dim : { x : r - l, y : b - t}, centre : { x : l + (r - l) / 2, y : t + (b - t) / 2}, end : { x : r, y : b}};
		var centre = dim.centre;
		ox = centre.x;
		oy = centre.y;
		oz = zSpecial;
	}
	var sX = Math.sin(rX);
	var sY = Math.sin(rY);
	var sZ = Math.sin(rZ);
	var cX = Math.cos(rX);
	var cY = Math.cos(rY);
	var cZ = Math.cos(rZ);
	var x;
	var y;
	var z;
	var x2;
	var y2;
	var z2;
	var tx;
	var ty;
	var tz;
	var s;
	var fL = 420;
	var a = new Array();
	var $it1 = $iterator(path)();
	while( $it1.hasNext() ) {
		var x1 = $it1.next();
		a.push((function($this) {
			var $r;
			var v0 = x1.v0;
			var v1 = x1.v1;
			switch(v1) {
			case "M":
				tx = v0[0] - ox;
				ty = v0[1] - oy;
				tz = zSpecial - oz;
				x = tx * cY * cZ + tz * sY - ty * sZ + ox;
				y = ty * cX * cZ - tz * sX + tx * sZ + oy;
				z = ty * sX + tz * cX * cY - tx * sY + oz;
				s = 1 - -z / fL;
				v0 = [x / s,y / s];
				break;
			case "L":
				tx = v0[0] - ox;
				ty = v0[1] - oy;
				tz = zSpecial - oz;
				x = tx * cY * cZ + tz * sY - ty * sZ + ox;
				y = ty * cX * cZ - tz * sX + tx * sZ + oy;
				z = ty * sX + tz * cX * cY - tx * sY + oz;
				s = 1 - -z / fL;
				v0 = [x / s,y / s];
				break;
			case "Q":
				tx = v0[0] - ox;
				ty = v0[1] - oy;
				tz = zSpecial - oz;
				x = tx * cY * cZ + tz * sY - ty * sZ + ox;
				y = ty * cX * cZ - tz * sX + tx * sZ + oy;
				z = ty * sX + tz * cX * cY - tx * sY + oz;
				s = 1 - -z / fL;
				x = x / s;
				y = y / s;
				tx = v0[2] - ox;
				ty = v0[3] - oy;
				tz = zSpecial - oz;
				x2 = tx * cY * cZ + tz * sY - ty * sZ + ox;
				y2 = ty * cX * cZ - tz * sX + tx * sZ + oy;
				z2 = ty * sX + tz * cX * cY - tx * sY + oz;
				s = 1 - -z2 / fL;
				x2 = x2 / s;
				y2 = y2 / s;
				v0 = [x,y,x2,y2];
				break;
			case "F":
				break;
			case "O":
				break;
			}
			var commandData = { v0 : v0, v1 : v1};
			$r = commandData;
			return $r;
		}(this)));
	}
	return a;
};
letters.Path.prototype = {
	iterator: function() {
		this.count = 0;
		return this;
	}
	,hasNext: function() {
		var hasAnother = this.count < this.length;
		if(!hasAnother) this.hasIterated = true;
		return hasAnother;
	}
	,next: function() {
		var command = this.str.charAt(this.count++);
		var commandEnum;
		if(command == " ") command = this.str.charAt(this.count++);
		if((function($this) {
			var $r;
			switch(command) {
			case "0":
				$r = true;
				break;
			case "1":
				$r = true;
				break;
			case "2":
				$r = true;
				break;
			case "3":
				$r = true;
				break;
			case "4":
				$r = true;
				break;
			case "5":
				$r = true;
				break;
			case "6":
				$r = true;
				break;
			case "7":
				$r = true;
				break;
			case "8":
				$r = true;
				break;
			case "9":
				$r = true;
				break;
			default:
				$r = false;
			}
			return $r;
		}(this))) {
			commandEnum = this.last;
			this.count--;
		} else commandEnum = command;
		switch(commandEnum) {
		case "L":
			var command1 = "L";
			this.last = command1;
			var num = "";
			var increment = 0;
			var isX = true;
			var arr = new Array();
			while(increment < 2) {
				var char = this.str.charAt(this.count);
				this.count++;
				if((function($this) {
					var $r;
					switch(char) {
					case "0":
						$r = true;
						break;
					case "1":
						$r = true;
						break;
					case "2":
						$r = true;
						break;
					case "3":
						$r = true;
						break;
					case "4":
						$r = true;
						break;
					case "5":
						$r = true;
						break;
					case "6":
						$r = true;
						break;
					case "7":
						$r = true;
						break;
					case "8":
						$r = true;
						break;
					case "9":
						$r = true;
						break;
					default:
						$r = false;
					}
					return $r;
				}(this)) || char == ".") num += char; else {
					isX = !isX;
					var out = Std.parseFloat(num);
					if(isX) {
						if(out < this.left) this.left = out;
						if(out > this.right) this.right = out;
					} else {
						if(out < this.top) this.top = out;
						if(out > this.bottom) this.bottom = out;
					}
					num = "";
					arr.push(out);
					increment++;
				}
			}
			this.count--;
			var commandData = { v0 : arr, v1 : command1};
			return commandData;
		case "Q":
			var command1 = "Q";
			this.last = command1;
			var num = "";
			var increment = 0;
			var isX = true;
			var arr = new Array();
			while(increment < 4) {
				var char = this.str.charAt(this.count);
				this.count++;
				if((function($this) {
					var $r;
					switch(char) {
					case "0":
						$r = true;
						break;
					case "1":
						$r = true;
						break;
					case "2":
						$r = true;
						break;
					case "3":
						$r = true;
						break;
					case "4":
						$r = true;
						break;
					case "5":
						$r = true;
						break;
					case "6":
						$r = true;
						break;
					case "7":
						$r = true;
						break;
					case "8":
						$r = true;
						break;
					case "9":
						$r = true;
						break;
					default:
						$r = false;
					}
					return $r;
				}(this)) || char == ".") num += char; else {
					isX = !isX;
					var out = Std.parseFloat(num);
					if(isX) {
						if(out < this.left) this.left = out;
						if(out > this.right) this.right = out;
					} else {
						if(out < this.top) this.top = out;
						if(out > this.bottom) this.bottom = out;
					}
					num = "";
					arr.push(out);
					increment++;
				}
			}
			this.count--;
			var commandData = { v0 : arr, v1 : command1};
			return commandData;
		case "M":
			var command1 = "M";
			this.last = command1;
			var num = "";
			var increment = 0;
			var isX = true;
			var arr = new Array();
			while(increment < 2) {
				var char = this.str.charAt(this.count);
				this.count++;
				if((function($this) {
					var $r;
					switch(char) {
					case "0":
						$r = true;
						break;
					case "1":
						$r = true;
						break;
					case "2":
						$r = true;
						break;
					case "3":
						$r = true;
						break;
					case "4":
						$r = true;
						break;
					case "5":
						$r = true;
						break;
					case "6":
						$r = true;
						break;
					case "7":
						$r = true;
						break;
					case "8":
						$r = true;
						break;
					case "9":
						$r = true;
						break;
					default:
						$r = false;
					}
					return $r;
				}(this)) || char == ".") num += char; else {
					isX = !isX;
					var out = Std.parseFloat(num);
					if(isX) {
						if(out < this.left) this.left = out;
						if(out > this.right) this.right = out;
					} else {
						if(out < this.top) this.top = out;
						if(out > this.bottom) this.bottom = out;
					}
					num = "";
					arr.push(out);
					increment++;
				}
			}
			this.count--;
			var commandData = { v0 : arr, v1 : command1};
			return commandData;
		default:
			var command1 = "M";
			this.last = command1;
			var num = "";
			var increment = 0;
			var isX = true;
			var arr = new Array();
			while(increment < 2) {
				var char = this.str.charAt(this.count);
				this.count++;
				if((function($this) {
					var $r;
					switch(char) {
					case "0":
						$r = true;
						break;
					case "1":
						$r = true;
						break;
					case "2":
						$r = true;
						break;
					case "3":
						$r = true;
						break;
					case "4":
						$r = true;
						break;
					case "5":
						$r = true;
						break;
					case "6":
						$r = true;
						break;
					case "7":
						$r = true;
						break;
					case "8":
						$r = true;
						break;
					case "9":
						$r = true;
						break;
					default:
						$r = false;
					}
					return $r;
				}(this)) || char == ".") num += char; else {
					isX = !isX;
					var out = Std.parseFloat(num);
					if(isX) {
						if(out < this.left) this.left = out;
						if(out > this.right) this.right = out;
					} else {
						if(out < this.top) this.top = out;
						if(out > this.bottom) this.bottom = out;
					}
					num = "";
					arr.push(out);
					increment++;
				}
			}
			this.count--;
			var commandData = { v0 : arr, v1 : command1};
			return commandData;
		}
	}
	,__class__: letters.Path
};
letters.targetJS = {};
letters.targetJS.BasicJs = function() {
	var setup = new letters.targetJS.SetupCanvas();
	this.surface = setup.surface;
	var body = window.document.body;
	body.appendChild(setup.dom);
};
$hxClasses["letters.targetJS.BasicJs"] = letters.targetJS.BasicJs;
letters.targetJS.BasicJs.__name__ = true;
letters.targetJS.BasicJs.prototype = {
	__class__: letters.targetJS.BasicJs
};
letters.targetJS.SetupCanvas = function() {
	var _this = window.document;
	this.canvas = _this.createElement("canvas");
	this.dom = this.canvas;
	this.body = window.document.body;
	this.surface = this.canvas.getContext("2d");
	this.style = this.dom.style;
	this.canvas.width = Std.parseInt("1000");
	this.canvas.height = Std.parseInt("800");
	this.style.paddingLeft = "0px";
	this.style.paddingTop = "0px";
	this.style.left = Std.string(0 + "px");
	this.style.top = Std.string(0 + "px");
	this.style.position = "absolute";
	this.image = this.dom;
};
$hxClasses["letters.targetJS.SetupCanvas"] = letters.targetJS.SetupCanvas;
letters.targetJS.SetupCanvas.__name__ = true;
letters.targetJS.SetupCanvas.prototype = {
	__class__: letters.targetJS.SetupCanvas
};
function $iterator(o) { if( o instanceof Array ) return function() { return HxOverrides.iter(o); }; return typeof(o.iterator) == 'function' ? $bind(o,o.iterator) : o.iterator; }
var $_, $fid = 0;
function $bind(o,m) { if( m == null ) return null; if( m.__id__ == null ) m.__id__ = $fid++; var f; if( o.hx__closures__ == null ) o.hx__closures__ = {}; else f = o.hx__closures__[m.__id__]; if( f == null ) { f = function(){ return f.method.apply(f.scope, arguments); }; f.scope = o; f.method = m; o.hx__closures__[m.__id__] = f; } return f; }
Math.NaN = Number.NaN;
Math.NEGATIVE_INFINITY = Number.NEGATIVE_INFINITY;
Math.POSITIVE_INFINITY = Number.POSITIVE_INFINITY;
$hxClasses.Math = Math;
Math.isFinite = function(i) {
	return isFinite(i);
};
Math.isNaN = function(i) {
	return isNaN(i);
};
String.prototype.__class__ = $hxClasses.String = String;
String.__name__ = true;
Array.prototype.__class__ = $hxClasses.Array = Array;
Array.__name__ = true;
Date.prototype.__class__ = $hxClasses.Date = Date;
Date.__name__ = ["Date"];
var Int = $hxClasses.Int = { __name__ : ["Int"]};
var Dynamic = $hxClasses.Dynamic = { __name__ : ["Dynamic"]};
var Float = $hxClasses.Float = Number;
Float.__name__ = ["Float"];
var Bool = $hxClasses.Bool = Boolean;
Bool.__ename__ = ["Bool"];
var Class = $hxClasses.Class = { __name__ : ["Class"]};
var Enum = { };
haxe.Resource.content = [{ name : "qletter", data : "s582:TTE5IDE3Ljg1IFExNy45IDE4LjQgMTYuNSAxOS44NSAxNS4xIDIxLjI1IDE0LjY1IDI1LjI1IDE0LjEgMzYuMTUgMjEuMyAzNi4zNSAyNC44IDM2LjE1IDI2LjYgMzMuMzUgTDI2Ljc1IDIyLjMgUTI2LjggMTkuNSAyNS4wNSAxOC40IDIzLjggMTcuMzUgMjIgMTcuMyAyMC4xIDE3LjI1IDE5IDE3Ljg1IE0xMy4xNSAxOC4zIFExNS43NSAxNS43IDE4Ljc1IDE0Ljk1IDIyLjUgMTQgMjYuODUgMTYgTDI5LjY1IDE1LjU1IFEzMC44NSAxNS4zIDMxLjcgMTYuOTUgTDMxLjg1IDQ5LjU1IDMwLjI1IDQ5Ljk1IDMwLjA1IDQ5Ljk1IDI4LjYgNDkuNyBRMjcuMzUgNDkuMSAyNy4yNSA0OC4yIEwyNi41IDM3LjQgUTI1LjEgMzguNjUgMjIuNSAzOS41IEwyMC42IDM5LjcgUTE2LjIgMzkuNzUgMTQuNDUgMzguMiA5LjQgMzUgOS44NSAyNi4zIDEwLjA1IDIyLjIgMTMuMTUgMTguMw"},{ name : "lletter", data : "s214:TTIzLjcgMzcuMTUgUTIzLjg1IDM5Ljg1IDIwLjkgMzkuNSAxOS42NSAzOS40IDE4Ljc1IDM4LjYgMTcuOSAzNy4xIDE3Ljk1IDM0Ljg1IEwxOC4zIDQuNSBRMTguNzUgMy40IDE5Ljg1IDMuMiBMMjEuMyAyLjkgUTIyLjggMi43NSAyMi44NSAzLjcgTDIzIDI4LjggMjMuNyAzNy4xNQ"},{ name : "pletter", data : "s667:TTIwLjM1IDE3LjU1IFExNy4xIDE3LjY1IDE0LjggMjEuNCBMMTQuNzUgMzMuMTUgUTE2LjQgMzYuOTUgMjAuODUgMzYuNyAyMy4yNSAzNi41NSAyNC43IDM0LjQ1IEwyNS4zIDMzLjQgUTI3IDMwIDI2LjcgMjUuNjUgMjYuNDUgMjMuMTUgMjUuNjUgMjAuNjUgMjQuMDUgMTcuMSAyMC4zNSAxNy41NSBNMTggMTUuNCBRMTkuOSAxNC4yNSAyMy4yIDE0LjEgMjYuNDUgMTMuOSAyOS4xIDE2Ljc1IDMxLjcgMTkuNTUgMzIgMjMuMiAzMi4yNSAyNi44IDMxLjMgMzAuMjUgMzAuNSAzMy40IDI4LjQgMzUuOTUgMjcuMSAzNy43NSAyNC4zIDM4LjY1IDIyLjYgMzkuMyAyMC43NSAzOS4yNSAxNy45NSAzOS4yNSAxNS4xIDM4LjM1IEwxNC4xNSA0OC41IFExMy4xNSA0OS41IDExLjU1IDQ5LjMgMTAuMSA0OS40IDkuNiA0Ny45IEw5Ljk1IDE3LjA1IFExMC4yIDE1LjcgMTEuNCAxNS4xIEwxMi4wNSAxNC45NSAxMy40IDE1LjEgUTE1LjIgMTYuNCAxNS4zIDE3LjcgMTYuMSAxNi41IDE4IDE1LjQ"},{ name : "kletter", data : "s626:TTEzLjggMy43NSBMMTQuNSAzLjk1IFExNC45NSAzLjg1IDE1LjMgNS42NSBMMTUuNTUgOS4wNSAxNS42IDE4Ljg1IFExNS42IDIxLjQgMTYuMSAyNC40NSBMMjQuNDUgMTcuNiBRMjcuMDUgMTUuOSAyOC4zIDE2IDI5LjMgMTYuMDUgMjguNzUgMTYuOCBMMjEuODUgMjQuNyBRMjEuNSAyNS4zIDIzLjQ1IDI3Ljk1IEwzMC43IDM3LjggUTMyIDM5LjUgMzAuMjUgMzkuNyAyOC40NSA0MC4zNSAyNS40IDM3LjkgMjIuMjUgMzUuMDUgMTkuNjUgMzAuNzUgMTguMSAyOS4xNSAxNi43NSAyOC41NSAxNi4xIDI4LjMgMTYuMDUgMjkuMSAxNS42IDMwLjc1IDE1LjU1IDM1LjUgMTUuMzUgMzcuOTUgMTQuOCAzOS4xIDEzLjkgMzkuODUgMTIuNjUgMzkuOCAxMS43IDM5LjYgMTEgMzkuMDUgMTAuNyAzOC4wNSAxMC41NSAzNi44NSAxMC4wNSAyMS4yIDEwLjk1IDUuNTUgMTAuOSA0LjY1IDEyLjEgNC4yNSAxMi45NSAzLjg1IDEzLjggMy43NQ"},{ name : "oletter", data : "s588:TTE1LjkgMTkuNzUgUTEzLjggMjIuNTUgMTQuMDUgMjcuMyBMMTQuNCAzMC4yNSBRMTUuOSAzNy4zNSAyMS4yIDM3LjM1IDIzLjc1IDM3LjM1IDI1Ljk1IDM0LjY1IDI3LjM1IDMyLjI1IDI3LjUgMjcuMTUgMjcuNDUgMjQuMTUgMjYuNiAyMS45NSAyNS42IDE4Ljk1IDIyLjk1IDE3Ljc1IDIwLjkgMTcuMDUgMTkuMTUgMTcuMyAxNy40NSAxNy41IDE1LjkgMTkuNzUgTTE5LjE1IDE0LjggTDIxLjMgMTQuNjUgMjMuOTUgMTQuOTUgMjUuOCAxNS41NSBRMjcuOCAxNi4zIDI5IDE3LjQ1IDMxLjkgMjAuNzUgMzIuNSAyNC40IDMzLjIgMzIuNyAyOS4xIDM2LjcgMjYuMDUgNDAuMDUgMjAuMDUgNDAuMDUgMTMuMTUgMzkuOCAxMC40IDMzLjggOC43IDMwLjYgOS4xIDI1LjkgOS4zIDIzLjIgMTAuODUgMjAuMiAxMi4xIDE3Ljk1IDE0LjkgMTYuMDUgMTYuOTUgMTQuOSAxOS4xNSAxNC44"},{ name : "nletter", data : "s494:TTEwLjg1IDE3LjQ1IFExMSAxNi40NSAxMS44IDE2LjMgTDEyLjc1IDE2LjMgUTEzLjkgMTYuNDUgMTQuNyAxNy42IEwxNS42NSAxOS4yIDE5LjQ1IDE3LjEgUTIyLjQgMTUuMjUgMjUuMDUgMTUuOCAyNy42NSAxNi4zNSAyOC43NSAxNy42IDMwLjk1IDE5LjE1IDMxLjE1IDM1LjggMzEuMzUgMzguMTUgMzAuNzUgMzkuMTUgMzAuMjUgNDAgMjkuMDUgNDAgMjYuNDUgNDAgMjYuNSAzNS44IEwyNS41NSAyMiBRMjUuNCAyMSAyNC42NSAyMC40IDIzLjIgMTkuMSAyMS43IDE5LjIgMTguMTUgMTkuNiAxNiAyMi41IEwxNC45IDM4LjcgUTE0LjcgMzkuNiAxMy45NSAzOS43IEwxMy43NSAzOS43NSBRMTAuMTUgNDAuNCAxMC40NSAzOC41IEwxMC44NSAxNy40NQ"},{ name : "jletter", data : "s602:TTI1LjM1IDkuNCBMMjQuOCA5LjM1IDIzLjk1IDkuMjUgUTIzLjMgOS4xIDIzIDguOCBMMjIuNiA4LjMgUTIxLjggNy4zIDIyIDYuMyAyMi4yIDUuMiAyMi41NSA0LjkgTDIzLjIgNC4zNSBRMjYuOCAyLjkgMjcuNDUgNi4yNSAyNy43NSA3LjMgMjcuMSA4LjIgTDI2LjEgOS4xIDI1LjY1IDkuMyAyNS4zNSA5LjQgTTIxLjkgMTUuNTUgTDIyLjQgMTQuOTUgMjMuNSAxNC42NSAyNC41IDE0LjYgUTI1LjYgMTQuNDUgMjYuNCAxNC45IDI3LjI1IDE1IDI3LjA1IDE3Ljk1IDI3LjM1IDMyLjU1IDI3IDQyIDI2Ljc1IDUyLjA1IDE4Ljg1IDUxLjc1IDE2Ljc1IDUxLjYgMTUuNSA1MC44IDE0LjQ1IDUwLjUgMTQuMTUgNDkuNCAxMy40NSA0Ni45NSAxNy4xNSA0Ny44NSBMMTkuMTUgNDguNSAxOS44IDQ4LjQ1IDIwLjYgNDcuOTUgUTIxLjU1IDQ3IDIxLjk1IDQzLjggTDIxLjggMzEuMDUgMjEuOSAxNS41NQ"},{ name : "mletter", data : "s851:TTE3Ljc1IDIzLjYgUTE3IDIwLjk1IDE1LjY1IDIwLjQgMTQuODUgMjAgMTQuMDUgMTkuOSBMMTMuNjUgMTkuODUgMTEuNjUgMjAuMjUgUTEwLjM1IDIwLjYgOS4yIDIxLjc1IDguMDUgMjIuOSA3LjY1IDI0Ljg1IDcuMjUgMjYuNzUgNy40IDMwLjQgNy40NSAzNy42IDYuNCAzOS4wNSAzLjA1IDQxLjI1IDMuMyAzNi42IEwzLjQ1IDE5LjE1IFEzLjQ1IDE2LjggNC42NSAxNi43NSA1LjkgMTYuNyA2LjQgMTguNSBMNi40NSAxOC42NSBRNy4xNSAxOS43IDguNyAxOC45IEwxMC45IDE3LjggUTE1LjkgMTMuNiAyMy4wNSAxOS40NSAyNy4wNSAxNi43IDMwLjEgMTYuNiAzMy4xNSAxNi40NSAzNC45NSAxNy45IDM2Ljc1IDE5LjM1IDM3LjMgMjEuNyAzOC4zIDI1LjY1IDM4LjM1IDM3LjU1IDM4LjEgMzkuNDUgMzcuMjUgMzkuNyAzNSA0MC43NSAzNC40IDM4Ljg1IDMzLjMgMzMuOCAzMy40NSAyOC40IEwzMy4wNSAyNS4wNSBRMzAuNjUgMTcuNzUgMjYuMyAyMC4xNSBMMjUuNSAyMC42NSBRMjQgMjEuOTUgMjMuNyAyMy41NSAyMy4zNSAyNS4yIDIzLjIgMjguNjUgTDIzLjI1IDMzLjIgMjMgMzYuNjUgUTIyLjcgMzkuNzUgMjEuNSA0MCAyMC41NSA0MC4zNSAxOS4yNSA0MCAxOC41NSAzOS43NSAxOC4zIDM4LjggTDE3Ljc1IDIzLjY"},{ name : "iletter", data : "s568:TTIzLjYgNi43IFEyMy4zNSA4LjMgMjIuNiA4Ljg1IDIwLjYgOS42IDE5LjI1IDguODUgTDE4LjcgOC4zNSBRMTguMiA3Ljg1IDE4LjA1IDYuODUgMTguMjUgNS43NSAxOSA0Ljk1IDIwLjE1IDQuMzUgMjEuMyA0LjQ1IEwyMS41IDQuNSAyMS44NSA0LjU1IFEyMi43NSA0LjY1IDIzLjI1IDUuNDUgMjMuNjUgNS45IDIzLjYgNi43IE0yMC40NSAxNS43IEwyMS45IDE1LjU1IDIyLjMgMTUuNjUgMjIuNyAxNS43NSAyMy41NSAzNi4wNSBRMjQuMDUgNDAuMSAyMC4yIDQwLjEgMTkuMDUgNDAuMSAxOC43IDM5LjIgMTguNDUgMzguNDUgMTguNCAzNi4wNSBMMTguNCAzMS40IDE4LjM1IDI5LjQ1IDE4LjM1IDIwLjggMTguMyAxOC40IFExOC4yNSAxNy4xIDE4LjM1IDE2LjU1IEwxOC44IDE2LjE1IFExOS40NSAxNS44NSAyMC4yNSAxNS43IEwyMC40NSAxNS43"},{ name : "hletter", data : "s608:TTI2Ljk1IDE2LjQgUTMxLjUgMTguMzUgMzEuNTUgMjMuMSBMMzEuOTUgMzUuMiBRMzIuMDUgMzcuMzUgMzEuNiAzOS40NSBMMzEuNDUgMzkuOTUgUTMwLjk1IDQwLjY1IDMwLjEgNDAuNjUgTDI5LjQgNDAuNTUgUTI4IDQwLjE1IDI3LjcgMzguNDUgTDI3LjU1IDM3LjcgMjcuMyAzNSAyNy4xNSAyNC41NSBRMjYuMzUgMTguMTUgMjEuMjUgMjAuMDUgMTguOCAyMC45NSAxNy45NSAyMi4xIDE2Ljk1IDIzLjQ1IDE2LjkgMjYuMyBMMTYuMDUgMzcuNDUgUTE2LjEgMzguNzUgMTUuNDUgMzkuNjUgMTQuOCA0MC41NSAxMy45IDQwLjU1IDEzIDQwLjU1IDEyLjM1IDM5LjY1IDExLjcgMzguNzUgMTEuNyAzNy40NSBMMTEuNyAzNiAxMi4xIDcuMDUgUTEyLjIgNC42IDE0LjEgNC41IDE2LjkgMy44IDE2Ljg1IDYuOSBMMTcuMDUgMTguOSAxOS40IDE3LjcgMjEuOTUgMTYuOCBRMjQuMiAxNS45NSAyNi45NSAxNi40"},{ name : "gletter", data : "s570:TTIxLjk1IDIxLjg1IFExOS4wNSAyMi4yIDE3LjMgMjQuNyAxNS4yIDI5LjI1IDE3LjIgMzMuOTUgMTguNDUgMzYuOSAyMS4zNSAzNy4zNSAyNS43NSAzNi45IDI2LjkgMzMuNCAyNy44NSAyOS44NSAyNi43NSAyNS4zIDI1LjM1IDIxLjQgMjEuOTUgMjEuODUgTTExLjc1IDQ3Ljk1IFExMS42NSA0Ni4zIDEyLjkgNDYuMSBMMTQuMTUgNDYuMzUgMTcuMDUgNDcuNyBRMjguNjUgNTAgMjYuNzUgMzguOTUgMTkuMDUgNDEuMzUgMTUuMyAzNy40NSAxMS45IDM1LjI1IDExLjM1IDI5LjI1IDEyLjE1IDI0LjU1IDE0Ljg1IDIxLjk1IDIwLjI1IDE2LjY1IDI4LjM1IDIwLjMgMzEuMTUgMjEuNyAzMi4zIDI5LjIgTDMxLjk1IDQ0IFEzMC4zIDUzLjIgMTkuOCA1Mi42IDE1LjEgNTEuOCAxMy4yIDUwLjQgMTIuMSA0OS43NSAxMS45IDQ4Ljk1IEwxMS43NSA0Ny45NQ"},{ name : "zletter", data : "s358:TTEwLjQgMTYuNyBROS45IDE2LjMgMTAuMTUgMTUuOTUgTDEwLjU1IDE1LjY1IDExLjcgMTUuNSAxNC45IDE1LjMgUTI5LjE1IDE1IDMwLjg1IDE1LjUgMzIuMTUgMTYuMDUgMzEuNTUgMTcgTDE3LjQgMzYuMjUgMjcuNiAzNi43IFEzMS4yIDM2LjggMzIuNiAzOC4xIDMzLjI1IDM5IDMwLjk1IDM5LjQ1IEwyMC4xIDM5LjggMTIuOTUgMzkuNyBROC41IDM5LjggMTAuMSAzOC4wNSBMMjQuNjUgMTkgUTIyLjMgMTguMSAxNC42IDE3Ljc1IDExLjU1IDE3LjQ1IDEwLjQgMTYuNw"},{ name : "fletter", data : "s634:TTI4IDMuMjUgUTI5LjggMy41NSAzMC42NSA0Ljk1IDMxLjE1IDUuOSAzMS4wNSA2LjUgMzEuMiA3LjM1IDI5LjkgOC4xIDI5LjEgOC4yIDI4LjQgNy42NSBMMjcuOSA3LjIgMjcuNDUgNi43IDI2LjM1IDYuMiAyNS45NSA2LjE1IFEyNS4yIDYgMjQuNCA2LjQ1IDIxLjI1IDcuOTUgMjEuNyAxMi4wNSAyMS41IDE1LjEgMjQuNyAxNS4yIEwyNS41IDE1LjMgMjcuMTUgMTUuNjUgUTI4Ljc1IDE2LjggMjcuMyAxNy45NSBMMjUuNSAxOC4xNSAyNC44IDE4LjMgUTIxLjkgMTguMyAyMi4xIDIyIEwyMS40NSAzNy41IFEyMS44NSA0MC40IDE4Ljg1IDQwLjM1IDE2LjU1IDQwLjg1IDE2LjY1IDM2Ljg1IEwxNi42NSAyNC40IDE2LjE1IDE4LjkgUTE1LjMgMTcuOSAxNC41NSAxNy44NSAxMC43IDE2Ljc1IDE0LjUgMTUuNjUgMTYuMTUgMTUuMSAxNi4zNSAxMy44NSBMMTguMyA3LjkgUTE5Ljc1IDQuOCAyMi4xIDMuNyAyNC40IDIuNjUgMjggMy4yNQ"},{ name : "yletter", data : "s612:TTEwLjcgMTggTDE0LjggMTcuOTUgUTE2LjE1IDE5LjggMTcuOTUgMjUuMzUgMTkgMjguMiAyMS40NSAzMy40NSAyMS44NSAzNC4zIDIyLjcgMzQuMSAyMy42IDMzLjg1IDI0Ljc1IDMxLjA1IEwyNi40NSAyNi44IDI3LjkgMjIuNCAyOS4zIDE4LjEgUTI5LjU1IDE3LjI1IDMwLjY1IDE3LjMgMzIuNDUgMTcuNDUgMzIuNiAxOC41NSBMMzAuMiAyNi43IDI4IDM0LjA1IFEyNi42NSAzOC4zNSAyNS4zNSA0MS4yNSAyMy4yIDQ2IDIwLjEgNDkuMzUgMTYuOCA1Mi40NSAxNC42NSA1Mi44IDEwLjA1IDUzLjIgMTAuMDUgNTEuMSAxMC4xIDUwLjQgMTAuNSA0OS45NSAxMC45IDQ5LjQ1IDExLjkgNDkuMTUgMTMuNCA0OC42NSAxNC45IDQ5LjE1IDE2LjYgNDkuMiAxOS43IDQ0Ljk1IDIwLjc1IDQzLjMgMjEuMSA0MS42IEwyMSA0MC45IFExNCAyOS4zNSAxMC4wNSAxOS42IDkuNyAxOS4xIDkuOSAxOC42IEwxMC43IDE4"},{ name : "eletter", data : "s668:TTMxIDE5IFEzMi4xIDIxLjQ1IDMyLjY1IDIzLjc1IDMxLjM1IDI1LjIgMjUuNSAyNi41NSBMMTYuNTUgMjcuNDUgMTYuNCAyNy44IFExNy4xIDMyLjQ1IDE3Ljc1IDMzLjQgMTkuMzUgMzUuNyAyMy41IDM1LjY1IDI3LjcgMzUuNTUgMzIuMiAzMyBMMzIuMyAzMy4wNSAzMi4zIDMzLjEgUTMyLjcgMzQuNiAzMSAzNi4zIDI5LjY1IDM3LjY1IDI3LjMgMzguNzUgMjMuODUgNDAuMyAyMC42IDQwLjA1IDE3LjIgMzkuNzUgMTUuMDUgMzcuODUgMTMuMyAzNi4zNSAxMS43NSAzMy4xIDEwLjU1IDI4LjYgMTEuMSAyNS4xIDExLjY1IDIxLjcgMTMuOSAxOC42NSAxNS44NSAxNi42IDE4LjcgMTUuNSAyMS44NSAxMy44IDI2LjQgMTUuMDUgMjkuNSAxNiAzMSAxOSBNMjQuNSAxNy45IFEyMC43NSAxNiAxOC4yIDE4LjMgMTUuNjUgMjAuNiAxNS44IDIyLjIgTDE1LjggMjQuMjUgMTguMzUgMjQuNiAyNC42IDIzLjk1IFEyNi41NSAyMy42NSAyNy40IDIyLjYgMjcuODUgMjAuNDUgMjQuNSAxNy45"},{ name : "xletter", data : "s423:TTIxLjQgMjMuMyBMMjYuMjUgMTcuMSBRMjcuMjUgMTUuODUgMjguMjUgMTUuNTUgMzAuMjUgMTUuNjUgMzAuNTUgMTYuMyBMMjMuNzUgMjUuNzUgUTIzLjM1IDI2LjI1IDI0LjE1IDI3LjYgTDMxLjc1IDM4LjUgUTMyLjc1IDM5Ljc1IDMwLjcgMzkuOCAyOC4xIDQwLjEgMjYuMjUgMzguMjUgTDIwLjA1IDMwLjE1IDEzLjQ1IDM5LjEgUTExLjA1IDQwLjIgOS43NSAzOS44NSA5LjI1IDM5LjM1IDkuODUgMzguNjUgTDE3Ljk1IDI3LjQ1IDEwLjUgMTYuMyBRMTAuNCAxNS44IDExIDE1Ljc1IEwxMy4yIDE1LjYgUTE1IDE1LjYgMTYuMiAxNi40IEwyMS40IDIzLjM"},{ name : "dletter", data : "s483:TTI3LjMgMTUuNTUgTDI3Ljg1IDguMyBRMjcuOTUgNC4xIDMwLjcgMy43IDMyLjU1IDIuOCAzMi43NSA1LjEgTDMyLjcgMzIuOTUgMzMuMDUgMzUuOTUgUTMzLjQ1IDM2LjUgMzIuNjUgMzkuMTUgMzAuNTUgNDAuNzUgMjcuNzUgMzcuOCAxNy42IDQyLjcgMTIuNyAzNS44NSA3LjI1IDI1LjMgMTQuOCAxOC4zNSAxOC44NSAxNC4xNSAyNy4zIDE1LjU1IE0xNS45NSAyMy45NSBRMTQuNzUgMjcuOSAxNy4wNSAzNC4xIDE5LjQ1IDM3Ljk1IDI0LjQgMzYuNyAyNi4zNSAzNS43NSAyNy4yNSAzNC44IEwyNy4zIDMxLjY1IFEyOC4wNSAyMy4yIDI2Ljc1IDIwLjE1IDIzLjkgMTYuNTUgMjAuMTUgMTcuODUgMTcuODUgMTguODUgMTUuOTUgMjMuOTU"},{ name : "wletter", data : "s591:TTMuOCAxNi42NSBRNS41NSAxNS41IDYuOSAxNi44NSA4LjggMTguOCA5LjcgMjEuNCBMMTMuNCAzMS42NSBRMTQuOCAzNS43NSAxNS45IDMxLjc1IEwxOS44NSAxOS42IFEyMC42NSAxNy42NSAyMi4yNSAxNy42IDIzLjYgMTguMDUgMjQgMTkuMyBMMjguMzUgMzIuMTUgUTI4LjggMzMuMSAyOS42NSAzMi41IDMyLjYgMjYuNTUgMzQuNCAyMC44IDM0Ljg1IDE5LjI1IDM1LjY1IDE4LjI1IDM2LjYgMTcuMiAzNy41NSAxNi45IEwzNy42NSAxNi45IFEzOC4xNSAxNi44NSAzOCAxNy44IEwzNi45NSAyMC44IDMxLjY1IDM3LjUgUTMwIDQyLjEgMjcuMzUgMzguNzUgTDI3LjMgMzguNyBRMjUuMDUgMzUuNDUgMjQuMSAzMi42IEwyMS4xIDI2LjQ1IFExOC40NSAzMi43IDE1LjI1IDM4LjY1IDEyLjc1IDQxLjYgMTEuMjUgMzguNTUgTDMuNjUgMTguNTUgUTMuMzUgMTcuNiAzLjggMTYuNjU"},{ name : "cletter", data : "s535:TTI5LjcgMjEuNjUgTDI5LjUgMjEuNiAyOC43IDIxLjM1IDI2LjcgMTkuMyBRMjUuNCAxNy45IDIyLjUgMTcuOSAxOS42NSAxNy45IDE3Ljc1IDIwLjggMTYuMiAyMy4yIDE2LjIgMjUuNyAxNi4yIDMwLjU1IDE4LjY1IDMzLjUgMjAuNyAzNS45NSAyMi45NSAzNS45NSAyOS43NSAzNS45NSAzMi4wNSAzMi4zIEwzMi4yIDMyLjUgMzIuMjUgMzMuMiBRMzIuMjUgMzUuNjUgMjkuNiAzNy43IDI2LjcgMzkuOTUgMjIuMzUgMzkuOTUgMTYuODUgMzkuOTUgMTMuODUgMzYgMTEuMzUgMzIuNzUgMTEuMzUgMjguMyAxMS4zNSAyMi4wNSAxNS4zNSAxOC4xNSAxOC43NSAxNC44NSAyMi44IDE0Ljg1IDI3LjQ1IDE0Ljg1IDI5LjggMTYuOCAzMS40NSAxOC4xNSAzMS40NSAxOS42NSAzMS40NSAyMS40IDI5LjcgMjEuNjU"},{ name : "vletter", data : "s428:TTE1LjM1IDE4LjQgTDE2LjggMjIuNCAyMS4xIDMzLjI1IDIxLjQgMzMuNzUgMjEuNzUgMzMuNiBRMjUuMjUgMjYuODUgMjguMTUgMTguMjUgMjkuMjUgMTUuOCAzMC40IDE1LjggTDMxLjE1IDE1Ljc1IFEzMi4xIDE1Ljg1IDMyLjE1IDE2LjM1IEwyOS45IDIyLjYgMjQuODUgMzUgUTIyLjggMzkuNDUgMjIuMSAzOS43NSBMMjEuNSA0MCBRMjAgNDAuNCAxOC4zIDM3LjggTDE2Ljg1IDM0Ljg1IDkuOCAxNy41IFE5LjI1IDE2LjY1IDkuNTUgMTYuMTUgOS44NSAxNS42IDEwLjY1IDE1LjY1IDEzLjI1IDE1Ljc1IDEzLjk1IDE2LjI1IDE0LjggMTYuOSAxNS4zNSAxOC40"},{ name : "bletter", data : "s656:TTI1LjQ1IDE1LjUgUTI5LjUgMTYuNCAzMS44IDIxLjIgMzIuOSAyMy40NSAzMy4wNSAyNi4xNSAzMy4yIDI5IDMyLjMgMzEuNDUgMzEuNCAzMy44NSAzMC4zNSAzNS4xNSBMMjguNTUgMzcuMiAyNi42IDM4LjUgMjYuMyAzOC43IDI1LjYgMzkgMjMuNyAzOS42NSAyMi41IDM5LjggMTkuMSAzOS45NSAxOCAzOS44NSAxNi4zIDM5LjcgMTQuNSAzOS41IFExMi4zNSAzOSAxMS41IDM3LjcgMTAuNTUgMzYuMiAxMC41NSAzNC4xIEwxMC45NSA3LjMgMTEgNC45IDExLjUgNC41IFExMi4xNSAzLjg1IDEyLjggMy43IDE0LjE1IDIuOTUgMTUuMyAzLjcgTDE2LjIgMTcuNyBRMjEuNDUgMTQuNiAyNS40NSAxNS41IE0xNi4yIDIxLjMgTDE1Ljc1IDIzLjE1IDE1LjUgMjUuNCAxNS41IDMxLjUgUTE1LjUgMzMuODUgMTYuMzUgMzUuNCAxNy42IDM3LjEgMjAuOCAzNy4zIDI3LjQgMzcuMDUgMjcuNSAyNy4yIDI3LjYgMTcuMzUgMTkuNyAxOC43IDE3LjY1IDE4LjkgMTYuMiAyMS4z"},{ name : "uletter", data : "s582:TTEyLjY1IDE1LjU1IFExMy42NSAxNS42NSAxNC4zIDE2LjE1IDE0Ljk1IDE2LjY1IDE1IDE3LjQ1IEwxNS4xNSAyMC4xIFExNS4xIDI2Ljc1IDE1LjUgMzMuNDUgMTUuNzUgMzUuMSAxNy42NSAzNi4yIDIxLjc1IDM3LjI1IDI0LjE1IDM0LjkgMjYgMzMuMTUgMjYuMDUgMjguODUgTDI2LjMgMjEuNSBRMjYuMjUgMTcuMSAyNy4yNSAxNi40IDI3LjkgMTUuOTUgMjguNjUgMTUuOTUgTDMwLjEgMTYuMzUgUTMwLjg1IDE2LjggMzAuOSAxOS43NSBMMzEgMjMuNCAzMS4wNSAyNS4zNSAzMS4yIDM0LjcgMzEuMiAzNC45NSAzMS4xIDM4IDMwLjk1IDM4LjQ1IFEyOS40IDQwLjUgMjYuNjUgMzguNSBMMjUuNyAzNi45NSBRMTguNDUgNDEuNjUgMTQgMzguNzUgMTAuMTUgMzYuNjUgMTAuMzUgMjcuNjUgMTAuMyAyMi4zIDEwLjY1IDE3LjEgMTAuODUgMTUuNSAxMi42NSAxNS41NQ"},{ name : "aletter", data : "s870:TTIzLjUgMTguMSBRMTkuOSAxNi42IDE4LjIgMTkuMyAxNi40NSAyMS45NSAxNC44NSAyMS41IDEzLjg1IDIxLjI1IDEzLjU1IDIwLjYgTDEzLjM1IDIwIFExMy4yNSAxOS40NSAxMy40IDE4Ljk1IDEzLjY1IDE3Ljc1IDE1LjE1IDE2LjYgTDE2LjkgMTUuOCAxOS4yIDE1LjE1IDIwLjk1IDE0LjkgMjIuOTUgMTQuOSAyNi40NSAxNS4yNSBRMjcuNjUgMTUuNTUgMjguNCAxNi4xNSAzMS4xIDE3Ljk1IDMxLjE1IDIxLjU1IEwzMS44IDM4LjMgUTMxLjk1IDM5LjMgMzEuNSAzOS41NSBMMjkuNiAzOS45IFEyOC4yIDM5Ljk1IDI2Ljc1IDM5LjIgTDI2LjUgMzcuNyAyMi4yNSAzOS43IFEyMC4zIDQwLjQgMTcuOCA0MC40IDEzLjIgMzkuODUgMTIuMSAzNS43NSAxMS4yNSAzMy41IDEyLjU1IDMwLjY1IDEzLjEgMjguOSAxNS4zNSAyNy41NSAxOC40NSAyNS4yNSAyNC4yNSAyNC42NSAyNS4zIDI0LjcgMjUuOTUgMjQuMjUgMjYuNjUgMjMuNyAyNi4zNSAyMS40NSAyNiAxOS4xNSAyMy41IDE4LjEgTTIyLjQgMzYuOTUgUTI0LjggMzYuNjUgMjYuNCAzNC43IEwyNi43IDI3LjA1IDI0LjM1IDI3LjI1IFExOS43NSAyOC4xIDE4LjMgMjkuNiAxNi44NSAzMS4wNSAxNi45NSAzMy4yNSAxNy4wNSAzNS40IDE4LjUgMzYuMzUgMTkuOTUgMzcuMjUgMjIuNCAzNi45NQ"},{ name : "tletter", data : "s566:TTE0LjA1IDE1LjggUTE1Ljk1IDE1LjQgMTcuNSAxMy43NSAxOC42IDEyLjM1IDE4Ljg1IDkuOTUgMTkuMjUgOCAyMCA3LjQgMjAuNyA2LjggMjEuMyA3LjA1IDIxLjg1IDcuMyAyMiA4IEwyMi4yIDkuNjUgUTIyLjE1IDExLjMgMjIuMzUgMTIuOCAyMi4zNSAxMy45IDIzLjQ1IDE0LjYgTDI2LjM1IDE1LjE1IFEyNy4zIDE1LjE1IDI3LjUgMTUuOCAyNy45IDE2LjkgMjYuOSAxNy40NSBMMjMuODUgMTcuOSBRMjEuODUgMTcuODUgMjEuOTUgMjUuNDUgTDIxLjk1IDMwLjU1IFEyMi41NSAzNy42NSAyNi44NSAzNS45IDI4LjQ1IDM1Ljc1IDI3LjcgMzcuNiAyNy4xNSAzOC44NSAyNS40IDM5LjQgMTYuOTUgNDEuNzUgMTcgMjkuNSBMMTcuMTUgMjQuNyAxNy4xNSAyNC41IFExNi45NSAxNy42NSAxNC4zNSAxNy4wNSAxMy4xIDE2LjUgMTQuMDUgMTUuOA"},{ name : "sletter", data : "s802:TTE3LjIgMTUuMDUgUTIwLjA1IDE0LjMgMjIuNTUgMTQuOTUgTDI1Ljc1IDE1LjggMjcuNSAxNi43NSBRMjguNSAxNy42IDI4LjUgMTguMyAyOC40NSAxOC45NSAyOC4wNSAxOS40IDI3LjY1IDE5Ljg1IDI3IDE5LjggMjYuMyAxOS43NSAyNS40IDE5LjIgTDIzLjcgMTguMyAyMS44IDE3LjcgUTE4Ljk1IDE2Ljg1IDE3LjQ1IDE4LjE1IDE1LjkgMTkuNDUgMTYuMzUgMjAuOTUgMTYuOCAyMi40NSAxNy43IDIyLjk1IDIxLjQ1IDI1LjM1IDI1LjIgMjYuNDUgMjcuNDUgMjcuNCAyOC42IDI5IDMwLjQ1IDMyLjc1IDI5LjQgMzUuMjUgMjguMyAzNy43IDI1LjcgMzkgMjIuNSA0MC4yNSAxOC44NSA0MC4xIDE1Ljc1IDM5LjUgMTQgMzguNCAxMi4yNSAzNy4yNSAxMS45IDM2LjQgMTEuNiAzNS41NSAxMi4yNSAzNC43NSAxMi45NSAzNC4xNSAxMy40NSAzNC40IEwxNy44NSAzNi45NSBRMjIuNzUgMzguOCAyNC43IDM0LjYgMjUuMDUgMzMuNjUgMjQuNiAzMi43IDI0LjA1IDMxLjU1IDIyLjI1IDMwLjQ1IEwxNy4wNSAyNy44NSBRMTMuMSAyNi4wNSAxMi4xNSAyMy4xNSAxMS43NSAxOS43NSAxMy4yNSAxNy40NSBMMTQuMiAxNi41IFExNS40IDE1LjUgMTcuMiAxNS4wNQ"},{ name : "rletter", data : "s398:TTEzLjI1IDE3LjA1IFExMy44NSAxNS42NSAxNS40IDE1LjggMTYuNjUgMTUuNjUgMTcuNzUgMTYuNyBMMTguOTUgMTguNSAyMiAxNi4xNSBRMjMuMzUgMTUuNDUgMjQuNyAxNS40IEwyNC45NSAxNS40IFEyNi4zNSAxNS41NSAyNy4xNSAxNi4xNSAyOS41NSAxOC4wNSAyNy4zIDE5LjggTDI2Ljg1IDIwLjA1IFEyNS44IDIwLjM1IDI0Ljc1IDIwLjA1IDIxLjMgMTguNjUgMTguNzUgMjMuNSBMMTguNDUgMzcgUTE3LjcgNDAuMjUgMTUgMzkuOSAxMy40NSAzOS44NSAxMy40IDM4LjU1IEwxMy4yNSAzNi42NSAxMy4yNSAxNy4wNQ"}];
haxe.Unserializer.DEFAULT_RESOLVER = Type;
haxe.Unserializer.BASE64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789%:";
haxe.ds.ObjectMap.count = 0;
letters.ExampleLetters.main();
})();

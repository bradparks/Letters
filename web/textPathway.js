(function () { "use strict";
var HxOverrides = function() { };
HxOverrides.__name__ = true;
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
Lambda.map = function(it,f) {
	var l = new List();
	var $it0 = $iterator(it)();
	while( $it0.hasNext() ) {
		var x = $it0.next();
		l.add(f(x));
	}
	return l;
};
var List = function() {
	this.length = 0;
};
List.__name__ = true;
List.prototype = {
	add: function(item) {
		var x = [item];
		if(this.h == null) this.h = x; else this.q[1] = x;
		this.q = x;
		this.length++;
	}
};
var IMap = function() { };
IMap.__name__ = true;
Math.__name__ = true;
var Std = function() { };
Std.__name__ = true;
Std.string = function(s) {
	return js.Boot.__string_rec(s,"");
};
Std["int"] = function(x) {
	return x | 0;
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
StringTools.__name__ = true;
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
StringTools.fastCodeAt = function(s,index) {
	return s.charCodeAt(index);
};
var haxe = {};
haxe.Resource = function() { };
haxe.Resource.__name__ = true;
haxe.Resource.getString = function(name) {
	var _g = 0;
	var _g1 = haxe.Resource.content;
	while(_g < _g1.length) {
		var x = _g1[_g];
		++_g;
		if(x.name == name) {
			if(x.str != null) return x.str;
			var b = haxe.crypto.Base64.decode(x.data);
			return b.toString();
		}
	}
	return null;
};
haxe.io = {};
haxe.io.Bytes = function(length,b) {
	this.length = length;
	this.b = b;
};
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
haxe.io.Bytes.ofString = function(s) {
	var a = new Array();
	var i = 0;
	while(i < s.length) {
		var c = StringTools.fastCodeAt(s,i++);
		if(55296 <= c && c <= 56319) c = c - 55232 << 10 | StringTools.fastCodeAt(s,i++) & 1023;
		if(c <= 127) a.push(c); else if(c <= 2047) {
			a.push(192 | c >> 6);
			a.push(128 | c & 63);
		} else if(c <= 65535) {
			a.push(224 | c >> 12);
			a.push(128 | c >> 6 & 63);
			a.push(128 | c & 63);
		} else {
			a.push(240 | c >> 18);
			a.push(128 | c >> 12 & 63);
			a.push(128 | c >> 6 & 63);
			a.push(128 | c & 63);
		}
	}
	return new haxe.io.Bytes(a.length,a);
};
haxe.io.Bytes.prototype = {
	get: function(pos) {
		return this.b[pos];
	}
	,set: function(pos,v) {
		this.b[pos] = v & 255;
	}
	,getString: function(pos,len) {
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
				var c21 = b[i++];
				var c3 = b[i++];
				var u = (c & 15) << 18 | (c21 & 127) << 12 | (c3 & 127) << 6 | b[i++] & 127;
				s += fcc((u >> 10) + 55232);
				s += fcc(u & 1023 | 56320);
			}
		}
		return s;
	}
	,toString: function() {
		return this.getString(0,this.length);
	}
};
haxe.crypto = {};
haxe.crypto.Base64 = function() { };
haxe.crypto.Base64.__name__ = true;
haxe.crypto.Base64.decode = function(str,complement) {
	if(complement == null) complement = true;
	if(complement) while(HxOverrides.cca(str,str.length - 1) == 61) str = HxOverrides.substr(str,0,-1);
	return new haxe.crypto.BaseCode(haxe.crypto.Base64.BYTES).decodeBytes(haxe.io.Bytes.ofString(str));
};
haxe.crypto.BaseCode = function(base) {
	var len = base.length;
	var nbits = 1;
	while(len > 1 << nbits) nbits++;
	if(nbits > 8 || len != 1 << nbits) throw "BaseCode : base length must be a power of two.";
	this.base = base;
	this.nbits = nbits;
};
haxe.crypto.BaseCode.__name__ = true;
haxe.crypto.BaseCode.prototype = {
	initTable: function() {
		var tbl = new Array();
		var _g = 0;
		while(_g < 256) {
			var i = _g++;
			tbl[i] = -1;
		}
		var _g1 = 0;
		var _g2 = this.base.length;
		while(_g1 < _g2) {
			var i1 = _g1++;
			tbl[this.base.b[i1]] = i1;
		}
		this.tbl = tbl;
	}
	,decodeBytes: function(b) {
		var nbits = this.nbits;
		var base = this.base;
		if(this.tbl == null) this.initTable();
		var tbl = this.tbl;
		var size = b.length * nbits >> 3;
		var out = haxe.io.Bytes.alloc(size);
		var buf = 0;
		var curbits = 0;
		var pin = 0;
		var pout = 0;
		while(pout < size) {
			while(curbits < 8) {
				curbits += nbits;
				buf <<= nbits;
				var i = tbl[b.get(pin++)];
				if(i == -1) throw "BaseCode : invalid encoded char";
				buf |= i;
			}
			curbits -= 8;
			out.set(pout++,buf >> curbits & 255);
		}
		return out;
	}
};
haxe.ds = {};
haxe.ds.StringMap = function() {
	this.h = { };
};
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
};
haxe.io.Eof = function() { };
haxe.io.Eof.__name__ = true;
haxe.io.Eof.prototype = {
	toString: function() {
		return "Eof";
	}
};
haxe.io.Error = { __ename__ : true, __constructs__ : ["Blocked","Overflow","OutsideBounds","Custom"] };
haxe.io.Error.Blocked = ["Blocked",0];
haxe.io.Error.Blocked.__enum__ = haxe.io.Error;
haxe.io.Error.Overflow = ["Overflow",1];
haxe.io.Error.Overflow.__enum__ = haxe.io.Error;
haxe.io.Error.OutsideBounds = ["OutsideBounds",2];
haxe.io.Error.OutsideBounds.__enum__ = haxe.io.Error;
haxe.io.Error.Custom = function(e) { var $x = ["Custom",3,e]; $x.__enum__ = haxe.io.Error; return $x; };
var js = {};
js.Boot = function() { };
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
			var i1;
			var str1 = "[";
			s += "\t";
			var _g2 = 0;
			while(_g2 < l) {
				var i2 = _g2++;
				str1 += (i2 > 0?",":"") + js.Boot.__string_rec(o[i2],s);
			}
			str1 += "]";
			return str1;
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
		var str2 = "{\n";
		s += "\t";
		var hasp = o.hasOwnProperty != null;
		for( var k in o ) {
		if(hasp && !o.hasOwnProperty(k)) {
			continue;
		}
		if(k == "prototype" || k == "__class__" || k == "__super__" || k == "__interfaces__" || k == "__properties__") {
			continue;
		}
		if(str2.length != 2) str2 += ", \n";
		str2 += s + k + " : " + js.Boot.__string_rec(o[k],s);
		}
		s = s.substring(1);
		str2 += "\n" + s + "}";
		return str2;
	case "function":
		return "<function>";
	case "string":
		return o;
	default:
		return String(o);
	}
};
var letters = {};
letters.LetterResource = function() {
	this.letters = new haxe.ds.StringMap();
};
letters.LetterResource.__name__ = true;
letters.LetterResource.preAdjustX = function(str) {
	switch(str) {
	case "i":case "s":
		return 2.;
	case "r":
		return 1.;
	default:
		return 0.;
	}
};
letters.LetterResource.postAdjustX = function(str) {
	switch(str) {
	case "i":case "j":
		return 3.;
	case "r":
		return -1.;
	case "f":
		return -2.;
	default:
		return 0.;
	}
};
letters.LetterResource.verticalAdj = function(str) {
	switch(str) {
	case "g":
		return -1.9;
	case "m":
		return -0.5;
	default:
		return 0.;
	}
};
letters.LetterResource.space = function() {
	return 15;
};
letters.LetterResource.prototype = {
	getLetter: function(str) {
		if(this.letters.exists(str)) return this.letters.get(str); else {
			var patha = new letters.Path(haxe.Resource.getString(str + "letter"));
			this.letters.set(str,patha);
			return patha;
		}
	}
};
letters._Path = {};
letters._Path.T2_Impl_ = function() { };
letters._Path.T2_Impl_.__name__ = true;
letters._Path.T2_Impl_._new = function(s,t) {
	return { v0 : s, v1 : t};
};
letters._Path.T2_Impl_.make = function(s,t) {
	return { v0 : s, v1 : t};
};
letters._Path.T2_Impl_.get_v0 = function(this1) {
	return this1.v0;
};
letters._Path.T2_Impl_.set_v0 = function(this1,v0) {
	return this1.v0 = v0;
};
letters._Path.T2_Impl_.get_v1 = function(this1) {
	return this1.v1;
};
letters._Path.T2_Impl_.set_v1 = function(this1,v1) {
	return this1.v1 = v1;
};
letters._Path.T2_Impl_.toString = function(this1) {
	return "(" + Std.string(this1.v0) + "," + Std.string(this1.v1) + ")";
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
letters.Path.__name__ = true;
letters.Path.rainbowPencilColors = function() {
	return [13816001,13467688,13802769,14905640,15755121,13777201,11480113,9450302,8797520,5786205,5545667,2912413,4553390,3558765,3640429,7251784,3562916,4550210,12683310,8467492,4206116,2696224,5396305,1776409];
};
letters.Path.isNum = function(x) {
	switch(x) {
	case "0":case "1":case "2":case "3":case "4":case "5":case "6":case "7":case "8":case "9":
		return true;
	default:
		return false;
	}
};
letters.Path.isNumOrDot = function(x) {
	return (function($this) {
		var $r;
		switch(x) {
		case "0":case "1":case "2":case "3":case "4":case "5":case "6":case "7":case "8":case "9":
			$r = true;
			break;
		default:
			$r = false;
		}
		return $r;
	}(this)) || x == ".";
};
letters.Path.generateVectorText = function(str,x,y,scale,width,lineSpace,path,highlightFunction,outlineFunction) {
	if(path == null) path = new Array();
	if(width == null) {
		width = 1000000;
		lineSpace = 0;
	}
	var temp;
	var x1 = x;
	var x2 = x;
	var dx = 0.;
	var y1 = y;
	var tempDim;
	var word = new Array();
	var lastLetterX1 = 0;
	var letterResource = new letters.LetterResource();
	var arrStr = str.split("");
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
			var $float = [highlightFunction(wordContent)];
			var commandEnum = "F";
			var fillColor = { v0 : $float, v1 : commandEnum};
			if(outlineFunction != null) {
				$float = [outlineFunction(wordContent)];
				commandEnum = "O";
				var outlineColor = { v0 : $float, v1 : commandEnum};
				path.push(outlineColor);
			}
			path.push(fillColor);
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
			case "i":case "s":
				preX = 2.;
				break;
			case "r":
				preX = 1.;
				break;
			default:
				preX = 0.;
			}
			if(vert != 0) y1 += vert * scale;
			if(preX != 0) x1 += preX * scale;
			temp = letters.Path.scaleTranslate(letterResource.getLetter(i),x1,y1,scale,scale);
			tempDim = letters.Path.getDim(temp);
			dx = x2 - tempDim.pos.x;
			var postX;
			switch(i) {
			case "i":case "j":
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
			if(postX != 0) x1 += postX * scale;
			if(preX != 0) dx += preX * scale;
			x1 += tempDim.dim.x + 2 * scale;
			temp = letters.Path.translate(temp,dx,0);
			if(x1 > width) {
				y += lineSpace;
				word = word.concat(temp);
				var dim2 = letters.Path.getDim(word);
				var repos = x - dim2.pos.x;
				word = letters.Path.translate(word,repos,lineSpace);
				x1 = x1 + repos;
			} else word = word.concat(temp);
		} else {
			path = path.concat(word);
			if(highlightFunction != null) {
				var j1 = "";
				var count1 = counta + 1;
				var wordContent1 = "";
				if(count1 < arrStr.length) {
					while(j1 != " " && count1 < arrStr.length) {
						j1 = arrStr[count1];
						if(j1 != " ") wordContent1 = wordContent1 + j1;
						count1++;
					}
					var float1 = [highlightFunction(wordContent1)];
					var commandEnum1 = "F";
					var fillColor1 = { v0 : float1, v1 : commandEnum1};
					if(outlineFunction != null) {
						float1 = [outlineFunction(wordContent1)];
						commandEnum1 = "O";
						var outlineColor1 = { v0 : float1, v1 : commandEnum1};
						path.push(outlineColor1);
					}
					path.push(fillColor1);
				}
			}
			x1 += 15 * scale;
			word = new Array();
		}
		counta++;
	}
	path = path.concat(word);
	return path;
};
letters.Path.rainbowPencilHighlight = function(str) {
	var rand = Std["int"](Math.random() * ([13816001,13467688,13802769,14905640,15755121,13777201,11480113,9450302,8797520,5786205,5545667,2912413,4553390,3558765,3640429,7251784,3562916,4550210,12683310,8467492,4206116,2696224,5396305,1776409].length - 1));
	var col = [13816001,13467688,13802769,14905640,15755121,13777201,11480113,9450302,8797520,5786205,5545667,2912413,4553390,3558765,3640429,7251784,3562916,4550210,12683310,8467492,4206116,2696224,5396305,1776409][rand];
	return col;
};
letters.Path.highlightAnd = function(str) {
	if(str == "and") return 16711680;
	if(str == "in") return 65535;
	return 16763904;
};
letters.Path.translate = function(path,x_,y_) {
	var x = x_;
	var y = y_;
	var x0 = x == 0;
	var y0 = y == 0;
	if(x0 && y0) return Lambda.array(path);
	if(x0) return letters.Path.mapArr(path,function(v) {
		var v0 = v.v0;
		var v1 = v.v1;
		switch(v1) {
		case "L":case "M":
			v0 = [v0[0],y + v0[1]];
			break;
		case "Q":
			v0 = [v0[0],y + v0[1],v0[2],y + v0[3]];
			break;
		default:
		}
		var commandData = { v0 : v0, v1 : v1};
		return commandData;
	});
	if(y0) return letters.Path.mapArr(path,function(v2) {
		var v01 = v2.v0;
		var v11 = v2.v1;
		switch(v11) {
		case "L":case "M":
			v01 = [x + v01[0],v01[1]];
			break;
		case "Q":
			v01 = [x + v01[0],v01[1],x + v01[2],v01[3]];
			break;
		default:
		}
		var commandData1 = { v0 : v01, v1 : v11};
		return commandData1;
	});
	return letters.Path.mapArr(path,function(v3) {
		var v02 = v3.v0;
		var v12 = v3.v1;
		switch(v12) {
		case "L":case "M":
			v02 = [x + v02[0],y + v02[1]];
			break;
		case "Q":
			v02 = [x + v02[0],y + v02[1],x + v02[2],y + v02[3]];
			break;
		default:
		}
		var commandData2 = { v0 : v02, v1 : v12};
		return commandData2;
	});
};
letters.Path.scale = function(path,x_,y_) {
	var x = x_;
	var y = y_;
	var x0 = x == 1;
	var y0 = y == 1;
	if(x0 && y0) return Lambda.array(path);
	if(x0) return letters.Path.mapArr(path,function(v) {
		var v0 = v.v0;
		var v1 = v.v1;
		switch(v1) {
		case "L":case "M":
			v0 = [v0[0],y * v0[1]];
			break;
		case "Q":
			v0 = [v0[0],y * v0[1],v0[2],y * v0[3]];
			break;
		default:
		}
		var commandData = { v0 : v0, v1 : v1};
		return commandData;
	});
	if(y0) return letters.Path.mapArr(path,function(v2) {
		var v01 = v2.v0;
		var v11 = v2.v1;
		switch(v11) {
		case "L":case "M":
			v01 = [x * v01[0],v01[1]];
			break;
		case "Q":
			v01 = [x * v01[0],v01[1],x * v01[2],v01[3]];
			break;
		default:
		}
		var commandData1 = { v0 : v01, v1 : v11};
		return commandData1;
	});
	return letters.Path.mapArr(path,function(v3) {
		var v02 = v3.v0;
		var v12 = v3.v1;
		switch(v12) {
		case "L":case "M":
			v02 = [x * v02[0],y * v02[1]];
			break;
		case "Q":
			v02 = [x * v02[0],y * v02[1],x * v02[2],y * v02[3]];
			break;
		default:
		}
		var commandData2 = { v0 : v02, v1 : v12};
		return commandData2;
	});
};
letters.Path.scaleTranslate = function(path,x_,y_,sx_,sy_) {
	var x = x_;
	var y = y_;
	var sx = sx_;
	var sy = sy_;
	return letters.Path.mapArr(path,function(v) {
		var v0 = v.v0;
		var v1 = v.v1;
		switch(v1) {
		case "L":case "M":
			v0 = [sx * v0[0] + x,sy * v0[1] + y];
			break;
		case "Q":
			v0 = [sx * v0[0] + x,sy * v0[1] + y,sx * v0[2] + x,sy * v0[3] + y];
			break;
		default:
		}
		var commandData = { v0 : v0, v1 : v1};
		return commandData;
	});
};
letters.Path.rotateXYZ = function(path,rX,rY,rZ,zSpecial,ox,oy,oz) {
	if(ox == null || oy == null || oz == null) {
		var dim = letters.Path.getDim(path);
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
	return letters.Path.mapArr(path,function(v) {
		var v0 = v.v0;
		var v1 = v.v1;
		switch(v1) {
		case "M":case "L":
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
		default:
		}
		var commandData = { v0 : v0, v1 : v1};
		return commandData;
	});
};
letters.Path.getDim = function(path) {
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
		case "M":case "L":case "Q":
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
	return { pos : { x : l, y : t}, dim : { x : r - l, y : b - t}, centre : { x : l + (r - l) / 2, y : t + (b - t) / 2}, end : { x : r, y : b}};
};
letters.Path.tracePoints = function(path) {
	var str = "";
	var path1 = Lambda.map(path,function(v) {
		str += Std.string(v.v0[0]) + " " + Std.string(v.v0[1]) + "\n";
		return v;
	});
	console.log(str);
};
letters.Path.mapArr = function(it,f) {
	var a = new Array();
	var $it0 = $iterator(it)();
	while( $it0.hasNext() ) {
		var x = $it0.next();
		a.push(f(x));
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
			case "0":case "1":case "2":case "3":case "4":case "5":case "6":case "7":case "8":case "9":
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
			return this.createCommandData(2,"L");
		case "Q":
			return this.createCommandData(4,"Q");
		case "M":
			return this.createCommandData(2,"M");
		default:
			return this.createCommandData(2,"M");
		}
	}
	,createCommandData: function(len,command) {
		this.last = command;
		var num = "";
		var increment = 0;
		var isX = true;
		var arr = new Array();
		while(increment < len) {
			var $char = this.str.charAt(this.count);
			this.count++;
			if((function($this) {
				var $r;
				switch($char) {
				case "0":case "1":case "2":case "3":case "4":case "5":case "6":case "7":case "8":case "9":
					$r = true;
					break;
				default:
					$r = false;
				}
				return $r;
			}(this)) || $char == ".") num += $char; else {
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
		var commandData = { v0 : arr, v1 : command};
		return commandData;
	}
	,getCentre: function() {
		if(!this.hasIterated) letters.Path.mapArr(this,function(v) {
			return v;
		});
		return { x : this.left + (this.right - this.left) / 2, y : this.top + (this.bottom - this.top) / 2};
	}
};
letters.paragraphPath = {};
letters.paragraphPath.GraphicsPoints = function() { };
letters.paragraphPath.GraphicsPoints.__name__ = true;
letters.paragraphPath.GraphicsPoints.drawLinePath = function(arr) {
	var g = turtle.Turtle.surface;
	var string;
	var col;
	g.strokeStyle = (function($this) {
		var $r;
		var this1 = col = 14496733;
		$r = string = "#" + StringTools.hex(this1,6);
		return $r;
	}(this));
	g.lineWidth = 1;
	g.moveTo(arr[0].x,arr[0].y);
	var _g = 0;
	while(_g < arr.length) {
		var p = arr[_g];
		++_g;
		g.lineTo(p.x,p.y);
	}
	g.stroke();
};
letters.paragraphPath.GraphicsPoints.drawCommandsMore = function(renderPath) {
	var col;
	var g = turtle.Turtle.surface;
	g.strokeStyle = col = 0;
	g.lineWidth = 1;
	g.fillStyle = col = 0;
	g.beginPath();
	turtle.Turtle.drawCommands(g,renderPath);
	g.stroke();
	g.closePath();
	g.fill();
};
letters.paragraphPath.GraphicsPoints.drawCommandsAndFill = function(renderPath,line,fill) {
	var col;
	var g = turtle.Turtle.surface;
	g.strokeStyle = col = line;
	g.lineWidth = 1;
	g.fillStyle = col = fill;
	g.beginPath();
	turtle.Turtle.drawCommands(g,renderPath);
	g.stroke();
	g.closePath();
	g.fill();
};
letters.paragraphPath.ParagraphPathDemo = function() {
	new turtle.Turtle();
	this.showInstructions();
	this.pointMaker = new letters.paragraphPath.PointMaker(40,$bind(this,this.draw));
};
letters.paragraphPath.ParagraphPathDemo.__name__ = true;
letters.paragraphPath.ParagraphPathDemo.main = function() {
	new letters.paragraphPath.ParagraphPathDemo();
};
letters.paragraphPath.ParagraphPathDemo.prototype = {
	showInstructions: function() {
		var g = turtle.Turtle.surface;
		var coloring = letters.Path.rainbowPencilHighlight;
		var instructions = "click on screen to create a path of forty points for the text to follow";
		var path = letters.Path.generateVectorText(instructions,100.,50.,.7,300.,22.,null,coloring,null);
		path = letters.Path.rotateXYZ(path,Math.PI / 10,Math.PI / 3,Math.PI / 10,1);
		path = letters.Path.scale(path,3,3);
		turtle.Turtle.drawCommands(g,path);
	}
	,draw: function() {
		var points = this.pointMaker.points;
		points = letters.pathway.MathPoints.generateMidPoints(this.pointMaker.points);
		var equaPoints = letters.pathway.Equa.getEquaPoints(points,100);
		var sidePoints = letters.pathway.Sides.getPoints(equaPoints.points);
		var sentence = "hi my name is justin and i live in bath a small city in the south west of the uk";
		new letters.paragraphPath.ParagraphPathRepeat(sentence,sidePoints);
	}
};
letters.paragraphPath.ParagraphPathRepeat = function(sentence,sidePoints) {
	turtle.Turtle.surface.clearRect(0,0,Std.parseInt("1000"),Std.parseInt("800"));
	var g = turtle.Turtle.surface;
	var renderPath;
	var coloring = letters.Path.rainbowPencilHighlight;
	var path = letters.Path.generateVectorText(sentence,43.,200.,.7,640.,22.,null,coloring,coloring);
	var path1 = letters.Path.translate(path,43,-197);
	path1 = letters.Path.scale(path1,1.4,-0.3);
	path1 = letters.Path.translate(path1,0,10);
	renderPath = letters.pathway.Sides.mapToRouting(sidePoints,path1);
	turtle.Turtle.drawCommands(g,renderPath);
	letters.paragraphPath.GraphicsPoints.drawCommandsMore(renderPath);
	var aPath;
	var lastPath = path1;
	var k;
	var paragraphWidth = letters.Path.getDim(lastPath).end.x;
	var maxY = sidePoints.length + 1;
	while(true) {
		aPath = letters.Path.translate(lastPath,letters.Path.getDim(path1).end.x + 1,0);
		paragraphWidth = letters.Path.getDim(aPath).end.x;
		if(paragraphWidth > maxY) break;
		renderPath = letters.pathway.Sides.mapToRouting(sidePoints,aPath);
		turtle.Turtle.drawCommands(g,renderPath);
		lastPath = aPath;
	}
};
letters.paragraphPath.ParagraphPathRepeat.__name__ = true;
letters.paragraphPath.PointMaker = function(tot_,fin_) {
	this.hasFin = false;
	this.points = [];
	this.fin = fin_;
	this.tot = tot_;
	turtle.Turtle.PressDownStage($bind(this,this.createPoint));
};
letters.paragraphPath.PointMaker.__name__ = true;
letters.paragraphPath.PointMaker.prototype = {
	createPoint: function(e) {
		var pos = turtle.Turtle.CurrentPosInt(e);
		var g = turtle.Turtle.surface;
		this.randomColor();
		turtle.Turtle.circle8(pos.x,pos.y);
		this.points.push({ x : pos.x, y : pos.y});
		if(this.points.length == this.tot) {
			turtle.Turtle.RemovePressDownStage();
			this.hasFin = true;
			this.fin();
		}
	}
	,randomColor: function() {
		var g = turtle.Turtle.surface;
		var col1 = letters.paragraphPath.RainbowPencilColours.random();
		var string;
		var col3;
		g.strokeStyle = string = "#" + StringTools.hex(col1,6);
		g.lineWidth = 2;
		var col2 = col1;
		while(col1 == col2) col2 = letters.paragraphPath.RainbowPencilColours.random();
		if(this.points.length == 0) g.fillStyle = (function($this) {
			var $r;
			var this1 = col3 = 65280;
			$r = string = "#" + StringTools.hex(this1,6);
			return $r;
		}(this)); else if(this.points.length == this.tot - 1) g.fillStyle = (function($this) {
			var $r;
			var this2 = col3 = 16711680;
			$r = string = "#" + StringTools.hex(this2,6);
			return $r;
		}(this)); else g.fillStyle = string = "#" + StringTools.hex(col2,6);
	}
};
letters.paragraphPath.RainbowPencilColours = function() { };
letters.paragraphPath.RainbowPencilColours.__name__ = true;
letters.paragraphPath.RainbowPencilColours.colors = function() {
	return [13816001,13467688,13802769,14905640,15755121,13777201,11480113,9450302,8797520,5786205,5545667,2912413,4553390,3558765,3640429,7251784,3562916,4550210,12683310,8467492,4206116,2696224,5396305,1776409];
};
letters.paragraphPath.RainbowPencilColours.random = function() {
	var col = [13816001,13467688,13802769,14905640,15755121,13777201,11480113,9450302,8797520,5786205,5545667,2912413,4553390,3558765,3640429,7251784,3562916,4550210,12683310,8467492,4206116,2696224,5396305,1776409];
	return col[Math.round(Math.random() * (col.length + 1))];
};
letters.pathway = {};
letters.pathway.Equa = function() { };
letters.pathway.Equa.__name__ = true;
letters.pathway.Equa.getEquaPoints = function(pointsIn,numSections) {
	var totDistance;
	var currDistance = [];
	var accumDistance = [];
	var points = [];
	totDistance = 0;
	var dist3 = new letters.pathway.ThreeIterator(0,pointsIn.length,1);
	dist3.arr = pointsIn;
	while( dist3.hasNext() ) {
		var dist = dist3.next();
		var pNext = dist3.arrNext;
		var d = letters.pathway.MathPoints.distance(pNext[0],pNext[1]);
		currDistance.push(d);
		accumDistance.push(totDistance);
		totDistance += d;
	}
	var iterator3 = new letters.pathway.ThreeIterator(0,pointsIn.length,2);
	iterator3.arr = pointsIn;
	while( iterator3.hasNext() ) {
		var i = iterator3.next();
		var factor;
		var factorWorks = 1 / numSections;
		if(currDistance.length > i) factor = 10 * currDistance[i] / totDistance; else factor = factorWorks;
		if(factor == 0) factor = factorWorks;
		var it0_1 = new letters.pathway.Iterator0_1(factorWorks);
		var pNext1 = iterator3.arrNext;
		while( it0_1.hasNext() ) {
			var t = it0_1.next();
			points.push({ x : letters.pathway.MathPoints._quadraticBezier(t,pNext1[0].x,pNext1[1].x,pNext1[2].x), y : letters.pathway.MathPoints._quadraticBezier(t,pNext1[0].y,pNext1[1].y,pNext1[2].y)});
		}
	}
	return { totDistance : totDistance, currDistance : currDistance, accumDistance : accumDistance, points : points};
};
letters.pathway.Iterator0_1 = function(step_) {
	this.min = 0.;
	this.step = step_;
	this.count = 1;
	this.max = 1.;
};
letters.pathway.Iterator0_1.__name__ = true;
letters.pathway.Iterator0_1.prototype = {
	hasNext: function() {
		return this.min < this.max;
	}
	,next: function() {
		var minOld = Math.round(this.min * 1000000) / 1000000;
		this.min = this.count++ * this.step;
		return minOld;
	}
	,iterator: function() {
		return this;
	}
};
letters.pathway.MathPoints = function() { };
letters.pathway.MathPoints.__name__ = true;
letters.pathway.MathPoints.arcTan = function(p0,p1) {
	return Math.atan2(p1.y - p0.y,p1.x - p0.x);
};
letters.pathway.MathPoints.distance = function(p0,p1) {
	var x = p0.x - p1.x;
	var y = p0.y - p1.y;
	return Math.sqrt(x * x + y * y);
};
letters.pathway.MathPoints.quadraticBezier = function(t,arr) {
	return { x : letters.pathway.MathPoints._quadraticBezier(t,arr[0].x,arr[1].x,arr[2].x), y : letters.pathway.MathPoints._quadraticBezier(t,arr[0].y,arr[1].y,arr[2].y)};
};
letters.pathway.MathPoints._quadraticBezier = function(t,startPoint,controlPoint,endPoint) {
	var u = 1 - t;
	return Math.pow(u,2) * startPoint + 2 * u * t * controlPoint + Math.pow(t,2) * endPoint;
};
letters.pathway.MathPoints.generateMidPoints = function(arr) {
	var out = [];
	var a;
	var b;
	var len = arr.length - 2;
	var _g = 0;
	while(_g < len) {
		var i = _g++;
		a = arr[i];
		b = arr[i + 1];
		out.push({ x : (b.x + a.x) / 2, y : (b.y + a.y) / 2});
		out.push({ x : b.x, y : b.y});
	}
	a = arr[0];
	out.unshift({ x : a.x, y : a.y});
	out.unshift({ x : a.x, y : a.y});
	b = arr[arr.length - 1];
	out.push({ x : b.x, y : b.y});
	out.push({ x : b.x, y : b.y});
	out.push({ x : b.x, y : b.y});
	return out;
};
letters.pathway.Sides = function() { };
letters.pathway.Sides.__name__ = true;
letters.pathway.Sides.getPoints = function(points_) {
	var thetas = [];
	var points = [];
	var iterTheta3 = new letters.pathway.ThreeIterator(0,points_.length,1);
	iterTheta3.arr = points_;
	while( iterTheta3.hasNext() ) {
		var i = iterTheta3.next();
		thetas.push(letters.pathway.Sides.createTheta(iterTheta3.arrNext));
	}
	thetas.unshift(thetas[0]);
	thetas.unshift(thetas[0]);
	var aSidePoint;
	var lastSidePoint = letters.pathway.Sides.createInitSidePoint(thetas[0],points_[0]);
	var count = 0;
	var _g = 0;
	while(_g < points_.length) {
		var p = points_[_g];
		++_g;
		aSidePoint = letters.pathway.Sides.createSidePoints(thetas[count],lastSidePoint,p);
		count++;
		points.push(aSidePoint);
		lastSidePoint = aSidePoint;
	}
	return points;
};
letters.pathway.Sides.createTheta = function(pNext) {
	return (letters.pathway.MathPoints.arcTan(pNext[0],pNext[1]) + letters.pathway.MathPoints.arcTan(pNext[1],pNext[2])) / 2;
};
letters.pathway.Sides.createInitSidePoint = function(theta,nextP) {
	var dx = 5 * Math.cos(theta + Math.PI / 2);
	var dy = 5 * Math.sin(theta + Math.PI / 2);
	return { x : nextP.x, y : nextP.y, dx : dx, dy : dy};
};
letters.pathway.Sides.createSidePoints = function(theta,lastSp,nextP) {
	var dx = 5 * Math.cos(theta + Math.PI / 2);
	var dy = 5 * Math.sin(theta + Math.PI / 2);
	var x1 = nextP.x + 15 * dx;
	var y1 = nextP.y + 15 * dy;
	var x2 = nextP.x - 15 * dx;
	var y2 = nextP.y - 15 * dy;
	var sAx = lastSp.x + 15 * lastSp.dx;
	var sAy = lastSp.y + 15 * lastSp.dy;
	var sBx = lastSp.x - 15 * lastSp.dx;
	var sBy = lastSp.y - 15 * lastSp.dy;
	var same = Math.abs(letters.pathway.Sides.distance(x1,y1,sAx,sAy) - letters.pathway.Sides.distance(x2,y2,sBx,sBy));
	var dif = Math.abs(letters.pathway.Sides.distance(x2,y2,sAx,sAy) - letters.pathway.Sides.distance(x1,y1,sBx,sBy));
	var totSame = letters.pathway.Sides.distance(x1,y1,sAx,sAy) + letters.pathway.Sides.distance(x2,y2,sBx,sBy);
	var totDif = letters.pathway.Sides.distance(x2,y2,sAx,sAy) + letters.pathway.Sides.distance(x1,y1,sBx,sBy);
	if(same > dif && totSame < totDif) {
	} else {
		dx = -dx;
		dy = -dy;
	}
	return { x : nextP.x, y : nextP.y, dx : dx, dy : dy};
};
letters.pathway.Sides.distance = function(p0x,p0y,p1x,p1y) {
	var x = p0x - p1x;
	var y = p0y - p1y;
	return Math.sqrt(x * x + y * y);
};
letters.pathway.Sides.mapToRouting = function(sidePoints_,pathIn) {
	var sp = sidePoints_;
	return letters.Path.mapArr(pathIn,function(v) {
		var v0 = v.v0;
		var v1 = v.v1;
		var p1 = sp[Math.round(v0[0])];
		switch(v1) {
		case "L":case "M":
			v0 = [p1.x + v0[1] * p1.dx,p1.y + v0[1] * p1.dy];
			break;
		case "Q":
			var p2 = sp[Math.round(v0[2])];
			v0 = [p1.x + v0[1] * p1.dx,p1.y + v0[1] * p1.dy,p2.x + v0[3] * p1.dx,p2.y + v0[3] * p1.dy];
			break;
		default:
		}
		var commandData = { v0 : v0, v1 : v1};
		return commandData;
	});
};
letters.pathway.ThreeIterator = function(min_,max_,step_) {
	this.min = min_;
	this.max = max_;
	this.step = step_;
};
letters.pathway.ThreeIterator.__name__ = true;
letters.pathway.ThreeIterator.prototype = {
	hasNext: function() {
		return this.min < this.max - 2;
	}
	,next: function() {
		this.arrNext = this.arr.slice(this.min,this.min + 3);
		this.min += this.step;
		return this.min;
	}
	,iterator: function() {
		return this;
	}
};
var turtle = {};
turtle.Turtle = function() {
	var basicJs = new turtle.targetJS.BasicJs();
	turtle.Turtle.surface = basicJs.surface;
};
turtle.Turtle.__name__ = true;
turtle.Turtle.RemovePressDownStage = function() {
	var _g = 0;
	var _g1 = turtle.Turtle.pressDownStageFunc;
	while(_g < _g1.length) {
		var func = _g1[_g];
		++_g;
		window.document.body.onmousedown = null;
	}
};
turtle.Turtle.PressDownStage = function(func) {
	if(func == null) return turtle.Turtle.RemovePressDownStage();
	window.document.body.onmousedown = func;
	turtle.Turtle.pressDownStageFunc.push(func);
};
turtle.Turtle.CurrentPosFloat = function(e) {
	var currPos;
	var p = e;
	currPos = { x : p.clientX, y : p.clientY};
	return currPos;
};
turtle.Turtle.circle8 = function(x,y) {
	var radius = 8;
	turtle.Turtle.surface.beginPath();
	turtle.Turtle.surface.arc(x,y,radius,0,2 * Math.PI,false);
	turtle.Turtle.surface.stroke();
	turtle.Turtle.surface.closePath();
	turtle.Turtle.surface.fill();
};
turtle.Turtle.CurrentPosInt = function(e) {
	var currPos;
	var p = e;
	currPos = { x : Math.round(p.clientX), y : Math.round(p.clientY)};
	return currPos;
};
turtle.Turtle.lines = function(g,renderPath) {
	var p;
	var _g = 0;
	while(_g < renderPath.length) {
		var cmd = renderPath[_g];
		++_g;
		p = cmd.v0;
		var command = cmd.v1;
		switch(command) {
		case "M":
			g.moveTo(p[0],p[1]);
			break;
		case "L":
			g.lineTo(p[0],p[1]);
			break;
		default:
		}
	}
};
turtle.Turtle.drawCommands = function(g,renderPath) {
	var p;
	var lastCommand = "M";
	var col;
	var _g = 0;
	while(_g < renderPath.length) {
		var cmd = renderPath[_g];
		++_g;
		p = cmd.v0;
		var command = cmd.v1;
		switch(command) {
		case "M":
			g.moveTo(p[0],p[1]);
			break;
		case "L":
			g.lineTo(p[0],p[1]);
			break;
		case "Q":
			g.quadraticCurveTo(p[0],p[1],p[2],p[3]);
			break;
		case "O":
			turtle.Turtle.surface.closePath();
			turtle.Turtle.surface.stroke();
			turtle.Turtle.surface.fill();
			turtle.Turtle.surface.lineWidth = 5;
			turtle.Turtle.surface.strokeStyle = "#" + StringTools.hex(p[0] | 0,6);
			break;
		case "F":
			if(lastCommand != "O") {
				turtle.Turtle.surface.stroke();
				turtle.Turtle.surface.closePath();
				turtle.Turtle.surface.fill();
			}
			turtle.Turtle.surface.fillStyle = "#" + StringTools.hex(p[0] | 0,6);
			turtle.Turtle.surface.beginPath();
			break;
		}
		lastCommand = command;
	}
	turtle.Turtle.surface.stroke();
	turtle.Turtle.surface.closePath();
	turtle.Turtle.surface.fill();
};
turtle.Turtle.quadTo = function(g,x1,y1,x2,y2) {
	g.quadraticCurveTo(x1,y1,x2,y2);
};
turtle.Turtle.clear = function() {
	turtle.Turtle.surface.clearRect(0,0,Std.parseInt("1000"),Std.parseInt("800"));
};
turtle.targetJS = {};
turtle.targetJS.BasicJs = function() {
	var setup = new turtle.targetJS.SetupCanvas();
	this.surface = setup.surface;
	var body = window.document.body;
	body.appendChild(setup.dom);
};
turtle.targetJS.BasicJs.__name__ = true;
turtle.targetJS._ColorJS = {};
turtle.targetJS._ColorJS.ColorJS_Impl_ = function() { };
turtle.targetJS._ColorJS.ColorJS_Impl_.__name__ = true;
turtle.targetJS._ColorJS.ColorJS_Impl_.toString = function(this1) {
	return "#" + StringTools.hex(this1,6);
};
turtle.targetJS.SetupCanvas = function() {
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
turtle.targetJS.SetupCanvas.__name__ = true;
turtle.targetJS.SetupCanvas.prototype = {
	parseInt: function(e) {
		return Std.parseInt(e);
	}
};
function $iterator(o) { if( o instanceof Array ) return function() { return HxOverrides.iter(o); }; return typeof(o.iterator) == 'function' ? $bind(o,o.iterator) : o.iterator; }
var $_, $fid = 0;
function $bind(o,m) { if( m == null ) return null; if( m.__id__ == null ) m.__id__ = $fid++; var f; if( o.hx__closures__ == null ) o.hx__closures__ = {}; else f = o.hx__closures__[m.__id__]; if( f == null ) { f = function(){ return f.method.apply(f.scope, arguments); }; f.scope = o; f.method = m; o.hx__closures__[m.__id__] = f; } return f; }
String.__name__ = true;
Array.__name__ = true;
haxe.Resource.content = [{ name : "gletter", data : "TTIxLjk1IDIxLjg1IFExOS4wNSAyMi4yIDE3LjMgMjQuNyAxNS4yIDI5LjI1IDE3LjIgMzMuOTUgMTguNDUgMzYuOSAyMS4zNSAzNy4zNSAyNS43NSAzNi45IDI2LjkgMzMuNCAyNy44NSAyOS44NSAyNi43NSAyNS4zIDI1LjM1IDIxLjQgMjEuOTUgMjEuODUgTTExLjc1IDQ3Ljk1IFExMS42NSA0Ni4zIDEyLjkgNDYuMSBMMTQuMTUgNDYuMzUgMTcuMDUgNDcuNyBRMjguNjUgNTAgMjYuNzUgMzguOTUgMTkuMDUgNDEuMzUgMTUuMyAzNy40NSAxMS45IDM1LjI1IDExLjM1IDI5LjI1IDEyLjE1IDI0LjU1IDE0Ljg1IDIxLjk1IDIwLjI1IDE2LjY1IDI4LjM1IDIwLjMgMzEuMTUgMjEuNyAzMi4zIDI5LjIgTDMxLjk1IDQ0IFEzMC4zIDUzLjIgMTkuOCA1Mi42IDE1LjEgNTEuOCAxMy4yIDUwLjQgMTIuMSA0OS43NSAxMS45IDQ4Ljk1IEwxMS43NSA0Ny45NQ"},{ name : "lletter", data : "TTIzLjcgMzcuMTUgUTIzLjg1IDM5Ljg1IDIwLjkgMzkuNSAxOS42NSAzOS40IDE4Ljc1IDM4LjYgMTcuOSAzNy4xIDE3Ljk1IDM0Ljg1IEwxOC4zIDQuNSBRMTguNzUgMy40IDE5Ljg1IDMuMiBMMjEuMyAyLjkgUTIyLjggMi43NSAyMi44NSAzLjcgTDIzIDI4LjggMjMuNyAzNy4xNQ"},{ name : "wletter", data : "TTMuOCAxNi42NSBRNS41NSAxNS41IDYuOSAxNi44NSA4LjggMTguOCA5LjcgMjEuNCBMMTMuNCAzMS42NSBRMTQuOCAzNS43NSAxNS45IDMxLjc1IEwxOS44NSAxOS42IFEyMC42NSAxNy42NSAyMi4yNSAxNy42IDIzLjYgMTguMDUgMjQgMTkuMyBMMjguMzUgMzIuMTUgUTI4LjggMzMuMSAyOS42NSAzMi41IDMyLjYgMjYuNTUgMzQuNCAyMC44IDM0Ljg1IDE5LjI1IDM1LjY1IDE4LjI1IDM2LjYgMTcuMiAzNy41NSAxNi45IEwzNy42NSAxNi45IFEzOC4xNSAxNi44NSAzOCAxNy44IEwzNi45NSAyMC44IDMxLjY1IDM3LjUgUTMwIDQyLjEgMjcuMzUgMzguNzUgTDI3LjMgMzguNyBRMjUuMDUgMzUuNDUgMjQuMSAzMi42IEwyMS4xIDI2LjQ1IFExOC40NSAzMi43IDE1LjI1IDM4LjY1IDEyLjc1IDQxLjYgMTEuMjUgMzguNTUgTDMuNjUgMTguNTUgUTMuMzUgMTcuNiAzLjggMTYuNjU"},{ name : "bletter", data : "TTI1LjQ1IDE1LjUgUTI5LjUgMTYuNCAzMS44IDIxLjIgMzIuOSAyMy40NSAzMy4wNSAyNi4xNSAzMy4yIDI5IDMyLjMgMzEuNDUgMzEuNCAzMy44NSAzMC4zNSAzNS4xNSBMMjguNTUgMzcuMiAyNi42IDM4LjUgMjYuMyAzOC43IDI1LjYgMzkgMjMuNyAzOS42NSAyMi41IDM5LjggMTkuMSAzOS45NSAxOCAzOS44NSAxNi4zIDM5LjcgMTQuNSAzOS41IFExMi4zNSAzOSAxMS41IDM3LjcgMTAuNTUgMzYuMiAxMC41NSAzNC4xIEwxMC45NSA3LjMgMTEgNC45IDExLjUgNC41IFExMi4xNSAzLjg1IDEyLjggMy43IDE0LjE1IDIuOTUgMTUuMyAzLjcgTDE2LjIgMTcuNyBRMjEuNDUgMTQuNiAyNS40NSAxNS41IE0xNi4yIDIxLjMgTDE1Ljc1IDIzLjE1IDE1LjUgMjUuNCAxNS41IDMxLjUgUTE1LjUgMzMuODUgMTYuMzUgMzUuNCAxNy42IDM3LjEgMjAuOCAzNy4zIDI3LjQgMzcuMDUgMjcuNSAyNy4yIDI3LjYgMTcuMzUgMTkuNyAxOC43IDE3LjY1IDE4LjkgMTYuMiAyMS4z"},{ name : "iletter", data : "TTIzLjYgNi43IFEyMy4zNSA4LjMgMjIuNiA4Ljg1IDIwLjYgOS42IDE5LjI1IDguODUgTDE4LjcgOC4zNSBRMTguMiA3Ljg1IDE4LjA1IDYuODUgMTguMjUgNS43NSAxOSA0Ljk1IDIwLjE1IDQuMzUgMjEuMyA0LjQ1IEwyMS41IDQuNSAyMS44NSA0LjU1IFEyMi43NSA0LjY1IDIzLjI1IDUuNDUgMjMuNjUgNS45IDIzLjYgNi43IE0yMC40NSAxNS43IEwyMS45IDE1LjU1IDIyLjMgMTUuNjUgMjIuNyAxNS43NSAyMy41NSAzNi4wNSBRMjQuMDUgNDAuMSAyMC4yIDQwLjEgMTkuMDUgNDAuMSAxOC43IDM5LjIgMTguNDUgMzguNDUgMTguNCAzNi4wNSBMMTguNCAzMS40IDE4LjM1IDI5LjQ1IDE4LjM1IDIwLjggMTguMyAxOC40IFExOC4yNSAxNy4xIDE4LjM1IDE2LjU1IEwxOC44IDE2LjE1IFExOS40NSAxNS44NSAyMC4yNSAxNS43IEwyMC40NSAxNS43"},{ name : "qletter", data : "TTE5IDE3Ljg1IFExNy45IDE4LjQgMTYuNSAxOS44NSAxNS4xIDIxLjI1IDE0LjY1IDI1LjI1IDE0LjEgMzYuMTUgMjEuMyAzNi4zNSAyNC44IDM2LjE1IDI2LjYgMzMuMzUgTDI2Ljc1IDIyLjMgUTI2LjggMTkuNSAyNS4wNSAxOC40IDIzLjggMTcuMzUgMjIgMTcuMyAyMC4xIDE3LjI1IDE5IDE3Ljg1IE0xMy4xNSAxOC4zIFExNS43NSAxNS43IDE4Ljc1IDE0Ljk1IDIyLjUgMTQgMjYuODUgMTYgTDI5LjY1IDE1LjU1IFEzMC44NSAxNS4zIDMxLjcgMTYuOTUgTDMxLjg1IDQ5LjU1IDMwLjI1IDQ5Ljk1IDMwLjA1IDQ5Ljk1IDI4LjYgNDkuNyBRMjcuMzUgNDkuMSAyNy4yNSA0OC4yIEwyNi41IDM3LjQgUTI1LjEgMzguNjUgMjIuNSAzOS41IEwyMC42IDM5LjcgUTE2LjIgMzkuNzUgMTQuNDUgMzguMiA5LjQgMzUgOS44NSAyNi4zIDEwLjA1IDIyLjIgMTMuMTUgMTguMw"},{ name : "vletter", data : "TTE1LjM1IDE4LjQgTDE2LjggMjIuNCAyMS4xIDMzLjI1IDIxLjQgMzMuNzUgMjEuNzUgMzMuNiBRMjUuMjUgMjYuODUgMjguMTUgMTguMjUgMjkuMjUgMTUuOCAzMC40IDE1LjggTDMxLjE1IDE1Ljc1IFEzMi4xIDE1Ljg1IDMyLjE1IDE2LjM1IEwyOS45IDIyLjYgMjQuODUgMzUgUTIyLjggMzkuNDUgMjIuMSAzOS43NSBMMjEuNSA0MCBRMjAgNDAuNCAxOC4zIDM3LjggTDE2Ljg1IDM0Ljg1IDkuOCAxNy41IFE5LjI1IDE2LjY1IDkuNTUgMTYuMTUgOS44NSAxNS42IDEwLjY1IDE1LjY1IDEzLjI1IDE1Ljc1IDEzLjk1IDE2LjI1IDE0LjggMTYuOSAxNS4zNSAxOC40"},{ name : "yletter", data : "TTEwLjcgMTggTDE0LjggMTcuOTUgUTE2LjE1IDE5LjggMTcuOTUgMjUuMzUgMTkgMjguMiAyMS40NSAzMy40NSAyMS44NSAzNC4zIDIyLjcgMzQuMSAyMy42IDMzLjg1IDI0Ljc1IDMxLjA1IEwyNi40NSAyNi44IDI3LjkgMjIuNCAyOS4zIDE4LjEgUTI5LjU1IDE3LjI1IDMwLjY1IDE3LjMgMzIuNDUgMTcuNDUgMzIuNiAxOC41NSBMMzAuMiAyNi43IDI4IDM0LjA1IFEyNi42NSAzOC4zNSAyNS4zNSA0MS4yNSAyMy4yIDQ2IDIwLjEgNDkuMzUgMTYuOCA1Mi40NSAxNC42NSA1Mi44IDEwLjA1IDUzLjIgMTAuMDUgNTEuMSAxMC4xIDUwLjQgMTAuNSA0OS45NSAxMC45IDQ5LjQ1IDExLjkgNDkuMTUgMTMuNCA0OC42NSAxNC45IDQ5LjE1IDE2LjYgNDkuMiAxOS43IDQ0Ljk1IDIwLjc1IDQzLjMgMjEuMSA0MS42IEwyMSA0MC45IFExNCAyOS4zNSAxMC4wNSAxOS42IDkuNyAxOS4xIDkuOSAxOC42IEwxMC43IDE4"},{ name : "cletter", data : "TTI5LjcgMjEuNjUgTDI5LjUgMjEuNiAyOC43IDIxLjM1IDI2LjcgMTkuMyBRMjUuNCAxNy45IDIyLjUgMTcuOSAxOS42NSAxNy45IDE3Ljc1IDIwLjggMTYuMiAyMy4yIDE2LjIgMjUuNyAxNi4yIDMwLjU1IDE4LjY1IDMzLjUgMjAuNyAzNS45NSAyMi45NSAzNS45NSAyOS43NSAzNS45NSAzMi4wNSAzMi4zIEwzMi4yIDMyLjUgMzIuMjUgMzMuMiBRMzIuMjUgMzUuNjUgMjkuNiAzNy43IDI2LjcgMzkuOTUgMjIuMzUgMzkuOTUgMTYuODUgMzkuOTUgMTMuODUgMzYgMTEuMzUgMzIuNzUgMTEuMzUgMjguMyAxMS4zNSAyMi4wNSAxNS4zNSAxOC4xNSAxOC43NSAxNC44NSAyMi44IDE0Ljg1IDI3LjQ1IDE0Ljg1IDI5LjggMTYuOCAzMS40NSAxOC4xNSAzMS40NSAxOS42NSAzMS40NSAyMS40IDI5LjcgMjEuNjU"},{ name : "fletter", data : "TTI4IDMuMjUgUTI5LjggMy41NSAzMC42NSA0Ljk1IDMxLjE1IDUuOSAzMS4wNSA2LjUgMzEuMiA3LjM1IDI5LjkgOC4xIDI5LjEgOC4yIDI4LjQgNy42NSBMMjcuOSA3LjIgMjcuNDUgNi43IDI2LjM1IDYuMiAyNS45NSA2LjE1IFEyNS4yIDYgMjQuNCA2LjQ1IDIxLjI1IDcuOTUgMjEuNyAxMi4wNSAyMS41IDE1LjEgMjQuNyAxNS4yIEwyNS41IDE1LjMgMjcuMTUgMTUuNjUgUTI4Ljc1IDE2LjggMjcuMyAxNy45NSBMMjUuNSAxOC4xNSAyNC44IDE4LjMgUTIxLjkgMTguMyAyMi4xIDIyIEwyMS40NSAzNy41IFEyMS44NSA0MC40IDE4Ljg1IDQwLjM1IDE2LjU1IDQwLjg1IDE2LjY1IDM2Ljg1IEwxNi42NSAyNC40IDE2LjE1IDE4LjkgUTE1LjMgMTcuOSAxNC41NSAxNy44NSAxMC43IDE2Ljc1IDE0LjUgMTUuNjUgMTYuMTUgMTUuMSAxNi4zNSAxMy44NSBMMTguMyA3LjkgUTE5Ljc1IDQuOCAyMi4xIDMuNyAyNC40IDIuNjUgMjggMy4yNQ"},{ name : "kletter", data : "TTEzLjggMy43NSBMMTQuNSAzLjk1IFExNC45NSAzLjg1IDE1LjMgNS42NSBMMTUuNTUgOS4wNSAxNS42IDE4Ljg1IFExNS42IDIxLjQgMTYuMSAyNC40NSBMMjQuNDUgMTcuNiBRMjcuMDUgMTUuOSAyOC4zIDE2IDI5LjMgMTYuMDUgMjguNzUgMTYuOCBMMjEuODUgMjQuNyBRMjEuNSAyNS4zIDIzLjQ1IDI3Ljk1IEwzMC43IDM3LjggUTMyIDM5LjUgMzAuMjUgMzkuNyAyOC40NSA0MC4zNSAyNS40IDM3LjkgMjIuMjUgMzUuMDUgMTkuNjUgMzAuNzUgMTguMSAyOS4xNSAxNi43NSAyOC41NSAxNi4xIDI4LjMgMTYuMDUgMjkuMSAxNS42IDMwLjc1IDE1LjU1IDM1LjUgMTUuMzUgMzcuOTUgMTQuOCAzOS4xIDEzLjkgMzkuODUgMTIuNjUgMzkuOCAxMS43IDM5LjYgMTEgMzkuMDUgMTAuNyAzOC4wNSAxMC41NSAzNi44NSAxMC4wNSAyMS4yIDEwLjk1IDUuNTUgMTAuOSA0LjY1IDEyLjEgNC4yNSAxMi45NSAzLjg1IDEzLjggMy43NQ"},{ name : "mletter", data : "TTE3Ljc1IDIzLjYgUTE3IDIwLjk1IDE1LjY1IDIwLjQgMTQuODUgMjAgMTQuMDUgMTkuOSBMMTMuNjUgMTkuODUgMTEuNjUgMjAuMjUgUTEwLjM1IDIwLjYgOS4yIDIxLjc1IDguMDUgMjIuOSA3LjY1IDI0Ljg1IDcuMjUgMjYuNzUgNy40IDMwLjQgNy40NSAzNy42IDYuNCAzOS4wNSAzLjA1IDQxLjI1IDMuMyAzNi42IEwzLjQ1IDE5LjE1IFEzLjQ1IDE2LjggNC42NSAxNi43NSA1LjkgMTYuNyA2LjQgMTguNSBMNi40NSAxOC42NSBRNy4xNSAxOS43IDguNyAxOC45IEwxMC45IDE3LjggUTE1LjkgMTMuNiAyMy4wNSAxOS40NSAyNy4wNSAxNi43IDMwLjEgMTYuNiAzMy4xNSAxNi40NSAzNC45NSAxNy45IDM2Ljc1IDE5LjM1IDM3LjMgMjEuNyAzOC4zIDI1LjY1IDM4LjM1IDM3LjU1IDM4LjEgMzkuNDUgMzcuMjUgMzkuNyAzNSA0MC43NSAzNC40IDM4Ljg1IDMzLjMgMzMuOCAzMy40NSAyOC40IEwzMy4wNSAyNS4wNSBRMzAuNjUgMTcuNzUgMjYuMyAyMC4xNSBMMjUuNSAyMC42NSBRMjQgMjEuOTUgMjMuNyAyMy41NSAyMy4zNSAyNS4yIDIzLjIgMjguNjUgTDIzLjI1IDMzLjIgMjMgMzYuNjUgUTIyLjcgMzkuNzUgMjEuNSA0MCAyMC41NSA0MC4zNSAxOS4yNSA0MCAxOC41NSAzOS43NSAxOC4zIDM4LjggTDE3Ljc1IDIzLjY"},{ name : "aletter", data : "TTIzLjUgMTguMSBRMTkuOSAxNi42IDE4LjIgMTkuMyAxNi40NSAyMS45NSAxNC44NSAyMS41IDEzLjg1IDIxLjI1IDEzLjU1IDIwLjYgTDEzLjM1IDIwIFExMy4yNSAxOS40NSAxMy40IDE4Ljk1IDEzLjY1IDE3Ljc1IDE1LjE1IDE2LjYgTDE2LjkgMTUuOCAxOS4yIDE1LjE1IDIwLjk1IDE0LjkgMjIuOTUgMTQuOSAyNi40NSAxNS4yNSBRMjcuNjUgMTUuNTUgMjguNCAxNi4xNSAzMS4xIDE3Ljk1IDMxLjE1IDIxLjU1IEwzMS44IDM4LjMgUTMxLjk1IDM5LjMgMzEuNSAzOS41NSBMMjkuNiAzOS45IFEyOC4yIDM5Ljk1IDI2Ljc1IDM5LjIgTDI2LjUgMzcuNyAyMi4yNSAzOS43IFEyMC4zIDQwLjQgMTcuOCA0MC40IDEzLjIgMzkuODUgMTIuMSAzNS43NSAxMS4yNSAzMy41IDEyLjU1IDMwLjY1IDEzLjEgMjguOSAxNS4zNSAyNy41NSAxOC40NSAyNS4yNSAyNC4yNSAyNC42NSAyNS4zIDI0LjcgMjUuOTUgMjQuMjUgMjYuNjUgMjMuNyAyNi4zNSAyMS40NSAyNiAxOS4xNSAyMy41IDE4LjEgTTIyLjQgMzYuOTUgUTI0LjggMzYuNjUgMjYuNCAzNC43IEwyNi43IDI3LjA1IDI0LjM1IDI3LjI1IFExOS43NSAyOC4xIDE4LjMgMjkuNiAxNi44NSAzMS4wNSAxNi45NSAzMy4yNSAxNy4wNSAzNS40IDE4LjUgMzYuMzUgMTkuOTUgMzcuMjUgMjIuNCAzNi45NQ"},{ name : "xletter", data : "TTIxLjQgMjMuMyBMMjYuMjUgMTcuMSBRMjcuMjUgMTUuODUgMjguMjUgMTUuNTUgMzAuMjUgMTUuNjUgMzAuNTUgMTYuMyBMMjMuNzUgMjUuNzUgUTIzLjM1IDI2LjI1IDI0LjE1IDI3LjYgTDMxLjc1IDM4LjUgUTMyLjc1IDM5Ljc1IDMwLjcgMzkuOCAyOC4xIDQwLjEgMjYuMjUgMzguMjUgTDIwLjA1IDMwLjE1IDEzLjQ1IDM5LjEgUTExLjA1IDQwLjIgOS43NSAzOS44NSA5LjI1IDM5LjM1IDkuODUgMzguNjUgTDE3Ljk1IDI3LjQ1IDEwLjUgMTYuMyBRMTAuNCAxNS44IDExIDE1Ljc1IEwxMy4yIDE1LjYgUTE1IDE1LjYgMTYuMiAxNi40IEwyMS40IDIzLjM"},{ name : "zletter", data : "TTEwLjQgMTYuNyBROS45IDE2LjMgMTAuMTUgMTUuOTUgTDEwLjU1IDE1LjY1IDExLjcgMTUuNSAxNC45IDE1LjMgUTI5LjE1IDE1IDMwLjg1IDE1LjUgMzIuMTUgMTYuMDUgMzEuNTUgMTcgTDE3LjQgMzYuMjUgMjcuNiAzNi43IFEzMS4yIDM2LjggMzIuNiAzOC4xIDMzLjI1IDM5IDMwLjk1IDM5LjQ1IEwyMC4xIDM5LjggMTIuOTUgMzkuNyBROC41IDM5LjggMTAuMSAzOC4wNSBMMjQuNjUgMTkgUTIyLjMgMTguMSAxNC42IDE3Ljc1IDExLjU1IDE3LjQ1IDEwLjQgMTYuNw"},{ name : "eletter", data : "TTMxIDE5IFEzMi4xIDIxLjQ1IDMyLjY1IDIzLjc1IDMxLjM1IDI1LjIgMjUuNSAyNi41NSBMMTYuNTUgMjcuNDUgMTYuNCAyNy44IFExNy4xIDMyLjQ1IDE3Ljc1IDMzLjQgMTkuMzUgMzUuNyAyMy41IDM1LjY1IDI3LjcgMzUuNTUgMzIuMiAzMyBMMzIuMyAzMy4wNSAzMi4zIDMzLjEgUTMyLjcgMzQuNiAzMSAzNi4zIDI5LjY1IDM3LjY1IDI3LjMgMzguNzUgMjMuODUgNDAuMyAyMC42IDQwLjA1IDE3LjIgMzkuNzUgMTUuMDUgMzcuODUgMTMuMyAzNi4zNSAxMS43NSAzMy4xIDEwLjU1IDI4LjYgMTEuMSAyNS4xIDExLjY1IDIxLjcgMTMuOSAxOC42NSAxNS44NSAxNi42IDE4LjcgMTUuNSAyMS44NSAxMy44IDI2LjQgMTUuMDUgMjkuNSAxNiAzMSAxOSBNMjQuNSAxNy45IFEyMC43NSAxNiAxOC4yIDE4LjMgMTUuNjUgMjAuNiAxNS44IDIyLjIgTDE1LjggMjQuMjUgMTguMzUgMjQuNiAyNC42IDIzLjk1IFEyNi41NSAyMy42NSAyNy40IDIyLjYgMjcuODUgMjAuNDUgMjQuNSAxNy45"},{ name : "nletter", data : "TTEwLjg1IDE3LjQ1IFExMSAxNi40NSAxMS44IDE2LjMgTDEyLjc1IDE2LjMgUTEzLjkgMTYuNDUgMTQuNyAxNy42IEwxNS42NSAxOS4yIDE5LjQ1IDE3LjEgUTIyLjQgMTUuMjUgMjUuMDUgMTUuOCAyNy42NSAxNi4zNSAyOC43NSAxNy42IDMwLjk1IDE5LjE1IDMxLjE1IDM1LjggMzEuMzUgMzguMTUgMzAuNzUgMzkuMTUgMzAuMjUgNDAgMjkuMDUgNDAgMjYuNDUgNDAgMjYuNSAzNS44IEwyNS41NSAyMiBRMjUuNCAyMSAyNC42NSAyMC40IDIzLjIgMTkuMSAyMS43IDE5LjIgMTguMTUgMTkuNiAxNiAyMi41IEwxNC45IDM4LjcgUTE0LjcgMzkuNiAxMy45NSAzOS43IEwxMy43NSAzOS43NSBRMTAuMTUgNDAuNCAxMC40NSAzOC41IEwxMC44NSAxNy40NQ"},{ name : "uletter", data : "TTEyLjY1IDE1LjU1IFExMy42NSAxNS42NSAxNC4zIDE2LjE1IDE0Ljk1IDE2LjY1IDE1IDE3LjQ1IEwxNS4xNSAyMC4xIFExNS4xIDI2Ljc1IDE1LjUgMzMuNDUgMTUuNzUgMzUuMSAxNy42NSAzNi4yIDIxLjc1IDM3LjI1IDI0LjE1IDM0LjkgMjYgMzMuMTUgMjYuMDUgMjguODUgTDI2LjMgMjEuNSBRMjYuMjUgMTcuMSAyNy4yNSAxNi40IDI3LjkgMTUuOTUgMjguNjUgMTUuOTUgTDMwLjEgMTYuMzUgUTMwLjg1IDE2LjggMzAuOSAxOS43NSBMMzEgMjMuNCAzMS4wNSAyNS4zNSAzMS4yIDM0LjcgMzEuMiAzNC45NSAzMS4xIDM4IDMwLjk1IDM4LjQ1IFEyOS40IDQwLjUgMjYuNjUgMzguNSBMMjUuNyAzNi45NSBRMTguNDUgNDEuNjUgMTQgMzguNzUgMTAuMTUgMzYuNjUgMTAuMzUgMjcuNjUgMTAuMyAyMi4zIDEwLjY1IDE3LjEgMTAuODUgMTUuNSAxMi42NSAxNS41NQ"},{ name : "jletter", data : "TTI1LjM1IDkuNCBMMjQuOCA5LjM1IDIzLjk1IDkuMjUgUTIzLjMgOS4xIDIzIDguOCBMMjIuNiA4LjMgUTIxLjggNy4zIDIyIDYuMyAyMi4yIDUuMiAyMi41NSA0LjkgTDIzLjIgNC4zNSBRMjYuOCAyLjkgMjcuNDUgNi4yNSAyNy43NSA3LjMgMjcuMSA4LjIgTDI2LjEgOS4xIDI1LjY1IDkuMyAyNS4zNSA5LjQgTTIxLjkgMTUuNTUgTDIyLjQgMTQuOTUgMjMuNSAxNC42NSAyNC41IDE0LjYgUTI1LjYgMTQuNDUgMjYuNCAxNC45IDI3LjI1IDE1IDI3LjA1IDE3Ljk1IDI3LjM1IDMyLjU1IDI3IDQyIDI2Ljc1IDUyLjA1IDE4Ljg1IDUxLjc1IDE2Ljc1IDUxLjYgMTUuNSA1MC44IDE0LjQ1IDUwLjUgMTQuMTUgNDkuNCAxMy40NSA0Ni45NSAxNy4xNSA0Ny44NSBMMTkuMTUgNDguNSAxOS44IDQ4LjQ1IDIwLjYgNDcuOTUgUTIxLjU1IDQ3IDIxLjk1IDQzLjggTDIxLjggMzEuMDUgMjEuOSAxNS41NQ"},{ name : "hletter", data : "TTI2Ljk1IDE2LjQgUTMxLjUgMTguMzUgMzEuNTUgMjMuMSBMMzEuOTUgMzUuMiBRMzIuMDUgMzcuMzUgMzEuNiAzOS40NSBMMzEuNDUgMzkuOTUgUTMwLjk1IDQwLjY1IDMwLjEgNDAuNjUgTDI5LjQgNDAuNTUgUTI4IDQwLjE1IDI3LjcgMzguNDUgTDI3LjU1IDM3LjcgMjcuMyAzNSAyNy4xNSAyNC41NSBRMjYuMzUgMTguMTUgMjEuMjUgMjAuMDUgMTguOCAyMC45NSAxNy45NSAyMi4xIDE2Ljk1IDIzLjQ1IDE2LjkgMjYuMyBMMTYuMDUgMzcuNDUgUTE2LjEgMzguNzUgMTUuNDUgMzkuNjUgMTQuOCA0MC41NSAxMy45IDQwLjU1IDEzIDQwLjU1IDEyLjM1IDM5LjY1IDExLjcgMzguNzUgMTEuNyAzNy40NSBMMTEuNyAzNiAxMi4xIDcuMDUgUTEyLjIgNC42IDE0LjEgNC41IDE2LjkgMy44IDE2Ljg1IDYuOSBMMTcuMDUgMTguOSAxOS40IDE3LjcgMjEuOTUgMTYuOCBRMjQuMiAxNS45NSAyNi45NSAxNi40"},{ name : "tletter", data : "TTE0LjA1IDE1LjggUTE1Ljk1IDE1LjQgMTcuNSAxMy43NSAxOC42IDEyLjM1IDE4Ljg1IDkuOTUgMTkuMjUgOCAyMCA3LjQgMjAuNyA2LjggMjEuMyA3LjA1IDIxLjg1IDcuMyAyMiA4IEwyMi4yIDkuNjUgUTIyLjE1IDExLjMgMjIuMzUgMTIuOCAyMi4zNSAxMy45IDIzLjQ1IDE0LjYgTDI2LjM1IDE1LjE1IFEyNy4zIDE1LjE1IDI3LjUgMTUuOCAyNy45IDE2LjkgMjYuOSAxNy40NSBMMjMuODUgMTcuOSBRMjEuODUgMTcuODUgMjEuOTUgMjUuNDUgTDIxLjk1IDMwLjU1IFEyMi41NSAzNy42NSAyNi44NSAzNS45IDI4LjQ1IDM1Ljc1IDI3LjcgMzcuNiAyNy4xNSAzOC44NSAyNS40IDM5LjQgMTYuOTUgNDEuNzUgMTcgMjkuNSBMMTcuMTUgMjQuNyAxNy4xNSAyNC41IFExNi45NSAxNy42NSAxNC4zNSAxNy4wNSAxMy4xIDE2LjUgMTQuMDUgMTUuOA"},{ name : "blueArrow2", data : "TTEzOS42IDIzMi40IEwxMjAuMTUgMjMyLjEgMTE4LjY1IDIzMi4wNSAxMTAuMSAyMzEuOTUgOTMuNTUgMjMxLjc1IDgyLjc1IDIzMS42NSA3MS4xNSAyMzEuNSA2OC4zNSAyMzEuNDUgNTUuNCAyMzEuMyA0OS4wNSAyMzEuMTUgUTQ1LjUgMjMwLjggNDQuNyAyMjkuMyBMNDQuMTUgMjI4LjMgNDMuOTUgMjI3LjQgUTQzLjk1IDIyNi43IDQ0LjMgMjI2LjMgTDQ1LjM1IDIyNS4zNSBRNDcuMTUgMjI0IDQ5LjA1IDIyMy45IEw1NS40IDIyMy45NSA2OC4zNSAyMjQuMDUgNzEuMTUgMjI0LjA1IDgyLjc1IDIyNC4wNSA4Ni4zNSAyMjQuMDUgOTMuNTUgMjI0LjA1IDExMC4xIDIyMy45NSAxMjAuMTUgMjIzLjc1IDEzOS42IDIyMy4yNSAxNTAuMzUgMjIyLjg1IDE2My4zIDIyMi4zIDE4My40NSAyMjEuMjUgMTkxLjQgMjIwLjggMTkzLjMgMjIwLjY1IDE5NC4yIDIyMC42NSAxOTkuNzUgMjIwLjUgMjA1LjA1IDIyMC4zIDIwNy45NSAyMjAuMDUgMjE4IDIxOS4yNSAyMzEuMDUgMjE4LjYgMjMyLjQgMjE4LjU1IDI0MS4wNSAyMTguMjUgMjQ1LjU1IDIxOC4xIFEyNDguNDUgMjE3Ljg1IDI1MC4zIDIxNi4zIDI1Mi40IDIxNC42IDI1My4zIDIxMS4wNSBMMjUzLjg1IDIwNS4xIDI1My44NSAxOTcgUTI1Ni42IDIwMCAyNjAuNDUgMjAzIEwyNjYuOTUgMjA3LjQ1IDI3MC41NSAyMDkuNiAyNzIuNyAyMTAuOCAyNzMuMzUgMjExLjE1IDI4MC40IDIxNC43IDI4NC4yIDIxNi41IDI4NyAyMTcuNzUgUTI5Mi4zIDIyMCAyOTcuOSAyMjIuMSBMMzAwLjcgMjIzLjE1IFEzMDYuNyAyMjUuMjUgMzEzLjA1IDIyNy4xNSAzMTQuNSAyMjcuOCAzMTQuMDUgMjI4LjQ1IDMxMy41NSAyMjkgMzEwLjk1IDIzMCBMMzAwLjcgMjMzLjY1IDI5Ny45IDIzNC42NSAyOTIuNjUgMjM2LjY1IDI4NyAyMzkgMjg0LjIgMjQwLjI1IFEyNzguNzUgMjQyLjc1IDI3My4zNSAyNDUuNyBMMjcyLjcgMjQ2LjA1IDI3MC41NSAyNDcuMjUgMjY2Ljk1IDI0OS4zNSAyNjAuNDUgMjUzLjQ1IFEyNTcuMTUgMjU1LjY1IDI1My44NSAyNTggTDI1My44NSAyNTIgMjUzLjMgMjQ1LjM1IFEyNTIuNCAyNDEuODUgMjUwLjMgMjQwLjEgMjQ4LjQ1IDIzOC41NSAyNDUuNTUgMjM4LjMgTDI0MS4wNSAyMzcuOTUgMjMyLjQgMjM3LjI1IDIyMiAyMzYuNDUgMjE4IDIzNi4xNSAyMDcuOTUgMjM1LjQgMjA1LjA1IDIzNS4yIDE5NC4yIDIzNC40NSAxOTMuMyAyMzQuNCAxOTEuNCAyMzQuMyAxODMuNDUgMjMzLjg1IDE2My4zIDIzMyAxNTAuMzUgMjMyLjY1IDEzOS42IDIzMi40"},{ name : "dletter", data : "TTI3LjMgMTUuNTUgTDI3Ljg1IDguMyBRMjcuOTUgNC4xIDMwLjcgMy43IDMyLjU1IDIuOCAzMi43NSA1LjEgTDMyLjcgMzIuOTUgMzMuMDUgMzUuOTUgUTMzLjQ1IDM2LjUgMzIuNjUgMzkuMTUgMzAuNTUgNDAuNzUgMjcuNzUgMzcuOCAxNy42IDQyLjcgMTIuNyAzNS44NSA3LjI1IDI1LjMgMTQuOCAxOC4zNSAxOC44NSAxNC4xNSAyNy4zIDE1LjU1IE0xNS45NSAyMy45NSBRMTQuNzUgMjcuOSAxNy4wNSAzNC4xIDE5LjQ1IDM3Ljk1IDI0LjQgMzYuNyAyNi4zNSAzNS43NSAyNy4yNSAzNC44IEwyNy4zIDMxLjY1IFEyOC4wNSAyMy4yIDI2Ljc1IDIwLjE1IDIzLjkgMTYuNTUgMjAuMTUgMTcuODUgMTcuODUgMTguODUgMTUuOTUgMjMuOTU"},{ name : "oletter", data : "TTE1LjkgMTkuNzUgUTEzLjggMjIuNTUgMTQuMDUgMjcuMyBMMTQuNCAzMC4yNSBRMTUuOSAzNy4zNSAyMS4yIDM3LjM1IDIzLjc1IDM3LjM1IDI1Ljk1IDM0LjY1IDI3LjM1IDMyLjI1IDI3LjUgMjcuMTUgMjcuNDUgMjQuMTUgMjYuNiAyMS45NSAyNS42IDE4Ljk1IDIyLjk1IDE3Ljc1IDIwLjkgMTcuMDUgMTkuMTUgMTcuMyAxNy40NSAxNy41IDE1LjkgMTkuNzUgTTE5LjE1IDE0LjggTDIxLjMgMTQuNjUgMjMuOTUgMTQuOTUgMjUuOCAxNS41NSBRMjcuOCAxNi4zIDI5IDE3LjQ1IDMxLjkgMjAuNzUgMzIuNSAyNC40IDMzLjIgMzIuNyAyOS4xIDM2LjcgMjYuMDUgNDAuMDUgMjAuMDUgNDAuMDUgMTMuMTUgMzkuOCAxMC40IDMzLjggOC43IDMwLjYgOS4xIDI1LjkgOS4zIDIzLjIgMTAuODUgMjAuMiAxMi4xIDE3Ljk1IDE0LjkgMTYuMDUgMTYuOTUgMTQuOSAxOS4xNSAxNC44"},{ name : "rletter", data : "TTEzLjI1IDE3LjA1IFExMy44NSAxNS42NSAxNS40IDE1LjggMTYuNjUgMTUuNjUgMTcuNzUgMTYuNyBMMTguOTUgMTguNSAyMiAxNi4xNSBRMjMuMzUgMTUuNDUgMjQuNyAxNS40IEwyNC45NSAxNS40IFEyNi4zNSAxNS41NSAyNy4xNSAxNi4xNSAyOS41NSAxOC4wNSAyNy4zIDE5LjggTDI2Ljg1IDIwLjA1IFEyNS44IDIwLjM1IDI0Ljc1IDIwLjA1IDIxLjMgMTguNjUgMTguNzUgMjMuNSBMMTguNDUgMzcgUTE3LjcgNDAuMjUgMTUgMzkuOSAxMy40NSAzOS44NSAxMy40IDM4LjU1IEwxMy4yNSAzNi42NSAxMy4yNSAxNy4wNQ"},{ name : "sletter", data : "TTE3LjIgMTUuMDUgUTIwLjA1IDE0LjMgMjIuNTUgMTQuOTUgTDI1Ljc1IDE1LjggMjcuNSAxNi43NSBRMjguNSAxNy42IDI4LjUgMTguMyAyOC40NSAxOC45NSAyOC4wNSAxOS40IDI3LjY1IDE5Ljg1IDI3IDE5LjggMjYuMyAxOS43NSAyNS40IDE5LjIgTDIzLjcgMTguMyAyMS44IDE3LjcgUTE4Ljk1IDE2Ljg1IDE3LjQ1IDE4LjE1IDE1LjkgMTkuNDUgMTYuMzUgMjAuOTUgMTYuOCAyMi40NSAxNy43IDIyLjk1IDIxLjQ1IDI1LjM1IDI1LjIgMjYuNDUgMjcuNDUgMjcuNCAyOC42IDI5IDMwLjQ1IDMyLjc1IDI5LjQgMzUuMjUgMjguMyAzNy43IDI1LjcgMzkgMjIuNSA0MC4yNSAxOC44NSA0MC4xIDE1Ljc1IDM5LjUgMTQgMzguNCAxMi4yNSAzNy4yNSAxMS45IDM2LjQgMTEuNiAzNS41NSAxMi4yNSAzNC43NSAxMi45NSAzNC4xNSAxMy40NSAzNC40IEwxNy44NSAzNi45NSBRMjIuNzUgMzguOCAyNC43IDM0LjYgMjUuMDUgMzMuNjUgMjQuNiAzMi43IDI0LjA1IDMxLjU1IDIyLjI1IDMwLjQ1IEwxNy4wNSAyNy44NSBRMTMuMSAyNi4wNSAxMi4xNSAyMy4xNSAxMS43NSAxOS43NSAxMy4yNSAxNy40NSBMMTQuMiAxNi41IFExNS40IDE1LjUgMTcuMiAxNS4wNQ"},{ name : "pletter", data : "TTIwLjM1IDE3LjU1IFExNy4xIDE3LjY1IDE0LjggMjEuNCBMMTQuNzUgMzMuMTUgUTE2LjQgMzYuOTUgMjAuODUgMzYuNyAyMy4yNSAzNi41NSAyNC43IDM0LjQ1IEwyNS4zIDMzLjQgUTI3IDMwIDI2LjcgMjUuNjUgMjYuNDUgMjMuMTUgMjUuNjUgMjAuNjUgMjQuMDUgMTcuMSAyMC4zNSAxNy41NSBNMTggMTUuNCBRMTkuOSAxNC4yNSAyMy4yIDE0LjEgMjYuNDUgMTMuOSAyOS4xIDE2Ljc1IDMxLjcgMTkuNTUgMzIgMjMuMiAzMi4yNSAyNi44IDMxLjMgMzAuMjUgMzAuNSAzMy40IDI4LjQgMzUuOTUgMjcuMSAzNy43NSAyNC4zIDM4LjY1IDIyLjYgMzkuMyAyMC43NSAzOS4yNSAxNy45NSAzOS4yNSAxNS4xIDM4LjM1IEwxNC4xNSA0OC41IFExMy4xNSA0OS41IDExLjU1IDQ5LjMgMTAuMSA0OS40IDkuNiA0Ny45IEw5Ljk1IDE3LjA1IFExMC4yIDE1LjcgMTEuNCAxNS4xIEwxMi4wNSAxNC45NSAxMy40IDE1LjEgUTE1LjIgMTYuNCAxNS4zIDE3LjcgMTYuMSAxNi41IDE4IDE1LjQ"}];
haxe.crypto.Base64.CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
haxe.crypto.Base64.BYTES = haxe.io.Bytes.ofString(haxe.crypto.Base64.CHARS);
letters.Path.fl = 420;
letters.paragraphPath.ParagraphPathDemo.numBeziers = 40;
letters.paragraphPath.ParagraphPathDemo.numSections = 100;
letters.pathway.Iterator0_1.accuracy = 1000000;
turtle.Turtle.pressDownStageFunc = [];
turtle.targetJS.SetupCanvas.__meta__ = { fields : { parseInt : { 'static' : null}}};
letters.paragraphPath.ParagraphPathDemo.main();
})();

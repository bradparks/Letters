package letters;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class Path extends haxe.lang.HxObject
{
	static 
	{
		letters.Path.fl = ((double) (((int) (420.0) )) );
	}
	public    Path(haxe.lang.EmptyObject empty)
	{
		{
		}
		
	}
	
	
	public    Path(java.lang.String str_)
	{
		letters.Path.__hx_ctor_letters_Path(this, str_);
	}
	
	
	public static   void __hx_ctor_letters_Path(letters.Path __temp_me20, java.lang.String str_)
	{
		__temp_me20.hasIterated = false;
		__temp_me20.bottom = ((double) (((int) (-1000000.0) )) );
		__temp_me20.right = ((double) (((int) (-1000000.0) )) );
		__temp_me20.top = ((double) (((int) (1000000.0) )) );
		__temp_me20.left = ((double) (((int) (1000000.0) )) );
		__temp_me20.count = 0;
		__temp_me20.length = str_.length();
		__temp_me20.str = str_;
	}
	
	
	public static   haxe.root.Array<java.lang.Object> rainbowPencilColors()
	{
		return new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{13816001, 13467688, 13802769, 14905640, 15755121, 13777201, 11480113, 9450302, 8797520, 5786205, 5545667, 2912413, 4553390, 3558765, 3640429, 7251784, 3562916, 4550210, 12683310, 8467492, 4206116, 2696224, 5396305, 1776409});
	}
	
	
	public static   boolean isNum(java.lang.String x)
	{
		{
			java.lang.String __temp_svar222 = (x);
			int __temp_hash224 = __temp_svar222.hashCode();
			boolean __temp_executeDef223 = true;
			switch (__temp_hash224)
			{
				case 57:case 56:case 55:case 54:case 53:case 52:case 51:case 50:case 49:case 48:
				{
					if (( (( ( __temp_hash224 == 57 ) && __temp_svar222.equals("9") )) || ( (( ( __temp_hash224 == 56 ) && __temp_svar222.equals("8") )) || ( (( ( __temp_hash224 == 55 ) && __temp_svar222.equals("7") )) || ( (( ( __temp_hash224 == 54 ) && __temp_svar222.equals("6") )) || ( (( ( __temp_hash224 == 53 ) && __temp_svar222.equals("5") )) || ( (( ( __temp_hash224 == 52 ) && __temp_svar222.equals("4") )) || ( (( ( __temp_hash224 == 51 ) && __temp_svar222.equals("3") )) || ( (( ( __temp_hash224 == 50 ) && __temp_svar222.equals("2") )) || ( (( ( __temp_hash224 == 49 ) && __temp_svar222.equals("1") )) || __temp_svar222.equals("0") ) ) ) ) ) ) ) ) )) 
					{
						__temp_executeDef223 = false;
						return true;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef223) 
			{
				return false;
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	public static   boolean isNumOrDot(java.lang.String x)
	{
		boolean __temp_stmt226 = false;
		{
			java.lang.String __temp_svar228 = (x);
			int __temp_hash230 = __temp_svar228.hashCode();
			boolean __temp_executeDef229 = true;
			switch (__temp_hash230)
			{
				case 57:case 56:case 55:case 54:case 53:case 52:case 51:case 50:case 49:case 48:
				{
					if (( (( ( __temp_hash230 == 57 ) && __temp_svar228.equals("9") )) || ( (( ( __temp_hash230 == 56 ) && __temp_svar228.equals("8") )) || ( (( ( __temp_hash230 == 55 ) && __temp_svar228.equals("7") )) || ( (( ( __temp_hash230 == 54 ) && __temp_svar228.equals("6") )) || ( (( ( __temp_hash230 == 53 ) && __temp_svar228.equals("5") )) || ( (( ( __temp_hash230 == 52 ) && __temp_svar228.equals("4") )) || ( (( ( __temp_hash230 == 51 ) && __temp_svar228.equals("3") )) || ( (( ( __temp_hash230 == 50 ) && __temp_svar228.equals("2") )) || ( (( ( __temp_hash230 == 49 ) && __temp_svar228.equals("1") )) || __temp_svar228.equals("0") ) ) ) ) ) ) ) ) )) 
					{
						__temp_executeDef229 = false;
						__temp_stmt226 = true;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef229) 
			{
				__temp_stmt226 = false;
			}
			
		}
		
		boolean __temp_boolv227 = false;
		if ( ! (__temp_stmt226) ) 
		{
			__temp_boolv227 = haxe.lang.Runtime.valEq(x, ".");
		}
		
		boolean __temp_stmt225 = ( __temp_stmt226 || __temp_boolv227 );
		return __temp_stmt225;
	}
	
	
	public static   haxe.root.Array<java.lang.Object> generateVectorText(java.lang.String str, double x, double y, double scale, java.lang.Object width, java.lang.Object lineSpace, haxe.root.Array<java.lang.Object> path, haxe.lang.Function highlightFunction, haxe.lang.Function outlineFunction)
	{
		if (( path == null )) 
		{
			path = new haxe.root.Array<java.lang.Object>();
		}
		
		if (( width == null )) 
		{
			width = 1000000;
			lineSpace = 0;
		}
		
		haxe.root.Array<java.lang.Object> temp = null;
		double x1 = x;
		double x2 = x;
		double dx = 0.;
		double y1 = y;
		java.lang.Object tempDim = null;
		haxe.root.Array<java.lang.Object> word = new haxe.root.Array<java.lang.Object>();
		double lastLetterX1 = ((double) (0) );
		letters.LetterResource letterResource = new letters.LetterResource();
		haxe.root.Array<java.lang.String> arrStr = haxe.lang.StringExt.split(str, "");
		int counta = 0;
		if (( highlightFunction != null )) 
		{
			java.lang.String j = "";
			int count = ( counta + 1 );
			java.lang.String wordContent = "";
			if (( count < arrStr.length )) 
			{
				while ((  ! (haxe.lang.Runtime.valEq(j, " "))  && ( count < arrStr.length ) ))
				{
					j = arrStr.__get(count);
					if ( ! (haxe.lang.Runtime.valEq(j, " ")) ) 
					{
						wordContent = ( wordContent + j );
					}
					
					count++;
				}
				
				haxe.root.Array<java.lang.Object> _float = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (highlightFunction.__hx_invoke1_f(0.0, wordContent)) )) )});
				java.lang.String commandEnum = haxe.lang.Runtime.toString("F");
				java.lang.Object fillColor = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{_float, commandEnum}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
				if (( outlineFunction != null )) 
				{
					_float = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (outlineFunction.__hx_invoke1_f(0.0, wordContent)) )) )});
					commandEnum = haxe.lang.Runtime.toString("O");
					java.lang.Object outlineColor = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{_float, commandEnum}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
					path.push(outlineColor);
				}
				
				path.push(fillColor);
			}
			
		}
		
		{
			int _g = 0;
			while (( _g < arrStr.length ))
			{
				java.lang.String i = arrStr.__get(_g);
				 ++ _g;
				x2 = x1;
				if ((  ! (haxe.lang.Runtime.valEq(i, " "))  &&  ! (haxe.lang.Runtime.valEq(i, ""))  )) 
				{
					y1 = y;
					double vert = 0.0;
					{
						java.lang.String __temp_svar238 = (i);
						boolean __temp_executeDef239 = true;
						switch (__temp_svar238.hashCode())
						{
							case 103:
							{
								if (__temp_svar238.equals("g")) 
								{
									__temp_executeDef239 = false;
									vert = -1.9;
								}
								
								break;
							}
							
							
							case 109:
							{
								if (__temp_svar238.equals("m")) 
								{
									__temp_executeDef239 = false;
									vert = -0.5;
								}
								
								break;
							}
							
							
						}
						
						if (__temp_executeDef239) 
						{
							vert = 0.;
						}
						
					}
					
					double preX = 0.0;
					{
						java.lang.String __temp_svar240 = (i);
						int __temp_hash242 = __temp_svar240.hashCode();
						boolean __temp_executeDef241 = true;
						switch (__temp_hash242)
						{
							case 115:case 105:
							{
								if (( (( ( __temp_hash242 == 115 ) && __temp_svar240.equals("s") )) || __temp_svar240.equals("i") )) 
								{
									__temp_executeDef241 = false;
									preX = 2.;
								}
								
								break;
							}
							
							
							case 114:
							{
								if (__temp_svar240.equals("r")) 
								{
									__temp_executeDef241 = false;
									preX = 1.;
								}
								
								break;
							}
							
							
						}
						
						if (__temp_executeDef241) 
						{
							preX = 0.;
						}
						
					}
					
					if (( vert != 0 )) 
					{
						y1 += ( vert * scale );
					}
					
					if (( preX != 0 )) 
					{
						x1 += ( preX * scale );
					}
					
					{
						java.lang.Object path1 = null;
						if (letterResource.letters.exists(i)) 
						{
							path1 = letterResource.letters.get(i);
						}
						 else 
						{
							java.lang.String aLetter = null;
							{
								java.lang.String __temp_svar243 = (i);
								boolean __temp_executeDef244 = true;
								switch (__temp_svar243.hashCode())
								{
									case 97:
									{
										if (__temp_svar243.equals("a")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M23.5 18.1 Q19.9 16.6 18.2 19.3 16.45 21.95 14.85 21.5 13.85 21.25 13.55 20.6 L13.35 20 Q13.25 19.45 13.4 18.95 13.65 17.75 15.15 16.6 L16.9 15.8 19.2 15.15 20.95 14.9 22.95 14.9 26.45 15.25 Q27.65 15.55 28.4 16.15 31.1 17.95 31.15 21.55 L31.8 38.3 Q31.95 39.3 31.5 39.55 L29.6 39.9 Q28.2 39.95 26.75 39.2 L26.5 37.7 22.25 39.7 Q20.3 40.4 17.8 40.4 13.2 39.85 12.1 35.75 11.25 33.5 12.55 30.65 13.1 28.9 15.35 27.55 18.45 25.25 24.25 24.65 25.3 24.7 25.95 24.25 26.65 23.7 26.35 21.45 26 19.15 23.5 18.1 M22.4 36.95 Q24.8 36.65 26.4 34.7 L26.7 27.05 24.35 27.25 Q19.75 28.1 18.3 29.6 16.85 31.05 16.95 33.25 17.05 35.4 18.5 36.35 19.95 37.25 22.4 36.95";
										}
										
										break;
									}
									
									
									case 122:
									{
										if (__temp_svar243.equals("z")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M10.4 16.7 Q9.9 16.3 10.15 15.95 L10.55 15.65 11.7 15.5 14.9 15.3 Q29.15 15 30.85 15.5 32.15 16.05 31.55 17 L17.4 36.25 27.6 36.7 Q31.2 36.8 32.6 38.1 33.25 39 30.95 39.45 L20.1 39.8 12.95 39.7 Q8.5 39.8 10.1 38.05 L24.65 19 Q22.3 18.1 14.6 17.75 11.55 17.45 10.4 16.7";
										}
										
										break;
									}
									
									
									case 98:
									{
										if (__temp_svar243.equals("b")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M25.45 15.5 Q29.5 16.4 31.8 21.2 32.9 23.45 33.05 26.15 33.2 29 32.3 31.45 31.4 33.85 30.35 35.15 L28.55 37.2 26.6 38.5 26.3 38.7 25.6 39 23.7 39.65 22.5 39.8 19.1 39.95 18 39.85 16.3 39.7 14.5 39.5 Q12.35 39 11.5 37.7 10.55 36.2 10.55 34.1 L10.95 7.3 11 4.9 11.5 4.5 Q12.15 3.85 12.8 3.7 14.15 2.95 15.3 3.7 L16.2 17.7 Q21.45 14.6 25.45 15.5 M16.2 21.3 L15.75 23.15 15.5 25.4 15.5 31.5 Q15.5 33.85 16.35 35.4 17.6 37.1 20.8 37.3 27.4 37.05 27.5 27.2 27.6 17.35 19.7 18.7 17.65 18.9 16.2 21.3";
										}
										
										break;
									}
									
									
									case 121:
									{
										if (__temp_svar243.equals("y")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M10.7 18 L14.8 17.95 Q16.15 19.8 17.95 25.35 19 28.2 21.45 33.45 21.85 34.3 22.7 34.1 23.6 33.85 24.75 31.05 L26.45 26.8 27.9 22.4 29.3 18.1 Q29.55 17.25 30.65 17.3 32.45 17.45 32.6 18.55 L30.2 26.7 28 34.05 Q26.65 38.35 25.35 41.25 23.2 46 20.1 49.35 16.8 52.45 14.65 52.8 10.05 53.2 10.05 51.1 10.1 50.4 10.5 49.95 10.9 49.45 11.9 49.15 13.4 48.65 14.9 49.15 16.6 49.2 19.7 44.95 20.75 43.3 21.1 41.6 L21 40.9 Q14 29.35 10.05 19.6 9.7 19.1 9.9 18.6 L10.7 18";
										}
										
										break;
									}
									
									
									case 99:
									{
										if (__temp_svar243.equals("c")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M29.7 21.65 L29.5 21.6 28.7 21.35 26.7 19.3 Q25.4 17.9 22.5 17.9 19.65 17.9 17.75 20.8 16.2 23.2 16.2 25.7 16.2 30.55 18.65 33.5 20.7 35.95 22.95 35.95 29.75 35.95 32.05 32.3 L32.2 32.5 32.25 33.2 Q32.25 35.65 29.6 37.7 26.7 39.95 22.35 39.95 16.85 39.95 13.85 36 11.35 32.75 11.35 28.3 11.35 22.05 15.35 18.15 18.75 14.85 22.8 14.85 27.45 14.85 29.8 16.8 31.45 18.15 31.45 19.65 31.45 21.4 29.7 21.65";
										}
										
										break;
									}
									
									
									case 120:
									{
										if (__temp_svar243.equals("x")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M21.4 23.3 L26.25 17.1 Q27.25 15.85 28.25 15.55 30.25 15.65 30.55 16.3 L23.75 25.75 Q23.35 26.25 24.15 27.6 L31.75 38.5 Q32.75 39.75 30.7 39.8 28.1 40.1 26.25 38.25 L20.05 30.15 13.45 39.1 Q11.05 40.2 9.75 39.85 9.25 39.35 9.85 38.65 L17.95 27.45 10.5 16.3 Q10.4 15.8 11 15.75 L13.2 15.6 Q15 15.6 16.2 16.4 L21.4 23.3";
										}
										
										break;
									}
									
									
									case 100:
									{
										if (__temp_svar243.equals("d")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M27.3 15.55 L27.85 8.3 Q27.95 4.1 30.7 3.7 32.55 2.8 32.75 5.1 L32.7 32.95 33.05 35.95 Q33.45 36.5 32.65 39.15 30.55 40.75 27.75 37.8 17.6 42.7 12.7 35.85 7.25 25.3 14.8 18.35 18.85 14.15 27.3 15.55 M15.95 23.95 Q14.75 27.9 17.05 34.1 19.45 37.95 24.4 36.7 26.35 35.75 27.25 34.8 L27.3 31.65 Q28.05 23.2 26.75 20.15 23.9 16.55 20.15 17.85 17.85 18.85 15.95 23.95";
										}
										
										break;
									}
									
									
									case 119:
									{
										if (__temp_svar243.equals("w")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M3.8 16.65 Q5.55 15.5 6.9 16.85 8.8 18.8 9.7 21.4 L13.4 31.65 Q14.8 35.75 15.9 31.75 L19.85 19.6 Q20.65 17.65 22.25 17.6 23.6 18.05 24 19.3 L28.35 32.15 Q28.8 33.1 29.65 32.5 32.6 26.55 34.4 20.8 34.85 19.25 35.65 18.25 36.6 17.2 37.55 16.9 L37.65 16.9 Q38.15 16.85 38 17.8 L36.95 20.8 31.65 37.5 Q30 42.1 27.35 38.75 L27.3 38.7 Q25.05 35.45 24.1 32.6 L21.1 26.45 Q18.45 32.7 15.25 38.65 12.75 41.6 11.25 38.55 L3.65 18.55 Q3.35 17.6 3.8 16.65";
										}
										
										break;
									}
									
									
									case 101:
									{
										if (__temp_svar243.equals("e")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M31 19 Q32.1 21.45 32.65 23.75 31.35 25.2 25.5 26.55 L16.55 27.45 16.4 27.8 Q17.1 32.45 17.75 33.4 19.35 35.7 23.5 35.65 27.7 35.55 32.2 33 L32.3 33.05 32.3 33.1 Q32.7 34.6 31 36.3 29.65 37.65 27.3 38.75 23.85 40.3 20.6 40.05 17.2 39.75 15.05 37.85 13.3 36.35 11.75 33.1 10.55 28.6 11.1 25.1 11.65 21.7 13.9 18.65 15.85 16.6 18.7 15.5 21.85 13.8 26.4 15.05 29.5 16 31 19 M24.5 17.9 Q20.75 16 18.2 18.3 15.65 20.6 15.8 22.2 L15.8 24.25 18.35 24.6 24.6 23.95 Q26.55 23.65 27.4 22.6 27.85 20.45 24.5 17.9";
										}
										
										break;
									}
									
									
									case 118:
									{
										if (__temp_svar243.equals("v")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M15.35 18.4 L16.8 22.4 21.1 33.25 21.4 33.75 21.75 33.6 Q25.25 26.85 28.15 18.25 29.25 15.8 30.4 15.8 L31.15 15.75 Q32.1 15.85 32.15 16.35 L29.9 22.6 24.85 35 Q22.8 39.45 22.1 39.75 L21.5 40 Q20 40.4 18.3 37.8 L16.85 34.85 9.8 17.5 Q9.25 16.65 9.55 16.15 9.85 15.6 10.65 15.65 13.25 15.75 13.95 16.25 14.8 16.9 15.35 18.4";
										}
										
										break;
									}
									
									
									case 102:
									{
										if (__temp_svar243.equals("f")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M28 3.25 Q29.8 3.55 30.65 4.95 31.15 5.9 31.05 6.5 31.2 7.35 29.9 8.1 29.1 8.2 28.4 7.65 L27.9 7.2 27.45 6.7 26.35 6.2 25.95 6.15 Q25.2 6 24.4 6.45 21.25 7.95 21.7 12.05 21.5 15.1 24.7 15.2 L25.5 15.3 27.15 15.65 Q28.75 16.8 27.3 17.95 L25.5 18.15 24.8 18.3 Q21.9 18.3 22.1 22 L21.45 37.5 Q21.85 40.4 18.85 40.35 16.55 40.85 16.65 36.85 L16.65 24.4 16.15 18.9 Q15.3 17.9 14.55 17.85 10.7 16.75 14.5 15.65 16.15 15.1 16.35 13.85 L18.3 7.9 Q19.75 4.8 22.1 3.7 24.4 2.65 28 3.25";
										}
										
										break;
									}
									
									
									case 117:
									{
										if (__temp_svar243.equals("u")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M12.65 15.55 Q13.65 15.65 14.3 16.15 14.95 16.65 15 17.45 L15.15 20.1 Q15.1 26.75 15.5 33.45 15.75 35.1 17.65 36.2 21.75 37.25 24.15 34.9 26 33.15 26.05 28.85 L26.3 21.5 Q26.25 17.1 27.25 16.4 27.9 15.95 28.65 15.95 L30.1 16.35 Q30.85 16.8 30.9 19.75 L31 23.4 31.05 25.35 31.2 34.7 31.2 34.95 31.1 38 30.95 38.45 Q29.4 40.5 26.65 38.5 L25.7 36.95 Q18.45 41.65 14 38.75 10.15 36.65 10.35 27.65 10.3 22.3 10.65 17.1 10.85 15.5 12.65 15.55";
										}
										
										break;
									}
									
									
									case 103:
									{
										if (__temp_svar243.equals("g")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M21.95 21.85 Q19.05 22.2 17.3 24.7 15.2 29.25 17.2 33.95 18.45 36.9 21.35 37.35 25.75 36.9 26.9 33.4 27.85 29.85 26.75 25.3 25.35 21.4 21.95 21.85 M11.75 47.95 Q11.65 46.3 12.9 46.1 L14.15 46.35 17.05 47.7 Q28.65 50 26.75 38.95 19.05 41.35 15.3 37.45 11.9 35.25 11.35 29.25 12.15 24.55 14.85 21.95 20.25 16.65 28.35 20.3 31.15 21.7 32.3 29.2 L31.95 44 Q30.3 53.2 19.8 52.6 15.1 51.8 13.2 50.4 12.1 49.75 11.9 48.95 L11.75 47.95";
										}
										
										break;
									}
									
									
									case 116:
									{
										if (__temp_svar243.equals("t")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M14.05 15.8 Q15.95 15.4 17.5 13.75 18.6 12.35 18.85 9.95 19.25 8 20 7.4 20.7 6.8 21.3 7.05 21.85 7.3 22 8 L22.2 9.65 Q22.15 11.3 22.35 12.8 22.35 13.9 23.45 14.6 L26.35 15.15 Q27.3 15.15 27.5 15.8 27.9 16.9 26.9 17.45 L23.85 17.9 Q21.85 17.85 21.95 25.45 L21.95 30.55 Q22.55 37.65 26.85 35.9 28.45 35.75 27.7 37.6 27.15 38.85 25.4 39.4 16.95 41.75 17 29.5 L17.15 24.7 17.15 24.5 Q16.95 17.65 14.35 17.05 13.1 16.5 14.05 15.8";
										}
										
										break;
									}
									
									
									case 104:
									{
										if (__temp_svar243.equals("h")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M26.95 16.4 Q31.5 18.35 31.55 23.1 L31.95 35.2 Q32.05 37.35 31.6 39.45 L31.45 39.95 Q30.95 40.65 30.1 40.65 L29.4 40.55 Q28 40.15 27.7 38.45 L27.55 37.7 27.3 35 27.15 24.55 Q26.35 18.15 21.25 20.05 18.8 20.95 17.95 22.1 16.95 23.45 16.9 26.3 L16.05 37.45 Q16.1 38.75 15.45 39.65 14.8 40.55 13.9 40.55 13 40.55 12.35 39.65 11.7 38.75 11.7 37.45 L11.7 36 12.1 7.05 Q12.2 4.6 14.1 4.5 16.9 3.8 16.85 6.9 L17.05 18.9 19.4 17.7 21.95 16.8 Q24.2 15.95 26.95 16.4";
										}
										
										break;
									}
									
									
									case 115:
									{
										if (__temp_svar243.equals("s")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M17.2 15.05 Q20.05 14.3 22.55 14.95 L25.75 15.8 27.5 16.75 Q28.5 17.6 28.5 18.3 28.45 18.95 28.05 19.4 27.65 19.85 27 19.8 26.3 19.75 25.4 19.2 L23.7 18.3 21.8 17.7 Q18.95 16.85 17.45 18.15 15.9 19.45 16.35 20.95 16.8 22.45 17.7 22.95 21.45 25.35 25.2 26.45 27.45 27.4 28.6 29 30.45 32.75 29.4 35.25 28.3 37.7 25.7 39 22.5 40.25 18.85 40.1 15.75 39.5 14 38.4 12.25 37.25 11.9 36.4 11.6 35.55 12.25 34.75 12.95 34.15 13.45 34.4 L17.85 36.95 Q22.75 38.8 24.7 34.6 25.05 33.65 24.6 32.7 24.05 31.55 22.25 30.45 L17.05 27.85 Q13.1 26.05 12.15 23.15 11.75 19.75 13.25 17.45 L14.2 16.5 Q15.4 15.5 17.2 15.05";
										}
										
										break;
									}
									
									
									case 105:
									{
										if (__temp_svar243.equals("i")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M23.6 6.7 Q23.35 8.3 22.6 8.85 20.6 9.6 19.25 8.85 L18.7 8.35 Q18.2 7.85 18.05 6.85 18.25 5.75 19 4.95 20.15 4.35 21.3 4.45 L21.5 4.5 21.85 4.55 Q22.75 4.65 23.25 5.45 23.65 5.9 23.6 6.7 M20.45 15.7 L21.9 15.55 22.3 15.65 22.7 15.75 23.55 36.05 Q24.05 40.1 20.2 40.1 19.05 40.1 18.7 39.2 18.45 38.45 18.4 36.05 L18.4 31.4 18.35 29.45 18.35 20.8 18.3 18.4 Q18.25 17.1 18.35 16.55 L18.8 16.15 Q19.45 15.85 20.25 15.7 L20.45 15.7";
										}
										
										break;
									}
									
									
									case 114:
									{
										if (__temp_svar243.equals("r")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M13.25 17.05 Q13.85 15.65 15.4 15.8 16.65 15.65 17.75 16.7 L18.95 18.5 22 16.15 Q23.35 15.45 24.7 15.4 L24.95 15.4 Q26.35 15.55 27.15 16.15 29.55 18.05 27.3 19.8 L26.85 20.05 Q25.8 20.35 24.75 20.05 21.3 18.65 18.75 23.5 L18.45 37 Q17.7 40.25 15 39.9 13.45 39.85 13.4 38.55 L13.25 36.65 13.25 17.05";
										}
										
										break;
									}
									
									
									case 106:
									{
										if (__temp_svar243.equals("j")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M25.35 9.4 L24.8 9.35 23.95 9.25 Q23.3 9.1 23 8.8 L22.6 8.3 Q21.8 7.3 22 6.3 22.2 5.2 22.55 4.9 L23.2 4.35 Q26.8 2.9 27.45 6.25 27.75 7.3 27.1 8.2 L26.1 9.1 25.65 9.3 25.35 9.4 M21.9 15.55 L22.4 14.95 23.5 14.65 24.5 14.6 Q25.6 14.45 26.4 14.9 27.25 15 27.05 17.95 27.35 32.55 27 42 26.75 52.05 18.85 51.75 16.75 51.6 15.5 50.8 14.45 50.5 14.15 49.4 13.45 46.95 17.15 47.85 L19.15 48.5 19.8 48.45 20.6 47.95 Q21.55 47 21.95 43.8 L21.8 31.05 21.9 15.55";
										}
										
										break;
									}
									
									
									case 113:
									{
										if (__temp_svar243.equals("q")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M19 17.85 Q17.9 18.4 16.5 19.85 15.1 21.25 14.65 25.25 14.1 36.15 21.3 36.35 24.8 36.15 26.6 33.35 L26.75 22.3 Q26.8 19.5 25.05 18.4 23.8 17.35 22 17.3 20.1 17.25 19 17.85 M13.15 18.3 Q15.75 15.7 18.75 14.95 22.5 14 26.85 16 L29.65 15.55 Q30.85 15.3 31.7 16.95 L31.85 49.55 30.25 49.95 30.05 49.95 28.6 49.7 Q27.35 49.1 27.25 48.2 L26.5 37.4 Q25.1 38.65 22.5 39.5 L20.6 39.7 Q16.2 39.75 14.45 38.2 9.4 35 9.85 26.3 10.05 22.2 13.15 18.3";
										}
										
										break;
									}
									
									
									case 107:
									{
										if (__temp_svar243.equals("k")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M13.8 3.75 L14.5 3.95 Q14.95 3.85 15.3 5.65 L15.55 9.05 15.6 18.85 Q15.6 21.4 16.1 24.45 L24.45 17.6 Q27.05 15.9 28.3 16 29.3 16.05 28.75 16.8 L21.85 24.7 Q21.5 25.3 23.45 27.95 L30.7 37.8 Q32 39.5 30.25 39.7 28.45 40.35 25.4 37.9 22.25 35.05 19.65 30.75 18.1 29.15 16.75 28.55 16.1 28.3 16.05 29.1 15.6 30.75 15.55 35.5 15.35 37.95 14.8 39.1 13.9 39.85 12.65 39.8 11.7 39.6 11 39.05 10.7 38.05 10.55 36.85 10.05 21.2 10.95 5.55 10.9 4.65 12.1 4.25 12.95 3.85 13.8 3.75";
										}
										
										break;
									}
									
									
									case 112:
									{
										if (__temp_svar243.equals("p")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M20.35 17.55 Q17.1 17.65 14.8 21.4 L14.75 33.15 Q16.4 36.95 20.85 36.7 23.25 36.55 24.7 34.45 L25.3 33.4 Q27 30 26.7 25.65 26.45 23.15 25.65 20.65 24.05 17.1 20.35 17.55 M18 15.4 Q19.9 14.25 23.2 14.1 26.45 13.9 29.1 16.75 31.7 19.55 32 23.2 32.25 26.8 31.3 30.25 30.5 33.4 28.4 35.95 27.1 37.75 24.3 38.65 22.6 39.3 20.75 39.25 17.95 39.25 15.1 38.35 L14.15 48.5 Q13.15 49.5 11.55 49.3 10.1 49.4 9.6 47.9 L9.95 17.05 Q10.2 15.7 11.4 15.1 L12.05 14.95 13.4 15.1 Q15.2 16.4 15.3 17.7 16.1 16.5 18 15.4";
										}
										
										break;
									}
									
									
									case 108:
									{
										if (__temp_svar243.equals("l")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M23.7 37.15 Q23.85 39.85 20.9 39.5 19.65 39.4 18.75 38.6 17.9 37.1 17.95 34.85 L18.3 4.5 Q18.75 3.4 19.85 3.2 L21.3 2.9 Q22.8 2.75 22.85 3.7 L23 28.8 23.7 37.15";
										}
										
										break;
									}
									
									
									case 111:
									{
										if (__temp_svar243.equals("o")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M15.9 19.75 Q13.8 22.55 14.05 27.3 L14.4 30.25 Q15.9 37.35 21.2 37.35 23.75 37.35 25.95 34.65 27.35 32.25 27.5 27.15 27.45 24.15 26.6 21.95 25.6 18.95 22.95 17.75 20.9 17.05 19.15 17.3 17.45 17.5 15.9 19.75 M19.15 14.8 L21.3 14.65 23.95 14.95 25.8 15.55 Q27.8 16.3 29 17.45 31.9 20.75 32.5 24.4 33.2 32.7 29.1 36.7 26.05 40.05 20.05 40.05 13.15 39.8 10.4 33.8 8.7 30.6 9.1 25.9 9.3 23.2 10.85 20.2 12.1 17.95 14.9 16.05 16.95 14.9 19.15 14.8";
										}
										
										break;
									}
									
									
									case 109:
									{
										if (__temp_svar243.equals("m")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M17.75 23.6 Q17 20.95 15.65 20.4 14.85 20 14.05 19.9 L13.65 19.85 11.65 20.25 Q10.35 20.6 9.2 21.75 8.05 22.9 7.65 24.85 7.25 26.75 7.4 30.4 7.45 37.6 6.4 39.05 3.05 41.25 3.3 36.6 L3.45 19.15 Q3.45 16.8 4.65 16.75 5.9 16.7 6.4 18.5 L6.45 18.65 Q7.15 19.7 8.7 18.9 L10.9 17.8 Q15.9 13.6 23.05 19.45 27.05 16.7 30.1 16.6 33.15 16.45 34.95 17.9 36.75 19.35 37.3 21.7 38.3 25.65 38.35 37.55 38.1 39.45 37.25 39.7 35 40.75 34.4 38.85 33.3 33.8 33.45 28.4 L33.05 25.05 Q30.65 17.75 26.3 20.15 L25.5 20.65 Q24 21.95 23.7 23.55 23.35 25.2 23.2 28.65 L23.25 33.2 23 36.65 Q22.7 39.75 21.5 40 20.55 40.35 19.25 40 18.55 39.75 18.3 38.8 L17.75 23.6";
										}
										
										break;
									}
									
									
									case 110:
									{
										if (__temp_svar243.equals("n")) 
										{
											__temp_executeDef244 = false;
											aLetter = "M10.85 17.45 Q11 16.45 11.8 16.3 L12.75 16.3 Q13.9 16.45 14.7 17.6 L15.65 19.2 19.45 17.1 Q22.4 15.25 25.05 15.8 27.65 16.35 28.75 17.6 30.95 19.15 31.15 35.8 31.35 38.15 30.75 39.15 30.25 40 29.05 40 26.45 40 26.5 35.8 L25.55 22 Q25.4 21 24.65 20.4 23.2 19.1 21.7 19.2 18.15 19.6 16 22.5 L14.9 38.7 Q14.7 39.6 13.95 39.7 L13.75 39.75 Q10.15 40.4 10.45 38.5 L10.85 17.45";
										}
										
										break;
									}
									
									
								}
								
								if (__temp_executeDef244) 
								{
									aLetter = "";
								}
								
							}
							
							letters.Path patha = new letters.Path(haxe.lang.Runtime.toString(aLetter));
							letterResource.letters.set(i, patha);
							path1 = patha;
						}
						
						double x3 = x1;
						double y2 = y1;
						double sx = scale;
						double sy = scale;
						{
							haxe.root.Array<java.lang.Object> a = new haxe.root.Array<java.lang.Object>();
							{
								java.lang.Object __temp_iterator35 = ((java.lang.Object) (haxe.lang.Runtime.callField(path1, "iterator", null)) );
								while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator35, "hasNext", null)))
								{
									java.lang.Object x4 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator35, "next", null)) );
									java.lang.Object __temp_stmt231 = null;
									{
										haxe.root.Array<java.lang.Object> v0 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x4, "v0", true)) );
										java.lang.String v1 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x4, "v1", true));
										{
											java.lang.String __temp_svar245 = (v1);
											int __temp_hash247 = __temp_svar245.hashCode();
											boolean __temp_executeDef246 = true;
											switch (__temp_hash247)
											{
												case 77:case 76:
												{
													if (( (( ( __temp_hash247 == 77 ) && __temp_svar245.equals("M") )) || __temp_svar245.equals("L") )) 
													{
														__temp_executeDef246 = false;
														v0 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( ( sx * ((double) (haxe.lang.Runtime.toDouble(v0.__get(0))) ) ) + x3 )) ), ((java.lang.Object) (( ( sy * ((double) (haxe.lang.Runtime.toDouble(v0.__get(1))) ) ) + y2 )) )});
													}
													
													break;
												}
												
												
												case 81:
												{
													if (__temp_svar245.equals("Q")) 
													{
														__temp_executeDef246 = false;
														v0 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( ( sx * ((double) (haxe.lang.Runtime.toDouble(v0.__get(0))) ) ) + x3 )) ), ((java.lang.Object) (( ( sy * ((double) (haxe.lang.Runtime.toDouble(v0.__get(1))) ) ) + y2 )) ), ((java.lang.Object) (( ( sx * ((double) (haxe.lang.Runtime.toDouble(v0.__get(2))) ) ) + x3 )) ), ((java.lang.Object) (( ( sy * ((double) (haxe.lang.Runtime.toDouble(v0.__get(3))) ) ) + y2 )) )});
													}
													
													break;
												}
												
												
											}
											
											if (__temp_executeDef246) 
											{
												{
												}
												
											}
											
										}
										
										java.lang.Object commandData = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v0, v1}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
										__temp_stmt231 = commandData;
									}
									
									a.push(__temp_stmt231);
								}
								
							}
							
							temp = a;
						}
						
					}
					
					{
						double l = 1000000.0;
						double t = 1000000.0;
						double r = -1000.0;
						double b = -1000.0;
						double x5 = 0.0;
						double y3 = 0.0;
						int count1 = 0;
						{
							java.lang.Object __temp_iterator36 = temp.iterator();
							while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator36, "hasNext", null)))
							{
								java.lang.Object i1 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator36, "next", null)) );
								haxe.root.Array<java.lang.Object> v = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(i1, "v0", true)) );
								java.lang.String command = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(i1, "v1", true));
								{
									java.lang.String __temp_svar248 = (command);
									int __temp_hash250 = __temp_svar248.hashCode();
									boolean __temp_executeDef249 = true;
									switch (__temp_hash250)
									{
										case 81:case 76:case 77:
										{
											if (( (( ( __temp_hash250 == 81 ) && __temp_svar248.equals("Q") )) || ( (( ( __temp_hash250 == 76 ) && __temp_svar248.equals("L") )) || __temp_svar248.equals("M") ) )) 
											{
												__temp_executeDef249 = false;
												x5 = ((double) (haxe.lang.Runtime.toDouble(v.__get(0))) );
												y3 = ((double) (haxe.lang.Runtime.toDouble(v.__get(1))) );
												if (( x5 < l )) 
												{
													l = x5;
												}
												
												if (( x5 > r )) 
												{
													r = x5;
												}
												
												if (( y3 < t )) 
												{
													t = y3;
												}
												
												if (( y3 > b )) 
												{
													b = y3;
												}
												
												if (( v.length > 2 )) 
												{
													x5 = ((double) (haxe.lang.Runtime.toDouble(v.__get(2))) );
													y3 = ((double) (haxe.lang.Runtime.toDouble(v.__get(3))) );
													if (( x5 < l )) 
													{
														l = x5;
													}
													
													if (( x5 > r )) 
													{
														r = x5;
													}
													
													if (( y3 < t )) 
													{
														t = y3;
													}
													
													if (( y3 > b )) 
													{
														b = y3;
													}
													
												}
												
											}
											
											break;
										}
										
										
									}
									
									if (__temp_executeDef249) 
									{
										{
										}
										
									}
									
								}
								
							}
							
						}
						
						tempDim = new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"centre", "dim", "end", "pos"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( l + ( (( r - l )) / 2 ) )) ), ((java.lang.Object) (( t + ( (( b - t )) / 2 ) )) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( r - l )) ), ((java.lang.Object) (( b - t )) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (r) ), ((java.lang.Object) (b) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (l) ), ((java.lang.Object) (t) )}))}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}));
					}
					
					dx = ( ((double) (x2) ) - ((double) (haxe.lang.Runtime.getField_f(haxe.lang.Runtime.getField(tempDim, "pos", true), "x", true)) ) );
					double postX = 0.0;
					{
						java.lang.String __temp_svar251 = (i);
						int __temp_hash253 = __temp_svar251.hashCode();
						boolean __temp_executeDef252 = true;
						switch (__temp_hash253)
						{
							case 106:case 105:
							{
								if (( (( ( __temp_hash253 == 106 ) && __temp_svar251.equals("j") )) || __temp_svar251.equals("i") )) 
								{
									__temp_executeDef252 = false;
									postX = 3.;
								}
								
								break;
							}
							
							
							case 102:
							{
								if (__temp_svar251.equals("f")) 
								{
									__temp_executeDef252 = false;
									postX = -2.;
								}
								
								break;
							}
							
							
							case 114:
							{
								if (__temp_svar251.equals("r")) 
								{
									__temp_executeDef252 = false;
									postX = -1.;
								}
								
								break;
							}
							
							
						}
						
						if (__temp_executeDef252) 
						{
							postX = 0.;
						}
						
					}
					
					if (( postX != 0 )) 
					{
						x1 += ( postX * scale );
					}
					
					if (( preX != 0 )) 
					{
						dx += ( preX * scale );
					}
					
					x1 += ( ((double) (haxe.lang.Runtime.getField_f(haxe.lang.Runtime.getField(tempDim, "dim", true), "x", true)) ) + ( 2 * scale ) );
					{
						double x6 = dx;
						double y4 = ((double) (0) );
						boolean x0 = ( x6 == 0 );
						boolean y0 = ( y4 == 0 );
						if (( x0 && y0 )) 
						{
							temp = haxe.root.Lambda.array(temp);
						}
						 else 
						{
							if (x0) 
							{
								haxe.root.Array<java.lang.Object> a1 = new haxe.root.Array<java.lang.Object>();
								{
									java.lang.Object __temp_iterator37 = temp.iterator();
									while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator37, "hasNext", null)))
									{
										java.lang.Object x7 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator37, "next", null)) );
										java.lang.Object __temp_stmt234 = null;
										{
											haxe.root.Array<java.lang.Object> v01 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x7, "v0", true)) );
											java.lang.String v11 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x7, "v1", true));
											{
												java.lang.String __temp_svar254 = (v11);
												int __temp_hash256 = __temp_svar254.hashCode();
												boolean __temp_executeDef255 = true;
												switch (__temp_hash256)
												{
													case 77:case 76:
													{
														if (( (( ( __temp_hash256 == 77 ) && __temp_svar254.equals("M") )) || __temp_svar254.equals("L") )) 
														{
															__temp_executeDef255 = false;
															v01 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v01.__get(0))) )) ), ((java.lang.Object) (( y4 + ((double) (haxe.lang.Runtime.toDouble(v01.__get(1))) ) )) )});
														}
														
														break;
													}
													
													
													case 81:
													{
														if (__temp_svar254.equals("Q")) 
														{
															__temp_executeDef255 = false;
															v01 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v01.__get(0))) )) ), ((java.lang.Object) (( y4 + ((double) (haxe.lang.Runtime.toDouble(v01.__get(1))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v01.__get(2))) )) ), ((java.lang.Object) (( y4 + ((double) (haxe.lang.Runtime.toDouble(v01.__get(3))) ) )) )});
														}
														
														break;
													}
													
													
												}
												
												if (__temp_executeDef255) 
												{
													{
													}
													
												}
												
											}
											
											java.lang.Object commandData1 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v01, v11}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
											__temp_stmt234 = commandData1;
										}
										
										a1.push(__temp_stmt234);
									}
									
								}
								
								temp = a1;
							}
							 else 
							{
								if (y0) 
								{
									haxe.root.Array<java.lang.Object> a2 = new haxe.root.Array<java.lang.Object>();
									{
										java.lang.Object __temp_iterator38 = temp.iterator();
										while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator38, "hasNext", null)))
										{
											java.lang.Object x8 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator38, "next", null)) );
											java.lang.Object __temp_stmt233 = null;
											{
												haxe.root.Array<java.lang.Object> v02 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x8, "v0", true)) );
												java.lang.String v12 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x8, "v1", true));
												{
													java.lang.String __temp_svar257 = (v12);
													int __temp_hash259 = __temp_svar257.hashCode();
													boolean __temp_executeDef258 = true;
													switch (__temp_hash259)
													{
														case 77:case 76:
														{
															if (( (( ( __temp_hash259 == 77 ) && __temp_svar257.equals("M") )) || __temp_svar257.equals("L") )) 
															{
																__temp_executeDef258 = false;
																v02 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x6 + ((double) (haxe.lang.Runtime.toDouble(v02.__get(0))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v02.__get(1))) )) )});
															}
															
															break;
														}
														
														
														case 81:
														{
															if (__temp_svar257.equals("Q")) 
															{
																__temp_executeDef258 = false;
																v02 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x6 + ((double) (haxe.lang.Runtime.toDouble(v02.__get(0))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v02.__get(1))) )) ), ((java.lang.Object) (( x6 + ((double) (haxe.lang.Runtime.toDouble(v02.__get(2))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v02.__get(3))) )) )});
															}
															
															break;
														}
														
														
													}
													
													if (__temp_executeDef258) 
													{
														{
														}
														
													}
													
												}
												
												java.lang.Object commandData2 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v02, v12}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
												__temp_stmt233 = commandData2;
											}
											
											a2.push(__temp_stmt233);
										}
										
									}
									
									temp = a2;
								}
								 else 
								{
									haxe.root.Array<java.lang.Object> a3 = new haxe.root.Array<java.lang.Object>();
									{
										java.lang.Object __temp_iterator39 = temp.iterator();
										while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator39, "hasNext", null)))
										{
											java.lang.Object x9 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator39, "next", null)) );
											java.lang.Object __temp_stmt232 = null;
											{
												haxe.root.Array<java.lang.Object> v03 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x9, "v0", true)) );
												java.lang.String v13 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x9, "v1", true));
												{
													java.lang.String __temp_svar260 = (v13);
													int __temp_hash262 = __temp_svar260.hashCode();
													boolean __temp_executeDef261 = true;
													switch (__temp_hash262)
													{
														case 77:case 76:
														{
															if (( (( ( __temp_hash262 == 77 ) && __temp_svar260.equals("M") )) || __temp_svar260.equals("L") )) 
															{
																__temp_executeDef261 = false;
																v03 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x6 + ((double) (haxe.lang.Runtime.toDouble(v03.__get(0))) ) )) ), ((java.lang.Object) (( y4 + ((double) (haxe.lang.Runtime.toDouble(v03.__get(1))) ) )) )});
															}
															
															break;
														}
														
														
														case 81:
														{
															if (__temp_svar260.equals("Q")) 
															{
																__temp_executeDef261 = false;
																v03 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x6 + ((double) (haxe.lang.Runtime.toDouble(v03.__get(0))) ) )) ), ((java.lang.Object) (( y4 + ((double) (haxe.lang.Runtime.toDouble(v03.__get(1))) ) )) ), ((java.lang.Object) (( x6 + ((double) (haxe.lang.Runtime.toDouble(v03.__get(2))) ) )) ), ((java.lang.Object) (( y4 + ((double) (haxe.lang.Runtime.toDouble(v03.__get(3))) ) )) )});
															}
															
															break;
														}
														
														
													}
													
													if (__temp_executeDef261) 
													{
														{
														}
														
													}
													
												}
												
												java.lang.Object commandData3 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v03, v13}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
												__temp_stmt232 = commandData3;
											}
											
											a3.push(__temp_stmt232);
										}
										
									}
									
									temp = a3;
								}
								
							}
							
						}
						
					}
					
					if (( haxe.lang.Runtime.compare(x1, width) > 0 )) 
					{
						y = ((double) (haxe.lang.Runtime.toDouble(haxe.lang.Runtime.plus(y, lineSpace))) );
						word = word.concat(temp);
						java.lang.Object dim2 = null;
						{
							double l1 = 1000000.0;
							double t1 = 1000000.0;
							double r1 = -1000.0;
							double b1 = -1000.0;
							double x10 = 0.0;
							double y5 = 0.0;
							int count2 = 0;
							{
								java.lang.Object __temp_iterator40 = word.iterator();
								while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator40, "hasNext", null)))
								{
									java.lang.Object i2 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator40, "next", null)) );
									haxe.root.Array<java.lang.Object> v2 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(i2, "v0", true)) );
									java.lang.String command1 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(i2, "v1", true));
									{
										java.lang.String __temp_svar263 = (command1);
										int __temp_hash265 = __temp_svar263.hashCode();
										boolean __temp_executeDef264 = true;
										switch (__temp_hash265)
										{
											case 81:case 76:case 77:
											{
												if (( (( ( __temp_hash265 == 81 ) && __temp_svar263.equals("Q") )) || ( (( ( __temp_hash265 == 76 ) && __temp_svar263.equals("L") )) || __temp_svar263.equals("M") ) )) 
												{
													__temp_executeDef264 = false;
													x10 = ((double) (haxe.lang.Runtime.toDouble(v2.__get(0))) );
													y5 = ((double) (haxe.lang.Runtime.toDouble(v2.__get(1))) );
													if (( x10 < l1 )) 
													{
														l1 = x10;
													}
													
													if (( x10 > r1 )) 
													{
														r1 = x10;
													}
													
													if (( y5 < t1 )) 
													{
														t1 = y5;
													}
													
													if (( y5 > b1 )) 
													{
														b1 = y5;
													}
													
													if (( v2.length > 2 )) 
													{
														x10 = ((double) (haxe.lang.Runtime.toDouble(v2.__get(2))) );
														y5 = ((double) (haxe.lang.Runtime.toDouble(v2.__get(3))) );
														if (( x10 < l1 )) 
														{
															l1 = x10;
														}
														
														if (( x10 > r1 )) 
														{
															r1 = x10;
														}
														
														if (( y5 < t1 )) 
														{
															t1 = y5;
														}
														
														if (( y5 > b1 )) 
														{
															b1 = y5;
														}
														
													}
													
												}
												
												break;
											}
											
											
										}
										
										if (__temp_executeDef264) 
										{
											{
											}
											
										}
										
									}
									
								}
								
							}
							
							dim2 = new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"centre", "dim", "end", "pos"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( l1 + ( (( r1 - l1 )) / 2 ) )) ), ((java.lang.Object) (( t1 + ( (( b1 - t1 )) / 2 ) )) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( r1 - l1 )) ), ((java.lang.Object) (( b1 - t1 )) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (r1) ), ((java.lang.Object) (b1) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (l1) ), ((java.lang.Object) (t1) )}))}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}));
						}
						
						double repos = ( ((double) (x) ) - ((double) (haxe.lang.Runtime.getField_f(haxe.lang.Runtime.getField(dim2, "pos", true), "x", true)) ) );
						{
							double y_ = ((double) (haxe.lang.Runtime.toDouble(lineSpace)) );
							double x11 = repos;
							double y6 = y_;
							boolean x01 = ( x11 == 0 );
							boolean y01 = ( y6 == 0 );
							if (( x01 && y01 )) 
							{
								word = haxe.root.Lambda.array(word);
							}
							 else 
							{
								if (x01) 
								{
									haxe.root.Array<java.lang.Object> a4 = new haxe.root.Array<java.lang.Object>();
									{
										java.lang.Object __temp_iterator41 = word.iterator();
										while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator41, "hasNext", null)))
										{
											java.lang.Object x12 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator41, "next", null)) );
											java.lang.Object __temp_stmt237 = null;
											{
												haxe.root.Array<java.lang.Object> v04 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x12, "v0", true)) );
												java.lang.String v14 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x12, "v1", true));
												{
													java.lang.String __temp_svar266 = (v14);
													int __temp_hash268 = __temp_svar266.hashCode();
													boolean __temp_executeDef267 = true;
													switch (__temp_hash268)
													{
														case 77:case 76:
														{
															if (( (( ( __temp_hash268 == 77 ) && __temp_svar266.equals("M") )) || __temp_svar266.equals("L") )) 
															{
																__temp_executeDef267 = false;
																v04 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v04.__get(0))) )) ), ((java.lang.Object) (( y6 + ((double) (haxe.lang.Runtime.toDouble(v04.__get(1))) ) )) )});
															}
															
															break;
														}
														
														
														case 81:
														{
															if (__temp_svar266.equals("Q")) 
															{
																__temp_executeDef267 = false;
																v04 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v04.__get(0))) )) ), ((java.lang.Object) (( y6 + ((double) (haxe.lang.Runtime.toDouble(v04.__get(1))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v04.__get(2))) )) ), ((java.lang.Object) (( y6 + ((double) (haxe.lang.Runtime.toDouble(v04.__get(3))) ) )) )});
															}
															
															break;
														}
														
														
													}
													
													if (__temp_executeDef267) 
													{
														{
														}
														
													}
													
												}
												
												java.lang.Object commandData4 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v04, v14}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
												__temp_stmt237 = commandData4;
											}
											
											a4.push(__temp_stmt237);
										}
										
									}
									
									word = a4;
								}
								 else 
								{
									if (y01) 
									{
										haxe.root.Array<java.lang.Object> a5 = new haxe.root.Array<java.lang.Object>();
										{
											java.lang.Object __temp_iterator42 = word.iterator();
											while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator42, "hasNext", null)))
											{
												java.lang.Object x13 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator42, "next", null)) );
												java.lang.Object __temp_stmt236 = null;
												{
													haxe.root.Array<java.lang.Object> v05 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x13, "v0", true)) );
													java.lang.String v15 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x13, "v1", true));
													{
														java.lang.String __temp_svar269 = (v15);
														int __temp_hash271 = __temp_svar269.hashCode();
														boolean __temp_executeDef270 = true;
														switch (__temp_hash271)
														{
															case 77:case 76:
															{
																if (( (( ( __temp_hash271 == 77 ) && __temp_svar269.equals("M") )) || __temp_svar269.equals("L") )) 
																{
																	__temp_executeDef270 = false;
																	v05 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x11 + ((double) (haxe.lang.Runtime.toDouble(v05.__get(0))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v05.__get(1))) )) )});
																}
																
																break;
															}
															
															
															case 81:
															{
																if (__temp_svar269.equals("Q")) 
																{
																	__temp_executeDef270 = false;
																	v05 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x11 + ((double) (haxe.lang.Runtime.toDouble(v05.__get(0))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v05.__get(1))) )) ), ((java.lang.Object) (( x11 + ((double) (haxe.lang.Runtime.toDouble(v05.__get(2))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v05.__get(3))) )) )});
																}
																
																break;
															}
															
															
														}
														
														if (__temp_executeDef270) 
														{
															{
															}
															
														}
														
													}
													
													java.lang.Object commandData5 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v05, v15}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
													__temp_stmt236 = commandData5;
												}
												
												a5.push(__temp_stmt236);
											}
											
										}
										
										word = a5;
									}
									 else 
									{
										haxe.root.Array<java.lang.Object> a6 = new haxe.root.Array<java.lang.Object>();
										{
											java.lang.Object __temp_iterator43 = word.iterator();
											while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator43, "hasNext", null)))
											{
												java.lang.Object x14 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator43, "next", null)) );
												java.lang.Object __temp_stmt235 = null;
												{
													haxe.root.Array<java.lang.Object> v06 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x14, "v0", true)) );
													java.lang.String v16 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x14, "v1", true));
													{
														java.lang.String __temp_svar272 = (v16);
														int __temp_hash274 = __temp_svar272.hashCode();
														boolean __temp_executeDef273 = true;
														switch (__temp_hash274)
														{
															case 77:case 76:
															{
																if (( (( ( __temp_hash274 == 77 ) && __temp_svar272.equals("M") )) || __temp_svar272.equals("L") )) 
																{
																	__temp_executeDef273 = false;
																	v06 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x11 + ((double) (haxe.lang.Runtime.toDouble(v06.__get(0))) ) )) ), ((java.lang.Object) (( y6 + ((double) (haxe.lang.Runtime.toDouble(v06.__get(1))) ) )) )});
																}
																
																break;
															}
															
															
															case 81:
															{
																if (__temp_svar272.equals("Q")) 
																{
																	__temp_executeDef273 = false;
																	v06 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x11 + ((double) (haxe.lang.Runtime.toDouble(v06.__get(0))) ) )) ), ((java.lang.Object) (( y6 + ((double) (haxe.lang.Runtime.toDouble(v06.__get(1))) ) )) ), ((java.lang.Object) (( x11 + ((double) (haxe.lang.Runtime.toDouble(v06.__get(2))) ) )) ), ((java.lang.Object) (( y6 + ((double) (haxe.lang.Runtime.toDouble(v06.__get(3))) ) )) )});
																}
																
																break;
															}
															
															
														}
														
														if (__temp_executeDef273) 
														{
															{
															}
															
														}
														
													}
													
													java.lang.Object commandData6 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v06, v16}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
													__temp_stmt235 = commandData6;
												}
												
												a6.push(__temp_stmt235);
											}
											
										}
										
										word = a6;
									}
									
								}
								
							}
							
						}
						
						x1 = ( x1 + repos );
					}
					 else 
					{
						word = word.concat(temp);
					}
					
				}
				 else 
				{
					path = path.concat(word);
					if (( highlightFunction != null )) 
					{
						java.lang.String j1 = "";
						int count3 = ( counta + 1 );
						java.lang.String wordContent1 = "";
						if (( count3 < arrStr.length )) 
						{
							while ((  ! (haxe.lang.Runtime.valEq(j1, " "))  && ( count3 < arrStr.length ) ))
							{
								j1 = arrStr.__get(count3);
								if ( ! (haxe.lang.Runtime.valEq(j1, " ")) ) 
								{
									wordContent1 = ( wordContent1 + j1 );
								}
								
								count3++;
							}
							
							haxe.root.Array<java.lang.Object> float1 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (highlightFunction.__hx_invoke1_f(0.0, wordContent1)) )) )});
							java.lang.String commandEnum1 = haxe.lang.Runtime.toString("F");
							java.lang.Object fillColor1 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{float1, commandEnum1}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
							if (( outlineFunction != null )) 
							{
								float1 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (outlineFunction.__hx_invoke1_f(0.0, wordContent1)) )) )});
								commandEnum1 = haxe.lang.Runtime.toString("O");
								java.lang.Object outlineColor1 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{float1, commandEnum1}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
								path.push(outlineColor1);
							}
							
							path.push(fillColor1);
						}
						
					}
					
					x1 += ( ((double) (15) ) * scale );
					word = new haxe.root.Array<java.lang.Object>();
				}
				
				counta++;
			}
			
		}
		
		path = path.concat(word);
		return path;
	}
	
	
	public static   int rainbowPencilHighlight(java.lang.String str)
	{
		int rand = 0;
		{
			double x = ( java.lang.Math.random() * (( new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{13816001, 13467688, 13802769, 14905640, 15755121, 13777201, 11480113, 9450302, 8797520, 5786205, 5545667, 2912413, 4553390, 3558765, 3640429, 7251784, 3562916, 4550210, 12683310, 8467492, 4206116, 2696224, 5396305, 1776409}).length - 1 )) );
			rand = ((int) (x) );
		}
		
		int col = ((int) (haxe.lang.Runtime.toInt(new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{13816001, 13467688, 13802769, 14905640, 15755121, 13777201, 11480113, 9450302, 8797520, 5786205, 5545667, 2912413, 4553390, 3558765, 3640429, 7251784, 3562916, 4550210, 12683310, 8467492, 4206116, 2696224, 5396305, 1776409}).__get(rand))) );
		return col;
	}
	
	
	public static   int highlightAnd(java.lang.String str)
	{
		haxe.Log.trace.__hx_invoke2_o(0.0, ( ( "_" + str ) + "_" ), 0.0, new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"className", "fileName", "methodName"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{"letters.Path", "Path.hx", "highlightAnd"}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"lineNumber"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (305) )) )})));
		if (haxe.lang.Runtime.valEq(str, "and")) 
		{
			return 16711680;
		}
		
		if (haxe.lang.Runtime.valEq(str, "in")) 
		{
			return 65535;
		}
		
		return 16763904;
	}
	
	
	public static   haxe.root.Array<java.lang.Object> translate(java.lang.Object path, double x_, double y_)
	{
		double x = x_;
		double y = y_;
		boolean x0 = ( x == 0 );
		boolean y0 = ( y == 0 );
		if (( x0 && y0 )) 
		{
			return haxe.root.Lambda.array(path);
		}
		
		if (x0) 
		{
			haxe.root.Array<java.lang.Object> a = new haxe.root.Array<java.lang.Object>();
			{
				java.lang.Object __temp_iterator44 = ((java.lang.Object) (haxe.lang.Runtime.callField(path, "iterator", null)) );
				while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator44, "hasNext", null)))
				{
					java.lang.Object x1 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator44, "next", null)) );
					java.lang.Object __temp_stmt275 = null;
					{
						haxe.root.Array<java.lang.Object> v0 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x1, "v0", true)) );
						java.lang.String v1 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x1, "v1", true));
						{
							java.lang.String __temp_svar278 = (v1);
							int __temp_hash280 = __temp_svar278.hashCode();
							boolean __temp_executeDef279 = true;
							switch (__temp_hash280)
							{
								case 77:case 76:
								{
									if (( (( ( __temp_hash280 == 77 ) && __temp_svar278.equals("M") )) || __temp_svar278.equals("L") )) 
									{
										__temp_executeDef279 = false;
										v0 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v0.__get(0))) )) ), ((java.lang.Object) (( y + ((double) (haxe.lang.Runtime.toDouble(v0.__get(1))) ) )) )});
									}
									
									break;
								}
								
								
								case 81:
								{
									if (__temp_svar278.equals("Q")) 
									{
										__temp_executeDef279 = false;
										v0 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v0.__get(0))) )) ), ((java.lang.Object) (( y + ((double) (haxe.lang.Runtime.toDouble(v0.__get(1))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v0.__get(2))) )) ), ((java.lang.Object) (( y + ((double) (haxe.lang.Runtime.toDouble(v0.__get(3))) ) )) )});
									}
									
									break;
								}
								
								
							}
							
							if (__temp_executeDef279) 
							{
								{
								}
								
							}
							
						}
						
						java.lang.Object commandData = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v0, v1}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
						__temp_stmt275 = commandData;
					}
					
					a.push(__temp_stmt275);
				}
				
			}
			
			return a;
		}
		
		if (y0) 
		{
			haxe.root.Array<java.lang.Object> a1 = new haxe.root.Array<java.lang.Object>();
			{
				java.lang.Object __temp_iterator45 = ((java.lang.Object) (haxe.lang.Runtime.callField(path, "iterator", null)) );
				while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator45, "hasNext", null)))
				{
					java.lang.Object x2 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator45, "next", null)) );
					java.lang.Object __temp_stmt276 = null;
					{
						haxe.root.Array<java.lang.Object> v01 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x2, "v0", true)) );
						java.lang.String v11 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x2, "v1", true));
						{
							java.lang.String __temp_svar281 = (v11);
							int __temp_hash283 = __temp_svar281.hashCode();
							boolean __temp_executeDef282 = true;
							switch (__temp_hash283)
							{
								case 77:case 76:
								{
									if (( (( ( __temp_hash283 == 77 ) && __temp_svar281.equals("M") )) || __temp_svar281.equals("L") )) 
									{
										__temp_executeDef282 = false;
										v01 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x + ((double) (haxe.lang.Runtime.toDouble(v01.__get(0))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v01.__get(1))) )) )});
									}
									
									break;
								}
								
								
								case 81:
								{
									if (__temp_svar281.equals("Q")) 
									{
										__temp_executeDef282 = false;
										v01 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x + ((double) (haxe.lang.Runtime.toDouble(v01.__get(0))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v01.__get(1))) )) ), ((java.lang.Object) (( x + ((double) (haxe.lang.Runtime.toDouble(v01.__get(2))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v01.__get(3))) )) )});
									}
									
									break;
								}
								
								
							}
							
							if (__temp_executeDef282) 
							{
								{
								}
								
							}
							
						}
						
						java.lang.Object commandData1 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v01, v11}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
						__temp_stmt276 = commandData1;
					}
					
					a1.push(__temp_stmt276);
				}
				
			}
			
			return a1;
		}
		
		{
			haxe.root.Array<java.lang.Object> a2 = new haxe.root.Array<java.lang.Object>();
			{
				java.lang.Object __temp_iterator46 = ((java.lang.Object) (haxe.lang.Runtime.callField(path, "iterator", null)) );
				while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator46, "hasNext", null)))
				{
					java.lang.Object x3 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator46, "next", null)) );
					java.lang.Object __temp_stmt277 = null;
					{
						haxe.root.Array<java.lang.Object> v02 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x3, "v0", true)) );
						java.lang.String v12 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x3, "v1", true));
						{
							java.lang.String __temp_svar284 = (v12);
							int __temp_hash286 = __temp_svar284.hashCode();
							boolean __temp_executeDef285 = true;
							switch (__temp_hash286)
							{
								case 77:case 76:
								{
									if (( (( ( __temp_hash286 == 77 ) && __temp_svar284.equals("M") )) || __temp_svar284.equals("L") )) 
									{
										__temp_executeDef285 = false;
										v02 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x + ((double) (haxe.lang.Runtime.toDouble(v02.__get(0))) ) )) ), ((java.lang.Object) (( y + ((double) (haxe.lang.Runtime.toDouble(v02.__get(1))) ) )) )});
									}
									
									break;
								}
								
								
								case 81:
								{
									if (__temp_svar284.equals("Q")) 
									{
										__temp_executeDef285 = false;
										v02 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x + ((double) (haxe.lang.Runtime.toDouble(v02.__get(0))) ) )) ), ((java.lang.Object) (( y + ((double) (haxe.lang.Runtime.toDouble(v02.__get(1))) ) )) ), ((java.lang.Object) (( x + ((double) (haxe.lang.Runtime.toDouble(v02.__get(2))) ) )) ), ((java.lang.Object) (( y + ((double) (haxe.lang.Runtime.toDouble(v02.__get(3))) ) )) )});
									}
									
									break;
								}
								
								
							}
							
							if (__temp_executeDef285) 
							{
								{
								}
								
							}
							
						}
						
						java.lang.Object commandData2 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v02, v12}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
						__temp_stmt277 = commandData2;
					}
					
					a2.push(__temp_stmt277);
				}
				
			}
			
			return a2;
		}
		
	}
	
	
	public static   haxe.root.Array<java.lang.Object> scale(java.lang.Object path, double x_, double y_)
	{
		double x = x_;
		double y = y_;
		boolean x0 = ( x == 1 );
		boolean y0 = ( y == 1 );
		if (( x0 && y0 )) 
		{
			return haxe.root.Lambda.array(path);
		}
		
		if (x0) 
		{
			haxe.root.Array<java.lang.Object> a = new haxe.root.Array<java.lang.Object>();
			{
				java.lang.Object __temp_iterator47 = ((java.lang.Object) (haxe.lang.Runtime.callField(path, "iterator", null)) );
				while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator47, "hasNext", null)))
				{
					java.lang.Object x1 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator47, "next", null)) );
					java.lang.Object __temp_stmt287 = null;
					{
						haxe.root.Array<java.lang.Object> v0 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x1, "v0", true)) );
						java.lang.String v1 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x1, "v1", true));
						{
							java.lang.String __temp_svar290 = (v1);
							int __temp_hash292 = __temp_svar290.hashCode();
							boolean __temp_executeDef291 = true;
							switch (__temp_hash292)
							{
								case 77:case 76:
								{
									if (( (( ( __temp_hash292 == 77 ) && __temp_svar290.equals("M") )) || __temp_svar290.equals("L") )) 
									{
										__temp_executeDef291 = false;
										v0 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v0.__get(0))) )) ), ((java.lang.Object) (( y * ((double) (haxe.lang.Runtime.toDouble(v0.__get(1))) ) )) )});
									}
									
									break;
								}
								
								
								case 81:
								{
									if (__temp_svar290.equals("Q")) 
									{
										__temp_executeDef291 = false;
										v0 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v0.__get(0))) )) ), ((java.lang.Object) (( y * ((double) (haxe.lang.Runtime.toDouble(v0.__get(1))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v0.__get(2))) )) ), ((java.lang.Object) (( y * ((double) (haxe.lang.Runtime.toDouble(v0.__get(3))) ) )) )});
									}
									
									break;
								}
								
								
							}
							
							if (__temp_executeDef291) 
							{
								{
								}
								
							}
							
						}
						
						java.lang.Object commandData = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v0, v1}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
						__temp_stmt287 = commandData;
					}
					
					a.push(__temp_stmt287);
				}
				
			}
			
			return a;
		}
		
		if (y0) 
		{
			haxe.root.Array<java.lang.Object> a1 = new haxe.root.Array<java.lang.Object>();
			{
				java.lang.Object __temp_iterator48 = ((java.lang.Object) (haxe.lang.Runtime.callField(path, "iterator", null)) );
				while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator48, "hasNext", null)))
				{
					java.lang.Object x2 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator48, "next", null)) );
					java.lang.Object __temp_stmt288 = null;
					{
						haxe.root.Array<java.lang.Object> v01 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x2, "v0", true)) );
						java.lang.String v11 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x2, "v1", true));
						{
							java.lang.String __temp_svar293 = (v11);
							int __temp_hash295 = __temp_svar293.hashCode();
							boolean __temp_executeDef294 = true;
							switch (__temp_hash295)
							{
								case 77:case 76:
								{
									if (( (( ( __temp_hash295 == 77 ) && __temp_svar293.equals("M") )) || __temp_svar293.equals("L") )) 
									{
										__temp_executeDef294 = false;
										v01 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x * ((double) (haxe.lang.Runtime.toDouble(v01.__get(0))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v01.__get(1))) )) )});
									}
									
									break;
								}
								
								
								case 81:
								{
									if (__temp_svar293.equals("Q")) 
									{
										__temp_executeDef294 = false;
										v01 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x * ((double) (haxe.lang.Runtime.toDouble(v01.__get(0))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v01.__get(1))) )) ), ((java.lang.Object) (( x * ((double) (haxe.lang.Runtime.toDouble(v01.__get(2))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v01.__get(3))) )) )});
									}
									
									break;
								}
								
								
							}
							
							if (__temp_executeDef294) 
							{
								{
								}
								
							}
							
						}
						
						java.lang.Object commandData1 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v01, v11}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
						__temp_stmt288 = commandData1;
					}
					
					a1.push(__temp_stmt288);
				}
				
			}
			
			return a1;
		}
		
		{
			haxe.root.Array<java.lang.Object> a2 = new haxe.root.Array<java.lang.Object>();
			{
				java.lang.Object __temp_iterator49 = ((java.lang.Object) (haxe.lang.Runtime.callField(path, "iterator", null)) );
				while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator49, "hasNext", null)))
				{
					java.lang.Object x3 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator49, "next", null)) );
					java.lang.Object __temp_stmt289 = null;
					{
						haxe.root.Array<java.lang.Object> v02 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x3, "v0", true)) );
						java.lang.String v12 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x3, "v1", true));
						{
							java.lang.String __temp_svar296 = (v12);
							int __temp_hash298 = __temp_svar296.hashCode();
							boolean __temp_executeDef297 = true;
							switch (__temp_hash298)
							{
								case 77:case 76:
								{
									if (( (( ( __temp_hash298 == 77 ) && __temp_svar296.equals("M") )) || __temp_svar296.equals("L") )) 
									{
										__temp_executeDef297 = false;
										v02 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x * ((double) (haxe.lang.Runtime.toDouble(v02.__get(0))) ) )) ), ((java.lang.Object) (( y * ((double) (haxe.lang.Runtime.toDouble(v02.__get(1))) ) )) )});
									}
									
									break;
								}
								
								
								case 81:
								{
									if (__temp_svar296.equals("Q")) 
									{
										__temp_executeDef297 = false;
										v02 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x * ((double) (haxe.lang.Runtime.toDouble(v02.__get(0))) ) )) ), ((java.lang.Object) (( y * ((double) (haxe.lang.Runtime.toDouble(v02.__get(1))) ) )) ), ((java.lang.Object) (( x * ((double) (haxe.lang.Runtime.toDouble(v02.__get(2))) ) )) ), ((java.lang.Object) (( y * ((double) (haxe.lang.Runtime.toDouble(v02.__get(3))) ) )) )});
									}
									
									break;
								}
								
								
							}
							
							if (__temp_executeDef297) 
							{
								{
								}
								
							}
							
						}
						
						java.lang.Object commandData2 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v02, v12}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
						__temp_stmt289 = commandData2;
					}
					
					a2.push(__temp_stmt289);
				}
				
			}
			
			return a2;
		}
		
	}
	
	
	public static   haxe.root.Array<java.lang.Object> scaleTranslate(java.lang.Object path, double x_, double y_, double sx_, double sy_)
	{
		double x = x_;
		double y = y_;
		double sx = sx_;
		double sy = sy_;
		{
			haxe.root.Array<java.lang.Object> a = new haxe.root.Array<java.lang.Object>();
			{
				java.lang.Object __temp_iterator50 = ((java.lang.Object) (haxe.lang.Runtime.callField(path, "iterator", null)) );
				while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator50, "hasNext", null)))
				{
					java.lang.Object x1 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator50, "next", null)) );
					java.lang.Object __temp_stmt299 = null;
					{
						haxe.root.Array<java.lang.Object> v0 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x1, "v0", true)) );
						java.lang.String v1 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x1, "v1", true));
						{
							java.lang.String __temp_svar300 = (v1);
							int __temp_hash302 = __temp_svar300.hashCode();
							boolean __temp_executeDef301 = true;
							switch (__temp_hash302)
							{
								case 77:case 76:
								{
									if (( (( ( __temp_hash302 == 77 ) && __temp_svar300.equals("M") )) || __temp_svar300.equals("L") )) 
									{
										__temp_executeDef301 = false;
										v0 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( ( sx * ((double) (haxe.lang.Runtime.toDouble(v0.__get(0))) ) ) + x )) ), ((java.lang.Object) (( ( sy * ((double) (haxe.lang.Runtime.toDouble(v0.__get(1))) ) ) + y )) )});
									}
									
									break;
								}
								
								
								case 81:
								{
									if (__temp_svar300.equals("Q")) 
									{
										__temp_executeDef301 = false;
										v0 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( ( sx * ((double) (haxe.lang.Runtime.toDouble(v0.__get(0))) ) ) + x )) ), ((java.lang.Object) (( ( sy * ((double) (haxe.lang.Runtime.toDouble(v0.__get(1))) ) ) + y )) ), ((java.lang.Object) (( ( sx * ((double) (haxe.lang.Runtime.toDouble(v0.__get(2))) ) ) + x )) ), ((java.lang.Object) (( ( sy * ((double) (haxe.lang.Runtime.toDouble(v0.__get(3))) ) ) + y )) )});
									}
									
									break;
								}
								
								
							}
							
							if (__temp_executeDef301) 
							{
								{
								}
								
							}
							
						}
						
						java.lang.Object commandData = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v0, v1}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
						__temp_stmt299 = commandData;
					}
					
					a.push(__temp_stmt299);
				}
				
			}
			
			return a;
		}
		
	}
	
	
	public static  double fl;
	
	public static   haxe.root.Array<java.lang.Object> rotateXYZ(java.lang.Object path, double rX, double rY, double rZ, double zSpecial, java.lang.Object ox, java.lang.Object oy, java.lang.Object oz)
	{
		if (( ( ( ox == null ) || ( oy == null ) ) || ( oz == null ) )) 
		{
			java.lang.Object dim = null;
			{
				double l = 1000000.0;
				double t = 1000000.0;
				double r = -1000.0;
				double b = -1000.0;
				double x = 0.0;
				double y = 0.0;
				int count = 0;
				{
					java.lang.Object __temp_iterator51 = ((java.lang.Object) (haxe.lang.Runtime.callField(path, "iterator", null)) );
					while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator51, "hasNext", null)))
					{
						java.lang.Object i = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator51, "next", null)) );
						haxe.root.Array<java.lang.Object> v = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(i, "v0", true)) );
						java.lang.String command = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(i, "v1", true));
						{
							java.lang.String __temp_svar304 = (command);
							int __temp_hash306 = __temp_svar304.hashCode();
							boolean __temp_executeDef305 = true;
							switch (__temp_hash306)
							{
								case 81:case 76:case 77:
								{
									if (( (( ( __temp_hash306 == 81 ) && __temp_svar304.equals("Q") )) || ( (( ( __temp_hash306 == 76 ) && __temp_svar304.equals("L") )) || __temp_svar304.equals("M") ) )) 
									{
										__temp_executeDef305 = false;
										x = ((double) (haxe.lang.Runtime.toDouble(v.__get(0))) );
										y = ((double) (haxe.lang.Runtime.toDouble(v.__get(1))) );
										if (( x < l )) 
										{
											l = x;
										}
										
										if (( x > r )) 
										{
											r = x;
										}
										
										if (( y < t )) 
										{
											t = y;
										}
										
										if (( y > b )) 
										{
											b = y;
										}
										
										if (( v.length > 2 )) 
										{
											x = ((double) (haxe.lang.Runtime.toDouble(v.__get(2))) );
											y = ((double) (haxe.lang.Runtime.toDouble(v.__get(3))) );
											if (( x < l )) 
											{
												l = x;
											}
											
											if (( x > r )) 
											{
												r = x;
											}
											
											if (( y < t )) 
											{
												t = y;
											}
											
											if (( y > b )) 
											{
												b = y;
											}
											
										}
										
									}
									
									break;
								}
								
								
							}
							
							if (__temp_executeDef305) 
							{
								{
								}
								
							}
							
						}
						
					}
					
				}
				
				dim = new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"centre", "dim", "end", "pos"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( l + ( (( r - l )) / 2 ) )) ), ((java.lang.Object) (( t + ( (( b - t )) / 2 ) )) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( r - l )) ), ((java.lang.Object) (( b - t )) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (r) ), ((java.lang.Object) (b) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (l) ), ((java.lang.Object) (t) )}))}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}));
			}
			
			java.lang.Object centre = haxe.lang.Runtime.getField(dim, "centre", true);
			ox = ((double) (haxe.lang.Runtime.getField_f(centre, "x", true)) );
			oy = ((double) (haxe.lang.Runtime.getField_f(centre, "y", true)) );
			oz = zSpecial;
		}
		
		double sX = java.lang.Math.sin(rX);
		double sY = java.lang.Math.sin(rY);
		double sZ = java.lang.Math.sin(rZ);
		double cX = java.lang.Math.cos(rX);
		double cY = java.lang.Math.cos(rY);
		double cZ = java.lang.Math.cos(rZ);
		double x1 = 0.0;
		double y1 = 0.0;
		double z = 0.0;
		double x2 = 0.0;
		double y2 = 0.0;
		double z2 = 0.0;
		double tx = 0.0;
		double ty = 0.0;
		double tz = 0.0;
		double s = 0.0;
		int fL = ((int) (420.0) );
		{
			haxe.root.Array<java.lang.Object> a = new haxe.root.Array<java.lang.Object>();
			{
				java.lang.Object __temp_iterator52 = ((java.lang.Object) (haxe.lang.Runtime.callField(path, "iterator", null)) );
				while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator52, "hasNext", null)))
				{
					java.lang.Object x3 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator52, "next", null)) );
					java.lang.Object __temp_stmt303 = null;
					{
						haxe.root.Array<java.lang.Object> v0 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x3, "v0", true)) );
						java.lang.String v1 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x3, "v1", true));
						{
							java.lang.String __temp_svar307 = (v1);
							int __temp_hash309 = __temp_svar307.hashCode();
							boolean __temp_executeDef308 = true;
							switch (__temp_hash309)
							{
								case 76:case 77:
								{
									if (( (( ( __temp_hash309 == 76 ) && __temp_svar307.equals("L") )) || __temp_svar307.equals("M") )) 
									{
										__temp_executeDef308 = false;
										tx = ( ((double) (haxe.lang.Runtime.toDouble(v0.__get(0))) ) - ((double) (haxe.lang.Runtime.toDouble(ox)) ) );
										ty = ( ((double) (haxe.lang.Runtime.toDouble(v0.__get(1))) ) - ((double) (haxe.lang.Runtime.toDouble(oy)) ) );
										tz = ( ((double) (zSpecial) ) - ((double) (haxe.lang.Runtime.toDouble(oz)) ) );
										x1 = ((double) (haxe.lang.Runtime.toDouble(haxe.lang.Runtime.plus(( ( ( ( tx * cY ) * cZ ) + ( tz * sY ) ) - ( ty * sZ ) ), ox))) );
										y1 = ((double) (haxe.lang.Runtime.toDouble(haxe.lang.Runtime.plus(( ( ( ( ty * cX ) * cZ ) - ( tz * sX ) ) + ( tx * sZ ) ), oy))) );
										z = ((double) (haxe.lang.Runtime.toDouble(haxe.lang.Runtime.plus(( ( ( ty * sX ) + ( ( tz * cX ) * cY ) ) - ( tx * sY ) ), oz))) );
										s = ( 1 - (  - (z)  / fL ) );
										v0 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x1 / s )) ), ((java.lang.Object) (( y1 / s )) )});
									}
									
									break;
								}
								
								
								case 81:
								{
									if (__temp_svar307.equals("Q")) 
									{
										__temp_executeDef308 = false;
										tx = ( ((double) (haxe.lang.Runtime.toDouble(v0.__get(0))) ) - ((double) (haxe.lang.Runtime.toDouble(ox)) ) );
										ty = ( ((double) (haxe.lang.Runtime.toDouble(v0.__get(1))) ) - ((double) (haxe.lang.Runtime.toDouble(oy)) ) );
										tz = ( ((double) (zSpecial) ) - ((double) (haxe.lang.Runtime.toDouble(oz)) ) );
										x1 = ((double) (haxe.lang.Runtime.toDouble(haxe.lang.Runtime.plus(( ( ( ( tx * cY ) * cZ ) + ( tz * sY ) ) - ( ty * sZ ) ), ox))) );
										y1 = ((double) (haxe.lang.Runtime.toDouble(haxe.lang.Runtime.plus(( ( ( ( ty * cX ) * cZ ) - ( tz * sX ) ) + ( tx * sZ ) ), oy))) );
										z = ((double) (haxe.lang.Runtime.toDouble(haxe.lang.Runtime.plus(( ( ( ty * sX ) + ( ( tz * cX ) * cY ) ) - ( tx * sY ) ), oz))) );
										s = ( 1 - (  - (z)  / fL ) );
										x1 = ( x1 / s );
										y1 = ( y1 / s );
										tx = ( ((double) (haxe.lang.Runtime.toDouble(v0.__get(2))) ) - ((double) (haxe.lang.Runtime.toDouble(ox)) ) );
										ty = ( ((double) (haxe.lang.Runtime.toDouble(v0.__get(3))) ) - ((double) (haxe.lang.Runtime.toDouble(oy)) ) );
										tz = ( ((double) (zSpecial) ) - ((double) (haxe.lang.Runtime.toDouble(oz)) ) );
										x2 = ((double) (haxe.lang.Runtime.toDouble(haxe.lang.Runtime.plus(( ( ( ( tx * cY ) * cZ ) + ( tz * sY ) ) - ( ty * sZ ) ), ox))) );
										y2 = ((double) (haxe.lang.Runtime.toDouble(haxe.lang.Runtime.plus(( ( ( ( ty * cX ) * cZ ) - ( tz * sX ) ) + ( tx * sZ ) ), oy))) );
										z2 = ((double) (haxe.lang.Runtime.toDouble(haxe.lang.Runtime.plus(( ( ( ty * sX ) + ( ( tz * cX ) * cY ) ) - ( tx * sY ) ), oz))) );
										s = ( 1 - (  - (z2)  / fL ) );
										x2 = ( x2 / s );
										y2 = ( y2 / s );
										v0 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (x1) ), ((java.lang.Object) (y1) ), ((java.lang.Object) (x2) ), ((java.lang.Object) (y2) )});
									}
									
									break;
								}
								
								
							}
							
							if (__temp_executeDef308) 
							{
								{
								}
								
							}
							
						}
						
						java.lang.Object commandData = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v0, v1}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
						__temp_stmt303 = commandData;
					}
					
					a.push(__temp_stmt303);
				}
				
			}
			
			return a;
		}
		
	}
	
	
	public static   java.lang.Object getDim(java.lang.Object path)
	{
		double l = 1000000.0;
		double t = 1000000.0;
		double r = -1000.0;
		double b = -1000.0;
		double x = 0.0;
		double y = 0.0;
		int count = 0;
		{
			java.lang.Object __temp_iterator53 = ((java.lang.Object) (haxe.lang.Runtime.callField(path, "iterator", null)) );
			while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator53, "hasNext", null)))
			{
				java.lang.Object i = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator53, "next", null)) );
				haxe.root.Array<java.lang.Object> v = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(i, "v0", true)) );
				java.lang.String command = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(i, "v1", true));
				{
					java.lang.String __temp_svar310 = (command);
					int __temp_hash312 = __temp_svar310.hashCode();
					boolean __temp_executeDef311 = true;
					switch (__temp_hash312)
					{
						case 81:case 76:case 77:
						{
							if (( (( ( __temp_hash312 == 81 ) && __temp_svar310.equals("Q") )) || ( (( ( __temp_hash312 == 76 ) && __temp_svar310.equals("L") )) || __temp_svar310.equals("M") ) )) 
							{
								__temp_executeDef311 = false;
								x = ((double) (haxe.lang.Runtime.toDouble(v.__get(0))) );
								y = ((double) (haxe.lang.Runtime.toDouble(v.__get(1))) );
								if (( x < l )) 
								{
									l = x;
								}
								
								if (( x > r )) 
								{
									r = x;
								}
								
								if (( y < t )) 
								{
									t = y;
								}
								
								if (( y > b )) 
								{
									b = y;
								}
								
								if (( v.length > 2 )) 
								{
									x = ((double) (haxe.lang.Runtime.toDouble(v.__get(2))) );
									y = ((double) (haxe.lang.Runtime.toDouble(v.__get(3))) );
									if (( x < l )) 
									{
										l = x;
									}
									
									if (( x > r )) 
									{
										r = x;
									}
									
									if (( y < t )) 
									{
										t = y;
									}
									
									if (( y > b )) 
									{
										b = y;
									}
									
								}
								
							}
							
							break;
						}
						
						
					}
					
					if (__temp_executeDef311) 
					{
						{
						}
						
					}
					
				}
				
			}
			
		}
		
		return new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"centre", "dim", "end", "pos"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( l + ( (( r - l )) / 2 ) )) ), ((java.lang.Object) (( t + ( (( b - t )) / 2 ) )) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( r - l )) ), ((java.lang.Object) (( b - t )) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (r) ), ((java.lang.Object) (b) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (l) ), ((java.lang.Object) (t) )}))}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}));
	}
	
	
	public static   void tracePoints(java.lang.Object path)
	{
		haxe.root.Array<java.lang.String> str = new haxe.root.Array<java.lang.String>(new java.lang.String[]{""});
		haxe.root.List<java.lang.Object> path1 = haxe.root.Lambda.map(path, new letters.Path_tracePoints_556__Fun(((haxe.root.Array<java.lang.String>) (str) )));
		haxe.Log.trace.__hx_invoke2_o(0.0, str.__get(0), 0.0, new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"className", "fileName", "methodName"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{"letters.Path", "Path.hx", "tracePoints"}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"lineNumber"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (557) )) )})));
	}
	
	
	public static  <A, B> haxe.root.Array<B> mapArr(java.lang.Object it, haxe.lang.Function f)
	{
		haxe.root.Array<B> a = new haxe.root.Array<B>();
		{
			java.lang.Object __temp_iterator55 = ((java.lang.Object) (haxe.lang.Runtime.callField(it, "iterator", null)) );
			while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator55, "hasNext", null)))
			{
				A x = ((A) (haxe.lang.Runtime.callField(__temp_iterator55, "next", null)) );
				a.push(((B) (f.__hx_invoke1_o(0.0, x)) ));
			}
			
		}
		
		return a;
	}
	
	
	public static   java.lang.Object __hx_createEmpty()
	{
		return new letters.Path(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
	}
	
	
	public static   java.lang.Object __hx_create(haxe.root.Array arr)
	{
		return new letters.Path(haxe.lang.Runtime.toString(arr.__get(0)));
	}
	
	
	public  int length;
	
	public  int count;
	
	public  java.lang.String str;
	
	public  java.lang.String last;
	
	public  double left;
	
	public  double top;
	
	public  double right;
	
	public  double bottom;
	
	public  boolean hasIterated;
	
	public   java.lang.Object iterator()
	{
		this.count = 0;
		return this;
	}
	
	
	public   boolean hasNext()
	{
		boolean hasAnother = ( this.count < this.length );
		if ( ! (hasAnother) ) 
		{
			this.hasIterated = true;
		}
		
		return hasAnother;
	}
	
	
	public   java.lang.Object next()
	{
		java.lang.String command = haxe.lang.StringExt.charAt(this.str, this.count++);
		java.lang.String commandEnum = null;
		if (haxe.lang.Runtime.valEq(command, " ")) 
		{
			command = haxe.lang.StringExt.charAt(this.str, this.count++);
		}
		
		boolean __temp_stmt180 = false;
		{
			java.lang.String __temp_svar193 = (command);
			int __temp_hash195 = __temp_svar193.hashCode();
			boolean __temp_executeDef194 = true;
			switch (__temp_hash195)
			{
				case 57:case 56:case 55:case 54:case 53:case 52:case 51:case 50:case 49:case 48:
				{
					if (( (( ( __temp_hash195 == 57 ) && __temp_svar193.equals("9") )) || ( (( ( __temp_hash195 == 56 ) && __temp_svar193.equals("8") )) || ( (( ( __temp_hash195 == 55 ) && __temp_svar193.equals("7") )) || ( (( ( __temp_hash195 == 54 ) && __temp_svar193.equals("6") )) || ( (( ( __temp_hash195 == 53 ) && __temp_svar193.equals("5") )) || ( (( ( __temp_hash195 == 52 ) && __temp_svar193.equals("4") )) || ( (( ( __temp_hash195 == 51 ) && __temp_svar193.equals("3") )) || ( (( ( __temp_hash195 == 50 ) && __temp_svar193.equals("2") )) || ( (( ( __temp_hash195 == 49 ) && __temp_svar193.equals("1") )) || __temp_svar193.equals("0") ) ) ) ) ) ) ) ) )) 
					{
						__temp_executeDef194 = false;
						__temp_stmt180 = true;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef194) 
			{
				__temp_stmt180 = false;
			}
			
		}
		
		if (__temp_stmt180) 
		{
			commandEnum = this.last;
			this.count--;
		}
		 else 
		{
			commandEnum = haxe.lang.Runtime.toString(command);
		}
		
		{
			java.lang.String __temp_svar208 = (commandEnum);
			boolean __temp_executeDef209 = true;
			switch (__temp_svar208.hashCode())
			{
				case 76:
				{
					if (__temp_svar208.equals("L")) 
					{
						__temp_executeDef209 = false;
						java.lang.String command1 = haxe.lang.Runtime.toString("L");
						this.last = command1;
						java.lang.String num = "";
						int increment = 0;
						boolean isX = true;
						haxe.root.Array<java.lang.Object> arr = new haxe.root.Array<java.lang.Object>();
						while (( increment < 2 ))
						{
							java.lang.String _char = haxe.lang.StringExt.charAt(this.str, this.count);
							this.count++;
							boolean __temp_stmt185 = false;
							{
								java.lang.String __temp_svar199 = (_char);
								int __temp_hash201 = __temp_svar199.hashCode();
								boolean __temp_executeDef200 = true;
								switch (__temp_hash201)
								{
									case 57:case 56:case 55:case 54:case 53:case 52:case 51:case 50:case 49:case 48:
									{
										if (( (( ( __temp_hash201 == 57 ) && __temp_svar199.equals("9") )) || ( (( ( __temp_hash201 == 56 ) && __temp_svar199.equals("8") )) || ( (( ( __temp_hash201 == 55 ) && __temp_svar199.equals("7") )) || ( (( ( __temp_hash201 == 54 ) && __temp_svar199.equals("6") )) || ( (( ( __temp_hash201 == 53 ) && __temp_svar199.equals("5") )) || ( (( ( __temp_hash201 == 52 ) && __temp_svar199.equals("4") )) || ( (( ( __temp_hash201 == 51 ) && __temp_svar199.equals("3") )) || ( (( ( __temp_hash201 == 50 ) && __temp_svar199.equals("2") )) || ( (( ( __temp_hash201 == 49 ) && __temp_svar199.equals("1") )) || __temp_svar199.equals("0") ) ) ) ) ) ) ) ) )) 
										{
											__temp_executeDef200 = false;
											__temp_stmt185 = true;
										}
										
										break;
									}
									
									
								}
								
								if (__temp_executeDef200) 
								{
									__temp_stmt185 = false;
								}
								
							}
							
							boolean __temp_boolv186 = false;
							if ( ! (__temp_stmt185) ) 
							{
								__temp_boolv186 = haxe.lang.Runtime.valEq(_char, ".");
							}
							
							boolean __temp_stmt184 = ( __temp_stmt185 || __temp_boolv186 );
							if (__temp_stmt184) 
							{
								num += _char;
							}
							 else 
							{
								isX =  ! (isX) ;
								double out = haxe.root.Std.parseFloat(num);
								if (isX) 
								{
									if (( out < this.left )) 
									{
										this.left = out;
									}
									
									if (( out > this.right )) 
									{
										this.right = out;
									}
									
								}
								 else 
								{
									if (( out < this.top )) 
									{
										this.top = out;
									}
									
									if (( out > this.bottom )) 
									{
										this.bottom = out;
									}
									
								}
								
								num = "";
								arr.push(out);
								increment++;
							}
							
						}
						
						this.count--;
						java.lang.Object commandData = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{arr, command1}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
						return commandData;
					}
					
					break;
				}
				
				
				case 77:
				{
					if (__temp_svar208.equals("M")) 
					{
						__temp_executeDef209 = false;
						java.lang.String command3 = haxe.lang.Runtime.toString("M");
						this.last = command3;
						java.lang.String num2 = "";
						int increment2 = 0;
						boolean isX2 = true;
						haxe.root.Array<java.lang.Object> arr2 = new haxe.root.Array<java.lang.Object>();
						while (( increment2 < 2 ))
						{
							java.lang.String char2 = haxe.lang.StringExt.charAt(this.str, this.count);
							this.count++;
							boolean __temp_stmt191 = false;
							{
								java.lang.String __temp_svar205 = (char2);
								int __temp_hash207 = __temp_svar205.hashCode();
								boolean __temp_executeDef206 = true;
								switch (__temp_hash207)
								{
									case 57:case 56:case 55:case 54:case 53:case 52:case 51:case 50:case 49:case 48:
									{
										if (( (( ( __temp_hash207 == 57 ) && __temp_svar205.equals("9") )) || ( (( ( __temp_hash207 == 56 ) && __temp_svar205.equals("8") )) || ( (( ( __temp_hash207 == 55 ) && __temp_svar205.equals("7") )) || ( (( ( __temp_hash207 == 54 ) && __temp_svar205.equals("6") )) || ( (( ( __temp_hash207 == 53 ) && __temp_svar205.equals("5") )) || ( (( ( __temp_hash207 == 52 ) && __temp_svar205.equals("4") )) || ( (( ( __temp_hash207 == 51 ) && __temp_svar205.equals("3") )) || ( (( ( __temp_hash207 == 50 ) && __temp_svar205.equals("2") )) || ( (( ( __temp_hash207 == 49 ) && __temp_svar205.equals("1") )) || __temp_svar205.equals("0") ) ) ) ) ) ) ) ) )) 
										{
											__temp_executeDef206 = false;
											__temp_stmt191 = true;
										}
										
										break;
									}
									
									
								}
								
								if (__temp_executeDef206) 
								{
									__temp_stmt191 = false;
								}
								
							}
							
							boolean __temp_boolv192 = false;
							if ( ! (__temp_stmt191) ) 
							{
								__temp_boolv192 = haxe.lang.Runtime.valEq(char2, ".");
							}
							
							boolean __temp_stmt190 = ( __temp_stmt191 || __temp_boolv192 );
							if (__temp_stmt190) 
							{
								num2 += char2;
							}
							 else 
							{
								isX2 =  ! (isX2) ;
								double out2 = haxe.root.Std.parseFloat(num2);
								if (isX2) 
								{
									if (( out2 < this.left )) 
									{
										this.left = out2;
									}
									
									if (( out2 > this.right )) 
									{
										this.right = out2;
									}
									
								}
								 else 
								{
									if (( out2 < this.top )) 
									{
										this.top = out2;
									}
									
									if (( out2 > this.bottom )) 
									{
										this.bottom = out2;
									}
									
								}
								
								num2 = "";
								arr2.push(out2);
								increment2++;
							}
							
						}
						
						this.count--;
						java.lang.Object commandData2 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{arr2, command3}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
						return commandData2;
					}
					
					break;
				}
				
				
				case 81:
				{
					if (__temp_svar208.equals("Q")) 
					{
						__temp_executeDef209 = false;
						java.lang.String command2 = haxe.lang.Runtime.toString("Q");
						this.last = command2;
						java.lang.String num1 = "";
						int increment1 = 0;
						boolean isX1 = true;
						haxe.root.Array<java.lang.Object> arr1 = new haxe.root.Array<java.lang.Object>();
						while (( increment1 < 4 ))
						{
							java.lang.String char1 = haxe.lang.StringExt.charAt(this.str, this.count);
							this.count++;
							boolean __temp_stmt188 = false;
							{
								java.lang.String __temp_svar202 = (char1);
								int __temp_hash204 = __temp_svar202.hashCode();
								boolean __temp_executeDef203 = true;
								switch (__temp_hash204)
								{
									case 57:case 56:case 55:case 54:case 53:case 52:case 51:case 50:case 49:case 48:
									{
										if (( (( ( __temp_hash204 == 57 ) && __temp_svar202.equals("9") )) || ( (( ( __temp_hash204 == 56 ) && __temp_svar202.equals("8") )) || ( (( ( __temp_hash204 == 55 ) && __temp_svar202.equals("7") )) || ( (( ( __temp_hash204 == 54 ) && __temp_svar202.equals("6") )) || ( (( ( __temp_hash204 == 53 ) && __temp_svar202.equals("5") )) || ( (( ( __temp_hash204 == 52 ) && __temp_svar202.equals("4") )) || ( (( ( __temp_hash204 == 51 ) && __temp_svar202.equals("3") )) || ( (( ( __temp_hash204 == 50 ) && __temp_svar202.equals("2") )) || ( (( ( __temp_hash204 == 49 ) && __temp_svar202.equals("1") )) || __temp_svar202.equals("0") ) ) ) ) ) ) ) ) )) 
										{
											__temp_executeDef203 = false;
											__temp_stmt188 = true;
										}
										
										break;
									}
									
									
								}
								
								if (__temp_executeDef203) 
								{
									__temp_stmt188 = false;
								}
								
							}
							
							boolean __temp_boolv189 = false;
							if ( ! (__temp_stmt188) ) 
							{
								__temp_boolv189 = haxe.lang.Runtime.valEq(char1, ".");
							}
							
							boolean __temp_stmt187 = ( __temp_stmt188 || __temp_boolv189 );
							if (__temp_stmt187) 
							{
								num1 += char1;
							}
							 else 
							{
								isX1 =  ! (isX1) ;
								double out1 = haxe.root.Std.parseFloat(num1);
								if (isX1) 
								{
									if (( out1 < this.left )) 
									{
										this.left = out1;
									}
									
									if (( out1 > this.right )) 
									{
										this.right = out1;
									}
									
								}
								 else 
								{
									if (( out1 < this.top )) 
									{
										this.top = out1;
									}
									
									if (( out1 > this.bottom )) 
									{
										this.bottom = out1;
									}
									
								}
								
								num1 = "";
								arr1.push(out1);
								increment1++;
							}
							
						}
						
						this.count--;
						java.lang.Object commandData1 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{arr1, command2}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
						return commandData1;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef209) 
			{
				java.lang.String command3 = haxe.lang.Runtime.toString("M");
				this.last = command3;
				java.lang.String num2 = "";
				int increment2 = 0;
				boolean isX2 = true;
				haxe.root.Array<java.lang.Object> arr2 = new haxe.root.Array<java.lang.Object>();
				while (( increment2 < 2 ))
				{
					java.lang.String char2 = haxe.lang.StringExt.charAt(this.str, this.count);
					this.count++;
					boolean __temp_stmt182 = false;
					{
						java.lang.String __temp_svar196 = (char2);
						int __temp_hash198 = __temp_svar196.hashCode();
						boolean __temp_executeDef197 = true;
						switch (__temp_hash198)
						{
							case 57:case 56:case 55:case 54:case 53:case 52:case 51:case 50:case 49:case 48:
							{
								if (( (( ( __temp_hash198 == 57 ) && __temp_svar196.equals("9") )) || ( (( ( __temp_hash198 == 56 ) && __temp_svar196.equals("8") )) || ( (( ( __temp_hash198 == 55 ) && __temp_svar196.equals("7") )) || ( (( ( __temp_hash198 == 54 ) && __temp_svar196.equals("6") )) || ( (( ( __temp_hash198 == 53 ) && __temp_svar196.equals("5") )) || ( (( ( __temp_hash198 == 52 ) && __temp_svar196.equals("4") )) || ( (( ( __temp_hash198 == 51 ) && __temp_svar196.equals("3") )) || ( (( ( __temp_hash198 == 50 ) && __temp_svar196.equals("2") )) || ( (( ( __temp_hash198 == 49 ) && __temp_svar196.equals("1") )) || __temp_svar196.equals("0") ) ) ) ) ) ) ) ) )) 
								{
									__temp_executeDef197 = false;
									__temp_stmt182 = true;
								}
								
								break;
							}
							
							
						}
						
						if (__temp_executeDef197) 
						{
							__temp_stmt182 = false;
						}
						
					}
					
					boolean __temp_boolv183 = false;
					if ( ! (__temp_stmt182) ) 
					{
						__temp_boolv183 = haxe.lang.Runtime.valEq(char2, ".");
					}
					
					boolean __temp_stmt181 = ( __temp_stmt182 || __temp_boolv183 );
					if (__temp_stmt181) 
					{
						num2 += char2;
					}
					 else 
					{
						isX2 =  ! (isX2) ;
						double out2 = haxe.root.Std.parseFloat(num2);
						if (isX2) 
						{
							if (( out2 < this.left )) 
							{
								this.left = out2;
							}
							
							if (( out2 > this.right )) 
							{
								this.right = out2;
							}
							
						}
						 else 
						{
							if (( out2 < this.top )) 
							{
								this.top = out2;
							}
							
							if (( out2 > this.bottom )) 
							{
								this.bottom = out2;
							}
							
						}
						
						num2 = "";
						arr2.push(out2);
						increment2++;
					}
					
				}
				
				this.count--;
				java.lang.Object commandData2 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{arr2, command3}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
				return commandData2;
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	public final   java.lang.Object createCommandData(int len, java.lang.String command)
	{
		this.last = command;
		java.lang.String num = "";
		int increment = 0;
		boolean isX = true;
		haxe.root.Array<java.lang.Object> arr = new haxe.root.Array<java.lang.Object>();
		while (( increment < len ))
		{
			java.lang.String _char = haxe.lang.StringExt.charAt(this.str, this.count);
			this.count++;
			boolean __temp_stmt211 = false;
			{
				java.lang.String __temp_svar213 = (_char);
				int __temp_hash215 = __temp_svar213.hashCode();
				boolean __temp_executeDef214 = true;
				switch (__temp_hash215)
				{
					case 57:case 56:case 55:case 54:case 53:case 52:case 51:case 50:case 49:case 48:
					{
						if (( (( ( __temp_hash215 == 57 ) && __temp_svar213.equals("9") )) || ( (( ( __temp_hash215 == 56 ) && __temp_svar213.equals("8") )) || ( (( ( __temp_hash215 == 55 ) && __temp_svar213.equals("7") )) || ( (( ( __temp_hash215 == 54 ) && __temp_svar213.equals("6") )) || ( (( ( __temp_hash215 == 53 ) && __temp_svar213.equals("5") )) || ( (( ( __temp_hash215 == 52 ) && __temp_svar213.equals("4") )) || ( (( ( __temp_hash215 == 51 ) && __temp_svar213.equals("3") )) || ( (( ( __temp_hash215 == 50 ) && __temp_svar213.equals("2") )) || ( (( ( __temp_hash215 == 49 ) && __temp_svar213.equals("1") )) || __temp_svar213.equals("0") ) ) ) ) ) ) ) ) )) 
						{
							__temp_executeDef214 = false;
							__temp_stmt211 = true;
						}
						
						break;
					}
					
					
				}
				
				if (__temp_executeDef214) 
				{
					__temp_stmt211 = false;
				}
				
			}
			
			boolean __temp_boolv212 = false;
			if ( ! (__temp_stmt211) ) 
			{
				__temp_boolv212 = haxe.lang.Runtime.valEq(_char, ".");
			}
			
			boolean __temp_stmt210 = ( __temp_stmt211 || __temp_boolv212 );
			if (__temp_stmt210) 
			{
				num += _char;
			}
			 else 
			{
				isX =  ! (isX) ;
				double out = haxe.root.Std.parseFloat(num);
				if (isX) 
				{
					if (( out < this.left )) 
					{
						this.left = out;
					}
					
					if (( out > this.right )) 
					{
						this.right = out;
					}
					
				}
				 else 
				{
					if (( out < this.top )) 
					{
						this.top = out;
					}
					
					if (( out > this.bottom )) 
					{
						this.bottom = out;
					}
					
				}
				
				num = "";
				arr.push(out);
				increment++;
			}
			
		}
		
		this.count--;
		java.lang.Object commandData = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{arr, command}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
		return commandData;
	}
	
	
	public   java.lang.Object getCentre()
	{
		if ( ! (this.hasIterated) ) 
		{
			haxe.root.Array<java.lang.Object> a = new haxe.root.Array<java.lang.Object>();
			{
				java.lang.Object __temp_iterator34 = this.iterator();
				while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator34, "hasNext", null)))
				{
					java.lang.Object x = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator34, "next", null)) );
					a.push(x);
				}
				
			}
			
			haxe.root.Array<java.lang.Object> __temp_expr216 = a;
		}
		
		return new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( this.left + ( (( this.right - this.left )) / 2 ) )) ), ((java.lang.Object) (( this.top + ( (( this.bottom - this.top )) / 2 ) )) )}));
	}
	
	
	@Override public   double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		{
			boolean __temp_executeDef217 = true;
			switch (field.hashCode())
			{
				case -1383228885:
				{
					if (field.equals("bottom")) 
					{
						__temp_executeDef217 = false;
						this.bottom = ((double) (value) );
						return value;
					}
					
					break;
				}
				
				
				case -1106363674:
				{
					if (field.equals("length")) 
					{
						__temp_executeDef217 = false;
						this.length = ((int) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 108511772:
				{
					if (field.equals("right")) 
					{
						__temp_executeDef217 = false;
						this.right = ((double) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 94851343:
				{
					if (field.equals("count")) 
					{
						__temp_executeDef217 = false;
						this.count = ((int) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 115029:
				{
					if (field.equals("top")) 
					{
						__temp_executeDef217 = false;
						this.top = ((double) (value) );
						return value;
					}
					
					break;
				}
				
				
				case 3317767:
				{
					if (field.equals("left")) 
					{
						__temp_executeDef217 = false;
						this.left = ((double) (value) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef217) 
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
			boolean __temp_executeDef218 = true;
			switch (field.hashCode())
			{
				case -237976604:
				{
					if (field.equals("hasIterated")) 
					{
						__temp_executeDef218 = false;
						this.hasIterated = haxe.lang.Runtime.toBool(value);
						return value;
					}
					
					break;
				}
				
				
				case -1106363674:
				{
					if (field.equals("length")) 
					{
						__temp_executeDef218 = false;
						this.length = ((int) (haxe.lang.Runtime.toInt(value)) );
						return value;
					}
					
					break;
				}
				
				
				case -1383228885:
				{
					if (field.equals("bottom")) 
					{
						__temp_executeDef218 = false;
						this.bottom = ((double) (haxe.lang.Runtime.toDouble(value)) );
						return value;
					}
					
					break;
				}
				
				
				case 94851343:
				{
					if (field.equals("count")) 
					{
						__temp_executeDef218 = false;
						this.count = ((int) (haxe.lang.Runtime.toInt(value)) );
						return value;
					}
					
					break;
				}
				
				
				case 108511772:
				{
					if (field.equals("right")) 
					{
						__temp_executeDef218 = false;
						this.right = ((double) (haxe.lang.Runtime.toDouble(value)) );
						return value;
					}
					
					break;
				}
				
				
				case 114225:
				{
					if (field.equals("str")) 
					{
						__temp_executeDef218 = false;
						this.str = haxe.lang.Runtime.toString(value);
						return value;
					}
					
					break;
				}
				
				
				case 115029:
				{
					if (field.equals("top")) 
					{
						__temp_executeDef218 = false;
						this.top = ((double) (haxe.lang.Runtime.toDouble(value)) );
						return value;
					}
					
					break;
				}
				
				
				case 3314326:
				{
					if (field.equals("last")) 
					{
						__temp_executeDef218 = false;
						this.last = haxe.lang.Runtime.toString(value);
						return value;
					}
					
					break;
				}
				
				
				case 3317767:
				{
					if (field.equals("left")) 
					{
						__temp_executeDef218 = false;
						this.left = ((double) (haxe.lang.Runtime.toDouble(value)) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef218) 
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
			boolean __temp_executeDef219 = true;
			switch (field.hashCode())
			{
				case 332001489:
				{
					if (field.equals("getCentre")) 
					{
						__temp_executeDef219 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("getCentre"))) );
					}
					
					break;
				}
				
				
				case -1106363674:
				{
					if (field.equals("length")) 
					{
						__temp_executeDef219 = false;
						return this.length;
					}
					
					break;
				}
				
				
				case -704743687:
				{
					if (field.equals("createCommandData")) 
					{
						__temp_executeDef219 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("createCommandData"))) );
					}
					
					break;
				}
				
				
				case 94851343:
				{
					if (field.equals("count")) 
					{
						__temp_executeDef219 = false;
						return this.count;
					}
					
					break;
				}
				
				
				case 3377907:
				{
					if (field.equals("next")) 
					{
						__temp_executeDef219 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("next"))) );
					}
					
					break;
				}
				
				
				case 114225:
				{
					if (field.equals("str")) 
					{
						__temp_executeDef219 = false;
						return this.str;
					}
					
					break;
				}
				
				
				case 696759469:
				{
					if (field.equals("hasNext")) 
					{
						__temp_executeDef219 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("hasNext"))) );
					}
					
					break;
				}
				
				
				case 3314326:
				{
					if (field.equals("last")) 
					{
						__temp_executeDef219 = false;
						return this.last;
					}
					
					break;
				}
				
				
				case 1182533742:
				{
					if (field.equals("iterator")) 
					{
						__temp_executeDef219 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("iterator"))) );
					}
					
					break;
				}
				
				
				case 3317767:
				{
					if (field.equals("left")) 
					{
						__temp_executeDef219 = false;
						return this.left;
					}
					
					break;
				}
				
				
				case -237976604:
				{
					if (field.equals("hasIterated")) 
					{
						__temp_executeDef219 = false;
						return this.hasIterated;
					}
					
					break;
				}
				
				
				case 115029:
				{
					if (field.equals("top")) 
					{
						__temp_executeDef219 = false;
						return this.top;
					}
					
					break;
				}
				
				
				case -1383228885:
				{
					if (field.equals("bottom")) 
					{
						__temp_executeDef219 = false;
						return this.bottom;
					}
					
					break;
				}
				
				
				case 108511772:
				{
					if (field.equals("right")) 
					{
						__temp_executeDef219 = false;
						return this.right;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef219) 
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
			boolean __temp_executeDef220 = true;
			switch (field.hashCode())
			{
				case -1383228885:
				{
					if (field.equals("bottom")) 
					{
						__temp_executeDef220 = false;
						return this.bottom;
					}
					
					break;
				}
				
				
				case -1106363674:
				{
					if (field.equals("length")) 
					{
						__temp_executeDef220 = false;
						return ((double) (this.length) );
					}
					
					break;
				}
				
				
				case 108511772:
				{
					if (field.equals("right")) 
					{
						__temp_executeDef220 = false;
						return this.right;
					}
					
					break;
				}
				
				
				case 94851343:
				{
					if (field.equals("count")) 
					{
						__temp_executeDef220 = false;
						return ((double) (this.count) );
					}
					
					break;
				}
				
				
				case 115029:
				{
					if (field.equals("top")) 
					{
						__temp_executeDef220 = false;
						return this.top;
					}
					
					break;
				}
				
				
				case 3317767:
				{
					if (field.equals("left")) 
					{
						__temp_executeDef220 = false;
						return this.left;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef220) 
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
			boolean __temp_executeDef221 = true;
			switch (field.hashCode())
			{
				case 332001489:
				{
					if (field.equals("getCentre")) 
					{
						__temp_executeDef221 = false;
						return this.getCentre();
					}
					
					break;
				}
				
				
				case 1182533742:
				{
					if (field.equals("iterator")) 
					{
						__temp_executeDef221 = false;
						return this.iterator();
					}
					
					break;
				}
				
				
				case -704743687:
				{
					if (field.equals("createCommandData")) 
					{
						__temp_executeDef221 = false;
						return this.createCommandData(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ), haxe.lang.Runtime.toString(dynargs.__get(1)));
					}
					
					break;
				}
				
				
				case 696759469:
				{
					if (field.equals("hasNext")) 
					{
						__temp_executeDef221 = false;
						return this.hasNext();
					}
					
					break;
				}
				
				
				case 3377907:
				{
					if (field.equals("next")) 
					{
						__temp_executeDef221 = false;
						return this.next();
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef221) 
			{
				return super.__hx_invokeField(field, dynargs);
			}
			 else 
			{
				throw null;
			}
			
		}
		
	}
	
	
	@Override public   void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		baseArr.push("hasIterated");
		baseArr.push("bottom");
		baseArr.push("right");
		baseArr.push("top");
		baseArr.push("left");
		baseArr.push("last");
		baseArr.push("str");
		baseArr.push("count");
		baseArr.push("length");
		{
			super.__hx_getFields(baseArr);
		}
		
	}
	
	
}



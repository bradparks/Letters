package letters;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class ExampleLetters extends letters.targetJava.BasicJava
{
	public static void main(String[] args)
	{
		main();
	}
	public    ExampleLetters(haxe.lang.EmptyObject empty)
	{
		super(haxe.lang.EmptyObject.EMPTY);
	}
	
	
	public    ExampleLetters()
	{
		super();
		this.letterResource = new letters.LetterResource();
		haxe.root.Array<java.lang.Object> path = null;
		{
			double y = 50.;
			java.lang.Object width = 300.;
			java.lang.Object lineSpace = 22.;
			haxe.root.Array<java.lang.Object> path1 = null;
			haxe.lang.Function highlightFunction = ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (letters.Path.class) ), haxe.lang.Runtime.toString("rainbowPencilHighlight"))) );
			if (( path1 == null )) 
			{
				path1 = new haxe.root.Array<java.lang.Object>();
			}
			
			if (( width == null )) 
			{
				width = 1000000;
				lineSpace = 0;
			}
			
			haxe.root.Array<java.lang.Object> temp = null;
			double x1 = 100.;
			double x2 = 100.;
			double dx = 0.;
			double y1 = y;
			java.lang.Object tempDim = null;
			haxe.root.Array<java.lang.Object> word = new haxe.root.Array<java.lang.Object>();
			double lastLetterX1 = ((double) (0) );
			letters.LetterResource letterResource = new letters.LetterResource();
			haxe.root.Array<java.lang.String> arrStr = haxe.lang.StringExt.split("hi my name is justin and i live in bath a small city in the south west of the uk", "");
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
					path1.push(fillColor);
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
							java.lang.String __temp_svar128 = (i);
							boolean __temp_executeDef129 = true;
							switch (__temp_svar128.hashCode())
							{
								case 103:
								{
									if (__temp_svar128.equals("g")) 
									{
										__temp_executeDef129 = false;
										vert = -1.9;
									}
									
									break;
								}
								
								
								case 109:
								{
									if (__temp_svar128.equals("m")) 
									{
										__temp_executeDef129 = false;
										vert = -0.5;
									}
									
									break;
								}
								
								
							}
							
							if (__temp_executeDef129) 
							{
								vert = 0.;
							}
							
						}
						
						double preX = 0.0;
						{
							java.lang.String __temp_svar130 = (i);
							int __temp_hash132 = __temp_svar130.hashCode();
							boolean __temp_executeDef131 = true;
							switch (__temp_hash132)
							{
								case 115:case 105:
								{
									if (( (( ( __temp_hash132 == 115 ) && __temp_svar130.equals("s") )) || __temp_svar130.equals("i") )) 
									{
										__temp_executeDef131 = false;
										preX = 2.;
									}
									
									break;
								}
								
								
								case 114:
								{
									if (__temp_svar130.equals("r")) 
									{
										__temp_executeDef131 = false;
										preX = 1.;
									}
									
									break;
								}
								
								
							}
							
							if (__temp_executeDef131) 
							{
								preX = 0.;
							}
							
						}
						
						if (( vert != 0 )) 
						{
							y1 += ( vert * .7 );
						}
						
						if (( preX != 0 )) 
						{
							x1 += ( preX * .7 );
						}
						
						{
							java.lang.Object path2 = null;
							if (letterResource.letters.exists(i)) 
							{
								path2 = letterResource.letters.get(i);
							}
							 else 
							{
								java.lang.String aLetter = null;
								{
									java.lang.String __temp_svar133 = (i);
									boolean __temp_executeDef134 = true;
									switch (__temp_svar133.hashCode())
									{
										case 97:
										{
											if (__temp_svar133.equals("a")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M23.5 18.1 Q19.9 16.6 18.2 19.3 16.45 21.95 14.85 21.5 13.85 21.25 13.55 20.6 L13.35 20 Q13.25 19.45 13.4 18.95 13.65 17.75 15.15 16.6 L16.9 15.8 19.2 15.15 20.95 14.9 22.95 14.9 26.45 15.25 Q27.65 15.55 28.4 16.15 31.1 17.95 31.15 21.55 L31.8 38.3 Q31.95 39.3 31.5 39.55 L29.6 39.9 Q28.2 39.95 26.75 39.2 L26.5 37.7 22.25 39.7 Q20.3 40.4 17.8 40.4 13.2 39.85 12.1 35.75 11.25 33.5 12.55 30.65 13.1 28.9 15.35 27.55 18.45 25.25 24.25 24.65 25.3 24.7 25.95 24.25 26.65 23.7 26.35 21.45 26 19.15 23.5 18.1 M22.4 36.95 Q24.8 36.65 26.4 34.7 L26.7 27.05 24.35 27.25 Q19.75 28.1 18.3 29.6 16.85 31.05 16.95 33.25 17.05 35.4 18.5 36.35 19.95 37.25 22.4 36.95";
											}
											
											break;
										}
										
										
										case 122:
										{
											if (__temp_svar133.equals("z")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M10.4 16.7 Q9.9 16.3 10.15 15.95 L10.55 15.65 11.7 15.5 14.9 15.3 Q29.15 15 30.85 15.5 32.15 16.05 31.55 17 L17.4 36.25 27.6 36.7 Q31.2 36.8 32.6 38.1 33.25 39 30.95 39.45 L20.1 39.8 12.95 39.7 Q8.5 39.8 10.1 38.05 L24.65 19 Q22.3 18.1 14.6 17.75 11.55 17.45 10.4 16.7";
											}
											
											break;
										}
										
										
										case 98:
										{
											if (__temp_svar133.equals("b")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M25.45 15.5 Q29.5 16.4 31.8 21.2 32.9 23.45 33.05 26.15 33.2 29 32.3 31.45 31.4 33.85 30.35 35.15 L28.55 37.2 26.6 38.5 26.3 38.7 25.6 39 23.7 39.65 22.5 39.8 19.1 39.95 18 39.85 16.3 39.7 14.5 39.5 Q12.35 39 11.5 37.7 10.55 36.2 10.55 34.1 L10.95 7.3 11 4.9 11.5 4.5 Q12.15 3.85 12.8 3.7 14.15 2.95 15.3 3.7 L16.2 17.7 Q21.45 14.6 25.45 15.5 M16.2 21.3 L15.75 23.15 15.5 25.4 15.5 31.5 Q15.5 33.85 16.35 35.4 17.6 37.1 20.8 37.3 27.4 37.05 27.5 27.2 27.6 17.35 19.7 18.7 17.65 18.9 16.2 21.3";
											}
											
											break;
										}
										
										
										case 121:
										{
											if (__temp_svar133.equals("y")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M10.7 18 L14.8 17.95 Q16.15 19.8 17.95 25.35 19 28.2 21.45 33.45 21.85 34.3 22.7 34.1 23.6 33.85 24.75 31.05 L26.45 26.8 27.9 22.4 29.3 18.1 Q29.55 17.25 30.65 17.3 32.45 17.45 32.6 18.55 L30.2 26.7 28 34.05 Q26.65 38.35 25.35 41.25 23.2 46 20.1 49.35 16.8 52.45 14.65 52.8 10.05 53.2 10.05 51.1 10.1 50.4 10.5 49.95 10.9 49.45 11.9 49.15 13.4 48.65 14.9 49.15 16.6 49.2 19.7 44.95 20.75 43.3 21.1 41.6 L21 40.9 Q14 29.35 10.05 19.6 9.7 19.1 9.9 18.6 L10.7 18";
											}
											
											break;
										}
										
										
										case 99:
										{
											if (__temp_svar133.equals("c")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M29.7 21.65 L29.5 21.6 28.7 21.35 26.7 19.3 Q25.4 17.9 22.5 17.9 19.65 17.9 17.75 20.8 16.2 23.2 16.2 25.7 16.2 30.55 18.65 33.5 20.7 35.95 22.95 35.95 29.75 35.95 32.05 32.3 L32.2 32.5 32.25 33.2 Q32.25 35.65 29.6 37.7 26.7 39.95 22.35 39.95 16.85 39.95 13.85 36 11.35 32.75 11.35 28.3 11.35 22.05 15.35 18.15 18.75 14.85 22.8 14.85 27.45 14.85 29.8 16.8 31.45 18.15 31.45 19.65 31.45 21.4 29.7 21.65";
											}
											
											break;
										}
										
										
										case 120:
										{
											if (__temp_svar133.equals("x")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M21.4 23.3 L26.25 17.1 Q27.25 15.85 28.25 15.55 30.25 15.65 30.55 16.3 L23.75 25.75 Q23.35 26.25 24.15 27.6 L31.75 38.5 Q32.75 39.75 30.7 39.8 28.1 40.1 26.25 38.25 L20.05 30.15 13.45 39.1 Q11.05 40.2 9.75 39.85 9.25 39.35 9.85 38.65 L17.95 27.45 10.5 16.3 Q10.4 15.8 11 15.75 L13.2 15.6 Q15 15.6 16.2 16.4 L21.4 23.3";
											}
											
											break;
										}
										
										
										case 100:
										{
											if (__temp_svar133.equals("d")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M27.3 15.55 L27.85 8.3 Q27.95 4.1 30.7 3.7 32.55 2.8 32.75 5.1 L32.7 32.95 33.05 35.95 Q33.45 36.5 32.65 39.15 30.55 40.75 27.75 37.8 17.6 42.7 12.7 35.85 7.25 25.3 14.8 18.35 18.85 14.15 27.3 15.55 M15.95 23.95 Q14.75 27.9 17.05 34.1 19.45 37.95 24.4 36.7 26.35 35.75 27.25 34.8 L27.3 31.65 Q28.05 23.2 26.75 20.15 23.9 16.55 20.15 17.85 17.85 18.85 15.95 23.95";
											}
											
											break;
										}
										
										
										case 119:
										{
											if (__temp_svar133.equals("w")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M3.8 16.65 Q5.55 15.5 6.9 16.85 8.8 18.8 9.7 21.4 L13.4 31.65 Q14.8 35.75 15.9 31.75 L19.85 19.6 Q20.65 17.65 22.25 17.6 23.6 18.05 24 19.3 L28.35 32.15 Q28.8 33.1 29.65 32.5 32.6 26.55 34.4 20.8 34.85 19.25 35.65 18.25 36.6 17.2 37.55 16.9 L37.65 16.9 Q38.15 16.85 38 17.8 L36.95 20.8 31.65 37.5 Q30 42.1 27.35 38.75 L27.3 38.7 Q25.05 35.45 24.1 32.6 L21.1 26.45 Q18.45 32.7 15.25 38.65 12.75 41.6 11.25 38.55 L3.65 18.55 Q3.35 17.6 3.8 16.65";
											}
											
											break;
										}
										
										
										case 101:
										{
											if (__temp_svar133.equals("e")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M31 19 Q32.1 21.45 32.65 23.75 31.35 25.2 25.5 26.55 L16.55 27.45 16.4 27.8 Q17.1 32.45 17.75 33.4 19.35 35.7 23.5 35.65 27.7 35.55 32.2 33 L32.3 33.05 32.3 33.1 Q32.7 34.6 31 36.3 29.65 37.65 27.3 38.75 23.85 40.3 20.6 40.05 17.2 39.75 15.05 37.85 13.3 36.35 11.75 33.1 10.55 28.6 11.1 25.1 11.65 21.7 13.9 18.65 15.85 16.6 18.7 15.5 21.85 13.8 26.4 15.05 29.5 16 31 19 M24.5 17.9 Q20.75 16 18.2 18.3 15.65 20.6 15.8 22.2 L15.8 24.25 18.35 24.6 24.6 23.95 Q26.55 23.65 27.4 22.6 27.85 20.45 24.5 17.9";
											}
											
											break;
										}
										
										
										case 118:
										{
											if (__temp_svar133.equals("v")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M15.35 18.4 L16.8 22.4 21.1 33.25 21.4 33.75 21.75 33.6 Q25.25 26.85 28.15 18.25 29.25 15.8 30.4 15.8 L31.15 15.75 Q32.1 15.85 32.15 16.35 L29.9 22.6 24.85 35 Q22.8 39.45 22.1 39.75 L21.5 40 Q20 40.4 18.3 37.8 L16.85 34.85 9.8 17.5 Q9.25 16.65 9.55 16.15 9.85 15.6 10.65 15.65 13.25 15.75 13.95 16.25 14.8 16.9 15.35 18.4";
											}
											
											break;
										}
										
										
										case 102:
										{
											if (__temp_svar133.equals("f")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M28 3.25 Q29.8 3.55 30.65 4.95 31.15 5.9 31.05 6.5 31.2 7.35 29.9 8.1 29.1 8.2 28.4 7.65 L27.9 7.2 27.45 6.7 26.35 6.2 25.95 6.15 Q25.2 6 24.4 6.45 21.25 7.95 21.7 12.05 21.5 15.1 24.7 15.2 L25.5 15.3 27.15 15.65 Q28.75 16.8 27.3 17.95 L25.5 18.15 24.8 18.3 Q21.9 18.3 22.1 22 L21.45 37.5 Q21.85 40.4 18.85 40.35 16.55 40.85 16.65 36.85 L16.65 24.4 16.15 18.9 Q15.3 17.9 14.55 17.85 10.7 16.75 14.5 15.65 16.15 15.1 16.35 13.85 L18.3 7.9 Q19.75 4.8 22.1 3.7 24.4 2.65 28 3.25";
											}
											
											break;
										}
										
										
										case 117:
										{
											if (__temp_svar133.equals("u")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M12.65 15.55 Q13.65 15.65 14.3 16.15 14.95 16.65 15 17.45 L15.15 20.1 Q15.1 26.75 15.5 33.45 15.75 35.1 17.65 36.2 21.75 37.25 24.15 34.9 26 33.15 26.05 28.85 L26.3 21.5 Q26.25 17.1 27.25 16.4 27.9 15.95 28.65 15.95 L30.1 16.35 Q30.85 16.8 30.9 19.75 L31 23.4 31.05 25.35 31.2 34.7 31.2 34.95 31.1 38 30.95 38.45 Q29.4 40.5 26.65 38.5 L25.7 36.95 Q18.45 41.65 14 38.75 10.15 36.65 10.35 27.65 10.3 22.3 10.65 17.1 10.85 15.5 12.65 15.55";
											}
											
											break;
										}
										
										
										case 103:
										{
											if (__temp_svar133.equals("g")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M21.95 21.85 Q19.05 22.2 17.3 24.7 15.2 29.25 17.2 33.95 18.45 36.9 21.35 37.35 25.75 36.9 26.9 33.4 27.85 29.85 26.75 25.3 25.35 21.4 21.95 21.85 M11.75 47.95 Q11.65 46.3 12.9 46.1 L14.15 46.35 17.05 47.7 Q28.65 50 26.75 38.95 19.05 41.35 15.3 37.45 11.9 35.25 11.35 29.25 12.15 24.55 14.85 21.95 20.25 16.65 28.35 20.3 31.15 21.7 32.3 29.2 L31.95 44 Q30.3 53.2 19.8 52.6 15.1 51.8 13.2 50.4 12.1 49.75 11.9 48.95 L11.75 47.95";
											}
											
											break;
										}
										
										
										case 116:
										{
											if (__temp_svar133.equals("t")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M14.05 15.8 Q15.95 15.4 17.5 13.75 18.6 12.35 18.85 9.95 19.25 8 20 7.4 20.7 6.8 21.3 7.05 21.85 7.3 22 8 L22.2 9.65 Q22.15 11.3 22.35 12.8 22.35 13.9 23.45 14.6 L26.35 15.15 Q27.3 15.15 27.5 15.8 27.9 16.9 26.9 17.45 L23.85 17.9 Q21.85 17.85 21.95 25.45 L21.95 30.55 Q22.55 37.65 26.85 35.9 28.45 35.75 27.7 37.6 27.15 38.85 25.4 39.4 16.95 41.75 17 29.5 L17.15 24.7 17.15 24.5 Q16.95 17.65 14.35 17.05 13.1 16.5 14.05 15.8";
											}
											
											break;
										}
										
										
										case 104:
										{
											if (__temp_svar133.equals("h")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M26.95 16.4 Q31.5 18.35 31.55 23.1 L31.95 35.2 Q32.05 37.35 31.6 39.45 L31.45 39.95 Q30.95 40.65 30.1 40.65 L29.4 40.55 Q28 40.15 27.7 38.45 L27.55 37.7 27.3 35 27.15 24.55 Q26.35 18.15 21.25 20.05 18.8 20.95 17.95 22.1 16.95 23.45 16.9 26.3 L16.05 37.45 Q16.1 38.75 15.45 39.65 14.8 40.55 13.9 40.55 13 40.55 12.35 39.65 11.7 38.75 11.7 37.45 L11.7 36 12.1 7.05 Q12.2 4.6 14.1 4.5 16.9 3.8 16.85 6.9 L17.05 18.9 19.4 17.7 21.95 16.8 Q24.2 15.95 26.95 16.4";
											}
											
											break;
										}
										
										
										case 115:
										{
											if (__temp_svar133.equals("s")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M17.2 15.05 Q20.05 14.3 22.55 14.95 L25.75 15.8 27.5 16.75 Q28.5 17.6 28.5 18.3 28.45 18.95 28.05 19.4 27.65 19.85 27 19.8 26.3 19.75 25.4 19.2 L23.7 18.3 21.8 17.7 Q18.95 16.85 17.45 18.15 15.9 19.45 16.35 20.95 16.8 22.45 17.7 22.95 21.45 25.35 25.2 26.45 27.45 27.4 28.6 29 30.45 32.75 29.4 35.25 28.3 37.7 25.7 39 22.5 40.25 18.85 40.1 15.75 39.5 14 38.4 12.25 37.25 11.9 36.4 11.6 35.55 12.25 34.75 12.95 34.15 13.45 34.4 L17.85 36.95 Q22.75 38.8 24.7 34.6 25.05 33.65 24.6 32.7 24.05 31.55 22.25 30.45 L17.05 27.85 Q13.1 26.05 12.15 23.15 11.75 19.75 13.25 17.45 L14.2 16.5 Q15.4 15.5 17.2 15.05";
											}
											
											break;
										}
										
										
										case 105:
										{
											if (__temp_svar133.equals("i")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M23.6 6.7 Q23.35 8.3 22.6 8.85 20.6 9.6 19.25 8.85 L18.7 8.35 Q18.2 7.85 18.05 6.85 18.25 5.75 19 4.95 20.15 4.35 21.3 4.45 L21.5 4.5 21.85 4.55 Q22.75 4.65 23.25 5.45 23.65 5.9 23.6 6.7 M20.45 15.7 L21.9 15.55 22.3 15.65 22.7 15.75 23.55 36.05 Q24.05 40.1 20.2 40.1 19.05 40.1 18.7 39.2 18.45 38.45 18.4 36.05 L18.4 31.4 18.35 29.45 18.35 20.8 18.3 18.4 Q18.25 17.1 18.35 16.55 L18.8 16.15 Q19.45 15.85 20.25 15.7 L20.45 15.7";
											}
											
											break;
										}
										
										
										case 114:
										{
											if (__temp_svar133.equals("r")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M13.25 17.05 Q13.85 15.65 15.4 15.8 16.65 15.65 17.75 16.7 L18.95 18.5 22 16.15 Q23.35 15.45 24.7 15.4 L24.95 15.4 Q26.35 15.55 27.15 16.15 29.55 18.05 27.3 19.8 L26.85 20.05 Q25.8 20.35 24.75 20.05 21.3 18.65 18.75 23.5 L18.45 37 Q17.7 40.25 15 39.9 13.45 39.85 13.4 38.55 L13.25 36.65 13.25 17.05";
											}
											
											break;
										}
										
										
										case 106:
										{
											if (__temp_svar133.equals("j")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M25.35 9.4 L24.8 9.35 23.95 9.25 Q23.3 9.1 23 8.8 L22.6 8.3 Q21.8 7.3 22 6.3 22.2 5.2 22.55 4.9 L23.2 4.35 Q26.8 2.9 27.45 6.25 27.75 7.3 27.1 8.2 L26.1 9.1 25.65 9.3 25.35 9.4 M21.9 15.55 L22.4 14.95 23.5 14.65 24.5 14.6 Q25.6 14.45 26.4 14.9 27.25 15 27.05 17.95 27.35 32.55 27 42 26.75 52.05 18.85 51.75 16.75 51.6 15.5 50.8 14.45 50.5 14.15 49.4 13.45 46.95 17.15 47.85 L19.15 48.5 19.8 48.45 20.6 47.95 Q21.55 47 21.95 43.8 L21.8 31.05 21.9 15.55";
											}
											
											break;
										}
										
										
										case 113:
										{
											if (__temp_svar133.equals("q")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M19 17.85 Q17.9 18.4 16.5 19.85 15.1 21.25 14.65 25.25 14.1 36.15 21.3 36.35 24.8 36.15 26.6 33.35 L26.75 22.3 Q26.8 19.5 25.05 18.4 23.8 17.35 22 17.3 20.1 17.25 19 17.85 M13.15 18.3 Q15.75 15.7 18.75 14.95 22.5 14 26.85 16 L29.65 15.55 Q30.85 15.3 31.7 16.95 L31.85 49.55 30.25 49.95 30.05 49.95 28.6 49.7 Q27.35 49.1 27.25 48.2 L26.5 37.4 Q25.1 38.65 22.5 39.5 L20.6 39.7 Q16.2 39.75 14.45 38.2 9.4 35 9.85 26.3 10.05 22.2 13.15 18.3";
											}
											
											break;
										}
										
										
										case 107:
										{
											if (__temp_svar133.equals("k")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M13.8 3.75 L14.5 3.95 Q14.95 3.85 15.3 5.65 L15.55 9.05 15.6 18.85 Q15.6 21.4 16.1 24.45 L24.45 17.6 Q27.05 15.9 28.3 16 29.3 16.05 28.75 16.8 L21.85 24.7 Q21.5 25.3 23.45 27.95 L30.7 37.8 Q32 39.5 30.25 39.7 28.45 40.35 25.4 37.9 22.25 35.05 19.65 30.75 18.1 29.15 16.75 28.55 16.1 28.3 16.05 29.1 15.6 30.75 15.55 35.5 15.35 37.95 14.8 39.1 13.9 39.85 12.65 39.8 11.7 39.6 11 39.05 10.7 38.05 10.55 36.85 10.05 21.2 10.95 5.55 10.9 4.65 12.1 4.25 12.95 3.85 13.8 3.75";
											}
											
											break;
										}
										
										
										case 112:
										{
											if (__temp_svar133.equals("p")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M20.35 17.55 Q17.1 17.65 14.8 21.4 L14.75 33.15 Q16.4 36.95 20.85 36.7 23.25 36.55 24.7 34.45 L25.3 33.4 Q27 30 26.7 25.65 26.45 23.15 25.65 20.65 24.05 17.1 20.35 17.55 M18 15.4 Q19.9 14.25 23.2 14.1 26.45 13.9 29.1 16.75 31.7 19.55 32 23.2 32.25 26.8 31.3 30.25 30.5 33.4 28.4 35.95 27.1 37.75 24.3 38.65 22.6 39.3 20.75 39.25 17.95 39.25 15.1 38.35 L14.15 48.5 Q13.15 49.5 11.55 49.3 10.1 49.4 9.6 47.9 L9.95 17.05 Q10.2 15.7 11.4 15.1 L12.05 14.95 13.4 15.1 Q15.2 16.4 15.3 17.7 16.1 16.5 18 15.4";
											}
											
											break;
										}
										
										
										case 108:
										{
											if (__temp_svar133.equals("l")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M23.7 37.15 Q23.85 39.85 20.9 39.5 19.65 39.4 18.75 38.6 17.9 37.1 17.95 34.85 L18.3 4.5 Q18.75 3.4 19.85 3.2 L21.3 2.9 Q22.8 2.75 22.85 3.7 L23 28.8 23.7 37.15";
											}
											
											break;
										}
										
										
										case 111:
										{
											if (__temp_svar133.equals("o")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M15.9 19.75 Q13.8 22.55 14.05 27.3 L14.4 30.25 Q15.9 37.35 21.2 37.35 23.75 37.35 25.95 34.65 27.35 32.25 27.5 27.15 27.45 24.15 26.6 21.95 25.6 18.95 22.95 17.75 20.9 17.05 19.15 17.3 17.45 17.5 15.9 19.75 M19.15 14.8 L21.3 14.65 23.95 14.95 25.8 15.55 Q27.8 16.3 29 17.45 31.9 20.75 32.5 24.4 33.2 32.7 29.1 36.7 26.05 40.05 20.05 40.05 13.15 39.8 10.4 33.8 8.7 30.6 9.1 25.9 9.3 23.2 10.85 20.2 12.1 17.95 14.9 16.05 16.95 14.9 19.15 14.8";
											}
											
											break;
										}
										
										
										case 109:
										{
											if (__temp_svar133.equals("m")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M17.75 23.6 Q17 20.95 15.65 20.4 14.85 20 14.05 19.9 L13.65 19.85 11.65 20.25 Q10.35 20.6 9.2 21.75 8.05 22.9 7.65 24.85 7.25 26.75 7.4 30.4 7.45 37.6 6.4 39.05 3.05 41.25 3.3 36.6 L3.45 19.15 Q3.45 16.8 4.65 16.75 5.9 16.7 6.4 18.5 L6.45 18.65 Q7.15 19.7 8.7 18.9 L10.9 17.8 Q15.9 13.6 23.05 19.45 27.05 16.7 30.1 16.6 33.15 16.45 34.95 17.9 36.75 19.35 37.3 21.7 38.3 25.65 38.35 37.55 38.1 39.45 37.25 39.7 35 40.75 34.4 38.85 33.3 33.8 33.45 28.4 L33.05 25.05 Q30.65 17.75 26.3 20.15 L25.5 20.65 Q24 21.95 23.7 23.55 23.35 25.2 23.2 28.65 L23.25 33.2 23 36.65 Q22.7 39.75 21.5 40 20.55 40.35 19.25 40 18.55 39.75 18.3 38.8 L17.75 23.6";
											}
											
											break;
										}
										
										
										case 110:
										{
											if (__temp_svar133.equals("n")) 
											{
												__temp_executeDef134 = false;
												aLetter = "M10.85 17.45 Q11 16.45 11.8 16.3 L12.75 16.3 Q13.9 16.45 14.7 17.6 L15.65 19.2 19.45 17.1 Q22.4 15.25 25.05 15.8 27.65 16.35 28.75 17.6 30.95 19.15 31.15 35.8 31.35 38.15 30.75 39.15 30.25 40 29.05 40 26.45 40 26.5 35.8 L25.55 22 Q25.4 21 24.65 20.4 23.2 19.1 21.7 19.2 18.15 19.6 16 22.5 L14.9 38.7 Q14.7 39.6 13.95 39.7 L13.75 39.75 Q10.15 40.4 10.45 38.5 L10.85 17.45";
											}
											
											break;
										}
										
										
									}
									
									if (__temp_executeDef134) 
									{
										aLetter = "";
									}
									
								}
								
								letters.Path patha = new letters.Path(haxe.lang.Runtime.toString(aLetter));
								letterResource.letters.set(i, patha);
								path2 = patha;
							}
							
							double x = x1;
							double y2 = y1;
							double sx = .7;
							double sy = .7;
							{
								haxe.root.Array<java.lang.Object> a = new haxe.root.Array<java.lang.Object>();
								{
									java.lang.Object __temp_iterator25 = ((java.lang.Object) (haxe.lang.Runtime.callField(path2, "iterator", null)) );
									while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator25, "hasNext", null)))
									{
										java.lang.Object x3 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator25, "next", null)) );
										java.lang.Object __temp_stmt121 = null;
										{
											haxe.root.Array<java.lang.Object> v0 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x3, "v0", true)) );
											java.lang.String v1 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x3, "v1", true));
											{
												java.lang.String __temp_svar135 = (v1);
												int __temp_hash137 = __temp_svar135.hashCode();
												boolean __temp_executeDef136 = true;
												switch (__temp_hash137)
												{
													case 77:case 76:
													{
														if (( (( ( __temp_hash137 == 77 ) && __temp_svar135.equals("M") )) || __temp_svar135.equals("L") )) 
														{
															__temp_executeDef136 = false;
															v0 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( ( sx * ((double) (haxe.lang.Runtime.toDouble(v0.__get(0))) ) ) + x )) ), ((java.lang.Object) (( ( sy * ((double) (haxe.lang.Runtime.toDouble(v0.__get(1))) ) ) + y2 )) )});
														}
														
														break;
													}
													
													
													case 81:
													{
														if (__temp_svar135.equals("Q")) 
														{
															__temp_executeDef136 = false;
															v0 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( ( sx * ((double) (haxe.lang.Runtime.toDouble(v0.__get(0))) ) ) + x )) ), ((java.lang.Object) (( ( sy * ((double) (haxe.lang.Runtime.toDouble(v0.__get(1))) ) ) + y2 )) ), ((java.lang.Object) (( ( sx * ((double) (haxe.lang.Runtime.toDouble(v0.__get(2))) ) ) + x )) ), ((java.lang.Object) (( ( sy * ((double) (haxe.lang.Runtime.toDouble(v0.__get(3))) ) ) + y2 )) )});
														}
														
														break;
													}
													
													
												}
												
												if (__temp_executeDef136) 
												{
													{
													}
													
												}
												
											}
											
											java.lang.Object commandData = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v0, v1}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
											__temp_stmt121 = commandData;
										}
										
										a.push(__temp_stmt121);
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
							double x4 = 0.0;
							double y3 = 0.0;
							int count1 = 0;
							{
								java.lang.Object __temp_iterator26 = temp.iterator();
								while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator26, "hasNext", null)))
								{
									java.lang.Object i1 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator26, "next", null)) );
									haxe.root.Array<java.lang.Object> v = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(i1, "v0", true)) );
									java.lang.String command = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(i1, "v1", true));
									{
										java.lang.String __temp_svar138 = (command);
										int __temp_hash140 = __temp_svar138.hashCode();
										boolean __temp_executeDef139 = true;
										switch (__temp_hash140)
										{
											case 81:case 76:case 77:
											{
												if (( (( ( __temp_hash140 == 81 ) && __temp_svar138.equals("Q") )) || ( (( ( __temp_hash140 == 76 ) && __temp_svar138.equals("L") )) || __temp_svar138.equals("M") ) )) 
												{
													__temp_executeDef139 = false;
													x4 = ((double) (haxe.lang.Runtime.toDouble(v.__get(0))) );
													y3 = ((double) (haxe.lang.Runtime.toDouble(v.__get(1))) );
													if (( x4 < l )) 
													{
														l = x4;
													}
													
													if (( x4 > r )) 
													{
														r = x4;
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
														x4 = ((double) (haxe.lang.Runtime.toDouble(v.__get(2))) );
														y3 = ((double) (haxe.lang.Runtime.toDouble(v.__get(3))) );
														if (( x4 < l )) 
														{
															l = x4;
														}
														
														if (( x4 > r )) 
														{
															r = x4;
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
										
										if (__temp_executeDef139) 
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
							java.lang.String __temp_svar141 = (i);
							int __temp_hash143 = __temp_svar141.hashCode();
							boolean __temp_executeDef142 = true;
							switch (__temp_hash143)
							{
								case 106:case 105:
								{
									if (( (( ( __temp_hash143 == 106 ) && __temp_svar141.equals("j") )) || __temp_svar141.equals("i") )) 
									{
										__temp_executeDef142 = false;
										postX = 3.;
									}
									
									break;
								}
								
								
								case 102:
								{
									if (__temp_svar141.equals("f")) 
									{
										__temp_executeDef142 = false;
										postX = -2.;
									}
									
									break;
								}
								
								
								case 114:
								{
									if (__temp_svar141.equals("r")) 
									{
										__temp_executeDef142 = false;
										postX = -1.;
									}
									
									break;
								}
								
								
							}
							
							if (__temp_executeDef142) 
							{
								postX = 0.;
							}
							
						}
						
						if (( postX != 0 )) 
						{
							x1 += ( postX * .7 );
						}
						
						if (( preX != 0 )) 
						{
							dx += ( preX * .7 );
						}
						
						x1 += ( ((double) (haxe.lang.Runtime.getField_f(haxe.lang.Runtime.getField(tempDim, "dim", true), "x", true)) ) + 1.4 );
						{
							double x5 = dx;
							double y4 = ((double) (0) );
							boolean x0 = ( x5 == 0 );
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
										java.lang.Object __temp_iterator27 = temp.iterator();
										while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator27, "hasNext", null)))
										{
											java.lang.Object x6 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator27, "next", null)) );
											java.lang.Object __temp_stmt124 = null;
											{
												haxe.root.Array<java.lang.Object> v01 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x6, "v0", true)) );
												java.lang.String v11 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x6, "v1", true));
												{
													java.lang.String __temp_svar144 = (v11);
													int __temp_hash146 = __temp_svar144.hashCode();
													boolean __temp_executeDef145 = true;
													switch (__temp_hash146)
													{
														case 77:case 76:
														{
															if (( (( ( __temp_hash146 == 77 ) && __temp_svar144.equals("M") )) || __temp_svar144.equals("L") )) 
															{
																__temp_executeDef145 = false;
																v01 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v01.__get(0))) )) ), ((java.lang.Object) (( y4 + ((double) (haxe.lang.Runtime.toDouble(v01.__get(1))) ) )) )});
															}
															
															break;
														}
														
														
														case 81:
														{
															if (__temp_svar144.equals("Q")) 
															{
																__temp_executeDef145 = false;
																v01 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v01.__get(0))) )) ), ((java.lang.Object) (( y4 + ((double) (haxe.lang.Runtime.toDouble(v01.__get(1))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v01.__get(2))) )) ), ((java.lang.Object) (( y4 + ((double) (haxe.lang.Runtime.toDouble(v01.__get(3))) ) )) )});
															}
															
															break;
														}
														
														
													}
													
													if (__temp_executeDef145) 
													{
														{
														}
														
													}
													
												}
												
												java.lang.Object commandData1 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v01, v11}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
												__temp_stmt124 = commandData1;
											}
											
											a1.push(__temp_stmt124);
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
											java.lang.Object __temp_iterator28 = temp.iterator();
											while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator28, "hasNext", null)))
											{
												java.lang.Object x7 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator28, "next", null)) );
												java.lang.Object __temp_stmt123 = null;
												{
													haxe.root.Array<java.lang.Object> v02 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x7, "v0", true)) );
													java.lang.String v12 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x7, "v1", true));
													{
														java.lang.String __temp_svar147 = (v12);
														int __temp_hash149 = __temp_svar147.hashCode();
														boolean __temp_executeDef148 = true;
														switch (__temp_hash149)
														{
															case 77:case 76:
															{
																if (( (( ( __temp_hash149 == 77 ) && __temp_svar147.equals("M") )) || __temp_svar147.equals("L") )) 
																{
																	__temp_executeDef148 = false;
																	v02 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x5 + ((double) (haxe.lang.Runtime.toDouble(v02.__get(0))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v02.__get(1))) )) )});
																}
																
																break;
															}
															
															
															case 81:
															{
																if (__temp_svar147.equals("Q")) 
																{
																	__temp_executeDef148 = false;
																	v02 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x5 + ((double) (haxe.lang.Runtime.toDouble(v02.__get(0))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v02.__get(1))) )) ), ((java.lang.Object) (( x5 + ((double) (haxe.lang.Runtime.toDouble(v02.__get(2))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v02.__get(3))) )) )});
																}
																
																break;
															}
															
															
														}
														
														if (__temp_executeDef148) 
														{
															{
															}
															
														}
														
													}
													
													java.lang.Object commandData2 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v02, v12}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
													__temp_stmt123 = commandData2;
												}
												
												a2.push(__temp_stmt123);
											}
											
										}
										
										temp = a2;
									}
									 else 
									{
										haxe.root.Array<java.lang.Object> a3 = new haxe.root.Array<java.lang.Object>();
										{
											java.lang.Object __temp_iterator29 = temp.iterator();
											while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator29, "hasNext", null)))
											{
												java.lang.Object x8 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator29, "next", null)) );
												java.lang.Object __temp_stmt122 = null;
												{
													haxe.root.Array<java.lang.Object> v03 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x8, "v0", true)) );
													java.lang.String v13 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x8, "v1", true));
													{
														java.lang.String __temp_svar150 = (v13);
														int __temp_hash152 = __temp_svar150.hashCode();
														boolean __temp_executeDef151 = true;
														switch (__temp_hash152)
														{
															case 77:case 76:
															{
																if (( (( ( __temp_hash152 == 77 ) && __temp_svar150.equals("M") )) || __temp_svar150.equals("L") )) 
																{
																	__temp_executeDef151 = false;
																	v03 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x5 + ((double) (haxe.lang.Runtime.toDouble(v03.__get(0))) ) )) ), ((java.lang.Object) (( y4 + ((double) (haxe.lang.Runtime.toDouble(v03.__get(1))) ) )) )});
																}
																
																break;
															}
															
															
															case 81:
															{
																if (__temp_svar150.equals("Q")) 
																{
																	__temp_executeDef151 = false;
																	v03 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x5 + ((double) (haxe.lang.Runtime.toDouble(v03.__get(0))) ) )) ), ((java.lang.Object) (( y4 + ((double) (haxe.lang.Runtime.toDouble(v03.__get(1))) ) )) ), ((java.lang.Object) (( x5 + ((double) (haxe.lang.Runtime.toDouble(v03.__get(2))) ) )) ), ((java.lang.Object) (( y4 + ((double) (haxe.lang.Runtime.toDouble(v03.__get(3))) ) )) )});
																}
																
																break;
															}
															
															
														}
														
														if (__temp_executeDef151) 
														{
															{
															}
															
														}
														
													}
													
													java.lang.Object commandData3 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v03, v13}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
													__temp_stmt122 = commandData3;
												}
												
												a3.push(__temp_stmt122);
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
								double x9 = 0.0;
								double y5 = 0.0;
								int count2 = 0;
								{
									java.lang.Object __temp_iterator30 = word.iterator();
									while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator30, "hasNext", null)))
									{
										java.lang.Object i2 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator30, "next", null)) );
										haxe.root.Array<java.lang.Object> v2 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(i2, "v0", true)) );
										java.lang.String command1 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(i2, "v1", true));
										{
											java.lang.String __temp_svar153 = (command1);
											int __temp_hash155 = __temp_svar153.hashCode();
											boolean __temp_executeDef154 = true;
											switch (__temp_hash155)
											{
												case 81:case 76:case 77:
												{
													if (( (( ( __temp_hash155 == 81 ) && __temp_svar153.equals("Q") )) || ( (( ( __temp_hash155 == 76 ) && __temp_svar153.equals("L") )) || __temp_svar153.equals("M") ) )) 
													{
														__temp_executeDef154 = false;
														x9 = ((double) (haxe.lang.Runtime.toDouble(v2.__get(0))) );
														y5 = ((double) (haxe.lang.Runtime.toDouble(v2.__get(1))) );
														if (( x9 < l1 )) 
														{
															l1 = x9;
														}
														
														if (( x9 > r1 )) 
														{
															r1 = x9;
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
															x9 = ((double) (haxe.lang.Runtime.toDouble(v2.__get(2))) );
															y5 = ((double) (haxe.lang.Runtime.toDouble(v2.__get(3))) );
															if (( x9 < l1 )) 
															{
																l1 = x9;
															}
															
															if (( x9 > r1 )) 
															{
																r1 = x9;
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
											
											if (__temp_executeDef154) 
											{
												{
												}
												
											}
											
										}
										
									}
									
								}
								
								dim2 = new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"centre", "dim", "end", "pos"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( l1 + ( (( r1 - l1 )) / 2 ) )) ), ((java.lang.Object) (( t1 + ( (( b1 - t1 )) / 2 ) )) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( r1 - l1 )) ), ((java.lang.Object) (( b1 - t1 )) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (r1) ), ((java.lang.Object) (b1) )})), new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{"x", "y"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (l1) ), ((java.lang.Object) (t1) )}))}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}));
							}
							
							double repos = ( ((double) (100.) ) - ((double) (haxe.lang.Runtime.getField_f(haxe.lang.Runtime.getField(dim2, "pos", true), "x", true)) ) );
							{
								double y_ = ((double) (haxe.lang.Runtime.toDouble(lineSpace)) );
								double x10 = repos;
								double y6 = y_;
								boolean x01 = ( x10 == 0 );
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
											java.lang.Object __temp_iterator31 = word.iterator();
											while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator31, "hasNext", null)))
											{
												java.lang.Object x11 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator31, "next", null)) );
												java.lang.Object __temp_stmt127 = null;
												{
													haxe.root.Array<java.lang.Object> v04 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x11, "v0", true)) );
													java.lang.String v14 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x11, "v1", true));
													{
														java.lang.String __temp_svar156 = (v14);
														int __temp_hash158 = __temp_svar156.hashCode();
														boolean __temp_executeDef157 = true;
														switch (__temp_hash158)
														{
															case 77:case 76:
															{
																if (( (( ( __temp_hash158 == 77 ) && __temp_svar156.equals("M") )) || __temp_svar156.equals("L") )) 
																{
																	__temp_executeDef157 = false;
																	v04 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v04.__get(0))) )) ), ((java.lang.Object) (( y6 + ((double) (haxe.lang.Runtime.toDouble(v04.__get(1))) ) )) )});
																}
																
																break;
															}
															
															
															case 81:
															{
																if (__temp_svar156.equals("Q")) 
																{
																	__temp_executeDef157 = false;
																	v04 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v04.__get(0))) )) ), ((java.lang.Object) (( y6 + ((double) (haxe.lang.Runtime.toDouble(v04.__get(1))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v04.__get(2))) )) ), ((java.lang.Object) (( y6 + ((double) (haxe.lang.Runtime.toDouble(v04.__get(3))) ) )) )});
																}
																
																break;
															}
															
															
														}
														
														if (__temp_executeDef157) 
														{
															{
															}
															
														}
														
													}
													
													java.lang.Object commandData4 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v04, v14}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
													__temp_stmt127 = commandData4;
												}
												
												a4.push(__temp_stmt127);
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
												java.lang.Object __temp_iterator32 = word.iterator();
												while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator32, "hasNext", null)))
												{
													java.lang.Object x12 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator32, "next", null)) );
													java.lang.Object __temp_stmt126 = null;
													{
														haxe.root.Array<java.lang.Object> v05 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x12, "v0", true)) );
														java.lang.String v15 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x12, "v1", true));
														{
															java.lang.String __temp_svar159 = (v15);
															int __temp_hash161 = __temp_svar159.hashCode();
															boolean __temp_executeDef160 = true;
															switch (__temp_hash161)
															{
																case 77:case 76:
																{
																	if (( (( ( __temp_hash161 == 77 ) && __temp_svar159.equals("M") )) || __temp_svar159.equals("L") )) 
																	{
																		__temp_executeDef160 = false;
																		v05 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x10 + ((double) (haxe.lang.Runtime.toDouble(v05.__get(0))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v05.__get(1))) )) )});
																	}
																	
																	break;
																}
																
																
																case 81:
																{
																	if (__temp_svar159.equals("Q")) 
																	{
																		__temp_executeDef160 = false;
																		v05 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x10 + ((double) (haxe.lang.Runtime.toDouble(v05.__get(0))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v05.__get(1))) )) ), ((java.lang.Object) (( x10 + ((double) (haxe.lang.Runtime.toDouble(v05.__get(2))) ) )) ), ((java.lang.Object) (((double) (haxe.lang.Runtime.toDouble(v05.__get(3))) )) )});
																	}
																	
																	break;
																}
																
																
															}
															
															if (__temp_executeDef160) 
															{
																{
																}
																
															}
															
														}
														
														java.lang.Object commandData5 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v05, v15}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
														__temp_stmt126 = commandData5;
													}
													
													a5.push(__temp_stmt126);
												}
												
											}
											
											word = a5;
										}
										 else 
										{
											haxe.root.Array<java.lang.Object> a6 = new haxe.root.Array<java.lang.Object>();
											{
												java.lang.Object __temp_iterator33 = word.iterator();
												while (haxe.lang.Runtime.toBool(haxe.lang.Runtime.callField(__temp_iterator33, "hasNext", null)))
												{
													java.lang.Object x13 = ((java.lang.Object) (haxe.lang.Runtime.callField(__temp_iterator33, "next", null)) );
													java.lang.Object __temp_stmt125 = null;
													{
														haxe.root.Array<java.lang.Object> v06 = ((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(x13, "v0", true)) );
														java.lang.String v16 = haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(x13, "v1", true));
														{
															java.lang.String __temp_svar162 = (v16);
															int __temp_hash164 = __temp_svar162.hashCode();
															boolean __temp_executeDef163 = true;
															switch (__temp_hash164)
															{
																case 77:case 76:
																{
																	if (( (( ( __temp_hash164 == 77 ) && __temp_svar162.equals("M") )) || __temp_svar162.equals("L") )) 
																	{
																		__temp_executeDef163 = false;
																		v06 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x10 + ((double) (haxe.lang.Runtime.toDouble(v06.__get(0))) ) )) ), ((java.lang.Object) (( y6 + ((double) (haxe.lang.Runtime.toDouble(v06.__get(1))) ) )) )});
																	}
																	
																	break;
																}
																
																
																case 81:
																{
																	if (__temp_svar162.equals("Q")) 
																	{
																		__temp_executeDef163 = false;
																		v06 = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{((java.lang.Object) (( x10 + ((double) (haxe.lang.Runtime.toDouble(v06.__get(0))) ) )) ), ((java.lang.Object) (( y6 + ((double) (haxe.lang.Runtime.toDouble(v06.__get(1))) ) )) ), ((java.lang.Object) (( x10 + ((double) (haxe.lang.Runtime.toDouble(v06.__get(2))) ) )) ), ((java.lang.Object) (( y6 + ((double) (haxe.lang.Runtime.toDouble(v06.__get(3))) ) )) )});
																	}
																	
																	break;
																}
																
																
															}
															
															if (__temp_executeDef163) 
															{
																{
																}
																
															}
															
														}
														
														java.lang.Object commandData6 = ((java.lang.Object) (new haxe.lang.DynamicObject(new haxe.root.Array<java.lang.String>(new java.lang.String[]{"v0", "v1"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{v06, v16}), new haxe.root.Array<java.lang.String>(new java.lang.String[]{}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{}))) );
														__temp_stmt125 = commandData6;
													}
													
													a6.push(__temp_stmt125);
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
						path1 = path1.concat(word);
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
								path1.push(fillColor1);
							}
							
						}
						
						x1 += ( ((double) (15) ) * .7 );
						word = new haxe.root.Array<java.lang.Object>();
					}
					
					counta++;
				}
				
			}
			
			path1 = path1.concat(word);
			path = path1;
		}
		
		path = letters.Path.rotateXYZ(path, ( java.lang.Math.PI / 10 ), ( java.lang.Math.PI / 3 ), ( java.lang.Math.PI / 10 ), ((double) (1) ), null, null, null);
		this.drawToScreen(path);
	}
	
	
	public static   void main()
	{
		new letters.ExampleLetters();
	}
	
	
	public static   java.lang.Object __hx_createEmpty()
	{
		return new letters.ExampleLetters(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
	}
	
	
	public static   java.lang.Object __hx_create(haxe.root.Array arr)
	{
		return new letters.ExampleLetters();
	}
	
	
	public  letters.LetterResource letterResource;
	
	public   void drawToScreen(haxe.root.Array<java.lang.Object> path_)
	{
		haxe.root.Array<haxe.root.Array> path = new haxe.root.Array<haxe.root.Array>(new haxe.root.Array[]{path_});
		this.surface.paintFunction = new letters.ExampleLetters_drawToScreen_92__Fun(((haxe.root.Array<haxe.root.Array>) (path) ));
	}
	
	
	@Override public   java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		{
			boolean __temp_executeDef118 = true;
			switch (field.hashCode())
			{
				case -1369717164:
				{
					if (field.equals("letterResource")) 
					{
						__temp_executeDef118 = false;
						this.letterResource = ((letters.LetterResource) (value) );
						return value;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef118) 
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
			boolean __temp_executeDef119 = true;
			switch (field.hashCode())
			{
				case 1675673643:
				{
					if (field.equals("drawToScreen")) 
					{
						__temp_executeDef119 = false;
						return ((haxe.lang.Function) (new haxe.lang.Closure(((java.lang.Object) (this) ), haxe.lang.Runtime.toString("drawToScreen"))) );
					}
					
					break;
				}
				
				
				case -1369717164:
				{
					if (field.equals("letterResource")) 
					{
						__temp_executeDef119 = false;
						return this.letterResource;
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef119) 
			{
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
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
			boolean __temp_executeDef120 = true;
			switch (field.hashCode())
			{
				case 1675673643:
				{
					if (field.equals("drawToScreen")) 
					{
						__temp_executeDef120 = false;
						this.drawToScreen(((haxe.root.Array<java.lang.Object>) (dynargs.__get(0)) ));
					}
					
					break;
				}
				
				
			}
			
			if (__temp_executeDef120) 
			{
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		return null;
	}
	
	
	@Override public   void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		baseArr.push("letterResource");
		{
			super.__hx_getFields(baseArr);
		}
		
	}
	
	
}



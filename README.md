Letters
=======

A library that parses letter svg path info so that in can be used for drawing API and rendering letters as sentences it has some basic ability to color words based on sentences and includes a basic a-z hand created font, the code is developed in haxe it currently works well for Javascript target, should be suitable for extension to flash target and has some semi working Java implementation. It is designed more as a lite toolkit to hack on rather than a perfect framework. The current a-z letters were hand crafted in flash API and exported using an online as3 script and then the path data extracted for easy use with my haxe code. It's quite a low level simple structure ideal for extending to your needs but quite basic DIY toolset. The code has rudimentary 2.5D support very very simple 3D. The code allows you to use your own vector hand hacked svg path font with Html Canvas ( or perhaps java graphics2d ) and might be a good starting point for creating lite weight innovative text effects. I have no idea how it compares to other web font approaches.

You can view canvas result here with a bit of 3d and rainbow highlight refresh for new colors:
https://rawgithub.com/Justinfront/Letters/master/web/index.html

Basic usage:

var path = Path.generateVectorText( 'text', 100., 50., .7, 300., 22.);

3D rotation:

path = path.rotateXYZ( Math.PI/10, Math.PI/3, Math.PI/10, 1 );

then depending on platform you just iterate and switch on the path case.

ADDED ability for the letters to follow an arbitrary path and a demo where users clicks generate the path.

package letters.paragraphPath;

import letters.Path;
import haxe.Resource;
using letters.paragraphPath.GraphicsPoints;
using letters.pathway.Sides;
using turtle.Turtle;
using letters.Path;

class ParagraphPathRepeat{
    
    public function new( sentence :String, sidePoints: Array<SidePoint> ){
        Turtle.clear();
        var g = Turtle.surface;
        var renderPath: Array<CommandData>;
        var coloring = Path.rainbowPencilHighlight;
        var path = Path.generateVectorText( sentence, 43., 200., .7, 640., 22., coloring, coloring );
        var path1 = path.translate( 43, -197 );
        path1 = path1.scale( 1.4, -0.3 );
        path1 = path1.translate( 0, 10 );
        renderPath = sidePoints.mapToRouting( path1 );
        g.drawCommands( renderPath );
        renderPath.drawCommandsMore();
        var aPath: Array<CommandData>;
        var lastPath = path1;
        var k: Int;
        var paragraphWidth = lastPath.getDim().end.x;
        var maxY = sidePoints.length + 1;
        while( true ){
            aPath           = lastPath.translate( path1.getDim().end.x + 1, 0  );
            paragraphWidth  = aPath.getDim().end.x;
            if( paragraphWidth > maxY ) break;
            renderPath  = sidePoints.mapToRouting( aPath );
            g.drawCommands( renderPath );
            lastPath    = aPath;
        }
    }
    
}
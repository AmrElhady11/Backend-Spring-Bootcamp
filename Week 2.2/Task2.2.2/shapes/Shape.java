package shapes;

import tools.Draw2D;
import tools.Draw3D;

public interface Shape {
     double getArea(double l);
     String getShapeName();
     void draw2DShape();
     void draw3DShape();
     void setDraw2DShape(Draw2D draw2D);
     void setDraw3DShape(Draw3D draw3D);



}

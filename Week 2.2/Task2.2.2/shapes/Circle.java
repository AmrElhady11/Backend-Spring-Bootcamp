package shapes;

import tools.Draw2D;
import tools.Draw3D;
import util.DatabaseOperation;

public class Circle implements Shape{

   private Draw2D draw2D;
   private Draw3D draw3D;
   private DatabaseOperation databaseOperation;
   public Circle(){}
    public Circle(Draw2D draw2D, Draw3D draw3D, DatabaseOperation databaseOperation){
        this.draw2D = draw2D;
        this.draw3D = draw3D;
        this.databaseOperation =databaseOperation;
    }
    @Override
    public double getArea(double l) {
        return l *3.14;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public void draw2DShape() {
        draw2D.draw(getShapeName());
    }

    @Override
    public void draw3DShape() {
        draw3D.draw(getShapeName());
    }

    @Override
    public void setDraw2DShape(Draw2D draw2D) {
        this.draw2D = draw2D;
    }

    @Override
    public void setDraw3DShape(Draw3D draw3D) {
        this.draw3D = draw3D;

    }
}

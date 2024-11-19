package shapes;

import tools.Draw2D;
import tools.Draw3D;

public class Square implements Shape{


    Draw2D draw2D;
    private Draw3D draw3D;
    public Square(Draw2D draw2D,Draw3D draw3D){
        this.draw2D = draw2D;
        this.draw3D = draw3D;
    }
    public Square(){}
    @Override
    public double getArea(double l) {
        return l*l;
    }

    @Override
    public String getShapeName() {
        return "Square";
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

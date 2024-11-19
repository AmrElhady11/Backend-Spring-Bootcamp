package shapes;

import tools.Draw2D;
import tools.Draw3D;
import util.DatabaseOperation;

public class Square implements Shape{


    private Draw2D draw2D;
    private Draw3D draw3D;
    private DatabaseOperation databaseOperation;
    public Square(Draw2D draw2D, Draw3D draw3D, DatabaseOperation databaseOperation){
        this.draw2D = draw2D;
        this.draw3D = draw3D;
        this.databaseOperation =databaseOperation;

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

    public DatabaseOperation getDatabaseOperation() {
        return databaseOperation;
    }

    public void setDatabaseOperation(DatabaseOperation databaseOperation) {
        this.databaseOperation = databaseOperation;
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

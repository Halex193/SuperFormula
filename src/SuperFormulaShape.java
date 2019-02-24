import processing.data.JSONObject;

public class SuperFormulaShape
{
    public float m1;
    public float m2;
    public float a;
    public float b;
    public float n1;
    public float n2;
    public float n3;

    public SuperFormulaShape(float m1, float m2, float a, float b, float n1, float n2, float n3)
    {
        this.m1 = m1;
        this.m2 = m2;
        this.a = a;
        this.b = b;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public SuperFormulaShape(JSONObject shape)
    {
        this.m1 = shape.getFloat("m1");
        this.m2 = shape.getFloat("m2");
        this.a = shape.getFloat("a");
        this.b = shape.getFloat("b");
        this.n1 = shape.getFloat("n1");
        this.n2 = shape.getFloat("n2");
        this.n3 = shape.getFloat("n3");
    }

    public JSONObject toJsonObject()
    {
        JSONObject shape = new JSONObject();
        shape.put("m1", m1);
        shape.put("m2", m2);
        shape.put("a", a);
        shape.put("b", b);
        shape.put("n1", n1);
        shape.put("n2", n2);
        shape.put("n3", n3);
        return shape;
    }
}

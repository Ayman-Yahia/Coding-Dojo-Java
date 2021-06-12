public class ProjectClass{
    public String name;
    public String description;
    private double initialCost;
    public ProjectClass(){
    }
    public ProjectClass(String name){
        this.name=name;
    }
    public ProjectClass(String name,String description){
        this.name=name;
        this.description=description;
    }
    public ProjectClass(String name,String description,double cost){
        this.name=name;
        this.description=description;
        this .initialCost=cost;
    }
    public String elevatorPitch(){
        return (name+"("+initialCost+"),"+description);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setInitialCost(double initialCost){
        this.initialCost = initialCost;
    }
    public String getProjectName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public double getInitialCost(){
        return this.initialCost;
    }
}
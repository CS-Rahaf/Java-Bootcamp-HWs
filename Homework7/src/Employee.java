public class Employee {

    private String id;
    private String name;
    private float salary;

    Employee(String id, String name, float salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }


    public float getAnnualSalary(){
        return (this.salary * 12);
    }
    public float raisedSalary(int percent){
        float raisedAmount= (this.salary*percent)/100;
        this.salary=salary+raisedAmount;
        return this.salary;
    }

    //Setters, Getters and ToString methods:
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

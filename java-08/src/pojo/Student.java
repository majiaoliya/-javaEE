package pojo;
// 学生类  javaBean
public class Student {
    //学号
    private String id;
    //姓名
    private String name;
    //年龄
    private String age;

    public Student() {
    }

    public Student(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    // toString()

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String)
            return this.id.equals(obj);
        else if(obj instanceof Student) {
            Student other = (Student)obj;
            return this.id.equals(other.id);
        }
        return false;
    }
}

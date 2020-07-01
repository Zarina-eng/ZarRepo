package API.SerializationIntro;

public class Pet {
    private String name;
    private int age;
    private String status;
    private int id;
    private  String photoUrl;
    public  Pet(String name,int age,String status){
        this.name=name;
        this.status=status;
        this.age=age;
    }

    public void setName(String name){
        this.name=name;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Pet setAge(int age) {
        this.age = age;
        return this;
    }

    public int getId() {
        return id;
    }

    public Pet setId(int id) {
        this.id = id;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Pet setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Pet setStatus(String status) {
        this.status = status;
        return this;
    }
}

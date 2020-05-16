/**
 * @author : kongyy
 * @time : 2020/4/22 14:39
 */
public class Student {

    private int id;

    private String name;

    private String email;

    //private String birDate; 问题：1
    private String birthDate;

    private Boolean gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birDate) {
        this.birthDate = birDate;
    }

//    问题：1
//    public String getBirDate() {
//        return birthDate;
//    }
//
//    public void setBirDate(String birDate) {
//        this.birthDate = birDate;
//    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    问题：1
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", birDate='" + birthDate + '\'' +
//                ", gender=" + gender +
//                '}';
//    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender=" + gender +
                '}';
    }
}

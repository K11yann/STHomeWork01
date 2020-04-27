import java.util.*;

/**
 * @author : kongyy
 * @time : 2020/4/22 15:05
 */

public class StudentManager {

    List<Student> list = new ArrayList<Student>();
    Scanner input = new Scanner(System.in);
    boolean flag = true;

    public void listStudent(){
        if(list.size()>0){
            printList(list);
        }
        else{
            System.out.println("这里还没有记录哦，快去添加吧！！！！！！");
        }
    }

    public void addStudent(){
        if(list.size()>20){
            System.out.println("人数已达上限，不能再进行添加！！！！");
        }
        else{
            Student stu = new Student();
            System.out.println("下面开始添加记录--------------------------------------");
            System.out.println("请输入学生学号：");
            int id = 0;
            while(true){
                String str = input.next();
                if(isNumeric(str)){
                    id = Integer.parseInt(str);
                    break;
                }
                else{
                    System.out.println("请重新输入学生学号：");
                }
            }
            boolean f = false;
            for(int i=0;i<list.size();i++){
                if(list.get(i).getId() == id){
                    f = true;
                    break;
                }
            }
            if(!f){
                System.out.println("请输入学生姓名：");
                String name = input.next();
                System.out.println("请输入学生邮箱：");
                String email = input.next();
                System.out.println("请输入学生出生日期：");
                String birDate = input.next();
                System.out.println("请输入学生性别（男or女）：");
                boolean gender = false;
                while(true){
                    String truGen = input.next();
                    if(truGen.equals("女")){
                        gender = false;
                        break;
                    }
                    else if(truGen.equals("男")){
                        gender = true;
                        break;
                    }
                    else{
                        System.out.println("请输入指定内容：男或女！！！！！！");
                    }
                }
                stu.setId(id);
                stu.setName(name);
                stu.setEmail(email);
                stu.setBirDate(birDate);
                stu.setGender(gender);
                if(list.add(stu)){
                    System.out.println("插入成功！！！");
                }else{
                    System.out.println("插入失败");
                }
            }
            else{
                System.out.println("该id已存在");
            }
        }
    }

    public List<Student> searchStuent(){
        List<Student> sealist = new ArrayList<Student>();
        System.out.println("请输入你要查找的同学的名字：");
        String name = input.next();
        Student student = new Student();
        for(int i = 0;i<list.size();i++){
            student = list.get(i);
            if(student.getName().equals(name)){
                sealist.add(student);
            }
        }
        if(sealist.size() > 0){
            printList(sealist);
        }
        else{
            System.out.println("没有找到你想要的记录！");
        }
        return sealist;
    }

    public boolean updateStudent(){
        Student stu = new Student();
        System.out.println("请输入你要修改的记录的id（同学学号）：");
        Student s = new Student();
        int id = 0;
        while(true){
            String str = input.next();
            if(isNumeric(str)){
                id = Integer.parseInt(str);
                break;
            }
            else{
                System.out.println("请重新输入合法学生学号：");
            }
        }
        boolean f = false;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId() == id){
                s = list.get(i);
                f = true;
                break;
            }
        }
        if(f){
            System.out.println("下面输入修改信息---------------------------------------------");
            System.out.println("原姓名为:"+s.getName()+"\n请输入学生姓名：");
            String name = input.next();
            System.out.println("原邮箱："+s.getEmail()+"\n请输入学生邮箱：");
            String email = input.next();
            System.out.println("原出生日期为："+s.getBirDate()+"\n请输入学生出生日期：");
            String birDate = input.next();
            Boolean gend = s.getGender();
            String intgend ;
            if(gend){
                intgend = "男";
            }
            else{
                intgend = "女";
            }
            System.out.println("原性别为："+intgend+"\n请输入学生性别（男or女）：");
            String truGen = input.next();
            boolean gender = false;
            if(truGen.equals("女")){
                gender = false;
            }
            if(truGen.equals("男")){
                gender = true;
            }
            for(int i=0;i<list.size();i++){
                if(list.get(i).getId() == id){
                    list.get(i).setName(name);
                    list.get(i).setEmail(email);
                    list.get(i).setBirDate(birDate);
                    list.get(i).setGender(gender);
                }
            }
            System.out.println("修改成功！");
        }
        else{
            System.out.println("没有找到相关同学");
        }

        return true;
    }

    public boolean delStudent(){
        System.out.println("请输入你要删除的同学的名字：");
        String name = input.next();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().equals(name)){
                list.remove(i);
                i = 0;
            }
        }
        System.out.println("删除成功！");
        return true;
    }

    public void printList(List<Student> alist){
        int id;
        String name;
        String email;
        String birDate;
        boolean gender;
        String truGen;
        Collections.sort(alist, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // 按照学生的年龄进行升序排列
                if (s1.getId() > s2.getId()) {
                    return 1;
                }
                if (s1.getId() == s2.getId()) {
                    return 0;
                }
                return -1;
            }
        });
        for(int i=0;i<alist.size();i++){
            Student s = alist.get(i);
            id = s.getId();
            name = s.getName();
            birDate = s.getBirDate();
            gender = s.getGender();
            email = s.getEmail();
            if(gender){
                truGen = "男";
            }
            else{
                truGen = "女";
            }
            System.out.println("学号："+id+" 姓名：" + name + " 邮箱：" + email + " 出生年月：" + birDate + " 性别：" + truGen);
        }
    }

    public static boolean isNumeric(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57){
                return false;
            }
        }
        return true;
    }

    public void application(){
        System.out.println("欢迎来到学生管理系统！");
        while (flag){
            System.out.println("请选择操作：");
            System.out.println("***********************************");
            System.out.println("*              1 插入             *");
            System.out.println("*              2 查找             *");
            System.out.println("*              3 删除             *");
            System.out.println("*              4 修改             *");
            System.out.println("*              5 输出             *");
            System.out.println("*              6 退出             *");
            System.out.println("***********************************");
            String str = input.next();
            int num = 0;
            if(isNumeric(str)){
                num = Integer.parseInt(str);
                switch (num) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        searchStuent();
                        break;
                    case 3:
                        delStudent();
                        break;
                    case 4:
                        updateStudent();
                        break;
                    case 5:
                        listStudent();
                        break;
                    case 6:
                        System.out.println("退出成功！！！！！！欢迎下次光临！！！！！！");
                        flag = false;
                        break;
                    default:
                        System.out.println("请输入指定数字！！！！！！！！！！");
                        break;
                }
            }
            else{
                System.out.println("请输入指定数字！！！！！！！！！！");
            }
        }
    }
}

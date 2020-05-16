import java.util.*;

/**
 * @author : kongyy
 * @time : 2020/4/22 15:05
 */

public class StudentManager {

    List<Student> list = new ArrayList<Student>();
    Scanner input = new Scanner(System.in);
    boolean flag = true;

    /**
     * 问题：8
     * 功能：调用printList函数将list中的学生信息输出出来
     * 输入：无
     * 返回：无
     */
    public void listStudent(){
        if(list.size()>0){
            printList(list);
        } else{
            System.out.println("这里还没有记录哦，快去添加吧！！！！！！");
        }
    }

    /**
     * 问题：8
     * 功能：添加一个学生的信息到list中
     * 输入：id、name、email、birthDate、gender
     * 返回：无
     */
    public void addStudent(){
        if(list.size()>20){
            System.out.println("人数已达上限，不能再进行添加！！！！");
        } else{
//            Student stu = new Student(); 问题：1
            Student student = new Student();
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
                //String birDate = input.next(); 问题：1
                String birthDate = input.next();
                System.out.println("请输入学生性别（男or女）：");
                boolean gender = false;
                while(true){
                    //String truGen = input.next(); 问题：1
                    String trueGender = input.next();
//                    问题：1
//                    if(truGen.equals("女")){
//                        gender = false;
//                        break;
//                    }
//                    else if(truGen.equals("男")){
//                        gender = true;
//                        break;
//                    }
                    if(trueGender.equals("女")){
                        gender = false;
                        break;
                    } else if(trueGender.equals("男")){
                        gender = true;
                        break;
                    } else{
                        System.out.println("请输入指定内容：男或女！！！！！！");
                    }
                }
//                问题：1
//                stu.setId(id);
//                stu.setName(name);
//                stu.setEmail(email);
//                stu.setBirDate(birDate);
//                stu.setGender(gender);
                student.setId(id);
                student.setName(name);
                student.setEmail(email);
                student.setBirthDate(birthDate);
                student.setGender(gender);
                //if(list.add(stu)){ 问题：1
                if(list.add(student)){
                    System.out.println("插入成功！！！");
                }else{
                    System.out.println("插入失败");
                }
            } else{
                System.out.println("该id已存在");
            }
        }
    }

    /**
     * 问题：8
     * 功能：通过学生的姓名来找学生信息
     * 输入：name
     * 返回：若查找到，则返回所有符合条件的信息，若没有找到，则返回空
     */
    public List<Student> searchStudent(){
//        List<Student> sealist = new ArrayList<Student>(); 问题：1
        List<Student> searchlist = new ArrayList<Student>();
        System.out.println("请输入你要查找的同学的名字：");
        String name = input.next();
        Student student = new Student();
        for(int i = 0;i<list.size();i++){
            student = list.get(i);
            if(student.getName().equals(name)){
//                sealist.add(student); 问题：1
                searchlist.add(student);
            }
        }
//        问题：1
//        if(sealist.size() > 0){
//            printList(sealist);
//        }
        if(searchlist.size() > 0){
            printList(searchlist);
        } else{
            System.out.println("没有找到你想要的记录！");
        }
//        return sealist; 问题：1
        return searchlist;
    }

    /**
     * 问题：8
     * 功能：更新学生信息
     * 输入：id、name、email、birthDate、gender
     * 返回：true
     */
    public boolean updateStudent(){
        System.out.println("请输入你要修改的记录的id（同学学号）：");
        Student s = new Student();
        int id = 0;
        while(true){
            String str = input.next();
            if(isNumeric(str)){
                id = Integer.parseInt(str);
                break;
            } else{
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
            //System.out.println("原出生日期为："+s.getBirDate()+"\n请输入学生出生日期："); 问题：1
            System.out.println("原出生日期为："+s.getBirthDate()+"\n请输入学生出生日期：");
            //String birDate = input.next(); 问题：1
            String birthDate = input.next();
            boolean gender = s.getGender();
            //String intgend ;
            String intGender ;
            if(gender){
                //intgend = "男";
                intGender = "男";
            } else{
                //intgend = "女";
                intGender = "女";
            }
//            System.out.println("原性别为："+intgend+"\n请输入学生性别（男or女）："); 问题：1
            System.out.println("原性别为："+intGender+"\n请输入学生性别（男or女）：");
//            String truGen = input.next(); 问题：1
            String trueGender = input.next();
//            问题：1
//            if(truGen.equals("女")){
//                gender = false;
//            }
//            if(truGen.equals("男")){
//                gender = true;
//            }
            if(trueGender.equals("女")){
                gender = false;
            }
            if(trueGender.equals("男")){
                gender = true;
            }
            for(int i=0;i<list.size();i++){
                if(list.get(i).getId() == id){
                    list.get(i).setName(name);
                    list.get(i).setEmail(email);
                    //list.get(i).setBirDate(birDate); 问题：1
                    list.get(i).setBirthDate(birthDate);
                    list.get(i).setGender(gender);
                }
            }
            System.out.println("修改成功！");
        } else{
            System.out.println("没有找到相关同学");
        }
        return true;
    }

    /**
     * 问题：8
     * 功能：删除学生信息
     * 输入：name
     * 返回：true
     */
    public boolean deleteStudent(){
    //public boolean delStudent(){ 问题：1
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

    /**
     * 问题：8
     * 功能：将list中的信息按学号大小排序并打印
     * 输入：无
     * 返回：无
     */
//    public void printList(List<Student> alist){ 问题：1
     public void printList(List<Student> aList){
        // int id; 问题：11
        int id = 0;
        //String name; 问题：11
        String name = "xxx";
        //String email; 问题：11
        String email = "1111";
        //String birDate; 问题：11
        String birthDate = "0101";
        //boolean gender; 问题：11
        boolean gender = false;
        //String truGen; 问题：1  问题：11
        String trueGender = "男";
//        Collections.sort(alist, new Comparator<Student>() { 问题：1
         Collections.sort(aList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // 按照学生的年龄进行升序排列
                if (s1.getId() > s2.getId()) {
                    return 1;
                } else if (s1.getId() == s2.getId()) {
                    return 0;
                } else{
                    return -1;
                }
            }
        });
//        for(int i=0;i<alist.size();i++){ 问题：1
         for(int i=0;i<aList.size();i++){
            Student s = aList.get(i);
            id = s.getId();
            name = s.getName();
            //birDate = s.getBirDate(); 问题：1
            birthDate = s.getBirthDate();
            gender = s.getGender();
            email = s.getEmail();
            if(gender){
                //truGen = "男"; 问题：1
                trueGender = "男";
            } else{
                //truGen = "女"; 问题：1
                trueGender = "女";
            }
            //System.out.println("学号："+id+" 姓名：" + name + " 邮箱：" + email +
             // " 出生年月：" + birDate + " 性别：" + truGen); 问题：1 问题：1
            System.out.println("学号："+id+" 姓名：" + name + " 邮箱：" + email +
                    " 出生年月：" + birthDate + " 性别：" + trueGender);
        }
    }

    /**
     * 问题：8
     * 功能：判断一个字符串是否为一串数字
     * 输入：要判断的字符串
     * 返回：true
     */
    public static boolean isNumeric(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57){
                return false;
            }
        }
        return true;
    }

    /**
     * 问题：8
     * 功能：控制整个系统的运行
     * 输入：要选择的操作
     * 返回：无
     */
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
                        searchStudent();
                        break;
                    case 3:
                        deleteStudent();
                        //delStudent(); 问题：1
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

package Service;


import Domain.*;

/**
 * 负责将Data中的数据封装到Employee 数组中 同时提供相关操作Employee[] 的方法
 * employees用来保存所有的公司员工对象
 *
 * @author zheng
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            //获取员工类型
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);

            //获取员工的其他基本信息
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            double bonus; //声明奖金
            Equipment equipment; // 声明设备信息
            int stock; //声明股票信息
//            String status = new Status("").getNAME();
            if (type == Data.EMPLOYEE) { //员工
                employees[i] = new Employee(id, name, age, salary);
            } else if (type == Data.PROGRAMMER) { //程序员
                equipment = creatEquipment(i);
                employees[i] = new Programmer(id, name, age, salary, equipment);
            } else if (type == Data.DESIGNER) { //设计师
                bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                equipment = creatEquipment(i);
                employees[i] = new Designer(id, name, age, salary, equipment, bonus);
            } else if (type == Data.ARCHITECT) { //架构师
                equipment = creatEquipment(i);
                bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
            }
        }
    }

    private Equipment creatEquipment(int index) {  //创建设备方法
        int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        if (type == Data.PC) {
            return new PC(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
        } else if (type == Data.NOTEBOOK) {
            return new NoteBook(Data.EQUIPMENTS[index][1], Integer.parseInt(Data.EQUIPMENTS[index][2]));
        } else if (type == Data.PRINTER) {
            return new Printer(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
        }

        return null;
    }

    /**
     * 获取所有的员工
     *
     * @return 所有员工
     */
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 获取指定员工
     *
     * @param id 指定id
     * @return 指定员工数据
     */
    public Employee getEmployee(int id) throws TeamException {  //先将异常抛出 等待调用方法的时候再进行 异常处理。
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamException("没有找到相关Id的员工！"); //主动抛出异常
    }
}
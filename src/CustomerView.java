import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView {
    ArrayList<Customer> customers = new ArrayList<>();
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------------商务酒店管理系统-------------------------------------");
            System.out.println("1. 添加顾客信息\n2. 修改顾客信息\n3. 删除顾客信息\n4. 查看顾客信息\n5. 退出系统\n请选择(1-5):");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 处理换行
            if (choice == 1) {
                System.out.println("--------------------------------------------------------------------------------");
                System.out.print("输入房间号: ");
                int roomNumber = scanner.nextInt();
                scanner.nextLine(); // 处理换行
                System.out.print("输入姓名: ");
                String name = scanner.nextLine();
                System.out.print("输入年龄: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // 处理换行
                System.out.print("输入性别: ");
                String gender = scanner.nextLine();
                System.out.print("输入身份证号: ");
                String idCard = scanner.nextLine();
                addCustomer(roomNumber, name, age, gender, idCard);
            } else if (choice == 2) {
                System.out.println("--------------------------------------------------------------------------------");
                System.out.print("输入房间号: ");
                int roomNumber = scanner.nextInt();
                ArrayUtils arrayUtils = new ArrayUtils();
                while (!flag(roomNumber)) {
                    System.out.println("房间号无效，请重新输入房间号: ");
                    roomNumber = scanner.nextInt();
                    scanner.nextLine();
                }
                int updateCustomerIndex = ArrayUtils.findCustomerByRoomId(roomNumber);
                scanner.nextLine();
                System.out.print("输入姓名: ");
                String name = scanner.nextLine();
                System.out.print("输入年龄: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("输入性别: ");
                String gender = scanner.nextLine();
                System.out.print("输入身份证号: ");
                String idCard = scanner.nextLine();
                UpdateCustomer(roomNumber, name, age, gender, idCard);
            } else if (choice == 3) {
                System.out.println("--------------------------------------------------------------------------------");
                System.out.print("请输入要删除信息的房间号：");
                int roomNumberToDelete = scanner.nextInt();
                scanner.nextLine(); // 处理换行
                deleteCustomer(roomNumberToDelete);
            } else if (choice == 4) {
                System.out.println("--------------------------------------------------------------------------------");
                findCustomers();
            } else if (choice == 5) {
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("酒店期待你的下次到来！");
                break;
            }
        }
    }

    //添加信息
    public void addCustomer(int roomNumber, String name, int age, String gender, String idCard) {
        Customer newCustomer = new Customer(roomNumber, name, age, gender, idCard);
        customers.add(newCustomer);
        System.out.println("顾客信息已成功添加！");
    }

    //修改信息
    boolean flag(int roomNumber) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getRoomNumber() == roomNumber)
                return true;
        }
        System.out.println("该房间号不存在！");
        return false;
    }

    public void UpdateCustomer(int roomNumber, String name, int age, String gender, String idCard) {
        customers.set(roomNumber - 1, new Customer(roomNumber, name, age, gender, idCard));
        System.out.println("顾客信息已成功修改！");
    }

    //删除信息
    public void deleteCustomer(int roomNumber) {
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getRoomNumber() == roomNumber) {
                customers.remove(customer);
                System.out.println("房间号为 " + roomNumber + " 的顾客信息已成功删除！");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("未找到房间号为 " + roomNumber + " 的顾客信息。");
        }
    }

    //查看信息
    public void findCustomers() {
        if (customers.isEmpty()) {
            System.out.println("当前没有顾客信息！");
            return;
        } else {
            System.out.printf("%-10s %-13s %-6s %-8s %-25s%n", "房间号", "顾客姓名", "顾客年龄", "顾客性别", "顾客身份证号");
            for (Customer customer : customers) {
                System.out.printf("%-12d %-15s %-9d %-10s %-25s%n",
                        customer.getRoomNumber(),
                        customer.getName(),
                        customer.getAge(),
                        customer.getGender(),
                        customer.getIdCard());
            }
        }
    }
}

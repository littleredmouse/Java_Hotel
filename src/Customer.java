class Customer {
    private int roomNumber; //房间号
    private String name;//姓名
    private int age;//年龄
    private String gender;//性别
    private String idCard;//身份证

    public Customer(int roomNumber, String name, int age, String gender, String idCard) {
        this.roomNumber = roomNumber;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.idCard = idCard;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getIdCard() {
        return idCard;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "roomNumber=" + roomNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
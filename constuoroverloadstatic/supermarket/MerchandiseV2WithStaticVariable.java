package constuoroverloadstatic.supermarket;

public class MerchandiseV2WithStaticVariable {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    //>> TODO 静态变量使用 Static 修饰符
    //>> TODO 静态变量如果不赋值，Java也会给它赋以其类型的初始值
    //>> TODO 静态变量一般使用全大写字母加下划线。这是一个习惯用法
    //>> TODO 所有代码都可以使用静态变量，只要根据防范控制符的规范，这个静态变量对其可见即可
    //   TODO 比如 public 的静态变量，所有代码都可以使用它
    public static double DISCOUNT_FOR_VIP = 0.95;

    //>> TODO 静态方法使用 Static 修饰符
    //静态方法的方法名没有约定俗称全大写
    public static double getVIPDisCount() {
        //>> TODO 静态方法可以访问静态变量，包括自己的静态变量和在访问控制符允许的别的类的静态变量
        return DISCOUNT_FOR_VIP;
    }

    //>> TODO 除了没有this，静态方法的定义和成员方法一样，也有方法名，返回值和参数
    //>> TODO 静态变量没有this自引用，它不属于某个实例，调用的时候也无需引用，直接用类名调用，所以它也不能直接访问
    //>> TODO 当然在静态方法里面，也可以自己创建对象，或者通过参数，获得对象的引用，进而调用方法和访问成员变量
    //>> TODO 静态方法只是没有this自引用的方法而已
    public static double getDiscountOnDisCount(LittleSuperMarket LittleSuperMarket) {
        double activityDiscount = LittleSuperMarket.activityDiscount;
        return DISCOUNT_FOR_VIP * activityDiscount;
    }

    //>> TODO 但是如果没有public修饰符，只能当前包的代码使用它
    static int STATIC_VARIABLE_CURR_PACKAGE_ONLY = 100;

    public MerchandiseV2WithStaticVariable(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }


    //>> TODO 访问修饰符
    //>> TODO 返回值类型：无需返回值则用void表示，void是Java中的关键字
    //>> TODO 方法任意合法的标识符都可以
    //>> TODO 参数列表：后续讲解
    //>> TODO 方法体：方法的代码
    //>> TODO 方法体内部定义的变量叫作局部变量
    public void describe() {
        double netIncome = soldPrice - purchasePrice;
        System.out.println("商品名为" + name + "，商品编号为" + id + "。售价为" + soldPrice
                + "，进价为" + purchasePrice + "。库存为" + count + "。销售一个的毛利润为"
                + netIncome + "。");
    }

    //>> TODO 在方法定义中指定方法的返回值类型
    //>> TODO Java中一个方法只能有一种返回值，如果不需要返回值则用void表示
    //>> TODO 如果定义了返回值，则必须使用return语句返回方法的返回值，return是Java的关键字
    //>> TODO 可以认为，返回值必须要能够用来给返回值类型的变量赋值
    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        return profit;
    }

    //>> TODO 参数是定义在方法名字后面的括号里
    //>> TODO 参数定义的规范和变量一样，都是类型名字家标识符，这里的标识符我们叫作参数名
    //>> TODO 方法体中的代码可以使用参数
    //>> TODO 参数的值在调用的时候需要给出，有的资料叫作实参（实际参数）
    //   TODO 对应的，方法定义这里的参数，叫作形参（形式参数）
    //   TODO 如果返回值是负数，就表示购买失败，比如库存不足
    public double buy() {
        return buy(1);
    }

    public double buy(int numToBuy) {
        return buy(count, false);
    }

    public double buy(int numToBuy, boolean isVIP) {
        if (this.count < numToBuy) {
            System.out.println("商品库存不足。");
            return -1;
        }

        this.count -= numToBuy;
        double totalCost = numToBuy * this.soldPrice;
        if (isVIP) {
            //>> TODO 使用自己的使用静态变量的时候，直接写静态变量的名字
            return totalCost * DISCOUNT_FOR_VIP;
        } else {
            return totalCost;
        }
    }

    public String getname() {
        return name;
    }
}

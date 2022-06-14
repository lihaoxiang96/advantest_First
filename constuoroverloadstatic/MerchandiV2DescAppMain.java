package constuoroverloadstatic;

import constuoroverloadstatic.supermarket.MerchandiseV2WithStaticVariable;

import static constuoroverloadstatic.supermarket.MerchandiseV2WithStaticVariable.getVIPDisCount;


public class MerchandiV2DescAppMain {
    public static void main(String[] args) {
        MerchandiseV2WithStaticVariable merchandise = new MerchandiseV2WithStaticVariable("书桌","DESK9765",40,999.9,500);
        merchandise.describe();
        //>> TODO 使用import static来引入一个静态方法，就可以直接用静态变量名访问了
        //   TODO import static也可以使用通配符*来引入一个类里面所有静态变量
        System.out.println(getVIPDisCount());
    }
}

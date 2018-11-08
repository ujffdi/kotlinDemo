package com.tongsr.kotlindemo.ui;

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/11/1
 *     desc   :
 * </pre>
 */
public class UserBean {

    public int age;
    public String name;
    public String phoneNum;
    public Address address;

    @Override
    public String toString() {
        return "UserBean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address=" + address +
                '}';
    }

    public static class Address {

        public String city;
        public String district;
        public String street;

        public Address(String city, String district, String street) {
            this.city = city;
            this.district = district;
            this.street = street;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "city='" + city + '\'' +
                    ", distruct='" + district + '\'' +
                    ", street='" + street + '\'' +
                    '}';
        }
    }
}

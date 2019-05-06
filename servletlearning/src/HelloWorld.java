public class HelloWorld {
    public static void main(String[] args){
//        long val = 26L; //以L结尾的字面值表示long型
//        int decVal = 26; //默认就是int型
//        int hexVal = 0x1a; //16进制
//        int oxVal = 032; //8进制
//        int binVal = 0b11010; //2进制
//        System.out.println(oxVal);

//        char c = 'A';
//        short s = 80;
//
//        public class HelloWorld {
//
//            public void method1(final int j) {
//                j = 5; //这个能否执行？
//            }
//        }

        // ======== 数组
        //声明
        int [] a;
        a = new int[5];
        int[] b = new int[5];
        a[0]= 1;  //下标0，代表数组里的第一个数
        a[1]= 2;
        a[2]= 3;
        a[3]= 4;
        a[4]= 5;
        System.out.println(a.length);
    }
}

public class IntegerArithmeticDemo5 {

  public static void main(String[] args) {
    //        类似的，对整数28进行右移，结果如下：
    int n = 7; // 00000000 00000000 00000000 00000111 = 7
    int a = n >> 1; // 00000000 00000000 00000000 00000011 = 3
    int b = n >> 2; // 00000000 00000000 00000000 00000001 = 1
    int c = n >> 3; // 00000000 00000000 00000000 00000000 = 0
  }
}

public class IntegerArithmeticDemo7 {

  public static void main(String[] args) {
    int n = -536870912;
    int a = n >>> 1; // 01110000 00000000 00000000 00000000 = 1879048192
    int b = n >>> 2; // 00111000 00000000 00000000 00000000 = 939524096
    int c = n >>> 29; // 00000000 00000000 00000000 00000111 = 7
    int d = n >>> 31; // 00000000 00000000 00000000 00000001 = 1
    //        对byte和short类型进行移位时，会首先转换为int再进行位移。
    //        左移实际上就是不断地×2，右移实际上就是不断地÷2。
  }
}

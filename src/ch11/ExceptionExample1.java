package ch11;

// Runtime Exception(실행 예외)  -> UncheckException -> 컴파일러 예외 확인하지 않음.
public class ExceptionExample1 {

   public static int makeException(int input) {
      int divide = 0;
      int result = input/divide;   // java.lang.ArithmeticException: / by zero
      return result;
   }
   
   public static void makeException2() {
      String s= "가";
      System.out.println(s.charAt(1)); //  java.lang.StringIndexOutOfBoundsException: 
   }
   
   public static void makeException3()  {		// throws Exception를 지우면 어떤 에러인지 보이게 됨 
	   // throws Exception 안 지웠을 때 에러
	   //java.lang.Error: Unresolved compilation problem: 
	   //Unhandled exception type Exception
	   // throws Exception 지웠을 때 에러
	   //java.lang.ArrayIndexOutOfBoundsException
      int[] a = { 1, 2, 3};
      System.out.println(a[3]);
   }
   
   public static void makeException4() {		//java.lang.NullPointerException
      String nothing = null;
      System.out.println(nothing.split(""));
   }
   
   public static void makeException5() {		//java.lang.NumberFormatException
      String notInt = "가나다";
      int a = Integer.parseInt(notInt);
   }
   
   public static void makeExcetpion6() {		//java.lang.StackOverflowError
      for(int i = 0; i < Integer.MAX_VALUE; i++) {
         makeExcetpion6();
      }
   }
   
   public static void makeException7() {		//java.lang.ArrayStoreException
      Object[] objArr = new String[3];
      objArr[0] = 0;
   }
   
   public static void makeException8() {		//java.lang.ClassCastException
      Object[] objArr = new String[3];
      objArr[0] = "0";
      Integer a = (Integer) objArr[0];
   }
   
   public static void main(String[] args) {
      // 하나씩 예외 확인해볼 것
//      makeException(10);
//      makeException2();
//      makeException3();		// 이 메서드는 throws 를 사용하여 예외 사항을 호출한 곳으로 넘김
	   							// 이 메서드를 호출한 곳에서 에외 처리를 진행해야 함
	   							// 예외 처리 방법은 (1) try-catch-finally 구문의 사용과, (2) throws 가 있음
//      makeException4();
//      makeException5();
//	    makeExcetpion6();
//      makeException7();
//      makeException8();
      

   }

}

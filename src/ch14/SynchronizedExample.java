package ch14;

public class SynchronizedExample {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }

}

class Calculator {
   // 필드
   private int memory;
   
   // getter
   public int getMemory() {
      return memory;
   }
   
   public void setMemory1(int memory) {
      this.memory = memory;
      try {
         Thread.sleep(2000);
      } catch (InterruptedException e) {}
      System.out.println(Thread.currentThread().getName()+ ": " + this.memory);   
   }
   
   public void setMemory2(int memory) {
      this.memory = memory;
      try {
         Thread.sleep(2000);
      } catch (InterruptedException e) {}
      System.out.println(Thread.currentThread().getName()+ ": " + this.memory);   
   }
}

class User1Thread extends Thread {
   // 필드
   private Calculator calculator;
   
   // 생성자
   public User1Thread() {
      setName("User1Thread");
   }
   
   // setter 메서드
   public void setCalculator(Calculator calculator) {
      this.calculator = calculator;
   }
   
   @Override
   public void run() {
      calculator.setMemory1(100);
   }
   
}

class User2Thread extends Thread {
   // 필드
   private Calculator calculator;
   
   // 생성자
   public User2Thread() {
      setName("User2Thread");
   }
   
   // setter 메서드
   public void setCalculator(Calculator calculator) {
      this.calculator = calculator;
   }
   
   @Override
   public void run() {
      calculator.setMemory2(50);
   }
   
}




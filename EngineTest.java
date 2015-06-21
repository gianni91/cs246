public class EngineTest{
   public static Double salary = 1800.0;

   public static void main(String args[]) {
      EngineTest et = new EngineTest();
      et.run();
   }

   public void run() {
      Engine e = new Engine();
      e.calculateSimulatorVariables();

      System.out.println(e.getEmployeesQuitJob() +
                         " employees quit" );
      System.out.println("the profit changed by " + e.getProfitChange() + "%");
      System.out.println("Unexpected expenses: " + e.getUnexpectedExpenses());
      System.out.println("Unexpected gains: " + e.getUnexpectedGains());

      //      System.out.println("testing 1 2 3 ");

   }
}
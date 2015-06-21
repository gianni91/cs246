import java.util.Random;

public class Engine {

   // Temp var for testing, these should be static?
   public static Double salary = 1950.00;
   public static int numEmployees = 20;


   // Added by Jonny
   public static float ChanceQuitMinPercent = 2; // should be declared here?
   // numEmployees has to be a static int if it is not
   // this can be no more than 50
   public static int maxQuit = numEmployees/2; // should be declared here?
   // These can be changed based on difficulty - stretch
   public static Double desiredSalary = 1920.00;         // Declare this here?
   // should this be a month value or hourly?
   public static Double minAcceptableSalary = 1280.00;

   public static int numCutsSinceRaise = 0;  // TODO - counts how many
   //pay cuts since last raise, can affect the number of employee losses
   // will get this value from the turn history?

   // Salary should be a static variable if it isn't yet? or pass as param?


   private static int randEmployeesQuit;
   private static int randProfitChange; // made this a int percentage
   private static Double randUnexpExp;
   private static Double randUnexpGains;

   public void calculateSimulatorVariables() {

      Random r = new Random();

      // Start with 0 quitters and expenses
      randEmployeesQuit = 0;
      randUnexpExp = 0.0;
      randUnexpGains = 0.0;
      randProfitChange = 0;

      int numQuit = 0; // tracks of the number of people quitting this turn
      int randQuit = 0; // randomly generated number in loop
      float quitChance = 0;

      // No more than half of the employees should quit in one turn
      //    (we can make this variable depending on difficulty - stretch)
      for (int i = 0; i < numEmployees && numQuit < maxQuit; i++) {
         quitChance = 0;

         quitChance += ChanceQuitMinPercent;
         if (salary < desiredSalary) {

            // If you ever set the wage to less than acceptable,
            //     you'll lose half the employees
            // Should this be a sure thing? or should there be firm warning?
            // Currently the warning will be a higher drop in employees based
            //     on a lower salary as calculated in the else
            if (salary < minAcceptableSalary) {
               quitChance = 100;
            }

            else {
               // For every cut in a row before a raise, the employees are 10%
               // more likely to quit
               if (numCutsSinceRaise > 3) {
                  quitChance += 10 * (numCutsSinceRaise - 3);
               }


               quitChance += (100 * (desiredSalary - salary)/
                              (desiredSalary-minAcceptableSalary));
               // This represents the ratio of pay-cut to acceptable-pay-cut
            }
         }

         // 50% quitChance means 1 in 2 chance that the random number is 0
         randQuit = r.nextInt((int)(100/quitChance));
         if(randQuit == 0) {
            numQuit++;
            randEmployeesQuit += 1;
            numEmployees -= 1;    // should this be here or not until after?

            //        randUnexpExp += 1000.00; // TODO - realistic?
            // TODO - Make this change elseware?
         }
      }


      // Produces a random increase or decrease of profit, up to as much as 20%
      if (r.nextInt(2) == 1 )
         randProfitChange += r.nextInt(20);    //TODO, is profit change a %?
      else
         randProfitChange -= r.nextInt(20);

      // up to 4 unexpected expenses of up to $1000 each
      // TODO - can call funny situational explanations
      int numExp = r.nextInt(4);
      for (int i = 0; i < numExp; i++ ) {
         randUnexpExp += r.nextInt(1001);
      }

      // up to 4 unexpected gains of up to $500
      int numGain = r.nextInt(4);
      for (int i = 0; i < numGain; i++) {
         randUnexpGains += r.nextInt(501);
      }

   }

   public static int getEmployeesQuitJob() {
      return randEmployeesQuit;
   }

   public static int getProfitChange() {
      return randProfitChange;
   }

   public static Double getUnexpectedExpenses() {
      return randUnexpExp;
   }

   public static Double getUnexpectedGains() {
      return randUnexpGains;
   }

}
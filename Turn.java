import java.util.List;

public class Turn{

   private int employeeIncrease;
   private Double payrollChange;
   private Double revenueStatus;
   private List<Advertisement> aSold;
   private List<Advertisement> aBought;
   private List<Product> pSold;
   private List<Product> pBought;

   public int getEmployeeIncrease() {
      return employeeIncrease;
   }
   
   public Double getPayrollChange() {
      return payrollChange;
   }

   public Double getRevenueStatus() {
      return revenueStatus;
   }
   
   public List<Advertisement> getASold() {
      return aSold;
   }
   
   public List<Advertisement> getABought() {
      return aBought;
   }
   
   public List<Product> getPSold() {
      return pSold;
   }
   
   public List<Product> getPBought() {
      return pBought;
   }

   

   public void setEmployeeIncrease(int pEmployeeIncrease) {
      employeeIncrease = pEmployeeIncrease;
   }

   public void setPayrollChange(Double pPayrollChange) {
      payrollChange =  pPayrollChange;
   }

   public void setRevenueStatus(Double pRevenueStatus) {
      revenueStatus = pRevenueStatus;
   }

   public void setASold(List<Advertisement> pASold) {
      aSold = pASold;
   }

   public void setABought(List<Advertisement> pABought) {
      aBought = pABought;
   }

   public void setPSold(List<Products> pPSold) {
      pSold = pPSold;
   }

   public void setPBought(List<Products> pPBough) {
      pBought = pPBought;
   }
   
}
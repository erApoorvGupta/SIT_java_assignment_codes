class As_5_part2{
    public static void main(String[] args) {
        employee e1 = new employee(1, "Software Engineer", "IT", "01/01/2020", 10000, 30, 0, 1234567890, "SBI", 1234567890);
        e1.print_slip();
    }
}


abstract class worker{
    // Details Name
    int employee_id;
    String designation;
    String department;
    String DOJ;
    int gross_wage;
    int total_working_days = 30;
    int paid_days;
    int LOP_days;
    int leaves_taken;

    int UAN;
    String bank_name;
    int bank_account_number;

    // Earnings

    float basic_wage;
    float HRA;
    float conveyance_allowance;
    float medical_allowance;
    float other_allowance;
    float total_earningscls;

    // Deductions

    public abstract float getEPF();
    public abstract float getESI();
    public abstract float getProfessionalTax();
    public abstract float getLoanRecovery();


    // Net Salary
    float net_salary;

    public void setPaidDays(int days) {
        this.paid_days = days;
        this.LOP_days = total_working_days - paid_days;
    }

}

// class for regular employee

class employee extends worker{
    // Earnings
    float EPF;
    float ESI;
    float Professional_tax;
    float Loan_recovery;
    float total_deductions;

    float basic_wage;
    float HRA;
    float conveyance_allowance;
    float medical_allowance;
    float other_allowance;
    float total_earnings;

    employee(int employee_id, String designation, String department, String DOJ, int gross_wage, int paid_days, int leaves_taken, int UAN, String bank_name, int bank_account_number){
        this.employee_id = employee_id;
        this.designation = designation;
        this.department = department;
        this.DOJ = DOJ;
        this.gross_wage = gross_wage;
        this.paid_days = paid_days;
        this.leaves_taken = leaves_taken;
        this.UAN = UAN;
        this.bank_name = bank_name;
        this.bank_account_number = bank_account_number;
        this.LOP_days = total_working_days - paid_days;

        this.basic_wage = ((gross_wage/total_working_days) * paid_days);
        this.HRA  = basic_wage * 0.4f;
        this.conveyance_allowance = ((1600/total_working_days)*paid_days);
        this.medical_allowance = ((1250/total_working_days)*paid_days);
        this.other_allowance = ((gross_wage/total_working_days)*paid_days) - (HRA + conveyance_allowance + medical_allowance + basic_wage);
        this.total_earnings = HRA + conveyance_allowance + medical_allowance + basic_wage + other_allowance;
    }

    public float getEPF(){
        if (gross_wage >= 15000){
            return EPF = 12/100f * basic_wage;
        }
        else{
            return EPF = 15/100f * basic_wage;
        }
    }

    public float getESI(){
        if (gross_wage >= 21000){
            return ESI = 0;
        }
        else{
            return ESI = 75/100f * basic_wage;
        }
    }

    public float getProfessionalTax(){
        if (gross_wage >= 15000){
            return Professional_tax = 0;
        }
        else{
            return Professional_tax = 50;
        }
    }

    public float getLoanRecovery(){
        return Loan_recovery = 0;
    }

    void print_slip(){
        // Calculate deductions
        EPF = getEPF();
        ESI = getESI();
        Professional_tax = getProfessionalTax();
        Loan_recovery = getLoanRecovery();
        float total_deductions = EPF + ESI + Professional_tax + Loan_recovery;
        
        // Calculate net salary
        net_salary = total_earnings - total_deductions;
    
        // Print payslip
        System.out.printf("%-20s %-30s\n", "Employee ID:", employee_id);
        System.out.printf("%-20s %-30s\n", "Designation:", designation);
        System.out.printf("%-20s %-30s\n", "Department:", department);
        System.out.printf("%-20s %-30s\n", "Date of Joining:", DOJ);
        System.out.printf("%-20s %-30s\n", "Gross Wage:", gross_wage);
        System.out.printf("%-20s %-30s\n", "Paid Days:", paid_days);
        System.out.printf("%-20s %-30s\n", "Leaves Taken:", leaves_taken);
        System.out.printf("%-20s %-30s\n", "UAN:", UAN);
        System.out.printf("%-20s %-30s\n", "Bank Name:", bank_name);
        System.out.printf("%-20s %-30s\n", "Bank Account Number:", bank_account_number);
        System.out.printf("\n%-20s %-30s\n", "Earnings:", "");
        System.out.printf("%-20s %-30s\n", "Basic Wage:", basic_wage);
        System.out.printf("%-20s %-30s\n", "HRA:", HRA);
        System.out.printf("%-20s %-30s\n", "Conveyance Allowance:", conveyance_allowance);
        System.out.printf("%-20s %-30s\n", "Medical Allowance:", medical_allowance);
        System.out.printf("%-20s %-30s\n", "Other Allowance:", other_allowance);
        System.out.printf("%-20s %-30s\n", "Total Earnings:", total_earnings);
        System.out.printf("\n%-20s %-30s\n", "Deductions:", "");
        System.out.printf("%-20s %-30s\n", "EPF:", EPF);
        System.out.printf("%-20s %-30s\n", "ESI:", ESI);
        System.out.printf("%-20s %-30s\n", "Professional Tax:", Professional_tax);
        System.out.printf("%-20s %-30s\n", "Loan Recovery:", Loan_recovery);
        System.out.printf("%-20s %-30s\n", "Total Deductions:", total_deductions);
        System.out.printf("\n%-20s %-30s\n", "Net Salary:", net_salary);
    }
}   


//     void print_slip(){
//         System.out.printf("%-20s %-30s\n", "Employee ID:", employee_id);
//         System.out.printf("%-20s %-30s\n", "Designation:", designation);
//         System.out.printf("%-20s %-30s\n", "Department:", department);
//         System.out.printf("%-20s %-30s\n", "Date of Joining:", DOJ);
//         System.out.printf("%-20s %-30s\n", "Gross Wage:", gross_wage);
//         System.out.printf("%-20s %-30s\n", "Paid Days:", paid_days);
//         System.out.printf("%-20s %-30s\n", "Leaves Taken:", leaves_taken);
//         System.out.printf("%-20s %-30s\n", "UAN:", UAN);
//         System.out.printf("%-20s %-30s\n", "Bank Name:", bank_name);
//         System.out.printf("%-20s %-30s\n", "Bank Account Number:", bank_account_number);
//         System.out.printf("\n%-20s %-30s\n", "Earnings:", "");
//         System.out.printf("%-20s %-30s\n", "Basic Wage:", basic_wage);
//         System.out.printf("%-20s %-30s\n", "HRA:", HRA);
//         System.out.printf("%-20s %-30s\n", "Conveyance Allowance:", conveyance_allowance);
//         System.out.printf("%-20s %-30s\n", "Medical Allowance:", medical_allowance);
//         System.out.printf("%-20s %-30s\n", "Other Allowance:", other_allowance);
//         System.out.printf("%-20s %-30s\n", "Total Earnings:", total_earnings);
//         System.out.printf("\n%-20s %-30s\n", "Deductions:", "");
//         System.out.printf("%-20s %-30s\n", "EPF:", EPF);
//         System.out.printf("%-20s %-30s\n", "ESI:", ESI);
//         System.out.printf("%-20s %-30s\n", "Professional Tax:", Professional_tax);
//         System.out.printf("%-20s %-30s\n", "Loan Recovery:", Loan_recovery);
//         System.out.printf("%-20s %-30s\n", "Total Deductions:", total_deductions);
//         System.out.printf("\n%-20s %-30s\n", "Net Salary:", net_salary);
//     }
// }

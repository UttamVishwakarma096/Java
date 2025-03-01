package Projects.BankingSystem;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
    
public class Customer extends BankAccount {
    private String name;
    private String Address;
    private String gender;
    private int age;
    private final String PassBook;

    public Customer(String name, int age, String gender) {
        super();
        this.PassBook = name+getAccountNo()+".txt";
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAddress(String Add) {
        this.Address = Add;
    }

    public String getAddress() {
        return Address;
    }

    public void getCustomerInfo() {
        StringBuilder sb = new StringBuilder("Customer Details -> \n\n");
        sb.append("Name = ").append(getName()).append("\n");
        sb.append("Account No. = ").append(getAccountNo()).append("\n");
        sb.append("Age = ").append(getAge()).append("\n");
        sb.append("Gender = ").append(getGender()).append("\n");
        sb.append("Address = ").append(getAddress()).append("\n");
        System.out.println(sb.toString());
    }

    public void Deposit(double Amo) {
        super.deposit(Amo);
        System.out.printf("Creadited Amount : %.2f.\n", Amo);
        try (FileWriter writer = new FileWriter(PassBook, true)) {
            writer.write("Creadited Amount -> "+Amo+"\n");
            writer.write("Balance : "+super.getBalance()+"\n");
            writer.flush();
            writer.close();
        } catch (FileNotFoundException exception) {
            System.out.printf("Exception Occurse %s.\n", exception.getMessage());
        } catch (IOException exception) {
            System.out.printf("Excepton Occurse %s.\n", exception.getMessage());
        }
        System.out.printf("Amount %.2f Deposit Successfully.\n", Amo);
    }

    public void Withdraw(double Amo) {
        if(Amo > getBalance()) {
            System.out.printf("Sorry! Current Balance is %.2f, can't withdraw %.2f.\n", super.getBalance(), Amo);
        } else {
            super.withdraw(Amo);
            System.out.printf("Debited Amount : %.2f\n", Amo);
            try (FileWriter writer = new FileWriter(PassBook, true)) {
                writer.write("Debited Amount -> "+Amo+"\n");
                writer.write("Balance : "+super.getBalance()+"\n");
                writer.flush();
                writer.close();
            } catch (FileNotFoundException exception) {
                System.out.printf("Exception Occurse %s.\n", exception.getMessage());
            } catch (IOException exception) {
                System.out.printf("Exception Occurse %s.\n", exception.getMessage());
            }
            System.out.printf("Amount %.2f Withdraw Successfully.\n", Amo);
        }
    }

    public void getPassBook() {
        try (FileReader reader = new FileReader(PassBook)) {
            int read;
            while((read = reader.read()) != -1) {
                System.out.print((char)read);
            }
            reader.close();
        } catch (IOException exception) {
            System.out.printf("Exception Occurse %s.\n", exception.getMessage());
        }
    }

    public void BalanceCheck() {
        System.out.printf("Current Balance : %.2f\n", super.getBalance());
    }
}
   
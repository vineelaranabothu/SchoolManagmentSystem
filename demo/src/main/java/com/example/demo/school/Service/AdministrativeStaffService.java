package com.example.demo.school.Service;

import java.sql.Time;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.school.Model.AdministrativeStaff;
import com.example.demo.school.Model.PaymentDetails;
import com.example.demo.school.repository.AdministrativeStaffRepository;
import com.example.demo.school.repository.PaymentDetailsRepository;

@Service
public class AdministrativeStaffService {
	
	
	
	private final PaymentDetailsRepository paymentDetailsRepository;
	
	private final AdministrativeStaffRepository administrativeStaffRepository;
	
	public AdministrativeStaffService(PaymentDetailsRepository paymentDetailsRepository ,AdministrativeStaffRepository administrativeStaffRepository) {
		
		this.paymentDetailsRepository = paymentDetailsRepository;
		this.administrativeStaffRepository = administrativeStaffRepository;
		
	}
	
	
	public void login(long empID, Time loginTime) {
        System.out.println("EmployeeID: " + empID + "\nLogin Time: " + loginTime);
    }

    public void logout(long empID, Time logoutTime) {
        System.out.println("EmployeeID: " + empID + "\nLogout Time: " + logoutTime);
    }
    
    public void feeCollection(long empID,int feeCollected) {
		 System.out.println("Student rollno: " + empID+ "Fee collected: " + feeCollected);
	}
    public void payment(PaymentDetails paymentDetails) {
    	paymentDetailsRepository.save(paymentDetails);
    }

    public int register(AdministrativeStaff administrativeStaff) {
		return administrativeStaffRepository.registerAdministrativeStaff(administrativeStaff);
        
    }
	
    
}

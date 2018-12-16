package com.demo.service;
import java.util.List;

import com.demo.entity.Emi;
public interface EmiService {
public void saveEmi(Emi theEmi);
public List<Emi> getEmis();
public float calculateEmi(float loanAmount, float rateofInterest, float tenure, float NoofInstallments);
public void repaymentSchedule(float emi, float loanAmount, float rateofInterest, float tenure, float NoofInstallments);
public Emi getEmi(int theno);


}

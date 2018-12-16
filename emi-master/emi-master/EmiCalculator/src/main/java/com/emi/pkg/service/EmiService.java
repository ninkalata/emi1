package com.emi.pkg.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emi.pkg.domain.Fields;
import com.emi.pkg.domain.Result;
import com.emi.pkg.repository.EmiRepository;

@Service 
public class EmiService implements ServiceInterface
{

	@Autowired
	private EmiRepository emirepo;
	static double emi = 0.0;

	static boolean emiFlag = true;

	List<Fields> List = new ArrayList<>();

	@Override
	public void saveFields(Fields fields)
	{

		double loanAmount = fields.getLoanAmount();
		

		double rateOfInterest = fields.getRateOfInterest();
		double rateOfInPercentage = rateOfInterest / 100;

		int tenure = fields.getTenure();
		int numOfInstalments = fields.getNumberOfInstalments();

		for (int i = 0; i < numOfInstalments; i++)
		{

			loanAmount = calculateEMI(i, loanAmount, rateOfInPercentage, tenure, numOfInstalments);

		}

	}

	public double calculateEMI(int count, double loanAmount, double rateOfInPercentage, int tenure,
			int numOfInstalments)
	{
		Result result = new Result();
		double numerator = loanAmount * (rateOfInPercentage / numOfInstalments);
		double deno1 = 1 + (rateOfInPercentage / numOfInstalments);
		double deno2 = 1 / (Math.pow(deno1, tenure));

		double deominator = 1 - deno2;
		if (emiFlag)
		{
			emi = numerator / deominator;
			emiFlag = false;
		}

		double Pn = emi - numerator;
		double Opn = loanAmount - Pn;
		DecimalFormat formatter = new DecimalFormat("0.00");
		DecimalFormat formatter1 = new DecimalFormat("0");

		Double outprint = Double.parseDouble(formatter.format(loanAmount));
		Double interst = Double.parseDouble(formatter.format(numerator));
		Double principal = Double.parseDouble(formatter.format(Pn));
		result.setCount(count);
		result.setOutsandingPrincipal(outprint);
		result.setInterst(interst);
		result.setPrincipal(principal);
		result.setEmi(EmiService.emi);
		emirepo.save(result);

		System.out.format("%-15s %-15s %-15s %-15s %-15s\n", formatter1.format(count), formatter.format(loanAmount),
				formatter.format(numerator), formatter.format(Pn), formatter.format(emi));

		return Opn;
	}

}

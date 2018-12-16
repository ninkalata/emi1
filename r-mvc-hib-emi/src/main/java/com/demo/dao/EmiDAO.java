package com.demo.dao;

import java.util.List;
import com.demo.entity.Emi;

public interface EmiDAO {
	public void saveEmi(Emi theEmi);

	public List<Emi> getEmis();

	public Emi getEmi(int theno);

	
}

package com.site.beans;

import javax.servlet.http.HttpServletRequest;

public class CompteBancaire {
    int saving;
    String isPositive;

	public void calculateSaving(HttpServletRequest request) {
		int income = Integer.parseInt(request.getParameter("income"));
		int expense = Integer.parseInt(request.getParameter("expense"));		
		
		saving = income - expense;
		if (saving >= 0)
			isPositive = "True";
		else
			isPositive = "False";
	}
	
	public String getIsPositive() {
		return isPositive;
	}

	public void setIsPositive(String isPositive) {
		this.isPositive = isPositive;
	}

	public int getSaving() {
		return saving;
	}
	public void setSaving(int saving) {
		this.saving = saving;
	}	
}

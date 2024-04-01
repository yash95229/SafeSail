package Policies.portlet;

import com.safesail.model.Policy;

import java.util.Comparator;


public class PolicyComparator implements Comparator<Policy> {

	@Override
	public int compare(Policy p1, Policy p2) {
		// TODO Auto-generated method stub
		return (int)(p1.getApplicationNumber()-p2.getApplicationNumber());
	}

}

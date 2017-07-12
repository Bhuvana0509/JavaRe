package com.infy.utillities;

import java.util.Comparator;

import javax.faces.model.SelectItem;


public class Label implements Comparator<Object>{

	public int compare(Object s1, Object s2) {
		SelectItem value1 = (SelectItem) s1;
		SelectItem value2 = (SelectItem) s2;
		
		String  label1 = value1.getValue().toString();
	
        /*if(s1.getValue() != null && s2.getValue() != null){
            return (s1.getValue().toString()).compareTo(s2.getValue().toString());
        }*/

        return 0;
    }


}


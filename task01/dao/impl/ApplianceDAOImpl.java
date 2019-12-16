package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public Appliance find(Criteria criteria) {
		try {
				String str = "resources\\appliances_db.txt";
				FileReader fr = new FileReader(str);
				BufferedReader br = new BufferedReader(fr);
				String s;
				String groupName = criteria.getGroupSearchName();
				List<String> allApplianceGroup = new ArrayList<>();
				while((s = br.readLine())!= null) {
					if(s.contains(groupName)) {
						allApplianceGroup.add(s);
					}	
				}
				fr.close();
							
				Set<String> keys = criteria.getCriteria().keySet();
				List<String> keyForSearch = new ArrayList<>();
				for(String key : keys) {
					Object value =  criteria.getCriteria().get(key);
					//key=value
					String string = key.toString() + "=" + value.toString();
					keyForSearch.add(string);
				}
				
				String searchedAppliance = null;
				for(String appliance : allApplianceGroup) {
					for(String key : keyForSearch) {
						if(appliance.contains(key)) {
							searchedAppliance = appliance;
						}
					}
				}				
		
				Appliance appliance = null;
				if(groupName.equals("Oven")) {
					searchedAppliance = searchedAppliance.replaceAll("[^\\d+(\\.\\d{2})?|\\.\\d{2}]", " ");
					searchedAppliance = searchedAppliance.replaceAll(",", " ");
					searchedAppliance = searchedAppliance.replaceAll(" {2,}", " ");
					String[] string = searchedAppliance.split(" ");
					appliance = new Oven(Integer.parseInt(string[1]), Integer.parseInt(string[2]),
							Integer.parseInt(string[3]), Integer.parseInt(string[4]),
							Double.parseDouble(string[5]), Double.parseDouble(string[6]) );
				}
			
				return appliance;
	

				
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
}


package com.AvionSchool.lms.generic.fileutlity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws IOException {
		String path="./testdata/CommonData.properties";
		FileInputStream fis=new FileInputStream(path);
		Properties pobj=new Properties();
		pobj.load(fis);
		String data = pobj.getProperty(key);
		return data;
	}

}

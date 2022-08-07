package com.reports;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reports {

	public static void generateJVM(String jsonFile) {

		File f = new File(System.getProperty("user.dir") + "\\target");
		Configuration config = new Configuration(f, "APIAutomation");
		config.addClassifications("platform Name", "Windows");
		config.addClassifications("platformVersion", "11");
		config.addClassifications("author", "Jagan");
		config.addClassifications("sprint", "10");
		config.addClassifications("buildNumber", "AD4569852");

		List<String> l = new LinkedList<String>();
		l.add(jsonFile);

		ReportBuilder build = new ReportBuilder(l, config);
		build.generateReports();

	}
}

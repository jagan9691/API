package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reports;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", glue = "com.stepdefnition", snippets = SnippetType.CAMELCASE, dryRun = false)
public class TestRunner {

	/*
	 * @AfterClass public static void afterClass() {
	 * Reports.generateJVM(System.getProperty("user.dir")+"\\target\\\\out.json"); }
	 */
}

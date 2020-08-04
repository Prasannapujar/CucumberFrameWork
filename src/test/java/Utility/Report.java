package Utility;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Report {

    public static void  generateDemoReport() throws IOException {
        File reportOutputDirectory = new File("target/demo");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/firefox1.json");
        jsonFiles.add("target/firefox2.json");

        String buildNumber = "101";
        String projectName = "cucumber Demo";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);

//        configuration.addClassifications("Browser", "Firefox");
//        configuration.addClassifications("Branch", "release/1.0");
//        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
        configuration.setQualifier("sample", "Some Qualifier");
        // points to the demo trends which is not used for other tests
      //  configuration.setTrendsStatsFile(new File("target/test-classes/demo-trends.json"));

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}

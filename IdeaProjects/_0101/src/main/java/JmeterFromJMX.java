import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JmeterFromJMX {
    public void run() throws Exception {
        //JMeter Engine
        StandardJMeterEngine jmeter = new StandardJMeterEngine();

        //Jmeter path
        String Jmeterpath = "src\\main\\resources\\apache-jmeter-3.3";
        JMeterUtils.setJMeterHome(Jmeterpath);
        File jmeterHome = new File(Jmeterpath);

        //JMeter initialization (properties, log levels, locale, etc)
        JMeterUtils.loadJMeterProperties(Jmeterpath + "/bin/jmeter.properties");
        JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
        JMeterUtils.initLocale();

        // Initialize JMeter SaveService
        SaveService.loadProperties();

        // Load existing .jmx Test Plan
        File in = new File(jmeterHome + "/bin/Test1.jmx");
        HashTree testPlanTree = SaveService.loadTree(in);
        //  in.close();

        //Results and Logging
        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }

        // Store execution results into a .jtl file
        String logFile = jmeterHome + "/" + "RESULTS.jtl";

        if (Files.exists(Paths.get(logFile))) {
            Files.delete(Paths.get(logFile));
        }
        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename(logFile);
        testPlanTree.add(testPlanTree.getArray()[0], logger);

        // Run JMeter Test
        jmeter.configure(testPlanTree);
        jmeter.run();
    }

    //checks
    public List checkElapsed () throws IOException {
        String logFile = "src\\main\\resources\\apache-jmeter-3.3\\RESULTS.jtl";
        List<String> results = Files.readAllLines(Paths.get(logFile));
        Integer elapsedMax = 0;
        Integer elapsedSum = 0;
        Integer elapsedAvg = 0;
        Integer i = 0;
        if (results != null) {
            for (String line : results) {
                if (i != 0) {
                    Integer elapsed = Integer.parseInt(line.split(",")[1]);
                    if (elapsedMax < elapsed) {
                        elapsedMax = elapsed;
                    }
                    elapsedSum = elapsedSum + elapsed;
                    i++;
                } else {
                    i++;
                }
            }
        }
        List<Integer> elapsedResult = new ArrayList<>();
        elapsedAvg = elapsedSum / i;
        elapsedResult.add(elapsedAvg);
        elapsedResult.add(elapsedMax);

        return elapsedResult;
    }
}

package br.com.koller.certification.chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {

    private static Logger LOG = Logger.getLogger(Search.class.getName());

    private Search(){}

    public static List<Integer> searchForOccurrences(String source, String expression) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(source);
        LOG.log(Level.INFO, "\nsource: "+source);
        LOG.log(Level.INFO, "\nexpression: "+expression);
        List<Integer> occurrenceIndexes = new ArrayList<>();
        while (matcher.find()) {
            occurrenceIndexes.add(matcher.start());
        }
        LOG.log(Level.INFO, "\nmatch positions: "+occurrenceIndexes.toString());
        return occurrenceIndexes;
    }

    public static List<String> searchForOccurrencesGroups(String source, String expression) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(source);
        LOG.log(Level.INFO, "\nsource: "+source);
        LOG.log(Level.INFO, "\nexpression: "+expression);
        List<String> occurrencesGroups = new ArrayList<String>();
        while (matcher.find()) {
            occurrencesGroups.add(matcher.group());
        }
        LOG.log(Level.INFO, "\nmatch groups: "+occurrencesGroups.toString());
        return occurrencesGroups;
    }
}

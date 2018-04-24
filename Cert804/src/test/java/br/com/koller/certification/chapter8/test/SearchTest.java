package br.com.koller.certification.chapter8.test;

import br.com.koller.certification.chapter8.Search;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void searchForExpressionInStringMustReturnOccurrences() {
        List<Integer> occurrences = Search.searchForOccurrences("abcdeab", "ab");
        assertEquals(2, occurrences.size());
        assertEquals(Integer.valueOf(0), occurrences.get(0));
        assertEquals(Integer.valueOf(5), occurrences.get(1));
    }

    @Test
    public void searchForNonExistentExpressionMustReturnNothing() {
        List<Integer> occurrences = Search.searchForOccurrences("abcdeab", "ef");
        assertTrue(occurrences.isEmpty());
    }

    @Test
    public void searchForNumbersInString() {
        List<Integer> occurrences = Search.searchForOccurrences("a12c3e456f", "\\d");
        assertEquals(6, occurrences.size());
        assertEquals(Integer.valueOf(2), occurrences.get(1));
        assertEquals(Integer.valueOf(8), occurrences.get(occurrences.size()-1));
    }

    @Test
    public void searchForStringRange() {
        List<Integer> occurrences = Search.searchForOccurrences("cafeBABE", "[a-cA-C]");
        assertEquals(5, occurrences.size());
        assertEquals(Integer.valueOf(0), occurrences.get(0));
        assertEquals(Integer.valueOf(4), occurrences.get(2));
    }

    @Test
    public void searchForNumbersMustReturnNumberGroups() {
        List<String> groups = Search.searchForOccurrencesGroups("1 a12 234b", "\\d+");
        assertEquals(3, groups.size());
        assertEquals("1", groups.get(0));
        assertEquals("234", groups.get(2));
    }
}

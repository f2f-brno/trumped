package org.jboss.trumped.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Candidates {
	
	public static Map<String, List<String>> LIST;
	
	static {
		List<String> pages;
		LIST = new HashMap<String, List<String>>();
		
		pages = new ArrayList<String>();
	    pages.add("http://www.nytimes.com/2016/02/10/us/politics/new-hampshire-primary.html");
	    pages.add("http://www.theguardian.com/us-news/2016/feb/09/donald-trump-wins-new-hampshire-republican-primary-us-election-2016");
	    pages.add("http://www.vox.com/2016/2/9/10955378/new-hampshire-primary-results-trump-wins");
	    pages.add("http://edition.cnn.com/2016/02/09/politics/new-hampshire-primary-highlights/");
		LIST.put("Donald Trump", pages);
		
		pages = new ArrayList<String>();
	    pages.add("http://www.nytimes.com/2016/02/10/us/politics/new-hampshire-primary.html");
	    pages.add("http://www.theguardian.com/us-news/2016/feb/09/donald-trump-wins-new-hampshire-republican-primary-us-election-2016");
	    pages.add("http://www.vox.com/2016/2/9/10955378/new-hampshire-primary-results-trump-wins");
	    pages.add("http://edition.cnn.com/2016/02/09/politics/new-hampshire-primary-highlights/");
		LIST.put("John Kasich", pages);
		
		pages = new ArrayList<String>();
		LIST.put("Ted Cruz", pages);
		
		pages = new ArrayList<String>();
		LIST.put("Jeb Bush", pages);
		
		pages = new ArrayList<String>();
		LIST.put("Marco Rubio", pages);
		
		pages = new ArrayList<String>();
		LIST.put("Chris Christie", pages);
		
		pages = new ArrayList<String>();
		LIST.put("Carly Fiorina", pages);
		
		pages = new ArrayList<String>();
		LIST.put("Ben Carson", pages);
		
		pages = new ArrayList<String>();
		LIST.put("Jim Gilmore", pages);
		
		pages = new ArrayList<String>();
		LIST.put("Bernie Sanders", pages);
		
		pages = new ArrayList<String>();
		LIST.put("Hillary Clinton", pages);
		
		pages = new ArrayList<String>();
		LIST.put("Martin O'Malley", pages);
	}
		
}

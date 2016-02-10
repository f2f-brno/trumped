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
	    pages.add("http://www.theguardian.com/us-news/2016/feb/09/donald-trump-wins-new-hampshire-republican-primary-us-election-2016");
		LIST.put("Donald Trump", pages);
		
		pages = new ArrayList<String>();
	    pages.add("http://www.abc.net.au/news/2016-02-10/john-kasich-has-his-moment-in-new-hampshire/7157292");
		LIST.put("John Kasich", pages);
		
		pages = new ArrayList<String>();
	    pages.add("http://www.ibtimes.com/new-hampshire-ted-cruz-gives-victory-speech-even-though-no-one-seems-really-him-2300733");
	    pages.add("http://www.huffingtonpost.com/entry/new-hampshire-ted-cruz_us_56ba9451e4b08ffac12336ed");
		LIST.put("Ted Cruz", pages);
		
		pages = new ArrayList<String>();
	    pages.add("https://www.bostonglobe.com/metro/2016/02/09/bush/O0xJPzJNRXQxHvsos2C3tM/story.html");
		LIST.put("Jeb Bush", pages);
		
		pages = new ArrayList<String>();
	    pages.add("http://www.theguardian.com/us-news/2016/feb/09/marco-rubio-new-hampshire-primary-us-election-2016");
		LIST.put("Marco Rubio", pages);
		
		pages = new ArrayList<String>();
	    pages.add("http://www.theatlantic.com/politics/archive/2016/02/chris-christie-new-hampshire/462096/");
		LIST.put("Chris Christie", pages);
		
		pages = new ArrayList<String>();
	    pages.add("http://time.com/4208526/carly-fiorina-new-hampshire-women/");
		LIST.put("Carly Fiorina", pages);
		
		pages = new ArrayList<String>();
	    pages.add("http://thehill.com/blogs/ballot-box/presidential-races/268858-carson-leaves-for-south-carolina-before-nh-polls-close");
	    pages.add("http://www.cbsnews.com/news/ben-carson-to-skip-new-hampshire-primary-night-event/");
	    pages.add("http://www.breitbart.com/big-government/2016/02/09/ben-carson-will-ditch-his-new-hampshire-primary-party/");
	    pages.add("http://www.vanityfair.com/news/2016/02/ben-carson-new-hampshire");
		LIST.put("Ben Carson", pages);
		
		pages = new ArrayList<String>();
	    pages.add("https://www.romper.com/p/jim-gilmore-didnt-win-new-hampshire-but-he-obviously-had-the-most-fun-5363");
	    pages.add("http://theweek.com/speedreads/604866/jim-gilmore-just-wanted-some-recognition-new-hampshire");
		LIST.put("Jim Gilmore", pages);
		
		pages = new ArrayList<String>();
	    pages.add("http://www.nytimes.com/2016/02/10/us/politics/new-hampshire-primary.html");
	    pages.add("http://www.theguardian.com/us-news/2016/feb/09/donald-trump-wins-new-hampshire-republican-primary-us-election-2016");
	    pages.add("http://www.vox.com/2016/2/9/10955378/new-hampshire-primary-results-trump-wins");
	    pages.add("http://edition.cnn.com/2016/02/09/politics/new-hampshire-primary-highlightsÒ");
		LIST.put("Bernie Sanders", pages);
		
		pages = new ArrayList<String>();
	    pages.add("https://www.romper.com/p/jim-gilmore-didnt-win-new-hampshire-but-he-obviously-had-the-most-fun-5363");
	    pages.add("http://theweek.com/speedreads/604866/jim-gilmore-just-wanted-some-recognition-new-hampshire");
		LIST.put("Hillary Clinton", pages);
		
		pages = new ArrayList<String>();
	    pages.add("http://www.nytimes.com/2016/02/10/us/politics/new-hampshire-primary.html");
	    pages.add("http://www.theguardian.com/us-news/2016/feb/09/donald-trump-wins-new-hampshire-republican-primary-us-election-2016");
	    pages.add("http://www.vox.com/2016/2/9/10955378/new-hampshire-primary-results-trump-wins");
	    pages.add("http://edition.cnn.com/2016/02/09/politics/new-hampshire-primary-highlights/");
		LIST.put("Martin O'Malley", pages);
	}
		
}

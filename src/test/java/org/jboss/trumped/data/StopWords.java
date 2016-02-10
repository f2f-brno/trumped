package org.jboss.trumped.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.util.CharArraySet;

public class StopWords {
	
	public static final CharArraySet SET;
	
	static { 
		try {
			List<String> list = new ArrayList<String>();
			String line;
			try (InputStream fis = new FileInputStream("stop_words.txt");
					InputStreamReader isr = new InputStreamReader(fis);
					BufferedReader br = new BufferedReader(isr);) {
				while ((line = br.readLine()) != null) {
					if (!line.startsWith("#")) {
						list.add(line);
					}
				}
			}
			SET = new CharArraySet(list, true);
		} catch (Exception e) {
			throw new RuntimeException("Problem while initializing Stopwords.LIST");
		}
	}
	
}

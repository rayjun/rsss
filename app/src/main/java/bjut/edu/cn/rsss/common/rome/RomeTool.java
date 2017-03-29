package bjut.edu.cn.rsss.common.rome;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.URL;

/**
 * Created by ray on 2017/3/29.
 */

public class RomeTool {

    public static void main(String[] args) {
        String url = "http://www.ruanyifeng.com/blog/atom.xml";
        try {
            SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
            System.out.println(feed.getEntries());
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

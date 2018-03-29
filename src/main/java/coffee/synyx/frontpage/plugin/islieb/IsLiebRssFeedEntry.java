package coffee.synyx.frontpage.plugin.islieb;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEntry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

class IsLiebRssFeedEntry {

    private final SyndEntry entry;

    IsLiebRssFeedEntry(SyndEntry entry) {
        this.entry = entry;
    }

    String getValue() {
        final List<SyndContent> contents = entry.getContents();
        final String rssFeedContentHtml = contents.get(0).getValue();
        final Document rssFeed = Jsoup.parse(rssFeedContentHtml);

        return rssFeed.select("img").removeAttr("class").attr("style","max-width: 100%").outerHtml();
    }
}

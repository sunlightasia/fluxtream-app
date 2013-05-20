package com.fluxtream.connectors.flickr;

import java.awt.Dimension;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import com.fluxtream.TimeInterval;
import com.fluxtream.connectors.vos.AbstractPhotoFacetVO;
import com.fluxtream.domain.GuestSettings;

public class FlickrPhotoFacetVO extends
		AbstractPhotoFacetVO<FlickrPhotoFacet> {

	public String photoUrl;
    public Map<Integer, String> thumbnailUrls = new HashMap<Integer, String>();
    public SortedMap<Integer, Dimension> thumbnailSizes = new TreeMap<Integer, Dimension>();

    public FlickrPhotoFacetVO()
    {
        timeType="local";
    }

	@Override
	public void fromFacet(FlickrPhotoFacet facet, TimeInterval timeInterval,
			GuestSettings settings) {
        start = facet.datetaken;
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        c.setTimeInMillis(start);
		startMinute = c.get(Calendar.HOUR_OF_DAY)*60+c.get(Calendar.MINUTE);

        int i = 0;
        thumbnailUrls.put(i, String.format("http://farm%s.static.flickr.com/%s/%s_%s_s.jpg", facet.farm, facet.server, facet.flickrId, facet.secret));
        thumbnailSizes.put(i, new Dimension(75, 75));
        i++;
        thumbnailUrls.put(i, String.format("http://farm%s.static.flickr.com/%s/%s_%s_q.jpg", facet.farm, facet.server, facet.flickrId, facet.secret));
        thumbnailSizes.put(i, new Dimension(150, 150));
        i++;

        // hereafter, flickr documentation specifies a number of pixels *on longest side* - since we don't have the
        // original image's dimension, we just specify a square of that number
        thumbnailUrls.put(i, String.format("http://farm%s.static.flickr.com/%s/%s_%s_t.jpg", facet.farm, facet.server, facet.flickrId, facet.secret));
        thumbnailSizes.put(i, new Dimension(100, 100));
        i++;
        thumbnailUrls.put(i, String.format("http://farm%s.static.flickr.com/%s/%s_%s_m.jpg", facet.farm, facet.server, facet.flickrId, facet.secret));
        thumbnailSizes.put(i, new Dimension(240, 240));
        i++;
        thumbnailUrls.put(i, String.format("http://farm%s.static.flickr.com/%s/%s_%s_n.jpg", facet.farm, facet.server, facet.flickrId, facet.secret));
        thumbnailSizes.put(i, new Dimension(320, 320));
        i++;
        thumbnailUrls.put(i, String.format("http://farm%s.static.flickr.com/%s/%s_%s_-.jpg", facet.farm, facet.server, facet.flickrId, facet.secret));
        thumbnailSizes.put(i, new Dimension(500, 500));
        i++;
        thumbnailUrls.put(i, String.format("http://farm%s.static.flickr.com/%s/%s_%s_z.jpg", facet.farm, facet.server, facet.flickrId, facet.secret));
        thumbnailSizes.put(i, new Dimension(640, 640));
        i++;
        thumbnailUrls.put(i, String.format("http://farm%s.static.flickr.com/%s/%s_%s_c.jpg", facet.farm, facet.server, facet.flickrId, facet.secret));
        thumbnailSizes.put(i, new Dimension(800, 800));
        i++;
        thumbnailUrls.put(i, String.format("http://farm%s.static.flickr.com/%s/%s_%s_b.jpg", facet.farm, facet.server, facet.flickrId, facet.secret));
        thumbnailSizes.put(i, new Dimension(1024, 1024));

        this.photoUrl = "http://farm" + facet.farm + ".static.flickr.com/"
                        + facet.server + "/" + facet.flickrId + "_" + facet.secret
                        + "_z.jpg";
		description = facet.title;
	}

    @Override
    public String getPhotoUrl() {
        return photoUrl;
    }

    @Override
	public String getThumbnail(int index) {
		return thumbnailUrls.get(index);
	}

	@Override
	public List<Dimension> getThumbnailSizes() {
		// TODO...
		return null;
	}
}

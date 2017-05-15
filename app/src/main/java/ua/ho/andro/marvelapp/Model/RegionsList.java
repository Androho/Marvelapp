package ua.ho.andro.marvelapp.Model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.net.URL;
import java.util.List;

@Root(name="regions_list")
public class RegionsList {

    @ElementList(name="region", required=false, entry="region", inline=true)
    List<Region> region;

    public List<Region> getRegion() {return this.region;}
    public void setRegion(List<Region> value) {this.region = value;}

    public static class Region {

        @Attribute(name="boundary", required=false)
        String boundary;

        @Attribute(name="wiki", required=false)
        String wiki;

        @Attribute(name="inner_download_prefix", required=false)
        String innerDownloadPrefix;

        @Attribute(name="roads", required=false)
        String roads;

        @Attribute(name="download_suffix", required=false)
        String downloadSuffix;

        @Attribute(name="inner_download_suffix", required=false)
        String innerDownloadSuffix;

        @Attribute(name="type", required=false)
        String type;

        @Attribute(name="translate", required=false)
        String translate;

        @Attribute(name="srtm", required=false)
        String srtm;

        @Attribute(name="join_road_files", required=false)
        String joinRoadFiles;

        @Attribute(name="download_prefix", required=false)
        String downloadPrefix;

        @Attribute(name="road_signs", required=false)
        String roadSigns;

        @Attribute(name="metric", required=false)
        String metric;

        @Attribute(name="poly_extract", required=false)
        String polyExtract;

        @Attribute(name="hillshade", required=false)
        String hillshade;

        @Attribute(name="left_hand_navigation", required=false)
        String leftHandNavigation;

        @Attribute(name="name", required=false)
        String name;

        @ElementList(name="region", required=false, entry="region", inline=true)
        List<Region> region;

        @Attribute(name="lang", required=false)
        String lang;

        @Attribute(name="map", required=false)
        String map;

        @Attribute(name="join_map_files", required=false)
        String joinMapFiles;

        public String getBoundary() {return this.boundary;}
        public void setBoundary(String value) {this.boundary = value;}

        public String getWiki() {return this.wiki;}
        public void setWiki(String value) {this.wiki = value;}

        public String getInnerDownloadPrefix() {return this.innerDownloadPrefix;}
        public void setInnerDownloadPrefix(String value) {this.innerDownloadPrefix = value;}

        public String getRoads() {return this.roads;}
        public void setRoads(String value) {this.roads = value;}

        public String getDownloadSuffix() {return this.downloadSuffix;}
        public void setDownloadSuffix(String value) {this.downloadSuffix = value;}

        public String getInnerDownloadSuffix() {return this.innerDownloadSuffix;}
        public void setInnerDownloadSuffix(String value) {this.innerDownloadSuffix = value;}

        public String getType() {return this.type;}
        public void setType(String value) {this.type = value;}

        public String getTranslate() {return this.translate;}
        public void setTranslate(String value) {this.translate = value;}

        public String getSrtm() {return this.srtm;}
        public void setSrtm(String value) {this.srtm = value;}

        public String getJoinRoadFiles() {return this.joinRoadFiles;}
        public void setJoinRoadFiles(String value) {this.joinRoadFiles = value;}

        public String getDownloadPrefix() {return this.downloadPrefix;}
        public void setDownloadPrefix(String value) {this.downloadPrefix = value;}

        public String getRoadSigns() {return this.roadSigns;}
        public void setRoadSigns(String value) {this.roadSigns = value;}

        public String getMetric() {return this.metric;}
        public void setMetric(String value) {this.metric = value;}

        public String getPolyExtract() {return this.polyExtract;}
        public void setPolyExtract(String value) {this.polyExtract = value;}

        public String getHillshade() {return this.hillshade;}
        public void setHillshade(String value) {this.hillshade = value;}

        public String getLeftHandNavigation() {return this.leftHandNavigation;}
        public void setLeftHandNavigation(String value) {this.leftHandNavigation = value;}

        public String getName() {return this.name;}
        public void setName(String value) {this.name = value;}

        public List<Region> getRegion() {return this.region;}
        public void setRegion(List<Region> value) {this.region = value;}

        public String getLang() {return this.lang;}
        public void setLang(String value) {this.lang = value;}

        public String getMap() {return this.map;}
        public void setMap(String value) {this.map = value;}

        public String getJoinMapFiles() {return this.joinMapFiles;}
        public void setJoinMapFiles(String value) {this.joinMapFiles = value;}

    }

}
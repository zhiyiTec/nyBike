function addBikeWindowInfoContent(obj) {

    bikeWindowInfoContent = "<div class='mapbox-content'>" +
        "<div class='mapbox-content-top'>" +
        "<span class='window_lastUpdate'> 0 ms ago </span> <span class='window_info_button'></span>" +
        "</div>" +
        "<div class='mapbox-content-header'>" +
        "<h1 class='mapbox-content-header-stationName'>" + obj.name + "</h1>" +
        "</div>" +
        "<div class='mapbox-content-detail'>" +
        "<div class='mapbox-content-detail-bikes-available'>" +
        "<span class='mapbox-content-detail-bikes-available-val'> " + obj.nba + " </span>" +
        "<span class='mapbox-content-detail-bikes-available-lbl'>Bikes</span>" +
        "</div>" +
        "<div class='mapbox-content-detail-docks-available'>" +
        "<span class='mapbox-content-detail-docks-available-val'> " + obj.nda + " </span>" +
        " <span	class='mapbox-content-detail-docks-available-lbl'>Docks</span>:" +
        "</div>" +
        "</div>" +
        "<div class='mapbox-content-footer'>" +
        "<span class='mapbox-content-footer-shortName'> Bike station:" + obj.short_name + " </span>" +
        "</div>" +
        "</div>";

    return bikeWindowInfoContent;
}
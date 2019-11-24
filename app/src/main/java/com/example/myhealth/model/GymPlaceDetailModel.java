package com.example.myhealth.model;

import java.util.List;

public class GymPlaceDetailModel {

    /**
     * html_attributions : []
     * result : {"address_components":[{"long_name":"48","short_name":"48","types":["street_number"]},{"long_name":"Pirrama Road","short_name":"Pirrama Rd","types":["route"]},{"long_name":"Sydney","short_name":"Sydney","types":["locality","political"]},{"long_name":"Council of the City of Sydney","short_name":"Sydney","types":["administrative_area_level_2","political"]},{"long_name":"New South Wales","short_name":"NSW","types":["administrative_area_level_1","political"]},{"long_name":"Australia","short_name":"AU","types":["country","political"]},{"long_name":"2009","short_name":"2009","types":["postal_code"]}],"adr_address":"<span class=\"street-address\">48 Pirrama Rd<\/span>, <span class=\"locality\">Sydney<\/span> <span class=\"region\">NSW<\/span> <span class=\"postal-code\">2009<\/span>, <span class=\"country-name\">Australia<\/span>","formatted_address":"48 Pirrama Rd, Sydney NSW 2009, Australia","formatted_phone_number":"(02) 8084 6690","geometry":{"location":{"lat":-33.8666199,"lng":151.1958527},"viewport":{"northeast":{"lat":-33.86555361970849,"lng":151.1970993802915},"southwest":{"lat":-33.86825158029149,"lng":151.1944014197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png","id":"4f89212bf76dde31f092cfc14d7506555d85b5c7","international_phone_number":"+61 2 8084 6690","name":"Google Australia","opening_hours":{"open_now":false,"periods":[{"close":{"day":1,"time":"1730"},"open":{"day":1,"time":"0900"}},{"close":{"day":2,"time":"1730"},"open":{"day":2,"time":"0900"}},{"close":{"day":3,"time":"1730"},"open":{"day":3,"time":"0900"}},{"close":{"day":4,"time":"1730"},"open":{"day":4,"time":"0900"}},{"close":{"day":5,"time":"1700"},"open":{"day":5,"time":"0900"}}],"weekday_text":["Monday: 9:00 AM \u2013 5:30 PM","Tuesday: 9:00 AM \u2013 5:30 PM","Wednesday: 9:00 AM \u2013 5:30 PM","Thursday: 9:00 AM \u2013 5:30 PM","Friday: 9:00 AM \u2013 5:00 PM","Saturday: Closed","Sunday: Closed"]},"photos":[{"height":3024,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/105641698161404211148/photos\">Baptiste Pichon<\/a>"],"photo_reference":"CmRaAAAA0Zv_vx47vBeyonWFTKkzIIFg3XhXGhUf5k7oIgKIzKObr_awQTVh1xnGhaMCbeEGqXuCQJqGrcb0Wrq8wXb2ds0avbHR5pNOERDALIsV1r_zYZbLQwXAJHvstfn9W6btEhBZf3vjN3ZrRz_FPuFJ4XoOGhRDJFWTZ1fNoIYUUhQ9J-MYjecdBQ","width":4032},{"height":4032,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/110549523391810800215/photos\">Lorinda Ferry<\/a>"],"photo_reference":"CmRaAAAAWR3oWmgo1rfKfUThCF8nf4gRN1m1tguLsruIKdlURMLGreuAN6pHqTpMZaYHs9azC3IkrW1kwiidA6ft32Qyx-JG7Cn3-ftyfVIZjscoObdRid0GsMgjFALIkB-TrvBhEhAHmjhZntyk0MG5ohRaUCRSGhTwFMHwX7Jfg9MzZ1kFqDLMu-2QAg","width":3024},{"height":4016,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/107755640736541028674/photos\">Jonah Deller<\/a>"],"photo_reference":"CmRaAAAACwMlcRveTZ8ONJLpw1ImMUpdnEKxHAUEjg8_u6VWP7vazEO7yHaVrVw4sV2hywVvyV6P73c3XL1CHHI5PY7C7FmvJhqisQkWOM7XCxyZh0jADSEUzbzABVhhcqVYy8F-EhCDroVCxifboi9KPCGwP9KDGhRSmp7KfzxvymCZue57PFUGy4xnFw","width":6016},{"height":3264,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/102493344958625549078/photos\">Thomas Li<\/a>"],"photo_reference":"CmRaAAAApK-yevCjaawKf4JrU9o-O2rPUmCfwv8c-yJEJ08ftFIC5oxMPX0WyVJCUfpulkyFJjQEAz1W5JJ4D5YBF2F5gUnkopaJYYr5U6qnSEMPiQg48qk_9DOQJsC68Qaa_sitEhCetQYBA0zOGc0gDasDXqITGhRElAJO-ZFqP_fT-wZLP76AkzZCPg","width":4912},{"height":1365,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/105932078588305868215/photos\">Maksym Kozlenko<\/a>"],"photo_reference":"CmRaAAAAlFU_qn6WWio4mrF5PiYygChgiFUeBC8dz4K-y4YlqBjtqZbEkm4x31rRisPl9NhmVcAj_mNKxUKH9KH8e2Va6H1XTcLfw-yNdlMwjXP83XhVRnLua5D4c1_R5OqJG6qZEhD9tqJlGMK59W_-6yZmZC7_GhRodnnvkyhCmuhrhQv9_-q3HTzbQw","width":2048},{"height":4032,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/112862866592522813509/photos\">Ricky Watson<\/a>"],"photo_reference":"CmRaAAAA2mSjNleSTpPKezIsPdt27ANjHd6np7CEdGxybIa-nCCIKNc-fqrQVs7USZQlH1I-Ji0_MEabHyUSlowY-s1sTQgZJJFTtqUgs-wfwAu8dNOOHS-qjqIT4f0NQvWvD4_6EhCKbkk_SVxNocpLjc9chxGDGhSgHR33JZK_JmPbzR1JKiC8Z2OVlQ","width":3024},{"height":2160,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/116830524696476899564/photos\">Chris Betcher<\/a>"],"photo_reference":"CmRaAAAAdrRaEN-uZ-TTxHa1Dqa3kTYrOj0HXL95nfdnkT_UXTSq5giADRIT0dql0F_7UZW86oxRB0JuMXZGpQAx9ZtHoiUOv1I2SjJYptBMu0LZiOW2ISnDKdoi6h5VAPBiyUdOEhDh16ENPrZbBoQM_DcIyDdRGhTxInxBxRmB2d4-oZKCryhc5847oQ","width":3840},{"height":3840,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/106650315847309124075/photos\">Ben Chien<\/a>"],"photo_reference":"CmRaAAAAs0acJRL__S6Tt-_a4f7nBLLt56OLs3Bxr-m4NLjjJHqyxGaXmiU3jZuluajOzGNkW_EJ-WHmXMTwsB5UtgPr0wUZqTxV3zJzAVjNUzYGYu7YNrfvrR0RlzweTygldQYOEhCCZaNHDUp4vTnXgn_jaRZRGhR54U8_rF-QVi9jMY4LQnbLvQBsXQ","width":2160},{"height":3036,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/110146156524226291200/photos\">Anand Kumar<\/a>"],"photo_reference":"CmRaAAAAQ50qxg0bAAlbHNUqChyPMJtkRm8NtrGIQIkSnjsCOvN2owIdkPiW5KYALaOVjLgmW4OEszoB4W7HpF4-pcRtQ5zxoNAaXsniI80anHu0T1_36tSCzV7eLfw3wXM7yvssEhApB-poerKq37CHifAdO7BlGhQ-P0HiiwfzJaVj4pUEvyUmQ43quw","width":4048},{"height":3024,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/104578111747260232633/photos\">Raymond LAM<\/a>"],"photo_reference":"CmRaAAAAqJlRkPUrFEo-ziK71ufSfQze5zcnzo5wssh3fkcOd2KTcTGRVRvlgUPa6ZHjQb09rIE5CTdQ5L2MRi365uMCzBgi5-WlYIwqfUo7WwgwEMNWqOWwnz55xKKN0KF9JavhEhAW3o1MbkJKz6ixQ1Hynq8gGhTYShLFqR0Gx0U5LOV_sTo0CCS0ug","width":4032}],"place_id":"ChIJN1t_tDeuEmsRUsoyG83frY4","plus_code":{"compound_code":"45MW+98 Pyrmont, New South Wales, Australia","global_code":"4RRH45MW+98"},"rating":4.199999999999999,"reference":"ChIJN1t_tDeuEmsRUsoyG83frY4","reviews":[{"author_name":"Guru s","author_url":"https://www.google.com/maps/contrib/106780570080138238260/reviews","language":"en","profile_photo_url":"https://lh3.ggpht.com/-DTR0hYa08Aw/AAAAAAAAAAI/AAAAAAAAAAA/xlkETZk8IJg/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":5,"relative_time_description":"a month ago","text":"Its been more than 3 years since I got the PR with great guidance & professional work from Dr. Anna. I had approached him this week for getting the passport details update . No questions asked. And the update was done in a most professional way. \n\nIf you want to get your feedback on whether you are eligible for PR , stop anything else you are doing and Dr. Anna is the person you have to speak to.\n\nBe ready to get the honest feedback on your status.","time":1570001987},{"author_name":"Bastian M Goonewardena","author_url":"https://www.google.com/maps/contrib/116469171974372645286/reviews","language":"en","profile_photo_url":"https://lh5.ggpht.com/-zwvTCguP_4E/AAAAAAAAAAI/AAAAAAAAAAA/0pqwNUfNP-g/s128-c0x00000000-cc-rp-mo-ba5/photo.jpg","rating":5,"relative_time_description":"a month ago","text":"It was a honour for me to get in to google Australia office. The staff is extremely helpful very kind. I had high expectations even before entering the office but the architecture and the design of the office itself blew my expectations over the roof. \nOne thing I noticed is that google actually cares about their staff and their well-being.\n\nI was there at a google education conference. The food that they serve was very good, possibly the best ever food I have had in a conference.","time":1568879793},{"author_name":"Mark Titley","author_url":"https://www.google.com/maps/contrib/106973681844973256152/reviews","language":"en","profile_photo_url":"https://lh3.ggpht.com/-0ejT1L4jRSE/AAAAAAAAAAI/AAAAAAAAAAA/8bM9YUgaxzA/s128-c0x00000000-cc-rp-mo-ba6/photo.jpg","rating":5,"relative_time_description":"2 weeks ago","text":"Great office, plenty of facilities and resources. So much respect for what Google does and their mission.","time":1571561285},{"author_name":"Rachel K","author_url":"https://www.google.com/maps/contrib/101659062778675001360/reviews","language":"en","profile_photo_url":"https://lh5.ggpht.com/-Vc4kbOMt4BA/AAAAAAAAAAI/AAAAAAAAAAA/pYI6r6fzRgU/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":1,"relative_time_description":"3 weeks ago","text":"Impossible to get through to an actual person. Also, Google needs to stop removing negative reviews left for businesses by paying customers. People often rely on these reviews to make an informed decision. By removing negative reviews because a business complains really lacks integrity. Some businesses deserve 1 star reviews or less. These reviews should not be so easily removed.","time":1571116439},{"author_name":"Debbie Mitchell","author_url":"https://www.google.com/maps/contrib/105284747324607660073/reviews","language":"en","profile_photo_url":"https://lh3.ggpht.com/-aHfNlsNIIbU/AAAAAAAAAAI/AAAAAAAAAAA/XZa7X6MAU6I/s128-c0x00000000-cc-rp-mo-ba5/photo.jpg","rating":5,"relative_time_description":"2 months ago","text":"I was lucky enough to meet with our fantastic google ads consultant (finally put a face to the name!). Brilliant service, great coffee and beautiful offices","time":1566425560}],"scope":"GOOGLE","types":["point_of_interest","establishment"],"url":"https://maps.google.com/?cid=10281119596374313554","user_ratings_total":819,"utc_offset":660,"vicinity":"48 Pirrama Road, Sydney","website":"https://about.google/locations/?region=asia-pacific&office=sydney"}
     * status : OK
     */

    private ResultBean result;
    private String status;
    private List<?> html_attributions;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<?> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(List<?> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public static class ResultBean {
        /**
         * address_components : [{"long_name":"48","short_name":"48","types":["street_number"]},{"long_name":"Pirrama Road","short_name":"Pirrama Rd","types":["route"]},{"long_name":"Sydney","short_name":"Sydney","types":["locality","political"]},{"long_name":"Council of the City of Sydney","short_name":"Sydney","types":["administrative_area_level_2","political"]},{"long_name":"New South Wales","short_name":"NSW","types":["administrative_area_level_1","political"]},{"long_name":"Australia","short_name":"AU","types":["country","political"]},{"long_name":"2009","short_name":"2009","types":["postal_code"]}]
         * adr_address : <span class="street-address">48 Pirrama Rd</span>, <span class="locality">Sydney</span> <span class="region">NSW</span> <span class="postal-code">2009</span>, <span class="country-name">Australia</span>
         * formatted_address : 48 Pirrama Rd, Sydney NSW 2009, Australia
         * formatted_phone_number : (02) 8084 6690
         * geometry : {"location":{"lat":-33.8666199,"lng":151.1958527},"viewport":{"northeast":{"lat":-33.86555361970849,"lng":151.1970993802915},"southwest":{"lat":-33.86825158029149,"lng":151.1944014197085}}}
         * icon : https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png
         * id : 4f89212bf76dde31f092cfc14d7506555d85b5c7
         * international_phone_number : +61 2 8084 6690
         * name : Google Australia
         * opening_hours : {"open_now":false,"periods":[{"close":{"day":1,"time":"1730"},"open":{"day":1,"time":"0900"}},{"close":{"day":2,"time":"1730"},"open":{"day":2,"time":"0900"}},{"close":{"day":3,"time":"1730"},"open":{"day":3,"time":"0900"}},{"close":{"day":4,"time":"1730"},"open":{"day":4,"time":"0900"}},{"close":{"day":5,"time":"1700"},"open":{"day":5,"time":"0900"}}],"weekday_text":["Monday: 9:00 AM \u2013 5:30 PM","Tuesday: 9:00 AM \u2013 5:30 PM","Wednesday: 9:00 AM \u2013 5:30 PM","Thursday: 9:00 AM \u2013 5:30 PM","Friday: 9:00 AM \u2013 5:00 PM","Saturday: Closed","Sunday: Closed"]}
         * photos : [{"height":3024,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/105641698161404211148/photos\">Baptiste Pichon<\/a>"],"photo_reference":"CmRaAAAA0Zv_vx47vBeyonWFTKkzIIFg3XhXGhUf5k7oIgKIzKObr_awQTVh1xnGhaMCbeEGqXuCQJqGrcb0Wrq8wXb2ds0avbHR5pNOERDALIsV1r_zYZbLQwXAJHvstfn9W6btEhBZf3vjN3ZrRz_FPuFJ4XoOGhRDJFWTZ1fNoIYUUhQ9J-MYjecdBQ","width":4032},{"height":4032,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/110549523391810800215/photos\">Lorinda Ferry<\/a>"],"photo_reference":"CmRaAAAAWR3oWmgo1rfKfUThCF8nf4gRN1m1tguLsruIKdlURMLGreuAN6pHqTpMZaYHs9azC3IkrW1kwiidA6ft32Qyx-JG7Cn3-ftyfVIZjscoObdRid0GsMgjFALIkB-TrvBhEhAHmjhZntyk0MG5ohRaUCRSGhTwFMHwX7Jfg9MzZ1kFqDLMu-2QAg","width":3024},{"height":4016,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/107755640736541028674/photos\">Jonah Deller<\/a>"],"photo_reference":"CmRaAAAACwMlcRveTZ8ONJLpw1ImMUpdnEKxHAUEjg8_u6VWP7vazEO7yHaVrVw4sV2hywVvyV6P73c3XL1CHHI5PY7C7FmvJhqisQkWOM7XCxyZh0jADSEUzbzABVhhcqVYy8F-EhCDroVCxifboi9KPCGwP9KDGhRSmp7KfzxvymCZue57PFUGy4xnFw","width":6016},{"height":3264,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/102493344958625549078/photos\">Thomas Li<\/a>"],"photo_reference":"CmRaAAAApK-yevCjaawKf4JrU9o-O2rPUmCfwv8c-yJEJ08ftFIC5oxMPX0WyVJCUfpulkyFJjQEAz1W5JJ4D5YBF2F5gUnkopaJYYr5U6qnSEMPiQg48qk_9DOQJsC68Qaa_sitEhCetQYBA0zOGc0gDasDXqITGhRElAJO-ZFqP_fT-wZLP76AkzZCPg","width":4912},{"height":1365,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/105932078588305868215/photos\">Maksym Kozlenko<\/a>"],"photo_reference":"CmRaAAAAlFU_qn6WWio4mrF5PiYygChgiFUeBC8dz4K-y4YlqBjtqZbEkm4x31rRisPl9NhmVcAj_mNKxUKH9KH8e2Va6H1XTcLfw-yNdlMwjXP83XhVRnLua5D4c1_R5OqJG6qZEhD9tqJlGMK59W_-6yZmZC7_GhRodnnvkyhCmuhrhQv9_-q3HTzbQw","width":2048},{"height":4032,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/112862866592522813509/photos\">Ricky Watson<\/a>"],"photo_reference":"CmRaAAAA2mSjNleSTpPKezIsPdt27ANjHd6np7CEdGxybIa-nCCIKNc-fqrQVs7USZQlH1I-Ji0_MEabHyUSlowY-s1sTQgZJJFTtqUgs-wfwAu8dNOOHS-qjqIT4f0NQvWvD4_6EhCKbkk_SVxNocpLjc9chxGDGhSgHR33JZK_JmPbzR1JKiC8Z2OVlQ","width":3024},{"height":2160,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/116830524696476899564/photos\">Chris Betcher<\/a>"],"photo_reference":"CmRaAAAAdrRaEN-uZ-TTxHa1Dqa3kTYrOj0HXL95nfdnkT_UXTSq5giADRIT0dql0F_7UZW86oxRB0JuMXZGpQAx9ZtHoiUOv1I2SjJYptBMu0LZiOW2ISnDKdoi6h5VAPBiyUdOEhDh16ENPrZbBoQM_DcIyDdRGhTxInxBxRmB2d4-oZKCryhc5847oQ","width":3840},{"height":3840,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/106650315847309124075/photos\">Ben Chien<\/a>"],"photo_reference":"CmRaAAAAs0acJRL__S6Tt-_a4f7nBLLt56OLs3Bxr-m4NLjjJHqyxGaXmiU3jZuluajOzGNkW_EJ-WHmXMTwsB5UtgPr0wUZqTxV3zJzAVjNUzYGYu7YNrfvrR0RlzweTygldQYOEhCCZaNHDUp4vTnXgn_jaRZRGhR54U8_rF-QVi9jMY4LQnbLvQBsXQ","width":2160},{"height":3036,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/110146156524226291200/photos\">Anand Kumar<\/a>"],"photo_reference":"CmRaAAAAQ50qxg0bAAlbHNUqChyPMJtkRm8NtrGIQIkSnjsCOvN2owIdkPiW5KYALaOVjLgmW4OEszoB4W7HpF4-pcRtQ5zxoNAaXsniI80anHu0T1_36tSCzV7eLfw3wXM7yvssEhApB-poerKq37CHifAdO7BlGhQ-P0HiiwfzJaVj4pUEvyUmQ43quw","width":4048},{"height":3024,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/104578111747260232633/photos\">Raymond LAM<\/a>"],"photo_reference":"CmRaAAAAqJlRkPUrFEo-ziK71ufSfQze5zcnzo5wssh3fkcOd2KTcTGRVRvlgUPa6ZHjQb09rIE5CTdQ5L2MRi365uMCzBgi5-WlYIwqfUo7WwgwEMNWqOWwnz55xKKN0KF9JavhEhAW3o1MbkJKz6ixQ1Hynq8gGhTYShLFqR0Gx0U5LOV_sTo0CCS0ug","width":4032}]
         * place_id : ChIJN1t_tDeuEmsRUsoyG83frY4
         * plus_code : {"compound_code":"45MW+98 Pyrmont, New South Wales, Australia","global_code":"4RRH45MW+98"}
         * rating : 4.199999999999999
         * reference : ChIJN1t_tDeuEmsRUsoyG83frY4
         * reviews : [{"author_name":"Guru s","author_url":"https://www.google.com/maps/contrib/106780570080138238260/reviews","language":"en","profile_photo_url":"https://lh3.ggpht.com/-DTR0hYa08Aw/AAAAAAAAAAI/AAAAAAAAAAA/xlkETZk8IJg/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":5,"relative_time_description":"a month ago","text":"Its been more than 3 years since I got the PR with great guidance & professional work from Dr. Anna. I had approached him this week for getting the passport details update . No questions asked. And the update was done in a most professional way. \n\nIf you want to get your feedback on whether you are eligible for PR , stop anything else you are doing and Dr. Anna is the person you have to speak to.\n\nBe ready to get the honest feedback on your status.","time":1570001987},{"author_name":"Bastian M Goonewardena","author_url":"https://www.google.com/maps/contrib/116469171974372645286/reviews","language":"en","profile_photo_url":"https://lh5.ggpht.com/-zwvTCguP_4E/AAAAAAAAAAI/AAAAAAAAAAA/0pqwNUfNP-g/s128-c0x00000000-cc-rp-mo-ba5/photo.jpg","rating":5,"relative_time_description":"a month ago","text":"It was a honour for me to get in to google Australia office. The staff is extremely helpful very kind. I had high expectations even before entering the office but the architecture and the design of the office itself blew my expectations over the roof. \nOne thing I noticed is that google actually cares about their staff and their well-being.\n\nI was there at a google education conference. The food that they serve was very good, possibly the best ever food I have had in a conference.","time":1568879793},{"author_name":"Mark Titley","author_url":"https://www.google.com/maps/contrib/106973681844973256152/reviews","language":"en","profile_photo_url":"https://lh3.ggpht.com/-0ejT1L4jRSE/AAAAAAAAAAI/AAAAAAAAAAA/8bM9YUgaxzA/s128-c0x00000000-cc-rp-mo-ba6/photo.jpg","rating":5,"relative_time_description":"2 weeks ago","text":"Great office, plenty of facilities and resources. So much respect for what Google does and their mission.","time":1571561285},{"author_name":"Rachel K","author_url":"https://www.google.com/maps/contrib/101659062778675001360/reviews","language":"en","profile_photo_url":"https://lh5.ggpht.com/-Vc4kbOMt4BA/AAAAAAAAAAI/AAAAAAAAAAA/pYI6r6fzRgU/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":1,"relative_time_description":"3 weeks ago","text":"Impossible to get through to an actual person. Also, Google needs to stop removing negative reviews left for businesses by paying customers. People often rely on these reviews to make an informed decision. By removing negative reviews because a business complains really lacks integrity. Some businesses deserve 1 star reviews or less. These reviews should not be so easily removed.","time":1571116439},{"author_name":"Debbie Mitchell","author_url":"https://www.google.com/maps/contrib/105284747324607660073/reviews","language":"en","profile_photo_url":"https://lh3.ggpht.com/-aHfNlsNIIbU/AAAAAAAAAAI/AAAAAAAAAAA/XZa7X6MAU6I/s128-c0x00000000-cc-rp-mo-ba5/photo.jpg","rating":5,"relative_time_description":"2 months ago","text":"I was lucky enough to meet with our fantastic google ads consultant (finally put a face to the name!). Brilliant service, great coffee and beautiful offices","time":1566425560}]
         * scope : GOOGLE
         * types : ["point_of_interest","establishment"]
         * url : https://maps.google.com/?cid=10281119596374313554
         * user_ratings_total : 819
         * utc_offset : 660
         * vicinity : 48 Pirrama Road, Sydney
         * website : https://about.google/locations/?region=asia-pacific&office=sydney
         */

        private String adr_address;
        private String formatted_address;
        private String formatted_phone_number;
        private GeometryBean geometry;
        private String icon;
        private String id;
        private String international_phone_number;
        private String name;
        private OpeningHoursBean opening_hours;
        private String place_id;
        private PlusCodeBean plus_code;
        private Double rating;
        private String reference;
        private String scope;
        private String url;
        private int user_ratings_total;
        private int utc_offset;
        private String vicinity;
        private String website;
        private List<AddressComponentsBean> address_components;
        private List<PhotosBean> photos;
        private List<ReviewsBean> reviews;
        private List<String> types;

        public String getAdr_address() {
            return adr_address;
        }

        public void setAdr_address(String adr_address) {
            this.adr_address = adr_address;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getFormatted_phone_number() {
            return formatted_phone_number;
        }

        public void setFormatted_phone_number(String formatted_phone_number) {
            this.formatted_phone_number = formatted_phone_number;
        }

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getInternational_phone_number() {
            return international_phone_number;
        }

        public void setInternational_phone_number(String international_phone_number) {
            this.international_phone_number = international_phone_number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OpeningHoursBean getOpening_hours() {
            return opening_hours;
        }

        public void setOpening_hours(OpeningHoursBean opening_hours) {
            this.opening_hours = opening_hours;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public PlusCodeBean getPlus_code() {
            return plus_code;
        }

        public void setPlus_code(PlusCodeBean plus_code) {
            this.plus_code = plus_code;
        }

        public Double getRating() {
            return rating;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUser_ratings_total() {
            return user_ratings_total;
        }

        public void setUser_ratings_total(int user_ratings_total) {
            this.user_ratings_total = user_ratings_total;
        }

        public int getUtc_offset() {
            return utc_offset;
        }

        public void setUtc_offset(int utc_offset) {
            this.utc_offset = utc_offset;
        }

        public String getVicinity() {
            return vicinity;
        }

        public void setVicinity(String vicinity) {
            this.vicinity = vicinity;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public List<AddressComponentsBean> getAddress_components() {
            return address_components;
        }

        public void setAddress_components(List<AddressComponentsBean> address_components) {
            this.address_components = address_components;
        }

        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }

        public List<ReviewsBean> getReviews() {
            return reviews;
        }

        public void setReviews(List<ReviewsBean> reviews) {
            this.reviews = reviews;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

        public static class GeometryBean {
            /**
             * location : {"lat":-33.8666199,"lng":151.1958527}
             * viewport : {"northeast":{"lat":-33.86555361970849,"lng":151.1970993802915},"southwest":{"lat":-33.86825158029149,"lng":151.1944014197085}}
             */

            private LocationBean location;
            private ViewportBean viewport;

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public ViewportBean getViewport() {
                return viewport;
            }

            public void setViewport(ViewportBean viewport) {
                this.viewport = viewport;
            }

            public static class LocationBean {
                /**
                 * lat : -33.8666199
                 * lng : 151.1958527
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class ViewportBean {
                /**
                 * northeast : {"lat":-33.86555361970849,"lng":151.1970993802915}
                 * southwest : {"lat":-33.86825158029149,"lng":151.1944014197085}
                 */

                private NortheastBean northeast;
                private SouthwestBean southwest;

                public NortheastBean getNortheast() {
                    return northeast;
                }

                public void setNortheast(NortheastBean northeast) {
                    this.northeast = northeast;
                }

                public SouthwestBean getSouthwest() {
                    return southwest;
                }

                public void setSouthwest(SouthwestBean southwest) {
                    this.southwest = southwest;
                }

                public static class NortheastBean {
                    /**
                     * lat : -33.86555361970849
                     * lng : 151.1970993802915
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }

                public static class SouthwestBean {
                    /**
                     * lat : -33.86825158029149
                     * lng : 151.1944014197085
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }
        }

        public static class OpeningHoursBean {
            /**
             * open_now : false
             * periods : [{"close":{"day":1,"time":"1730"},"open":{"day":1,"time":"0900"}},{"close":{"day":2,"time":"1730"},"open":{"day":2,"time":"0900"}},{"close":{"day":3,"time":"1730"},"open":{"day":3,"time":"0900"}},{"close":{"day":4,"time":"1730"},"open":{"day":4,"time":"0900"}},{"close":{"day":5,"time":"1700"},"open":{"day":5,"time":"0900"}}]
             * weekday_text : ["Monday: 9:00 AM \u2013 5:30 PM","Tuesday: 9:00 AM \u2013 5:30 PM","Wednesday: 9:00 AM \u2013 5:30 PM","Thursday: 9:00 AM \u2013 5:30 PM","Friday: 9:00 AM \u2013 5:00 PM","Saturday: Closed","Sunday: Closed"]
             */

            private boolean open_now;
            private List<PeriodsBean> periods;
            private List<String> weekday_text;

            public boolean isOpen_now() {
                return open_now;
            }

            public void setOpen_now(boolean open_now) {
                this.open_now = open_now;
            }

            public List<PeriodsBean> getPeriods() {
                return periods;
            }

            public void setPeriods(List<PeriodsBean> periods) {
                this.periods = periods;
            }

            public List<String> getWeekday_text() {
                return weekday_text;
            }

            public void setWeekday_text(List<String> weekday_text) {
                this.weekday_text = weekday_text;
            }

            public static class PeriodsBean {
                /**
                 * close : {"day":1,"time":"1730"}
                 * open : {"day":1,"time":"0900"}
                 */

                private CloseBean close;
                private OpenBean open;

                public CloseBean getClose() {
                    return close;
                }

                public void setClose(CloseBean close) {
                    this.close = close;
                }

                public OpenBean getOpen() {
                    return open;
                }

                public void setOpen(OpenBean open) {
                    this.open = open;
                }

                public static class CloseBean {
                    /**
                     * day : 1
                     * time : 1730
                     */

                    private int day;
                    private String time;

                    public int getDay() {
                        return day;
                    }

                    public void setDay(int day) {
                        this.day = day;
                    }

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }

                public static class OpenBean {
                    /**
                     * day : 1
                     * time : 0900
                     */

                    private int day;
                    private String time;

                    public int getDay() {
                        return day;
                    }

                    public void setDay(int day) {
                        this.day = day;
                    }

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }
            }
        }

        public static class PlusCodeBean {
            /**
             * compound_code : 45MW+98 Pyrmont, New South Wales, Australia
             * global_code : 4RRH45MW+98
             */

            private String compound_code;
            private String global_code;

            public String getCompound_code() {
                return compound_code;
            }

            public void setCompound_code(String compound_code) {
                this.compound_code = compound_code;
            }

            public String getGlobal_code() {
                return global_code;
            }

            public void setGlobal_code(String global_code) {
                this.global_code = global_code;
            }
        }

        public static class AddressComponentsBean {
            /**
             * long_name : 48
             * short_name : 48
             * types : ["street_number"]
             */

            private String long_name;
            private String short_name;
            private List<String> types;

            public String getLong_name() {
                return long_name;
            }

            public void setLong_name(String long_name) {
                this.long_name = long_name;
            }

            public String getShort_name() {
                return short_name;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }

            public List<String> getTypes() {
                return types;
            }

            public void setTypes(List<String> types) {
                this.types = types;
            }
        }

        public static class PhotosBean {
            /**
             * height : 3024
             * html_attributions : ["<a href=\"https://maps.google.com/maps/contrib/105641698161404211148/photos\">Baptiste Pichon<\/a>"]
             * photo_reference : CmRaAAAA0Zv_vx47vBeyonWFTKkzIIFg3XhXGhUf5k7oIgKIzKObr_awQTVh1xnGhaMCbeEGqXuCQJqGrcb0Wrq8wXb2ds0avbHR5pNOERDALIsV1r_zYZbLQwXAJHvstfn9W6btEhBZf3vjN3ZrRz_FPuFJ4XoOGhRDJFWTZ1fNoIYUUhQ9J-MYjecdBQ
             * width : 4032
             */

            private int height;
            private String photo_reference;
            private int width;
            private List<String> html_attributions;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getPhoto_reference() {
                return photo_reference;
            }

            public void setPhoto_reference(String photo_reference) {
                this.photo_reference = photo_reference;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<String> getHtml_attributions() {
                return html_attributions;
            }

            public void setHtml_attributions(List<String> html_attributions) {
                this.html_attributions = html_attributions;
            }
        }

        public static class ReviewsBean {
            /**
             * author_name : Guru s
             * author_url : https://www.google.com/maps/contrib/106780570080138238260/reviews
             * language : en
             * profile_photo_url : https://lh3.ggpht.com/-DTR0hYa08Aw/AAAAAAAAAAI/AAAAAAAAAAA/xlkETZk8IJg/s128-c0x00000000-cc-rp-mo/photo.jpg
             * rating : 5
             * relative_time_description : a month ago
             * text : Its been more than 3 years since I got the PR with great guidance & professional work from Dr. Anna. I had approached him this week for getting the passport details update . No questions asked. And the update was done in a most professional way.

             If you want to get your feedback on whether you are eligible for PR , stop anything else you are doing and Dr. Anna is the person you have to speak to.

             Be ready to get the honest feedback on your status.
             * time : 1570001987
             */

            private String author_name;
            private String author_url;
            private String language;
            private String profile_photo_url;
            private Double rating;
            private String relative_time_description;
            private String text;
            private int time;

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getAuthor_url() {
                return author_url;
            }

            public void setAuthor_url(String author_url) {
                this.author_url = author_url;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getProfile_photo_url() {
                return profile_photo_url;
            }

            public void setProfile_photo_url(String profile_photo_url) {
                this.profile_photo_url = profile_photo_url;
            }

            public Double getRating() {
                return rating;
            }

            public void setRating(Double rating) {
                this.rating = rating;
            }

            public String getRelative_time_description() {
                return relative_time_description;
            }

            public void setRelative_time_description(String relative_time_description) {
                this.relative_time_description = relative_time_description;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }
        }
    }
}

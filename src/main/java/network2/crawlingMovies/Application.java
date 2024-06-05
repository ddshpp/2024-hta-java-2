package network2.crawlingMovies;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Application {
    public static void main(String[] args) throws Exception {

        try {
            URL url = new URL(Constant.URL);
            BufferedReader bf = new BufferedReader(
                    new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

            String result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            JSONObject movieInfoResult = (JSONObject) jsonObject.get("movieInfoResult");
            JSONObject movieInfo = (JSONObject) movieInfoResult.get("movieInfo");

            JSONArray nations = (JSONArray) movieInfo.get("nations");
            JSONObject nations_nationNm = (JSONObject) nations.get(0);
            JSONArray genres = (JSONArray) movieInfo.get("genres");

            System.out.println("영화코드 : " + movieInfo.get("movieCd"));
            System.out.println("영화명(한글) : " + movieInfo.get("movieNm"));
            System.out.println("영화명(영문) : " + movieInfo.get("movieNmEn"));
            System.out.println("재생시간 : " + movieInfo.get("showTm"));
            System.out.println("개봉일 : " + movieInfo.get("openDt"));
            System.out.println("영화유형 : " + movieInfo.get("typeNm"));
            System.out.println("제작국가명 : " + nations_nationNm.get("nationNm"));

            StringBuilder genreNm = new StringBuilder();
            for (Object genre : genres) {
                JSONObject genres_genreNm = (JSONObject) genre;
                genreNm.append(genres_genreNm.get("genreNm")).append(" ");
            }
        } catch (Exception e) {
            throw new Exception("예외~!!");
        }
    }
}

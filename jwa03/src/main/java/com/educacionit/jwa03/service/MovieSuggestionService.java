package com.educacionit.jwa03.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.educacionit.jwa03.dto.MovieDTO;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class MovieSuggestionService {
	
	private static final String URLLISTMOVIES = "https://yts.mx/api/v2/list_movies.json?query_term=";
	
	JSONObject jsonObject = new JSONObject();
	JSONArray jsonArray;

	public List<MovieDTO> getMoviesByName(String movieName) {
		
		ArrayList<MovieDTO> movies = new ArrayList<MovieDTO>();
		jsonObject = getMoviesFromWebService(URLLISTMOVIES, movieName);
		if(jsonObject.getInt("movie_count")>0) {
			jsonArray = jsonObject.getJSONArray("movies");
			for(int i=0;i<jsonArray.length();i++) {
				MovieDTO movieDTO = new MovieDTO();
				movieDTO.setId(jsonArray.getJSONObject(i).getInt("id"));
				movieDTO.setName(jsonArray.getJSONObject(i).getString("title"));
				movieDTO.setSummary(jsonArray.getJSONObject(i).getString("synopsis"));
				movieDTO.setCover(jsonArray.getJSONObject(i).getString("medium_cover_image"));
				// utilizar un mapper
				movies.add(movieDTO);
			}
		}
		return movies;
	}
	
	private JSONObject getMoviesFromWebService(String url, String data) {
		OkHttpClient httpClient = new OkHttpClient();
		Request request = new Request.Builder().url(url+data).build();
		Call call= httpClient.newCall(request);
		Response response;
		JSONObject jsonObject = null;
		try {
			response = call.execute();
			jsonObject = new JSONObject(response.body().string());
			if(jsonObject.get("status").equals("ok")) {
				jsonObject = jsonObject.getJSONObject("data");
				
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	
}

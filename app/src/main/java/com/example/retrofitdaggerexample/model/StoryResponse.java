package com.example.retrofitdaggerexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class StoryResponse implements Serializable {
    @SerializedName("articles")
    @Expose
    public List<Story> articles = null;

    public StoryResponse(List<Story> articles) {
        this.articles = articles;
    }

    public List<Story> getArticles() {
        return articles;
    }

    public void setArticles(List<Story> articles) {
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoryResponse storyResponse = (StoryResponse) o;
        return Objects.equals(articles, storyResponse.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articles);
    }

    @Override
    public String toString() {
        return "StoryList{" +
                "articles=" + articles +
                '}';
    }
}

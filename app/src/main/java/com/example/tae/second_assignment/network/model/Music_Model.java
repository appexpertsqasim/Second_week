package com.example.tae.second_assignment.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by TAE on 28/09/2017.
 */

public class Music_Model extends RealmObject{
    @SerializedName("resultCount")
    @Expose
    private Integer resultCount;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}

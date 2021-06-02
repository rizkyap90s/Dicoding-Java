package com.example.asynctask;

public interface MyAsyncCallback {
    void onPreExecute();
    void onPostExecute(String text);
}
